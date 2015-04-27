package views.game;

import instruction.InstructionController;

/**
 * Produces DirectionPanels of various types based on current instruction.
 *
 * @author heshamsalman
 */
public class DirectionPanelFactory {
    private static InstructionController instrControl = InstructionController.getInstance();

    public static DirectionPanel getNextPanel() {
        instrControl.nextInstruction();
        if (instrControl.isReversed())
            return new ReverseDirectionPanel();
        else {
            return new SimpleDirectionPanel();
        }

    }

}
