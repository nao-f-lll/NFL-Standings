package com.standings.model;


public class Team {
    private FootballTeamName teamName;
    private int points;
    private int wins;
    private int losses;
    private int ties;
    
    
    
    public Team(FootballTeamName footballTeam) {
        this.teamName = footballTeam;
         
    }
    
    public String getTeamName() {
        return teamName.toString();
    }
    
    
    public int getPoints() {
        return points;
    }
    
    public int getWins() {
    	return wins;
    }
    
    public int getTies() {
    	return ties;
    }
    
    public int getLosses() {
    	return losses;
    }
   
    public void setPoints(int points) {
        this.points = points;
    }

    public void incrementWins() {
        wins++;
    }

    public void incrementLosses() {
        losses++;
    }

    public void incrementTies() {
        ties++;
    }
 
}


