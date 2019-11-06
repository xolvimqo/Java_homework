/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Last_
 */
public class ChequingAccount extends Account {
    // instance variables
    private double monthlyFees, overDraftLimit, overDraftFees;
    private boolean overDraftActive;
    
    // constructor
    public ChequingAccount(String fname, String lname, String phoneNumber, double balance, double monthlyFees, double overDraftLimit, boolean overDraftActive, double overDraftFees){
        super(fname, lname, phoneNumber, balance);
        this.monthlyFees = monthlyFees;
        this.overDraftLimit = overDraftLimit;
        this.overDraftActive = overDraftActive;
        this.overDraftFees = overDraftFees;
    }
    
    @Override
    public void withdrawal(double value) {
        if (overDraftActive) {
            if (super.getBalance() >= value) {
                super.withdrawal(value);
            } else if (super.getBalance() + overDraftLimit >= value) {
                overDraftFees -= (value - super.getBalance());
                super.withdrawal(super.getBalance());
            }
            if (Math.abs(overDraftFees) >= overDraftLimit) {
                overDraftActive = false;
            }
        }
    }
    
    @Override
    public void deposit(double value) {
        if (overDraftFees < 0) {
            overDraftFees += value;
            if (overDraftFees >= 0) {
                overDraftActive = true;
                super.deposit(overDraftFees);
                overDraftFees = 0;
            }
        } else {
            super.deposit(value);
        }
    }
    
    public double getOverDraftLimit() {
        return overDraftLimit;
    }
    
    public double getOverDraftFees() {
        return overDraftFees;
    }
    
    // toString is the string representation of the class
    @Override
    public String toString() {
        return ("FirstName:" + getfirstName() + " LastName:" + getlastName() + " Balance:" + getBalance()
                + " Over Draft Limit:" + getOverDraftLimit()
                + " Over Draft Fees:" + getOverDraftFees());
    }
}
