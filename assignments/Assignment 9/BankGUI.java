import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
/*
 * This class is written by Nathaly Verwaal
 */
public class BankGUI extends JFrame {
	private JLabel balanceLbl = new JLabel("0.0");
	private JTextField amountEntry = new JTextField(20); 
	private JLabel errorLbl = new JLabel("  ");
	
	public BankGUI(ActionListener listener){
		super("My Account");
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel content = new JPanel();
		content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
		
		balanceLbl.setAlignmentX(Component.CENTER_ALIGNMENT);
		content.add(balanceLbl);
		
		amountEntry.setAlignmentX(Component.CENTER_ALIGNMENT);
		content.add(amountEntry);
		
		JButton withdrawBtn = new JButton("withdraw");
		withdrawBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
		withdrawBtn.addActionListener(listener);
		content.add(withdrawBtn);
		
		JButton depositBtn = new JButton("deposit");
		depositBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
		depositBtn.addActionListener(listener);
		content.add(depositBtn);
		
		errorLbl.setForeground(Color.RED);
		content.add(errorLbl);
		
		super.getContentPane().add(content);
    }
	
	public void clear(){
		amountEntry.setText("");
		amountEntry.requestFocus();
	}
	
	public void setBalance(String balance){
		balanceLbl.setText(balance);
	}
	
	public String getAmount() {
		return amountEntry.getText();
	}
	
	public void setError(String msg) {
		errorLbl.setText(msg);
	}
}