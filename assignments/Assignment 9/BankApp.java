import java.awt.event.*;
/*
 * This class is written by Nathaly Verwaal
 */
public class BankApp implements ActionListener {
	private BankGUI gui;
	private BankAccount account;
	
	public BankApp() {
		account = new BankAccount(new Customer("Bob",1));
		gui = new BankGUI(this);
		gui.setBalance(account.getBalance() + "");
		gui.pack();
		gui.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent event){
		if (event.getActionCommand().equals("deposit")){
			double amount = Double.parseDouble(gui.getAmount());
			account.deposit(amount);
		} else if (event.getActionCommand().equals("withdraw")){
			double amount = Double.parseDouble(gui.getAmount());
			try {
				account.withdraw(amount);
			} catch (InsufficientFundsException ife) {
				gui.setError("Insufficient Funds in Account");
			}
		}
		double balance = account.getBalance();
		gui.clear();
		gui.setBalance("" + balance);
	}
	
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	BankApp app = new BankApp();
            }
        });
    }
}