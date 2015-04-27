package views.game;

import instruction.InstructionController;
import instruction.InstructionStatus;
import utilities.GameLog;
import views.Window;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.logging.Level;

/**
 * GamePanel class: Contains all game elements
 *
 * @author heshamsalman
 */
public class GamePanel extends JPanel implements KeyListener {
    private static final long serialVersionUID = 1L;
    DirectionPanel directionPanel;
    Clip clip;
    InstructionController controller = InstructionController.getInstance();
    Window window;
    Timer timer;
    JLabel scoreButton;
    private JPanel timePanel;
    private JProgressBar timeBar;
    private int timePosition = 0;
    private int score = 0;

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
        timer = new Timer(20, e -> {
            timeBar.setMaximum(setTime());
            timeBar.setValue(timePosition);
            timePosition += 20;
            if (controller.getStatus() == InstructionStatus.STOP && timeBar.getValue() >= setTime()) {
                nextRound();
            } else if (timeBar.getValue() >= setTime()) {
                gameOver();
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
        addKeyListener(this);
        directionPanel = DirectionPanelFactory.getNextPanel();
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
        updateGUI();
    }

    /**
     * Plays audio.
     *
     * @param url TODO: Clean up this code. Shouldn't have to re-instantiate
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
     * Ends game. Disposes of all game resources and performs operations to setup for next game.
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
        updateUI();
    }

    /**
     * The actions to be carried out for next round
     */
    private void nextRound() {
        restartTimer();
        score += 1;
        updateGUI();
        updateUI();
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
     *
     * @return time, the maximum value of time for that round
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
    public void keyTyped(KeyEvent e) {
    }

    /**
     * Handles key presses
     *
     * @param e caller
     */
    @Override
    public void keyPressed(KeyEvent e) {
        GameLog.log.entering(getClass().getName(), "keyPressed");
        if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_RIGHT
                || e.getKeyCode() == KeyEvent.VK_UP
                || e.getKeyCode() == KeyEvent.VK_DOWN) {
            if (controller.getStatus() == InstructionStatus.STOP)
                gameOver();
            else if (e.getKeyCode() == directionPanel.getInternalKey()) {
                nextRound();
            } else {
                gameOver();
            }
        }
        GameLog.log.exiting(getClass().getName(), "keyPressed");
    }

    /**
     * Updates the gui between rounds
     */
    private void updateGUI() {
        remove(directionPanel);
        directionPanel = DirectionPanelFactory.getNextPanel();
        add(directionPanel, BorderLayout.CENTER);
        remove(timePanel);
        timePanel.remove(timeBar);
        timeBar.setForeground(directionPanel.getColors()[0]);
        timePanel.add(timeBar);
        timePanel.setBackground(directionPanel.getColors()[2]);
        scoreButton.setBackground(directionPanel.getColors()[2]);
        scoreButton.setText("" + score);
        add(timePanel, BorderLayout.SOUTH);
    }

    /**
     * @return score -- value of points
     */
    public int getScore() {
        return score;
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void addNotify() {
        super.addNotify();
        requestFocus();
    }
}
