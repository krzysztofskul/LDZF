package LDZF;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;

public class containerForGameElements extends JPanel {

	/**
	 * parameters/features
	 */
	
		private int sizeX, sizeY;
		private Dimension containerDimension;
		private Border border = new MatteBorder(1,1,1,1, LDZF.colorBaseBrown.brighter());
		private Color colorBackground = LDZF.colorBasePapyrus.brighter();
		private FlowLayout layout = new FlowLayout(FlowLayout.CENTER);
	
	/**
	 * constructors
	 */
	
		public containerForGameElements(int width, int height) {
			this.setSizeX(width);
			this.setSizeY(height);
			this.setContainerDimension();
			this.setPreferredSize(containerDimension);
			this.setBackground(colorBackground);
			this.setBorder(border);
			this.setLayout(layout);
		}
		
	/**
	 * methods
	 */
		public int getSizeX() {
			return sizeX;
		}
	
		public void setSizeX(int x) {
			//this.sizeX = (int) LDZF._mainWindow.getScreenWidth() - 10;
			this.sizeX = x;
		}
	
		public int getSizeY() {
			return sizeY;
		}
	
		public void setSizeY(int y) {
			this.sizeY = y;
		}
		
		public Dimension getContainerDimension() {
			return containerDimension;
		}

		public void setContainerDimension() {
			this.containerDimension = new Dimension(this.getSizeX(), this.getSizeY());
		}
}
