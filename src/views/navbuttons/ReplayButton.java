package views.navbuttons;

import views.Window;

import java.awt.event.ActionEvent;

/**
 * Replay Button allows user to replay game
 *
 * @author heshamsalman
 */
public class ReplayButton extends NavigationButton {
    private static final long serialVersionUID = -8928983203121047464L;
    Window window;

    /**
     * Constructor
     * @param window the main window
     */
    public ReplayButton(Window window) {
        this.window = window;
        setText("Replay");
        initializeComponents();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        window.switchToGame();
    }
}
