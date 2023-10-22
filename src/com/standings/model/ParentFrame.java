package com.standings.model;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import com.standings.ui.page.LoginPage;

public class ParentFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private final ImageIcon nflIconFrame = new ImageIcon(LoginPage.class.getResource("/images/nflDark.png"));
	private Image logo;
	private static  Image logoStatic;
    
	public ParentFrame () {
	    this.setIconImage(nflIconFrame.getImage());
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setVisible(true);
	}
	
	//REQUIRES: image path to be a valid path that contain an image; width and height must be a positive integer.
	//MODIFIES: change the size of the given image to match given width and height.
	//EFFECTS:  returns the icon with the wanted size.
	protected Image ResizeIcon(String ImagePath, int width, int height) {
		logo = new ImageIcon(LoginPage.class.getResource(ImagePath)).getImage().getScaledInstance(width,height,Image.SCALE_SMOOTH);
		return logo;
	}
	
	//REQUIRES: image path to be a valid path that contain an image; width and height must be a positive integer.
	//MODIFIES: change the size of the given image to match given width and height.
	//EFFECTS:  returns the icon with the wanted size.
	
	public static Image ResizeIconStatic(String ImagePath, int width, int height) {
		logoStatic = new ImageIcon(LoginPage.class.getResource(ImagePath)).getImage().getScaledInstance(width,height,Image.SCALE_SMOOTH);
		return logoStatic;
	}
	
	
}