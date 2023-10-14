package page;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import model.CustomBorder;
import model.ParentFrame;
import panel.Teams;
import panel.UpdateData;



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
    
    private JLabel scoresLabel;
    private JLabel standingsLabel;
    private JLabel teamsLabel;
    private JLabel updateDataLabel;
      
    
    public SportsDashboard() {
        setTitle("Sports Dashboard");
        setResizable(true);
        setSizeAndCenter();

        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        
        // Create panels for different sections
        scoresPanel = new UpdateData();
        standingsPanel = new JPanel();
        
        teamsPanel = new Teams();
        
        updateDataPanel = new UpdateData();
        
        scoresPanel.setLayout(null);
        standingsPanel.setLayout(null);
        teamsPanel.setLayout(null);
        updateDataPanel.setLayout(null);
        
        // Add content labels to the panels
        
        scoresLabel = new JLabel("Panel 1 Content");
        scoresLabel.setBounds(753, 208, 162, 13);
        
        standingsLabel = new JLabel("Panel 2 Content");
        standingsLabel.setBounds(636, 248, 162, 13);
        
        teamsLabel = new JLabel("");
        teamsLabel.setBounds(636, 248, 162, 13);
        
        updateDataLabel = new JLabel("Panel 4 Content");
        updateDataLabel.setBounds(636, 248, 162, 13);
        
        
        
        // need revision
        
        
        scoresPanel.add(scoresLabel);
        standingsPanel.add(standingsLabel);
        teamsPanel.add(teamsLabel);
        updateDataPanel.add(updateDataLabel);
       
        
        mainPanel.add(scoresPanel, BorderLayout.CENTER);
        
        
       panelButton = new JPanel();
       panelButton.setBounds(0, 0, 1522, 60);
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
        if (e.getSource() == goToScoresButton) {
            showPanel(scoresPanel);
            goToScoresButton.setBorder(new CustomBorder(20));
            goToStandingButton.setBorder(null);
            goToTeamsButton.setBorder(null);
            goToUpdateDataButton.setBorder(null);
        } else if (e.getSource() == goToStandingButton) {
            showPanel(standingsPanel);
            goToStandingButton.setBorder(new CustomBorder(20));
            goToScoresButton.setBorder(null);
            goToTeamsButton.setBorder(null);
            goToUpdateDataButton.setBorder(null);
        } else if (e.getSource() == goToTeamsButton) {
            showPanel(teamsPanel);
            goToTeamsButton.setBorder(new CustomBorder(20));
            goToScoresButton.setBorder(null);
            goToStandingButton.setBorder(null);
            goToUpdateDataButton.setBorder(null);
        } else if (e.getSource() == goToUpdateDataButton) {
            showPanel(updateDataPanel);
            goToUpdateDataButton.setBorder(new CustomBorder(20));
            goToScoresButton.setBorder(null);
            goToStandingButton.setBorder(null);
            goToTeamsButton.setBorder(null);
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
