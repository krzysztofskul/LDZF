package cards;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import LDZF.LDZF;
import LDZF.myButton;
import LDZF.playerHand;
import LDZF.plot;

public class card extends JPanel implements action, ActionListener {

	/**
	 * parameters/features
	 */
		/*
		 * "front-end" p/f
		 */
			protected static int noOfAllCards = 0;
			protected int sizeX = 50, sizeY = 68;
			protected Dimension dimension = new Dimension(this.sizeX, this.sizeY);
			protected Border border = new CompoundBorder(
															new CompoundBorder( // outside border
																	new MatteBorder(1,1,1,1, LDZF.colorBaseBrown),
																	new MatteBorder(1,1,1,1, LDZF.colorBaseBrown.brighter())
																),
															new EmptyBorder(1,1,1,1) // inside border
													);
			protected Color background = LDZF.colorBasePapyrus;
			protected FlowLayout layout = new FlowLayout(FlowLayout.CENTER, 0, 2);
			protected File bgFilePath;
			protected BufferedImage image;
			protected JPanel info;
		/*
		 * "back-end" p/f
		 */
			protected enum States {active, notActive};
			protected States status;
			protected String name, description;
				protected JLabel labelName;
			protected myButton buttonPlay = new myButton("PLAY CARD"), 
								buttonThrowOut = new myButton("THROW OUT CARD");
			protected playerHand.playerFinger owner;
	/**
	 * constructors
	 */
		public card(String xName) {
			this(xName, null, null);
		}
		
		public card(String xName, String xDescription, File XbgFilePath) {
			// counting all cards and adding to the stack
				card.noOfAllCards++;
			// setting name and description
				this.setName(xName);
					this.labelName = new JLabel(this.getName());
					this.add(labelName);
				this.description = xDescription;
			// set owner
				this.setOwner(null);
			// setting up: dimensions; border; background;
				this.setPreferredSize(this.dimension);
				this.setBorder(border);
				this.setBackground(background);
			// setting up buttons
				this.add(buttonPlay);
					buttonPlay.addActionListener(this);
				this.add(buttonThrowOut);
			
			
		}

	/**
	 * methods
	 */
		public void setOwner(playerHand.playerFinger x) {
			//System.out.println("Ustawi³em w³¹œciciela karty: "+x);
			this.owner = x;
		}
		
		public playerHand.playerFinger getOwner() {
			return owner;
		}
		
		public static int getNoOfAllCards() {
			return cards.card.noOfAllCards;
		}
		/*
		protected void setDescription(String xDescription) {
			switch (this.getName()) {
				case "Nothing":
					//this.description = "karta nie wykonuje ¿adnej akcji";
					this.description = xDescription;
					break;
				case "Test01":
					//this.description = "karta testowa nr 1 - nie wykonuje ¿adnej akcji";
					this.description = xDescription;
					break;
				case "Test02":
					//this.description = "karta testowa nr 2 - nie wykonuje ¿adnej akcji";
					this.description = xDescription;
					break;
				case "Test04-attackplayers":
					//this.description = "karta testowa nr 2 - nie wykonuje ¿adnej akcji";
					this.description = xDescription;
					break;
				default:
					this.description = "opis domyœlny / brak opisu karty";
					break;
			}
		}
		*/
		
