package com.standings.util;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
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

	
		public StandingsCalculation(ArrayList<Team> teams,  List<Game> games, List<List<Game>> weeks) {
		 
			asignteamNames();
			initializeTheCalculation(teamsNames, teams, games, weeks);
			
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
		
		private static void initializeTheCalculation(String[] teamsNames, ArrayList<Team> teams,  List<Game> games, List<List<Game>> weeks) {
			
			games.addAll(generateMatchesDataFirstHalfPart(teamsNames)); 
			games.addAll(generateMatchesDataSecondHalfPart(teamsNames));
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
		  //EFFECTS  : update the fields of a team based on the given games.
		 
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
	    		
	    		boolean areOldAndNewgamesTies = game.getOldLocalScore() == game.getOldVisitorScore() && game.getLocalScore() == game.getVisitorScore();
	    		boolean areOldAndNewgamesWins = game.getOldLocalScore() > game.getOldVisitorScore() && game.getLocalScore() > game.getVisitorScore();
	    		boolean areOldAndNewgamesLose = game.getOldLocalScore() < game.getOldVisitorScore() && game.getLocalScore() < game.getVisitorScore();
	    		
	    		if (areOldAndNewgamesTies || areOldAndNewgamesWins || areOldAndNewgamesLose) {
	    			
	    			if (team.getName().equals(game.getLocalTeam())) {
	    				
	    				team.setPoints(team.getPoints() - game.getOldLocalScore() + game.getLocalScore());
	    			} 
	    			if (team.getName().equals(game.getVisitorTeam())) {
	    				team.setPoints(team.getPoints() - game.getOldLocalScore() + game.getLocalScore());
	    			}
	    			
	    		} else {
	    			    		
	    		
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
	    	    			} else if (game.getOldLocalScore() > game.getOldVisitorScore()){
	    	    				team.decrementWins();
	    	    				team.incrementTies();
	    	    			} else if (game.getOldLocalScore() < game.getOldVisitorScore()) {
	    	    				team.decrementLosses();
	    	    				team.incrementTies();
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
	    	    			
	    	    			} else if (game.getOldLocalScore() < game.getOldVisitorScore()){
	    	    				team.decrementWins();
	    	    				team.incrementTies();
	    	    			} else if (game.getOldLocalScore() > game.getOldVisitorScore()) {
	    	    				team.decrementLosses();
	    	    				team.incrementTies();
	    	    			} else {
	    	    				team.incrementTies();
	    	    			}
	    	    			team.setPoints(team.getPoints() - game.getOldVisitorScore() + game.getVisitorScore());
	    	    		}
	    	    	}	
	    	      
	    			}
	    		}
    
	    	}

	    
		  //MODIFIES : games
		  //EFFECTS  : returns the games list filled with random matches data.	
	    
	    private static List<Game> generateMatchesDataFirstHalfPart(String[] teams) {
	        List<Game> games = new ArrayList<>();
	        int totalWeeks = 5;
	        int gamesPerWeek = teams.length / 2;

	        for (int week = 1; week <= totalWeeks; week++) {
	            for (int i = 0; i < gamesPerWeek; i++) {
	                String team1 = teams[i];
	                String team2 = teams[teams.length - 1 - i];

	                int localScore = (int) (Math.random() * 31);
	                int visitorScore = (int) (Math.random() * 31);

	                Game game = new Game(team1, team2, localScore, visitorScore, defaultLocalScore, defaultVisitorScore, week);
	                games.add(game);

	            }

	        
	            rotateTeamsArray(teams);
	        }

	        return games;
	    }
	    
	    
		  //MODIFIES : games
		  //EFFECTS  : returns the games list filled with random matches data.	
	    private static List<Game> generateMatchesDataSecondHalfPart(String[] teams) {
	        List<Game> games = new ArrayList<>();
	        int totalWeeks = 9;
	        int gamesPerWeek = teams.length / 2;

	        for (int week = 6; week <= totalWeeks; week++) {
	            for (int i = 0; i < gamesPerWeek; i++) {
	                String team1 = teams[i];
	                String team2 = teams[teams.length - 1 - i];

	                int localScore = (int) (Math.random() * 31);
	                int visitorScore = (int) (Math.random() * 31);

	                Game game = new Game(team2, team1, localScore, visitorScore, defaultLocalScore, defaultVisitorScore, week);
	                games.add(game);

	            }

	        
	            rotateTeamsArray(teams);
	        }

	        return games;
	    }

	    private static void rotateTeamsArray(String[] teams) {
	        String temp = teams[teams.length - 1];
	        System.arraycopy(teams, 1, teams, 2, teams.length - 2);
	        teams[1] = temp;
	    }
	    
}