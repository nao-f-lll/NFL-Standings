package com.standings.ui.page.panel;

import java.awt.Color;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.standings.model.ParentFrame;
import com.standings.ui.page.SportsDashboardPage;

public class UpdateDataPanel extends JPanel{

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
    private JLabel copyRights;
    
    public UpdateDataPanel() {
 
    	 
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
        
        visitorClubPointsField = new JTextField();
        visitorClubPointsField.setColumns(10);
        visitorClubPointsField.setBounds(1250, 392, 35, 34);
        this.add(visitorClubPointsField);
        
        submitButton = new JButton("Submit");
        submitButton.setBounds(778, 535, 130, 45);
        submitButton.setFocusable(false);
        submitButton.setBackground(Color.lightGray);
        this.add(submitButton);
        
        updateButton = new JButton("Update");
        updateButton.setBounds(1001, 535, 130, 45);
        updateButton.setFocusable(false);
        updateButton.setBackground(Color.lightGray);
        this.add(updateButton);
        
        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(1222, 535, 130, 45);
        cancelButton.setFocusable(false);
        cancelButton.setBackground(Color.lightGray);
        this.add(cancelButton);
        
        instructionPanel = new JPanel();
        instructionPanel.setBackground(new Color(255, 255, 255));
        instructionPanel.setBounds(0, 71, 627, 756);
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
        
        
		copyRights = new JLabel("<html> Copyright © 2023 NFL.<br> all rights reserved </html>");
		copyRights.setBounds(225,630,231,40);
	    copyRights.setFont(new Font("Dialog", Font.PLAIN, 13));
	    instructionPanel.add(copyRights);
        
        
        


    }
 
}
