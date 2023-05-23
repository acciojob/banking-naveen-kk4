package com.driver;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter


public class StudentAccount extends BankAccount{

    String  institutionName;
    private static double minimumBalance = 0;

    public StudentAccount(String name, double balance, String  institutionName) {
        super(name,balance,minimumBalance);
        this.institutionName=institutionName;


    }

}
