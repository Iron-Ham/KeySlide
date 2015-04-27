package misc;

/**
 * Java representation of model for "Person"
 * Allows for easy data entry into the database.
 *
 * Refactored and Documented: heshamsalman 04/23/15
 * @author troyjohnson
 */
public class Person {
    private String name;
    private int score;
    private String date;

    /**
     * Constructor
     * @param name the user's name
     * @param score the user's score
     * @param date the date of play
     */
    public Person(String name, int score, String date) {
        this.name = name;
        this.score = score;
        this.date = date;
    }

    /**
     * getter method for the date
     * @return date
     */
    public String getDate() {
        return date;
    }

    /**
     * setter method for date
     * @param date the new value of date
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * getter method for name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * setter method for name
     * @param name the new value for name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * getter method for score
     * @return score
     */
    public int getScore() {
        return score;
    }

    /**
     * setter method for score
     * @param score the new value of score
     */
    public void setScore(int score) {
        this.score = score;
    }

}
