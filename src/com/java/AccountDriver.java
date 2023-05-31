package com.java;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AccountDriver {
    //entry point of program
    //static String name;
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        //Create array of accounts
        Account account[]=new Account[10];
        int numAccount=0;
        int choice;
        do{
            choice=menu(sc);
            System.out.println();
            if(choice==1)
            {
                account[numAccount++]=createAccount(sc);
            } else if (choice==2) {
//                AccountDriver obj=new AccountDriver();
//
//                obj.doDeposit(account,numAccount,sc);
               doDeposit(account,numAccount,sc);


            } else if (choice==3) {
                doWithdraw(account,numAccount,sc);

            }
            else if (choice==4) {
                doCheckBalance(account,numAccount,sc);

            }
            else if (choice==5) {
                doTransfer(account,numAccount,sc);

            }
            else if (choice==6) {
                doApplyInterest(account,numAccount,sc);

            }
        }while(choice!=7);

    }
    public static int accountMenu(Scanner sc)
    {
        System.out.println("Select account type");
        System.out.println("1. Savings Account");
        System.out.println("2. Fixed Deposit");
        int choice;
        do{
            System.out.println("Enter choice:");
            choice=sc.nextInt();

        }while(choice<1||choice>2);
        return choice;
    }



    public static  int searchAccount(Account account[],int count,int accountNumber)
    {
        for(int i=0;i<count;i++)
        {
            if(account[i].getAccountNumber()==accountNumber)
            {
                return i;
            }
        }
        return -1;
    }
    //method to perform deposit on a selected account
    public static void doDeposit(Account account[],int count,Scanner sc)
    {
        //Get the account Number
        int accountNumber=0;
        System.out.println("Enter account Number:");
        try{
             accountNumber=sc.nextInt();
        }
        catch(Exception e)
        {
            e.toString();
        }


        // search for account
        int index=searchAccount(account,count,accountNumber);
        if(index>=0)
        {
            //Amount
            System.out.println("Please Enter deposit amount");
            double amount=sc.nextDouble();
            account[index].deposit(amount);

        }
        else{
            System.out.println("No account exist whith account number:"+accountNumber);
        }
    }
    public static void doWithdraw(Account account[],int count,Scanner sc)
    {
        //Get the account Number
        System.out.println("Please Enter account number");
        int accountNumber=sc.nextInt();

        // search for account
        int index=searchAccount(account,count,accountNumber);
        if(index>=0)
        {
            //Amount
            System.out.println("Please Enter withdrwa amount");
            double amount=sc.nextDouble();
            account[index].withdraw(amount);

        }
        else{
            System.out.println("No account exist whith account number:"+accountNumber);
        }
    }
    //// Applying Interest on Fixed Deposit
    public static void doApplyInterest(Account account[],int count,Scanner sc)
    {
        //Get the account Number
        System.out.println("Please Enter account number");
        int accountNumber=sc.nextInt();

        // search for account
        int index=searchAccount(account,count,accountNumber);
        if(index>=0)
        {
            if(account[index] instanceof FixedDeposit)
            {
                ((FixedDeposit) account[index]).applyInterest();

            }


        }
        else{
            System.out.println("No account exist whith account number:"+accountNumber);
        }
    }


    //////// Check Balance
    public static void doCheckBalance(Account account[],int count,Scanner sc)
    {
        //Get the account Number
        System.out.println("Please Enter account number");
        int accountNumber=sc.nextInt();

        // search for account
        int index=searchAccount(account,count,accountNumber);
        if(index>=0)
        {
            //Amount

            account[index].checkBalance(accountNumber);

        }
        else{
            System.out.println("No account exist whith account number:"+accountNumber);
        }
    }
    ////////////////////////////////////////////////////////////////////
    // Transfer
    public static void doTransfer(Account account[],int count,Scanner sc)
    {
        //Get the account Number
        System.out.println("Enter account Number:");
        int accountNumber=sc.nextInt();

        // search for account
        int index=searchAccount(account,count,accountNumber);
        if(index>=0)
        {
            //Amount
            System.out.println("Please Enter Transfer Amount amount");
            double amount=sc.nextDouble();
            account[index].transfer(amount,accountNumber);

        }
        else{
            System.out.println("No account exist whith account number:"+accountNumber);
        }
    }
    public  static Account createAccount(Scanner sc)
    {
        Account account=null;
        int choice=accountMenu(sc);

        int accountNumber = 0;
        String name = " ";

    System.out.println("Enter account Number");
    accountNumber = sc.nextInt();


    if (choice == 1) {
        //Saving Account
        System.out.println("Enter transaction fee");
        double fee = sc.nextDouble();
        System.out.println("Enter account_holder Name:");
        name = sc.next();
        System.out.println("Account Created with user name " + name);
        System.out.printf("Account Number is %d %n", accountNumber);
        account = new SavingsAccount(accountNumber, fee, name);


    } else {
        //Fixed account
        System.out.println("Please enter interest rate:");
        double ir = sc.nextDouble();
        account = new FixedDeposit(accountNumber, ir, name);
    }

        return account;
    }

    //Menu to display the option and get user's selection
    public  static int menu(Scanner sc)
    {
        System.out.println("Bank Account Menu");
        System.out.println("1.Create new Account");
        System.out.println("2.Deposit fund");
        System.out.println("3.Withdraw funds");
        System.out.println("4.Check Balance");
        System.out.println("5.Transfer Amount");
        System.out.println("6.Show Fixed Deposit Amount");
        System.out.println("7. Quit");
        int choice;
        do{
            System.out.println("Enter choice");
            choice=sc.nextInt();
        }while(choice<1 || choice>6);
        return choice;

    }


}
