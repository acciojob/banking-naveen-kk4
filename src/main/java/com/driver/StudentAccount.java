package com.driver;




public class StudentAccount extends BankAccount{

    String  institutionName;
    private static double minimumBalance = 0;

    public StudentAccount(String name, double balance, String  institutionName) {
        super(name,balance,minimumBalance);
        this.institutionName=institutionName;


    }

    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
    }

    public static void setMinimumBalance(double minimumBalance) {
        StudentAccount.minimumBalance = minimumBalance;
    }

    public String getInstitutionName() {
        return institutionName;
    }

    public static double getMinimumBalance() {
        return minimumBalance;
    }
}
