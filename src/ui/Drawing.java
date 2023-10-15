package ui;

import java.awt.EventQueue;

import credentials.LoginCredentials;
import ui.page.LoginPage;

public class Drawing {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginCredentials credentials = new LoginCredentials();
			        new LoginPage(credentials.getLogingInfo());			    
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}