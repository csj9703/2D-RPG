import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * The design of the Guessing Game app follows the architecture pattern called
 * Model-View-Controller (MVC) which is a standard design for applications.
 * The model represents the logic of the application.
 * The view represents the user interface of the application.
 * And the controller controls the applications and usually acts as a go-between for
 * the model and the view.
 *
 * In this application, GuessingGameLogic holds the model, GuessingGameGUI holds the view
 * and GuessingGame is the controller.
 */
public class GuessingGame implements ActionListener  {
	private GuessingGameLogic gg = new GuessingGameLogic();
	private GuessingGameGUI gui = new GuessingGameGUI(this);
	
	public void actionPerformed(ActionEvent event) {
		if (event.getActionCommand().equals("GUESS")){
			String guess = gui.getText();
			String message = gg.manageGuess(guess);
			gui.setMessage(message);
		}
                else if (event.getActionCommand().equals("NEW")){
                    gg = new GuessingGameLogic();
                    gui.setMessage(gui.resetLabel());
                }
	}
	
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
				GuessingGame game = new GuessingGame();
				game.gui.pack();
				game.gui.setVisible(true);
            }
        });
    }

}