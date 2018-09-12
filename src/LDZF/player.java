package LDZF;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ButtonModel;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;

import LDZF.plot.StatusOfPlots;

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
			private BorderLayout layout = new BorderLayout(0, 0);
		/*
		 * player features
		 */
			private String name;
				private JLabel labelName = new JLabel();
			private int 
							moveActual, 
							movesPossible;
			private double budget = 0;
				private panelRaitingBudget panelRaitingBudget = new panelRaitingBudget("Budget");
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
				// budget
					this.setBudget(1000000000.00f);
				// panel rating icons
					this.add(panelForRaitings, layout.SOUTH);
						panelForRaitings.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 1));
						panelForRaitings.setBackground(null);
							this.panelForRaitings.add(panelRaitingBudget);
							this.panelForRaitings.add(panelRaitingDebt);
							this.panelForRaitings.add(panelRaitingPrestige);
							this.panelForRaitings.add(panelRaitingHealth);
							this.panelForRaitings.add(panelRaitingFamilySize);
							
		}

	
	/**
	 * methods
	 */
		public String getName() {
			return name;
		}
		
		public void setBudget(double x) {
			this.budget += x;
			this.panelRaitingBudget.setLabelBudget(this.budget);
		}
		public double getBudget() {
			return budget;
		}
		
		public void buyPlot() {
			/*
				// ask which plot to buy
					// show radiobuttons on plots
					// wait for choose
					// set plot to buy			
			*/
				// buing process (after it was checked if plot had been selected)
					// checking (every) which plot is selected to buy
					for (int i=1; i<=LDZF.mapOfPlots.size(); i++) {
						// if found plot selected
						if (LDZF.mapOfPlots.get(i).radioButton.isSelected() == true) {
							// set plot to buy
								plot plotToBuy = LDZF.mapOfPlots.get(i);
							// if plot is not for sale
								if (plotToBuy.getStatus() != StatusOfPlots.forsale) {
									LDZF.institutionCityHall.setAnnouncement("Wybrana dzia³ka nie jest na sprzeda¿..");
								} 
							// (else) if plot is for sale
								else { 
								// check price
								// check if actual player have enough money
								// if player have money
									// change owner of the plot
										plotToBuy.setOwner(this);
									// change player's budget
										this.setBudget(-plotToBuy.price);
									// set announcement which plot was bought by who
									LDZF.institutionCityHall.setAnnouncement("<html>Dzia³ka "+plotToBuy.getName()+" <br>zosta³a kupiona przez <br>"+LDZF.playerActiveNow.getName()+"</html>");
								// else if player doesnt have money
									// say that there is no enough money							
							}
						}
					}
			
			// clear selection and hide radiobuttons on plots
				LDZF.plotRadioButtonsGroup.clearSelection();
				/*for (int i=1; i<=LDZF.mapOfPlots.size(); i++) {
					LDZF.mapOfPlots.get(i).radioButton.setEnabled(false);
				}*/
			// clear announcemnt at city hall	
				//LDZF.institutionCityHall.setAnnouncement("");
			
		}
		
}
