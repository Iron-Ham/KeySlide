package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import utilities.ImageHelper;

public class InstructionPanel extends JPanel {
	private JLabel image;
	private JScrollPane imageView;
	Window window;
	
	public InstructionPanel(Window window) {
		setLayout(new BorderLayout());
		setBackground(Color.WHITE);
		this.window = window;
		image = new JLabel(new ImageIcon(new File("Assets/PNG/Instructions.png").toString()));
		imageView = new JScrollPane();
		imageView.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		imageView.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		imageView.setViewportView(image);
		imageView.setSize(1280, 720);		
		imageView.setPreferredSize(new Dimension(1280, 720));
		BackButton back = new BackButton(window);
		add(imageView, BorderLayout.CENTER);
		add(back, BorderLayout.NORTH);
	}
}
