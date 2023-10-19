package com.standings.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

import com.standings.model.FootballTeamName;
import com.standings.model.Game;
import com.standings.model.Team;

public class StandingsCalculation {
	
	
		public StandingsCalculation(ArrayList<Team> teams,  List<Game> games) {
		
			
			FootballTeamName[] nflTeams = FootballTeamName.values();
			String[] teamsNames = new String[6];
			 
			for (int i = 0; i <  nflTeams.length; i++) {
				 teamsNames[i] = nflTeams[i].toString();
 	    	}
			

		        for (int i = 0; i < teamsNames.length; i++) {
		            String teamName = teamsNames[i];
		            Team team = new Team(teamName);
		            teams.add(team);
		        }
		        
            games = generateMatchesData(teamsNames);
            updateStandings(teams, games);
            //sortStandings(teams);
		
		}
		
		 public static void sortStandings(List<Team> teams) {

	            teams.sort(new Comparator<Team>() {
	                @Override
	                public int compare(Team localTeam, Team visitorTeam) {
	                    int winsDiff = visitorTeam.getWins() - localTeam.getWins();
	                    if (winsDiff != 0) {
	                        return winsDiff;
	                    }
	                    int tiesDiff = visitorTeam.getTies() - localTeam.getTies();
	                    if (tiesDiff != 0) {
	                        return tiesDiff;
	                    }
	                    int lossesDiff = localTeam.getLosses() - visitorTeam.getLosses();
	                    if (lossesDiff != 0) {
	                        return lossesDiff;
	                    }
	                    return visitorTeam.getPoints() - localTeam.getPoints();
	                }
	            });
	        }
	      
	    private static void updateStandings(List<Team> teams, List<Game> games) {
	     	
	    	for (Game game : games) {	
	    		 for (Team team : teams) {
	    			 updateStandingsBasedOnMatch(team, game);
	    	        }    		  		
	    	}		    
	    }
	        
	    private static void updateStandingsBasedOnMatch(Team team, Game game) {
	    	
	        if (team.getName().equals(game.getLocalTeam())) {
	            if (game.getLocalScore() > game.getVisitorScore()) {
	                team.incrementWins();
	            } else if (game.getLocalScore() < game.getVisitorScore()) {
	                team.incrementLosses();
	            } else {
	                team.incrementTies();
	            }
	            team.setPoints(team.getPoints() + game.getLocalScore());
	            team.incrementGamesPlayed();
	            
	        } else if (team.getName().equals(game.getVisitorTeam())) {
	            if (game.getVisitorScore() > game.getLocalScore()) {
	                team.incrementWins();
	            } else if (game.getVisitorScore() < game.getLocalScore()) {
	                team.incrementLosses();
	            } else {
	                team.incrementTies();
	            }
	            team.setPoints(team.getPoints() + game.getVisitorScore());
	            team.incrementGamesPlayed();
	        }
	    }
	    
	    private static List<Game> generateMatchesData(String[] teams) {
	        List<Game> games = new ArrayList<>();
	        Random random = new Random();

	        for (int i = 0; i < teams.length; i++) {
	            for (int j = i + 1; j < teams.length; j++) {
	                int localScore = random.nextInt(30); 
	                int visitorScore = random.nextInt(30);

	                Game match = new Game(teams[i], teams[j], localScore, visitorScore);
	                games.add(match);
	            }
	        }
	        return games;
	    }
}