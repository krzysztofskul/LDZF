package LDZF;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
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
			protected Color background = Color.YELLOW;
			protected MatteBorder border = new MatteBorder(1,1,1,1, Color.DARK_GRAY);
			protected BorderLayout layout = new BorderLayout();
			protected myRadioButton radioButton = new myRadioButton("");
		/*
		 * game features
		 */
			protected String name, owner;
				private JLabel 
								labelName = new JLabel();
				private JLabel
								labelOwner = new JLabel();
			protected double price;
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
					this.setBackground(background);
					this.setBorder(border);
					this.setLayout(this.layout);
			/*
			 * setting game features 
			 */
				this.name = xStreetName+" "+Integer.toString(xNo); this.setName(this.name);
					if (xNo % 2 != 0) {
						this.add(labelName, layout.NORTH);
						this.add(radioButton, layout.SOUTH);
					} else {
						this.add(labelName, layout.SOUTH);
						this.add(radioButton, layout.NORTH);
					}
					radioButton.setEnabled(true);
					labelName.setText(this.name);
					labelName.setHorizontalAlignment(SwingConstants.CENTER);;
					labelName.setFont(new myFont());
					labelName.addMouseListener(this);
				this.setOwner("<html>W£ASNOŒÆ<br>MIASTA</html>");
					this.add(labelOwner, layout.CENTER);
					this.setLabelOwner(this.owner);
				this.price = xPrice;
				this.prestige = xPrestige;
				this.health = 100;
				this.status = StatusOfPlots.forsale;
		}
	
	/**
	 * methods
	 */
		
		public StatusOfPlots getStatus() {
			return status;
		}
		
		public void setOwner(String x) {
			this.owner = x;
			this.setLabelOwner(this.owner);			
		}
		
		public void setOwner(player xPlayer) {
			this.owner = xPlayer.getName();
			this.setLabelOwner(this.owner);
		}
		
		private void setLabelOwner (String xOwner) {
			labelOwner.setText(this.owner);
			//labelOwner.setHorizontalAlignment(SwingConstants.CENTER);
			labelOwner.setFont(new myFont());
		}
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
			int xMouse = arg0.getXOnScreen()+5;
			int yMouse = arg0.getYOnScreen()+25;
			LDZF.plotWindowInfo.setDataToShow(xMouse, yMouse,
												this.price, this.prestige,
												this.health
																		);
			LDZF.plotWindowInfo.setVisible(true);
		}
		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			LDZF.plotWindowInfo.setDataToShow(0, 0, 0, 0, 101);
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
