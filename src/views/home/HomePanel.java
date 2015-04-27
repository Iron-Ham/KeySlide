package views.home;

import views.Window;

import javax.swing.*;
import java.awt.*;

/**
 * The Home Screen for the game.
 *
 * @author heshamsalman
 */
public class HomePanel extends JPanel {
    private static final long serialVersionUID = -137351898919773110L;
    Window window;
    private Menu menu;

    /**
     * Constructor
     * @param window the main window
     */
    public HomePanel(Window window) {
        this.window = window;
        setLayout(new GridBagLayout());
        setBackground(Color.WHITE);
        menu = new Menu(window);
        menu.setBackground(Color.WHITE);
        menu.setAlignmentY(0.5f);
        menu.setAlignmentX(0.5f);
        setSize(1280, 720);
        add(menu);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        ImageIcon icon = new ImageIcon("Assets/PNG/Blue_Abstract.png");
        g.drawImage(utilities.ImageHelper.PrepareFullScreenImageIcon(icon).getImage(), 0, 0, null);
    }
}
