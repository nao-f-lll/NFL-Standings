package com.standings.model;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JProgressBar;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class CustomProgressBar extends ParentFrame {
	
	
	private static final long serialVersionUID = -4027033588458917019L;
	
	public CustomProgressBar() {
		getContentPane().setBackground(Color.WHITE);	
		getContentPane().setLayout(null);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setForeground(Color.GRAY);
		progressBar.setValue(30);
		progressBar.setStringPainted(true);
		progressBar.setBounds(12, 317, 626, 30);
		getContentPane().add(progressBar);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(ResizeIcon("/images/processing.png",480,400)));
		lblNewLabel.setBounds(67, 68, 495, 279);
		getContentPane().add(lblNewLabel);
		
		initializeFrameGraphics();	

	}
	

	
	private void initializeFrameGraphics() {
		this.setLocationRelativeTo(null);	
		this.setResizable(false);
		this.setSize(650,400);
		setSizeAndCenter();
	}
	
    
    private void setSizeAndCenter() {
	    Toolkit tool = getToolkit();
	    Dimension screenSize = tool.getScreenSize();
	    this.setLocation(screenSize.width / 2 - getWidth() / 2, screenSize.height / 2 - getHeight() / 2);
	   
    }
    
    public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				
			        new CustomProgressBar();			    
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
