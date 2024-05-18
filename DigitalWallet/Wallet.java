package DigitalWallet;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Wallet {
    private User user;
    private double balance;
    private final Lock lock = new ReentrantLock();

    public Wallet(User user) {
        this.user = user;
        this.balance = 0.0;
    }

    public User getUser() {
        return user;
    }

    public double getBalance() {
        return balance;
    }

    // Synchronized balance getter for thread-safe access
    public synchronized double getBalanceSynchronized() {
        return balance;
    }

    public void addFunds(double amount) {
        lock.lock();
        try {
            if (amount > 0) {
                this.balance += amount;
                System.out.println("Added " + amount + " to the wallet. New balance: " + balance);
            } else {
                System.out.println("Invalid amount to add.");
            }
        } finally {
            lock.unlock();
        }
    }

    public void withdrawFunds(double amount) {
        lock.lock();
        try {
            if (amount > 0 && amount <= balance) {
                this.balance -= amount;
                System.out.println("Withdrew " + amount + " from the wallet. New balance: " + balance);
            } else {
                System.out.println("Invalid amount to withdraw.");
            }
        } finally {
            lock.unlock();
        }
    }

    // Two-phase commit prepare phase
    public boolean prepareWithdraw(double amount) {
        lock.lock();
        try {
            if (amount > 0 && amount <= balance) {
                return true;
            } else {
                return false;
            }
        } finally {
            lock.unlock();
        }
    }

    // Commit the withdrawal
    public void commitWithdraw(double amount) {
        lock.lock();
        try {
            if (amount > 0 && amount <= balance) {
                this.balance -= amount;
                System.out.println("Committed withdrawal of " + amount + " from the wallet. New balance: " + balance);
            }
        } finally {
            lock.unlock();
        }
    }

    // Rollback the withdrawal (if necessary)
    public void rollbackWithdraw(double amount) {
        lock.lock();
        try {
            System.out.println("Rollback withdrawal of " + amount + " from the wallet.");
            // Rollback by adding the withdrawn amount back to the balance
            this.balance += amount;
        } finally {
            lock.unlock();
        }
    }

    // Two-phase commit prepare phase for adding funds
    public boolean prepareAdd(double amount) {
        lock.lock();
        try {
            if (amount > 0) {
                return true;
            } else {
                return false;
            }
        } finally {
            lock.unlock();
        }
    }

    // Commit the addition of funds
    public void commitAdd(double amount) {
        lock.lock();
        try {
            if (amount > 0) {
                this.balance += amount;
                System.out.println("Committed addition of " + amount + " to the wallet. New balance: " + balance);
            }
        } finally {
            lock.unlock();
        }
    }

    // Rollback the addition (if necessary)
    public void rollbackAdd(double amount) {
        lock.lock();
        try {
            System.out.println("Rollback addition of " + amount + " to the wallet.");
            // No state change needed, as we only prepare without altering state
        } finally {
            lock.unlock();
        }
    }
}