package views.highscores;

import misc.Person;
import utilities.DBUtility;
import views.Window;
import views.navbuttons.BackButton;
import javax.swing.*;
import java.awt.Component;
import java.awt.Font;
import java.util.ArrayList;

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
