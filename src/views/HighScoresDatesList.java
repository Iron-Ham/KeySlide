package views;

import java.util.ArrayList;

import javax.swing.JList;

public class HighScoresDatesList extends JList {

	Window window;
	
	public HighScoresDatesList(ArrayList<String> dates, Window window){
		super(dates.toArray());
		this.window = window;
		
	}
}
