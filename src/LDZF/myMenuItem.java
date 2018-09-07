package LDZF;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

public class myMenuItem extends JMenuItem /*implements ActionListener*/ {

	/**
	 * parameters/features
	 */
	
	/**
	 * constructors
	 */
		
		public myMenuItem(String text) {
			super(text);
		}
	/**
	 * methods
	 */
		/* DOESNT WORK (MENU DOESNT SEE MY CLASS myMenuItem)
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			Object source = arg0.getSource();
			if (source == myMenuPlayer.menuItem_1) {
				//TO DEL TEST
				System.out.println("pressed menuItem_1 by player:"+this.getParent().getParent().getName());
				LDZF.institutionCityHall.setAnnouncement("pressed menuItem_1 by player:"+this.getParent().getParent().getName());
				// do action: BUY PLOT
					//...
			} else if (source == myMenuPlayer.menuItem_2) {
				//TO DEL TEST
				System.out.println("pressed menuItem_2 by player:"+this.getParent().getParent().getName());
				LDZF.institutionCityHall.setAnnouncement("pressed menuItem_2 by player:\"+this.getParent().getParent().getName()");
				// do action: ELL PLOT
					//...
			}else if (source == myMenuPlayer.menuItem_3) {
				//TO DEL TEST
				System.out.println("pressed menuItem_3 by player:"+this.getParent().getParent().getName());
				LDZF.institutionCityHall.setAnnouncement("pressed menuItem_3 by player:\"+this.getParent().getParent().getName()");
			}
		}
		*/
}
