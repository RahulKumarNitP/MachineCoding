package InMemoryDB;

import java.util.*;
public class Main {
    public static void main(String[] args) {
        InMemoryDB db = new InMemoryDB();

        // Create a table
        db.createTable("users", Arrays.asList("id", "name", "email"));

        // Get the table
        Table usersTable = db.getTable("users");

        // Insert records
        Map<String, Object> record1 = new HashMap<>();
        record1.put("id", 1);
        record1.put("name", "Alice");
        record1.put("email", "alice@example.com");
        usersTable.insert(new Record(record1));

        Map<String, Object> record2 = new HashMap<>();
        record2.put("id", 2);
        record2.put("name", "Bob");
        record2.put("email", "bob@example.com");
        usersTable.insert(new Record(record2));

        // Create an index on the 'email' field
        usersTable.createIndex("email");

        // Select records
        Map<String, Object> criteria = new HashMap<>();
        criteria.put("name", "Alice");
        List<Record> results = usersTable.select(criteria);
        System.out.println("Select Results: " + results);

        // Search using index
        Index emailIndex = usersTable.indexes.get("email");
        List<Record> indexedResults = emailIndex.search("alice@example.com");
        System.out.println("Indexed Search Results: " + indexedResults);

        // Delete a record
        usersTable.delete(criteria);
        List<Record> resultsAfterDelete = usersTable.select(new HashMap<>());
        System.out.println("Records After Deletion: " + resultsAfterDelete);

        // Drop index
        usersTable.dropIndex("email");

        // Drop table
        db.dropTable("users");
    }
}
