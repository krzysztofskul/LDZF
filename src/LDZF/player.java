package LDZF;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

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
			private JPanel panelForRaitings = new JPanel();
			// layout of the panel
				private BorderLayout layout = new BorderLayout(0, 0);
		/*
		 * player features
		 */
			private String name;
				private JLabel labelName = new JLabel();
			private float budget;
				private panelRaiting panelRaitingBudget = new panelRaiting("Budget");
			private float debt;
				private panelRaiting panelRaitingDebt = new panelRaiting("Debt");
			private int prestige;
				private panelRaiting panelRaitingPrestige = new panelRaiting("Prestige");
			private int health;
				private panelRaiting panelRaitingHealth = new panelRaiting("Health");
			private int familySize;
				private panelRaiting panelRaitingFamilySize = new panelRaiting("Family size");
	
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
				this.setLayout(layout);
			/*
			 * constructing and adding content
			 */

				// action button (menu?)
					this.add(menuBar, layout.NORTH);
						menuBar.setBackground(colorBackground);
						menuBar.setPreferredSize(new Dimension(this.sizeX-5,20));
					// name
						this.name = xPlayerName;
							this.setName(xPlayerName);
							this.menuBar.setLabelName(this.getName());
				// main content
				
				// panel rating icons
					this.add(panelForRaitings, layout.SOUTH);
						panelForRaitings.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 1));
						panelForRaitings.setBackground(null);
							this.panelForRaitings.add(panelRaitingBudget);
							this.panelForRaitings.add(panelRaitingDebt);
							this.panelForRaitings.add(panelRaitingPrestige);
							this.panelForRaitings.add(panelRaitingHealth);
							this.panelForRaitings.add(panelRaitingBudget);
							this.panelForRaitings.add(panelRaitingFamilySize);
							
		}

	
	/**
	 * methods
	 */
		public String getName() {
			return name;
		}
}
