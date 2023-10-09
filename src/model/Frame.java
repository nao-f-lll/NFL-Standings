package model;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import page.Login;

public class Frame extends JFrame {

	private static final long serialVersionUID = 1L;
	private final ImageIcon nflIconFrame = new ImageIcon(Login.class.getResource("/images/nflDark.png"));
	
	public Frame () {
	    this.setIconImage(nflIconFrame.getImage());
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    this.setVisible(true);
	}
}
