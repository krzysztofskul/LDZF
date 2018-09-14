package calendar;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JWindow;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import LDZF.myMenuBar;
import LDZF.myMenuItem;
import LDZF.LDZF;
import LDZF.myButton;

public class calendar extends JWindow {

	/**
	 * parameters/features
	 */
		/*
		 * frontend features
		 */
			private Dimension size = new Dimension(300, 250);
			private Point locationPoint = new Point(10, 10);
			private BorderLayout layout = new BorderLayout();
			private Border borderRootPane = new CompoundBorder(
																new CompoundBorder( // outside border
																		new MatteBorder(0,1,1,1, LDZF.colorBaseBrown),
																		new MatteBorder(0,1,1,1, LDZF.colorBaseBrown.brighter())
																	),
															new EmptyBorder(0,0,0,0) // inside border
													);
			private GridLayout layoutForPanelContent = new GridLayout(5,7);
			private JLabel labelRoundsCounter;
		/*
		 * backend paremetrs
		 */
			private myMenuBar menuBar = new myMenuBar();
			private JPanel panelContent = new JPanel();
			private int roundsCounter = 0;
	
	/**
	 * constructors
	 */
		public calendar() {
			/*
			 * setting style
			 */					
				//window border
					this.getRootPane().setBorder(borderRootPane);	
				//panel content
					panelContent.setBackground(LDZF.colorBasePapyrus);
					panelContent.setLayout(layoutForPanelContent);
				//labelRoundsCounter
						this.labelRoundsCounter = new JLabel(Integer.toString(this.roundsCounter));
						this.labelRoundsCounter.setBorder(new MatteBorder(5,0,0,0, Color.YELLOW));
						this.labelRoundsCounter.setPreferredSize(new Dimension(0,35));
						this.labelRoundsCounter.setOpaque(false);							//?????????????????
						this.labelRoundsCounter.setBackground(new Color(255,255,55,200));	//?????????????????
						this.labelRoundsCounter.setHorizontalAlignment(SwingConstants.RIGHT);

			
			/*
			 * constructing window
			 */
				//setting size and location of window
					this.setSize(size);
					this.setLocation(locationPoint);
					this.setVisible(true);
				//adding menu bar
					this.getContentPane().add(menuBar, layout.NORTH);
						this.menuBar.changeWindowName("Kalendarz (licznik rund)");
				//adding panel content
					this.getContentPane().add(panelContent, layout.CENTER);
				//adding label round counter
					this.getContentPane().add(this.labelRoundsCounter, layout.SOUTH);
		}
	
	/**
	 * methods
	 */
		public void countRound(int x) {
			this.roundsCounter += x;
			this.labelRoundsCounter.setText(Integer.toString(this.roundsCounter));
		}
	
}


