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
import javax.swing.border.EmptyBorder;

public class myMenuBar_player extends JMenuBar {
	
	/***
	 * p
	 */
		// layout of the window
			private BorderLayout layout = new BorderLayout(0, 0);
		// size of the window	
			private int sizeX;
			private int sizeY;
		// content of the menu
			private myButton buttonPlayerAction = new myButton("PLAYER ACTION");
			//private JPanel panelName = new JPanel();
	/***
	 * c
	 */
	
		public myMenuBar_player() {
			/*
			 * configuring look
			 */
				
				//this.setSizeX(50);
				//this.setSizeY(25);
				//this.setPreferredSize(new Dimension(this.sizeX, this.sizeY));
				this.setLayout(layout);
				this.setBackground(null);
			/*
			 * adding buttons and elements
			 */
				this.add(buttonPlayerAction, BorderLayout.WEST);
				//this.add(panelName, BorderLayout.CENTER);
					//panelName.setBackground(LDZF.colorBaseBrown);
					//panelName.setLayout(new FlowLayout(FlowLayout.LEFT));
			
		}

	/***
	 * m
	 */
		
		public int getSizeX() {
			return sizeX;
		}
	
		public void setSizeX(int sizeX) {
			this.sizeX = sizeX;
		}
		
		public int getSizeY() {
			return sizeY;
		}

		public void setSizeY(int sizeY) {
			this.sizeY = sizeY;
		}
}
