package views;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;

import com.sun.java.swing.plaf.windows.resources.windows;

import utilities.Colors;

/**
 * Menu Items are JButtons that allow the user to go to different panels of the game. 
 * @author heshamsalman
 *
 */
public class MenuItem extends JButton implements MouseListener{
	private static final long serialVersionUID = 3699142395262583263L;
	Window window;
	public MenuItem(Window window, String text) {
		this.window = window;
		this.setText(text);
		this.setActionCommand(text);
		this.setFont(new Font("Arial", Font.PLAIN, 40));
		this.setMaximumSize(new Dimension(400, 100));
		this.setContentAreaFilled(false);
		this.setFocusPainted(false);
		this.setBorder(BorderFactory.createEmptyBorder());
		this.setForeground(Colors.unselected());
		addMouseListener(this);
	}

//	@Override
//	public void mouseClicked(MouseEvent e) {
//		Object source = e.getSource();
//		if (source instanceof MenuItem) {
//			MenuItem m = (MenuItem) source;
//			if (m.getActionCommand().equals("Start")) {
//				
//			} else if (m.getActionCommand().equals("Hi-Scores")) {
//				window.removeAll();
//				window.setContentPane(new ScorePanel());
//				window.pack();
//			} else if (m.getActionCommand().equals("Instructions")) {
//				window.removeAll();
//				window.setContentPane(new InstructionPanel());
//				window.pack();
//				window.setExtendedState(JFrame.MAXIMIZED_BOTH);
//				window.setVisible(true);
//			}
//		}
//
//	}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {
		if (e.getSource() == this) {
			this.setForeground(Colors.selected());
		}
		this.updateUI();
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if (e.getSource() == this) {
			this.setForeground(Colors.unselected());
		}
		this.updateUI();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
