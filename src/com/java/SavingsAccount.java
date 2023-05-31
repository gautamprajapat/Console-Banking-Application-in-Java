package com.java;


public class SavingsAccount extends Account{
    //Added features
    private static double FEE=2.5;

    //default constructor
    public SavingsAccount()
    {
        super();
    }
    public SavingsAccount(int accountNumber, double fee,String name)
    {
        super(accountNumber,name);
        FEE=fee;
        //System.out.println(name);

    }

    @Override
    public void deposit(double amount) {
        if(amount>0)
        {
            balance+=amount;
            System.out.println("Amount deposited "+amount);
            //apply transaction fee;
            balance-=FEE;
            System.out.println("Fee applied "+FEE);
            System.out.println("Current balance is "+ balance);
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
            if((amount+FEE)<=balance)
            {
                System.out.println("Amount withdrawn from account "+amount);
             balance-=amount;
             balance-=FEE;
                System.out.println("Fee applied "+FEE);
                System.out.printf("Current balance is %.2f%n", balance);

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

    }

    @Override
    public void transfer(double transferAmount, int accountNumber) {
        if(transferAmount >0)
        {

                System.out.printf("Amount %.2f transfered to account %d %n", transferAmount,accountNumber);
                balance+= transferAmount;


                System.out.printf("Current balance is: %.2f %n",balance);


        }


    }
////////////////////////////////////////////////////////////////////////////////
    //Implementing Transfer method
    @Override
    public void transfer2(double transferAmount, int recieverAccout, int senderAccount) {

        if(transferAmount >0)
        {

            System.out.printf("Amount %.2f transfered to account %d %n", transferAmount,recieverAccout);
            balance+= transferAmount;


            System.out.printf("Current balance is: %.2f %n",balance);
            System.out.printf("Amount %.2f debited from account %d %n", transferAmount,senderAccount);
            balance-= transferAmount;



        }
    }
}
