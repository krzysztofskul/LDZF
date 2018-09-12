package LDZF;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class panelRaitingBudget extends panelRaiting {

	/**
	 * parameters/features
	 */
		protected Dimension size = new Dimension(105,55);
		private JLabel labelBudget = new JLabel();
		
	/**
	 * constructors
	 */
	
		public panelRaitingBudget(String xType) {
			super(xType);
			this.setPreferredSize(size);
			this.panelForLEDs.add(labelBudget);
				labelBudget.setFont(new myFont());
		}
	
	/**
	 * methods
	 */
		public void setLabelBudget(double x) {
			this.labelBudget.setText(String.format("%,.2f z³", x));
		}
}
