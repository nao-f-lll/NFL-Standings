package page;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.*;


import model.CustomBorder;
import model.ParentFrame;
import panel.TeamsPanel;
import panel.UpdateDataPanel;



public class SportsDashboard extends ParentFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    
    private JPanel mainPanel;
    private JPanel panelButton;
    private JPanel scoresPanel;
    private JPanel standingsPanel;
    private JPanel teamsPanel; 
    private JPanel updateDataPanel;
    
    private JButton goToScoresButton;
    private JButton goToStandingButton;
    private JButton goToTeamsButton;
    private JButton goToUpdateDataButton;
    private JLabel standingsLabel;
    private JLabel teamsLabel;
    private JLabel updateDataLabel;
    
   
    public SportsDashboard() {
        setTitle("Sports Dashboard");
        setResizable(true);
        setSizeAndCenter();

        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        

        scoresPanel = new JPanel();
        standingsPanel = new JPanel();      
        teamsPanel = new TeamsPanel();     
        updateDataPanel = new UpdateDataPanel();
        
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
 
               
       goToScoresButton = new JButton("Scores");
       goToScoresButton.setFont(new Font("Tahoma", Font.BOLD, 25));
       goToScoresButton.setBounds(10, 10, 134, 33);
       goToScoresButton.setFocusable(false);
       goToScoresButton.setBackground(Color.WHITE);
       goToScoresButton.setBorder(new CustomBorder(20));
                
       goToStandingButton = new JButton("Standings");
       goToStandingButton.setFont(new Font("Tahoma", Font.BOLD, 25));
       goToStandingButton.setBounds(205, 10, 183, 33);
       goToStandingButton.setFocusable(false);
       goToStandingButton.setBackground(Color.WHITE);
       goToStandingButton.setBorder(null);
       
       goToTeamsButton = new JButton("Teams");
       goToTeamsButton.setFont(new Font("Tahoma", Font.BOLD, 25));
       goToTeamsButton.setBounds(427, 10, 141, 33);
       goToTeamsButton.setFocusable(false);
       goToTeamsButton.setBackground(Color.WHITE);
       goToTeamsButton.setBorder(null);
       
       goToUpdateDataButton = new JButton("Update Data");
       goToUpdateDataButton.setFont(new Font("Tahoma", Font.BOLD, 25));
       goToUpdateDataButton.setBounds(1112, 10, 246, 33);
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
        
       
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(mainPanel, BorderLayout.CENTER);
      
       
    
        
     

    }

    private void setSizeAndCenter() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        setSize(screenSize.width, screenSize.height);
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
        // Define a map to associate buttons with panels
        Map<JButton, JPanel> buttonPanelMap = new HashMap<>();
        buttonPanelMap.put(goToScoresButton, scoresPanel);
        buttonPanelMap.put(goToStandingButton, standingsPanel);
        buttonPanelMap.put(goToTeamsButton, teamsPanel);
        buttonPanelMap.put(goToUpdateDataButton, updateDataPanel);

        // Reset all button borders to null
        for (JButton button : buttonPanelMap.keySet()) {
            button.setBorder(null);
        }

        // Check which button was clicked
        JButton clickedButton = (JButton) e.getSource();
        JPanel panelToShow = buttonPanelMap.get(clickedButton);

        if (panelToShow != null) {
            // Set the custom border for the clicked button and show the associated panel
            clickedButton.setBorder(new CustomBorder(20));
            showPanel(panelToShow);
        }
    }

    
    public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
			        new SportsDashboard();			    
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
