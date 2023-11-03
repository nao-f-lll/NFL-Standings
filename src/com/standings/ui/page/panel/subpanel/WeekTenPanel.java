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

public class WeekTenPanel extends JPanel{

	private static final long serialVersionUID = -453659361482126114L;

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
	
	private Map<String, String> teamLogos;
	
	
	private final int GAME_ONE = 27; 
	private final int GAME_TWO = 28;
	private final int GAME_THREE = 29; 
	
	
	public WeekTenPanel(ArrayList<Team> teams, List<Game> games, Map<String, String> teamLogos) {
		
	   	this.setBounds(0, 115, 1525, 845);
	   	this.setLayout(null);
	   	this.teamLogos = teamLogos;
	   	
   	
	       firstLocalTeamName = new JLabel("inexistente");
	       firstLocalTeamName.setFont(new Font("Tahoma", Font.PLAIN, 27));
	       firstLocalTeamName.setBounds(365, 80, 159, 95);
	       this.add(firstLocalTeamName);
	       
	       firstLocalTeamIcon = new JLabel("");
	       firstLocalTeamIcon.setIcon(new ImageIcon(ResizeIconStatic("/images/unkowen.png", 140, 90)));
	       firstLocalTeamIcon.setFont(new Font("Tahoma", Font.PLAIN, 20));
	       firstLocalTeamIcon.setBounds(127, 61, 186, 118);
	       this.add(firstLocalTeamIcon);
	       
	       firstLocalTeamPoint = new JLabel("0");
	       firstLocalTeamPoint.setFont(new Font("Tahoma", Font.PLAIN, 27));
	       firstLocalTeamPoint.setBounds(571, 80, 58, 95);
	       this.add(firstLocalTeamPoint);
	       
	             
	       
	       firstVisitorTeamName = new JLabel("inexistente");
	       firstVisitorTeamName.setFont(new Font("Tahoma", Font.PLAIN, 27));
	       firstVisitorTeamName.setBounds(365, 210, 159, 95);
	       this.add(firstVisitorTeamName);
	       
	       firstVisitorTeamIcon = new JLabel("");
	       firstVisitorTeamIcon.setIcon(new ImageIcon(ResizeIconStatic("/images/unkowen.png", 140, 90)));
	       firstVisitorTeamIcon.setFont(new Font("Tahoma", Font.PLAIN, 20));
	       firstVisitorTeamIcon.setBounds(127, 195, 174, 138);
	       this.add(firstVisitorTeamIcon);
	       
	     
	       
	       firstVisitorTeamPoint = new JLabel("0");
	       firstVisitorTeamPoint.setFont(new Font("Tahoma", Font.PLAIN, 27));
	       firstVisitorTeamPoint.setBounds(571, 210, 58, 95);
	       this.add(firstVisitorTeamPoint);
	       		       
	       
	       secondLocalTeamName = new JLabel("inexistente");
	       secondLocalTeamName.setFont(new Font("Tahoma", Font.PLAIN, 27));
	       secondLocalTeamName.setBounds(365, 404, 159, 95);
	       this.add(secondLocalTeamName);
	       
	       secondLocalTeamIcon = new JLabel("");
	       secondLocalTeamIcon.setIcon(new ImageIcon(ResizeIconStatic("/images/unkowen.png", 140, 90)));
	       secondLocalTeamIcon.setFont(new Font("Tahoma", Font.PLAIN, 20));
	       secondLocalTeamIcon.setBounds(127, 381, 174, 118);
	       this.add(secondLocalTeamIcon);
	      	       
	       secondLocalTeamPoint = new JLabel("0");
	       secondLocalTeamPoint.setFont(new Font("Tahoma", Font.PLAIN, 27));
	       secondLocalTeamPoint.setBounds(571, 404, 58, 95);
	       this.add(secondLocalTeamPoint);
	       
       
	       
	       secondVisitorTeamName = new JLabel("inexistente");
	       secondVisitorTeamName.setFont(new Font("Tahoma", Font.PLAIN, 27));
	       secondVisitorTeamName.setBounds(355, 529, 159, 95);      
	       this.add(secondVisitorTeamName);
	       
	      
	       
	       secondVisitorTeamIcon = new JLabel("");
	       secondVisitorTeamIcon.setIcon(new ImageIcon(ResizeIconStatic("/images/unkowen.png", 140, 90)));
	       secondVisitorTeamIcon.setFont(new Font("Tahoma", Font.PLAIN, 20));
	       secondVisitorTeamIcon.setBounds(127, 517, 194, 118);
	       this.add(secondVisitorTeamIcon);
	       
	       
	       
	       secondVisitorTeamPoint = new JLabel("0");
	       secondVisitorTeamPoint.setFont(new Font("Tahoma", Font.PLAIN, 27));
	       secondVisitorTeamPoint.setBounds(571, 529, 58, 95);
	       this.add(secondVisitorTeamPoint);
	       	       
	       
	       thirdLocalTeamName = new JLabel("inexistente");
	       thirdLocalTeamName.setFont(new Font("Tahoma", Font.PLAIN, 27));
	       thirdLocalTeamName.setBounds(1102, 80, 159, 95);
	       this.add(thirdLocalTeamName);
	       
	       thirdLocalTeamIcon = new JLabel("");
	       thirdLocalTeamIcon.setIcon(new ImageIcon(ResizeIconStatic("/images/unkowen.png", 140, 90)));
	       thirdLocalTeamIcon.setFont(new Font("Tahoma", Font.PLAIN, 20));
	       thirdLocalTeamIcon.setBounds(855, 51, 149, 138);
	       this.add(thirdLocalTeamIcon);
	       
	       thirdLocalTeamPoint = new JLabel("0");
	       thirdLocalTeamPoint.setFont(new Font("Tahoma", Font.PLAIN, 27));
	       thirdLocalTeamPoint.setBounds(1305, 80, 58, 95);
	       this.add(thirdLocalTeamPoint);
	       
	       
	       thirdVisitorTeamName = new JLabel("inexistente");
	       thirdVisitorTeamName.setFont(new Font("Tahoma", Font.PLAIN, 27));
	       thirdVisitorTeamName.setBounds(1102, 221, 159, 95);
	       this.add(thirdVisitorTeamName);
	       
	       
	       thirdVisitorTeamIcon = new JLabel("");
	       thirdVisitorTeamIcon.setIcon(new ImageIcon(ResizeIconStatic("/images/unkowen.png", 140, 90)));
	       thirdVisitorTeamIcon.setFont(new Font("Tahoma", Font.PLAIN, 20));
	       thirdVisitorTeamIcon.setBounds(855, 200, 176, 135);
	       this.add(thirdVisitorTeamIcon);
	       
	       thirdVisitorTeamPoint = new JLabel("0");
	       thirdVisitorTeamPoint.setFont(new Font("Tahoma", Font.PLAIN, 27));
	       thirdVisitorTeamPoint.setBounds(1305, 221, 58, 95);
	       this.add(thirdVisitorTeamPoint);
	       
       
}


