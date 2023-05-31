package com.java;

public class FixedDeposit extends Account {
    private double interestRate;
    public int accountNumber=getAccountNumber();
    public String name=getName();

    public FixedDeposit()
    {
        super();
    }
    public FixedDeposit(int accountNumber, double interestRate,String name)
    {

        super(accountNumber,interestRate,name);

        this.interestRate=interestRate;

    }

    public double getInterestRate() {
        return this.interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }
    public  double calInterest()
    {
        return balance*interestRate;
    }
    public void applyInterest()
    {
        double interest=calInterest();
        System.out.println("Interest amount added to balance "+interest);
        deposit(interest);
    }


    @Override
    public void deposit(double amount) {
        if(amount>0)
        {
            balance+=amount;
            System.out.printf("Amount %.2f deposited%n",amount);


            System.out.printf("Current balance is: %.2f%n",balance);
        }
        else {
            System.out.println("A negative amount can not be deposited");
        }

    }

    @Override
    public void withdraw(double amount) {
        if(amount>0)
        {
            //check sufficient balance
            if((amount)<=balance)
            {
                System.out.printf("Amount %.2f withdrawn from account%n",amount);
                balance-=amount;


                System.out.printf("Current balance is: %n",balance);

            }
        }

    }

    @Override
    public void checkBalance(int accountNumber) {
        System.out.println("Your Balance is: "+balance);
    }

    @Override
    public void transfer(double amount) {

    }

    @Override
    public void transfer() {
        transfer(0.0, 0);
    }

    @Override
    public void transfer(double transferAmount, int accountNumber) {
        if(transferAmount >0)
        {
            //check sufficient balance

                System.out.printf("Amount %.2f transfered to account %n", transferAmount,accountNumber);
                balance-= transferAmount;


                System.out.printf("Current balance is: %n",balance);


        }

    }

    @Override
    public void transfer2(double transferAmount, int recieverAccout, int senderAccount) {

    }
}
