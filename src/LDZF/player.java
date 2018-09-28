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
			private Border borderActive = new MatteBorder(4,1,1,1, Color.GREEN);
			private Border borderNotActive = new MatteBorder(2,1,1,1, Color.RED);
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
			private enum status {active, notActive};
				private status status;
			private double budget = 0;
				private panelRaitingBudget panelRaitingBudget = new panelRaitingBudget("Budget");
			private float debt;
				private panelRaiting panelRaitingDebt = new panelRaiting("Debt");
			private int prestige = 9;
				private panelRaiting panelRaitingPrestige = new panelRaiting("Prestige");
			private int health = 99;
				private panelRaiting panelRaitingHealth = new panelRaiting("Health");
			private int familySize = 0;
				private panelRaiting panelRaitingFamilySize = new panelRaiting("Family size");
				
			public playerHand playerHand;
	
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

				// setting action button (menu?)
					this.add(menuBar, layout.NORTH);
						menuBar.setBackground(colorBackground);
						menuBar.setPreferredSize(new Dimension(this.sizeX-5,20));
				// setting name
					this.name = xPlayerName;
						this.setName(xPlayerName);
						this.menuBar.setLabelName(this.getName());
				// setting budget
					this.setBudget(1000000000.00f);
				// setting panel rating icons
					this.add(panelForRaitings, layout.SOUTH);
						panelForRaitings.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 1));
						panelForRaitings.setBackground(null);
							this.panelForRaitings.add(panelRaitingBudget);
							this.panelForRaitings.add(panelRaitingDebt);
							this.panelForRaitings.add(panelRaitingPrestige);
							this.panelForRaitings.add(panelRaitingHealth);
							this.panelForRaitings.add(panelRaitingFamilySize);
					this.panelRaitingPrestige.setPanelFroLEDs(this.getPrestige());
					this.panelRaitingHealth.setPanelFroLEDs(this.getHealth());
					this.panelRaitingFamilySize.setPanelFroLEDs(this.getFamilySize());
				// creating player hand
					playerHand = new playerHand(this.getName(), this.sizeX, this.sizeY);

		}

	
	/**
	 * methods
	 */
		/*
		 * getters and setters for parameters/features
		 */
			//name
			public String getName() {
				return name;
			}
			//budget
			public double getBudget() {
				return budget;
			}
			public void setBudget(double x) {
				this.budget += x;
				this.panelRaitingBudget.setLabelBudget(this.budget);
			}
			//prestige
			public int getPrestige() {
				return prestige;
			}
			public void setPrestige(int prestige) {
				this.prestige += prestige;
				this.panelRaitingPrestige.setPanelFroLEDs(this.prestige);
			}
			//health
			public int getHealth() {
				return health;
			}
			public void setHealth(int health) {
				this.health += health;
			}		
			//family size
			public int getFamilySize() {
				return familySize;
			}
			public void setFamilySize(int familySize) {
				this.familySize += familySize;
			}
			// status
			public status getStatus() {
				return status;
			}
			public void setStatus(status x) {
				this.status = x;
				if (this.status == status.active) {
					this.setBorder(this.borderActive);
					this.menuBar.menu.setEnabled(true);
					this.playerHand.setStatus(this.playerHand.status.active);
				} else if (this.status == status.notActive) {
					this.setBorder(this.borderNotActive);
					this.menuBar.menu.setEnabled(false);
					this.playerHand.setStatus(this.playerHand.status.notActive);
				} else {
					this.setBorder(this.border);
					this.menuBar.menu.setEnabled(false);	
				}
			}			
			public void checkStatus() {
				if (this == LDZF.playerActiveNow) {
					this.setStatus(status.active);
				} else {
					this.setStatus(status.notActive);
				}
			}
		
		/*
		 * actions
		 */
			// buying plot
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
											plotToBuy.setOwner(this.getName());
										// change player's budget and prestige
											this.setBudget(-plotToBuy.price);
											this.setPrestige(+plotToBuy.prestige);
										// set plot status for notforsale
											plotToBuy.setStatus(StatusOfPlots.notforsale);
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
