package com.standings.ui.page.panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.standings.ui.page.panel.subpanel.*;

import com.standings.model.CustomBorder;
import com.standings.model.CustomButton;
import com.standings.model.Game;
import com.standings.model.Team;

public class ScoresPanel extends JPanel implements ActionListener{

	private static final long serialVersionUID = 2653188263518760831L;

	
	private WeekOnePanel weekOnePanel;
	private WeekTwoPanel weekTwoPanel;
	private WeekThreePanel weekThreePanel;
	private WeekFourPanel weekFourPanel;
	private WeekFivePanel weekFivePanel;	
	private WeekSixPanel weekSixPanel;
	private WeekSevenPanel weekSevenPanel;
	private WeekEighthPanel weekEighthPanel;
	private WeekNinePanel weekNinePanel;
	private WeekTenPanel weekTenPanel;
	
	private JPanel weeksPanelButton;
	private JPanel panelButton;
	
	private JButton weekOneButton;
	private JButton weekTwoButton;
	private JButton weekThreeButton;
	private JButton weekFourButton;
	private JButton weekFiveButton;
	private JButton weekSixButton;
	private JButton weekSevenButton;
	private JButton weekEighthButton;
	private JButton weekNineButton;
	private JButton weekTenButton;
	
	private ArrayList<Team> teams;
	private List<Game> games;
	private Map<String, String> teamLogos = new HashMap<>();
	
