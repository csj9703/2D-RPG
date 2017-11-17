/**
 * Class that holds a BankAccount which has a balance and an account number.
 * You can deposit money into the account, withdraw money from the account and
 * transfer money to another account.
 * @author Team 6 - CPSC 233 - Tutorial T02
 * @version 1.0
 * @since November 16, 2017
 */
public class BankAccount 
{
    private double balance = 0.0;
    private int accountNumber = 1;
    private static int accountCounter = 0;
    /*
     * This is the default constructor
     */
	public BankAccount() 
	{
		accountCounter += 1;
		accountNumber = accountCounter;
	}
	/*
     * This constructor accepts a start balance as argument
     * @param startBalance The starting balance
     */
	public BankAccount(double startBalance) 
	{
		balance = startBalance;
		accountCounter += 1;
		accountNumber = accountCounter;
	}
    /*
     * This is the copy constructor
     */
	public BankAccount(BankAccount accountToCopy) 
	{
		balance = accountToCopy.balance;
		accountNumber = accountToCopy.accountNumber;
	}
    /** 
     * This accessor methods returns the current balance in this account.
     * @return the current balance of the account.
     */
    public double getBalance() // author: Nathaly Verwaal
    {
        return balance;
    }
    /**
     * This accessor method returns the account number of this account.
     * @return the account number of the account.
     */
    public int getAccountNumber() // author: Nathaly Verwaal
    {
        return accountNumber;
    }
    /**
     * This mutator method withdraws the specified amount if sufficient funds 
     * exist in this account.  The amount is required to be a positive amount.
     * @param amount the amount to withdraw from the account.
     */
    public void withdraw(double amount) // author: Nathaly Verwaal
    {
        if (amount <= balance  && amount > 0) 
        {
            balance -= amount;
        }
    }
    /**
     * This mutator method deposits the specified amount, which is required
     * to be positive.
     * @param amount the amount to deposit into the account.
     */
    public void deposit(double amount) // author: Nathaly Verwaal
    {
        if (amount > 0) 
        {
            balance += amount;
        }
    }
    /**
     * This mutator method transfers the specified amount from this account
     * to the specified account if there is sufficient funds in this account.
     * The amount is required to be positive.
     * @param amount the amount to transfer.
     * @param toAccount the account to transfer the funds to.
     */
    public void transfer(double amount, BankAccount toAccount) // author: Nathaly Verwaal
    {
        if (amount > 0 && balance >= amount) 
        {
            withdraw(amount);
            toAccount.deposit(amount);
        }
    }
    /**
     * This accessor method returns a string representation of this account
     * in the format (<account_number>,<current_balance>).
     * @return a string representation of this account.
     */
    public String toString() // author: Nathaly Verwaal
    {
        return String.format("%d,%.2f",accountNumber,balance);
    }
    /**
     * Returns true if this account is considered equal to the specified account.
     * Two BankAccounts are considered equal if they have the same account number.
     * @param other the account to check for equality with.
     */
    public boolean equals(BankAccount other) 
    {
        return accountNumber == other.accountNumber;
    }
}