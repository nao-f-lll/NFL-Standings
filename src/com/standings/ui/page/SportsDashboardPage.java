package com.standings.ui.page;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import com.standings.model.CustomBorder;
import com.standings.model.ParentFrame;
import com.standings.ui.page.panel.StandingsPanel;
import com.standings.ui.page.panel.TeamsPanel;
import com.standings.ui.page.panel.UpdateDataPanel;



public class SportsDashboardPage extends ParentFrame implements ActionListener {

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
    
    
   
    public SportsDashboardPage() {
        setTitle("Sports Dashboard");
        setResizable(true);
        setSizeAndCenter();

        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        

        scoresPanel = new StandingsPanel();
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
       goToUpdateDataButton.setBounds(1251, 10, 246, 33);
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
      
         ///  
        
   
        DefaultTableModel model = new DefaultTableModel();
        
        
        String[] columnNames = {"Team",
                				"Match Played",
                				"Wins",
                				"Losses",
                				"Ties",
                				"PF",
                				"PA"};
        
   
        Object[][] data = {
        	    {"cardinals", 0, 0, 0, 0, 0, 0},
        	    {"Raiders", 0, 0, 0, 0, 0, 0},
        	    {"Chiefs", 0, 0, 0, 0, 0, 0},
        	    {"Cowboys", 0, 0, 0, 0, 0, 0},
        	    {"Bengals", 0, 0, 0, 0, 0, 0},
        	    {"Steelers", 0, 0, 0, 0, 0, 0},
        	};
        
        model.setColumnIdentifiers(columnNames);
        model.setDataVector(data, columnNames);
        
        JTable table = new JTable(model);
        table.setFont(new Font("Tahoma", Font.PLAIN, 20));
        table.setEnabled(false);
        table.setBounds(10,105,1502,535);
        table.setShowGrid(true);
        table.setShowHorizontalLines(true);
        table.setShowVerticalLines(true);
        table.setGridColor(Color.BLACK);
        scoresPanel.add(table);
        
        TableColumnModel columnModel = table.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(120); // Team
        columnModel.getColumn(1).setPreferredWidth(100); // Match Played
        columnModel.getColumn(2).setPreferredWidth(70);  // Wins
        columnModel.getColumn(3).setPreferredWidth(70);  // Losses
        columnModel.getColumn(4).setPreferredWidth(70);  // Ties
        columnModel.getColumn(5).setPreferredWidth(70);  // PF
        columnModel.getColumn(6).setPreferredWidth(70);  // PA
        
        table.setRowHeight(30); // Set row height (adjust as needed)
        
        scoresPanel.add(table.getTableHeader(), BorderLayout.NORTH);
  ///

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
			        new SportsDashboardPage();			    
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