	public ScoresPanel(JPanel panelButton, ArrayList<Team> teams, List<Game> games, List<List<Game>> weeks) {
	       
		
		this.panelButton = panelButton;
		this.games = games;
		this.teams = teams;
		
		initializeTeamLogos();
		initializeWeekPanels();
				
	       weeksPanelButton = new JPanel();
	       weeksPanelButton.setLayout(null);
	       weeksPanelButton.setBackground(Color.WHITE);
	       weeksPanelButton.setBounds(0, 62, 1522, 60);
	       this.add(weeksPanelButton);

	       int buttonWidth = 120;
	       int horizontalGap = 33; 
	       int initialX = 10;

	       weekOneButton = new JButton("J-1");
	       weekOneButton.setFont(new Font("Tahoma", Font.BOLD, 25));
	       weekOneButton.setFocusable(false);
	       weekOneButton.setBorder(new CustomBorder(20));
	       weekOneButton.setBackground(Color.WHITE);
	       weekOneButton.setBounds(initialX, 10, buttonWidth, 33);
	       weekOneButton.setUI(new CustomButton()); 
	       weekOneButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
	       weeksPanelButton.add(weekOneButton);
	       


	       weekTwoButton = new JButton("J-2");
	       weekTwoButton.setFont(new Font("Tahoma", Font.BOLD, 25));
	       weekTwoButton.setFocusable(false);
	       weekTwoButton.setUI(new CustomButton());
	       weekTwoButton.setBorder(null);
	       weekTwoButton.setBackground(Color.WHITE);
	       weekTwoButton.setBounds(initialX += buttonWidth + horizontalGap, 10, buttonWidth, 33);  
	       weekTwoButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
	       weeksPanelButton.add(weekTwoButton);
	       
	       
	       weekThreeButton = new JButton("J-3");
	       weekThreeButton.setFont(new Font("Tahoma", Font.BOLD, 25));
	       weekThreeButton.setFocusable(false);
	       weekThreeButton.setUI(new CustomButton());
	       weekThreeButton.setBorder(null);
	       weekThreeButton.setBackground(Color.WHITE);
	       weekThreeButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
	       weekThreeButton.setBounds(initialX += buttonWidth + horizontalGap, 10, buttonWidth, 33);
	       weeksPanelButton.add(weekThreeButton);
	       
	       

	       
	       weekFourButton  = new JButton("J-4");
	       weekFourButton.setFont(new Font("Tahoma", Font.BOLD, 25));
	       weekFourButton.setFocusable(false);
	       weekFourButton.setUI(new CustomButton());
	       weekFourButton.setBorder(null);
	       weekFourButton.setBackground(Color.WHITE);
	       weekFourButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
	       weekFourButton.setBounds(initialX += buttonWidth + horizontalGap, 10, buttonWidth, 33);
	       weeksPanelButton.add(weekFourButton);
	       
	  
	       
	       weekFiveButton = new JButton("J-5");
	       weekFiveButton.setFont(new Font("Tahoma", Font.BOLD, 25));
	       weekFiveButton.setFocusable(false);
	       weekFiveButton.setUI(new CustomButton());
	       weekFiveButton.setBorder(null);
	       weekFiveButton.setBackground(Color.WHITE);  
	       weekFiveButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
	       weekFiveButton.setBounds(initialX += buttonWidth + horizontalGap, 10, buttonWidth, 33);
	       weeksPanelButton.add(weekFiveButton);
	       
	       
	      
	       
	       weekSixButton  = new JButton("J-6");
	       weekSixButton.setFont(new Font("Tahoma", Font.BOLD, 25));
	       weekSixButton.setFocusable(false);
	       weekSixButton.setUI(new CustomButton());
	       weekSixButton.setBorder(null);
	       weekSixButton.setBackground(Color.WHITE); 
	       weekSixButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
	       weekSixButton.setBounds(initialX += buttonWidth + horizontalGap, 10, buttonWidth, 33);
	       weeksPanelButton.add(weekSixButton);
	       
	       
	       
	       
	       
	       weekSevenButton = new JButton("J-7");
	       weekSevenButton.setFont(new Font("Tahoma", Font.BOLD, 25));
	       weekSevenButton.setFocusable(false);
	       weekSevenButton.setUI(new CustomButton());
	       weekSevenButton.setBorder(null);
	       weekSevenButton.setBackground(Color.WHITE); 
	       weekSevenButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
	       weekSevenButton.setBounds(initialX += buttonWidth + horizontalGap, 10, buttonWidth, 33);
	       weeksPanelButton.add(weekSevenButton);


	       
	       weekEighthButton = new JButton("J-8");
	       weekEighthButton.setFont(new Font("Tahoma", Font.BOLD, 25));
	       weekEighthButton.setFocusable(false);
	       weekEighthButton.setUI(new CustomButton());
	       weekEighthButton.setBorder(null);
	       weekEighthButton.setBackground(Color.WHITE); 
	       weeksPanelButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
	       weekEighthButton.setBounds(initialX += buttonWidth + horizontalGap, 10, buttonWidth, 33);
	       weeksPanelButton.add(weekEighthButton);
	       
	       
	       
	       
	       weekNineButton = new JButton("J-9");
	       weekNineButton.setFont(new Font("Tahoma", Font.BOLD, 25));
	       weekNineButton.setFocusable(false);
	       weekNineButton.setUI(new CustomButton());
	       weekNineButton.setBorder(null);
	       weekNineButton.setBackground(Color.WHITE);
	       weekNineButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
	       weekNineButton.setBounds(initialX += buttonWidth + horizontalGap, 10, buttonWidth, 33);
	       weeksPanelButton.add(weekNineButton);
	       
	       
	  
	       
	       weekTenButton = new JButton("J-10");
	       weekTenButton.setFont(new Font("Tahoma", Font.BOLD, 25));
	       weekTenButton.setFocusable(false);
	       weekTenButton.setUI(new CustomButton());
	       weekTenButton.setBorder(null);
	       weekTenButton.setBackground(Color.WHITE); 
	       weekTenButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
	       weekTenButton.setBounds(initialX += buttonWidth + horizontalGap, 10, buttonWidth, 33);
	       weeksPanelButton.add(weekTenButton);
	       
	       
	       weekOneButton.addActionListener(this);
	       weekTwoButton.addActionListener(this);
	       weekThreeButton.addActionListener(this);
	       weekFourButton.addActionListener(this);       
	       weekFiveButton.addActionListener(this);       
	       weekSixButton.addActionListener(this);
	       weekSevenButton.addActionListener(this);
	       weekEighthButton.addActionListener(this);
	       weekNineButton.addActionListener(this);
	       weekTenButton.addActionListener(this);
	          
	}
	
	public void initializeWeekPanels() {
		
		 weekOnePanel    = new WeekOnePanel(this.teams, this.games, teamLogos);
		 weekTwoPanel    = new WeekTwoPanel(this.teams, this.games, teamLogos);
		 weekThreePanel  = new WeekThreePanel(this.teams, this.games, teamLogos);
		 weekFourPanel   = new WeekFourPanel(this.teams, this.games, teamLogos);
		 weekFivePanel   = new WeekFivePanel(this.teams, this.games, teamLogos);
		 weekSixPanel    = new WeekSixPanel(this.teams, this.games, teamLogos);
		 weekSevenPanel  = new WeekSevenPanel(this.teams, this.games, teamLogos);
		 weekEighthPanel = new WeekEighthPanel(this.teams, this.games, teamLogos);
		 weekNinePanel   = new WeekNinePanel(this.teams, this.games, teamLogos);
		 weekTenPanel   = new WeekTenPanel(this.teams, this.games, teamLogos);

		
		 this.add(weekOnePanel);
	}
	
