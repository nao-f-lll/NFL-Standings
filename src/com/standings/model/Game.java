package com.standings.model;

public class Game {
	
	 private final String localTeam;
	    private final String visitorTeam;
	    private final int localScore;
	    private final int visitorScore;

	    public Game(String localTeam, String visitorTeam, int localScore, int visitorScore) {
	    	
	        this.localTeam = localTeam;
	        this.visitorTeam = visitorTeam;
	        this.localScore = localScore;
	        this.visitorScore = visitorScore;
	        
	    }

	    public String getLocalTeam() {
	        return localTeam;
	    }

	    public String getVisitorTeam() {
	        return visitorTeam;
	    }

	    public int getLocalScore() {
	        return localScore;
	    }

	    public int getVisitorScore() {
	        return visitorScore;
	    }

	    @Override
	    public String toString() {
	        return localTeam + " " + localScore + " - " + visitorScore + " " + visitorTeam;
	    }
}
