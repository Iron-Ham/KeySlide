package views.game;

public class DownLabel extends InstructionLabel {
    private static final long serialVersionUID = 1L;

    public DownLabel() {
        super();
        setText(">");
        setUI(new VerticalLabelUI(true));
    }
}
