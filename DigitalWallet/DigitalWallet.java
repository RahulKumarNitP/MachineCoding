package DigitalWallet;
/*

Author: Rahul Kumar
 */

// Main class to demonstrate the wallet functionality
public class DigitalWallet {
    public static void main(String[] args) {
        User alice = new User("Alice");
        User bob = new User("Bob");

        Wallet aliceWallet = alice.getWallet();
        Wallet bobWallet = bob.getWallet();

        // Adding initial funds to Alice's wallet
        aliceWallet.addFunds(100.0);

        // Demonstrating transfer using 2-Phase Commit
        boolean success = TransactionManager.transferFunds(aliceWallet, bobWallet, 50.0);
        if (success) {
            System.out.println("Transfer was successful.");
        } else {
            System.out.println("Transfer failed.");
        }

        // Checking balances
        System.out.println("Alice's wallet balance: " + aliceWallet.getBalanceSynchronized());
        System.out.println("Bob's wallet balance: " + bobWallet.getBalanceSynchronized());
    }
}
