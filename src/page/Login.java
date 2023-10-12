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
	
	//private final Image nflImage;
    private final ImageIcon nflIcon;
    
	private final HashMap<String, String> loginInfo;
	
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
		 
		this.setLocationRelativeTo(null);
		this.loginInfo = loginInfo;
		this.setResizable(false);
		this.setSize(650,400);
		
	    Toolkit tool = getToolkit();
	    Dimension screenSize = tool.getScreenSize();
	    this.setLocation(screenSize.width / 2 - getWidth() / 2, screenSize.height / 2 - getHeight() / 2);
		
		//Main Panel
		mainPanel = new JPanel();
		mainPanel.setBackground(new Color(238, 238, 236));
		getContentPane().add(mainPanel, BorderLayout.CENTER);
		mainPanel.setLayout(null);
				
		//Left Panel
		leftIneerPanel = new JPanel();   
		leftIneerPanel.setBackground(new Color(238, 238, 236));
		leftIneerPanel.setBounds(0, 0, 322, 376);
		mainPanel.add(leftIneerPanel);
		leftIneerPanel.setLayout(null);
		leftIneerPanel.setBackground(new Color(255,255,255));
		
		
		nflIcon = new ImageIcon(ResizeIcon("/images/nflWhite.png",280,200));
		nflIconLabel = new JLabel("");
		nflIconLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nflIconLabel.setIcon(nflIcon);
		nflIconLabel.setBounds(100, 50, 150, 211);
		leftIneerPanel.add(nflIconLabel);
		
		
		
		copyRights = new JLabel("<html> Copyright © 2023 NFL.<br> all rights reserved </html>");
		leftIneerPanel.add(copyRights);
		copyRights.setBounds(121,255,120,40);
	    copyRights.setFont(new Font(null, Font.PLAIN,10));

		// rigth panel
		
	    rightInnerPanel = new JPanel();
		rightInnerPanel.setBounds(323, 0, 317, 376);
		mainPanel.add(rightInnerPanel);
		rightInnerPanel.setLayout(null);
	
		
		
		loginLabel = new JLabel("LOGIN");
		loginLabel.setVerticalAlignment(SwingConstants.TOP);
        loginLabel.setBounds(66,27,111,42);
        loginLabel.setFont(new Font(null, Font.PLAIN, 35));
        rightInnerPanel.add(loginLabel);
		
        
        emailLabel = new JLabel("Email");
	    emailLabel.setBounds(34,100,50,25);
	    rightInnerPanel.add(emailLabel);
		emailField = new JTextField();
		emailField.setBounds(34,130,200,25);
		rightInnerPanel.add(emailField);
		
		emailField.addKeyListener(this);   ////testing
		
       
	    passwordLabel = new JLabel("Password");
	    passwordLabel.setBounds(34,163,70,15);
	    rightInnerPanel.add(passwordLabel);
	    passwordField = new JPasswordField();
	    passwordField.setBounds(34, 190, 200, 25);
	    rightInnerPanel.add(passwordField);
	    
	    passwordField.addKeyListener(this);
	    
	    
	    creatAccountLabel = new JLabel("Create an account?");
	    creatAccountLabel.setBounds(24, 310, 159, 15);
	    rightInnerPanel.add(creatAccountLabel);
		
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

		
		
		
		errorMessageForEmail.setText("");
		errorMessageForEmail.setBounds(136, 100, 130, 25);
		errorMessageForEmail.setForeground(Color.RED);
		rightInnerPanel.add(errorMessageForEmail);
		
		
		
		
		
		errorMessageForPassword.setForeground(Color.RED);
		errorMessageForPassword.setBounds(125, 164, 111, 25);
		rightInnerPanel.add(errorMessageForPassword);
		
		
		emailField.addFocusListener(new FocusListener() {
		    @Override
		    public void focusGained(FocusEvent e) {
		        errorMessageForEmail.setText("");
		    }

		    @Override
		    public void focusLost(FocusEvent e) {
		        // Do nothing when focus is lost
		    }
		});
		
		passwordField.addFocusListener(new FocusListener() {
		    @Override
		    public void focusGained(FocusEvent e) {
		    	errorMessageForPassword.setText("");
		    }

		    @Override
		    public void focusLost(FocusEvent e) {
		        // Do nothing when focus is lost
		    }
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		userClickLoginLogic(e);
	}
	

	@Override
	public void keyPressed(KeyEvent e) {
		userKeyboardLoginLogic(e);

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
	

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	// to do
	//private void initComponent() {
		
	//}
}