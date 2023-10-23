package com.standings.ui.page.panel;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import static com.standings.model.ParentFrame.*;

public class TeamsPanel extends JPanel  {
	
	
    private static final long serialVersionUID = -538081400942327500L;
	private JLabel afcLeagueLabel;
    private JLabel nflLeagueLabel;
     
    private JLabel cardinalsIconLabel;
    private ImageIcon cardinalsIcon;
    private JLabel cardinalsNameLabel;
    private JLabel cardinalsStadiumLabel;
    private JLabel cardinalsFundiationLabel;
    private JLabel cardinalsCityLabel;
    
    
    private JLabel cowboysIconLabel;
    private ImageIcon cowboysIcon;
    private  JLabel cowboysNameLabel;
    private JLabel cowboysStadiumLabel;
    private JLabel cowboysFundiationLabel;
    private JLabel cowboysCityLabel;
    
    
    private JLabel steelersIconLabel;
    private ImageIcon steelersIcon;
    private JLabel steelersNameLabel;
    private JLabel steelersStadiumLabel;
    private JLabel steelersCityLabel;
    private JLabel steelersFundiationLabel;
        
    private JLabel raidersIconLabel;
    private ImageIcon raidersIcon;
    private JLabel raidersNameLabel;
    private JLabel raidersStadiumLabel;
    private JLabel raidersCityLabel;
    private JLabel raidersFundiationLabel;
       
    private JLabel chiefsIconLabel;
    private ImageIcon chiefsIcon;
    private JLabel chiefsNameLabel;
    private JLabel chiefsStadiumLabel;
    private JLabel chiefsCityLabel;
    private JLabel chiefsFundiationLabel;
    
    private JLabel bengalsIconLabel;
    private ImageIcon bengalsIcon;
    private JLabel bengalsNameLabel;
    private JLabel bengalsStadiumLabel;
    private JLabel bengalsCityLabel;
    private JLabel bengalsFundiationLabel;
    

    
    public TeamsPanel() {
    	
    	initializeNflLeagueLabel();
    	initializeAfcLeagueLabel();
    	initializeTeams();

    }
    
    private void initializeNflLeagueLabel() {
    	nflLeagueLabel = new JLabel("NFL Category");
        nflLeagueLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        nflLeagueLabel.setBounds(23, 55, 148, 54);
        //nflLeagueLabel.setBackground(Color.WHITE);
        this.add(nflLeagueLabel);
    }
    
    private void initializeAfcLeagueLabel() {
        afcLeagueLabel = new JLabel("AFC Category");
        afcLeagueLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        afcLeagueLabel.setBounds(23, 370, 148, 54);
       // nflLeagueLabel.setBackground(Color.WHITE);
        this.add(afcLeagueLabel);
	}
    
    private void initializeTeams() {
    	initializeCowboys();
    	initializeCardinals();
    	initializeSteelers();
    	initializeRaiders();
    	initializeBengals();
    	initializeChiefs();
    }
    
    private void initializeCowboys() {

 	    cowboysIcon = new ImageIcon(ResizeIconStatic("/images/cowboys.png",120,80));
        cowboysIconLabel = new JLabel("");
        cowboysIconLabel.setHorizontalAlignment(SwingConstants.CENTER);
        cowboysIconLabel.setIcon(cowboysIcon);
        cowboysIconLabel.setBounds(112, 66, 191, 160);
        this.add(cowboysIconLabel);
            
        cowboysNameLabel = new JLabel("Cowboys");
        cowboysNameLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
        cowboysNameLabel.setBounds(305, 134, 100, 45);
        this.add(cowboysNameLabel);
        
        cowboysStadiumLabel = new JLabel("AT&T Stadium");
        cowboysStadiumLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        cowboysStadiumLabel.setBounds(305, 234, 300, 54);
        this.add(cowboysStadiumLabel);
        
        cowboysFundiationLabel = new JLabel("1960");
        cowboysFundiationLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        cowboysFundiationLabel.setBounds(305, 282, 148, 54);
        this.add(cowboysFundiationLabel);
        
        
        cowboysCityLabel = new JLabel("Texas");
        cowboysCityLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        cowboysCityLabel.setBounds(305, 323, 148, 54);
        this.add(cowboysCityLabel);
        

    }
    
    private void initializeCardinals() {
        cardinalsIcon = new ImageIcon(ResizeIconStatic("/images/cardinals.png",120,80));
        cardinalsIconLabel = new JLabel("");
        cardinalsIconLabel.setHorizontalAlignment(SwingConstants.CENTER);
        cardinalsIconLabel.setIcon(cardinalsIcon);
        cardinalsIconLabel.setBounds(503, 85, 210, 125);
        this.add(cardinalsIconLabel);
        
        
        cardinalsNameLabel = new JLabel("Cardinals");
        cardinalsNameLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
        cardinalsNameLabel.setBounds(725, 134, 100, 45);
        this.add(cardinalsNameLabel);
               
        cardinalsStadiumLabel = new JLabel("Bush Stadium");
        cardinalsStadiumLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        cardinalsStadiumLabel.setBounds(733, 234, 148, 54);
        this.add(cardinalsStadiumLabel);
        
        cardinalsFundiationLabel = new JLabel("1984");
        cardinalsFundiationLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        cardinalsFundiationLabel.setBounds(733, 282, 148, 54);
        this.add(cardinalsFundiationLabel);
        
        cardinalsCityLabel = new JLabel("Arizona");
        cardinalsCityLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        cardinalsCityLabel.setBounds(733, 323, 148, 54);
        this.add(cardinalsCityLabel);
    }
    
