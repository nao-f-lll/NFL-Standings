package com.standings.model;

public class Game {
	
	 private final String localTeam;
	    private final String visitorTeam;
	    private int localScore;
	    private int visitorScore;
	    
	    private int oldLocalScore;
	    private int oldVisitorScore;

	    public Game(String localTeam, String visitorTeam, int localScore, int visitorScore, int oldLocalScore, int oldVisitorScore) {
	    	
	        this.localTeam = localTeam;
	        this.visitorTeam = visitorTeam;
	        this.localScore = localScore;
	        this.visitorScore = visitorScore;
	        
	        this.oldLocalScore = oldLocalScore;
	        this.oldVisitorScore = oldVisitorScore;
	        
	    }

	    // getters
	    
	    public String getLocalTeam() { return localTeam; }

	    public String getVisitorTeam() { return visitorTeam; }

	    public int getLocalScore() { return localScore; }

	    public int getVisitorScore() { return visitorScore; }
	    
	    
	    public int getOldLocalScore() { return oldLocalScore; }
	    
	    public int getOldVisitorScore() { return oldVisitorScore; }
	    
	    // setters

	    public void setLocalScore(int localScore)     {  this.localScore = localScore; }

	    public void setVisitorScore(int visitorScore) {  this.visitorScore = visitorScore;}
	    
	    
	    public void setOldLocalScore(int oldLocalScore) { this.oldLocalScore = oldLocalScore; }
	    
	    public void setOldVisitorScore(int oldVisitorScore) { this.oldVisitorScore = oldVisitorScore; }
	    

}
