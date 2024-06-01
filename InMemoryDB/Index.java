package InMemoryDB;

import java.util.*;

class Index {
    private String field;
    private Map<Object, List<Record>> indexMap = new HashMap<>();

    public Index(String field) {
        this.field = field;
    }

    public void add(Record record) {
        Object key = record.getData().get(field);
        indexMap.computeIfAbsent(key, k -> new ArrayList<>()).add(record);
    }

    public void remove(Record record) {
        Object key = record.getData().get(field);
        List<Record> records = indexMap.get(key);
        if (records != null) {
            records.remove(record);
            if (records.isEmpty()) {
                indexMap.remove(key);
            }
        }
    }

    public List<Record> search(Object value) {
        return indexMap.getOrDefault(value, Collections.emptyList());
    }
}