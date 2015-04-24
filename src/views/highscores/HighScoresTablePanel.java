package views.highscores;

import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class HighScoresTablePanel extends JTable {
	private static final long serialVersionUID = 6377134766161597876L;
	final String[] columnNames = {};
	final Object[] ranks = {1,2,3,4,5,6,7,8,9,10};
	public HighScoresTablePanel(ArrayList<String> names, ArrayList<Integer> scores, ArrayList<String> dates) {
		DefaultTableModel model = new DefaultTableModel(columnNames, 0);
		model.addColumn("Rank", ranks);
		model.addColumn("Name", names.toArray());
		model.addColumn("Score", scores.toArray());
		model.addColumn("Date", dates.toArray());
		setRowHeight(54);
		setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		this.setModel(model);
	}
}
