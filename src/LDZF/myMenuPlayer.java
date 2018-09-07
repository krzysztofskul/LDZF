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
		private JMenuItem menuItem_1 = new JMenuItem("BUY PLOT");
		private JMenuItem menuItem_2 = new JMenuItem("SOLD PLOT");
		private JMenuItem menuItem_3 = new JMenuItem("action 3");
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
			if (source == menuItem_1) {
				//TO DEL TEST
				System.out.println("pressed menuItem_1 by player:"+this.getParent().getParent().getName());
				LDZF.institutionCityHall.setAnnouncement("pressed menuItem_1 by player:"+this.getParent().getParent().getName());
				// do action: BUY PLOT
					//...
			} else if (source == menuItem_2) {
				//TO DEL TEST
				System.out.println("pressed menuItem_2 by player:"+this.getParent().getParent().getName());
				LDZF.institutionCityHall.setAnnouncement("pressed menuItem_2 by player:"+this.getParent().getParent().getName());
				// do action: ELL PLOT
					//...
			}else if (source == menuItem_3) {
				//TO DEL TEST
				System.out.println("pressed menuItem_3 by player:"+this.getParent().getParent().getName());
				LDZF.institutionCityHall.setAnnouncement("pressed menuItem_3 by player:"+this.getParent().getParent().getName());
			}
		}
}
