/**
 * This class is the graphical user interface 
 * for the banking application
 * @author Team 6 - CPSC 233 - Tutorial T02
 * @version 1.0
 * @since October 18, 2017
 */
import java.awt.Component;
import java.awt.event.ActionListener;
import javax.swing.*;
 
public class Gui extends JFrame 
{
	private JTextField entry = new JTextField(20);
	private JLabel balanceLabel = new JLabel("Current Balance: $ 0.0");
	/*
	 * This constructor initializes the frame, panel, and label
	 * @param listener The action listener
	 */
	public Gui(ActionListener listener) 
	{
		super("Bank App");
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// the panel that contains the label, buttons, and box
		JPanel content = new JPanel();
		content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
		// label displaying the balance
		balanceLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		content.add(balanceLabel);
		entry.setAlignmentX(Component.CENTER_ALIGNMENT);
		content.add(entry);
		// deposit button
		JButton depositBtn = new JButton("Deposit");
		depositBtn.setActionCommand("DEPOSIT");
		depositBtn.addActionListener(listener);
		depositBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
		depositBtn.setFocusPainted(false);
		content.add(depositBtn);
		// withdraw button
		JButton withdrawBtn = new JButton("Withdrarw");
		withdrawBtn.setActionCommand("WITHDRAW");
		withdrawBtn.addActionListener(listener);
		withdrawBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
		withdrawBtn.setFocusPainted(false);
		content.add(withdrawBtn);
		// adds panel to window
		super.getContentPane().add(content);
    }
	/*
	 * This method returns the text entered into the text box
	 */
	public String getText() 
	{
		return entry.getText();
	}
	/*
	 * This method updates the label
	 * @param message The message displayed in label
	 */
	public void setMessage(String message)
	{
		balanceLabel.setText(message);
	}
}