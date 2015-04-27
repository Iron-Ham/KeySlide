package misc;

/**
 * Java representation of model for "Person"
 * Allows for easy data entry into the database.
 *
 * @author troyjohnson
 *         Refactored and Documented: heshamsalman 04/23/15
 */
public class Person {
    private String name;
    private int score;
    private String date;

    public Person(String name, int score, String date) {
        this.name = name;
        this.score = score;
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

}
