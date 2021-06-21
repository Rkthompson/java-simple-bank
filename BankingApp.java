import java.util.Scanner;

public class BankingApp {

    public static void main(String[] args){

        //declare objects
        BankAccount bankAccountObj = new BankAccount("John Sample", "06202021");

        //display the menu
        bankAccountObj.openMenu();

    }  //end main

} //end class BankingApp

class BankAccount {

    //declare variables
    private int balance;
    private int previousTransaction;
    private String customerName;
    private String customerID;

    //object constructors
    //default constructor
    BankAccount(){
        setBalance(0);
        setPreviousTransaction(0);
        setCustomerName("");
        setCustomerID("");

    } //end default BankAccount constructor

    //constructor
    BankAccount(String nCustomerName, String nCustomerID){
        setBalance(0);
        setPreviousTransaction(0);
        setCustomerName(nCustomerName);
        setCustomerID(nCustomerID);

    } //end BankAccount constructor

    //accessors - getters
    void setBalance(int nBalance){
        balance = nBalance;

    } //end setBalance

    void setPreviousTransaction(int nPreviousTransaction){
        previousTransaction = nPreviousTransaction;
    } //end setPreviousTransaction

    void setCustomerName(String nCustomerName){
        customerName = nCustomerName;

    } //end setCustomerName

    void setCustomerID(String nCustomerID){
        customerID = nCustomerID;

    } //end setCustomerID

    //mutators - setters
    int getBalance(){
        return balance;

    } //end getBalance

    int getPreviousTransaction(){
        return previousTransaction;
    } //end getPreviousTransaction

    String getCustomerName(){
        return customerName;

    } //end getCustomerName

    String getCustomerID(){
        return customerID;

    }

    //other functions
    void deposit(int nAmount){
        if(nAmount != 0){
            int nBalance = getBalance() + nAmount;
            setBalance(nBalance);
            setPreviousTransaction(nAmount);
            
        }
    
    } //end deposit

    void withdraw(int nAmount){
        if(nAmount !=0){
            int nBalance = getBalance() - nAmount;
            setBalance(nBalance);
            setPreviousTransaction(-nAmount);

        }

    } //end withdraw

    void displayPreviousTransaction(){
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

    void openMenu(){

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

    void displayMenuList(){
        System.out.println("A. Check Balance");
        System.out.println("B. Deposit");
        System.out.println("C. Withdraw");
        System.out.println("D. Previous transaction");
        System.out.println("E. Exit");

    }

} //end class BankAccount