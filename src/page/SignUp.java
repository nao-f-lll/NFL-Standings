package page;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import model.Frame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SignUp extends Frame implements ActionListener {

	
	private static final long serialVersionUID = -4747175902106077767L;

	private final Image nflImage;
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
    private JButton signUpButton;
    private JLabel fullNameLabel;
    private JTextField fullNameField;
    private JButton loginButton;
	
    JLabel errorMessageForEmail = new JLabel();
    JLabel errorMessageForPassword = new JLabel();
    JLabel errorMessageForFullName = new JLabel();
	
	
	public SignUp(HashMap<String, String> loginInfo) {
		
		this.loginInfo = loginInfo;
		this.setResizable(false);
		this.setSize(650,479);
		
		//Main Panel
		mainPanel = new JPanel();
		mainPanel.setBackground(new Color(238, 238, 236));
		getContentPane().add(mainPanel, BorderLayout.CENTER);
		mainPanel.setLayout(null);
				
		//Left Panel
		leftIneerPanel = new JPanel();   
		leftIneerPanel.setBackground(new Color(238, 238, 236));
		leftIneerPanel.setBounds(0, 0, 322, 442);
		mainPanel.add(leftIneerPanel);
		leftIneerPanel.setLayout(null);
		leftIneerPanel.setBackground(new Color(255,255,255));
		
		
		nflImage = new ImageIcon(Login.class.getResource("/images/nflWhite.png")).getImage().getScaledInstance(280,200,Image.SCALE_SMOOTH);
		nflIcon = new ImageIcon(nflImage);
		nflIconLabel = new JLabel("");
		nflIconLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nflIconLabel.setIcon(nflIcon);
		nflIconLabel.setBounds(80, 68, 150, 211);
		leftIneerPanel.add(nflIconLabel);
		
		
		
		copyRights = new JLabel("<html> Copyright © 2023 NFL.<br> all rights reserved </html>");
		leftIneerPanel.add(copyRights);
		copyRights.setBounds(100,289,120,40);
	    copyRights.setFont(new Font(null, Font.PLAIN,10));

		// rigth panel
		
	    rightInnerPanel = new JPanel();
		rightInnerPanel.setBounds(323, 0, 317, 442);
		mainPanel.add(rightInnerPanel);
		rightInnerPanel.setLayout(null);
		
		
		loginLabel = new JLabel("SIGN UP");
		loginLabel.setBounds(66, 27, 144, 42);
		loginLabel.setVerticalAlignment(SwingConstants.TOP);
        loginLabel.setFont(new Font(null, Font.PLAIN, 35));
        rightInnerPanel.add(loginLabel);
		
        
        emailLabel = new JLabel("Email");
        emailLabel.setBounds(34, 167, 50, 25);
	    rightInnerPanel.add(emailLabel);
		emailField = new JTextField();
		emailField.setBounds(34, 197, 200, 25);
		rightInnerPanel.add(emailField);
		
       
	    passwordLabel = new JLabel("Password");
	    passwordLabel.setBounds(34, 232, 70, 15);
	    rightInnerPanel.add(passwordLabel);
	    passwordField = new JPasswordField();
	    passwordField.setBounds(34, 257, 200, 25);
	    rightInnerPanel.add(passwordField);
	    
	    
	    creatAccountLabel = new JLabel("Already have an account?");
	    creatAccountLabel.setBounds(21, 379, 159, 15);
	    rightInnerPanel.add(creatAccountLabel);
	    
        signUpButton = new JButton("Sign Up");
        signUpButton.setBounds(34, 304, 100, 25);
        signUpButton.addActionListener(this);
        signUpButton.setFocusable(false); 
        signUpButton.setBackground(Color.lightGray);
		rightInnerPanel.add(signUpButton);	
		
		
		loginButton = new JButton("Login");
		loginButton.setBounds(194, 374, 100, 25);
		loginButton.setFocusable(false);
		loginButton.setBackground(Color.LIGHT_GRAY);
		rightInnerPanel.add(loginButton);
		loginButton.addActionListener(this);
		
		fullNameLabel = new JLabel("Full Name");
		fullNameLabel.setBounds(34, 109, 70, 13);
		rightInnerPanel.add(fullNameLabel);
		
		fullNameField = new JTextField();
		fullNameField.setBounds(34, 132, 200, 25);
		rightInnerPanel.add(fullNameField);
		
		
		
		
		
		//ImageIcon errorIcon = IconImage("");
			
		//errorMessageForEmail.setText("Field is required");
		
		errorMessageForEmail.setForeground(Color.RED);
		rightInnerPanel.add(errorMessageForEmail);
		errorMessageForEmail.setBounds(137, 167, 111, 25);
		
		//errorMessageForPassword.setText("Field is required");
		
		errorMessageForPassword.setForeground(Color.RED);
		rightInnerPanel.add(errorMessageForPassword);
		errorMessageForPassword.setBounds(137, 232, 111, 25);
		
		
		
		errorMessageForFullName.setForeground(Color.RED);
		rightInnerPanel.add(errorMessageForFullName);
		errorMessageForFullName.setBounds(137, 103, 111, 25);
	
		
		
		
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
		
		fullNameField.addFocusListener(new FocusListener() {
		    @Override
		    public void focusGained(FocusEvent e) {
		    	errorMessageForFullName.setText("");
		    }

		    @Override
		    public void focusLost(FocusEvent e) {
		        // Do nothing when focus is lost
		    }
		});	
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == signUpButton) {	
			
			String userEmail = emailField.getText();
			String userPassword = String.valueOf(passwordField.getPassword());
			String userFullName = fullNameField.getText();
			
			if (userEmail.isEmpty() && userPassword.isEmpty() && userFullName.isEmpty()) {
				errorMessageForEmail.setText("Field is required");
				errorMessageForPassword.setText("Field is required");
				errorMessageForFullName.setText("Field is required");
				
			} else if (userEmail.isEmpty()) {
				
				errorMessageForEmail.setText("Field is required");
				
			} else if (userPassword.isEmpty()) {
				errorMessageForPassword.setText("Field is required");
				
			} else if (userFullName.isEmpty()) {
				errorMessageForFullName.setText("Field is required");
				
			}  else if (isValidFullName(userFullName)) {
						
				if (isValidEmail(userEmail)) {
					
					if (isValidPassword(userPassword)) {
						 loginInfo.put(userEmail, userPassword);
							this.dispose();
							new Scores();
					} else {
				  
	
						JOptionPane.showMessageDialog(this, "Password must be a minimum of 8 characters"
													+ " and must include at least one uppercase and one number",
														"Password Requirement",JOptionPane.WARNING_MESSAGE);

					}
					
				} else {
					errorMessageForEmail.setText("Invalid email format");
				}
				
				
			} else {
				
				errorMessageForFullName.setBounds(114, 103, 144, 25);
				errorMessageForFullName.setText("Full Name must be a text");
			}
			
			
		} else if (e.getSource() == loginButton) {
			this.dispose();
			new Login(this.loginInfo);
		}
	}
	
    private boolean isValidEmail(String email) {
        String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    
    private boolean isValidPassword(String password) {
        String regex = "^(?=.*[A-Z])(?=.*[0-9]).{8,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }
    
    private boolean isValidFullName(String fullName) {
        String regex = "^[a-zA-Z]+(?: [a-zA-Z]+)*$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(fullName);
        return matcher.matches();
    }
    

}
