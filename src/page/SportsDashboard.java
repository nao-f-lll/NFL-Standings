package page;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import model.ParentFrame;



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
    
    private JLabel cardinalsIconLabel;
    private JLabel steelersIconLabel;
    private JLabel raidersIconLabel;
    private JLabel chiefsIconLabel;
    private JLabel cowboysIconLabel;
    private JLabel bengalsIconLabel;
    
    
    private ImageIcon cardinalsIcon;
    private ImageIcon steelersIcon;
    private ImageIcon raidersIcon;
    private ImageIcon chiefsIcon;
    private ImageIcon cowboysIcon;
    private ImageIcon bengalsIcon;
    
    
    
    private JLabel lblStadium;
    private JLabel lblAttStadium_3;
    private JLabel lblAttStadium_4;
    private JLabel lblCardinals;
    private JLabel lblAtt;
    private JLabel lblBush;
    private JLabel lblArizona;
    
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
        scoresLabel.setBounds(409, 534, 162, 13);
        
        standingsLabel = new JLabel("Panel 2 Content");
        standingsLabel.setBounds(636, 248, 162, 13);
        
        teamsLabel = new JLabel("Panel 3 Content");
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
        
        
        
        
        cowboysIcon = new ImageIcon(ResizeIcon("/images/cowboys.png",210,120));
        cowboysIconLabel = new JLabel("");
        cowboysIconLabel.setHorizontalAlignment(SwingConstants.CENTER);
        cowboysIconLabel.setIcon(cowboysIcon);
        cowboysIconLabel.setBounds(156, 87, 186, 187);
        scoresPanel.add(cowboysIconLabel);
        
        
        
        
        
        cardinalsIcon = new ImageIcon(ResizeIcon("/images/cardinals.png",210,120));
        cardinalsIconLabel = new JLabel("");
        cardinalsIconLabel.setHorizontalAlignment(SwingConstants.CENTER);
        cardinalsIconLabel.setIcon(cardinalsIcon);
        cardinalsIconLabel.setBounds(581, 101, 216, 173);
        scoresPanel.add(cardinalsIconLabel);
        
        JLabel lblNewLabel = new JLabel("Cowboys");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
        lblNewLabel.setBounds(376, 165, 100, 45);
        scoresPanel.add(lblNewLabel);
        
        JLabel lblAttStadium = new JLabel("AT&T Stadium");
        lblAttStadium.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblAttStadium.setBounds(376, 234, 148, 54);
        scoresPanel.add(lblAttStadium);
        
        JLabel lblAttStadium_1 = new JLabel("1960");
        lblAttStadium_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblAttStadium_1.setBounds(376, 282, 148, 54);
        scoresPanel.add(lblAttStadium_1);
        
        JLabel lblAttStadium_1_1 = new JLabel("Texas");
        lblAttStadium_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblAttStadium_1_1.setBounds(382, 323, 148, 54);
        scoresPanel.add(lblAttStadium_1_1);
        
        lblStadium = new JLabel("Stadium");
        lblStadium.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblStadium.setBounds(23, 234, 148, 54);
        scoresPanel.add(lblStadium);
        
        lblAttStadium_3 = new JLabel("Established ");
        lblAttStadium_3.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblAttStadium_3.setBounds(23, 282, 148, 54);
        scoresPanel.add(lblAttStadium_3);
        
        lblAttStadium_4 = new JLabel("City");
        lblAttStadium_4.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblAttStadium_4.setBounds(23, 323, 148, 54);
        scoresPanel.add(lblAttStadium_4);
        
        lblCardinals = new JLabel("Cardinals");
        lblCardinals.setFont(new Font("Tahoma", Font.BOLD, 17));
        lblCardinals.setBounds(872, 165, 100, 45);
        scoresPanel.add(lblCardinals);
        
        lblAtt = new JLabel("Bush Stadium");
        lblAtt.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblAtt.setBounds(872, 234, 148, 54);
        scoresPanel.add(lblAtt);
        
        lblBush = new JLabel("1984");
        lblBush.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblBush.setBounds(872, 282, 148, 54);
        scoresPanel.add(lblBush);
        
        lblArizona = new JLabel("Arizona");
        lblArizona.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblArizona.setBounds(872, 323, 148, 54);
        scoresPanel.add(lblArizona);
        

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
