package cards;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.JWindow;

import LDZF.containerForGameElements;
import LDZF.playerHand;

public class windowCards extends JWindow {

	/**
	 * parameters / features
	 */	
		private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			private double screenWidth = screenSize.getWidth();
			private double screenHeight = screenSize.getHeight();
			private containerForGameElements containerForPlayerHands = new containerForGameElements(920, 160);
	/**
	 * constructors
	 */
	
		public windowCards() {
			// setting size and location
				this.setSize(1280, 200);
				this.setLocation((int) this.screenWidth/2-this.getWidth()/2, (int) this.screenHeight-this.getHeight()-145);
				this.setVisible(true);
			// setting border, background, layout
				this.getRootPane().setBorder(calendar.calendar_V2.borderContentPanel);
				this.getContentPane().setBackground(LDZF.LDZF.colorBasePapyrus);
				this.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER));
			// and adding containr for player hands (panel for cards)
				this.getContentPane().add(containerForPlayerHands);
					this.containerForPlayerHands.add(LDZF.LDZF.player01.playerHand);
					this.containerForPlayerHands.add(LDZF.LDZF.player02.playerHand);
					this.containerForPlayerHands.add(LDZF.LDZF.player03.playerHand);
					this.containerForPlayerHands.add(LDZF.LDZF.player04.playerHand);
		}
	
	/**
	 * methods
	 */
	
}
