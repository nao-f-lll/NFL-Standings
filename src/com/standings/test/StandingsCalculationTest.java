package com.standings.test;
/*
import org.junit.Before;
import com.standings.model.Game;
import com.standings.model.ParentFrame;
import com.standings.model.Team;
import javax.swing.ImageIcon;

public class StandingsCalculationTest {
    private Team cardinals;
    private Team cowboys;
    private Game cardinalsWinGame;
    private Game cowboyWinGame;
    private Game tieGame;

    @Before
    public void setUp() {
    	cardinals = new Team("Cardinals", new ImageIcon(ParentFrame.ResizeIconStatic("/images/cardinals.png",100,60)));
    	cowboys = new Team("Cowboys", new ImageIcon(ParentFrame.ResizeIconStatic("/images/cowboys.png",100,60)));
    	
    	cardinalsWinGame = new Game("Cardinals", "Cowboys", 10, 5, 0, 0);
    	
    	cowboyWinGame = new Game("Cowboys", "Cardinals", 5, 10, 0, 0);
    	
    	tieGame = cardinalsWinGame;
    	tieGame.setLocalScore(5);
    	tieGame.setVisitorScore(5);
    	tieGame.setLocalScore(10);
    	tieGame.setVisitorScore(5);
    	
    }
/*
    @Test
    public void testUpdateStandingsForNewEntry() {
    	
        StandingsCalculation.updateStandingsBasedOnMatch(team, game, "New entry");

        assertEquals(1, team.getGamesPlayed());
        assertEquals(0, team.getTies());
       
    }
    
    */

    /*
    @Test
    public void testUpdateStandingsForExistingEntry() {
        // Set up the initial standings for the team
        team.setGamesPlayed(10);
        team.setWins(5);
        team.setLosses(3);
        team.setTies(2);
        team.setPoints(20);

        // Set up the game with old scores
        game.setOldLocalScore(2);
        game.setOldVisitorScore(2);

        // Set the new scores for the game
        game.setLocalScore(3);
        game.setVisitorScore(1);

        StandingsUpdater.updateStandingsBasedOnMatch(team, game, "Existing entry");

        assertEquals(11, team.getGamesPlayed());
        assertEquals(6, team.getWins());
        assertEquals(3, team.getLosses());
        assertEquals(2, team.getTies());
        assertEquals(21, team.getPoints());
        // Add more assertions for other attributes in Team
    }
    
}
*/