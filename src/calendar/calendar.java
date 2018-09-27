package calendar;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Point;
import java.text.DateFormat.Field;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JWindow;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import LDZF.myMenuBar;
import LDZF.myMenuItem;
import LDZF.LDZF;
import LDZF.myButton;

public class calendar extends JWindow {  /* TO DELETE TO DELETE TO DELETE TO DELETE TO DELETE TO DELETE TO DELETE TO DELETE TO DELETE TO DELETE TO DELETE */

	/**
	 * parameters/features
	 */
		/*
		 * front-end parameters/features
		 */
			private Dimension size = new Dimension(300, 250);
			private Point locationPoint = new Point(10, 10);			
			private myMenuBar menuBar = new myMenuBar();
			private BorderLayout layout, layoutForPanelContent = new BorderLayout();
			private JPanel panelContent = new JPanel(),
							panelCalendar = new JPanel();
			private Border borderPanelCounter = new CompoundBorder(
														new MatteBorder(1,0,0,0, Color.BLACK),
														new EmptyBorder(0,0,0,5)
													);
			private Border borderContentPanel = new CompoundBorder(
																new CompoundBorder( // outside border
																		new MatteBorder(1,1,1,1, LDZF.colorBaseBrown),
																		new MatteBorder(1,1,1,1, LDZF.colorBaseBrown.brighter())
																	),
															new EmptyBorder(1,1,1,1) // inside border
													);
			private GridLayout layoutForPanelCalendar = new GridLayout(7,7);
			private JLabel labelRoundsCounter;

		/*
		 * back-end parameters/features
		 */
			private static int movesInRound = 0;
			private int roundsCounter = 1;
			private GregorianCalendar dateStartGame = new GregorianCalendar(/*1820, 8, 18*/2018, 2, 31), // 18.09.1820
										dateTodayRound = dateStartGame;
			private panelForDay[] arrayPanelForDays = new panelForDay[49];
			private day[] arrayDays;
			private int daysInThisMonth;
			private int firstDayOfWeekInThisMonth;
	
	/**
	 * constructors
	 */
		public calendar() {
			/*
			 * setting style
			 */					
				// setting panel content
					panelContent.setBackground(LDZF.colorBasePapyrus);
					panelContent.setBorder(borderContentPanel);
					panelContent.setLayout(layoutForPanelContent);
				//setting panel calendar
					panelCalendar.setLayout(layoutForPanelCalendar);
						panelCalendar.setBackground(LDZF.colorBasePapyrus);
				//setting labelRoundsCounter
					labelRoundsCounter = new JLabel(Integer.toString(this.roundsCounter));
					labelRoundsCounter.setBorder(borderPanelCounter);
					labelRoundsCounter.setPreferredSize(new Dimension(0,35));
					labelRoundsCounter.setHorizontalAlignment(SwingConstants.RIGHT);
				//setting panel for days
					for (int i = 0; i < arrayPanelForDays.length; i++) {
						arrayPanelForDays[i] = new panelForDay(i);
					}
			/*
			 * constructing window
			 */
				//setting size and location of window
					this.setSize(size);
					this.setLocation(locationPoint);
					this.setVisible(true);
				//adding menu bar
					this.getContentPane().add(menuBar, layout.NORTH);
						this.menuBar.changeWindowName("Kalendarz (licznik rund)");
				//adding panel content
					this.getContentPane().add(panelContent, layout.CENTER);
					//adding panelCalendar
						this.panelContent.add(panelCalendar);
						this.panelCalendar.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
							for (int i = 0; i < 7; i++) {
								panelCalendar.add(this.arrayPanelForDays[i]);
								this.arrayPanelForDays[i].setBackground(LDZF.colorBasePapyrus.brighter().brighter());
							}
							for (int i = 7; i < arrayPanelForDays.length; i++) {
								panelCalendar.add(this.arrayPanelForDays[i]);
							}

					//setting days in this month and creating days in calendar
						this.setFirstDayOfWeekInThisMonth();	
						this.drawDaysInCalendar();
					//adding label round counter
						this.panelContent.add(this.labelRoundsCounter, layout.SOUTH);
						this.countRound(1);
		}
	
	/**
	 * methods
	 */
		public void countRound(int x) {
				
			// check if it os time for change round/day
			if (this.movesInRound < 4) { 	// if not next round/day
				this.movesInRound += x;
			} else {						// if next round/day
				this.roundsCounter += 1;
				this.movesInRound = 1;
				this.dateTodayRound.add(Calendar.DAY_OF_MONTH, 1);
				if (this.getDateTodayRound().get(Calendar.DAY_OF_MONTH) == 1) {
					this.clearDaysInCalendar();
				}
				this.setFirstDayOfWeekInThisMonth();
				this.drawDaysInCalendar();
			}
				
			this.labelRoundsCounter.setText("Ruch: "+Integer.toString(this.movesInRound)+" / Runda: "
													+Integer.toString(this.roundsCounter)
													+" ("+this.dateTodayRound.get(Calendar.YEAR)
													+"."+this.getMonth()
													+"."+this.dateTodayRound.get(Calendar.DAY_OF_MONTH)
													+" "+this.getNameDayOfWeek(this.dateTodayRound.get(Calendar.DAY_OF_WEEK))
													+")"
													+" /"+this.getDaysInThisMonth()+" dni w m-cu");
		}
		
		public int getRoundsCounter() {
			return roundsCounter;
		}
	
