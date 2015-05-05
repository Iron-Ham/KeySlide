package views.game;

import instruction.InstructionController;
import instruction.InstructionStatus;
import utilities.Colors;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Random;

/**
 * DirectionPanel is the abstract class. At base implementation, it is a SimpleDirectionPanel
 *
 * @author heshamsalman
 */
public abstract class DirectionPanel extends JPanel {
    private static final long serialVersionUID = -2473781340553160448L;
    protected InstructionLabel symbol;
    protected int internalKey;
    protected Color[] colors = new Color[5];
    InstructionController instrControl = InstructionController.getInstance();
    Random r = new Random();
    protected UpLabel up = new UpLabel();
    protected LeftLabel left = new LeftLabel();
    protected DownLabel down = new DownLabel();
    protected RightLabel right = new RightLabel();


    /**
     * Constructor.
     */
    public DirectionPanel() {
        setLayout(new BorderLayout());
        resolveInstructions();
        setColors();
    }

    /**
     * Sets background color of the panel and of the symbol.
     */
    protected void setColors() {
        colors = Colors.getRandomColorFamily();
        setBackground(colors[2]);
        if (instrControl.getStatus() == InstructionStatus.STOP)
            symbol.setForeground(Color.WHITE);
        else
            symbol.setForeground(colors[0]);
    }

    public void updateSelf() {
        resolveInstructions();
        setColors();
    }

    /**
     * @return internalKey, the KeyEvent code required of it per panel type
     */
    public int getInternalKey() {
        return internalKey;
    }

    public Color[] getColors() {
        return colors;
    }

    /**
     * Constructor helper, also helps with updating panel
     */
    protected synchronized void resolveInstructions() {
        symbol = null;
        if (instrControl.getStatus() == InstructionStatus.LEFT) {
            internalKey = KeyEvent.VK_LEFT;
            symbol = left;
        } else if (instrControl.getStatus() == InstructionStatus.RIGHT) {
            internalKey = KeyEvent.VK_RIGHT;
            symbol = right;
        } else if (instrControl.getStatus() == InstructionStatus.UP) {
            internalKey = KeyEvent.VK_UP;
            symbol = up;
            symbol.setVerticalAlignment(JLabel.CENTER);

        } else if (instrControl.getStatus() == InstructionStatus.DOWN) {
            internalKey = KeyEvent.VK_DOWN;
            symbol = down;
            symbol.setVerticalAlignment(JLabel.CENTER);
        } else if (instrControl.getStatus() == InstructionStatus.STOP) {
            internalKey = -1;
            label l = label.values()[r.nextInt(label.values().length)];
            //Generates a Random Label for the stop instruction
            switch (l) {
                case UP:
                    symbol = up;
                    symbol.setVerticalAlignment(JLabel.CENTER);
                    break;
                case DOWN:
                    symbol = down;
                    symbol.setVerticalAlignment(JLabel.CENTER);
                    break;
                case LEFT:
                    symbol = left;
                    break;
                case RIGHT:
                    symbol = right;
                    break;
                default:
                    System.out.println("Unexpected value!?");
            }
        }
        symbol.setHorizontalAlignment(JLabel.CENTER);
        removeAll();
        add(symbol, BorderLayout.CENTER);
    }

    protected enum label {
        LEFT,
        RIGHT,
        UP,
        DOWN
    }
}
