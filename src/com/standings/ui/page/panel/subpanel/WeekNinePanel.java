package com.standings.ui.page.panel.subpanel;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class WeekNinePanel extends JPanel{

	private static final long serialVersionUID = -8260636017677961423L;
	
	public WeekNinePanel() {
		
		   this.setBounds(0, 124, 1525, 845);
		   this.setLayout(null);
			
		   JLabel name6 = new JLabel("week 9");
	       name6.setFont(new Font("Tahoma", Font.PLAIN, 27));
	       name6.setBounds(500, 310, 159, 95);
	       this.add(name6);
	}
}