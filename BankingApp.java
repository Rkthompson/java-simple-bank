import java.util.Scanner;

/**
 * BankingApp.java is a demo of the local BankAccount class.
 * 
 */

public class BankingApp {

    public static void main(String[] args){

        //declare objects
        BankAccount bankAccountObj = new BankAccount("John Q. Sample", "AB202021");

        //display the menu
        bankAccountObj.openMenu();

    }  //end main

} //end class BankingApp

/**
 * BankAccount is a simple bank account class that tracks balance additions and subtractions.
 * <p>
 * Interactions are handled by the terminal.
 */

class BankAccount {

    //declare variables
    private int balance;
    private int previousTransaction;
    private String customerName;
    private String customerID;

    //object constructors
    //default constructor
    public BankAccount(){
        setBalance(0);
        setPreviousTransaction(0);
        setCustomerName("");
        setCustomerID("");

    } //end default BankAccount constructor

    //constructor

    /**
     * The constructor BankAccount will instantiate an account object to track balance changes.
     * @param nCustomerName Accepts a String of the customer name.
     * @param nCustomerID Accepts a String of the customer id.
     */

    public BankAccount(String nCustomerName, String nCustomerID){
        setBalance(0);
        setPreviousTransaction(0);
        setCustomerName(nCustomerName);
        setCustomerID(nCustomerID);

    } //end BankAccount constructor
    
    //mutators - setters
    /**
     * setBalance accepts an int value for the balance.
     * @param nBalance balance value.
     */

    public void setBalance(int nBalance){
        balance = nBalance;

    } //end setBalance

    private void setPreviousTransaction(int nPreviousTransaction){
        previousTransaction = nPreviousTransaction;
    } //end setPreviousTransaction

    /**
     * setCustomerName accepts a String containing the customer's full name.
     * example - John Q. Sample.
     * @param nCustomerName String containing the full name.
     */

    public void setCustomerName(String nCustomerName){
        customerName = nCustomerName;

    } //end setCustomerName

    /**
     * setCustomerID accepts a String containing the customer ID as an Alpha - Numeric String.
     * @param nCustomerID String for the unique customer ID.
     */

    public void setCustomerID(String nCustomerID){
        customerID = nCustomerID;

    } //end setCustomerID
    
    //accessors - getters

    /**
     * getBalance returns the current balance as an int value.
     * @return The current balance.
     */

    public int getBalance(){
        return balance;

    } //end getBalance

    /**
     * getPreviousTransaction returns an int of the last transaction.
     * @return The last transaction.
     */

    public int getPreviousTransaction(){
        return previousTransaction;
    } //end getPreviousTransaction

    /**
     * getCustomerName returns the customers full name as a String.
     * @return The customers full name.
     */

    public String getCustomerName(){
        return customerName;

    } //end getCustomerName

    /**
     * getCustomerID returns the customer ID as an Alpha Numeric String.
     * @return The customer ID.
     */
    
    public String getCustomerID(){
        return customerID;

    }

    //other functions

    /**
     * deposit accepts an int value to add to the balance total.
     * @param nAmount int value representing amount deposited.
     */

    public void deposit(int nAmount){
        if(nAmount != 0){
            int nBalance = getBalance() + nAmount;
            setBalance(nBalance);
            setPreviousTransaction(nAmount);
            
        }
    
    } //end deposit

    /**
     * withdraw accepts an int value to subtract from the balance.
     * @param nAmount int value representing the amount taken out of the balance.
     */

    public void withdraw(int nAmount){
        if(nAmount !=0){
            int nBalance = getBalance() - nAmount;
            setBalance(nBalance);
            setPreviousTransaction(-nAmount);

        }

    } //end withdraw

    private void displayPreviousTransaction(){
        if(getPreviousTransaction() > 0){
            System.out.println("Depostied " + getPreviousTransaction());

        }
        else if(getPreviousTransaction() < 0){
            System.out.println("Withdrawn: " + Math.abs(getPreviousTransaction()));

        }
        else{
            System.out.println("No transaction occured");

        }

    } //end getPreviousTransaction

    /**
     * openMenu starts a terminal session which displays customer name and id followed by a list of options:
     * A. Check Balance
     * B. Deposit
     * C. Withdraw
     * D. Previous transaction
     * E. Exit
     * <p>
     * All selections print output to the terminal.
     */
    
    public void openMenu(){

        char optionSelect = '\0';  //var to hold the selection made
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome " + getCustomerName());
        System.out.println("Your ID is " + getCustomerID());
        System.out.println("\n");

        do{
            displayMenuList();
            System.out.println("==========================");
            System.out.println("Enter an option");
            System.out.println("==========================");
            optionSelect = Character.toUpperCase(scanner.next().charAt(0));
            System.out.println("\n");

            switch(optionSelect){

                case 'A':
                    System.out.println("--------------------------");
                    System.out.println("Name: " + getCustomerName());
                    System.out.println("Id #: " + getCustomerID());
                    System.out.println("Balance: " + getBalance());
                    System.out.println("--------------------------");
                    System.out.println("\n");
                    break;

                case 'B':
                    System.out.println("--------------------------");
                    System.out.println("Enter an amount to deposit: ");
                    System.out.println("--------------------------");
                    int depositAmt = scanner.nextInt();
                    deposit(depositAmt);
                    System.out.println("\n");
                    break;

                case 'C':
                    System.out.println("--------------------------");
                    System.out.println("Enter an amount to withdraw: ");
                    System.out.println("--------------------------");
                    int withdrawAmt = scanner.nextInt();
                    withdraw(withdrawAmt);
                    System.out.println("\n");
                    break;

                case 'D':
                    System.out.println("--------------------------");
                    System.out.println("Previous transaction: ");
                    displayPreviousTransaction();
                    System.out.println("--------------------------");
                    System.out.println("\n");
                    break;

                case 'E':
                    System.out.println("--------------------------");
        
                    break;

                default:
                    System.out.println("Invalid option. Please enter again");
                    break;

            }

        }while(optionSelect != 'E');

        scanner.close(); //close the open scanner

        System.out.println("Thank you " + getCustomerName() + " for using our services");
        System.out.println("Final balance: " + getBalance());
        System.out.println("--------------------------");
        System.out.println("\n");


    } //end openMenu

    private void displayMenuList(){
        System.out.println("A. Check Balance");
        System.out.println("B. Deposit");
        System.out.println("C. Withdraw");
        System.out.println("D. Previous transaction");
        System.out.println("E. Exit");

    }

} //end class BankAccount