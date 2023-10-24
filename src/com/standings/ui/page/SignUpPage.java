package com.standings.ui.page;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.standings.model.ParentFrame;
import com.standings.util.SignUpValidationUtil;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SignUpPage extends ParentFrame implements ActionListener, KeyListener {

	
	private static final long serialVersionUID = -4747175902106077767L;

    private ImageIcon nflIcon;
    
	private HashMap<String, String> loginInfo;
	
    private JLabel nflIconLabel;
    private JLabel copyRights;
    private JLabel loginLabel;
    private JLabel emailLabel;
    private JLabel passwordLabel;
    private JLabel creatAccountLabel;
    
	private JPanel mainPanel;
	private JPanel leftIneerPanel;   
    private JPanel rightInnerPanel;
    
    
    private JTextField emailField;
    private JPasswordField passwordField;
    private JButton signUpButton;
    private JLabel fullNameLabel;
    private JTextField fullNameField;
    private JButton loginButton;
	
    private JLabel errorMessageForEmail = new JLabel();
    private JLabel errorMessageForPassword = new JLabel();
    private JLabel errorMessageForFullName = new JLabel();
	
	
	public SignUpPage(HashMap<String, String> loginInfo) {
		setTitle("Registrarse");
		
		initializFrameGraphics(loginInfo);
		initializePanelsGraphics();

	}
	
	
	private void initializFrameGraphics(HashMap<String, String> loginInfo) {
		this.setLocationRelativeTo(null);
		this.loginInfo = loginInfo;
		this.setResizable(false);
		this.setSize(650,479);
		setSizeAndCenter();
	}
	
    private void setSizeAndCenter() {
	    Toolkit tool = getToolkit();
	    Dimension screenSize = tool.getScreenSize();
	    this.setLocation(screenSize.width / 2 - getWidth() / 2, screenSize.height / 2 - getHeight() / 2);
    }
	
    
    private void initializePanelsGraphics() {
    	initializeMainPanel();
    	initializeRightInnerPanel();
    	initializeLeftInnerPanel();
    }
    
    
    private void initializeMainPanel() {
		mainPanel = new JPanel();
		mainPanel.setBackground(new Color(238, 238, 236));
		getContentPane().add(mainPanel, BorderLayout.CENTER);
		mainPanel.setLayout(null);
    }
    
    private void initializeRightInnerPanel() {
	    rightInnerPanel = new JPanel();
		rightInnerPanel.setBounds(323, 0, 317, 442);
		mainPanel.add(rightInnerPanel);
		rightInnerPanel.setLayout(null);
		initializeLoginLabel();
		initializeEmail();
		initializePassword();
		initializeFullName();
		initializeCreatAcountLabel();
		initializeButtons();
		initializeErrorMessages();
    }
    
   private void initializeLoginLabel() {
		loginLabel = new JLabel("Rigistrarse");
		loginLabel.setBounds(60, 23, 188, 42);
		loginLabel.setVerticalAlignment(SwingConstants.TOP);
		loginLabel.setFont(new Font(null, Font.PLAIN, 35));
		rightInnerPanel.add(loginLabel);
    }
   
   private void initializeEmail() {
       emailLabel = new JLabel("Email");
       emailLabel.setBounds(34, 167, 50, 25);
	   rightInnerPanel.add(emailLabel);
	   
	   emailField = new JTextField();	
	   emailField.setBounds(34, 197, 200, 25);
	   rightInnerPanel.add(emailField);
	   emailField.addKeyListener(this); 
	   
	   fieldFocusListener(emailField,null,null);
   }
   
   private void initializePassword() {
	    passwordLabel = new JLabel("Contraseña");
	    passwordLabel.setBounds(34, 232, 70, 15);
	    rightInnerPanel.add(passwordLabel);
	    passwordField = new JPasswordField();
	    passwordField.setBounds(34, 257, 200, 25);
	    rightInnerPanel.add(passwordField);
	    passwordField.addKeyListener(this); 
	    fieldFocusListener(null,passwordField,null);
   }

   
   private void initializeFullName() {
		fullNameLabel = new JLabel("Nombre");
		fullNameLabel.setBounds(34, 109, 70, 13);
		rightInnerPanel.add(fullNameLabel);
		
		fullNameField = new JTextField();
		fullNameField.setBounds(34, 132, 200, 25);
		rightInnerPanel.add(fullNameField);
		fullNameField.addKeyListener(this); 
		fieldFocusListener(null,null,fullNameField);
 }
   
   private void fieldFocusListener(JTextField emailField, JPasswordField passwordField, JTextField fullNameField) {
	   if (emailField != null) {
		   emailField.addFocusListener(new FocusListener() {
			    @Override
			    public void focusGained(FocusEvent e) {
			        errorMessageForEmail.setText("");
			    }

			    @Override
			    public void focusLost(FocusEvent e) {
			    	
			    }
			});   
	   } else if (passwordField != null) {
			passwordField.addFocusListener(new FocusListener() {
			    @Override
			    public void focusGained(FocusEvent e) {
			    	errorMessageForPassword.setText("");
			    }

			    @Override
			    public void focusLost(FocusEvent e) {
			    	
			    }
			});
			
	   } else if (fullNameField != null) {

			fullNameField.addFocusListener(new FocusListener() {
			    @Override
			    public void focusGained(FocusEvent e) {
			    	errorMessageForFullName.setText("");
			    }

			    @Override
			    public void focusLost(FocusEvent e) {
			    
			    }
			});	
	   }
   }
   
   private void initializeCreatAcountLabel() {
	    creatAccountLabel = new JLabel("¿Ya tienes una cuenta?");
	    creatAccountLabel.setBounds(21, 379, 159, 15);
	    rightInnerPanel.add(creatAccountLabel);
  }
   
   

   private void initializeButtons() {
	   initializeLoginButton();
	   initializeSignUpButton();
   }
   
   private void initializeLoginButton() {	
		loginButton = new JButton("Inicia sesión");
		loginButton.setBounds(183, 374, 111, 25);
		loginButton.setFocusable(false);
		loginButton.setBackground(Color.LIGHT_GRAY);
		rightInnerPanel.add(loginButton);
		loginButton.addActionListener(this);
   }
   
   private void initializeSignUpButton() {
       signUpButton = new JButton("Regístrate");
       signUpButton.setBounds(34, 304, 100, 25);
       signUpButton.addActionListener(this);
       signUpButton.setFocusable(false); 
       signUpButton.setBackground(Color.lightGray);
	   rightInnerPanel.add(signUpButton);	
   }
   
   
   private void initializeErrorMessages() {
	   initializeEmailErrorMessage();
	   initializePasswordErrorMessage();
	   initializeFullNameErrorMessage();
   }
   
   private void initializeEmailErrorMessage() {
		errorMessageForEmail.setForeground(Color.RED);
		rightInnerPanel.add(errorMessageForEmail);
		errorMessageForEmail.setBounds(137, 167, 111, 25);
   }
   private void initializePasswordErrorMessage() {
		errorMessageForPassword.setForeground(Color.RED);
		rightInnerPanel.add(errorMessageForPassword);
		errorMessageForPassword.setBounds(137, 232, 111, 25);
   }
   private void initializeFullNameErrorMessage() {
		errorMessageForFullName.setForeground(Color.RED);
		rightInnerPanel.add(errorMessageForFullName);
		errorMessageForFullName.setBounds(137, 103, 111, 25);
   }
   
    private void initializeLeftInnerPanel() {
    	leftIneerPanel = new JPanel();   
		leftIneerPanel.setBackground(new Color(238, 238, 236));
		leftIneerPanel.setBounds(0, 0, 322, 442);
		mainPanel.add(leftIneerPanel);
		leftIneerPanel.setLayout(null);
		leftIneerPanel.setBackground(new Color(255,255,255));
		initializeNflIcon();
		initializeCopyRights();
    }
    
    private void initializeNflIcon() {
		nflIcon = new ImageIcon(ResizeIcon("/images/nflWhite.png",280,200));
		nflIconLabel = new JLabel("");
		nflIconLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nflIconLabel.setIcon(nflIcon);
		nflIconLabel.setBounds(80, 68, 150, 211);
		leftIneerPanel.add(nflIconLabel);
    }
    
    private void initializeCopyRights() {
		copyRights = new JLabel("<html> Copyright © 2023 NFL.<br> all rights reserved </html>");
		leftIneerPanel.add(copyRights);
		copyRights.setBounds(100,289,120,40);
	    copyRights.setFont(new Font(null, Font.PLAIN,10));
    }
    
	@Override
	public void actionPerformed(ActionEvent e) {
		userClickLoginLogic(e);
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		char keyChar = e.getKeyChar();
		if (keyChar != KeyEvent.VK_ENTER) {
			errorMessageForPassword.setText("");
			errorMessageForEmail.setText("");
			errorMessageForFullName.setText("");
           
        }
	}


	@Override
	public void keyPressed(KeyEvent e) {
		userKeyboardLoginLogic(e);
		
	}


	@Override
	public void keyReleased(KeyEvent e) {
		
		
	}
	
	private void userKeyboardLoginLogic(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {  
        	validateLogin(fullNameField.getText(),emailField.getText(),String.valueOf(passwordField.getPassword()));
		
        }
	}
	
	private void userClickLoginLogic(ActionEvent e) {
		
		if (e.getSource() == signUpButton) {	

			validateLogin(fullNameField.getText(), emailField.getText(), String.valueOf(passwordField.getPassword()));
			
		} else if (e.getSource() == loginButton) {
			this.dispose();
			new LoginPage(this.loginInfo);
		}
	}
	
	
	private void validateLogin(String userFullName, String userEmail, String userPassword) {
		
		if(handleEmptyFields(userFullName, userEmail, userPassword)) {
			handleCredentialvalidation(userFullName, userEmail, userPassword);
		}
	}
	


	private boolean handleEmptyFields(String userFullName, String userEmail, String userPassword) {

		if (SignUpValidationUtil.checkForEmptyField(userFullName, userEmail, userPassword)) {
			promptErrorMessage(1, 1, 1,"Field is required");
			return false;
			
		} else if (SignUpValidationUtil.checkForEmptyField(userEmail, userFullName)) {
			promptErrorMessage(1, 1, 0,"Field is required");
			return false;
			
		} else if (SignUpValidationUtil.checkForEmptyField(userEmail, userPassword)) {
			promptErrorMessage(0, 1, 1, "Field is required");
			return false;
				
		} else if (SignUpValidationUtil.checkForEmptyField(userFullName, userPassword)) {		
			promptErrorMessage(1, 0, 1, "Field is required");	
			return false;
	
		} else if (SignUpValidationUtil.checkForEmptyField(userFullName)) {
			promptErrorMessage(1, 0, 0, "Field is required");
			return false;
			
		} else if (SignUpValidationUtil.checkForEmptyField(userEmail)) {
			promptErrorMessage(0, 1, 0, "Field is required");
			return false;
			
		} else if (SignUpValidationUtil.checkForEmptyField(userPassword)) {
			promptErrorMessage(0, 0, 1, "Field is required");
			return false;
		}
		return true;
	}

	
	private void handleCredentialvalidation(String userFullName, String userEmail, String userPassword) {
		
		if (SignUpValidationUtil.isValidFullName(userFullName)) {				
			if (SignUpValidationUtil.isValidEmail(userEmail)) {
				if (!loginInfo.containsKey(userEmail)) {		
					if (SignUpValidationUtil.isValidPassword(userPassword)) {
							loginInfo.put(userEmail, userPassword);
							this.dispose();
							new LoginPage(loginInfo);
					} else {
					
							userDialog("Password must be a minimum of 8 characters"
									+ " and must include at least one uppercase and one number", "Password Requirement");
					}
				} else {
					promptErrorMessage(0, 1, 0, "Email already exists");
				}
				
			} else {
				promptErrorMessage(0, 1, 0, "Invalid email format");
			}
					
		} else {
			errorMessageForFullName.setBounds(114, 103, 144, 25);
			promptErrorMessage(1, 0, 0, "Full Name must be a text");
		}
	}
	
	
	private void promptErrorMessage(int fullNameBit, int emailBit, int passwordBit, String errorMessage) {
	    for (int i = 0; i < 3 ; i++) {
	    	if (fullNameBit == 1) {
	    		 errorMessageForFullName.setText(errorMessage);
	    	}
	    	if (emailBit == 1) {
	    		 errorMessageForEmail.setText(errorMessage);
	    	}
	    	if (passwordBit == 1) {
	    		errorMessageForPassword.setText(errorMessage);
	    	}

	    }
	}
	
	
	private void userDialog(String warrningText, String warrningTitle) {
		
        JOptionPane passwordRequirementPane = new JOptionPane(warrningText, JOptionPane.YES_OPTION);

        passwordRequirementPane.setMessageType(JOptionPane.WARNING_MESSAGE);

        JPanel buttonPanel = (JPanel)passwordRequirementPane.getComponent(1);
        
        JButton accepetButton = (JButton)buttonPanel.getComponent(0);
        accepetButton.setText("Accept");
        accepetButton.setFocusable(false);
        accepetButton.setBackground(Color.LIGHT_GRAY);
        
        JDialog passwordRequirementdialog = passwordRequirementPane.createDialog(this, warrningTitle);
        passwordRequirementdialog.setVisible(true);
	}
}