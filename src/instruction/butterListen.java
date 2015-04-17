package instruction;
	/**
	 * This button click handler according to the button
	 * command then display three views.
	 */
	import javax.swing.*;

	import java.awt.event.*;

	public class butterListen implements ActionListener{
		InstructionFrame frame;
		public butterListen(InstructionFrame frameIn){
			frame = frameIn;		
		}
		
		public void actionPerformed(ActionEvent ev) {
			Object source = ev.getSource();
			if(source instanceof JButton){
				JButton btn = (JButton) source;
				String message = btn.getActionCommand();
				String[] bu={"Go Back"};
				
				//if Start is clicked, then show labels which designed by str1
				if (message==bu[0]){
					System.out.println("I am here");
				
				}
			}
		}
	

}
