package calendar;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JWindow;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import LDZF.LDZF;
import LDZF.myFont;
import LDZF.myMenuBar;

public class calendar_V2 extends JWindow {

	/**
	 * parameters/features
	 */
		//..
			private Dimension dimension;
			private myMenuBar menuBar;
			private Border windowBorder;
			private BorderLayout layoutWindow;
			private BorderLayout layoutPanelContent = new BorderLayout();
			private GridLayout layoutPanelCalendar = new GridLayout(7,7);
			private Border borderContentPanel;
			private JPanel panelContent = new JPanel();
			private JPanel panelCalendar= new JPanel();
			private JPanel panelLabelRoundCounter = new JPanel();
		//..
			private panelForCalendarDay[] array_panelsForCalendarDay = new panelForCalendarDay[49];
				//private panelForCalendarDay panelForCalendarDay;
			private day[] array_daysForThisMonth;

		//.
			private int movesInRound = 0;
			private int roundsCounter = 1;
			private JLabel labelRoundsCounter = new JLabel("...");
			private GregorianCalendar dGameStart = new GregorianCalendar(/*1820, 8, 18*/2018, 0, 31), // 18.09.1820;
										dTodayRound = dGameStart,
										dFirstDayInThisMonth;
			private int noOfFirstDayInThisMonth, noOfDaysInThisMonth;

	/**			
	 * constructors
	 */
		
		public calendar_V2() {
			/*
			 * setting parameters/features of calendar_V2
			 */
				this.dimension = new Dimension(300,250);
				this.menuBar = new myMenuBar();
				this.layoutWindow = new BorderLayout();
				this.borderContentPanel = new CompoundBorder(
															new CompoundBorder( // outside border
																	new MatteBorder(1,1,1,1, LDZF.colorBaseBrown),
																	new MatteBorder(1,1,1,1, LDZF.colorBaseBrown.brighter())
																),
														new EmptyBorder(1,1,1,1) // inside border
													);

						
			/* 
			* setting up window
			 */
				//configuring window
					this.setVisible(true);
					this.setSize(dimension);
					this.setLocation(10, 10);
					this.setLayout(layoutWindow);
					//adding menu bar
						this.add(menuBar, BorderLayout.NORTH);
				//configuring contentPane / panelContent
					this.getContentPane().add(panelContent);					
						this.panelContent.setLayout(layoutPanelContent);
						this.panelContent.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
						this.panelContent.setBorder(borderContentPanel);					
					
					//configuring panel for calendar
						this.panelContent.add(panelCalendar, layoutPanelContent.CENTER);
						this.panelCalendar.setLayout(layoutPanelCalendar);
						//configuring panels for calendars day in panel content
							// creating 49 panels for calndar day
								for (int i=0; i<this.array_panelsForCalendarDay.length; i++) {
									this.array_panelsForCalendarDay[i] = new panelForCalendarDay(i);
								}
							// adding 49 panel for calendar day to panel content
								for (int i=0; i<this.array_panelsForCalendarDay.length; i++) {
									panelCalendar.add(this.array_panelsForCalendarDay[i]);
								}
					//configuring panel for labelRoundsCounter
						this.panelContent.add(panelLabelRoundCounter, layoutPanelContent.SOUTH);
							this.panelLabelRoundCounter.add(labelRoundsCounter);
				//countRound for first
					this.countRound(1);			
		}				
	
	/**
	 * methods
	 */
		
		public int getNoOfFirstDayInThisMonth() {
			return noOfFirstDayInThisMonth;
		}

		public void setNoOfFirstDayInThisMonth() {
			GregorianCalendar dFirstDayOfMonth = new GregorianCalendar(
					this.dTodayRound.get(Calendar.YEAR), 
					this.dTodayRound.get(Calendar.MONTH), 
					1 
				);
			
			switch (dFirstDayOfMonth.get(Calendar.DAY_OF_WEEK)) {
				case 1 /*sunday*/ : {
					this.noOfFirstDayInThisMonth = 6;
					break;
				}
				case 2 /*monday*/ : {
					this.noOfFirstDayInThisMonth = 0;
					break;
				}
				case 3 /*tuesday*/ : {
					this.noOfFirstDayInThisMonth = 1;
					break;
				}
				case 4 /*wednesday*/ : {
					this.noOfFirstDayInThisMonth = 2;
					break;
				}
				case 5 /*thursday*/ : {
					this.noOfFirstDayInThisMonth = 3;
					break;
				}
				case 6 /*friday*/ : {
					this.noOfFirstDayInThisMonth = 4;
					break;
				}
				case 7 /*saturday*/ : {
					this.noOfFirstDayInThisMonth = 5;
					break;
				}
			}
			
			System.out.println("Nr pierwzego dnia miesiaca (przesuniêcie kalendarza) to: "+this.getNoOfFirstDayInThisMonth());
		}
		
		public int getNoOfDaysInThisMonth() {
			return noOfDaysInThisMonth;
		}

		public void setNoOfDaysInThisMonth() {
			this.noOfDaysInThisMonth = this.dTodayRound.getActualMaximum(Calendar.DAY_OF_MONTH);
		}

		public void createDaysForThisMonth() {
			// create array with length getNoOfDaysInThisMonth
				if (this.array_daysForThisMonth != null) {
					System.out.println("czyszczê tablice dni array_daysForThisMonth, bo by³a zajêca");
					for (int i=0; i<this.array_daysForThisMonth.length; i++) {
						this.array_daysForThisMonth[i] = null;

					}
				}
				this.array_daysForThisMonth = new day[this.getNoOfDaysInThisMonth()];
				for (int i=0; i<this.array_daysForThisMonth.length; i++) {
					this.array_daysForThisMonth[i] = new day(i);	
				}
				//System.out.println("Stworzy³em tabelê array_daysForThisMonth z "+this.getNoOfDaysInThisMonth()+" dniami w tym miesi¹cu");
				//System.out.println("Aktualnie array_daysForThisMonth.length = "+this.array_daysForThisMonth.length);
		}
		
