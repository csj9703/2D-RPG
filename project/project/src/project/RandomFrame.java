import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class RandomFrame extends JFrame
{

    ListenForKeys LFK = new ListenForKeys();
    JLabel JInput = new JLabel("");
    JPanel P1 = new JPanel();
    public static void main(String[] args)
    {
        new RandomFrame();
    }

    public RandomFrame()
    {
        super("RandomFrame");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(800,800);
        P1.add(JInput);
        this.add(P1);
        this.setVisible(true);
        this.addKeyListener(LFK);
    }

    private class ListenForKeys implements KeyListener
    {
        @Override
        public void keyPressed(KeyEvent e)
        {
            String Key = String.valueOf(e.getKeyChar());
            JInput.setText(Key);
        }

        //@Override
        public void keyReleased(KeyEvent e)
        {
          int x = 0;
        }
        //@Override
        public void keyTyped(KeyEvent e)
        {
          int x = 0;
        }
    }
}
