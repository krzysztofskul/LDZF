package LDZF;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;

public /*abstract*/ class institution extends JPanel {

	/**
	 * parameters/features
	 */
	
		protected int sizeX, sizeY;
			protected Dimension dimension;
		protected Border 
						border = new MatteBorder(1,1,1,1, Color.BLACK),
						borderLightning = new MatteBorder(2,1,1,1, Color.YELLOW);
		protected BufferedImage imageBackground, imageButtonEnter;
			protected File filePath_imageBackground, filePath_imageButtonEnter;
		protected JPanel panelTitle = new JPanel();
		protected String nameOfInstitution, announcement;
		protected float budget = 0.00f;
		protected JLabel labelNameOfInstitution = new JLabel(), labelBudget = new JLabel();
		protected JLabel labelAnnouncement = new JLabel();
		protected myButton buttonEnter;
		
	
	/**
	 * constructors
	 */
	
		protected institution(String nameOfInstitution) {
			/*
			 * setting dimension
			 */
				this.setSizeX(300);
				this.setSizeY(90);
				this.setDimension();
					this.setPreferredSize(this.getDimension());
			/*
			 * setting look (border, background..)
			 */
				this.setBorder(border);
				this.setPanelTitle();
				//this.setImageBackground();
				//this.setImageButtonEnter();
				//this.setFilePath_imageBackground();
				//this.setFilePath_imageButtonEnter();
			/*
			 * setting content elements
			 */
				// adding panel title
					this.setPanelTitle();
					this.add(panelTitle);
					// adding name and budget to panel title					
						this.setNameOfInstitution(nameOfInstitution);
						this.setName(nameOfInstitution);
						this.setLabelNameOfInstitution();
							this.panelTitle.add(this.labelNameOfInstitution, BorderLayout.WEST);
						this.setBudget(1000000.00f);
							this.panelTitle.add(this.labelBudget, BorderLayout.EAST);
				// adding and configuring announcement text field
					this.add(labelAnnouncement, BorderLayout.CENTER);					
						//this.labelAnnouncement.setLayout(new FlowLayout(FlowLayout.LEFT));
						this.labelAnnouncement.setVerticalAlignment(SwingConstants.TOP);
						this.labelAnnouncement.setHorizontalAlignment(SwingConstants.LEFT);
						this.labelAnnouncement.setBorder(border);
						this.labelAnnouncement.setPreferredSize(new Dimension(240,50));	
						this.setAnnouncement("no announcements");
						this.setLabelAnnouncement();	
				// adding button enter
					this.setButtonEnter(new myButton("ENTER"));
					this.add(buttonEnter, BorderLayout.CENTER);
				// add info icon
					//...
		}
	

	/**
	 * methods
	 */
		
		/*
		 * getters and setters
		 */
			public int getSizeX() {
				return sizeX;
			}
	
			public void setSizeX(int sizeX) {
				this.sizeX = sizeX;
			}
	
			public int getSizeY() {
				return sizeY;
			}
	
			public void setSizeY(int sizeY) {
				this.sizeY = sizeY;
			}
			
			public Dimension getDimension() {
				return dimension;
			}

			public void setDimension() {
				this.dimension = new Dimension(this.getSizeX(), this.getSizeY());
			}
			
			public Border getBorder() {
				return border;
			}
	
			public void setBorder(Border border) {
				this.border = border;
			}
	
			public BufferedImage getImageBackground() {
				return imageBackground;
			}
	
			public void setImageBackground(BufferedImage imageBackground) {
				this.imageBackground = imageBackground;
			}
	
			public BufferedImage getImageButtonEnter() {
				return imageButtonEnter;
			}
	
			public void setImageButtonEnter(BufferedImage imageButtonEnter) {
				this.imageButtonEnter = imageButtonEnter;
			}
	
			public File getFilePath_imageBackground() {
				return filePath_imageBackground;
			}
	
			public void setFilePath_imageBackground(File filePath_imageBackground) {
				this.filePath_imageBackground = filePath_imageBackground;
			}
	
			public File getFilePath_imageButtonEnter() {
				return filePath_imageButtonEnter;
			}
	
			public void setFilePath_imageButtonEnter(File filePath_imageButtonEnter) {
				this.filePath_imageButtonEnter = filePath_imageButtonEnter;
			}
	
			public JPanel getPanelTitle() {
				return panelTitle;
			}

			public void setPanelTitle() {

					this.panelTitle.setPreferredSize(new Dimension(this.getSizeX(),20));
					this.panelTitle.setLayout(new BorderLayout(5,0));
					this.panelTitle.setBorder(border);

			}

			public String getNameOfInstitution() {
				return nameOfInstitution;
			}
	
			public void setNameOfInstitution(String x) {
				this.nameOfInstitution = x;
			}
			
			public String getAnnouncement() {
				return announcement;
			}
	
			public void setAnnouncement(String announcement) {
				this.announcement = announcement;
				this.setLabelAnnouncement();
			}
	
			public float getBudget() {
				return budget;
			}
	
			public void setBudget(float x) {
				this.budget += x;
				this.setLabelBudget();
			}
	
			public JLabel getLabelNameOfInstitution() {
				return labelNameOfInstitution;
			}
	
			public void setLabelNameOfInstitution() {
				this.labelNameOfInstitution.setText(this.getNameOfInstitution());
			}
	
			public JLabel getLabelBudget() {
				return labelBudget;
			}
	
			public void setLabelBudget() {
				this.labelBudget.setText(String.format("%,.2f z³", this.getBudget()));
			}
	
			public JLabel getLabelAnnouncement() {
				return labelAnnouncement;
			}
	
			private void setLabelAnnouncement() {			
				this.labelAnnouncement.setText(this.getAnnouncement());	
			}
	
			public myButton getButtonEnter() {
				return buttonEnter;
			}
	
			public void setButtonEnter(myButton buttonEnter) {
				this.buttonEnter = buttonEnter;
			}
	
	
}
