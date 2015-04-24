package driver;

import javax.swing.JFrame;
import views.Window;

public class Main {

	public static void main(String[] args) {
		Window window = new Window();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
	}

}
