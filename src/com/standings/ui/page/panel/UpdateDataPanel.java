package com.standings.ui.page.panel;

import java.awt.Color;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

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
    
    public UpdateDataPanel() {
 
    	 
    	comboWeekModel = new DefaultComboBoxModel<>();	
    	for (int i = 1; i < 11; i++) {
    		comboWeekModel.addElement("Week " + i);
    	}
    	
        weekComboBox = new JComboBox<>(comboWeekModel);
        weekComboBox.setBackground(Color.LIGHT_GRAY);
        weekComboBox.setBounds(679, 173, 114, 45);
        this.add(weekComboBox);
        
        localClubLabel = new JLabel("Local Club");
        localClubLabel.setBounds(452, 215, 103, 37);
        this.add(localClubLabel);
        
        localClubField = new JTextField();
        localClubField.setBounds(429, 264, 155, 37);
        this.add(localClubField);
        localClubField.setColumns(10);
        
        
        
        visitorClubLabel = new JLabel("Visitor Club");
        visitorClubLabel.setBounds(453, 328, 117, 25);
        this.add(visitorClubLabel);
        
        visitorClubField = new JTextField();
        visitorClubField.setColumns(10);
        visitorClubField.setBounds(429, 365, 155, 37);
        this.add(visitorClubField);
        
        
        localClubPointsLabel = new JLabel("Points");
        localClubPointsLabel.setBounds(873, 215, 71, 37);
        this.add(localClubPointsLabel);
        
        visitorClubPointsLabel = new JLabel("Points");
        visitorClubPointsLabel.setBounds(873, 313, 84, 31);
        this.add(visitorClubPointsLabel);
        
        
        localClubPointsField = new JTextField();
        localClubPointsField.setBounds(873, 266, 35, 34);
        this.add(localClubPointsField);
        localClubPointsField.setColumns(10);
        
        visitorClubPointsField = new JTextField();
        visitorClubPointsField.setColumns(10);
        visitorClubPointsField.setBounds(873, 367, 35, 34);
        this.add(visitorClubPointsField);
        
        submitButton = new JButton("Submit");
        submitButton.setBounds(391, 468, 130, 45);
        submitButton.setFocusable(false);
        submitButton.setBackground(Color.lightGray);
        this.add(submitButton);
        
        updateButton = new JButton("Update");
        updateButton.setBounds(608, 468, 130, 45);
        updateButton.setFocusable(false);
        updateButton.setBackground(Color.lightGray);
        this.add(updateButton);
        
        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(836, 468, 130, 45);
        cancelButton.setFocusable(false);
        cancelButton.setBackground(Color.lightGray);
        this.add(cancelButton);
        


    }
 
}
