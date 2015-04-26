package views.game;

import javax.swing.JLabel;

import java.awt.*;

/**
 * The abstract implementation of an instruction label.
 * Created by heshamsalman on 4/26/15.
 */
public abstract class InstructionLabel extends JLabel {
	private static final long serialVersionUID = 1L;
	
	/**
     * Default constructor.
     */
    public InstructionLabel() {
        super();
        setFont(new Font("Arial", Font.PLAIN, 512));
    }
}
