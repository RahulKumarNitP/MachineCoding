package DigitalWallet;

class TransactionManager {
    public static boolean transferFunds(Wallet sourceWallet, Wallet targetWallet, double amount) {
        // Phase 1: Prepare
        boolean sourcePrepared = sourceWallet.prepareWithdraw(amount);
        boolean targetPrepared = targetWallet.prepareAdd(amount);

        if (!sourcePrepared || !targetPrepared) {
            // If either wallet cannot prepare, rollback and abort the transaction
            if (sourcePrepared) sourceWallet.rollbackWithdraw(amount);
            if (targetPrepared) targetWallet.rollbackAdd(amount);
            System.out.println("Transaction failed during prepare phase. Rolled back.");
            return false;
        }

        // Phase 2: Commit
        sourceWallet.commitWithdraw(amount);
        targetWallet.commitAdd(amount);
        System.out.println("Transaction committed successfully.");
        return true;
    }
}