package com.driver;


import java.util.Collections;

public class BankAccount {

    private String name;
    private double balance;
    private double minBalance;

    public BankAccount(String name, double balance, double minBalance) {
        this.name = name;
        this.balance = balance;
        this.minBalance = minBalance;

    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public double getMinBalance() {
        return minBalance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setMinBalance(double minBalance) {
        this.minBalance = minBalance;
    }

    public String generateAccountNumber(int digits, int sum) throws Exception{
       if( sum > digits*9 || sum<0)throw new Exception("Account Number can not be generated");
       int rem = sum;
       StringBuilder ans = new StringBuilder();
       for(int i = 0;i<digits;i++){
           int val = Math.min(9,rem);
           ans.append(val);
           rem-=val;
       }
       return ans.toString();

    }

    public void deposit(double amount) {
        this.balance+=amount;

    }

    public void withdraw(double amount) throws Exception {
        if(this.balance-amount < this.minBalance)throw new Exception("Insufficient Balance");
        this.balance-=amount;


    }

}