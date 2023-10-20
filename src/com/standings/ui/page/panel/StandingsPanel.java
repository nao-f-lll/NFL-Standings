package com.standings.ui.page.panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import com.standings.model.FootballTeamName;
import com.standings.model.Game;
import com.standings.model.ParentFrame;
import com.standings.model.Team;
import com.standings.util.StandingsCalculation;

public class StandingsPanel extends JPanel  {
   

	private static final long serialVersionUID = 1L;
	
	private JTable table;
	private ArrayList<Team> teams;
	private List<Game> games;
	private FootballTeamName[] nflTeams;
	private Object[][] rows;
	private String[] columns;

		public StandingsPanel( ArrayList<Team> teams, List<Game> games) {
	    	

            table = new JTable();
            table.setEnabled(false);
            table.setFont(new Font("Tahoma", Font.PLAIN, 20));
            table.setBackground(new Color(255, 255, 255));
            
            this.teams = teams;
            this.games = games;
            
			nflTeams = FootballTeamName.values();
			 
			ImageIcon cardinalsLogo = new ImageIcon(ParentFrame.ResizeIconStatic("/images/cardinals.png",100,60));
			ImageIcon chiefsLogo = new ImageIcon(ParentFrame.ResizeIconStatic("/images/chiefs.png",100,60));
			ImageIcon cowboysLogo = new ImageIcon(ParentFrame.ResizeIconStatic("/images/cowboys.png",100,60));
			ImageIcon steelersLogo = new ImageIcon(ParentFrame.ResizeIconStatic("/images/steelers.png",100,60));
			ImageIcon raidersLogo = new ImageIcon(ParentFrame.ResizeIconStatic("/images/raiders.png",100,60));
			ImageIcon bengalsLogo = new ImageIcon(ParentFrame.ResizeIconStatic("/images/bengals.png",100,60));
			
			ImageIcon[] icons = {cowboysLogo, cardinalsLogo, chiefsLogo, bengalsLogo, raidersLogo, steelersLogo};
			
			
			int logoIndex = 0;
			
			for (FootballTeamName nflTeam : nflTeams) {
				Team team = new Team(nflTeam.name(), icons[logoIndex]);
				this.teams.add(team);
			   logoIndex++;
	    	}
            
            
         	rows = new Object[][] {
         							{null, null, null, null, null, null},
         							{null, null, null, null, null, null},
         							{null, null, null, null, null, null},
         							{null, null, null, null, null, null},
         							{null, null, null, null, null, null},
         							{null, null, null, null, null, null},
         							};
            
         	columns =	new String[] {
         				             		"Team", "Match Played", "Wins", "Losses", "Ties", "Points"
         				             	};										

           
           
          
           new StandingsCalculation(this.teams, this.games);
                 
           
          int teamIndex = 0;
           
           for (int i = 0; i < rows.length; i++) {
           	 
               Object[] teamInfo = new Object[2];
               teamInfo[0] = this.teams.get(teamIndex).getLogo();
               teamInfo[1] = this.teams.get(teamIndex).getName();
               
               rows[i][0] = teamInfo;
          		rows[i][1] = this.teams.get(teamIndex).getGamesPlayed();
          		rows[i][2] = this.teams.get(teamIndex).getWins();
          		rows[i][3] = this.teams.get(teamIndex).getLosses();
          		rows[i][4] = this.teams.get(teamIndex).getTies();
          		rows[i][5] = this.teams.get(teamIndex).getPoints();
            	 
           	teamIndex++;
            }
         
           table.setModel(new DefaultTableModel(rows, columns));
           
         
           table.getColumnModel().getColumn(0).setCellRenderer(new DefaultTableCellRenderer() {
         
			private static final long serialVersionUID = -2661844236545326544L;

			@Override
               public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                   if (value instanceof Object[]) {
                       Object[] teamInfo = (Object[]) value;
                       if (teamInfo.length == 2) {
                           ImageIcon logo = (ImageIcon) teamInfo[0];
                           String name = (String) teamInfo[1];

                           JLabel label = new JLabel(name, logo, JLabel.LEFT);
                           label.setOpaque(true);
                           label.setBackground(isSelected ? table.getSelectionBackground() : table.getBackground());
                           label.setFont(new Font(null, 20,20));
                           return label;
                       }
                   }
                   return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
               }
           });
           
                  
         JScrollPane sp = new JScrollPane(table);
         sp.setEnabled(false);
         sp.setBounds(10, 70, 1502, 703);


         JTableHeader tableHeader = table.getTableHeader();
         Dimension headerSize = tableHeader.getPreferredSize();
         headerSize.height = 100; 
         tableHeader.setPreferredSize(headerSize);
         tableHeader.setReorderingAllowed(false);
            
         table.getTableHeader().setFont(new Font(null, 20, 20));
         table.getTableHeader().setBackground(Color.LIGHT_GRAY);
            
     
         DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();

         centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

         table.setDefaultRenderer(Object.class, centerRenderer);
            
            table.setRowHeight(100);
         
            table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
            this.add(sp, BorderLayout.CENTER);

	}
}