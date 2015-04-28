package views.navbuttons;

import utilities.Colors;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;

/**
 * The abstract class defining behavior for navigation buttons.
 *
 * @author heshamsalman
 */
public abstract class NavigationButton extends JButton implements ActionListener, MouseListener {
    private static final long serialVersionUID = 8971973612959800330L;

    /**
     * Should be ran at initialization of the concrete class.
     * Initializes all components of the abstract class.
     */
    protected void initializeComponents() {
        addListeners();
        setupLookAndFeel();
    }

    /**
     * Adds appropriate listeners
     */
    private void addListeners() {
        addActionListener(this);
        addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
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
            this.setForeground(Colors.selected());
        }
        this.updateUI();
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == this) {
            this.setForeground(Colors.unselected());
        }
        this.updateUI();
    }

    /**
     * Sets up UI Feel
     */
    private void setupLookAndFeel() {
        setFont(new Font("Arial", Font.PLAIN, 40));
        setContentAreaFilled(false);
        setFocusPainted(false);
        setBorder(BorderFactory.createEmptyBorder());
        setForeground(Colors.unselected());
    }

}
