package TryConfirmCancel;

// Interface for transaction operations
interface Transaction {
    boolean tryTransaction();
    boolean confirmTransaction();
    boolean cancelTransaction();
}