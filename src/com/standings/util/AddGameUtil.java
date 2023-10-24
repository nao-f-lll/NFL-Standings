package com.standings.util;

import java.util.List;

import com.standings.model.Game;

public class AddGameUtil {
	
	private final int defaultLocalScore = 0;
	private final int  defaultVisitorScore = 0;
	private Game game;

	
	public AddGameUtil(List<Game> games, String localClubField, String visitorClubField, String localClubPointsField, String visitorClubPointsField) {
	          
        game = new Game(localClubField, visitorClubField,Integer.parseInt(localClubPointsField),Integer.parseInt(visitorClubPointsField), defaultLocalScore, defaultVisitorScore);           
        games.add(game);
	}
	
}