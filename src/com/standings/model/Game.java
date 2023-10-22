package com.standings.model;

public class Game {
	
	 private final String localTeam;
	    private final String visitorTeam;
	    private int localScore;
	    private int visitorScore;

	    public Game(String localTeam, String visitorTeam, int localScore, int visitorScore) {
	    	
	        this.localTeam = localTeam;
	        this.visitorTeam = visitorTeam;
	        this.localScore = localScore;
	        this.visitorScore = visitorScore;
	        
	    }

	    // getters
	    
	    public String getLocalTeam() { return localTeam; }

	    public String getVisitorTeam() { return visitorTeam; }

	    public int getLocalScore() { return localScore; }

	    public int getVisitorScore() { return visitorScore; }
	    
	    // setters

	    public void setLocalScore(int localScore)     {  this.localScore = localScore; }

	    public void setVisitorScore(int visitorScore) {  this.visitorScore = visitorScore;}

}
