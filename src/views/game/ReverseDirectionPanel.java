package views.game;

import instruction.InstructionStatus;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * The Reverse Direction Panel
 *
 * @author heshamsalman
 */
public class ReverseDirectionPanel extends DirectionPanel {
    private static final long serialVersionUID = 1L;

    /**
     * Draws alternating bg
     *
     * @param g the bg to draw on
     */
    private void doDrawing(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        rh.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHints(rh);
        g2d.setPaint(colors[4]);


        final int NUM_ROWS = 20;
        final int height = 720;
        final int ROW_SIZE = height / NUM_ROWS;

        for (int i = 0; i < NUM_ROWS; i++) {
            if (i % 2 == 0) {
                int y = ROW_SIZE * i;
                g2d.fillRect(0, y, getWidth(), ROW_SIZE);
            }
        }
    }


    /**
     * Sets the instruction internal key to the reverse of the instruction
     */
    @Override
    protected void resolveInstructions() {
        InstructionStatus status = instrControl.getStatus();
        if (status == InstructionStatus.LEFT) {
            internalKey = KeyEvent.VK_RIGHT;
            symbol = left;
        } else if (status == InstructionStatus.RIGHT) {
            internalKey = KeyEvent.VK_LEFT;
            symbol = right;
        } else if (status == InstructionStatus.UP) {
            internalKey = KeyEvent.VK_DOWN;
            symbol = up;
            symbol.setVerticalAlignment(JLabel.CENTER);

            } else if (instrControl.getStatus() == InstructionStatus.DOWN) {
                internalKey = KeyEvent.VK_UP;
                symbol = new DownLabel();
                symbol.setVerticalAlignment(JLabel.CENTER);
            } else if (instrControl.getStatus() == InstructionStatus.STOP) {
                int random = r.nextInt(10);
                //We want to make random appear at 1/2 the rate as the other instructions.
                if (random < 5 || happenedOnce) {
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
                } else {
                    happenedOnce = true;
                }
            }
        }
        symbol.setHorizontalAlignment(JLabel.CENTER);
        removeAll();
        add(symbol, BorderLayout.CENTER);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
    }
}
