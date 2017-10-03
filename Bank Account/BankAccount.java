/**
 * This class contains the methods of a bank account
 * @author Team 6 - CPSC 233 - Tutorial T02
 * @version 1.0
 * @since October 3, 2017
 */

public class BankAccount 
{
	private double balance;
	
	/**
	 * This constructor initializes the starting balance
	 * @param beginningBalance This is the starting bank balance
	 */	
	public BankAccount(double beginningBalance)
	{
		balance = beginningBalance;
	}
	
	/**
	 * This method adds to the balance
	 * @param amount The amount to be credited
	 */
	public void deposit(double amount)
	{
		balance += amount;
	}
	
	/**
	 * This method subtracts from the balance
	 * @param amount The amount to be debited
	 */
	public void withdraw(double amount)
	{
		balance -= amount;
	}
}
