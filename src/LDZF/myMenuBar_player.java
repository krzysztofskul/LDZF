package LDZF;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

public class myMenuBar_player extends JMenuBar {
	
	/***
	 * p
	 */
		// layout of the menu bar
			private BorderLayout layout = new BorderLayout(0, 0);
		// size of the window	
			private int sizeX;
			private int sizeY;
		// content of the menu
			//menu button
				private myButton buttonPlayerAction = new myButton("PLAYER ACTION");
				private myMenuPlayer menu = new myMenuPlayer();

			//name of the player
				private JPanel panelName = new JPanel();
				private JLabel labelName = new JLabel();
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
				this.setBorder(null);
				//this.setBackground(Color.WHITE);
			/*
			 * adding buttons and elements to menu bar
			 */
				//this.add(buttonPlayerAction, BorderLayout.WEST);
				this.add(menu, BorderLayout.WEST);

				this.add(panelName, BorderLayout.CENTER);
					panelName.setBackground(null);
					panelName.setBorder(null);
					panelName.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
					panelName.add(labelName);		
						labelName.setBorder(new EmptyBorder(2,2,2,2));
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

		public JLabel getLabelName() {
			return labelName;
		}

		public void setLabelName(String x) {
			this.labelName.setText(x);;
		}
		
		
}
