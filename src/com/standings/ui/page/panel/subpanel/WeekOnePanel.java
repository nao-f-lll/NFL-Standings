package com.standings.ui.page.panel.subpanel;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import static com.standings.model.ParentFrame.*;

public class WeekOnePanel extends JPanel{

	private static final long serialVersionUID = 2821219558128276869L;

	private JLabel firstLocalTeamName;
	private JLabel firstLocalTeamIcon;
	private JLabel firstLocalTeamPoint;
	
	private JLabel secondLocalTeamName;
	
	
	public WeekOnePanel() {

		  this.setBounds(0, 124, 1525, 845);
		  this.setLayout(null);
		  this.setBackground(Color.MAGENTA);
		
	       firstLocalTeamName = new JLabel("Cardinals");
	       firstLocalTeamName.setFont(new Font("Tahoma", Font.PLAIN, 27));
	       firstLocalTeamName.setBounds(365, 205, 159, 95);
	       this.add(firstLocalTeamName);
	       
	       firstLocalTeamIcon = new JLabel("");
	       firstLocalTeamIcon.setIcon(new ImageIcon(ResizeIconStatic("/images/cardinals.png",140,90)));
	       firstLocalTeamIcon.setFont(new Font("Tahoma", Font.PLAIN, 20));
	       firstLocalTeamIcon.setBounds(127, 182, 186, 118);
	       this.add(firstLocalTeamIcon);
	       
	       firstLocalTeamPoint = new JLabel("20");
	       firstLocalTeamPoint.setFont(new Font("Tahoma", Font.PLAIN, 27));
	       firstLocalTeamPoint.setBounds(571, 205, 58, 95);
	       this.add(firstLocalTeamPoint);
	       
	             
	       
	       secondLocalTeamName = new JLabel("Chiefs");
	       secondLocalTeamName.setFont(new Font("Tahoma", Font.PLAIN, 27));
	       secondLocalTeamName.setBounds(365, 310, 159, 95);
	       this.add(secondLocalTeamName);
	       
	       JLabel nfl2 = new JLabel("");
	       nfl2.setFont(new Font("Tahoma", Font.PLAIN, 20));
	       nfl2.setIcon(new ImageIcon(ResizeIconStatic("/images/chiefs.png",140,90)));
	       nfl2.setBounds(127, 298, 174, 138);
	       this.add(nfl2);
	       
	     
	       
	       JLabel point2 = new JLabel("10");
	       point2.setFont(new Font("Tahoma", Font.PLAIN, 27));
	       point2.setBounds(571, 310, 58, 95);
	       this.add(point2);
	       
	       
	       
	       JLabel icon3 = new JLabel("");
	       icon3.setFont(new Font("Tahoma", Font.PLAIN, 20));
	       icon3.setIcon(new ImageIcon(ResizeIconStatic("/images/bengals.png",140,90)));
	       icon3.setBounds(127, 516, 174, 118);
	       this.add(icon3);
	      
	       
	       JLabel icon4 = new JLabel("");
	       icon4.setFont(new Font("Tahoma", Font.PLAIN, 20));
	       icon4.setIcon(new ImageIcon(ResizeIconStatic("/images/cowboys.png",140,90)));
	       icon4.setBounds(127, 638, 174, 118);
	       this.add(icon4);
	       
	       JLabel name3 = new JLabel("Bengals");
	       name3.setFont(new Font("Tahoma", Font.PLAIN, 27));
	       name3.setBounds(365, 536, 116, 95);
	       this.add(name3);
	       
	       JLabel name4 = new JLabel("Cowboys");
	       name4.setFont(new Font("Tahoma", Font.PLAIN, 27));
	       name4.setBounds(365, 644, 126, 95);
	       this.add(name4);
	       
	       JLabel point3 = new JLabel("20");
	       point3.setFont(new Font("Tahoma", Font.PLAIN, 27));
	       point3.setBounds(571, 536, 58, 95);
	       this.add(point3);
	       
	       JLabel point4 = new JLabel("20");
	       point4.setFont(new Font("Tahoma", Font.PLAIN, 27));
	       point4.setBounds(571, 644, 58, 95);
	       this.add(point4);
	       
	       JLabel name5 = new JLabel("Steelers");
	       name5.setFont(new Font("Tahoma", Font.PLAIN, 27));
	       name5.setBounds(1102, 205, 159, 95);
	       this.add(name5);
	       
	       JLabel point5 = new JLabel("20");
	       point5.setFont(new Font("Tahoma", Font.PLAIN, 27));
	       point5.setBounds(1305, 205, 58, 95);
	       this.add(point5);
	       
	       JLabel name6 = new JLabel("Raiders");
	       name6.setFont(new Font("Tahoma", Font.PLAIN, 27));
	       name6.setBounds(1102, 310, 159, 95);
	       this.add(name6);
	       
	       JLabel point6 = new JLabel("20");
	       point6.setFont(new Font("Tahoma", Font.PLAIN, 27));
	       point6.setBounds(1305, 310, 58, 95);
	       this.add(point6);
	       
	       JLabel icon5 = new JLabel("");
	       icon5.setFont(new Font("Tahoma", Font.PLAIN, 20));
	       icon5.setBounds(858, 183, 149, 138);
	       icon5.setIcon(new ImageIcon(ResizeIconStatic("/images/steelers.png",140,90)));
	       this.add(icon5);
	       
	       JLabel icon6 = new JLabel("");
	       icon6.setFont(new Font("Tahoma", Font.PLAIN, 20));
	       icon6.setBounds(858, 301, 176, 135);
	       icon6.setIcon(new ImageIcon(ResizeIconStatic("/images/raiders.png",140,90)));
	       this.add(icon6);
	       
	       
	    
	       
	}
}