    private void initializeSteelers() {
        
        steelersIcon = new ImageIcon(ResizeIconStatic("/images/steelers.png",120,80));
        steelersIconLabel = new JLabel("");
        steelersIconLabel.setHorizontalAlignment(SwingConstants.CENTER);
        steelersIconLabel.setIcon(steelersIcon);
        steelersIconLabel.setBounds(974, 72, 191, 160);
        this.add(steelersIconLabel);
          
        steelersNameLabel = new JLabel("Steelers");
        steelersNameLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
        steelersNameLabel.setBounds(1177, 131, 100, 45);
        this.add(steelersNameLabel);
        
        steelersStadiumLabel = new JLabel("Acrisure Stadium");
        steelersStadiumLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        steelersStadiumLabel.setBounds(1177, 235, 148, 54);
        this.add(steelersStadiumLabel);
        
        steelersFundiationLabel = new JLabel("1933");
        steelersFundiationLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        steelersFundiationLabel.setBounds(1177, 287, 148, 54);
        this.add(steelersFundiationLabel);
        
        steelersCityLabel = new JLabel("Pittsburgh");
        steelersCityLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        steelersCityLabel.setBounds(1177, 331, 148, 54);
        this.add(steelersCityLabel);
    }
 
    private void initializeRaiders() {
        raidersIcon = new ImageIcon(ResizeIconStatic("/images/raiders.png",120,80));
        raidersIconLabel = new JLabel("");
        raidersIconLabel.setHorizontalAlignment(SwingConstants.CENTER);
        raidersIconLabel.setIcon(raidersIcon);
        raidersIconLabel.setBounds(107, 397, 210, 125);
        this.add(raidersIconLabel);       
        
        raidersNameLabel = new JLabel("Raiders");
        raidersNameLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
        raidersNameLabel.setBounds(329, 431, 100, 45);
        this.add(raidersNameLabel);
        
        raidersStadiumLabel = new JLabel("Vegas Stadium");
        raidersStadiumLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        raidersStadiumLabel.setBounds(329, 521, 148, 54);
        this.add(raidersStadiumLabel);
        
        raidersFundiationLabel = new JLabel("1959");
        raidersFundiationLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        raidersFundiationLabel.setBounds(329, 572, 148, 54);
        this.add(raidersFundiationLabel);
        
        raidersCityLabel = new JLabel("Las Vegas");
        raidersCityLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        raidersCityLabel.setBounds(329, 615, 148, 54);
        this.add(raidersCityLabel);
    }
 
    private void initializeBengals() {
        bengalsIcon = new ImageIcon(ResizeIconStatic("/images/bengals.png",120,80));
        bengalsIconLabel = new JLabel("");
        bengalsIconLabel.setHorizontalAlignment(SwingConstants.CENTER);
        bengalsIconLabel.setIcon(bengalsIcon);
        bengalsIconLabel.setBounds(961, 383, 210, 125);
        this.add(bengalsIconLabel);
        
        
        bengalsNameLabel = new JLabel("Bengals");
        bengalsNameLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
        bengalsNameLabel.setBounds(1183, 433, 100, 45);
        this.add(bengalsNameLabel);
        
        
        bengalsStadiumLabel = new JLabel("Paycor Stadium");
        bengalsStadiumLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        bengalsStadiumLabel.setBounds(1183, 521, 148, 54);
        this.add(bengalsStadiumLabel);
        
        bengalsFundiationLabel = new JLabel("1920");
        bengalsFundiationLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        bengalsFundiationLabel.setBounds(1183, 571, 148, 54);
        this.add(bengalsFundiationLabel);
        
        bengalsCityLabel = new JLabel("Cincinnati");
        bengalsCityLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        bengalsCityLabel.setBounds(1183, 615, 148, 54);
        this.add(bengalsCityLabel); 
    }
    
    private void initializeChiefs() {
    	 chiefsIcon = new ImageIcon(ResizeIconStatic("/images/chiefs.png",120,80));
         chiefsIconLabel = new JLabel("");
         chiefsIconLabel.setHorizontalAlignment(SwingConstants.CENTER);
         chiefsIconLabel.setIcon(chiefsIcon);
         chiefsIconLabel.setBounds(533, 383, 210, 125);
         this.add(chiefsIconLabel);
         
         
         chiefsNameLabel = new JLabel("Chiefs");
         chiefsNameLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
         chiefsNameLabel.setBounds(740, 428, 100, 45);
         this.add(chiefsNameLabel);
         
         
         chiefsStadiumLabel = new JLabel("Arrowhead Stadium");
         chiefsStadiumLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
         chiefsStadiumLabel.setBounds(740, 520, 148, 54);
         this.add(chiefsStadiumLabel);
         
         chiefsFundiationLabel = new JLabel("1949");
         chiefsFundiationLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
         chiefsFundiationLabel.setBounds(740, 571, 148, 54);
         this.add(chiefsFundiationLabel);
         
         chiefsCityLabel = new JLabel("Kansas City");
         chiefsCityLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
         chiefsCityLabel.setBounds(740, 615, 148, 54);
         this.add(chiefsCityLabel);
    }
}
