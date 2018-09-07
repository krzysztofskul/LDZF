package LDZF;

import java.awt.Color;
import java.awt.EventQueue;

public class LDZF {
	
	/***
	 * parameters
	 */
		public static _mainWindow _mainWindow;
		public static Color colorBaseBrown = new Color(102, 26, 0);
		public static Color colorBasePapyrus = new Color(201,152,104);
		
		public static institution institutionCityHall = new institution("RATUSZ MIEJSKI");
		public static institution institutionCreditCompany = new institution("TOWARZYSTWO KREDYTOWE");
		public static institution institutionKokolobolo = new institution("KOKOLOBOLO");
		
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
