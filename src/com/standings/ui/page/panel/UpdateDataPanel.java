package com.standings.ui.page.panel;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.standings.model.Game;
import com.standings.model.ParentFrame;
import com.standings.model.Team;
import com.standings.ui.page.SportsDashboardPage;
import com.standings.util.AddGameUtil;
import com.standings.util.StandingsCalculation;
import com.standings.util.StandingsDataUtil;

public class UpdateDataPanel extends JPanel  implements ActionListener {

	private static final long serialVersionUID = -3261993617585437616L;
	
    private JLabel localClubLabel;
    private JLabel localClubPointsLabel;
    private JTextField localClubField;
    private JTextField localClubPointsField;
    
    private JLabel visitorClubLabel;
    private JLabel visitorClubPointsLabel; 
    private JTextField visitorClubField;
    private JTextField visitorClubPointsField;
    
  
    private JComboBox<String> weekComboBox;
    DefaultComboBoxModel<String> comboWeekModel;
    
    private JButton submitButton;
    private JButton updateButton;
    private JButton cancelButton;
    
    private JLabel titleInstructionsLabel;
    private JPanel instructionPanel;
    private JLabel instructionsLabel;
    private ImageIcon nflIcon;
    private JLabel termsOfUse;

	private int validationNumber;
    
    
    private final int SOME_OR_ALL_FIELDS_ARE_EMPTY = 1;
    private final int WRONG_TEAM_NAME = 2;
    private final int THE_SAME_NAME_FOR_TEAMS_IS_NOT_ALLOWED = 6;


