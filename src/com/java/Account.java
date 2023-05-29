package com.java;
//Base class abstract

public abstract class Account {
    private int accountNumber;
    private String  name;
    protected double balance;
    public double interestRate;

    //default constructor
    public Account()
    {

    }
    //parameterized constructor
    public Account(int accountNumber,String name)
    {
        this.accountNumber=accountNumber;
        this.name=name;
        balance=0;

    }
    public Account(int accountNumber,double interestRate ,String name)
    {
        this.accountNumber=accountNumber;
        this.name=name;
        this.interestRate=interestRate;
        balance=0;

    }
    //Getter methods


    public double getBalance() {
        return this.balance;
    }

    public int getAccountNumber() {
        return this.accountNumber;

    }
    public String getName(){
        return  this.name;
    }

    //method to deposit fund in account
    // amount >0
    public abstract void  deposit(double amount);
    //method to withdraw fund from account
    // amount>0 and withdraw<=balance
    public abstract void withdraw(double amount);

    public abstract  void transfer(double amount);

    public abstract void transfer();

    public abstract void transfer(double transferAmount, int accountNumber);
}
