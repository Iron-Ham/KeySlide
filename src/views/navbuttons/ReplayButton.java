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

    /**
     * Constructor
     */
    public ReplayButton() {
        setText("Replay");
        initializeComponents();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Window.switchToGame();
    }
}
