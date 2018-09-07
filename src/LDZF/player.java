package LDZF;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;

public class player extends JPanel {

	/**
	 * parameters/features
	 */
		/*
		 * panel parameters construction
		 */
			private int sizeX = 220, sizeY = 145;
			private Border border = new MatteBorder(1,1,1,1, LDZF.colorBaseBrown);
			private Color colorBackground = LDZF.colorBasePapyrus;
			private myMenuBar_player menuBar = new myMenuBar_player();
		/*
		 * player features
		 */
			private String name;
				private JLabel labelName = new JLabel();
	
	/**
	 * constructors
	 */
	
		public player(String xPlayerName) {
			/*
			 * constructing panel look
			 */
				this.setPreferredSize(new Dimension(this.sizeX, this.sizeY));
				this.setBorder(border);
				this.setBackground(colorBackground);
			/*
			 * constructing and adding content
			 */

				// action button (menu?)
					this.add(menuBar);
						menuBar.setBackground(colorBackground.darker());
						menuBar.setPreferredSize(new Dimension(this.sizeX,20));
				// name
					this.name = xPlayerName;
						this.setName(xPlayerName);
					this.labelName.setText(name);
					this.add(labelName);
		}
	
	/**
	 * methods
	 */
	
}
