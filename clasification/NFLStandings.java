package clasificacion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class NFLStandings {
    public static void main(String[] args) {
    	
        List<NFLTeam> teams = new ArrayList<>();
        
        String[] teamsNames = {"Cardinals", "Raiders", "Steelers", "Chiefs", "Cowboys", "Bengals"};

        for (int i = 0; i < 6; i++) {
            String teamName = teamsNames[i];
            NFLTeam team = new NFLTeam(teamName);
            teams.add(team);
        }
                   
            List<Match> matches = generateMatchesData(teamsNames);
            matches.addAll(generateMatchesData(teamsNames));
            
            System.out.println("Generated Matches Data:");
            for (Match match : matches) {
                System.out.println(match);
            }
           	 	
      
        	updateStandings(teams, matches);
        	
            
            // Sort teams based on NFL criteria
            Collections.sort(teams, new Comparator<NFLTeam>() {
                @Override
                public int compare(NFLTeam localTeam, NFLTeam visitorTeam) {
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
            

    
            // Display updated standings
            System.out.println("NFL Standings:");
            int rank = 1;
            for (NFLTeam team : teams) {
                System.out.println(rank + ". " + team);
                rank++;
            }
        }
    

    private static void updateStandings(List<NFLTeam> teams, List<Match> matches) {
    	
    	
    	for (Match match : matches) {	
    		 for (NFLTeam team : teams) {
    			 updateStandingsBasedOnMatch(team, match);
    	        }    		  		
    	}		
       
    }
     
   
    private static void updateStandingsBasedOnMatch(NFLTeam team, Match game) {
    	
        if (team.getName().equals(game.getLocalTeam())) {
            if (game.getLocalScore() > game.getVisitorScore()) {
                team.incrementWins();
            } else if (game.getLocalScore() < game.getVisitorScore()) {
                team.incrementLosses();
            } else {
                team.incrementTies();
            }
            team.setPoints(team.getPoints() + game.getLocalScore());
            
        } else if (team.getName().equals(game.getVisitorTeam())) {
            if (game.getVisitorScore() > game.getLocalScore()) {
                team.incrementWins();
            } else if (game.getVisitorScore() < game.getLocalScore()) {
                team.incrementLosses();
            } else {
                team.incrementTies();
            }
            team.setPoints(team.getPoints() + game.getVisitorScore());
        
    }
    }
    
    private static List<Match> generateMatchesData(String[] teams) {
        List<Match> matches = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < teams.length; i++) {
            for (int j = i + 1; j < teams.length; j++) {
                int localScore = random.nextInt(30); 
                int visitorScore = random.nextInt(30);

                Match match = new Match(teams[i], teams[j], localScore, visitorScore);
                matches.add(match);
            }
        }

        return matches;
    

}
}