package views;

import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.JButton;

import utilities.DBUtility;
import misc.Person;

import java.awt.Font;

import javax.swing.table.DefaultTableModel;
import javax.swing.BoxLayout;
import java.awt.Component;

public class HighScoresPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	Window window;
	ArrayList<Person> people;

	public HighScoresPanel(Window window) {
		this.window = window;
		people = DBUtility.getHighScores();
		setUpGui(people);
	}

	public void updateSelf() {
		people = DBUtility.getHighScores();
		removeAll();
		setUpGui(people);
	}

	private void setUpGui(ArrayList<Person> people) {
		ArrayList<String> names = new ArrayList<>();
		ArrayList<Integer> scores = new ArrayList<>();
		ArrayList<String> dates = new ArrayList<>();

		for (Person person : people) {
			names.add(person.getName());
			scores.add(person.getScore());
			dates.add(person.getDate());
		}
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		JLabel title = new JLabel("High Scores");
		title.setAlignmentX(Component.CENTER_ALIGNMENT);
		title.setFont(new Font("Arial", Font.BOLD, 64));
		add(title);

		JTable table = new HighScoresTablePanel(names, scores, dates);
		table.setFont(new Font("Tahoma", Font.BOLD, 24));
		add(new JScrollPane(table));

		JButton btnMainMenu = new BackButton(window);
		btnMainMenu.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(btnMainMenu);

	}
}
