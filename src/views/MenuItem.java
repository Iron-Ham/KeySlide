package views;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

import utilities.Colors;

public class MenuItem extends JLabel{
	public MenuItem(String text) {
		this.setText(text);
		this.setForeground(new Color(Colors.unselected()));
	}
}
