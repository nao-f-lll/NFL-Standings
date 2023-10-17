package com.standings.model;


public class Team {
    private FootballTeamName footballTeam;
    private String teamName;  // You can add other attributes as needed
    
    public Team(FootballTeamName footballTeam, String teamName) {
        this.footballTeam = footballTeam;
        this.teamName = teamName;
    }
    
    public FootballTeamName getFootballTeam() {
        return footballTeam;
    }
    
    public String getTeamName() {
        return teamName;
    }
    
    // You can add other methods and attributes as needed
}


