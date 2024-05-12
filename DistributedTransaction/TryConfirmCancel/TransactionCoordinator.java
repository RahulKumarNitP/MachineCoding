package TryConfirmCancel;

// Coordinator class to manage the Try Confirm/Cancel pattern
class TransactionCoordinator {
    private Transaction transaction;

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public boolean executeTransaction() {
        if (transaction.tryTransaction()) {
            if (transaction.confirmTransaction()) {
                return true;
            } else {
                transaction.cancelTransaction(); // compensating transaction
                return false;
            }
        } else {
            return false;
        }
    }
}
