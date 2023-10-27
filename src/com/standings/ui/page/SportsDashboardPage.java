package com.standings.ui.page;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

import javax.swing.*;
import com.standings.model.CustomBorder;
import com.standings.model.CustomButton;
import com.standings.model.ParentFrame;
import com.standings.model.Team;
import com.standings.model.Game;
import com.standings.ui.page.panel.ScoresPanel;
import com.standings.ui.page.panel.StandingsPanel;
import com.standings.ui.page.panel.TeamsPanel;
import com.standings.ui.page.panel.UpdateDataPanel;



public class SportsDashboardPage extends ParentFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    
    private JPanel mainPanel;
    private JPanel panelButton;
    
    private ScoresPanel scoresPanel;
    private StandingsPanel standingsPanel;
    private TeamsPanel teamsPanel; 
    private UpdateDataPanel updateDataPanel;
    
    private JButton goToScoresButton;
    private JButton goToStandingButton;
    private JButton goToTeamsButton;
    private JButton goToUpdateDataButton;
    private ArrayList<Team> teams;
	private List<Game> games;
	private List<List<Game>> weeks;
	
	
	


  
    public SportsDashboardPage() {
        setTitle("Panel administrativo");
        setResizable(false);
        setSizeAndCenter();

        teams = new ArrayList<>();
        games = new ArrayList<>();
        weeks = new ArrayList<>();
        
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        
        
        
        panelButton = new JPanel();
        panelButton.setBounds(0, 0, 1522, 60);
        panelButton.setBackground(Color.WHITE);
        

        
        standingsPanel = new StandingsPanel(teams, games, weeks);   
        scoresPanel = new ScoresPanel(panelButton, teams, games, weeks);
        teamsPanel = new TeamsPanel();          
        updateDataPanel = new UpdateDataPanel(teams, games,standingsPanel, scoresPanel);
        
        
        scoresPanel.setLayout(null);
        standingsPanel.setLayout(null);
        teamsPanel.setLayout(null);
        updateDataPanel.setLayout(null);
        
 
        mainPanel.add(scoresPanel, BorderLayout.CENTER);
        scoresPanel.add(panelButton);
 
               
       goToScoresButton = new JButton("Partidos");
       goToScoresButton.setFont(new Font("Tahoma", Font.BOLD, 25));
       goToScoresButton.setBounds(10, 10, 163, 33);
       goToScoresButton.setFocusable(false);
       goToScoresButton.setBackground(Color.WHITE);
       goToScoresButton.setBorder(new CustomBorder(20));
       goToScoresButton.setUI(new CustomButton());
       
                
       goToStandingButton = new JButton("Clasificación");
       goToStandingButton.setFont(new Font("Tahoma", Font.BOLD, 25));
       goToStandingButton.setBounds(205, 10, 212, 33);
       goToStandingButton.setFocusable(false);
       goToStandingButton.setBackground(Color.WHITE);
       goToStandingButton.setUI(new CustomButton());
       goToStandingButton.setBorder(null);
       
       goToTeamsButton = new JButton("Equipos");
       goToTeamsButton.setFont(new Font("Tahoma", Font.BOLD, 25));
       goToTeamsButton.setBounds(427, 10, 152, 33);
       goToTeamsButton.setFocusable(false);
       goToTeamsButton.setBackground(Color.WHITE);
       goToTeamsButton.setUI(new CustomButton()); 
       goToTeamsButton.setBorder(null);
       
       goToUpdateDataButton = new JButton("Actualizar datos");
       goToUpdateDataButton.setFont(new Font("Tahoma", Font.BOLD, 25));
       goToUpdateDataButton.setBounds(1253, 10, 259, 33);
       goToUpdateDataButton.setFocusable(false);
       goToUpdateDataButton.setBackground(Color.WHITE);
       goToUpdateDataButton.setUI(new CustomButton()); 
       goToUpdateDataButton.setBorder(null);
               
       goToScoresButton.addActionListener(this);
       goToStandingButton.addActionListener(this);
       goToTeamsButton.addActionListener(this);
       goToUpdateDataButton.addActionListener(this);
       panelButton.setLayout(null);
                
                
       panelButton.add(goToScoresButton);
       panelButton.add(goToStandingButton);
       panelButton.add(goToTeamsButton);
       panelButton.add(goToUpdateDataButton);
       
       
             getContentPane().setLayout(new BorderLayout());
             getContentPane().add(mainPanel, BorderLayout.CENTER);
     	        
    }

    private void setSizeAndCenter() {
        //Toolkit toolkit = Toolkit.getDefaultToolkit();
        //Dimension screenSize = toolkit.getScreenSize();
        //setSize(screenSize.width, screenSize.height);
        setSize(1538, 850);
        //setLocation(screenSize.width / 2 - getWidth() / 2, screenSize.height / 2 - getHeight() / 2);
        setLocationRelativeTo(null);
    }

    private void showPanel(JPanel panelToShow) {
        mainPanel.removeAll();
        mainPanel.add(panelButton);
        mainPanel.add(panelToShow, BorderLayout.CENTER);
        mainPanel.revalidate();
        mainPanel.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Map<JButton, JPanel> buttonPanelMap = new HashMap<>();
        buttonPanelMap.put(goToScoresButton, scoresPanel);
        buttonPanelMap.put(goToStandingButton, standingsPanel);
        buttonPanelMap.put(goToTeamsButton, teamsPanel);
        buttonPanelMap.put(goToUpdateDataButton, updateDataPanel);

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
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
			        new SportsDashboardPage();			    
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}