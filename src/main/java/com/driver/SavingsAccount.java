package com.driver;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter


public class SavingsAccount extends BankAccount{
    double rate;
    double maxWithdrawalLimit;
    private static double minimumBalance = 0;

    public SavingsAccount(String name, double balance, double maxWithdrawalLimit, double rate) {
       super(name, balance, minimumBalance);
       this.rate = rate;
       this.maxWithdrawalLimit = maxWithdrawalLimit;

    }
    public void withdraw(double amount) throws Exception {
        if(amount>maxWithdrawalLimit)throw new Exception("Maximum Withdraw Limit Exceed");
        if(super.getBalance()-amount < minimumBalance) throw new Exception("Insufficient Balance");
        super.setBalance(super.getBalance()-amount);


    }

    public double getSimpleInterest(int years){
        return (double)years*rate*super.getBalance();

    }

    public double getCompoundInterest(int times, int years){
       double a = (this.rate/times) + 1;
       double b = Math.pow(a,years);
       return (double)super.getBalance()*b;


    }

}
