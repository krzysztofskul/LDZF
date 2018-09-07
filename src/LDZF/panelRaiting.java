package LDZF;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JPanel;

public class panelRaiting extends JPanel {

	/**
	 * parameters/features
	 */
		private JPanel 
						panelForLEDs = new JPanel(), 
						panelForIcon = new JPanel();
		private BorderLayout layout = new BorderLayout(1 ,1);
	
	/**
	 * constructors
	 */
	
		public panelRaiting(String xType) {
			/*
			 * configuration
			 */
				this.setLayout(layout);
				this.setBackground(Color.WHITE);
				this.setPreferredSize(new Dimension(15,55));
			/*
			 * content
			 */
				this.add(panelForLEDs, layout.CENTER);
					this.panelForLEDs.setPreferredSize(new Dimension(15, 30));
					this.panelForLEDs.setBackground(Color.YELLOW);
				this.add(panelForIcon, layout.SOUTH);
					this.panelForIcon.setPreferredSize(new Dimension(15, 15));
					this.panelForIcon.setBackground(Color.ORANGE);
		}
	
	/**
	 * methods
	 */
	
}
