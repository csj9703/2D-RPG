/**
 * This class contains the methods of a bank account
 * @author Team 6 - CPSC 233 - Tutorial T02
 * @version 1.5
 * @since October 12, 2017
 */

public class BankAccount 
{
	private double balance;
	private Customer accountHolder;
	
	/**
	 * This constructor takes an variable of the 
	 * Customer type as an argument
	 * @param customer The customer object
	 */
	public BankAccount(Customer customer)
	{
		accountHolder = customer;
	}
	
	/**
	 * This constructor takes an variable of the 
	 * Customer type and a double as an argument
	 * @param initialBalance The starting balance of the bank account
	 * @param customer  An instance of the customer class
	 */
	public BankAccount(double initialBalance, Customer customer)
	{
		balance = initialBalance;
		accountHolder = customer;
	}
	
	/**
	 * A copy constructor. 
	 * @param account The BankAccount object to be copied
	 */
	public BankAccount(BankAccount account)
	{
		balance = account.balance;
	}
	
	/**
	 * This method adds to the balance
	 * @param amount The amount to be credited
	 */
	public void deposit(double amount)
	{
		if (amount >= 0)
		{
			balance += amount;
		}
	}
	
	/**
	 * This method subtracts from the balance
	 * @param amount The amount to be debited
	 */
	public void withdraw(double amount)
	{
		if (amount <= balance)
		{
			balance -= amount;
		}
	}
	
	/**
	 * This returns the current balance
	 */
	public double getBalance()
	{
		return balance;
	}
	
	/**
	 * This method transfer the balance from one account to another
	 * @param amount The amount to be transfered
	 * @param account The account receiving the transfer
	 */
	public void transfer(double amount, BankAccount account)
	{
		if (amount <= balance)
		{
			balance -= amount;
			account.deposit(amount);
		}
	}
	
	/**
	 * Getter method for the account holder
	 * @return accountHolder The account holder
	 */
	public Customer getAccountHolder()
	{
		return new Customer(accountHolder);
	}
}
