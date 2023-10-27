package com.standings.ui.page.panel.subpanel;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class WeekEighthPanel extends JPanel{

	private static final long serialVersionUID = 1809860033923623985L;
	
	public WeekEighthPanel() {
		
		  this.setBounds(0, 124, 1525, 845);
		  this.setLayout(null);
		
		
		   JLabel name6 = new JLabel("week 8");
	       name6.setFont(new Font("Tahoma", Font.PLAIN, 27));
	       name6.setBounds(500, 310, 159, 95);
	       this.add(name6);
	}

}
