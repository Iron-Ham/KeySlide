package views.navbuttons;

import utilities.Colors;
import views.Window;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Menu Items are JButtons that allow the user to go to different panels of the game.
 *
 * @author heshamsalman
 */
public class MenuItem extends JButton implements MouseListener {
    private static final long serialVersionUID = 3699142395262583263L;

    /**
     * Constructor
     * @param text the display text of this menu item
     */
    public MenuItem(String text) {
        setText(text);
        setActionCommand(text);
        addMouseListener(this);
        setupGui();
    }

    /**
     * Sets up the GUI for this element
     */
    private void setupGui() {
        setFont(new Font("Arial", Font.PLAIN, 40));
        setMaximumSize(new Dimension(400, 100));
        setContentAreaFilled(false);
        setFocusPainted(false);
        setBorder(BorderFactory.createEmptyBorder());
        setForeground(Colors.unselected());
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == this) {
            setForeground(Colors.selected());
        }
        updateUI();
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == this) {
            setForeground(Colors.unselected());
        }
        updateUI();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }
}
