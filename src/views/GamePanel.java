package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.Timer;

public class GamePanel extends JPanel implements KeyListener {
	private static final long serialVersionUID = 1L;
	Window window;
	private JPanel timePanel = new JPanel();
	private JProgressBar timebar;
	private int score =0;
	private int delay = 10;
	private int timePosition = 0;
	Timer timer;
	JButton scoreLabel;
	private final Object lock = new Object();
	private boolean isSlideInProgress = false;
	private final ArrayList<Component> jPanels = new ArrayList<Component>();
	private Random randomGenerator = new Random();
	private final int RIGHT = 0x01;
	private final int LEFT = 0x02;
	private final int TOP = 0x03;
	private final int BOTTOM = 0x04;
	private JLabel[] labels = new JLabel[20];
	
	
	
	public GamePanel(Window window) {
		this.window = window;
	    this.setSize(1280, 720);       // this is the main panel
	    this.setLayout(new BorderLayout());
	    this.setFocusable(true);
	    this.setFocusTraversalKeysEnabled(false);
	    
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
					gameOver();
					window.switchToGameOver(); //TODO: Tie in DB utility, pass score to game over screen
				}
			}
	    });
	    scoreLabel = new JButton("Score: " + score);
	    scoreLabel.setFont(new Font("Arial", Font.PLAIN, 40));
	    scoreLabel.setContentAreaFilled(false);
	    scoreLabel.setFocusPainted(false);
		scoreLabel.setBorder(BorderFactory.createEmptyBorder());
	    timePanel.add(timebar);
	    this.add(scoreLabel, BorderLayout.NORTH);
	    this.add(timePanel, BorderLayout.SOUTH);
        String[] imageNames = {"1.png","2.png","3.png","4.png","5.png","6.png","7.png","8.png"};	
		String imageFolder = "images/";
		for (int i = 0; i < imageNames.length; i++) {
			ImageIcon icon = new ImageIcon(imageFolder + imageNames[i]);
			labels[i] = new JLabel(icon);
			labels[i].setName(imageNames[i]);
			addComponent(labels[i]);
		}
	    addKeyListener(this);
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
	
	public void addNotify() {
		super.addNotify();
		requestFocus();
	}
	
	public void start() {
		score = 0;
		scoreLabel.setText("Score: " + score);
		timePosition = 0;
		timer.start();
	}
	
	public void restartTimer() {
		score += 1;
		scoreLabel.setText("Score: " + score);
		timePosition = 0;
		timer.start();
	}
	
	public void gameOver() {
		timePosition = 0;
		timer.stop();
		timebar.setValue(timePosition);
	}
	
	public int getScore() {
		return score;
	}
	
	
	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println("Key Pressed");
	    if(e.getKeyCode() == KeyEvent.VK_LEFT){
	    	slideLeft();       
	    }
	    if(e.getKeyCode() == KeyEvent.VK_RIGHT){
	    	slideRight();            
	    }          
	    if(e.getKeyCode() == KeyEvent.VK_UP){
	    	slideTop();            
	    }   
	    if(e.getKeyCode() == KeyEvent.VK_DOWN){
	    	slideBottom();         
	    }   
	}
	
	@Override
	public void keyReleased(KeyEvent e) {}

	public void slideLeft() {
	    slide(LEFT);
	}
	
	public void slideRight() {
	    slide(RIGHT);
	}
	
	public void slideTop() {
	    slide(TOP);
	}
	
	public void slideBottom() {
	    slide(BOTTOM);
	}
	
	public void addComponent(final Component component) {
	    if (jPanels.contains(component)) {
	    }
	    else {
	        jPanels.add(component);
	        if (jPanels.size() == 1) {
	            this.add(component);   
	        }
	        component.setSize(this.getSize());
	        component.setLocation(0, 0);
	    }
	}
	
	public void removeComponent(final Component component) {
	    if (jPanels.contains(component)) {
	        jPanels.remove(component);
	    }
	}
	
	private void slide(final int slideType) {
	    if (!isSlideInProgress) {
	        isSlideInProgress = true;
	        final Thread t0 = new Thread(new Runnable() {
	            @Override
	            public void run() {          
	                slide(true, slideType);
	                isSlideInProgress = false;
	            }
	        });
	        t0.setDaemon(true);
	        t0.start();
	    }
	    else {
	        Toolkit.getDefaultToolkit().beep();
	    }
	}
	
	
	/*This is the function to accomplish sliding*/
	private void slide(final boolean useLoop, final int slideType) {
	    if (jPanels.size() < 2) {
	        System.err.println("Not enough panels");
	        return;
	    }
	    synchronized (lock) {
	        Component componentOld = null;
	        Component componentNew = null;
	        int randomInt = randomGenerator.nextInt(7)+1;
            componentOld = jPanels.get(0);
            componentNew = jPanels.remove(randomInt);
            jPanels.add(0, componentNew);
            int i = Integer.parseInt(componentOld.getName().substring(0, 1));
	       
	        if (slideType == LEFT) {
	           if (i != 4 && i!=8)
	        	   gameOver();
	          else
	        	   restartTimer();  	   	   
	         }
	        if (slideType == TOP) {            
	            if (i != 1 && i!=5)
	            	gameOver();
	            else
	            	restartTimer();
	        }
	        if (slideType == RIGHT) {
	            if (i != 3 && i!=7)
	            	gameOver();
	            else
	            	restartTimer();
	        }
	        if (slideType == BOTTOM) {
	            if (i != 2 && i!=6)
	            	gameOver();
	            
	            else
	            	restartTimer();
	        }
	        final int w = componentOld.getWidth();
	        final int h = componentOld.getHeight();
	        final Point p1 = componentOld.getLocation();
	        final Point p2 = new Point(0, 0);
	        if (slideType == LEFT) {
	            p2.x += w;
	        }
	        if (slideType == RIGHT) {
	            p2.x -= w;
	        }
	        if (slideType == TOP) {
	            p2.y += h;
	        }
	        if (slideType == BOTTOM) {
	            p2.y -= h;
	        }
	        componentNew.setLocation(p2);
	        int step = 0;
	        if ((slideType == LEFT) || (slideType == RIGHT)) {
	            step = (int) ((1280 / (float) Toolkit.getDefaultToolkit().getScreenSize().width) * 40.f);
	        }
	        else {
	            step = (int) ((720 / (float) Toolkit.getDefaultToolkit().getScreenSize().height) * 30.f);
	        }
	        step = step < 5 ? 5 : step;
	        this.add(componentNew);
	        this.revalidate();
	        if (useLoop) {
	            final int max = (slideType == LEFT) || (slideType == RIGHT) ? w : h;
	            final long t0 = System.currentTimeMillis();
	            for (int j = 0; j != (max / step); j++) {
	                switch (slideType) {
	                    case LEFT: {
	                        p1.x -= step;
	                        componentOld.setLocation(p1);
	                        p2.x += step;
	                        componentNew.setLocation(p2);
	                        break;
	                    }
	                    case RIGHT: {
	                        p1.x += step;
	                        componentOld.setLocation(p1);
	                        p2.x -= step;
	                        componentNew.setLocation(p2);
	                        break;
	                    }
	                    case TOP: {
	                        p1.y -= step;
	                        componentOld.setLocation(p1);
	                        p2.y += step;
	                        componentNew.setLocation(p2);
	                        break;
	                    }
	                    case BOTTOM: {
	                        p1.y += step;
	                        componentOld.setLocation(p1);
	                        p2.y -= step;
	                        componentNew.setLocation(p2);
	                        break;
	                    }
	                    default:
	                        new RuntimeException("ProgramCheck").printStackTrace();
	                        break;
	                }
	
	                try {
	                    Thread.sleep(300 / (max / step));
	                } catch (final Exception e) {
	                    e.printStackTrace();
	                }
	            }
	            final long t1 = System.currentTimeMillis();
	            final long t = t1-t0;
	            if(timePosition == maxTime() || t>maxTime())
	            {        
	            	gameOver();   
	            }
	        }
	        componentOld.setLocation(-10000, -10000);
	        componentNew.setLocation(0, 0);
	    }
	}
	
}
