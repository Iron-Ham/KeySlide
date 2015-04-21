package game_over.src;

import javax.swing.*;

import java.awt.*;

public class gameOver extends JFrame {
	JButton[] buttons = new JButton[3];
	JFrame frame = new JFrame();
	JPanel panel;
	JLabel label = new JLabel();

	public gameOver(String title) {
		int width = 1000;
		int height = 1200;

		// Setting the JFrame format.
		setTitle(title);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(width, height);
		setResizable(true);
		setLocationRelativeTo(null);
		setLayout(new GridBagLayout());

		// Setting one panels to display the interface of game over.
		panel = new JPanel(new GridBagLayout());
		panel.setSize(width, height);
		add(panel);
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(15, 15, 15, 5);

		// setting title of Game over
		c.gridx = 0;
		c.gridy = 0;
		c.ipady = 10; // make this component tall
		c.weightx = 0.0;
		c.anchor = GridBagConstraints.CENTER;
		JLabel label = new JLabel("Game Over");
		label.setFont(new Font("Tahoma", Font.BOLD, 60));
		panel.add(label, c);

		// setting label of score
		String k1 = "Score: ";
		c.gridx = 0;
		c.gridy = 11;
		c.ipady = 15; // make this component tall
		c.weightx = 0.5;
		c.gridwidth = 0;
		// c.weighty=5;
		// c.gridheight=20;
		c.anchor = GridBagConstraints.FIRST_LINE_START;
		// c.fill = GridBagConstraints.VERTICAL;
		label = new JLabel(k1);
		label.setFont(new Font("Tahoma", Font.PLAIN, 25));
		panel.add(label, c);

		// setting the score area
		String k21 = " score value";// score come here
		c.gridx = 1;
		c.gridy = 11;
		c.ipady = 15; // make this component tall
		c.anchor = GridBagConstraints.FIRST_LINE_START;
		label = new JLabel(k21);
		label.setFont(new Font("Tahoma", Font.PLAIN, 25));
		panel.add(label, c);

		// setting replay button and add listenner
		JButton button = new JButton("Replay");
		c.weightx = 0.5;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 27;
		c.ipady = 15;
		button.setFont(new Font("Tahoma", Font.PLAIN, 25));
		panel.add(button, c);
		// button.addActionListener("replayfuction");

		// setting go back to main page button and add listenner
		JButton button1 = new JButton("Go back to main page");
		c.weightx = 0.5;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 43;
		c.ipady = 15;
		button1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		panel.add(button1, c);
		// button.addActionListener("go back fuction");

	}

}
