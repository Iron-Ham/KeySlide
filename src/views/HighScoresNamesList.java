package views;

import java.util.ArrayList;

import javax.swing.JList;

public class HighScoresNamesList extends JList {

	Window window;
	
	public HighScoresNamesList(ArrayList<String> names, Window window){
		super(names.toArray());
		this.window = window;
		
	}
}
