package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.Timer;

public class GamePanel extends JPanel implements KeyListener {
	Window window;
	private JPanel basePanel = new JPanel();
	private JPanel timePanel = new JPanel();
	private JProgressBar timebar;
	private int score =0;
	private int delay = 10;
	private int timePosition = 0;
	Timer timer;
	JLabel scoreLabel;
	
	public GamePanel(Window window) {
		this.window = window;
	    basePanel.setSize(1280, 720);       // basePanel is the main panel
	    basePanel.setLayout(new BorderLayout());
	    basePanel.addKeyListener(this);
	    basePanel.setFocusable(true);
	    basePanel.setFocusTraversalKeysEnabled(false);
	    
	    timePanel = new JPanel();
	    timePanel.setBackground(Color.WHITE);
	    timebar = new JProgressBar();
	    timebar.setPreferredSize(new Dimension(1280, 50));
	    timebar.setMaximum(maxTime());
	    timebar.setMinimum(0);
	    timer = new Timer(10, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				timebar.setValue(timePosition);
				timePosition += 10;
				if (timebar.getValue() >= maxTime()) {
					timePosition = 0;
					timebar.setValue(timePosition);
					timer.stop();
					window.switchToGameOver(); //TODO: Tie in DB utility, pass score to game over screen
				}
			}
	    });
	    timer.start();
	    scoreLabel = new JLabel("Score: ");
	    scoreLabel.setFont(new Font("Arial", Font.PLAIN, 40));
	    timePanel.add(timebar);
	    basePanel.add(scoreLabel, BorderLayout.NORTH);
	    basePanel.add(timePanel, BorderLayout.SOUTH);
	    add(basePanel);
	}
	
	private int maxTime() {
		if (score < 5) {
			return 2000;
		} else if (score < 10) {
			return 1600;
		} else if (score < 15) {
			return 1200;
		} else if (score < 20) {
			return 1000;
		}
		return 800;
		
	}
	
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
