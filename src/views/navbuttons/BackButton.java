package views.navbuttons;

import views.Window;

import java.awt.event.ActionEvent;

/**
 * Back Button allows user to go back to home page when clicked.
 *
 * @author heshamsalman
 */
public class BackButton extends NavigationButton {
    private static final long serialVersionUID = 45768139147924018L;

    /**
     * Constructor
     */
    public BackButton() {
        setText("Home");
        initializeComponents();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Window.switchToHome();
    }
}
