package InMemoryDB;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class InMemoryDB {
    private Map<String, Table> tables = new HashMap<>();

    public void createTable(String tableName, List<String> schema) {
        if (tables.containsKey(tableName)) {
            throw new IllegalArgumentException("Table " + tableName + " already exists.");
        }
        tables.put(tableName, new Table(schema));
    }

    public void dropTable(String tableName) {
        if (!tables.containsKey(tableName)) {
            throw new IllegalArgumentException("Table " + tableName + " does not exist.");
        }
        tables.remove(tableName);
    }

    public Table getTable(String tableName) {
        if (!tables.containsKey(tableName)) {
            throw new IllegalArgumentException("Table " + tableName + " does not exist.");
        }
        return tables.get(tableName);
    }
}
