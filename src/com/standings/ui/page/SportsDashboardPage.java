package com.standings.ui.page;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import com.standings.model.CustomBorder;
import com.standings.model.FootballTeamName;
import com.standings.model.Game;
import com.standings.model.ParentFrame;
import com.standings.model.Team;
import com.standings.ui.page.panel.StandingsPanel;
import com.standings.ui.page.panel.TeamsPanel;
import com.standings.ui.page.panel.UpdateDataPanel;
import com.standings.util.StandingsCalculation;



public class SportsDashboardPage extends ParentFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    
    private JPanel mainPanel;
    private JPanel panelButton;
    private JPanel scoresPanel;
    private JPanel standingsPanel;
    private JPanel teamsPanel; 
    private JPanel updateDataPanel;
    
    private JButton goToScoresButton;
    private JButton goToStandingButton;
    private JButton goToTeamsButton;
    private JButton goToUpdateDataButton;
    private JLabel standingsLabel;
    private JLabel teamsLabel;
    private JLabel updateDataLabel;
    
    
   
    public SportsDashboardPage() {
        setTitle("Sports Dashboard");
        setResizable(true);
        setSizeAndCenter();

        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        

        scoresPanel = new JPanel();
        standingsPanel = new StandingsPanel();      
        teamsPanel = new TeamsPanel();     
        updateDataPanel = new UpdateDataPanel();
        scoresPanel.setLayout(null);
        standingsPanel.setLayout(null);
        teamsPanel.setLayout(null);
        updateDataPanel.setLayout(null);
        
        standingsLabel = new JLabel("Panel 2 Content");
        standingsLabel.setBounds(636, 248, 162, 13);
        
        teamsLabel = new JLabel("");
        teamsLabel.setBounds(636, 248, 162, 13);
        
        updateDataLabel = new JLabel("");
        updateDataLabel.setBounds(636, 248, 162, 13);
        standingsPanel.add(standingsLabel);
        teamsPanel.add(teamsLabel);
        updateDataPanel.add(updateDataLabel);
       
        
        mainPanel.add(scoresPanel, BorderLayout.CENTER);
       
        
        
       panelButton = new JPanel();
       panelButton.setBounds(0, 0, 1522, 60);
       panelButton.setBackground(Color.WHITE);
       scoresPanel.add(panelButton);
 
               
       goToScoresButton = new JButton("Scores");
       goToScoresButton.setFont(new Font("Tahoma", Font.BOLD, 25));
       goToScoresButton.setBounds(10, 10, 134, 33);
       goToScoresButton.setFocusable(false);
       goToScoresButton.setBackground(Color.WHITE);
       goToScoresButton.setBorder(new CustomBorder(20));
                
       goToStandingButton = new JButton("Standings");
       goToStandingButton.setFont(new Font("Tahoma", Font.BOLD, 25));
       goToStandingButton.setBounds(205, 10, 183, 33);
       goToStandingButton.setFocusable(false);
       goToStandingButton.setBackground(Color.WHITE);
       goToStandingButton.setBorder(null);
       
       goToTeamsButton = new JButton("Teams");
       goToTeamsButton.setFont(new Font("Tahoma", Font.BOLD, 25));
       goToTeamsButton.setBounds(427, 10, 141, 33);
       goToTeamsButton.setFocusable(false);
       goToTeamsButton.setBackground(Color.WHITE);
       goToTeamsButton.setBorder(null);
       
       goToUpdateDataButton = new JButton("Update Data");
       goToUpdateDataButton.setFont(new Font("Tahoma", Font.BOLD, 25));
       goToUpdateDataButton.setBounds(1251, 10, 246, 33);
       goToUpdateDataButton.setFocusable(false);
       goToUpdateDataButton.setBackground(Color.WHITE);
       goToUpdateDataButton.setBorder(null);
               
       goToScoresButton.addActionListener(this);
       goToStandingButton.addActionListener(this);
       goToTeamsButton.addActionListener(this);
       goToUpdateDataButton.addActionListener(this);
       panelButton.setLayout(null);
                
                
       panelButton.add(goToScoresButton);
       panelButton.add(goToStandingButton);
       panelButton.add(goToTeamsButton);
       panelButton.add(goToUpdateDataButton);
          
          
           ///  

             JTable table = new JTable();
             table.setFont(new Font("Tahoma", Font.PLAIN, 20));
             table.setBackground(new Color(255, 255, 255));
             
             ArrayList<Team> teams = new ArrayList<>();
             List<Game> games = new ArrayList<>();
             
 			FootballTeamName[] nflTeams = FootballTeamName.values();
			 
 			for (FootballTeamName nflTeam : nflTeams) {
 				Team team = new Team(nflTeam.name());
 			    teams.add(team);
 	    	}
             
             
          	Object[][] rows = new Object[][] {
          							{null, null, null, null, null, null},
          							{null, null, null, null, null, null},
          							{null, null, null, null, null, null},
          							{null, null, null, null, null, null},
          							{null, null, null, null, null, null},
          							{null, null, null, null, null, null},
          							};
             
          	String[] columns =	new String[] {
          				             		"Team", "Match Played", "Wins", "Losses", "Ties", "Points"
          				             	};
             

            
            
            
            new StandingsCalculation(teams, games);
            
          	int teamIndex = 0;
            
            for (int i = 0; i < rows.length; i++) {
            	for (int j = 0; j < rows[i].length; j++) {        		
           		rows[i][j++] = teams.get(teamIndex).getName();
           		rows[i][j++] = teams.get(teamIndex).getGamesPlayed();
           		rows[i][j++] = teams.get(teamIndex).getWins();
           		rows[i][j++] = teams.get(teamIndex).getLosses();
           		rows[i][j++] = teams.get(teamIndex).getTies();
           		rows[i][j++] = teams.get(teamIndex).getPoints();
            	}  	 
            	teamIndex++;
             }
            
            
            table.setModel(new DefaultTableModel(rows, columns));
            
            
             
             JScrollPane sp = new JScrollPane(table);
             sp.setBounds(10, 70, 1502, 703);

             

             JTableHeader tableHeader = table.getTableHeader();
             Dimension headerSize = tableHeader.getPreferredSize();
             headerSize.height = 100; 
             tableHeader.setPreferredSize(headerSize);
             
             table.getTableHeader().setFont(new Font(null, 20, 20));
             table.getTableHeader().setBackground(Color.LIGHT_GRAY);
             
             
             table.setRowHeight(100);
       
             table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
             scoresPanel.add(sp, BorderLayout.CENTER);
       
  
	        
	   

  ///

             
             getContentPane().setLayout(new BorderLayout());
             getContentPane().add(mainPanel, BorderLayout.CENTER);
     	        
    }

    private void setSizeAndCenter() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        setSize(screenSize.width, screenSize.height);
        setLocationRelativeTo(null);
    }

    private void showPanel(JPanel panelToShow) {
        mainPanel.removeAll();
        mainPanel.add(panelButton);
        mainPanel.add(panelToShow, BorderLayout.CENTER);
        mainPanel.revalidate();
        mainPanel.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Map<JButton, JPanel> buttonPanelMap = new HashMap<>();
        buttonPanelMap.put(goToScoresButton, scoresPanel);
        buttonPanelMap.put(goToStandingButton, standingsPanel);
        buttonPanelMap.put(goToTeamsButton, teamsPanel);
        buttonPanelMap.put(goToUpdateDataButton, updateDataPanel);

        // Reset all button borders to null
        for (JButton button : buttonPanelMap.keySet()) {
            button.setBorder(null);
        }

        // Check which button was clicked
        JButton clickedButton = (JButton) e.getSource();
        JPanel panelToShow = buttonPanelMap.get(clickedButton);

        if (panelToShow != null) {
            clickedButton.setBorder(new CustomBorder(20));
            showPanel(panelToShow);
        }
    }
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
			        new SportsDashboardPage();			    
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
