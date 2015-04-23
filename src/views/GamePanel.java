package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.Timer;

/**
 * GamePanel
 * @author heshamsalman
 *
 */
public class GamePanel extends JPanel implements KeyListener {
	private static final long serialVersionUID = 1L;
	DirectionPanel dp;
	Clip clip;
	Window window;
	private JPanel timePanel;
	private JProgressBar timeBar;
	private int timePosition = 0;
	private int score = 0;
	Timer timer;
	JButton scoreLabel;

	public GamePanel(final Window window) {
		this.window = window;
		setSize(1280, 720);
		setFocusable(true);
		setLayout(new BorderLayout());
		timePanel = new JPanel();
		timePanel.setBackground(Color.WHITE);
		timeBar = new JProgressBar();
		timeBar.setPreferredSize(new Dimension(1280, 50));
	    timeBar.setMaximum(maxTime());
	    timeBar.setMinimum(0);
	    timer = new Timer(20, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			    timeBar.setMaximum(maxTime());
				timeBar.setValue(timePosition);
				timePosition += 20;
				if (timeBar.getValue() >= maxTime()) {
					gameOver();
					window.switchToGameOver();
				}
			}
	    });
	    scoreLabel = new JButton("Score: " + score);
	    scoreLabel.setFont(new Font("Arial", Font.PLAIN, 40));
	    scoreLabel.setContentAreaFilled(false);
	    scoreLabel.setFocusPainted(false);
		scoreLabel.setBorder(BorderFactory.createEmptyBorder());
	    timePanel.add(timeBar);
	    add(scoreLabel, BorderLayout.NORTH);
	    add(timePanel, BorderLayout.SOUTH);
	    dp = new DirectionPanel();
	    addKeyListener(this);
	    add(dp, BorderLayout.CENTER);
	}

	public void start() {
		doPlay(new File("Assets/Audio/Chiptune.wav"));
		score = 0;
		timePosition = 0;
		timer.start();
	}

	private void doPlay(final File url) {
	    try {
	        stopPlay();
	        AudioInputStream inputStream = AudioSystem
	                .getAudioInputStream(url);
	        clip = AudioSystem.getClip();
	        clip.open(inputStream);
	        clip.start();
	    } catch (Exception e) {
	        stopPlay();
	        System.err.println(e.getMessage());
	    }
	}

	private void stopPlay() {
	    if (clip != null) {
	        clip.stop();
	        clip.close();
	        clip = null;
	    }
	}


	public void gameOver() {
		stopPlay();
		timePosition = 0;
		timer.stop();
		timeBar.setValue(timePosition);
		window.switchToGameOver();
	}

	public void restartTimer() {
		timePosition = 0;
		timeBar.setValue(timePosition);
		timer.restart();
	}


	private int maxTime() {
		int time = 1500 - (30 * score);
		if (time < 500) {
			return 500;
		} else {
			return time;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyPressed(KeyEvent e) {
	    if(e.getKeyCode() == dp.getInternalKey()){
	    	dp.updateDirection();
	    	restartTimer();
	    	score+=1;
	    	scoreLabel.setText("Score: " + score);
	    }
	    else {
	    	gameOver();
	    }
	}

	public int getScore() {
		return score;
	}

	@Override
	public void keyReleased(KeyEvent e) {}

	/**
	 * Required if we add a key listener to this class.
	 */
	@Override
	public void addNotify() {
		super.addNotify();
		requestFocus();
	}
}
