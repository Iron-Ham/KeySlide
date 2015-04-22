package views;

import java.util.ArrayList;

import javax.swing.JList;

public class HighScoresList extends JList {

	Window window;
	
	public HighScoresList(ArrayList<Integer> scores, Window window){
		super(scores.toArray());
		this.window = window;
		
	}
}
