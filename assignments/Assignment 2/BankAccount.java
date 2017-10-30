/**
 * This class contains the methods of a bank account
 * @author Team 6 - CPSC 233 - Tutorial T02
 * @version 1.2
 * @since October 5, 2017
 */

public class BankAccount 
{
	private double balance;
	
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
}












