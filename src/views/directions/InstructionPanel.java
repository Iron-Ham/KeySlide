package views.directions;

import views.navbuttons.BackButton;
import javax.swing.*;
import java.awt.*;
import java.io.File;

/**
 * The panel which contains instructions for the user.
 *
 * @author heshamsalman
 */
public class InstructionPanel extends JPanel {
    private static final long serialVersionUID = 8337054250198837572L;

    /**
     * Constructor
     */
    public InstructionPanel() {
        setupGui();
    }

    /**
     * Sets up the GUI for this Panel
     */
    private void setupGui() {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);
        JLabel image;
        image = new JLabel(new ImageIcon(new File("Assets/PNG/Instructions.png").toString()));
        JScrollPane imageView;
        imageView = new JScrollPane();
        imageView.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        imageView.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        imageView.setViewportView(image);
        imageView.setSize(1280, 720);
        imageView.setPreferredSize(new Dimension(1280, 720));
        BackButton back = new BackButton();
        add(imageView, BorderLayout.CENTER);
        add(back, BorderLayout.NORTH);
    }
}
