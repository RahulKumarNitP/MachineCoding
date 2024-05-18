package DigitalWallet;

import java.util.UUID;

class User {
    private String id;
    private String name;
    private Wallet wallet;

    public User(String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.wallet = new Wallet(this);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Wallet getWallet() {
        return wallet;
    }
}