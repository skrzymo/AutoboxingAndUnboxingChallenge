package com.skrzymo;

import java.util.ArrayList;

public class Bank {

    private String bankName;
    private ArrayList<Branch> branches;

    public Bank(String bankName) {
        this.bankName = bankName;
        this.branches = new ArrayList<Branch>();
    }

    public boolean addNewBranch(String branchName) {
        if(findBranch(branchName) == null) {
            this.branches.add(new Branch(branchName));
            return true;
        }

        return false;
    }

    public boolean addCustomer(String branchName, String customerName, double initialAmount) {
        Branch branch = findBranch(branchName);
        if(branch != null) {
            return branch.addCustomer(customerName,initialAmount);
        }

        return false;
    }

    public boolean addNewTransaction(String branchName, String customerName, double amount) {
        Branch branch = findBranch(branchName);
        if(branch != null) {
            return branch.addTransaction(customerName,amount);
        }

        return false;
    }

    private Branch findBranch(String branchName) {
        for(int i=0; i<this.branches.size(); i++) {
            Branch branch = this.branches.get(i);
            if(branch.getBranchName().equals(branchName)) {
                return branch;
            }
        }

        return null;
    }

    public boolean showCustomers(String branchName, boolean showTransactions) {
        Branch branch = findBranch(branchName);
        if(branch != null) {
            System.out.println("Customers details for branch " + branch.getBranchName());
            ArrayList<Customer> branchCustomers = branch.getCustomers();
            for(int i=0; i<branchCustomers.size(); i++) {
                Customer customer = branchCustomers.get(i);
                System.out.println("Customer: " + customer.getCustomerName());
                if(showTransactions) {
                    System.out.println("Transactions:");
                    ArrayList<Double> customerTransactions = customer.getTransactions();
                    for(int j=0; j<customerTransactions.size(); j++) {
                        System.out.println("[" + (j+1) + "] Amount " + customerTransactions.get(j));
                    }
                }
            }
            return true;
        }

        return false;
    }



}
