package views.home;

import utilities.Colors;
import views.Window;

import javax.swing.*;
import java.awt.GridBagLayout;
import java.awt.Color;

/**
 * The Home Screen for the game.
 *
 * @author heshamsalman
 */
public class HomePanel extends JPanel {
    private static final long serialVersionUID = -137351898919773110L;
    Window window;

    /**
     * Constructor
     * @param window the main window
     */
    public HomePanel(Window window) {
        this.window = window;
        setLayout(new GridBagLayout());
        setBackground(Color.WHITE);
        Menu menu = new Menu();
        setBackground(Colors.getRandomColorFamily()[2]);
        menu.setBackground(Color.WHITE);
        menu.setAlignmentY(0.5f);
        menu.setAlignmentX(0.5f);
        setSize(1280, 720);
        add(menu);
    }
}
