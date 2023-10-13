package panel;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import model.ParentFrame;

public class TeamsPanel extends JPanel  {
	
	
    private static final long serialVersionUID = -538081400942327500L;
	private JLabel stadiumLabel;
    private JLabel establishedLabel;
    private JLabel cityLabel;
    
    
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
    
    
    private JLabel chiefsIconLabel;
    private ImageIcon chiefsIcon;
    
    
    private JLabel bengalsIconLabel;
    private ImageIcon bengalsIcon;
    
    
    public TeamsPanel() {
    	
    	   ParentFrame parentFrame = new ParentFrame();
    	
    	   cowboysIcon = new ImageIcon(parentFrame.ResizeIcon("/images/cowboys.png",120,80));
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
           cowboysStadiumLabel.setBounds(305, 234, 148, 54);
           this.add(cowboysStadiumLabel);
           
           cowboysFundiationLabel = new JLabel("1960");
           cowboysFundiationLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
           cowboysFundiationLabel.setBounds(305, 282, 148, 54);
           this.add(cowboysFundiationLabel);
           
           cowboysCityLabel = new JLabel("Texas");
           cowboysCityLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
           cowboysCityLabel.setBounds(305, 323, 148, 54);
           this.add(cowboysCityLabel);
         
           stadiumLabel = new JLabel("Stadium");
           stadiumLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
           stadiumLabel.setBounds(23, 234, 148, 54);
           this.add(stadiumLabel);
           
           establishedLabel = new JLabel("Established ");
           establishedLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
           establishedLabel.setBounds(23, 282, 148, 54);
           this.add(establishedLabel);
           
           cityLabel = new JLabel("City");
           cityLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
           cityLabel.setBounds(23, 323, 148, 54);
           this.add(cityLabel);
           
           
           
           cardinalsIcon = new ImageIcon(parentFrame.ResizeIcon("/images/cardinals.png",120,80));
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
           
           
           steelersIcon = new ImageIcon(parentFrame.ResizeIcon("/images/steelers.png",120,80));
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
           
           
           parentFrame.dispose();
           
    	
    }
}
