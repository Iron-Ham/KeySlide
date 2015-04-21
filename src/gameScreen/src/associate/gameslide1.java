package gameScreen.src.associate;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import java.util.Random;

public class gameslide1<ParentType extends Container> implements KeyListener {
	private static int height                            = 660;
	private static int width                             = 1100;	   // height and width are defined for the basePanel
	private static final int           RIGHT             = 0x01;
	private static final int           LEFT              = 0x02;
	private static final int           TOP               = 0x03;
	private static final int           BOTTOM            = 0x04;
	private final static JPanel        basePanel         = new JPanel();
	private final ParentType           parent;
	private final Object               lock              = new Object();
	private final ArrayList<Component> jPanels           = new ArrayList<Component>();
	private boolean                    isSlideInProgress = false;
	private static JLabel[]            labels            = new JLabel[20];
	private static int                 score             = 0;
	private static JButton             button            = new JButton("Score: 0");	
	private static JProgressBar        timebar;
	private static Random              randomGenerator   = new Random();	
	private static int progress =0, minvalue = 0, maxvalue = 1000, delay=10;
	private static Timer bartime;
	private static  int initvalue =(int)maxvalue/5;
	private static  int endvalue = maxvalue-initvalue;
	
	public gameslide1(final ParentType parent) {
	    if (parent == null) {
	        throw new RuntimeException("ProgramCheck: Parent can not be null.");
	    }
	    if ((parent instanceof JFrame) || (parent instanceof JDialog) || (parent instanceof JWindow) || (parent instanceof JPanel)) {
	    }
	    else {
	        throw new RuntimeException("ProgramCheck: Parent type not supported. " + parent.getClass().getSimpleName());
	    }
	    this.parent = parent;
	    basePanel.setSize(parent.getSize());       // basePanel is the main panel
	    basePanel.setLayout(new BorderLayout());
	    basePanel.addKeyListener(this);
	    basePanel.setFocusable(true);
	    basePanel.setFocusTraversalKeysEnabled(false);   
	    
	    final JPanel statusPanel = new JPanel();      //statusPanel is defined to put the timebar
	    statusPanel.setBackground(Color.GRAY);
	    timebar = new JProgressBar();
	    statusPanel.add(timebar);
	    timebar.setPreferredSize(new Dimension(width,40));
	    timebar.setMinimum(minvalue);
		timebar.setMaximum(maxvalue);
	    timebar.setForeground(new Color(0xFF0000)); 
		timebar.setBackground(Color.WHITE);
		bartime=new Timer(delay,new ActionListener(){
			  public void actionPerformed(ActionEvent e)
			  {
				  timebar.setValue(progress);
				  if (progress<initvalue || progress>endvalue)
					  progress = progress+5;
				  else if (progress>initvalue &&progress < 2*initvalue || progress > (endvalue-initvalue) && progress < endvalue)
					  progress = progress+8;
				  else if (progress>2*initvalue && progress < 3*initvalue || progress>(endvalue-2*initvalue) && progress< (endvalue-initvalue))
					  progress = progress+15 ;
				  else if (progress> 3*initvalue&&progress< 4*initvalue|| progress>(endvalue-3*initvalue)&&progress<(endvalue-2*initvalue))
					  progress = progress+20;
				  else
					  progress = progress+14;
				  if (timebar.getValue ()>=990){
					  progress=0;
					  timebar.setValue(progress);
					  bartime.stop();
					  gameOver();
				  }
			  	}
			  });	
		bartime.start();
	    
	    button.setPreferredSize(new Dimension(100, 30));                //button is put at the NORTH of the basePanel, it is defined to show the score
	    button.setFont(new Font("Arial", Font.PLAIN, 40));
	    button.setEnabled(false);
	    button.setVisible(true); 
	    basePanel.add(button,BorderLayout.NORTH);   
	    basePanel.add(statusPanel, BorderLayout.SOUTH);   
   }
	
	public void keyPressed(KeyEvent e)             //key handler
	{
		 
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
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub	
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub      	
	}
	public JPanel getBasePanel() {
	    return basePanel;
	}
	
	/* add component to jPanels, put the first added component into the basePanel*/
	public void addComponent(final Component component) {
	    if (jPanels.contains(component)) {
	    }
	    else {
	        jPanels.add(component);
	        if (jPanels.size() == 1) {
	            basePanel.add(component);   
	        }
	        component.setSize(basePanel.getSize());
	        component.setLocation(0, 0);
	    }
	}
	
	public void removeComponent(final Component component) {
	    if (jPanels.contains(component)) {
	        jPanels.remove(component);
	    }
	}
	
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
	        	   startTimer();  	   	   
	         }
	        if (slideType == TOP) {            
	            if (i != 1 && i!=5)
	            	gameOver();
	            else
	            	startTimer();
	        }
	        if (slideType == RIGHT) {
	            if (i != 3 && i!=7)
	            	gameOver();
	            else
	            	startTimer();
	        }
	        if (slideType == BOTTOM) {
	            if (i != 2 && i!=6)
	            	gameOver();
	            
	            else
	            	startTimer();
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
	            step = (int) (((float) parent.getWidth() / (float) Toolkit.getDefaultToolkit().getScreenSize().width) * 40.f);
	        }
	        else {
	            step = (int) (((float) parent.getHeight() / (float) Toolkit.getDefaultToolkit().getScreenSize().height) * 30.f);
	        }
	        step = step < 5 ? 5 : step;
	        basePanel.add(componentNew);
	        basePanel.revalidate();
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
	            if(progress == 1000 || t>1000)
	            {        
	            	gameOver();   
	            }
	        }
	        componentOld.setLocation(-10000, -10000);
	        componentNew.setLocation(0, 0);
	    }
	}
	
	static public void gameOver(){
		   basePanel.setFocusable(false);   //need to switch to the game over screen.
		   bartime.stop();
		   timebar.setValue(0);
		   timebar.setFocusable(false);
	}
	
	static public void startTimer(){
		  score+=1;
	 	  button.setText("Score:"+score);
	 	  progress = 0;
	 	  bartime.start();
	}	
	
	
	/*In the main function, we initialize the gameslide1 class. We add 8 images to the labels list 
	 * and add these labels into the jPanels list, which is defined for the basePanel in the gameslide1 
	 * class, when the Panel slide in the frame, panels in the jPanels list will be added into the 
	 * basePanel randomly.*/
	static public void main(final String[] args) throws Exception {
	    SwingUtilities.invokeAndWait(new Runnable() {
	        @Override
	        public void run() {
	            final JFrame jFrame = new JFrame() {
	                {
	                    final gameslide1<JFrame> slider = new gameslide1<JFrame>(this);
	                    final JPanel jPanel = slider.getBasePanel();                 
	                    String[] imageNames = {"1.png","2.png","3.png","4.png","5.png","6.png","7.png","8.png"};	
	            		String imageFolder = "images/";
	            		for(int i = 0; i < imageNames.length;i++)
	            		{	
	            		ImageIcon icon = new ImageIcon(imageFolder+imageNames[i]);
	            	    Image img = icon.getImage();
	            	    labels[i] = new JLabel(new ImageIcon(img));
	            	    labels[i].setName(imageNames[i]);
	            	    labels[i].setSize(width,height);
	            	    
	            	    slider.addComponent(labels[i]);
	            		}
	                     getContentPane().add(jPanel);
	                     setSize(width, height);
	                     setLocationRelativeTo(null);
	                     setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	                     setVisible(true);
	                     setResizable(false);
	            		}
	                };
	        }
	   
	    });
	}
}

