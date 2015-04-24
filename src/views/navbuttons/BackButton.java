package views.navbuttons;

import java.awt.event.ActionEvent;

import views.Window;

/**
 * Back Button allows user to go back to home page when clicked. 
 * @author heshamsalman
 *
 */
public class BackButton extends NavigationButton {
	private static final long serialVersionUID = 45768139147924018L;
	Window window;

	public BackButton(Window window) {
		this.window = window;
		setText("Home");
		initializeComponents();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		window.switchToHome();
	}
}
