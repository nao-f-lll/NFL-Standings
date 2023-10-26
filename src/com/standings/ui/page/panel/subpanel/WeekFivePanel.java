package com.standings.ui.page.panel.subpanel;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class WeekFivePanel extends JPanel{

	private static final long serialVersionUID = 5719921169869472964L;
	
	public WeekFivePanel() {
		  this.setBounds(0, 124, 1525, 845);
		  this.setLayout(null);
		  this.setBackground(Color.MAGENTA);
			
		   JLabel name6 = new JLabel("week 5");
	       name6.setFont(new Font("Tahoma", Font.PLAIN, 27));
	       name6.setBounds(500, 310, 159, 95);
	       this.add(name6);
	}

}