 //REQUIRES: Objects musen't be a null value.
 //MODIFIES: this
 //EFFECTS : based on the game boolean that holds true, change the information of the game.

public void addGameInfo(ArrayList<Team> teams,  List<Game> games,int gameNumber) {
    
	
   	if (gameNumber == GAME_ONE) {
   		
   		firstLocalTeamName.setText(games.get(gameNumber).getLocalTeam());
   	    setTeamIcon(firstLocalTeamIcon, games.get(gameNumber).getLocalTeam());
   	    firstLocalTeamPoint.setText(String.valueOf(games.get(gameNumber).getLocalScore()));
   	    
   	    
   	    firstVisitorTeamName.setText(games.get(gameNumber).getVisitorTeam());
   	    setTeamIcon(firstVisitorTeamIcon, games.get(gameNumber).getVisitorTeam());
   	    firstVisitorTeamPoint.setText(String.valueOf(games.get(gameNumber).getVisitorScore()));
   		
   	} else if (gameNumber ==  GAME_TWO) {
        secondLocalTeamName.setText(games.get(gameNumber).getLocalTeam());
        setTeamIcon(secondLocalTeamIcon, games.get(gameNumber).getLocalTeam());
  	  secondLocalTeamPoint.setText(String.valueOf(games.get(gameNumber).getLocalScore()));
  	  
  	
  	  secondVisitorTeamName.setText(games.get(gameNumber).getVisitorTeam());
  	  setTeamIcon(secondVisitorTeamIcon, games.get(gameNumber).getVisitorTeam());
  	  secondVisitorTeamPoint.setText(String.valueOf(games.get(gameNumber).getVisitorScore()));
  	  
   	} else if (gameNumber ==  GAME_THREE)  {
   		
  	  thirdLocalTeamName.setText(games.get(gameNumber).getLocalTeam());
  	  setTeamIcon(thirdLocalTeamIcon, games.get(gameNumber).getLocalTeam());
  	  thirdLocalTeamPoint.setText(String.valueOf(games.get(gameNumber).getLocalScore()));
  	  
  	  
  	  thirdVisitorTeamName.setText(games.get(gameNumber).getVisitorTeam());
  	  setTeamIcon(thirdVisitorTeamIcon, games.get(gameNumber).getVisitorTeam());
  	  thirdVisitorTeamPoint.setText(String.valueOf(games.get(gameNumber).getVisitorScore()));
   	}
   	

}
 	
//REQUIRES: Object musen't be a null value.
//MODIFIES: this
//EFFECTS : set the appropriate icon for the given team
 
private void setTeamIcon(JLabel label, String teamName) {
    if (teamLogos.containsKey(teamName)) {
        String iconPath = teamLogos.get(teamName);
        label.setIcon(new ImageIcon(ResizeIconStatic(iconPath, 140, 90)));
    } else {
        label.setIcon(null);
    }
}

}
