package utilities;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import misc.Person;

public class DataBaseUtility {

	static Connection c = null;

	/**
	 * Inserts record into database of user how achieved a high score
	 * @param name Username of user who achieved high score
	 * @param date Date high score was achieved
	 * @param score Score user achieved
	 * @param time Total time user lasted (another measure of high score?)
	 */
	public static void insertNewHighScore(String name, String date, int score, int time) {
		if (connectToDb()) { // Change in case connection to db fails

			Statement stmt = null;
			try {
				stmt = c.createStatement();
				String sql = "INSERT INTO hiscores (name,date,score,time) VALUES('" + name + "','" + date + "',"
						+ Integer.toString(score) + "," + Integer.toString(time) + ");";
				stmt.execute(sql);
				stmt.close();
				c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println("Error connecting to database");
		}
	}

	public static ArrayList<Person> getHighScores() {
		ArrayList<Person> people = new ArrayList<Person>();

		if (connectToDb()) { // Change in case connection to db fails
			String sql = "SELECT * FROM hiscores ORDER BY score DESC LIMIT 5;";
			Statement stmt = null;

			try {
				ResultSet rs = null;
				stmt = c.createStatement();
				rs = stmt.executeQuery(sql);

				while (rs.next()) {
					people.add(new Person(rs.getString("name"), rs.getInt("score")));
				}
			} catch (Exception e) {
				System.out.println("Error retrieving high scores from database!");
			}
		} else {
			System.out.println("Error connecting to database");
		}
		return people;
	}

	/**
	 * Attempts to connects to the sqlite lite database called hiscores.db that contains
	 * information on the hi score.
	 * @return Returns true if successfully connects to the database, false otherwise.
	 */
	public static boolean connectToDb() {
		try {
			c = DriverManager.getConnection("jdbc:sqlite:hiscores.db");
			return true;
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
			return false;
		}

	}
}
