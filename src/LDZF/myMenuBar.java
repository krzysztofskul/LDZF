package LDZF;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class myMenuBar extends JMenuBar {
	
	/***
	 * p
	 */
		// layout of the menu bar
			private BorderLayout layout = new BorderLayout(5, 5);
		// size of the window
			private int sizeY;
		// content of the menu
			private myButton buttonMenuFull = new myButton("MENU");
			private JPanel panelName = new JPanel();
				private JLabel windowName = new JLabel("FIRST GAME PROJECT: 'LDZF'");
			private myButton buttonMenuExit = new myButton("EXIT");
			
		

	/***
	 * c
	 */
	
		public myMenuBar() {
			/*
			 * configuring look
			 */
				this.setSizeY(25);
				this.setLayout(layout);
				this.setBackground(LDZF.colorBaseBrown);
				this.setBorder(null);
			/*
			 * adding buttons and elements
			 */
				this.add(buttonMenuFull, BorderLayout.WEST);
				this.add(panelName, BorderLayout.CENTER);
					panelName.setBackground(LDZF.colorBaseBrown);
					panelName.setLayout(new FlowLayout(FlowLayout.LEFT));
					panelName.add(windowName);
						windowName.setBackground(null);
						windowName.setBorder(null);
						windowName.setForeground(Color.WHITE);
				this.add(buttonMenuExit, BorderLayout.EAST);
			
		}

	/***
	 * m
	 */
		public int getSizeY() {
			return sizeY;
		}
	
		public void setSizeY(int sizeY) {
			this.sizeY = sizeY;
		}
}
