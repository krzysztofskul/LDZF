package LDZF;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JWindow;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

public class _mainWindow extends JWindow {

	/***
	 * parameters/features
	 */
	
		private myMenuBar myMenuBar = new myMenuBar();
		private panelGame panelGame = new panelGame();
		private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			private double screenWidth = screenSize.getWidth();
			private double screenHeight = screenSize.getHeight();
	
	/***
	 * constructors
	 */
	
		public _mainWindow() {
			/*
			 * configuring look
			 */	
				this.setVisible(true);
				this.setSize(1280, 720);
				this.setLocation((int)screenWidth/2-this.getWidth()/2, 10);
			/*
			 * configuring content
			 */
				// conf. layout			
					this.getContentPane().setLayout(new BorderLayout(0, 0));
					this.getContentPane().setBackground(LDZF.colorBaseBrown);
				// adding content
					// adding menu bar
						this.getContentPane().add(myMenuBar, BorderLayout.NORTH);
							myMenuBar.setPreferredSize(new Dimension(this.getWidth(), myMenuBar.getSizeY()));
					// adding game panel for main contnent
						this.getContentPane().add(panelGame, BorderLayout.CENTER);
					// add window for choosing players
						// ...

		}
	
	/***
	 * methods
	 */
		public double getScreenWidth() {
			return screenWidth;
		}

		public double getScreenHeight() {
			return screenHeight;
		}
		
}
