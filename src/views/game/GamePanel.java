package views.game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.logging.Level;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.Timer;

import utilities.GameLog;
import views.Window;

/**
 * GamePanel class: Contains all game elements
 * @author heshamsalman
 *
 */
public class GamePanel extends JPanel implements KeyListener {
	private static final long serialVersionUID = 1L;
	DirectionPanel directionPanel;
	Clip clip;
	Window window;
	private JPanel timePanel;
	private JProgressBar timeBar;
	private int timePosition = 0;
	private int score = 0;
	Timer timer;
	JLabel scoreButton;
	
	public GamePanel(final Window window) {
		this.window = window;
		setupGui();
	}

	/**
	 * Sets up GUI
	 */
	private void setupGui() {
		setSize(1280, 720);
		setFocusable(true);
		setLayout(new BorderLayout());
		timePanel = new JPanel();
		timeBar = new JProgressBar();
		timeBar.setPreferredSize(new Dimension(1280, 50));
	    timeBar.setMaximum(setTime());
	    timeBar.setMinimum(0);
	    timer = new Timer(20, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			    timeBar.setMaximum(setTime());
				timeBar.setValue(timePosition);
				timePosition += 20;
				if (timeBar.getValue() >= setTime()) {
					gameOver();
					window.switchToGameOver();
				}
			}
	    });
	    scoreButton = new JLabel("0");
	    scoreButton.setFont(new Font("Arial", Font.PLAIN, 40));
	    scoreButton.setForeground(Color.WHITE);
	    scoreButton.setOpaque(true);
		scoreButton.setBorder(BorderFactory.createEmptyBorder());
	    timePanel.add(timeBar);
	    add(scoreButton, BorderLayout.NORTH);
	    add(timePanel, BorderLayout.SOUTH);
	    directionPanel = DirectionPanelFactory.getNextPanel();
	    addKeyListener(this);
	    add(directionPanel, BorderLayout.CENTER);
	    updateGUI();
	}

	/**
	 * Starts instance of game
	 */
	public void start() {
		doPlay(new File("Assets/Audio/Chiptune.wav"));
		score = 0;
		timePosition = 0;
		timer.start();
	}

	/**
	 * Plays audio.
	 * @param url
	 * TODO: Clean up this code. Shouldn't have to re-instantiate
	 */
	private void doPlay(final File url) {
		GameLog.log.entering(getClass().getName(), "doPlay");
	    try {
	        stopPlay();
	        AudioInputStream inputStream = AudioSystem
	                .getAudioInputStream(url);
			GameLog.log.log(Level.INFO, "Playing Audio");
	        clip = AudioSystem.getClip();
	        clip.open(inputStream);
	        clip.start();
	    } catch (Exception e) {
	        stopPlay();
	        System.err.println(e.getMessage());
	    }
		GameLog.log.exiting(getClass().getName(), "doPlay");
	}

	/**
	 * Stops audio.
	 */
	private void stopPlay() {
		GameLog.log.entering(getClass().getName(), "stopPlay");
	    if (clip != null) {
	        clip.stop();
	        clip.close();
			GameLog.log.log(Level.INFO, "Stopping Audio");
	        clip = null;
	    }
		GameLog.log.exiting(getClass().getName(), "doPlay");
	}


	/**
	 * Ends game. Disposes of all game resources & performs operations to setup for next game.
	 */
	private void gameOver() {
		GameLog.log.entering(getClass().getName(), "gameOver");
		stopPlay();
		updateGUI();
		timePosition = 0;
		timer.stop();
		timeBar.setValue(timePosition);
		window.switchToGameOver();
		GameLog.log.exiting(getClass().getName(), "gameOver");
	}

	/**
	 * Restarts timer.
	 */
	private void restartTimer() {
		GameLog.log.entering(getClass().getName(), "restartTimer");
		timePosition = 0;
		timeBar.setValue(timePosition);
		timer.restart();
		GameLog.log.exiting(getClass().getName(), "restartTimer");
	}


	/**
	 * Sets time per round
	 * @return
	 */
	private int setTime() {
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
		GameLog.log.entering(getClass().getName(), "keyPressed");
		if (e.getKeyCode() == KeyEvent.VK_F24) {

		}
		else if(e.getKeyCode() == directionPanel.getInternalKey()){
	    	restartTimer();
	    	score+=1;
	    	updateGUI();
	    }
	    else {
	    	gameOver();
	    }
		updateUI();
		GameLog.log.exiting(getClass().getName(), "keyPressed");
	}

	
	private void updateGUI() {
		remove(directionPanel);
    	directionPanel = DirectionPanelFactory.getNextPanel();
    	add(directionPanel, BorderLayout.CENTER);
    	remove (timePanel);
    	timePanel.remove(timeBar);
    	timeBar.setForeground(directionPanel.getColors()[0]);
    	timePanel.add(timeBar);
    	timePanel.setBackground(directionPanel.getColors()[2]);
    	scoreButton.setBackground(directionPanel.getColors()[2]);
    	scoreButton.setText("" +score);
    	add(timePanel, BorderLayout.SOUTH);
	}
	
	
	
	public int getScore() {
		return score;
	}

	
	
	
	@Override
	public void keyReleased(KeyEvent e) {}

	@Override
	public void addNotify() {
		super.addNotify();
		requestFocus();
	}
}
