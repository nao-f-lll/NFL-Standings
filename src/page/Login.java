package page;

import model.Frame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.HashMap;

public class Login extends Frame  implements ActionListener {
	
	private static final long serialVersionUID = 6002789331622401022L;
	
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
      
    private JButton loginButton;
    private JButton signUpButton;
    
      
	public Login(HashMap<String, String> loginInfo) {
		
		this.loginInfo = loginInfo;
		this.setResizable(false);
		
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
		
		
		nflImage = new ImageIcon(Login.class.getResource("/images/nflWhite.png")).getImage().getScaledInstance(150,200,Image.SCALE_SMOOTH);
		nflIcon = new ImageIcon(nflImage);
		nflIconLabel = new JLabel("");
		nflIconLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nflIconLabel.setIcon(nflIcon);
		nflIconLabel.setBounds(100, 50, 150, 245);
		leftIneerPanel.add(nflIconLabel);
		
		
		copyRights = new JLabel("<html> Copyright © 2023 NFL.<br> all rights reserved </html>");
		leftIneerPanel.add(copyRights);
		copyRights.setBounds(120,280,120,40);
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
		
       
	    passwordLabel = new JLabel("Password");
	    passwordLabel.setBounds(34,163,70,15);
	    rightInnerPanel.add(passwordLabel);
	    passwordField = new JPasswordField();
	    passwordField.setBounds(34, 190, 200, 25);
	    rightInnerPanel.add(passwordField);
	    
	    
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

		
		
		//JLabel errorMessage = new JLabel();
		//errorMessage.setText("fdggdgfddf");
		//errorMessage.setBounds(34, 130, 200, 25);
		//rightInnerPanel.add(errorMessage);
		
		
		emailField.addFocusListener(new FocusListener() {
		    @Override
		    public void focusGained(FocusEvent e) {
		        emailField.setForeground(Color.BLACK);
		        emailField.setBackground(Color.WHITE);
		        emailField.setText("");
		    }

		    @Override
		    public void focusLost(FocusEvent e) {
		        // Do nothing when focus is lost
		    }
		});
		
		passwordField.addFocusListener(new FocusListener() {
		    @Override
		    public void focusGained(FocusEvent e) {
		    	passwordField.setForeground(Color.BLACK);
		    	passwordField.setBackground(Color.WHITE);
		    	passwordField.setText("");
		    }

		    @Override
		    public void focusLost(FocusEvent e) {
		        // Do nothing when focus is lost
		    }
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == loginButton) {	
			
			String userEmail = emailField.getText();
			String userPassword = String.valueOf(passwordField.getPassword());
			
			if (userEmail.isEmpty() && userPassword.isEmpty()) {
				emailField.setBackground(new Color(150,0,0));
				emailField.setText("Field is required");
				passwordField.setBackground(new Color(150,0,0));
				
			} else if (emailField.getText().equals("")) {
				emailField.setBackground(new Color(0,150,0));
				emailField.setText("Field is required");
				
			} else if (String.valueOf(passwordField.getPassword()).equals("")) {
				passwordField.setBackground(new Color(0,150,0));
				passwordField.setText("Field is required");
				
			} else {
			
				if (loginInfo.containsKey(userEmail)) {		
					if (loginInfo.get(userEmail).equals(userPassword)) {
							this.dispose();
							new Scores();		
					} 
				}
			}
		} else if (e.getSource() == signUpButton) {
			
		}
	}
}