	public void renderWeeksScores(int selectedWeek) {
		
		int totalnumberOfGames;
		int firstGameNumber;
		int secondGameNumber;
		int lastGameNumber;
		int gameNumber;
		
		switch (selectedWeek) {
		case 1:
			weekOnePanel.addGameInfo(this.teams, this.games);
			break;
		case 2:
			weekTwoPanel.addGameInfo(this.teams, this.games);
			break;
		case 3:
			weekThreePanel.addGameInfo(this.teams, this.games);
			break;
		case 4:
			weekFourPanel.addGameInfo(this.teams, this.games);
			break;
		case 5:
			weekFivePanel.addGameInfo(this.teams, this.games);
			break;	
		case 6:
			weekSixPanel.addGameInfo(this.teams, this.games);
			break;
		case 7:
			weekSevenPanel.addGameInfo(this.teams, this.games);
			break;
		case 8:
			weekEighthPanel.addGameInfo(this.teams, this.games);
			break;
		case 9:
			weekNinePanel.addGameInfo(this.teams, this.games);
			break;
		case 10:	
			 totalnumberOfGames = games.size();
			 if (totalnumberOfGames == 30) {
				 firstGameNumber = totalnumberOfGames - 1;
				 secondGameNumber = totalnumberOfGames - 2;
				 lastGameNumber = totalnumberOfGames - 3;
 
				 weekTenPanel.addGameInfo(this.teams, this.games, lastGameNumber);
				 weekTenPanel.addGameInfo(this.teams, this.games, secondGameNumber);
				 weekTenPanel.addGameInfo(this.teams, this.games, firstGameNumber);
				 
			 } else if (totalnumberOfGames == 29) {
				 firstGameNumber = totalnumberOfGames - 1;
				 secondGameNumber = totalnumberOfGames - 2;
				 
				 weekTenPanel.addGameInfo(this.teams, this.games, secondGameNumber);
				 weekTenPanel.addGameInfo(this.teams, this.games, firstGameNumber);
				
			 } else if (totalnumberOfGames == 28){
				 
				    gameNumber = totalnumberOfGames - 1;
					weekTenPanel.addGameInfo(this.teams, this.games, gameNumber);
				 
			 }

			break;
		default:
			
		}
	}
	
	

	private void initializeTeamLogos() {
	    teamLogos.put("Cowboys", "/images/cowboys.png");
	    teamLogos.put("Cardinals", "/images/cardinals.png");
	    teamLogos.put("Chiefs", "/images/chiefs.png");
	    teamLogos.put("Bengals", "/images/bengals.png");
	    teamLogos.put("Raiders", "/images/raiders.png");
	    teamLogos.put("Steelers", "/images/steelers.png");
	}
    

	private void showPanel(JPanel panelToShow) {
        this.removeAll();
        this.add(panelButton);
        this.add(weeksPanelButton);
        this.add(panelToShow, BorderLayout.CENTER);
        this.revalidate();
        this.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
      
    	Map<JButton, JPanel> buttonPanelMap = new HashMap<>();
        buttonPanelMap.put(weekOneButton, weekOnePanel);
        buttonPanelMap.put(weekTwoButton, weekTwoPanel);
        buttonPanelMap.put(weekThreeButton, weekThreePanel);
        buttonPanelMap.put(weekFourButton, weekFourPanel);
        buttonPanelMap.put(weekFiveButton, weekFivePanel);
        buttonPanelMap.put(weekSixButton, weekSixPanel);
        buttonPanelMap.put(weekSevenButton, weekSevenPanel);
        buttonPanelMap.put(weekEighthButton, weekEighthPanel);
        buttonPanelMap.put(weekNineButton, weekNinePanel);
        buttonPanelMap.put(weekTenButton, weekTenPanel);
    
        for (JButton button : buttonPanelMap.keySet()) {
            button.setBorder(null);
        }

        JButton clickedButton = (JButton) e.getSource();
        JPanel panelToShow = buttonPanelMap.get(clickedButton);

        if (panelToShow != null) {
            clickedButton.setBorder(new CustomBorder(25));
            showPanel(panelToShow);
        }  
    }
}
