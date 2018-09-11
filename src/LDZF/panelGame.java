package LDZF;

import java.awt.FlowLayout;

import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

public class panelGame extends JPanel {

	/**
	 * p
	 */
		private containerForGameElements containerForInstitutions = new containerForGameElements(920, 100);
		private containerForGameElements containerForMap = new containerForGameElements(920, 400);
		private containerForGameElements containerForPlayers = new containerForGameElements(920, 160);
	/**
	 * c
	 */
		
		public panelGame() {
			// configuring look
				this.setLayout(new FlowLayout(FlowLayout.CENTER)); // maybe GRID LAYOUT or other???
				this.setBackground(LDZF.colorBasePapyrus);
				this.setBorder(new CompoundBorder(
											new CompoundBorder( // outside border
														new MatteBorder(1,1,1,1, LDZF.colorBaseBrown),
														new MatteBorder(1,1,1,1, LDZF.colorBaseBrown.brighter())
													),
											new EmptyBorder(5,5,5,5) // inside border
										)
									);
			/*
			 * adding content			
			 */
				//adding institutions
				this.add(containerForInstitutions);
					containerForInstitutions.add(LDZF.institutionCityHall);
					containerForInstitutions.add(LDZF.institutionCreditCompany);
					containerForInstitutions.add(LDZF.institutionKokolobolo);
				//adding map
				this.add(containerForMap);
					containerForMap.setLayout(null);
					//add(mapOfLodz)
						containerForMap.add(LDZF.piotrkowska01);
						containerForMap.add(LDZF.piotrkowska02);
						containerForMap.add(LDZF.piotrkowska03);
						containerForMap.add(LDZF.piotrkowska04);
						containerForMap.add(LDZF.piotrkowska05);
						containerForMap.add(LDZF.piotrkowska06);
						containerForMap.add(LDZF.piotrkowska07);
						containerForMap.add(LDZF.piotrkowska08);
						containerForMap.add(LDZF.piotrkowska09);
						containerForMap.add(LDZF.piotrkowska10);
				//adding players
				this.add(containerForPlayers);
					//add(playerFirst)
						containerForPlayers.add(LDZF.player01);
						containerForPlayers.add(LDZF.player02);
						containerForPlayers.add(LDZF.player03);
						containerForPlayers.add(LDZF.player04);
					//add(playerSecond)
					//add(playerThird)
					//add(playerFourth)
		}
	
	/**
	 * m
	 */
}
