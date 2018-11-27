package com.skrzymo;

import java.util.ArrayList;

public class Branch {

    private String branchName;
    private ArrayList<Customer> customers;

    public Branch(String branchName) {
        this.branchName = branchName;
        this.customers = new ArrayList<Customer>();
    }

    public String getBranchName() {
        return branchName;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public boolean addCustomer(String name, double initialAmount) {
        if(findCustomer(name) == null) {
            this.customers.add(new Customer(name, initialAmount));
            return true;
        }

        return false;
    }

    public boolean addTransaction(String customerName, double amount) {
        Customer customer = findCustomer(customerName);
        if(customer != null) {
            customer.addTransaction(amount);
            return true;
        }

        return false;
    }

    private Customer findCustomer(String name) {
        for(int i=0; i<this.customers.size(); i++) {
            Customer checkedCustomer = this.customers.get(i);
            if(checkedCustomer.getCustomerName().equals(name)) {
                return checkedCustomer;
            }
        }
        return null;
    }


}
