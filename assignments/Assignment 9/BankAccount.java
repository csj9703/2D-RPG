import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
/*
 * This class defines a bank account
 * @author Team 6 - CPSC 233 - Tutorial T02
 * @version 1.0
 * @since November 23, 2017
 */
public class BankAccount {
	public static final double ACCOUNT_FEE = 5.50;
	private double balance;
	private Customer accountHolder;
	private int accountID;
	private final String FILE = "accountInfo.txt";
	/*
	 * This method is written by Nathaly Verwaal
	 */
	public BankAccount(Customer aCustomer) {
		this(0.0, aCustomer);
	}
	/*
	 * This constructor accepts the initial balance and a customer 
	 * object as arguments.  When the application starts, it will get 
	 * the account information from a text file.  If there is no file 
	 * with account information, a new account will be created instead.
	 * When the application closes, the text file will have the updated 
	 * account information, which will be used when the BankApp is 
	 * started again.
	 * @param initialBalance The starting balance as a double
	 * @param aCustomer The customer 
	 */
	public BankAccount(double initialBalance, Customer aCustomer)
	{
		balance = initialBalance;
		accountHolder = new Customer(aCustomer);
		read();
		Runtime.getRuntime().addShutdownHook(onExit());
	}
	/*
	 * This method is written by Nathaly Verwaal
	 */
	public BankAccount(BankAccount toCopy) {
		balance = toCopy.balance;
		accountHolder = toCopy.accountHolder;
	}
	/*
	 * This method is written by Nathaly Verwaal
	 */
	public double getMeasure() {
		return balance;
	}
	/*
	 * This method is written by Nathaly Verwaal
	 */
	protected void setBalance(double newBalance){
		balance = newBalance;
	}
	/*
	 * This method is written by Nathaly Verwaal
	 */
	public void monthEnd() {
		setBalance(balance - ACCOUNT_FEE);
	}
	/*
	 * This method is written by Nathaly Verwaal
	 */
	public boolean equals(BankAccount other){
		boolean isEqual = false;
		if (other instanceof BankAccount) {
			BankAccount b = (BankAccount)other;
			if (accountID == b.accountID) {
				isEqual = true;
			} 
		}
		return isEqual;
	}
	/*
	 * This method is written by Nathaly Verwaal
	 */
	public String toString() {
		return accountHolder.toString() + ":" + balance;
	}
	/*
	 * This method is written by Nathaly Verwaal
	 */
	public Customer getAccountHolder(){
		return new Customer(accountHolder);
	}
	/*
	 * This method is written by Nathaly Verwaal
	 */
	public double getBalance() {
		return balance;
	}
	/*
	 * This method is written by Nathaly Verwaal
	 */
	public void deposit(double amount) {
		if (amount > 0) {
			balance += amount;
		}
	}
	/*
	 * This method is written by Nathaly Verwaal
	 */
	public void withdraw(double amount) throws InsufficientFundsException {
		if (amount > 0 && amount <= balance){
			balance -= amount;
		}else {
			throw new InsufficientFundsException();
		}
	}
	/*
	 * This method is written by Nathaly Verwaal
	 */
	public void transfer(double amount, BankAccount toAccount) throws InsufficientFundsException {
		withdraw(amount);
		toAccount.deposit(amount);
	}
	/*
	 * This method writes the relevant bank account information 
	 * including customer name, ID number, and balance to a text file. 
	 */
	private void write()
	{
		PrintWriter writer;
		try 
		{
			writer = new PrintWriter(new BufferedWriter(new FileWriter(FILE, false)));
			writer.println(accountHolder.getID());
			writer.println(accountHolder.getName());
			writer.println(balance);
			writer.close();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	/*
	 * This method will read the relevant bank account information
	 * including customer name, ID number, and balance from a text file.
	 * If there is no file with account information, a new file will 
	 * be created instead.
	 */
	private void read()
	{
		try 
		{
			BufferedReader reader = new BufferedReader(new FileReader(FILE));
			accountHolder.setID(Integer.parseInt(reader.readLine()));
			accountHolder.setName(reader.readLine());
			setBalance(Double.parseDouble(reader.readLine()));
			reader.close();
		} 
		catch (FileNotFoundException fnfe) 
		{
			write();
			read();
		} 
		catch (IOException ioe) 
		{
			ioe.printStackTrace();
		}
	}
	/*
	 * This method creates and returns a thread that is executed
	 * when the program is closed. This allows the program to save
	 * the account information to a text file on exit.
	 */
	private Thread onExit()
	{
		return new Thread() {public void run() {write();}};
	}
}