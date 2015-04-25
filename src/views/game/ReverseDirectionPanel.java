package views.game;

import instruction.InstructionStatus;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;

import javax.swing.JLabel;

/**
 * The Reverse Direction Panel
 * @author heshamsalman
 *
 */
public class ReverseDirectionPanel extends DirectionPanel {
	private static final long serialVersionUID = 1L;

	/**
	 * Draws the alternating background.
	 * @param g
	 */
	private void doDrawing(Graphics g) {	
		Graphics2D g2d = (Graphics2D) g;
		RenderingHints rh = new RenderingHints( RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		rh.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		g2d.setRenderingHints(rh);
		g2d.setPaint(colors[4]);

		
		final int NUM_ROWS = 20;
		final int height = 720;
		final int ROW_SIZE = height / NUM_ROWS;
		
		for (int i = 0; i < NUM_ROWS; i++) {
			if (i % 2 == 0) {
				int y = ROW_SIZE * i;
				g2d.fillRect(0, y, getWidth(), 36);
			}
		}
	} 
	
	@Override
	protected void resolveInstructions() {
		InstructionStatus status = instrControl.getStatus();
		if (status == InstructionStatus.LEFT)  {
			internalKey = KeyEvent.VK_RIGHT;
			symbol = new LeftLabel();
		}
		else if (status == InstructionStatus.RIGHT) {
			internalKey = KeyEvent.VK_LEFT;
			symbol = new RightLabel();
		}
		else if (status == InstructionStatus.UP) {
			internalKey = KeyEvent.VK_DOWN;
			symbol = new UpLabel();
			symbol.setVerticalAlignment(JLabel.CENTER);

		} else {
			internalKey = KeyEvent.VK_UP;
			symbol = new DownLabel();
			symbol.setVerticalAlignment(JLabel.CENTER);
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

