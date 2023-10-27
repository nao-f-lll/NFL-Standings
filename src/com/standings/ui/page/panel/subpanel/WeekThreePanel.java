package com.standings.ui.page.panel.subpanel;

import static com.standings.model.ParentFrame.ResizeIconStatic;

import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.standings.model.Game;
import com.standings.model.Team;

public class WeekThreePanel extends JPanel{

	private static final long serialVersionUID = -2819115739150317180L;


	private JLabel firstLocalTeamName;
	private JLabel firstLocalTeamIcon;
	private JLabel firstLocalTeamPoint;
	
	private JLabel firstVisitorTeamName;
	private JLabel firstVisitorTeamIcon;
	private JLabel firstVisitorTeamPoint;
	
	private JLabel secondLocalTeamName;
	private JLabel secondLocalTeamIcon;
	private JLabel secondLocalTeamPoint;
	
	private JLabel secondVisitorTeamName;
	private JLabel secondVisitorTeamIcon;
	private JLabel secondVisitorTeamPoint;
	
	private JLabel thirdLocalTeamName;
	private JLabel thirdLocalTeamIcon;
	private JLabel thirdLocalTeamPoint;
	
	private JLabel thirdVisitorTeamName;
	private JLabel thirdVisitorTeamIcon;
	private JLabel thirdVisitorTeamPoint;
	
	private ArrayList<Team> teams;
	private List<Game> games;
	private Map<String, String> teamLogos;
	
	public WeekThreePanel(ArrayList<Team> teams, List<Game> games,  Map<String, String> teamLogos) {
		

	   	this.setBounds(0, 115, 1525, 845);
	   	this.setLayout(null);
	   	this.games = games;
	   	this.teams = teams;
	   	this.teamLogos = teamLogos;
       
       
		
	       firstLocalTeamName = new JLabel("");
	       firstLocalTeamName.setFont(new Font("Tahoma", Font.PLAIN, 27));
	       firstLocalTeamName.setBounds(365, 80, 159, 95);
	       this.add(firstLocalTeamName);
	       
	       firstLocalTeamIcon = new JLabel("");
	       firstLocalTeamIcon.setFont(new Font("Tahoma", Font.PLAIN, 20));
	       firstLocalTeamIcon.setBounds(127, 61, 186, 118);
	       this.add(firstLocalTeamIcon);
	       
	       firstLocalTeamPoint = new JLabel("20");
	       firstLocalTeamPoint.setFont(new Font("Tahoma", Font.PLAIN, 27));
	       firstLocalTeamPoint.setBounds(571, 80, 58, 95);
	       this.add(firstLocalTeamPoint);
	       
	             
	       
	       firstVisitorTeamName = new JLabel("");
	       firstVisitorTeamName.setFont(new Font("Tahoma", Font.PLAIN, 27));
	       firstVisitorTeamName.setBounds(365, 210, 159, 95);
	       this.add(firstVisitorTeamName);
	       
	       firstVisitorTeamIcon = new JLabel("");
	       firstVisitorTeamIcon.setFont(new Font("Tahoma", Font.PLAIN, 20));
	       firstVisitorTeamIcon.setBounds(127, 195, 174, 138);
	       this.add(firstVisitorTeamIcon);
	       
	     
	       
	       firstVisitorTeamPoint = new JLabel("10");
	       firstVisitorTeamPoint.setFont(new Font("Tahoma", Font.PLAIN, 27));
	       firstVisitorTeamPoint.setBounds(571, 210, 58, 95);
	       this.add(firstVisitorTeamPoint);
	       
	       
	       
	       
	       secondLocalTeamName = new JLabel("");
	       secondLocalTeamName.setFont(new Font("Tahoma", Font.PLAIN, 27));
	       secondLocalTeamName.setBounds(365, 404, 116, 95);
	       this.add(secondLocalTeamName);
	       
	       secondLocalTeamIcon = new JLabel("");
	       secondLocalTeamIcon.setFont(new Font("Tahoma", Font.PLAIN, 20));
	       secondLocalTeamIcon.setBounds(127, 381, 174, 118);
	       this.add(secondLocalTeamIcon);
	      	       
	       secondLocalTeamPoint = new JLabel("20");
	       secondLocalTeamPoint.setFont(new Font("Tahoma", Font.PLAIN, 27));
	       secondLocalTeamPoint.setBounds(571, 404, 58, 95);
	       this.add(secondLocalTeamPoint);
	       
       
	       
	       secondVisitorTeamName = new JLabel("");
	       secondVisitorTeamName.setFont(new Font("Tahoma", Font.PLAIN, 27));
	       secondVisitorTeamName.setBounds(355, 529, 126, 95);      
	       this.add(secondVisitorTeamName);
	       
	      
	       
	       secondVisitorTeamIcon = new JLabel("");
	       secondVisitorTeamIcon.setFont(new Font("Tahoma", Font.PLAIN, 20));
	       secondVisitorTeamIcon.setBounds(127, 517, 194, 118);
	       this.add(secondVisitorTeamIcon);
	       
	       
	       
	       secondVisitorTeamPoint = new JLabel("20");
	       secondVisitorTeamPoint.setFont(new Font("Tahoma", Font.PLAIN, 27));
	       secondVisitorTeamPoint.setBounds(571, 529, 58, 95);
	       this.add(secondVisitorTeamPoint);
	       
	       
	       
	       thirdLocalTeamName = new JLabel("");
	       thirdLocalTeamName.setFont(new Font("Tahoma", Font.PLAIN, 27));
	       thirdLocalTeamName.setBounds(1102, 80, 159, 95);
	       this.add(thirdLocalTeamName);
	       
	       thirdLocalTeamIcon = new JLabel("");
	       thirdLocalTeamIcon.setFont(new Font("Tahoma", Font.PLAIN, 20));
	       thirdLocalTeamIcon.setBounds(855, 51, 149, 138);
	       this.add(thirdLocalTeamIcon);
	       
	       thirdLocalTeamPoint = new JLabel("20");
	       thirdLocalTeamPoint.setFont(new Font("Tahoma", Font.PLAIN, 27));
	       thirdLocalTeamPoint.setBounds(1305, 80, 58, 95);
	       this.add(thirdLocalTeamPoint);
	       
	      
	       
	       
	       
	       thirdVisitorTeamName = new JLabel("");
	       thirdVisitorTeamName.setFont(new Font("Tahoma", Font.PLAIN, 27));
	       thirdVisitorTeamName.setBounds(1102, 221, 159, 95);
	       this.add(thirdVisitorTeamName);
	       
	       
	       thirdVisitorTeamIcon = new JLabel("");
	       thirdVisitorTeamIcon.setFont(new Font("Tahoma", Font.PLAIN, 20));
	       thirdVisitorTeamIcon.setBounds(855, 200, 176, 135);
	       this.add(thirdVisitorTeamIcon);
	       
	       thirdVisitorTeamPoint = new JLabel("20");
	       thirdVisitorTeamPoint.setFont(new Font("Tahoma", Font.PLAIN, 27));
	       thirdVisitorTeamPoint.setBounds(1305, 221, 58, 95);
	       this.add(thirdVisitorTeamPoint);
	       

	       addGameInfo(this.teams, this.games);
       
}


