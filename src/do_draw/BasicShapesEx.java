package do_draw;
import java.awt.EventQueue;

import javax.swing.JFrame;

public class BasicShapesEx extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BasicShapesEx() {

        initUI();
    }
    
    private void initUI() {
        
        add(new Surface());
        
        setTitle("Basic shapes");
        setSize(350, 250);
        setLocationRelativeTo(null);        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                BasicShapesEx ex = new BasicShapesEx();
                ex.setVisible(true);
            }
        });
    }
}