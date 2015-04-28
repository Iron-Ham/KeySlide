package driver;

import views.Window;
import javax.swing.*;

/**
 * Requirements: Java 1.8
 * - Uses interface default methods
 * Main driver class. Run this to start the program.
 *
 * @author heshamsalman
 */
public class Main {
    public static void main(String[] args) {
        Window window = new Window();
        //noinspection MagicConstant
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }
}