		public GregorianCalendar getDateTodayRound() {
			return dateTodayRound;
		}

		public void setDateTodayRound(int x) {
			this.dateTodayRound.roll(Calendar.DAY_OF_MONTH, 1);

		}
		
		public String getMonth() {
			String x = "?";
			switch (this.dateTodayRound.get(Calendar.MONTH)) {
				case 0:
					x="01";
					break;
				case 1:
					x="02";
					break;
				case 2:
					x="03";
					break;
				case 3:
					x="04";
					break;
				case 4:
					x="05";
					break;
				case 5:
					x="06";
					break;
				case 6:
					x="07";
					break;
				case 7:
					x="08";
					break;
				case 8:
					x="09";
					break;
				case 9:
					x="10";
					break;
				case 10:
					x="11";
					break;
				case 11:
					x="12";
					break;
			}
			return x;
		}
		
		public String getNameDayOfWeek(int x) {
			String dayName = "?";
			switch (x) {
				case 1:
					dayName = "nd.";
					break;
				case 2:
					dayName = "pn.";
					break;
				case 3:
					dayName = "wt.";
					break;
				case 4:
					dayName = "œr.";
					break;
				case 5:
					dayName = "cz.";
					break;
				case 6:
					dayName = "pt.";
					break;
				case 7:
					dayName = "sb.";
					break;
			}
			return dayName;
		}
		
		public int getFirstDayOfWeekInThisMonth() {
			return this.firstDayOfWeekInThisMonth;
		}
		
		public void setFirstDayOfWeekInThisMonth() {
			// set first day of this month
				GregorianCalendar firstDayOfThisMonth = new GregorianCalendar(
																	this.dateTodayRound.get(Calendar.YEAR), 
																	this.dateTodayRound.get(Calendar.MONTH), 
																	1 
																);
			// set name of week day of first day in this month	
				int x1stDayNo = firstDayOfThisMonth.get(Calendar.DAY_OF_WEEK);
					System.out.println("nr pierwszeg dnia w miesioacu: "+x1stDayNo);
			// set move for 1st day in calendar
				int xx; // calendar first day move
				switch (x1stDayNo) {
					case 1: // if sunday
						xx = 6;
						break;
					case 2: // if monday
						xx = 0;
						break;
					case 3: // if tuesday
						xx = 1;
						break;
					case 4: // if wednesday
						xx = 2;
						break;
					case 5: // if thursday
						xx = 3;
						break;
					case 6: // if friday
						xx = 4;
						break;
					case 7: // if saturday
						xx = 5;
						break;
					default:
						xx = 0;
				}
				this.firstDayOfWeekInThisMonth = xx;
				//System.out.println("przesuniecie kalndarza: xx= "+xx);
			// start setting calendar days
				this.setDaysInThisMonth();

		}
		
		public void setDaysInThisMonth() {
			this.daysInThisMonth = this.dateTodayRound.getActualMaximum(Calendar.DAY_OF_MONTH);
			arrayDays = new day[this.getDaysInThisMonth()];
			for (int i = 0; i < arrayDays.length; i++) {
				arrayDays[i] = new day(i);
			}	
		}
		
		public int getDaysInThisMonth() {
			return this.daysInThisMonth;
		}
		
		public void clearDaysInCalendar() {
			System.out.println("Uruchamiam czysczenie kart kalendarza..");
			for (int i = 7; i <= 48; i++) {
				this.arrayPanelForDays[i].removeAll();
			}
		}
		
		public void drawDaysInCalendar() {
			this.clearDaysInCalendar();
			for (int i = 7; i <= this.getDaysInThisMonth()+6; i++) {
				this.arrayPanelForDays[i+this.getFirstDayOfWeekInThisMonth()].add(this.arrayDays[i-7]);
				//System.out.println("Doadajê do: "+i+" z przesunieciem: "+this.getFirstDayOfWeekInThisMonth());
			}			
			for (int i=7; i<=this.getFirstDayOfWeekInThisMonth(); i++) {
				this.arrayPanelForDays[i].removeAll();
			}
		}
		
	/**************
	 * nested class
	 */
		public class panelForDay extends JPanel {
			
			/**
			 * p/f
			 */
			
			/**
			 * c
			 */
				public panelForDay(int x) {
					if (x==0) setName("pn.");
					else if (x==1) setName("wt.");
					else if (x==2) setName("œr.");
					else if (x==3) setName("cz.");
					else if (x==4) setName("pt.");
					else if (x==5) setName("sb.");
					else if (x==6) setName("nd.");
					else {
						this.setName(Integer.toString(x));
					}
					this.setBorder(new MatteBorder(1,1,1,1, LDZF.colorBaseBrown));
					//this.setBackground(LDZF.colorBasePapyrus.brighter());
					this.setBackground(null);
					this.setOpaque(false);
					if (x >= 0 && x <= 6) {
						this.add(new JLabel(this.getName()));
					}
				}
			/**
			 * m
			 */
			
		}
		
	/**************
	 * nested class
	 */
		public class day extends JPanel {
			
			/**
			 * p/f
			 */
			
			/**
			 * c
			 */
				public day(int x) {
					this.setName(Integer.toString(x+1));
					this.setBackground(Color.CYAN);
					this.setBorder(new MatteBorder(1,1,1,1, Color.PINK));
					this.add(new JLabel(this.getName()));
					this.setLayout(new FlowLayout(FlowLayout.LEFT));
				}
			/**
			 * m
			 */
			
		}
		

}


