package model;


import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import page.Login;

public class Frame extends JFrame {

	private static final long serialVersionUID = 1L;
	private final ImageIcon nflIconFrame = new ImageIcon(Login.class.getResource("/images/nflDark.png"));
	private Image logo;
    
	public Frame () {
	    this.setIconImage(nflIconFrame.getImage());
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setVisible(true);
	}
	
	protected Image ResizeIcon(String ImagePath, int width, int height) {
		logo = new ImageIcon(Login.class.getResource(ImagePath)).getImage().getScaledInstance(width,height,Image.SCALE_SMOOTH);
		return logo;
	}
}