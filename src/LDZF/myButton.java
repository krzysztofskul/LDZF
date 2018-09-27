package LDZF;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

public class myButton extends JButton implements MouseListener {
	
	/***
	 * p
	 */
	
	/***
	 * c
	 */
	
		public myButton(String xType) {
			switch (xType) {
				case "MENU": {
					this.createButtonMenu();
					break;
				}
				case "PLAYER ACTION": {
					this.createButtonPlayerAction();
					break;
				}
				case "EXIT": {
					this.createButtonExit();
					break;
				}
				case "ENTER": {
					this.createButtonEnter();
					break;
				}
				case "TAKE CARD": {
					this.createButtonTakeCard();
					break;
				}
				case "PLAY CARD": {
					this.createButtonPlayCard();
					break;
				}
				case "THROW OUT CARD": {
					this.createButtonThrowOutCard();
					break;
				}
				default: {
					this.createButtonDefault();
				}
			}
		}
	
	/***
	 * m
	 */
		
		private void setTogetherFeatures() {
			this.setBorder(new MatteBorder(1,1,1,1, LDZF.colorBaseBrown));
			this.addMouseListener(this);

		}
		
		private void createButtonMenu() {
			this.setTogetherFeatures();
			this.setText("MENU");
			this.setPreferredSize(new Dimension (75, 15)); // width Y ??
			this.setBackground(Color.WHITE);
			this.setBorder(new MatteBorder(0,5,1,1, LDZF.colorBaseBrown));
		}
		private void createButtonPlayerAction() {
			this.setTogetherFeatures();
			this.setText("ACTION");
			this.setPreferredSize(new Dimension (75, 15)); // width Y ??
			this.setBackground(Color.YELLOW);
			this.setBorder(new MatteBorder(1,1,1,1, LDZF.colorBaseBrown));
		}
		private void createButtonExit() {
			this.setTogetherFeatures();
			this.setText(" X ");
			this.setPreferredSize(new Dimension (50, 15)); // width Y ??
			this.setBackground(Color.RED);
			this.setBorder(new MatteBorder(0,1,1,5, LDZF.colorBaseBrown));
		}
		private void createButtonEnter() {
			this.setTogetherFeatures();
			this.setText(" ENTER ");
			this.setPreferredSize(new Dimension (50, 50)); // width Y ??
			this.setBackground(Color.YELLOW);
			this.setBorder(new MatteBorder(1,1,1,1, LDZF.colorBaseBrown));
		}
		private void createButtonTakeCard() {
			this.setTogetherFeatures();
			this.setText(" DOBIERZ KARTÊ ");
			this.setPreferredSize(new Dimension (40, 60)); // width Y ??
			this.setBackground(Color.ORANGE);
			//this.setBorder(new MatteBorder(1,1,1,1, LDZF.colorBaseBrown));
			this.setFont(new myFont());
		}
		private void createButtonPlayCard() {
			this.setTogetherFeatures();
			this.setText(" ZAGRAJ ");
			this.setPreferredSize(new Dimension (30, 15)); // width Y ??
			this.setBackground(Color.ORANGE);
			//this.setBorder(new MatteBorder(1,1,1,1, LDZF.colorBaseBrown));
			this.setFont(new myFont());
		}
		private void createButtonThrowOutCard() {
			this.setTogetherFeatures();
			this.setText(" ODRZUÆ ");
			this.setPreferredSize(new Dimension (30, 15)); // width Y ??
			this.setBackground(Color.ORANGE);
			//this.setBorder(new MatteBorder(1,1,1,1, LDZF.colorBaseBrown));
			this.setFont(new myFont());
		}
		private void createButtonDefault() {
			this.setTogetherFeatures();
			this.setText(" ... ");
			this.setBackground(Color.YELLOW);
		}
		
		/*
		 * MouseListener methods
		 */
		
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
	
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				this.setBackground(this.getBackground().darker());
			}
	
			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				this.setBackground(this.getBackground().brighter());
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
