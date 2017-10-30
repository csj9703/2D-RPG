/**
 * This class is the manager for the banking application
 * @author Team 6 - CPSC 233 - Tutorial T02
 * @version 1.0
 * @since October 18, 2017
 */
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/*
 * This is the main method 
 */
public class Main implements ActionListener  
{	
	private Customer customer = new Customer("Bob",1234);
	private BankAccount account = new BankAccount(0, customer);
	private Gui gui = new Gui(this);
	/* 
	 * This action listener method is invoked each time the user clicks a button
	 */
	public void actionPerformed(ActionEvent event) 
	{
		if (event.getActionCommand().equals("DEPOSIT"))
		{
			account.deposit(Double.parseDouble(gui.getText()));
		}
		else if (event.getActionCommand().equals("WITHDRAW"))
		{
			account.withdraw(Double.parseDouble(gui.getText()));
		}
		gui.setMessage("Current Balance: $ " + account.getBalance());
	}
	/*
	 * This main method is the starting point of the banking program
	 */
    public static void main(String[] args) 
    {
        javax.swing.SwingUtilities.invokeLater(new Runnable() 
        {
            public void run() 
            {
				Main main = new Main();
				main.gui.pack();
				main.gui.setVisible(true);
            }
        });
    }
}