package InMemoryDB;

import java.util.*;

class Table {
    private List<String> schema;
    private List<Record> records = new ArrayList<>();
    Map<String, Index> indexes = new HashMap<>();

    public Table(List<String> schema) {
        this.schema = new ArrayList<>(schema);
    }

    public void insert(Record record) {
        if (!record.getData().keySet().equals(new HashSet<>(schema))) {
            throw new IllegalArgumentException("Record schema does not match table schema.");
        }
        records.add(record);
        for (Map.Entry<String, Index> entry : indexes.entrySet()) {
            entry.getValue().add(record);
        }
    }

    public List<Record> select(Map<String, Object> criteria) {
        List<Record> results = new ArrayList<>();
        for (Record record : records) {
            boolean match = true;
            for (Map.Entry<String, Object> entry : criteria.entrySet()) {
                if (!entry.getValue().equals(record.getData().get(entry.getKey()))) {
                    match = false;
                    break;
                }
            }
            if (match) {
                results.add(record);
            }
        }
        return results;
    }

    public void delete(Map<String, Object> criteria) {
        List<Record> recordsToDelete = select(criteria);
        records.removeAll(recordsToDelete);
        for (Record record : recordsToDelete) {
            for (Map.Entry<String, Index> entry : indexes.entrySet()) {
                entry.getValue().remove(record);
            }
        }
    }

    public void createIndex(String field) {
        if (!schema.contains(field)) {
            throw new IllegalArgumentException("Field " + field + " does not exist in schema.");
        }
        if (indexes.containsKey(field)) {
            throw new IllegalArgumentException("Index on " + field + " already exists.");
        }
        Index index = new Index(field);
        for (Record record : records) {
            index.add(record);
        }
        indexes.put(field, index);
    }

    public void dropIndex(String field) {
        if (!indexes.containsKey(field)) {
            throw new IllegalArgumentException("Index on " + field + " does not exist.");
        }
        indexes.remove(field);
    }
}
