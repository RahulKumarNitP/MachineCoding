package TryConfirmCancel;

import java.util.HashMap;
import java.util.Map;

// Sample implementation of Transaction interface
class SampleTransaction implements Transaction {
    public static final Map<String, Integer> accountBalances = new HashMap<>();
    private String accountId;
    private int amount;

    public SampleTransaction(String accountId, int amount) {
        this.accountId = accountId;
        this.amount = amount;
    }

    @Override
    public boolean tryTransaction() {
        System.out.println("Trying transaction...");
        if (accountBalances.containsKey(accountId) && accountBalances.get(accountId) >= amount) {
            System.out.println("Transaction try succeeded");
            return true;
        } else {
            System.out.println("Insufficient balance for transaction try");
            return false;
        }
    }

    @Override
    public boolean confirmTransaction() {
        System.out.println("Confirming transaction...");

        accountBalances.put(accountId, accountBalances.getOrDefault(accountId, 0) - amount);

        System.out.println("Transaction confirmed");
        return true;
    }

    @Override
    public boolean cancelTransaction() {
        System.out.println("Cancelling transaction...");
        // Implement logic to revert any changes made in tryTransaction
        System.out.println("Transaction cancelled");
        return true;
    }
}
