package views.game;

import instruction.InstructionController;

/**
 * Produces DirectionPanels of various types based on current instruction.
 *
 * @author heshamsalman
 */
public class DirectionPanelFactory {
    private static InstructionController instrControl = InstructionController.getInstance();
    private static ReverseDirectionPanel rp = new ReverseDirectionPanel();
    private static SimpleDirectionPanel sp = new SimpleDirectionPanel();

    /**
     * Returns the next panel based on the value of reverse
     * @return DirectionPanel
     */
    public static DirectionPanel getNextPanel() {
        instrControl.nextInstruction();
        if (instrControl.isReversed())
            return rp;
        else {
            return sp;
        }
    }
}
