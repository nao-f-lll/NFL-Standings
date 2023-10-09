package ui;

import java.awt.EventQueue;
import credentials.UserNameAndPass;
import page.Login;

public class Drawing {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserNameAndPass credentials = new UserNameAndPass();
			        new Login(credentials.getLogingInfo());			    
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}