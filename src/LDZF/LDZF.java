package LDZF;

import java.awt.Color;
import java.awt.EventQueue;

public class LDZF {
	
	/***
	 * parameters
	 */
		public static _mainWindow _mainWindow;
		public static plotWindowInfo plotWindowInfo = new plotWindowInfo();
		public static Color colorBaseBrown = new Color(102, 26, 0);
		public static Color colorBasePapyrus = new Color(201,152,104);
		
		public static institution institutionCityHall = new institution("RATUSZ MIEJSKI");
		public static institution institutionCreditCompany = new institution("TOWARZYSTWO KREDYTOWE");
		public static institution institutionKokolobolo = new institution("KOKOLOBOLO");
		
		public static plot 	// added in panelGame.java
							piotrkowska02 = new plot("Piotrkowska", 2, 110, 100, 1000000.00f, 10),
							piotrkowska04 = new plot("Piotrkowska", 4, 200, 100, 1000000.00f, 10),
							piotrkowska06 = new plot("Piotrkowska", 6, 290, 100, 900000.00f, 9),
							piotrkowska08 = new plot("Piotrkowska", 8, 380, 100, 900000.00f, 9),
							piotrkowska10 = new plot("Piotrkowska", 10, 470, 100, 900000.00f, 9),
							piotrkowska01 = new plot("Piotrkowska", 1, 110, 200, 1000000.00f, 10),
							piotrkowska03 = new plot("Piotrkowska", 3, 200, 200, 1000000.00f, 10),
							piotrkowska05 = new plot("Piotrkowska", 5, 290, 200, 900000.00f, 9),
							piotrkowska07 = new plot("Piotrkowska", 7, 380, 200, 900000.00f, 9),
							piotrkowska09 = new plot("Piotrkowska", 9, 470, 200, 900000.00f, 9);
		
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
									playerActiveNow;	
	/***
	 * constructors
	 */
	
		public LDZF() {
			_mainWindow = new _mainWindow();
		}
	
	/***
	 * methods
	 * 
	 */
	
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
