package LDZF;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.border.MatteBorder;

public class myMenuPlayer extends JMenu implements ActionListener {

	/**
	 * parameters/features
	 */
		private JMenuItem menuItem_1 = new JMenuItem("KUP DZIA£KÊ");
		private JMenuItem menuItem_2 = new JMenuItem("SPRZEDAJ DZIA£KÊ");
		private JMenuItem menuItem_3 = new JMenuItem("ZAKOÑCZ RUNDÊ");
	/**
	 * constructors
	 */
		public myMenuPlayer() {
			// configuration
				this.setText("MENU ACTION");
				this.setOpaque(true);
				this.setBackground(Color.YELLOW);
				this.setBorder(new MatteBorder(1,1,1,1, Color.WHITE));
				this.setCursor(new Cursor(12));
			// content
				this.add(menuItem_1);
					this.menuItem_1.addActionListener(this);
				this.add(menuItem_2);
					this.menuItem_2.addActionListener(this);
					this.menuItem_2.setEnabled(false);
				this.add(menuItem_3);
					this.menuItem_3.addActionListener(this);
		}
	
	/**
	 * methods
	 */
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			Object source = arg0.getSource();
			if (source == menuItem_1) { // BUY PLOT
				//TO DEL TEST
				//System.out.println("pressed menuItem_1 by player:"+this.getParent().getParent().getName());
				//LDZF.institutionCityHall.setAnnouncement("pressed menuItem_1 by player:"+this.getParent().getParent().getName());		
				// do action: BUY PLOT
					if (LDZF.plotRadioButtonsGroup.getSelection() != null) {
						//LDZF.setPlayerActiveNow((player) this.getParent().getParent());
						LDZF.playerActiveNow.buyPlot();
						LDZF.setPlayerActiveNow();
					} else {
						LDZF.institutionCityHall.setAnnouncement("Wybierz najpierw dzia³kê do kupienia..");
					}
			} else if (source == menuItem_2) { // SELL PLOT
				//TO DEL TEST
				//System.out.println("pressed menuItem_2 by player:"+this.getParent().getParent().getName());
				//LDZF.institutionCityHall.setAnnouncement("pressed menuItem_2 by player:"+this.getParent().getParent().getName());
				// do action: ELL PLOT
					//...
			} else if (source == menuItem_3) { // END ROUND
				//TO DEL TEST
				//System.out.println("pressed menuItem_3 by player:"+this.getParent().getParent().getName());
				//LDZF.institutionCityHall.setAnnouncement("pressed menuItem_3 by player:"+this.getParent().getParent().getName());
				LDZF.plotRadioButtonsGroup.clearSelection();
				LDZF.setPlayerActiveNow();
				
			}
		}
}
