import java.awt.Component;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
 
public class GuessingGameGUI extends JFrame {
	private JTextField entry = new JTextField(20);
        private String newGameMsg = "I'm thinking of a number between 1 and 10.  Try to guess it.";
	private JLabel msgLabel = new JLabel(newGameMsg);
	
	public GuessingGameGUI(ActionListener listener) {
		super("Guessing Game");
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel content = new JPanel();
		content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
		
		msgLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		content.add(msgLabel);
		
		entry.setAlignmentX(Component.CENTER_ALIGNMENT);
		content.add(entry);
		
		JButton guessBtn = new JButton("guess");
		guessBtn.setActionCommand("GUESS");
		guessBtn.addActionListener(listener);
                
                // button to start a new game
                JButton newBtn = new JButton("new");
		newBtn.setActionCommand("NEW");
		newBtn.addActionListener(listener);
		
		guessBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
		content.add(guessBtn);
                content.add(newBtn);
		
		super.getContentPane().add(content);
    }
	
	public String getText() {
		return entry.getText();
	}
	
	public void setMessage(String message){
		msgLabel.setText(message);
	}
        public String resetLabel() {
            return newGameMsg;
        }
	
}