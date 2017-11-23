import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class BankAccount {
	public static final double ACCOUNT_FEE = 5.50;
	private double balance;
	private Customer accountHolder;
	private int accountID;
	private final String FILE = "accountInfo.txt";
	
	public BankAccount(Customer aCustomer){
		this(0.0, aCustomer);
	}
	
	public BankAccount(double initialBalance, Customer aCustomer){
		super();
		balance = initialBalance;
		accountHolder = new Customer(aCustomer);
		read();
		Runtime.getRuntime().addShutdownHook(onExit());
	}
	
	public BankAccount(BankAccount toCopy) {
		balance = toCopy.balance;
		accountHolder = toCopy.accountHolder;
	}
	
	public double getMeasure(){
		return balance;
	}
	
	protected void setBalance(double newBalance){
		balance = newBalance;
	}
	
	public void monthEnd(){
		// Withdraw even if the result is an overdraft.
		setBalance(balance - ACCOUNT_FEE);
	}
	
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
	
	public String toString() {
		return accountHolder.toString() + ":" + balance;
	}
	
	public Customer getAccountHolder(){
		return new Customer(accountHolder);
	}
	
	public double getBalance() {
		return balance;
	}
	
	public void deposit(double amount) {
		if (amount > 0) {
			balance += amount;
		}
	}
	
	public void withdraw(double amount) throws InsufficientFundsException {
		if (amount > 0 && amount <= balance){
			balance -= amount;
		}else {
			throw new InsufficientFundsException();
		}
	}
	
	public void transfer(double amount, BankAccount toAccount) throws InsufficientFundsException {
		withdraw(amount);
		toAccount.deposit(amount);
	}
	/*
	 * This method writes the relevant bank account information 
	 * including customer name, ID number, and balance to a text file 
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
	 * including customer name, ID number, and balance from a text file 
	 */
	private void read()
	{
		try 
		{
			BufferedReader reader = new BufferedReader(new FileReader(FILE));
			accountHolder.setID(Integer.parseInt(reader.readLine()));
			accountHolder.setName(reader.readLine());
			setBalance(Double.parseDouble(reader.readLine()));
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
	 * when the program is closed
	 */
	private Thread onExit()
	{
		return new Thread() {public void run() {write();}};
	}
}