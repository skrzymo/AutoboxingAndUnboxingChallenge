package com.skrzymo;

public class Main {

    public static void main(String[] args) {

        Bank bank = new Bank("Narodowy Bank Polski");
        if(bank.addNewBranch("Białystok")) {
            System.out.println("Białystok branch created");
        }

        bank.addCustomer("Białystok", "Rafał", 50.05);
        bank.addCustomer("Białystok", "Ula", 175.34);
        bank.addCustomer("Białystok", "Dariusz", 220.12);

        bank.addNewBranch("Gdańsk");
        bank.addCustomer("Gdańsk", "Grzegorz", 150.54);

        bank.addNewTransaction("Białystok", "Rafał", 44.22);
        bank.addNewTransaction("Białystok", "Rafał", 12.44);
        bank.addNewTransaction("Białystok", "Ula", 1.65);

        bank.showCustomers("Białystok", true);
        bank.showCustomers("Gdańsk", true);

        bank.addNewBranch("Toruń");
        if(!bank.addCustomer("Toruń", "Tomasz", 5.53)) {
            System.out.println("ERROR Toruń branch does not exist");
        }

        if(!bank.addNewBranch("Białystok")) {
            System.out.println("Białystok branch already exists");
        }

        if(!bank.addNewTransaction("Białystok", "Bożena", 143.33)) {
            System.out.println("Customer does not exist at branch");
        }

        if(!bank.addCustomer("Białystok", "Rafał", 12.21)) {
            System.out.println("Customer Rafał already exists");
        }
    }
}