		@Override
		public void cardAction() {
			// TODO Auto-generated method stub
			switch (this.getName()) {
				case "Nothing":
					//this.description = "karta nie wykonuje ¿adnej akcji";
					System.out.println("Karta nie wykonuje ¿adnej akcji!");
					break;
				case "Test01":
					//this.description = "karta testowa nr 1 - nie wykonuje ¿adnej akcji";
					System.out.println("Akcja TEST 01 !!!");
					break;
				case "Test02":
					//this.description = "karta testowa nr 2 - nie wykonuje ¿adnej akcji";
					System.out.println("Akcja TEST 02 !!!");
					break;
				case "Test04-attackplayers":
					//this.description = "karta testowa nr 2 - nie wykonuje ¿adnej akcji";
					System.out.println("Akcja TEST 04 !!!");
					break;
				case "Podpalenia na Piotrkowskiej":
					//this.description = "karta testowa nr 2 - nie wykonuje ¿adnej akcji";
					System.out.println("Podpalenie wszystkich dzia³ek na ul. Piotrkowskiej !!!");
					LDZF.piotrkowska02.setHealth(-15);
					LDZF.piotrkowska04.setHealth(-15);
					LDZF.piotrkowska06.setHealth(-15);
					LDZF.piotrkowska08.setHealth(-15);
					LDZF.piotrkowska10.setHealth(-15);
					LDZF.piotrkowska01.setHealth(-15);
					LDZF.piotrkowska03.setHealth(-15);
					LDZF.piotrkowska05.setHealth(-15);
					LDZF.piotrkowska07.setHealth(-15);
					LDZF.piotrkowska09.setHealth(-15);
					break;
				case "Ubezpieczenie dzia³ki":
					if (LDZF.piotrkowska02.getOwner() == this.owner.getParent().getName()) {
						LDZF.piotrkowska02.setHealth(10);
					}
					if (LDZF.piotrkowska04.getOwner() == this.owner.getParent().getName()) {
						LDZF.piotrkowska04.setHealth(10);
					}
					if (LDZF.piotrkowska06.getOwner() == this.owner.getParent().getName()) {
						LDZF.piotrkowska06.setHealth(10);
					}
					if (LDZF.piotrkowska08.getOwner() == this.owner.getParent().getName()) {
						LDZF.piotrkowska08.setHealth(10);
					}
					if (LDZF.piotrkowska10.getOwner() == this.owner.getParent().getName()) {
						LDZF.piotrkowska10.setHealth(10);
					}
					if (LDZF.piotrkowska01.getOwner() == this.owner.getParent().getName()) {
						LDZF.piotrkowska01.setHealth(10);
					}
					if (LDZF.piotrkowska03.getOwner() == this.owner.getParent().getName()) {
						LDZF.piotrkowska03.setHealth(10);
					}
					if (LDZF.piotrkowska05.getOwner() == this.owner.getParent().getName()) {
						LDZF.piotrkowska05.setHealth(10);
					}
					if (LDZF.piotrkowska07.getOwner() == this.owner.getParent().getName()) {
						LDZF.piotrkowska07.setHealth(10);
					}
					if (LDZF.piotrkowska09.getOwner() == this.owner.getParent().getName()) {
						LDZF.piotrkowska09.setHealth(10);
					}
					//System.out.println("W³aœciciel dzia³ki piotrkowska01: "+LDZF.piotrkowska01.getOwner());
					//System.out.println("W³aœcicielme zagranej karty ubezbieczenie by³: "+this.owner.getParent().getName());
					break;
				default:
					System.out.println("Akcja default !!!");
					break;
			}
		}
	
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			Object source = arg0.getSource();	
			if (source==LDZF.cardNothing.buttonPlay) {
				LDZF.cardNothing.cardAction();
					this.putCardBack(LDZF.cardNothing);
				LDZF.calendar.countRound(1);
				LDZF.setPlayerActiveNow();
			} else if (source==LDZF.cardTest01.buttonPlay) {
				LDZF.cardTest01.cardAction();
					this.putCardBack(LDZF.cardTest01);
				LDZF.calendar.countRound(1);
				LDZF.setPlayerActiveNow();
			} else if (source==LDZF.cardTest02.buttonPlay) {
				LDZF.cardTest02.cardAction();
					this.putCardBack(LDZF.cardTest02);
				LDZF.calendar.countRound(1);
				LDZF.setPlayerActiveNow();
			} else if (source==LDZF.cardTest03.buttonPlay) {
				LDZF.cardTest03.cardAction();
					this.putCardBack(LDZF.cardTest03);
				LDZF.calendar.countRound(1);
				LDZF.setPlayerActiveNow();
			} else if (source==LDZF.cardTest04.buttonPlay) {
				LDZF.cardTest04.cardAction();
					this.putCardBack(LDZF.cardTest04);
				LDZF.calendar.countRound(1);
				LDZF.setPlayerActiveNow();
			} else if (source==LDZF.cardIncendiaryAllPiotrkowska.buttonPlay) {
					LDZF.cardIncendiaryAllPiotrkowska.cardAction();
					this.putCardBack(LDZF.cardIncendiaryAllPiotrkowska);
				LDZF.calendar.countRound(1);
				LDZF.setPlayerActiveNow();
			} else if (source==LDZF.cardPlotInsurance.buttonPlay) {
				LDZF.cardPlotInsurance.cardAction();
					this.putCardBack(LDZF.cardPlotInsurance);
				LDZF.calendar.countRound(1);
				LDZF.setPlayerActiveNow();
		}
		}
		
		/*
		 * put card back
		 */
			public void putCardBack(cards.card xName) {
				int x = 0;
				while (LDZF.allCardsStack[x] != null) {
					x++;
					//System.out.println(x+": jest zajête!");
				}
				//System.err.println(x+": jest wolne!");
				this.setVisible(false);
				this.getOwner().buttonTakeCard.setVisible(true);
				//System.out.println("Dla "+this.getOwner().getName()+" ustawiam widoczny przycisk");
				this.setOwner(null);
				LDZF.allCardsStack[x] = xName;
			}


}
