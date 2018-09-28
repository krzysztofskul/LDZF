package LDZF;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

public class playerHand extends JPanel {

	/**
	 * parameters/features
	 */
		public playerFinger[] playerFingers = new playerFinger[8];
		private int sizeX, sizeY;
		public enum States {active, notActive};
			public States status;
		private Dimension dimActive,
							dimNotActive;
		public player owner;
	
	/**
	 * constructors
	 */
		public playerHand(String x, int xSizeX, int xSizeY) {
			// configuration
				this.setName(x);
					System.out.println("Utworzy³em d³oñ gracza: "+this.getName());
				this.sizeX = xSizeX;
				this.sizeY = xSizeY;
				this.dimActive = new Dimension (sizeX, sizeY);
				this.dimNotActive = new Dimension (sizeX, 2);
				this.setPreferredSize(dimActive);
				this.setBackground(LDZF.colorBasePapyrus);
				this.setBorder( new CompoundBorder(
													new CompoundBorder( // outside border
															new MatteBorder(1,1,1,1, LDZF.colorBaseBrown),
															new MatteBorder(1,1,1,1, LDZF.colorBaseBrown.brighter())
														),
													new EmptyBorder(1,1,1,1) // inside border
											));
				this.setLayout(new FlowLayout(FlowLayout.CENTER, 1, 1));
			// creating player fingers (panels for cards)
				for (int i=0; i<this.playerFingers.length; i++) {
					this.playerFingers[i] = new playerFinger(i+1);
					this.add(this.playerFingers[i]);
				}


		}
	/**
	 * 
	 * methods
	 */
		public void setStatus(States xStatus) {
			this.status = xStatus;
			this.checkStatus();
		}
		public void checkStatus() {
			if (this.status == status.active) {
				//this.setBackground(Color.GREEN);
				//this.setSize(this.dimActive);
				for (int i=0; i<this.playerFingers.length; i++) {
					this.playerFingers[i].setVisible(true);
				}
			} else {
				//this.setBackground(Color.RED);
				//this.setSize(this.dimNotActive);
				for (int i=0; i<this.playerFingers.length; i++) {
					this.playerFingers[i].setVisible(false);
				}
			}
		}
		
	/***********************
	 * NESTED CLASS
	 */
		public class playerFinger extends JPanel implements ActionListener {
			/**
			 * p
			 */
				public myButton buttonTakeCard = new myButton("TAKE CARD");
			/**
			 * c
			 */
				public playerFinger(int x) {
					this.setName(Integer.toString(x));
					this.setPreferredSize(new Dimension(50, 68));
					this.setBackground(LDZF.colorBasePapyrus);
					this.setLayout(new FlowLayout(FlowLayout.CENTER,0 ,0));
					
					this.add(buttonTakeCard);
						this.buttonTakeCard.addActionListener(this);
						
				}
			/**
			 * m
			 */
				/*
				 * (non-Javadoc)
				 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
				 */
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						Object source = e.getSource();
						if (source.equals(this.buttonTakeCard)) {
							this.takeCard();
						}
					}
				/*
				 * take card
				 */
					public void takeCard() {
						int x = 0;
						// serching card in stack
						while (LDZF.allCardsStack[x] == null) {
							x++;
							if (x>=LDZF.allCardsStack.length) {
								System.out.println("Nie ma wiêcej kart!");
								break;
							}
						}
						// when find card
						if (x<LDZF.allCardsStack.length) {
							//	inform about array befor taking card								
								/*for (int i=0; i<LDZF.allCardsStack.length; i++) {
									System.out.println(i+" : "+LDZF.allCardsStack[i]);
								}
								*/
							// start taking card
								// set new owner of the card
									LDZF.allCardsStack[x].setOwner(this);
								// add card from stack to this finger
										this.add(LDZF.allCardsStack[x]);
								// hide button take card
									this.buttonTakeCard.setVisible(false);
								// show card
									LDZF.allCardsStack[x].setVisible(true);
								// set place in stack as null	
									LDZF.allCardsStack[x] = null;
								// do turn
									LDZF.calendar.countRound(1);
									LDZF.setPlayerActiveNow();
								// informa about taking card
									//System.err.println("Pobra³em kartê z: "+x);
									//System.out.println("D³ugoœæ tablicy wynosi teraz: "+LDZF.allCardsStack.length);

								// shuffle/sort cards
									for (int i=0; i<LDZF.allCardsStack.length-1; i++) {
										if (LDZF.allCardsStack[i] == null && LDZF.allCardsStack[i+1] != null)
											LDZF.allCardsStack[i] = LDZF.allCardsStack[i+1];
											LDZF.allCardsStack[i+1] = null;
									}
								// inform about new card sort
									/*
									 for (int i=0; i<LDZF.allCardsStack.length; i++) {
										System.err.println(i+" : "+LDZF.allCardsStack[i]);
									}
									*/
						}
					}

		}
	
}
