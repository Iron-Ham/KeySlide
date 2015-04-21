package views;
import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.JLabel;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.JButton;

import utilities.DBUtility;
import misc.Person;

import java.awt.Font;

public class HighScoresPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	public HighScoresPanel() {
		ArrayList<Person> people = DBUtility.getHighScores();
		setUpGui(people);

	}

	private void setUpGui(ArrayList<Person> people) {
		ArrayList<String> names = new ArrayList<>();
		ArrayList<Integer> scores = new ArrayList<>();
		ArrayList<Integer> times = new ArrayList<>();
		ArrayList<String> dates = new ArrayList<>();

		for (Person person : people) {
			names.add(person.getName());
			scores.add(person.getScore());
			times.add(person.getTime());
			dates.add(person.getDate());
		}

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 71, 31, 44, 44, 38, 46, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 37, 110, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel lblNames = new JLabel("Name");
		lblNames.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_lblNames = new GridBagConstraints();
		gbc_lblNames.insets = new Insets(0, 0, 5, 5);
		gbc_lblNames.gridx = 0;
		gbc_lblNames.gridy = 0;
		add(lblNames, gbc_lblNames);

		JLabel lblScore = new JLabel("Score");
		lblScore.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_lblScore = new GridBagConstraints();
		gbc_lblScore.insets = new Insets(0, 0, 5, 5);
		gbc_lblScore.gridx = 3;
		gbc_lblScore.gridy = 0;
		add(lblScore, gbc_lblScore);

		JLabel lblTime = new JLabel("Time");
		lblTime.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_lblTime = new GridBagConstraints();
		gbc_lblTime.insets = new Insets(0, 0, 5, 5);
		gbc_lblTime.gridx = 5;
		gbc_lblTime.gridy = 0;
		add(lblTime, gbc_lblTime);

		JLabel lblDate = new JLabel("Date");
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_lblDate = new GridBagConstraints();
		gbc_lblDate.insets = new Insets(0, 0, 5, 0);
		gbc_lblDate.gridx = 7;
		gbc_lblDate.gridy = 0;
		add(lblDate, gbc_lblDate);

		JList namesList = new JList(names.toArray());
		namesList.setFont(new Font("Tahoma", Font.PLAIN, 14));

		GridBagConstraints gbc_namesList = new GridBagConstraints();
		gbc_namesList.gridwidth = 3;
		gbc_namesList.fill = GridBagConstraints.BOTH;
		gbc_namesList.insets = new Insets(0, 0, 5, 5);
		gbc_namesList.gridx = 0;
		gbc_namesList.gridy = 1;
		add(namesList, gbc_namesList);

		JList scoresList = new JList(scores.toArray());
		scoresList.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_scoresList = new GridBagConstraints();
		gbc_scoresList.gridwidth = 2;
		gbc_scoresList.fill = GridBagConstraints.BOTH;
		gbc_scoresList.insets = new Insets(0, 0, 5, 5);
		gbc_scoresList.gridx = 3;
		gbc_scoresList.gridy = 1;
		add(scoresList, gbc_scoresList);
		JList timesList = new JList(times.toArray());
		timesList.setFont(new Font("Tahoma", Font.PLAIN, 14));

		GridBagConstraints gbc_timesList = new GridBagConstraints();
		gbc_timesList.gridwidth = 2;
		gbc_timesList.fill = GridBagConstraints.BOTH;
		gbc_timesList.insets = new Insets(0, 0, 5, 5);
		gbc_timesList.gridx = 5;
		gbc_timesList.gridy = 1;
		add(timesList, gbc_timesList);
		JList datesList = new JList(dates.toArray());
		datesList.setFont(new Font("Tahoma", Font.PLAIN, 14));

		GridBagConstraints gbc_datesList = new GridBagConstraints();
		gbc_datesList.insets = new Insets(0, 0, 5, 0);
		gbc_datesList.fill = GridBagConstraints.BOTH;
		gbc_datesList.gridx = 7;
		gbc_datesList.gridy = 1;
		add(datesList, gbc_datesList);

		JButton btnMainMenu = new JButton("Main Menu");
		GridBagConstraints gbc_btnMainMenu = new GridBagConstraints();
		gbc_btnMainMenu.gridwidth = 4;
		gbc_btnMainMenu.insets = new Insets(0, 0, 0, 5);
		gbc_btnMainMenu.gridx = 2;
		gbc_btnMainMenu.gridy = 2;
		add(btnMainMenu, gbc_btnMainMenu);
	}
}
