package LDZF;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class panelRaiting extends JPanel {

	/**
	 * parameters/features
	 */
		protected JPanel 
						panelForLEDs = new JPanel(), 
						panelForIcon = new JPanel();
		protected BorderLayout layout = new BorderLayout(1, 1);
		protected Dimension size = new Dimension(20,55);
		protected JLabel labelLEDs, labelIcon; 
	
	/**
	 * constructors
	 */
	
		public panelRaiting(String xType) {
			/*
			 * configuration
			 */
				switch (xType) {
					case "Budget": {
						this.setName("$$$");
						break;
					}
					case "Prestige": {
						this.setName("P");
						this.labelLEDs = new JLabel("P");
						this.setPanelFroLEDs(0);
						break;
					}
					case "Health": {
						this.setName("H");
						this.labelLEDs = new JLabel("H");
						this.setPanelFroLEDs(0);
						break;
					}
					case "Family size": {
						this.setName("FS");
						this.labelLEDs = new JLabel("FS");
						this.setPanelFroLEDs(0);
						break;
					}
					default:
						break;
				}
				this.labelIcon = new JLabel(this.getName());
				this.setLayout(layout);
				this.setBackground(Color.WHITE);
				this.setPreferredSize(size);
			/*
			 * content
			 */
				this.add(panelForLEDs, layout.CENTER);
					
				this.add(panelForIcon, layout.SOUTH);
					this.setPanelForIcon();					
		}
	
	/**
	 * methods
	 */
		public void setPanelFroLEDs(int x) {
			//this.panelForLEDs.setPreferredSize(new Dimension(15, 30));
			this.panelForLEDs.setBackground(Color.YELLOW);
			this.panelForLEDs.add(labelLEDs);
			this.labelLEDs.setText(Integer.toString(x));
		}
		
		public void setPanelForIcon() {
			//this.panelForIcon.setPreferredSize(new Dimension(15, 15));
			this.panelForIcon.setBackground(Color.ORANGE);
			this.panelForIcon.add(labelIcon);
		}
}
