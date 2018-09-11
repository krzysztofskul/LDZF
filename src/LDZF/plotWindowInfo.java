package LDZF;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JWindow;
import javax.swing.border.MatteBorder;

public class plotWindowInfo extends JWindow {

	/**
	 * p/f
	 */
		private JLabel labelPrice = new JLabel();
		private JLabel labelPrestige = new JLabel();
		private JLabel labelHealth = new JLabel();
		private Color background = new Color(255,100,100,150);
	/**
	 * c
	 */
	
		public plotWindowInfo() {
			/*
			 * construction of window
			 */
				this.setSize(200, 100);
				//this.setLocation(10, 10);
				this.setOpacity(.9f);
				this.getContentPane().setBackground(background);
				this.getRootPane().setBorder(new MatteBorder(1,1,1,1, Color.BLUE));
				this.getContentPane().setLayout(new GridLayout(3,0));
			/*
			 * setting content
			 */
				this.add(labelPrice);
					labelPrice.setFont(new myFont());
				this.add(labelPrestige);
					labelPrestige.setFont(new myFont());
				this.add(labelHealth);
					labelHealth.setFont(new myFont());
		}
	
	/**
	 * m
	 */
		public void setDataToShow(int xMouse, int yMouse,
									float xPrice, int xPrestige,
									int xHealth
																) {
			this.setLocation(xMouse, yMouse);
			
			this.labelPrice.setText("Cena: "+String.format("%,.2f", xPrice)+" z³");
			this.labelPrestige.setText("Presti¿: "+Integer.toString(xPrestige)+" pkt.");
			if (xHealth == 0) {
				this.labelHealth.setText("Stan: "+"nie do u¿ytku! ("+Integer.toString(xHealth)+"/100)");
			} else if (xHealth>0 && xHealth<10) {
				this.labelHealth.setText("Stan: "+"fatalny! ("+Integer.toString(xHealth)+"/100)");
			} else if (xHealth>10 && xHealth<20) {
				this.labelHealth.setText("Stan: "+"bardzo z³y! ("+Integer.toString(xHealth)+"/100)");
			} else if (xHealth>20 && xHealth<30) {
				this.labelHealth.setText("Stan: "+"z³y! ("+Integer.toString(xHealth)+"/100)");
			} else if (xHealth>30 && xHealth<70) {
				this.labelHealth.setText("Stan: "+"œredni! ("+Integer.toString(xHealth)+"/100)");
			} else if (xHealth>70 && xHealth<90) {
				this.labelHealth.setText("Stan: "+"dobry! ("+Integer.toString(xHealth)+"/100)");
			} else if (xHealth>90 && xHealth<=100) {
				this.labelHealth.setText("Stan: "+"bardzo dobry! ("+Integer.toString(xHealth)+"/100)");
			} else {
				this.labelHealth.setText("Stan: "+" n/d");
			}
		}
}
