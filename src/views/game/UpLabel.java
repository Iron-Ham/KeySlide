package views.game;


/**
 * Label for the up direction.
 *
 * @author heshamsalman
 */
public class UpLabel extends InstructionLabel {
    private static final long serialVersionUID = 1L;

    public UpLabel() {
        super();
        setText("<");
        setUI(new VerticalLabelUI(true));
    }
}
