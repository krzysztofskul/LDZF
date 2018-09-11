package LDZF;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;

public class plot extends JPanel implements MouseListener {

	
	/**
	 * parameters/features
	 */
		/*
		 * size and look features
		 */
			protected int sizeX = 90, sizeY = 90,
							locX, locY;
			protected Dimension size = new Dimension(sizeX, sizeY);
			protected MatteBorder border = new MatteBorder(1,1,1,1, Color.DARK_GRAY);
			protected BorderLayout layout = new BorderLayout();
		/*
		 * game features
		 */
			protected String name, owner;
				private JLabel 
								labelName = new JLabel(),
								labelOwner = new JLabel();
			protected float price;
			protected int prestige, health;
			protected enum StatusOfPlots {
									nostatus, 
									forsale, 
									notforsale, 
									destroyed
								};
			protected StatusOfPlots status;
								
		
	/**
	 * constructors
	 */
	
		public plot (String xStreetName, int xNo, 
						int xlocX, int xlocY,
						float xPrice, int xPrestige
													) {
			/*
			 * constructing
			 */
				// size and localization
					this.locX = xlocX;
					this.locY = xlocY;
					this.setSize(size);
					this.setLocation(this.locX, this.locY);
				// border and background
					this.setBorder(border);
					this.setLayout(this.layout);
			/*
			 * setting game features 
			 */
				this.name = xStreetName+" "+Integer.toString(xNo); this.setName(this.name);
					if (xNo % 2 != 0) {
						this.add(labelName, layout.NORTH);
					} else this.add(labelName, layout.SOUTH);
						labelName.setText(this.name);
						labelName.setHorizontalAlignment(SwingConstants.CENTER);;
						labelName.setFont(new myFont());
						labelName.addMouseListener(this);
				this.owner = "W£ASNOŒÆ MIASTA";
				this.price = xPrice;
				this.prestige = xPrestige;
				this.health = 100;
				this.status = StatusOfPlots.nostatus;
		}
	
	/**
	 * methods
	 */
		
		/*
		 * MouseListener
		 */
		@Override
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			LDZF.plotWindowInfo.setDataToShow(this.price, this.prestige,
												this.health
																		);
			LDZF.plotWindowInfo.setVisible(true);
		}
		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			LDZF.plotWindowInfo.setDataToShow(0, 0, 101);
			LDZF.plotWindowInfo.setVisible(false);
		}
		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
	
	
}
