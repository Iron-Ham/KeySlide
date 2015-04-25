package views.game;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

/**
 * The Reverse Direction Panel
 * @author heshamsalman
 *
 */
public class ReverseDirectionPanel extends DirectionPanel {
	private static final long serialVersionUID = 1L;


	private void doDrawing(Graphics g) {
		final int NUM_ROWS = 20;
		final int height = 720;
		final int ROW_SIZE = height / NUM_ROWS;

		Graphics2D g2d = (Graphics2D) g;

		g2d.setPaint(colors[4]);
		RenderingHints rh = new RenderingHints( RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		rh.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		g2d.setRenderingHints(rh);

		for (int i = 0; i < NUM_ROWS; i++) {
			if (i % 2 == 0) {
				int y = ROW_SIZE * i;
				g2d.fillRect(0, y, getWidth(), 36);
			}
		}
	} 

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		doDrawing(g);
	}    
}

