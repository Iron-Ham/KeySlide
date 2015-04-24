package views.navbuttons;

import java.awt.event.ActionEvent;

import views.Window;

/**
 * Replay Button allows user to replay game
 * @author heshamsalman
 *
 */
public class ReplayButton extends NavigationButton {
	private static final long serialVersionUID = -8928983203121047464L;
	Window window;
	
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
