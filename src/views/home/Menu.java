package views.home;

import utilities.GameLog;
import views.Window;
import views.navbuttons.MenuItem;

import javax.swing.*;
import java.awt.*;

/**
 * The Menu. This houses all menu items.
 *
 * @author heshamsalman
 */
public class Menu extends JPanel {
    private static final long serialVersionUID = -6758351920150177724L;
    private MenuItem start;
    private MenuItem hiScores;
    private MenuItem instructions;

    public Menu() {
        setupGui();
    }

    /**
     * Sets up GUI elements.
     */
    private void setupGui() {
        setOpaque(false);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        start = new MenuItem("Start");
        start.setSize(150, 120);
        hiScores = new MenuItem("Hi-Scores");
        hiScores.setSize(150, 120);
        instructions = new MenuItem("Instructions");
        instructions.setSize(150, 120);
        attachListeners();
        JLabel title = new JLabel("Key Slide");
        title.setFont(new Font("Arial", Font.BOLD, 64));
        title.setForeground(Color.WHITE);
        add(title);
        add(Box.createRigidArea(new Dimension(10, 150)));
        add(start);
        add(Box.createRigidArea(new Dimension(5, 25)));
        add(hiScores);
        add(Box.createRigidArea(new Dimension(5, 25)));
        add(instructions);
    }

    /**
     * Attaches action listeners to buttons.
     * This is what allows switching from panel to panel on click.
     */
    private void attachListeners() {
        GameLog.log.entering(getClass().getName(), "attachListeners");
        start.addActionListener(e -> Window.switchToGame());
        hiScores.addActionListener(e -> Window.switchToHiScores());
        instructions.addActionListener(e -> Window.switchToInstructions());
        GameLog.log.exiting(getClass().getName(), "attachListeners");

    }
}
