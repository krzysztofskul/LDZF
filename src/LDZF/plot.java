package LDZF;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
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
			protected int sizeX = 110, sizeY = 110,
							locX, locY;
			protected Dimension size = new Dimension(sizeX, sizeY);
			protected Color background = Color.YELLOW;
			protected MatteBorder border = new MatteBorder(1,1,1,1, Color.DARK_GRAY);
			protected BorderLayout layout = new BorderLayout();
			protected GridLayout layoutGrid = new GridLayout(2,0);
			protected myRadioButton radioButton = new myRadioButton("");
			protected JPanel panelCenter = new JPanel();
			protected JPanel panelTitle = new JPanel();
		/*
		 * game features
		 */
			protected String name, owner;
				private JLabel 
								labelName = new JLabel(),
								labelOwner = new JLabel(),
								labelStatus = new JLabel();
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
			 * setting construction of plot
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
				//panelTitle
					this.panelTitle.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
					//this.panelTitle.setOpaque(true);
					this.panelTitle.setBackground(background.darker());
				//panelCenter
					this.panelCenter.setOpaque(false);
					this.panelCenter.setLayout(layoutGrid);

			/*
			 * setting game features of plot
			 */
				// border NORTH and SOUTH
				this.name = xStreetName+" "+Integer.toString(xNo); this.setName(this.name);
					if (xNo % 2 != 0) {
						this.add(panelTitle, layout.NORTH);
						this.panelTitle.add(radioButton);
						this.panelTitle.add(labelName);
						
					} else {
						this.add(panelTitle, layout.SOUTH);
						this.panelTitle.add(radioButton);
						this.panelTitle.add(labelName);
					}
					radioButton.setEnabled(true);
					labelName.setText(this.name);
					labelName.setHorizontalAlignment(SwingConstants.CENTER);
					labelName.setFont(new myFont());
					labelName.addMouseListener(this);
				// border CENTER
				this.add(panelCenter, layout.CENTER);
					if (xNo % 2 != 0) {
						// labelOwner
						this.panelCenter.add(labelOwner);
							this.setOwner("<html><p style=text-align:center>W£ASNOŒÆ<br/>MIASTA</p></html>");
							this.setLabelOwner(this.owner);
						//labelStatus
						this.panelCenter.add(labelStatus);
							this.setStatus(StatusOfPlots.forsale);
					} else {
						//labelStatus
						this.panelCenter.add(labelStatus);
							this.setStatus(StatusOfPlots.forsale);
						// labelOwner
						this.panelCenter.add(labelOwner);
							this.setOwner("<html><p style=text-align:center>W£ASNOŒÆ<br/>MIASTA</p></html>");
							this.setLabelOwner(this.owner);
	
					}
				// HIDDEN P/F
				this.price = xPrice;
				this.prestige = xPrestige;
				this.health = 100;
		}
	
	/**
	 * methods
	 */
		/*
		 * owner
		 */
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
			labelOwner.setHorizontalAlignment(SwingConstants.CENTER);
			labelOwner.setFont(new myFont());

		}
		/*
		 * status
		 */
		public StatusOfPlots getStatus() {
			return status;
		}
		public void setStatus(StatusOfPlots x) {
			this.status = x;
			String y = this.status.toString();
			this.setLabelStatus(y);
		}
		public void setLabelStatus(String y) {
			labelStatus.setHorizontalAlignment(SwingConstants.CENTER);
			labelStatus.setFont(new myFont());
				labelStatus.setOpaque(false);
			if (this.status == status.forsale) {
				this.labelStatus.setText("na sprzeda¿!");
				labelStatus.setVisible(true);
				labelStatus.setForeground(Color.RED);
			} else {
				labelStatus.setVisible(false);
				this.labelStatus.setText(y);
			}
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
