package com.standings.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.standings.model.FootballTeamName;




public class StandingsDataUtil {
    

	private static final int ALL_POINTS_ARE_INVALID = 3;
	private static final int LOCAL_POINTS_ARE_INVALID = 4;
	private static final int VISITOR_POINTS_ARE_INVALID = 5;

    public static boolean validateStandingsDataForEmpties(String localClubField, String visitorClubField, String localClubPointsField, String visitorClubPointsField) {
       
    	return  checkFordEmptyFields(localClubField, visitorClubField, localClubPointsField, visitorClubPointsField);

    }
    
       
    public static boolean checkFordEmptyFields(String localClubField, String visitorClubField, String localClubPointsField, String visitorClubPointsField) {
    	 
    	boolean localClubEmpty = localClubField.isEmpty();
    	 boolean visitorClubEmpty = visitorClubField.isEmpty();
    	 boolean localClubPointsEmpty = localClubPointsField.isEmpty();
    	 boolean visitorClubPointsEmpty = visitorClubPointsField.isEmpty();
    
    	if (localClubEmpty || visitorClubEmpty || localClubPointsEmpty || visitorClubPointsEmpty) {
    		return true;
    	} else {
    		return false;
    	}
    }
    
    
    public static boolean validateStandingsDataForWrongTeamName(String localClubField, String visitorClubField) {
        
    	return  isNotValidTeamName(localClubField) || isNotValidTeamName(visitorClubField);

    }
    
    
    
    private static boolean isNotValidTeamName(String teamName) {
    	
    	  FootballTeamName[] validTeams = FootballTeamName.values();
    	    for (FootballTeamName team : validTeams) {
    	        if (team.name().equals(teamName)) {
    	            return false;
    	        }
    	        
    	    }
    	    return true;    
    }
    
    
    
    public static int validateStandingsDataForPoints(String localClubPointsField, String visitorClubPointsField) {
        if (areValidPoints(localClubPointsField) && areValidPoints(visitorClubPointsField)) {
            return ALL_POINTS_ARE_INVALID;
        } else if (areValidPoints(localClubPointsField)) {
            return LOCAL_POINTS_ARE_INVALID;
        } else if (areValidPoints(visitorClubPointsField)) {
            return VISITOR_POINTS_ARE_INVALID;
        }

        return 0;
    }

    private static boolean areValidPoints(String points) {
        String regex = "\\b(100|\\d{1,3})\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(points);
        return matcher.find();
    }

    
}
    
  
    




	
	
	
	    


       
   