    private final int ALL_POINTS_ARE_INVALID = 3;
    private final int LOCAL_POINTS_ARE_INVALID = 4;
    private final int VISITOR_POINTS_ARE_INVALID = 5;

    
    private JLabel errorMessageForLocalPointsField;
    private JLabel errorMessageForVisitorPointsField;
	private List<Game> games;
	private ArrayList<Team> teams;
    
    
    public UpdateDataPanel( ArrayList<Team> teams, List<Game> games) {
 
    	this.games = games;
    	this.teams = teams;
    	 
    	comboWeekModel = new DefaultComboBoxModel<>();	
    	for (int i = 1; i < 11; i++) {
    		comboWeekModel.addElement("Week " + i);
    	}
    	
        weekComboBox = new JComboBox<>(comboWeekModel);
        weekComboBox.setBackground(Color.LIGHT_GRAY);
        weekComboBox.setBounds(1033, 130, 114, 45);
        this.add(weekComboBox);
        
        localClubLabel = new JLabel("Local Club");
        localClubLabel.setBounds(829, 215, 103, 37);
        this.add(localClubLabel);
        
        localClubField = new JTextField();
        localClubField.setBounds(791, 262, 155, 37);
        this.add(localClubField);
        localClubField.setColumns(10);
        
        
        
        visitorClubLabel = new JLabel("Visitor Club");
        visitorClubLabel.setBounds(829, 355, 117, 25);
        this.add(visitorClubLabel);
        
        visitorClubField = new JTextField();
        visitorClubField.setColumns(10);
        visitorClubField.setBounds(791, 390, 155, 37);
        this.add(visitorClubField);
        
        
        localClubPointsLabel = new JLabel("Points");
        localClubPointsLabel.setBounds(1250, 215, 71, 37);
        this.add(localClubPointsLabel);
        
        
        visitorClubPointsLabel = new JLabel("Points");
        visitorClubPointsLabel.setBounds(1250, 352, 84, 31);
        this.add(visitorClubPointsLabel);
        
        
        localClubPointsField = new JTextField();
        localClubPointsField.setBounds(1250, 264, 35, 34);
        this.add(localClubPointsField);
        localClubPointsField.setColumns(10);
    	fieldFocusListener(localClubPointsField,null);
        
        visitorClubPointsField = new JTextField();
        visitorClubPointsField.setColumns(10);
        visitorClubPointsField.setBounds(1250, 392, 35, 34);
        this.add(visitorClubPointsField);
        fieldFocusListener(null,visitorClubPointsField);
        
        submitButton = new JButton("Submit");
        submitButton.setBounds(778, 535, 130, 45);
        submitButton.setFocusable(false);
        submitButton.setBackground(Color.lightGray);
        submitButton.addActionListener(this);
        this.add(submitButton);
        
        updateButton = new JButton("Update");
        updateButton.setBounds(1001, 535, 130, 45);
        updateButton.setFocusable(false);
        updateButton.setBackground(Color.lightGray);
        updateButton.addActionListener(this);
        this.add(updateButton);
        
        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(1222, 535, 130, 45);
        cancelButton.setFocusable(false);
        cancelButton.setBackground(Color.lightGray);
        cancelButton.addActionListener(this);
        this.add(cancelButton);
        
        
        instructionPanel = new JPanel();
        instructionPanel.setBackground(new Color(255, 255, 255));
        instructionPanel.setBounds(0, 60, 627, 756);
        this.add(instructionPanel);
        instructionPanel.setLayout(null);
        
        
        
        
        
        titleInstructionsLabel = new JLabel("Instruction for Inserting/Updating Match Data");
        titleInstructionsLabel.setIcon(new ImageIcon(SportsDashboardPage.class.getResource("/images/instructionBlue.png")));
        titleInstructionsLabel.setForeground(new Color(0, 0, 0));
        titleInstructionsLabel.setBounds(49, 10, 536, 105);
        instructionPanel.add(titleInstructionsLabel);
        titleInstructionsLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        titleInstructionsLabel.setHorizontalAlignment(SwingConstants.CENTER);
        
        
        instructionsLabel = new JLabel(
                "<html>" +
                "<body style='width: 500px;'>" +
                "<ul>" +
                "<li>Select the week of the match from 'Week 1' to 'Week 10' in the drop-down.</li> <br>" +
                "<li>Enter the local and visitor club names along with their points..</li> <br>" +
                "<li>Click 'Submit' to save match results or 'Update' to modify data.</li> <br>"+
                "<li>'Cancel' discards changes.</li> <br>" + 
                "</ul>" +         
                "<p style='text-indent: 30px;'>    Remember to save your input. Thank you for helping maintain match records.</p>" +     
                "</body>" +
                "</html>"
            );
        
     

      
        instructionsLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        instructionsLabel.setBackground(this.getBackground());

      
        instructionPanel.add(instructionsLabel);

       
        instructionsLabel.setBounds(21, 179, 596, 227);
        
        nflIcon = new ImageIcon(ParentFrame.ResizeIconStatic("/images/nflWhite.png",280,200));
        JLabel nflIconLabel = new JLabel("");
		nflIconLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nflIconLabel.setIcon(nflIcon);
		nflIconLabel.setBounds(233, 476, 110, 144);
		instructionPanel.add(nflIconLabel);
        
        
		termsOfUse = new JLabel("<html><p style='text-indent: 10px; white-space: nowrap;'><a href=\"https://nao-f-lll.github.io/paginas/terminos.html\">Terms of use</a></p></html>");
		termsOfUse.setBounds(235, 630, 250, 40);
		termsOfUse.setFont(new Font("Dialog", Font.PLAIN, 13));
		instructionPanel.add(termsOfUse);

		
		termsOfUse.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (Desktop.isDesktopSupported()) {
                    try {
                        Desktop.getDesktop().browse(new URI("https://nao-f-lll.github.io/paginas/terminos.html"));
                    } catch (IOException | URISyntaxException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
								
		errorMessageForLocalPointsField = new JLabel();
		errorMessageForLocalPointsField.setText("");
		errorMessageForLocalPointsField.setBounds(1310, 265, 130, 25);
		errorMessageForLocalPointsField.setForeground(Color.RED);
		this.add(errorMessageForLocalPointsField);
		
		
		errorMessageForVisitorPointsField = new JLabel();
		errorMessageForVisitorPointsField.setText("");
		errorMessageForVisitorPointsField.setBounds(1310, 390, 130, 40);  
		errorMessageForVisitorPointsField.setForeground(Color.RED);
		this.add(errorMessageForVisitorPointsField);
    }
       
    
 	
    
    @Override
	public void actionPerformed(ActionEvent e) {
		userClickLoginLogic(e);
	}
    
	private void userClickLoginLogic(ActionEvent e) {
		
		if (e.getSource() == submitButton) {
			
			validationNumber = StandingsDataUtil.validateStandingsDataForPoints(localClubPointsField.getText(),visitorClubPointsField.getText());

			
			if (StandingsDataUtil.validateStandingsDataForEmpties(localClubField.getText(), visitorClubField.getText(), localClubPointsField.getText(),visitorClubPointsField.getText())) {
				handleValidationNumber(SOME_OR_ALL_FIELDS_ARE_EMPTY);
			} else if (StandingsDataUtil.validateStandingsDataForWrongTeamName(localClubField.getText(), visitorClubField.getText())) {
				handleValidationNumber(WRONG_TEAM_NAME); 
			} else if (StandingsDataUtil.validateStandingsDataForSameTeamNAme(localClubField.getText(), visitorClubField.getText())) {
				handleValidationNumber(THE_SAME_NAME_FOR_TEAMS_IS_NOT_ALLOWED); 
			} else if(validationNumber == ALL_POINTS_ARE_INVALID || validationNumber == LOCAL_POINTS_ARE_INVALID || validationNumber == VISITOR_POINTS_ARE_INVALID) {
				handleValidationNumber(validationNumber); 
			} else {
				new AddGameUtil(this.games,localClubField.getText(),visitorClubField.getText(),localClubPointsField.getText(),visitorClubPointsField.getText());
				new StandingsCalculation(this.teams, this.games);
			}
			
			// add logic
							

		} else if (e.getSource() == updateButton) {
			
			if (StandingsDataUtil.validateStandingsDataForEmpties(localClubField.getText(), visitorClubField.getText(), localClubPointsField.getText(),visitorClubPointsField.getText())) {
				handleValidationNumber(SOME_OR_ALL_FIELDS_ARE_EMPTY);
			} else if (StandingsDataUtil.validateStandingsDataForWrongTeamName(localClubField.getText(), visitorClubField.getText())) {
				handleValidationNumber(WRONG_TEAM_NAME); 
			} else if (StandingsDataUtil.validateStandingsDataForSameTeamNAme(localClubField.getText(), visitorClubField.getText())) {
				handleValidationNumber(THE_SAME_NAME_FOR_TEAMS_IS_NOT_ALLOWED); 
			} else  {
				validationNumber = StandingsDataUtil.validateStandingsDataForPoints(localClubPointsField.getText(),visitorClubPointsField.getText());
				handleValidationNumber(validationNumber); 
			}
			
			/// logic to add

			
		} else if (e.getSource() == cancelButton) {
			localClubField.setText("");
			visitorClubField.setText("");
			localClubPointsField.setText("");
			visitorClubPointsField.setText("");
			
			comboWeekModel = new DefaultComboBoxModel<>();
	        for (int i = 1; i < 11; i++) {
	            comboWeekModel.addElement("Week " + i);
	        }
	        weekComboBox.setModel(comboWeekModel);
		}
	}
	
	
	
	public void handleValidationNumber(int validationNumber) {
		
		switch (validationNumber) {
		case SOME_OR_ALL_FIELDS_ARE_EMPTY:
			userDialog("Some fields are empty, fields must be filled", "Fields Requirement");        
			break;
		case WRONG_TEAM_NAME:
			userDialog("You have inserted the wrong team name, see the Teams panel for reference ", " Wrong Team name");
			break;		
		case THE_SAME_NAME_FOR_TEAMS_IS_NOT_ALLOWED:
			userDialog("You have inserted the same name for both teams, see the Teams panel for reference ", " Same name for both Teams");
			break;
		case ALL_POINTS_ARE_INVALID:
			errorMessageForVisitorPointsField.setText("Incorrect set of points");
			errorMessageForLocalPointsField.setText("Incorrect set of points");
			break;
		case LOCAL_POINTS_ARE_INVALID:
			errorMessageForLocalPointsField.setText("Incorrect set of points");
			break;
		case VISITOR_POINTS_ARE_INVALID:
			errorMessageForVisitorPointsField.setText("Incorrect set of points");
			break;
		default :
			//this.dispose();
			//new SportsDashboardPage();
		}
	}	
	
	
	
	 public void fieldFocusListener(JTextField localPoints, JTextField visitorPoints) {
		 if (localPoints != null) {
			 localPoints.addFocusListener(new FocusListener() {
				    @Override
				    public void focusGained(FocusEvent e) {
				    	errorMessageForLocalPointsField.setText("");
				    }

				    @Override
				    public void focusLost(FocusEvent e) {
				     
				    }
				});
		 } else if (visitorPoints != null) {
			 	visitorPoints.addFocusListener(new FocusListener() {
				    @Override
				    public void focusGained(FocusEvent e) {
				    	errorMessageForVisitorPointsField.setText("");
				    }

				    @Override
				    public void focusLost(FocusEvent e) {
				       
				    }
				});
		 }
	}
	
	
	private void userDialog(String dialogText, String dialogTitle) {
		
		 JOptionPane fieldRequirementPane = new JOptionPane(dialogText,JOptionPane.YES_OPTION);

		 fieldRequirementPane.setMessageType(JOptionPane.WARNING_MESSAGE);

	        JPanel buttonPanel = (JPanel)fieldRequirementPane.getComponent(1);
	        
	        JButton accepetButton = (JButton)buttonPanel.getComponent(0);
	        accepetButton.setText("Accepet");
	        accepetButton.setFocusable(false);
	        accepetButton.setBackground(Color.LIGHT_GRAY);
	        
	        JDialog passwordRequirementdialog = fieldRequirementPane.createDialog(this, dialogTitle);
	        passwordRequirementdialog.setVisible(true);
	}
	
 
 
}
