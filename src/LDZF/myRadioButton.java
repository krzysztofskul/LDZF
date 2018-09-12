package LDZF;

import javax.swing.ImageIcon;
import javax.swing.JRadioButton;

public class myRadioButton extends JRadioButton {

	/**
	 * p/f
	 */
		private ImageIcon iconON = new ImageIcon("src/graphics/gRB_on.png");
		private ImageIcon iconOFF = new ImageIcon("src/graphics/gRB_off.png");
		private ImageIcon iconNotActive = new ImageIcon("src/graphics/gRB_notActive.png");
	
	
	/**
	 * c
	 */
		public myRadioButton(String x) {
			this.setName(x);
			this.setText(x);
			
			this.setOpaque(false);
			
			this.setDisabledIcon(iconNotActive);
			this.setIcon(iconOFF);
			this.setPressedIcon(iconON); 
				this.setSelectedIcon(iconON);
		}
	
	/**
	 * m
	 */
	
	
}
