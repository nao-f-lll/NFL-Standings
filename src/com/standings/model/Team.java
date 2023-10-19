package com.standings.model;


public class Team {
	 	private final String name;
	    private int points;
	    private int gamesPlayed;
	    private int wins;
	    private int losses;
	    private int ties;

	    public Team(String name) {
	        this.name = name;
	        this.points = 0;
	        this.gamesPlayed = 0;
	        this.wins = 0;
	        this.losses = 0;
	        this.ties = 0;
	    }

	    public String getName() {
	        return name;
	    }

	    public int getPoints() {
	        return points;
	    }
	    
	    public int getGamesPlayed() {
	        return gamesPlayed;
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
	    
	    public void incrementGamesPlayed() {
	    	gamesPlayed++;
	    }

	    @Override
	    public String toString() {
	        return name + ": " + wins + " Wins, " + ties + " Ties, " + losses + " Losses, " + points + " Points";
	    }
	    
 
}


