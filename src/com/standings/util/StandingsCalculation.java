package com.standings.util;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

import com.standings.model.FootballTeamName;
import com.standings.model.Game;
import com.standings.model.Team;

public class StandingsCalculation {

	private final static String NEW_STANDINGS_TYPE = "New entry";
	private final static String EXISTING_STANDINGS_TYPE = "Exisitng entry";
	private final static int defaultLocalScore = 0;
	private final static int  defaultVisitorScore = 0;
	
	private FootballTeamName[] nflTeams;
	private String[] teamsNames;
	
		public StandingsCalculation(ArrayList<Team> teams,  List<Game> games) {
		 
			asignteamNames();
			initializeTheCalculation(teamsNames, teams, games);
		}
		
		
		  //MODIFIES : this
		  //EFFECTS  : extract the teams names from FootballTeamName and puts them in an array.
		
		private void asignteamNames () {
			nflTeams = FootballTeamName.values();
			teamsNames = new String[6];
			 
			for (int i = 0; i <  nflTeams.length; i++) {
				 teamsNames[i] = nflTeams[i].toString();
 	    	}
		}
		
		  //MODIFIES : teams, games
		  //EFFECTS  : generate and update the standings table data.
		
		private static void initializeTheCalculation(String[] teamsNames, ArrayList<Team> teams,  List<Game> games) {
			
			games.addAll(generateMatchesData(teamsNames)); 
			updateStandings(teams, games);           
			sortStandings(teams);
		}
		
		  //REQUIRES : list musen't be empty.
		  //MODIFIES : Team
		  //EFFECTS  : sort the teams based on theirs fields in this order,
		  //          (e.g wins, ties, losses, points)
		
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
		 
		 	 
		  //MODIFIES : Team
		  //EFFECTS  : update the fields of a team based on the given game.
		 
		 public static void updateStandings(Team team, Game game, String type) {
			 updateStandingsBasedOnMatch(team, game, type);
		 }
	    
		  //REQUIRES : list of teams and list of games musn't be null.
		  //MODIFIES : Team
		  //EFFECTS  : update the fields of a teams based on the given games.
		 
	    public static void updateStandings(List<Team> teams, List<Game> games) {
	     	
	    	for (Game game : games) {	
	    		 for (Team team : teams) {
	    			 updateStandingsBasedOnMatch(team, game, NEW_STANDINGS_TYPE);
	    	        }    		  		
	    	}		    
	    }
	    
		  //MODIFIES : Team
		  //EFFECTS  : if a team is present in a game, update it's fields based on the game data.
		         
	    private static void updateStandingsBasedOnMatch(Team team, Game game, String type) {
	    	
	    	if (type.equals(NEW_STANDINGS_TYPE)) {
	    		
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
	    		
    		
	    		
	    	} else if (type.equals(EXISTING_STANDINGS_TYPE)) {
	    	    	if (game.getOldLocalScore() == game.getOldVisitorScore()) {
	    	    		if (team.getName().equals(game.getLocalTeam())) {
	    	    			if (game.getLocalScore() > game.getVisitorScore()) {
	    	    				team.incrementWins();
	    	    				team.decrementTies();
	    	    			} else if (game.getLocalScore() < game.getVisitorScore()) {
	    	    				team.incrementLosses();
	    	    				team.decrementTies();
	    	    			} else {
	    	    				team.incrementTies();
	    	    			}
	    	    			team.setPoints(team.getPoints() - game.getOldLocalScore() + game.getLocalScore());
	    	    		}
	    	        
	    	    		if (team.getName().equals(game.getVisitorTeam())) {
	    	    			if (game.getVisitorScore() > game.getLocalScore()) {
	    	    				team.incrementWins();
	    	    				team.decrementTies();
	    	    			} else if (game.getVisitorScore() < game.getLocalScore()) {
	    	    				team.incrementLosses();
	    	    				team.decrementTies();
	    	    			} else {
	    	    				team.incrementTies();
	    	    			}
	    	    			team.setPoints(team.getPoints() - game.getOldVisitorScore() + game.getVisitorScore());
	    	    		}
	    	    	} else {
	    	    		if (team.getName().equals(game.getLocalTeam())) {
	    	    			if (game.getLocalScore() > game.getVisitorScore()) {
	    	    				team.incrementWins();
	    	    				team.decrementLosses();
	    	    			} else if (game.getLocalScore() < game.getVisitorScore()) {
	    	    				team.incrementLosses();
	    	    				team.decrementWins();
	    	    			} else {
	    	    				team.incrementTies();
	    	    			}
	    	    			team.setPoints(team.getPoints() - game.getOldLocalScore() + game.getLocalScore());
	    	    		}
	    	        
	    	    		if (team.getName().equals(game.getVisitorTeam())) {
	    	    			if (game.getVisitorScore() > game.getLocalScore()) {
	    	    				team.incrementWins();
	    	    				team.decrementLosses();
	    	    			} else if (game.getVisitorScore() < game.getLocalScore()) {
	    	    				team.incrementLosses();
	    	    				team.decrementWins();
	    	    			} else {
	    	    				team.incrementTies();
	    	    			}
	    	    			team.setPoints(team.getPoints() - game.getOldVisitorScore() + game.getVisitorScore());
	    	    		}
	    	    	}	
	    	      
	    		}
    
	    	}

	    
		  //MODIFIES : games
		  //EFFECTS  : returns the games list filled with random matches data.		 
	    
	    private static List<Game> generateMatchesData(String[] teams) {
	        List<Game> games = new ArrayList<>();
	        Random random = new Random();

	        for (int i = 0; i < teams.length; i++) {
	            for (int j = i + 1; j < teams.length; j++) {
	                int localScore = random.nextInt(30); 
	                int visitorScore = random.nextInt(30);

	                Game match = new Game(teams[i], teams[j], localScore, visitorScore, defaultLocalScore, defaultVisitorScore);
	                games.add(match);
	                
	                System.out.println(match.getLocalTeam()+ " " + match.getLocalScore() + " " + match.getVisitorTeam() + " " + match.getVisitorScore() );
	            }
	        }
	        return games;
	    }
	    
}