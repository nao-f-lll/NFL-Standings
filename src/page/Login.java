package page;

import model.ParentFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;

public class Login extends ParentFrame  implements ActionListener, KeyListener  {
	
	private static final long serialVersionUID = 6002789331622401022L;
	
    private ImageIcon nflIcon;
    
	private  HashMap<String, String> loginInfo;
	
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
      
    private JButton loginButton;
    private JButton signUpButton;
    
    private JLabel errorMessageForEmail = new JLabel();
    private JLabel errorMessageForPassword = new JLabel();
    
    
      
	public Login(HashMap<String, String> loginInfo) {	
		
		initializeFrame(loginInfo);	
		initializeGraphics();	
	}
	
	
	
	
	private void initializeFrame(HashMap<String, String> loginInfo) {
		this.setTitle("Login");	
		this.setLocationRelativeTo(null);
		this.loginInfo = loginInfo;
		this.setResizable(false);
		this.setSize(650,400);
		setSizeAndCenter();
	}
	
    
    private void setSizeAndCenter() {
	    Toolkit tool = getToolkit();
	    Dimension screenSize = tool.getScreenSize();
	    this.setLocation(screenSize.width / 2 - getWidth() / 2, screenSize.height / 2 - getHeight() / 2);
    }
	

	
	 private void initializeGraphics() {
		 initialMainPanel();
		 initialLeftPanel();
		 initialRightPanel();
	 }
	
	 private void initialMainPanel() {
			mainPanel = new JPanel();
			mainPanel.setBackground(new Color(238, 238, 236));
			getContentPane().add(mainPanel, BorderLayout.CENTER);
			mainPanel.setLayout(null);
	 }
	 
	 private void initialLeftPanel() {
			leftIneerPanel = new JPanel();   
			leftIneerPanel.setBounds(0, 0, 322, 376);		
			leftIneerPanel.setLayout(null);
			leftIneerPanel.setBackground(new Color(255,255,255));
			mainPanel.add(leftIneerPanel);
			initialNflIcon();
			initialCopyRights();
}
	 
	 private void initialNflIcon() {
			nflIcon = new ImageIcon(ResizeIcon("/images/nflWhite.png",280,200));
			nflIconLabel = new JLabel("");
			nflIconLabel.setHorizontalAlignment(SwingConstants.CENTER);
			nflIconLabel.setIcon(nflIcon);
			nflIconLabel.setBounds(100, 50, 150, 211);
			leftIneerPanel.add(nflIconLabel);
	 }
	 
	 private void initialCopyRights() {
			copyRights = new JLabel("<html> Copyright © 2023 NFL.<br> all rights reserved </html>");
			copyRights.setBounds(121,255,120,40);
		    copyRights.setFont(new Font(null, Font.PLAIN,10));
		    leftIneerPanel.add(copyRights);
	 }
	 
	 
	 private void initialRightPanel() {
		 rightInnerPanel = new JPanel();
		 rightInnerPanel.setBounds(323, 0, 317, 376); 
		 rightInnerPanel.setLayout(null);
		 mainPanel.add(rightInnerPanel);
		 initializeLabeles();
		 initializeEmail();
		 initializePassword();
		 initialzeButtons();
	 }
	 
	 public void initializeLabeles() {
			loginLabel = new JLabel("LOGIN");
			loginLabel.setVerticalAlignment(SwingConstants.TOP);
	        loginLabel.setBounds(66,27,111,42);
	        loginLabel.setFont(new Font(null, Font.PLAIN, 35));
	        rightInnerPanel.add(loginLabel);
	            
		    creatAccountLabel = new JLabel("Create an account?");
		    creatAccountLabel.setBounds(24, 310, 159, 15);
		    rightInnerPanel.add(creatAccountLabel);
	 }
	 
	 public void initializeEmail() {
	        emailLabel = new JLabel("Email");
		    emailLabel.setBounds(34,100,50,25);
		    rightInnerPanel.add(emailLabel);
			emailField = new JTextField();
			emailField.setBounds(34,130,200,25);
			emailField.addKeyListener(this);  
			rightInnerPanel.add(emailField);
			fieldFocusListener(emailField,null);
			
	 }
	 
	 
	 public void initializePassword() {
		    passwordLabel = new JLabel("Password");
		    passwordLabel.setBounds(34,163,70,15);
		    rightInnerPanel.add(passwordLabel);    
		    passwordField = new JPasswordField();
		    passwordField.setBounds(34, 190, 200, 25);   
		    passwordField.addKeyListener(this);
		    rightInnerPanel.add(passwordField); 
		    fieldFocusListener(null,passwordField);
	 }
	 
	 
	 public void fieldFocusListener(JTextField emailField, JPasswordField passwordField) {
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
		 }
	}
	 
	 public void initialzeButtons() {
		    loginButton = new JButton("Login");
			loginButton.setBounds(34, 227, 100, 25);
	        loginButton.setFocusable(false);
	        loginButton.addActionListener(this);
	        loginButton.setBackground(Color.lightGray);
	        rightInnerPanel.add(loginButton);
		    
	        signUpButton = new JButton("Sign Up");
			signUpButton.setBounds(201, 305, 100, 25);
	        signUpButton.setFocusable(false);
	        signUpButton.addActionListener(this);
	        signUpButton.setBackground(Color.lightGray);
			rightInnerPanel.add(signUpButton);	
			
			initializeErrorMessages();
	 }
	 

	 
	private void initializeErrorMessages() {
		
		errorMessageForEmail.setText("");
		errorMessageForEmail.setBounds(136, 100, 130, 25);
		errorMessageForEmail.setForeground(Color.RED);
		rightInnerPanel.add(errorMessageForEmail);	
		
		errorMessageForPassword.setForeground(Color.RED);
		errorMessageForPassword.setBounds(125, 164, 111, 25);
		rightInnerPanel.add(errorMessageForPassword);
	}
		 
	
	@Override
	public void actionPerformed(ActionEvent e) {
		userClickLoginLogic(e);
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		userKeyboardLoginLogic(e);

    }

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}
	
	private void userKeyboardLoginLogic(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {  
        	validateLogin(emailField.getText(),String.valueOf(passwordField.getPassword()));
		
        }
	}
	
	
	private void userClickLoginLogic(ActionEvent e) {
		
		if (e.getSource() == loginButton) {		
			validateLogin(emailField.getText(),String.valueOf(passwordField.getPassword()));

		} else if (e.getSource() == signUpButton) {
			this.dispose();
			new SignUp(this.loginInfo);
		}
	}
	
	
	
	private void validateLogin(String userEmail, String userPassword) {
			
		if (userEmail.isEmpty() && userPassword.isEmpty()) {
			
			errorMessageForPassword.setBounds(138, 164, 111, 25);
			errorMessageForEmail.setText("Field is required");
			errorMessageForPassword.setText("Field is required");
			
		} else if (emailField.getText().equals("")) {
			
				errorMessageForEmail.setText("Field is required");
			
		} else if (String.valueOf(passwordField.getPassword()).equals("")) {
			
				errorMessageForPassword.setText("Field is required");
			
		} else {
		
			if (loginInfo.containsKey(userEmail)) {		
				if (loginInfo.get(userEmail).equals(userPassword)) {
					
					this.dispose();
					new SportsDashboard();		
					
				} else {
						errorMessageForPassword.setText("Incorrect password");
				}
			} else {
					errorMessageForEmail.setText("Email is not found");
			}
		}
			
	
	}
		
}