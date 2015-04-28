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
        //Because we want to give two opportunities to generate an instruction.
        for (int i = 0; i < 2; i++) {
        	instrControl.nextInstruction();
        	if (instrControl.getStatus() == InstructionStatus.LEFT) {
                internalKey = KeyEvent.VK_LEFT;
                symbol = new LeftLabel();
            } else if (instrControl.getStatus() == InstructionStatus.RIGHT) {
                internalKey = KeyEvent.VK_RIGHT;
                symbol = new RightLabel();
            } else if (instrControl.getStatus() == InstructionStatus.UP) {
                internalKey = KeyEvent.VK_UP;
                symbol = new UpLabel();
                symbol.setVerticalAlignment(JLabel.CENTER);

            } else if (instrControl.getStatus() == InstructionStatus.DOWN) {
                internalKey = KeyEvent.VK_DOWN;
                symbol = new DownLabel();
                symbol.setVerticalAlignment(JLabel.CENTER);
            } else if (instrControl.getStatus() == InstructionStatus.STOP) {
            	int random = r.nextInt(10);
            	//We want to make random appear at 1/2 the rate as the other instructions. 
            	if (random < 5 ) {
            		internalKey = -1;
                    label l = label.values()[r.nextInt(label.values().length)];
                    //Generates a Random Label for the stop instruction
                    switch (l) {
                        case UP:
                            symbol = new UpLabel();
                            symbol.setVerticalAlignment(JLabel.CENTER);
                            break;
                        case DOWN:
                            symbol = new DownLabel();
                            symbol.setVerticalAlignment(JLabel.CENTER);
                            break;
                        case LEFT:
                            symbol = new LeftLabel();
                            break;
                        case RIGHT:
                            symbol = new RightLabel();
                            break;
                        default:
                            System.out.println("Unexpected value!?");
                    }
                    break;
            	}
            }
        }
        symbol.setHorizontalAlignment(JLabel.CENTER);
        removeAll();
        add(symbol, BorderLayout.CENTER);
    }

    private enum label {
        LEFT,
        RIGHT,
        UP,
        DOWN
    }
}