		public void clearCalendarDays() {
			for (int i=7; i<49; i++) {
				this.array_panelsForCalendarDay[i].removeAll();
				this.array_panelsForCalendarDay[i].revalidate();
				this.array_panelsForCalendarDay[i].repaint();
				
				//if (this.array_panelsForCalendarDay[i].getComponent(0) != null) {
					//this.array_panelsForCalendarDay[i].remove(0);
				//}
			}
		}
		
		public void addDaysForThisMonth() {
			for (int i=0; i<this.array_daysForThisMonth.length; i++) {
				this.array_panelsForCalendarDay[i+7+this.getNoOfFirstDayInThisMonth()].add(this.array_daysForThisMonth[i], BorderLayout.CENTER);
				//this.array_panelsForCalendarDay[i].add(this.array_daysForThisMonth[i], 0);
				if (i == this.dTodayRound.get(Calendar.DAY_OF_MONTH)-1) {
					this.array_daysForThisMonth[i].setBorder(new MatteBorder(2, 1, 1, 1, Color.YELLOW));
				}
			}
		}
		
		public void countRound(int x) {	
			// check if it is time for change round/day
				if (this.movesInRound < 4) { 	// if not next round/day
					this.movesInRound += x;
				} else {						// if next round/day
					this.roundsCounter += 1;
					this.movesInRound = 1;
					
					this.dTodayRound.add(Calendar.DAY_OF_MONTH, 1);
					/*
					if (this.getDateTodayRound().get(Calendar.DAY_OF_MONTH) == 1) {
						this.clearDaysInCalendar();
					}
					this.setFirstDayOfWeekInThisMonth();
					this.drawDaysInCalendar();
					*/
				}
			//set/check noOfFirstDayInThisMonth
				this.setNoOfFirstDayInThisMonth();
			//set/check noOfDaysInThisMonth
				this.setNoOfDaysInThisMonth();


			//clear calendar
				this.clearCalendarDays();
			//set/create array_daysForThisMonth
				this.createDaysForThisMonth();
			//add arrayDaysForThisMonth
				this.addDaysForThisMonth();
				//this.dTodayRound.add(Calendar.DAY_OF_MONTH, 30);

			//set label of today date
				this.labelRoundsCounter.setText("Ruch: "+Integer.toString(this.movesInRound)+" / Runda: "
														+Integer.toString(this.roundsCounter)
														+" ("+this.dTodayRound.get(Calendar.YEAR)
														+"."+this.dTodayRound.get(Calendar.MONTH)
														+"."+this.dTodayRound.get(Calendar.DAY_OF_MONTH)
														/*+" "+this.getNameDayOfWeek(this.dateTodayRound.get(Calendar.DAY_OF_WEEK))*/
														+")"
														+" /"+this.getNoOfDaysInThisMonth()+" dni w m-cu");


		}
		
	/****************
	 * **************
	 * nested classes
	 */
	
		public class panelForCalendarDay extends JPanel {
		
			/**
			 * p/f
			 */
				private JLabel labelNo = new JLabel();
				private JPanel panelForLabelNo = new JPanel();
				
			/**
			 * c
			 */
				public panelForCalendarDay(int x) {
					switch (x) {
						case 0: {
								this.setLabelNo("pn.");
							break;
						}
						case 1: {
								this.setLabelNo("wt.");
							break;
						}
						case 2: {
								this.setLabelNo("œr.");
							break;
						}
						case 3: {
								this.setLabelNo("cz.");
							break;
						}
						case 4: {
								this.setLabelNo("pt.");
							break;
						}
						case 5: {
								this.setLabelNo("so.");
							break;
						}
						case 6: {
								this.setLabelNo("nd.");
							break;
						}
						default: {
							this.setName(Integer.toString(x));
							this.setBackground(LDZF.colorBasePapyrus);
							this.setBorder(new MatteBorder(1,1,1,1, LDZF.colorBaseBrown));
							this.setLayout(new BorderLayout(0,0));
							break;
						}
					}
				}
				
			/**
			 * m
			 */
				private void setLabelNo(String x) {
					this.setName(x);
					this.panelForLabelNo.setBackground(LDZF.colorBasePapyrus.brighter().brighter());
					this.panelForLabelNo.setBorder(new MatteBorder(1,1,1,1, LDZF.colorBaseBrown));
					this.setLayout(new BorderLayout());		
						this.add(panelForLabelNo, BorderLayout.CENTER);
							this.panelForLabelNo.add(labelNo);
								this.labelNo.setFont(new myFont());
								this.labelNo.setText(this.getName());
				}
		}
		
		public class day extends JPanel {
			
			/**
			 * p/f
			 */
				private JLabel labelDay;
			/**
			 * c
			 */
				public day(int x) {
					this.setName(Integer.toString(x+1));
					this.setBackground(LDZF.colorBasePapyrus.brighter());
					this.setBorder(new MatteBorder(1,1,1,1, LDZF.colorBaseBrown));
					//this.setPreferredSize(new Dimension(this.getParent().getWidth(), 5));
					//creating, setting and adding labelDay
							this.labelDay = new JLabel(this.getName());
							this.labelDay.setFont(new myFont());
						this.add(this.labelDay);
						
				}
			/**
			 * m
			 */

		}
}
