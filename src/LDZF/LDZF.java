package LDZF;

import java.awt.Color;
import java.awt.EventQueue;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.swing.ButtonGroup;

import calendar.calendar_V2;

public class LDZF {
	
	/**
	 * notes
	 * 
	 * 			at startup: player should choose which players should be in game
	 * 
	 * 			game over:
	 * 					- when player's family die (no winner)
	 * 					- when player will be a bankrupt (no winner)
	 * 					- when player will be multimillionaire (winner)
	 */
	
	/***
	 * parameters
	 */
		public static _mainWindow _mainWindow;
		public static calendar_V2 calendar;
		public static plotWindowInfo plotWindowInfo = new plotWindowInfo();
		public static Color colorBaseBrown = new Color(102, 26, 0);
		public static Color colorBasePapyrus = new Color(201,152,104);
		
		public static institution institutionCityHall = new institution("RATUSZ MIEJSKI");
		public static institution institutionCreditCompany = new institution("TOWARZYSTWO KREDYTOWE");
		public static institution institutionKokolobolo = new institution("KOKOLOBOLO");
		
		public static plot 	// added in panelGame.java
							piotrkowska02 = new plot("Piotrkowska", 2, 110, 80, 1000000.00f, 10),
							piotrkowska04 = new plot("Piotrkowska", 4, 220, 80, 1000000.00f, 10),
							piotrkowska06 = new plot("Piotrkowska", 6, 330, 80, 900000.00f, 9),
							piotrkowska08 = new plot("Piotrkowska", 8, 440, 80, 900000.00f, 9),
							piotrkowska10 = new plot("Piotrkowska", 10, 550, 80, 900000.00f, 9),
							piotrkowska01 = new plot("Piotrkowska", 1, 110, 200, 1000000.00f, 10),
							piotrkowska03 = new plot("Piotrkowska", 3, 220, 200, 1000000.00f, 10),
							piotrkowska05 = new plot("Piotrkowska", 5, 330, 200, 900000.00f, 9),
							piotrkowska07 = new plot("Piotrkowska", 7, 440, 200, 900000.00f, 9),
							piotrkowska09 = new plot("Piotrkowska", 9, 550, 200, 900000.00f, 9);
		
		public static Map<Integer, plot> mapOfPlots = new HashMap<Integer, plot>();
		
		public static ButtonGroup plotRadioButtonsGroup = new ButtonGroup();
		
		public static player 
								// data base of players
									Geyerowie = new player("Geyerowie"), 
									Grohmanowie = new player("Grohmanowie"), 
									Scheiblerowie = new player("Scheiblerowie"), 
									Poznanscy = new player("Poznanscy"),
										Biedermannowie = new player("Biedermannowie"),
										Kindermannowie = new player("Kindermannowie"),
										Heinzelowie	= new player("Heinzelowie"),					
										Herbstowie = new player("Herbstowie"),
											Kunitzerowie = new player("Kunitzerowie"),
											Silbersteinowie = new player("Silbersteinowie"),
								// players in game
									player01 = Biedermannowie, 
									player02 = Kindermannowie, 
									player03 = Heinzelowie, 
									player04 = Herbstowie,
								// active player
									playerActiveNow = player02;	
	/***
	 * constructors
	 */
	
		public LDZF() {
			// creating main window
				_mainWindow = new _mainWindow();
				calendar = new calendar_V2();
			// setting map/array of the plots
				mapOfPlots.put(1, piotrkowska01);
				mapOfPlots.put(2, piotrkowska02);
				mapOfPlots.put(3, piotrkowska03);
				mapOfPlots.put(4, piotrkowska04);
				mapOfPlots.put(5, piotrkowska05);
				mapOfPlots.put(6, piotrkowska06);
				mapOfPlots.put(7, piotrkowska07);
				mapOfPlots.put(8, piotrkowska08);
				mapOfPlots.put(9, piotrkowska09);
				mapOfPlots.put(10, piotrkowska10);
			// setting button group of plots
				plotRadioButtonsGroup.add(this.piotrkowska01.radioButton);
				plotRadioButtonsGroup.add(this.piotrkowska02.radioButton);
				plotRadioButtonsGroup.add(this.piotrkowska03.radioButton);
				plotRadioButtonsGroup.add(this.piotrkowska04.radioButton);
				plotRadioButtonsGroup.add(this.piotrkowska05.radioButton);
				plotRadioButtonsGroup.add(this.piotrkowska06.radioButton);
				plotRadioButtonsGroup.add(this.piotrkowska07.radioButton);
				plotRadioButtonsGroup.add(this.piotrkowska08.radioButton);
				plotRadioButtonsGroup.add(this.piotrkowska09.radioButton);
				plotRadioButtonsGroup.add(this.piotrkowska10.radioButton);
			// setting active player for the beginning of the game
				setPlayerActiveNow();
				
		}
	
	/***
	 * methods
	 * 
	 */
		
		public static void setPlayerActiveNow() {
			Random random = new Random();
				int xPlayer = random.nextInt(4)+1;
			switch(xPlayer) {
				case 1:
					playerActiveNow = player01;
					break;
				case 2:
					playerActiveNow = player02;
					break;
				case 3:
					playerActiveNow = player03;
					break;
				case 4:
					playerActiveNow = player04;
					break;
			}
			player01.checkStatus();
			player02.checkStatus();
			player03.checkStatus();
			player04.checkStatus();
		}
	
		public static void main(String[] args) {
			// TODO Auto-generated method stub
				EventQueue.invokeLater(new Runnable() {
					@Override
					public void run() {
						new LDZF();
					}
				});
		}

}