	public void addGameInfo(ArrayList<Team> teams,  List<Game> games) {
    
	
	
		firstLocalTeamName.setText(games.get(2).getLocalTeam());
		setTeamIcon(firstLocalTeamIcon, games.get(2).getLocalTeam());
		firstLocalTeamPoint.setText(String.valueOf(games.get(2).getLocalScore()));
    
    
		firstVisitorTeamName.setText(games.get(2).getVisitorTeam());
		setTeamIcon(firstVisitorTeamIcon, games.get(2).getVisitorTeam());
		firstVisitorTeamPoint.setText(String.valueOf(games.get(2).getVisitorScore()));
     
    
    
		secondLocalTeamName.setText(games.get(7).getLocalTeam());
		setTeamIcon(secondLocalTeamIcon, games.get(7).getLocalTeam());
		secondLocalTeamPoint.setText(String.valueOf(games.get(7).getLocalScore()));
	  
		
		secondVisitorTeamName.setText(games.get(7).getVisitorTeam());
		setTeamIcon(secondVisitorTeamIcon, games.get(7).getVisitorTeam());
		secondVisitorTeamPoint.setText(String.valueOf(games.get(7).getVisitorScore()));
	
	  
	  
		thirdLocalTeamName.setText(games.get(11).getLocalTeam());
		setTeamIcon(thirdLocalTeamIcon, games.get(11).getLocalTeam());
		thirdLocalTeamPoint.setText(String.valueOf(games.get(11).getLocalScore()));
	  
	  
		thirdVisitorTeamName.setText(games.get(11).getVisitorTeam());
		setTeamIcon(thirdVisitorTeamIcon, games.get(11).getVisitorTeam());
		thirdVisitorTeamPoint.setText(String.valueOf(games.get(11).getVisitorScore()));
    
	}

	private void setTeamIcon(JLabel label, String teamName) {
		if (teamLogos.containsKey(teamName)) {
			String iconPath = teamLogos.get(teamName);
			label.setIcon(new ImageIcon(ResizeIconStatic(iconPath, 140, 90)));
		} else {
			label.setIcon(null);
		}
	}
}
