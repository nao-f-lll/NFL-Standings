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
import com.standings.ui.page.panel.StandingsPanel;
import com.standings.ui.page.panel.TeamsPanel;
import com.standings.ui.page.panel.UpdateDataPanel;



public class SportsDashboardPage extends ParentFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    
    private JPanel mainPanel;
    private JPanel panelButton;
    private JPanel scoresPanel;
    private StandingsPanel standingsPanel;
    private TeamsPanel teamsPanel; 
    private UpdateDataPanel updateDataPanel;
    
    private JButton goToScoresButton;
    private JButton goToStandingButton;
    private JButton goToTeamsButton;
    private JButton goToUpdateDataButton;
    private JLabel standingsLabel;
    private JLabel teamsLabel;
    private JLabel updateDataLabel;
    
	private ArrayList<Team> teams;
	private List<Game> games;
	

  
    public SportsDashboardPage() {
        setTitle("Panel administrativo");
        setResizable(false);
        setSizeAndCenter();

        teams = new ArrayList<>();
        games = new ArrayList<>();
        
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        

        scoresPanel = new JPanel();
        standingsPanel = new StandingsPanel(teams, games);   
        teamsPanel = new TeamsPanel();     
        updateDataPanel = new UpdateDataPanel(teams, games,standingsPanel);
        scoresPanel.setLayout(null);
        standingsPanel.setLayout(null);
        teamsPanel.setLayout(null);
        updateDataPanel.setLayout(null);
        
        standingsLabel = new JLabel("Panel 2 Content");
        standingsLabel.setBounds(636, 248, 162, 13);
        
        teamsLabel = new JLabel("");
        teamsLabel.setBounds(636, 248, 162, 13);
        
        updateDataLabel = new JLabel("");
        updateDataLabel.setBounds(636, 248, 162, 13);
        standingsPanel.add(standingsLabel);
        teamsPanel.add(teamsLabel);
        updateDataPanel.add(updateDataLabel);
       
        
        mainPanel.add(scoresPanel, BorderLayout.CENTER);
       
        
        
       panelButton = new JPanel();
       panelButton.setBounds(0, 0, 1522, 60);
       panelButton.setBackground(Color.WHITE);
       scoresPanel.add(panelButton);
 
               
       goToScoresButton = new JButton("Partidos");
       goToScoresButton.setFont(new Font("Tahoma", Font.BOLD, 25));
       goToScoresButton.setBounds(10, 10, 163, 33);
       goToScoresButton.setFocusable(false);
       goToScoresButton.setBackground(Color.WHITE);
       goToScoresButton.setBorder(new CustomBorder(20));
                
       goToStandingButton = new JButton("Clasificación");
       goToStandingButton.setFont(new Font("Tahoma", Font.BOLD, 25));
       goToStandingButton.setBounds(205, 10, 212, 33);
       goToStandingButton.setFocusable(false);
       goToStandingButton.setBackground(Color.WHITE);
       goToStandingButton.setBorder(null);
       
       goToTeamsButton = new JButton("Equipos");
       goToTeamsButton.setFont(new Font("Tahoma", Font.BOLD, 25));
       goToTeamsButton.setBounds(427, 10, 152, 33);
       goToTeamsButton.setFocusable(false);
       goToTeamsButton.setBackground(Color.WHITE);
       goToTeamsButton.setBorder(null);
       
       goToUpdateDataButton = new JButton("Actualizar datos");
       goToUpdateDataButton.setFont(new Font("Tahoma", Font.BOLD, 25));
       goToUpdateDataButton.setBounds(1253, 10, 259, 33);
       goToUpdateDataButton.setFocusable(false);
       goToUpdateDataButton.setBackground(Color.WHITE);
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
       
       
       
       
       
            ///
       
       
       
       JPanel weeksPanelButton = new JPanel();
       weeksPanelButton.setLayout(null);
       weeksPanelButton.setBackground(Color.WHITE);
       weeksPanelButton.setBounds(0, 62, 1522, 60);
       scoresPanel.add(weeksPanelButton);

       int buttonWidth = 120;
       int horizontalGap = 33; 
       int initialX = 10;

       JButton weekOneButton = new JButton("J-1");
       weekOneButton.setFont(new Font("Tahoma", Font.BOLD, 25));
       weekOneButton.setFocusable(false);
       weekOneButton.setBorder(new CustomBorder(20));
       weekOneButton.setBackground(Color.WHITE);
       weekOneButton.setBounds(initialX, 10, buttonWidth, 33);
       weekOneButton.setUI(new CustomButton()); ////add this to every button
       weeksPanelButton.add(weekOneButton);
       

       
       
       
       

       JButton weekTwoButton = new JButton("J-2");
       weekTwoButton.setFont(new Font("Tahoma", Font.BOLD, 25));
       weekTwoButton.setFocusable(false);
       weekTwoButton.setBorder(null);
       weekTwoButton.setBackground(Color.WHITE);
       weekTwoButton.setBounds(initialX += buttonWidth + horizontalGap, 10, buttonWidth, 33);
       weeksPanelButton.add(weekTwoButton);
       
       
       

       
       JButton weekThreeButton = new JButton("J-3");
       weekThreeButton.setFont(new Font("Tahoma", Font.BOLD, 25));
       weekThreeButton.setFocusable(false);
       weekThreeButton.setBorder(null);
       weekThreeButton.setBackground(Color.WHITE);
       weekThreeButton.setBounds(initialX += buttonWidth + horizontalGap, 10, buttonWidth, 33);
       weeksPanelButton.add(weekThreeButton);
       
       

       
       JButton weekFourButton  = new JButton("J-4");
       weekFourButton.setFont(new Font("Tahoma", Font.BOLD, 25));
       weekFourButton.setFocusable(false);
       weekFourButton.setBorder(null);
       weekFourButton.setBackground(Color.WHITE);
       weekFourButton.setBounds(initialX += buttonWidth + horizontalGap, 10, buttonWidth, 33);
       weeksPanelButton.add(weekFourButton);
       
  
       
       JButton weekFiveButton = new JButton("J-5");
       weekFiveButton.setFont(new Font("Tahoma", Font.BOLD, 25));
       weekFiveButton.setFocusable(false);
       weekFiveButton.setBorder(null);
       weekFiveButton.setBackground(Color.WHITE);
       weekFiveButton.setBounds(initialX += buttonWidth + horizontalGap, 10, buttonWidth, 33);
       weeksPanelButton.add(weekFiveButton);
       
       
      
       
       JButton weekSixButton  = new JButton("J-6");
       weekSixButton.setFont(new Font("Tahoma", Font.BOLD, 25));
       weekSixButton.setFocusable(false);
       weekSixButton.setBorder(null);
       weekSixButton.setBackground(Color.WHITE);
       weekSixButton.setBounds(initialX += buttonWidth + horizontalGap, 10, buttonWidth, 33);
       weeksPanelButton.add(weekSixButton);
       
       
       
       
       
       JButton weekSevenButton = new JButton("J-7");
       weekSevenButton.setFont(new Font("Tahoma", Font.BOLD, 25));
       weekSevenButton.setFocusable(false);
       weekSevenButton.setBorder(null);
       weekSevenButton.setBackground(Color.WHITE);     
       weekSevenButton.setBounds(initialX += buttonWidth + horizontalGap, 10, buttonWidth, 33);
       weeksPanelButton.add(weekSevenButton);

       
       

       
       JButton weekEighthButton = new JButton("J-8");
       weekEighthButton.setFont(new Font("Tahoma", Font.BOLD, 25));
       weekEighthButton.setFocusable(false);
       weekEighthButton.setBorder(null);
       weekEighthButton.setBackground(Color.WHITE);
       weekEighthButton.setBounds(initialX += buttonWidth + horizontalGap, 10, buttonWidth, 33);
       weeksPanelButton.add(weekEighthButton);
       
       
       
       
       JButton weekNineButton = new JButton("J-9");
       weekNineButton.setFont(new Font("Tahoma", Font.BOLD, 25));
       weekNineButton.setFocusable(false);
       weekNineButton.setBorder(null);
       weekNineButton.setBackground(Color.WHITE);
       weekNineButton.setBounds(initialX += buttonWidth + horizontalGap, 10, buttonWidth, 33);
       weeksPanelButton.add(weekNineButton);
       
       
  
       
       JButton weekTenButton = new JButton("J-10");
       weekTenButton.setFont(new Font("Tahoma", Font.BOLD, 25));
       weekTenButton.setFocusable(false);
       weekTenButton.setBorder(null);
       weekTenButton.setBackground(Color.WHITE);
       weekTenButton.setBounds(initialX += buttonWidth + horizontalGap, 10, buttonWidth, 33);
       weeksPanelButton.add(weekTenButton);
       
       
       
       
       JLabel name1 = new JLabel("Cardinals");
       name1.setFont(new Font("Tahoma", Font.PLAIN, 27));
       name1.setBounds(365, 205, 159, 95);
       scoresPanel.add(name1);
       
       JLabel nfl1 = new JLabel("");
       nfl1.setIcon(new ImageIcon(ResizeIcon("/images/cardinals.png",140,90)));
       nfl1.setFont(new Font("Tahoma", Font.PLAIN, 20));
       nfl1.setBounds(127, 182, 186, 118);
       scoresPanel.add(nfl1);
       
       JLabel point1 = new JLabel("20");
       point1.setFont(new Font("Tahoma", Font.PLAIN, 27));
       point1.setBounds(571, 205, 58, 95);
       scoresPanel.add(point1);
       
       JLabel nfl2 = new JLabel("");
       nfl2.setFont(new Font("Tahoma", Font.PLAIN, 20));
       nfl2.setIcon(new ImageIcon(ResizeIcon("/images/chiefs.png",140,90)));
       nfl2.setBounds(127, 298, 174, 138);
       scoresPanel.add(nfl2);
       
       JLabel name2 = new JLabel("Chiefs");
       name2.setFont(new Font("Tahoma", Font.PLAIN, 27));
       name2.setBounds(365, 310, 159, 95);
       scoresPanel.add(name2);
       
       JLabel point2 = new JLabel("10");
       point2.setFont(new Font("Tahoma", Font.PLAIN, 27));
       point2.setBounds(571, 310, 58, 95);
       scoresPanel.add(point2);
       
       
       
       
       JLabel icon3 = new JLabel("");
       icon3.setFont(new Font("Tahoma", Font.PLAIN, 20));
       icon3.setIcon(new ImageIcon(ResizeIcon("/images/bengals.png",140,90)));
       icon3.setBounds(127, 516, 174, 118);
       scoresPanel.add(icon3);
      
       
       JLabel icon4 = new JLabel("");
       icon4.setFont(new Font("Tahoma", Font.PLAIN, 20));
       icon4.setIcon(new ImageIcon(ResizeIcon("/images/cowboys.png",140,90)));
       icon4.setBounds(127, 638, 174, 118);
       scoresPanel.add(icon4);
       
       JLabel name3 = new JLabel("Bengals");
       name3.setFont(new Font("Tahoma", Font.PLAIN, 27));
       name3.setBounds(365, 536, 116, 95);
       scoresPanel.add(name3);
       
       JLabel name4 = new JLabel("Cowboys");
       name4.setFont(new Font("Tahoma", Font.PLAIN, 27));
       name4.setBounds(365, 644, 126, 95);
       scoresPanel.add(name4);
       
       JLabel point3 = new JLabel("20");
       point3.setFont(new Font("Tahoma", Font.PLAIN, 27));
       point3.setBounds(571, 536, 58, 95);
       scoresPanel.add(point3);
       
       JLabel point4 = new JLabel("20");
       point4.setFont(new Font("Tahoma", Font.PLAIN, 27));
       point4.setBounds(571, 644, 58, 95);
       scoresPanel.add(point4);
       
       JLabel name5 = new JLabel("Steelers");
       name5.setFont(new Font("Tahoma", Font.PLAIN, 27));
       name5.setBounds(1102, 205, 159, 95);
       scoresPanel.add(name5);
       
       JLabel point5 = new JLabel("20");
       point5.setFont(new Font("Tahoma", Font.PLAIN, 27));
       point5.setBounds(1305, 205, 58, 95);
       scoresPanel.add(point5);
       
       JLabel name6 = new JLabel("Raiders");
       name6.setFont(new Font("Tahoma", Font.PLAIN, 27));
       name6.setBounds(1102, 310, 159, 95);
       scoresPanel.add(name6);
       
       JLabel point6 = new JLabel("20");
       point6.setFont(new Font("Tahoma", Font.PLAIN, 27));
       point6.setBounds(1305, 310, 58, 95);
       scoresPanel.add(point6);
       
       JLabel icon5 = new JLabel("");
       icon5.setFont(new Font("Tahoma", Font.PLAIN, 20));
       icon5.setBounds(858, 183, 149, 138);
       icon5.setIcon(new ImageIcon(ResizeIcon("/images/steelers.png",140,90)));
       scoresPanel.add(icon5);
       
       JLabel icon6 = new JLabel("");
       icon6.setFont(new Font("Tahoma", Font.PLAIN, 20));
       icon6.setBounds(858, 301, 176, 135);
       icon6.setIcon(new ImageIcon(ResizeIcon("/images/raiders.png",140,90)));
       scoresPanel.add(icon6);
       
       
    
       
       
     
       
       
       
       
       ///
       
       
       
       
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