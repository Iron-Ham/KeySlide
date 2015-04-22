package utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import misc.Person;

public class DBUtility {

	static Connection c = null;

	/**
	 * Inserts record into database of user how achieved a high score
	 * 
	 * @param name
	 *            Username of user who achieved high score
	 * @param date
	 *            Date high score was achieved
	 * @param score
	 *            Score user achieved
	 * @param time
	 *            Total time user lasted (another measure of high score?)
	 */
	public static void insertNewHighScore(String name, String date, int score) {
		if (connectToDb()) { // Change in case connection to db fails

			Statement stmt = null;
			try {
				stmt = c.createStatement();
				String sql = "INSERT INTO hiscores (name,date,score) VALUES('" + name + "','" + date + "',"
						+ Integer.toString(score) + ");";
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
		try {
			c.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static ArrayList<Person> getHighScores() {
		ArrayList<Person> people = new ArrayList<Person>();

		if (connectToDb()) {
			String sql = "SELECT * FROM hiscores ORDER BY score DESC LIMIT 10;";
			Statement stmt = null;

			try {
				ResultSet rs = null;
				stmt = c.createStatement();
				rs = stmt.executeQuery(sql);

				while (rs.next()) {
					people.add(new Person(rs.getString("name"), rs.getInt("score"), rs.getString("date")));
				}
			} catch (Exception e) {
				System.out.println("Error retrieving high scores from database!");
			}
		} else {
			System.out.println("Error connecting to database");
		}
		try {
			c.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return people;
	}

	/**
	 * Attempts to connects to the sqlite lite database called hiscores.db that
	 * contains information on the hi score.
	 * 
	 * @return Returns true if successfully connects to the database, false
	 *         otherwise.
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

	/**
	 * Checks score value passed in against database to see if score is within
	 * the top 10 highest scores so far obtained for the game.
	 * 
	 * @return Returns true score is a high score, false returned otherwise.
	 */

	public static boolean isHighScore(int score) {
		int tenthScore = -1;
		if (connectToDb()) { // Change in case connection to db fails
			String sql = "SELECT DISTINCT score FROM hiscores ORDER BY score DESC LIMIT 1 OFFSET 9";
			Statement stmt = null;
			try {
				ResultSet rs = null;
				stmt = c.createStatement();
				rs = stmt.executeQuery(sql);

				while (rs.next()) {
					tenthScore = rs.getInt("score");
				}
			} catch (Exception e) {
				System.out.println("Error retrieving high scores from database!");
			}
		} else {
			System.out.println("Error connecting to database");
			return false;
		}
		try {
			c.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (score > tenthScore)
			return true;
		return false;
	}
}
