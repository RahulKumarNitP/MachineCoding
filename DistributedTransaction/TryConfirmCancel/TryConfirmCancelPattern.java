package TryConfirmCancel;

public class TryConfirmCancelPattern {
    public static void main(String[] args) {
        // Initialize sample data
        SampleTransaction.accountBalances.put("Alice", 100);
        SampleTransaction.accountBalances.put("Bob", 200);

        // Create a transaction
        Transaction transaction = new SampleTransaction("Alice", 50);

        // Create a coordinator and set the transaction
        TransactionCoordinator coordinator = new TransactionCoordinator();
        coordinator.setTransaction(transaction);

        // Execute the transaction
        if (coordinator.executeTransaction()) {
            System.out.println("Transaction executed successfully");
        } else {
            System.out.println("Transaction failed");
        }
    }
}
