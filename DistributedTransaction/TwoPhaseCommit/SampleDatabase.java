// Sample database implementation
class SampleDatabase implements Database {
    private List<String> data = new ArrayList<>();

    @Override
    public void prepare() throws Exception {
        System.out.println("Preparing database...");
        // Simulate some preparation work
        Thread.sleep(1000);
        System.out.println("Database prepared.");
    }

    @Override
    public void commit() throws Exception {
        System.out.println("Committing changes to database: " + data);
        // Simulate commit work
        Thread.sleep(1000);
        System.out.println("Changes committed.");
    }

    @Override
    public void rollback() throws Exception {
        System.out.println("Rolling back changes to database");
        // Simulate rollback work
        Thread.sleep(1000);
        System.out.println("Changes rolled back.");
    }

    public void addData(String newData) {
        data.add(newData);
    }
}