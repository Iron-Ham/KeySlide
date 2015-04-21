package instruction;
import javax.swing.*;

import java.awt.*;

public class InstructionFrame extends JFrame{

		public static JLabel array[] = new JLabel[4];
			
			JButton[] buttons = new JButton[4];
			ImageIcon[] icon = new ImageIcon[3]; 
			JFrame frame =new JFrame();
			JPanel panel;
			JLabel label = new JLabel();
			JTextArea area=new JTextArea(4,2);
			
		public InstructionFrame(String title){
				int width = 1000;
				int height =1200;
				
				
			// Setting the JFrame format.
				setTitle(title);
				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				setSize(width, height);
				setResizable(true);
				setLocationRelativeTo(null);
				setLayout(new GridBagLayout());
				
				

			
			// Setting two panels to display the cards and buttons, respectively.
				JPanel panel0 = new JPanel(new BorderLayout());
				add(panel0);
				panel0.setSize(width-100,height-200);
				panel = new JPanel(new GridBagLayout());
				panel.setSize(width,height);
				JScrollPane scrollPane = new JScrollPane(panel0);
				scrollPane.setViewportView(panel0); 
				scrollPane.setLocation(0, 0); 
				scrollPane.setSize(900, 720); 

				add(panel);
			    GridBagConstraints c = new GridBagConstraints();
			    c.insets =new Insets(5,5,5,5);
			    
			   //setting the title "How to play" 
			    c.gridx=0;
			    c.gridy=0;
			    c.ipady = 10;      //make this component tall
			    c.weightx = 0.0;
			    c.anchor = GridBagConstraints.CENTER;
			    JLabel label =new JLabel("How to play");
			    label.setFont(new Font("Tahoma",Font.BOLD, 25));
			    panel.add(label, c);
			    
			    //setting the rules of the game
			    String k1="The rule is simple: send the panel to the correct direction,if you can! In Dash you must press the\narrow accordingly to what is being shown within the remaining time and each round is faster than the last!";
			    c.gridx=0;
			    c.gridy=1;
			    c.ipady = 5;      //make this component tall
			    c.gridwidth =0;
			    c.anchor = GridBagConstraints.FIRST_LINE_START;
			    area=new JTextArea(k1);
			    area.setText(k1);
			    area.setBackground(Color.BLUE);
			    area.setEditable(false); 
			    area.setFont(new Font("Tahoma",Font.PLAIN,18));
			    panel.add(area, c);
			  
			    //setting the first rule title-simple arrow
			    String k21="Simple arrow";
			    c.gridx=0;
				c.gridy=39;
			    c.ipady = 20;      //make this component tall
			    c.anchor = GridBagConstraints.FIRST_LINE_START;
			    label=new JLabel(k21);
			    label.setFont(new Font("Tahoma",Font.PLAIN, 23));
			    panel.add(label, c); 
			
			   
			    //setting the simple image icon of the first rule
			    c.gridx = 0;
			    c.gridy = 40;
			    c.ipady = 20;      //make this component tall
			    c.weightx = 0.0;
			    c.gridwidth = 0;
			//	c.fill = GridBagConstraints.HORIZONTAL;
			    c.anchor = GridBagConstraints.FIRST_LINE_START;
			    icon[0] = new ImageIcon("images/1.png");
				Image img = icon[0].getImage();
				img = img.getScaledInstance(90, 90, Image.SCALE_SMOOTH);
				buttons[1] = new JButton(new ImageIcon(img));
				buttons[1].setActionCommand("images/1.png");
			    panel.add(buttons[1], c);
			  
			    //setting the first game rule-press the right direction
			    String k2="The simple arrow is the most basic and classic thing! Just press the right key\nin time and you're good.";
			    c.gridx=1;
				c.gridy=40;
			    c.ipady = 2;      //make this component tall
			    c.weightx = 0.5;
			    c.gridwidth =1;
			    area=new JTextArea(k2);
			    area.setText(k2);
			    area.setBackground(Color.BLUE);
			    area.setEditable(false);
			    area.setFont(new Font("Tahoma",Font.PLAIN, 18));
			    panel.add(area, c); 
			   
			   //setting the reverse image icon
			    c.gridx = 0;
			    c.gridy =70;
			    c.ipady = 20;      //make this component tall
			    c.weightx =0.0;
			    c.gridwidth= 1;
			    c.anchor = GridBagConstraints.FIRST_LINE_START;
			    icon[1] = new ImageIcon("images/7.png");
				Image img1 = icon[1].getImage();
				img = img1.getScaledInstance(90, 90, Image.SCALE_SMOOTH);
				buttons[2] = new JButton(new ImageIcon(img));
				buttons[2].setActionCommand("images/7.png");
			    panel.add(buttons[2], c);
			   
			    
			    // setting the reverse title
			     k21="Reverse";
			    c.gridx=0;
				c.gridy=69;
			    c.ipady = 20;      //make this component tall
			 //   c.weightx = 0;
			   // c.gridwidth =0;
			    c.anchor = GridBagConstraints.FIRST_LINE_START;
			    label=new JLabel(k21);
			    label.setFont(new Font("Tahoma",Font.PLAIN, 23));
			    panel.add(label, c); 
			
			    //setting the reverse game rule
			    String k3="It's a trap! If the background is striped, then you must take the opposite action\nthat is being shown. For instance, if the image shows a right arrow, press the\nleft key; If it shows up, then press down, and so on and so forth.";
			    c.gridx=1;
			    c.gridy=70;
			    c.ipady =2;      //make this component tall
			    c.weightx = 0.0;
			    c.gridwidth = 1;
			    area=new JTextArea(k3);
			    area.setText(k3);
			    area.setBackground(Color.BLUE);
			    area.setEditable(false);
			    area.setFont(new Font("Tahoma",Font.PLAIN, 18));
			    panel.add(area, c);
		
			    //setting the previous action image icon
			    c.gridx = 0;
			    c.gridy =100;
			    c.ipady = 20;      //make this component tall
			    c.weightx =0.0;
			    c.gridwidth= 1;		
			    c.anchor = GridBagConstraints.FIRST_LINE_START;
			    icon[1] = new ImageIcon("images/refresh.png");
				Image img2 = icon[1].getImage();
				img = img2.getScaledInstance(90, 90, Image.SCALE_SMOOTH);
				buttons[2] = new JButton(new ImageIcon(img));
				buttons[2].setActionCommand("images/refresh.png");
			    panel.add(buttons[2], c);
			  
			    //setting the previous action title
			  k21="Previous action";
			    c.gridx=0;
				c.gridy=99;
			    c.ipady = 20;      //make this component tall
			    c.anchor = GridBagConstraints.FIRST_LINE_START;
			    label=new JLabel(k21);
			    label.setFont(new Font("Tahoma",Font.PLAIN, 23));
			    panel.add(label, c); 
			
			    //setting the rule of previous action icon
			    String k4="This one may seem tricky. DASH is not only about being fast, but also being\nattentive! If you ever see a symbol like this, then it is a previous arrow! It means you\nmust repeat your last action!"; 		    
			    c.gridx=1;			    
			    c.gridy=100;
			    c.ipady =2;      //make this component tall
			    c.weightx = 0.0;
			    c.gridwidth = 1;
			    area=new JTextArea(k4);
			    area.setBackground(Color.BLUE);
			    area.setEditable(false);    // import place to change 
			    area.setText(k4);
			    area.setBackground(Color.BLUE);
			    area.setEditable(false);
			    area.setFont(new Font("Tahoma",Font.PLAIN, 18));
			    panel.add(area, c);
			   
			    //setting the no action image icon
			    c.gridx = 0;
			    c.gridy =120;
			    c.ipady = 20;      //make this component tall
			    c.weightx =0.0;
			    c.gridwidth= 1;		
			    c.anchor = GridBagConstraints.FIRST_LINE_START;
			    icon[1] = new ImageIcon("images/stop.png");
				img2 = icon[1].getImage();
				img = img2.getScaledInstance(90, 90, Image.SCALE_SMOOTH);
				buttons[2] = new JButton(new ImageIcon(img));
				buttons[2].setActionCommand("images/stop.png");
			    panel.add(buttons[2], c);
			   
			    //setting the title of no action
			    String k6="No action";
			    c.gridx=0;
				c.gridy=119;
			    c.ipady = 20;      //make this component tall
			    c.anchor = GridBagConstraints.FIRST_LINE_START;
			    label=new JLabel(k6);
			    label.setFont(new Font("Tahoma",Font.PLAIN, 23));
			    panel.add(label, c); 
			
			    //setting the rule of no action
			    String k5="Can not press any key! if you press any key, the game is over!"; 		    
			    c.gridx=1;			    
			    c.gridy=120;
			    c.ipady =2;      //make this component tall
			    c.weightx = 0.0;
			    c.gridwidth = 1;
			    area=new JTextArea(k5);
			    area.setText(k5);
			    area.setBackground(Color.BLUE);
			    area.setEditable(false);
			    area.setFont(new Font("Tahoma",Font.PLAIN, 18));
			    panel.add(area, c);
			    
			    //setting the go back button.
			    JButton button = new JButton("Go Back");
			    c.weightx = 0.5;
			    c.fill = GridBagConstraints.HORIZONTAL;
			    c.gridx = 1;
			    c.gridy = 121;
			    panel.add(button, c);
			   // button.addActionListener("gobackfuction");


			       
		}	
//			public JButton[] getButtons(){
//
//				return buttons;
//			}

	}

	


