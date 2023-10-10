package page;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class SportsDashboard extends JFrame implements ActionListener {

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
        scoresPanel = new JPanel();
        standingsPanel = new JPanel();
        teamsPanel = new JPanel();
        updateDataPanel = new JPanel();
        
        scoresPanel.setLayout(null);
        standingsPanel.setLayout(null);
        teamsPanel.setLayout(null);
        updateDataPanel.setLayout(null);
        
        // Add content labels to the panels
        
        scoresLabel = new JLabel("Panel 1 Content");
        scoresLabel.setBounds(636, 248, 72, 13);
        
        standingsLabel = new JLabel("Panel 2 Content");
        standingsLabel.setBounds(636, 248, 72, 13);
        
        teamsLabel = new JLabel("Panel 3 Content");
        teamsLabel.setBounds(636, 248, 72, 13);
        
        updateDataLabel = new JLabel("Panel 4 Content");
        updateDataLabel.setBounds(636, 248, 72, 13);
        
        scoresPanel.add(scoresLabel);
        standingsPanel.add(standingsLabel);
        teamsPanel.add(teamsLabel);
        updateDataPanel.add(updateDataLabel);
        
        mainPanel.add(scoresPanel, BorderLayout.CENTER);
        
        
       panelButton = new JPanel();
       panelButton.setBounds(0, 0, 1522, 60);
       scoresPanel.add(panelButton);
       panelButton.setBackground(Color.LIGHT_GRAY);
                
               
       goToScoresButton = new JButton("Scores");
       goToScoresButton.setFont(new Font("Tahoma", Font.PLAIN, 25));
       goToScoresButton.setBounds(10, 10, 124, 33);
       goToScoresButton.setFocusable(false);
                
       goToStandingButton = new JButton("Standings");
       goToStandingButton.setFont(new Font("Tahoma", Font.PLAIN, 25));
       goToStandingButton.setBounds(205, 10, 143, 33);
       goToStandingButton.setFocusable(false);
       
       goToTeamsButton = new JButton("Teams");
       goToTeamsButton.setFont(new Font("Tahoma", Font.PLAIN, 25));
       goToTeamsButton.setBounds(427, 10, 111, 33);
       goToTeamsButton.setFocusable(false);
       
       goToUpdateDataButton = new JButton("Update Data");
       goToUpdateDataButton.setFont(new Font("Tahoma", Font.PLAIN, 25));
       goToUpdateDataButton.setBounds(1304, 10, 208, 33);
       goToUpdateDataButton.setFocusable(false);
                
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
        } else if (e.getSource() == goToStandingButton) {
            showPanel(standingsPanel);
        } else if (e.getSource() == goToTeamsButton) {
            showPanel(teamsPanel);
        } else if (e.getSource() == goToUpdateDataButton) {
            showPanel(updateDataPanel);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SportsDashboard dashboard = new SportsDashboard();
            dashboard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            dashboard.setVisible(true);
        });
    }
}
