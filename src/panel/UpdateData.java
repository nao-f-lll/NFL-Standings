package panel;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class UpdateData extends JPanel {

	private static final long serialVersionUID = -3261993617585437616L;
	
    private JLabel localClubLabel;
    private JLabel localClubPointsLabel;
    private JTextField localClubField;
    private JTextField localClubPointsField;
    
    private JLabel visitorClubLabel;
    private JLabel visitorClubPointsLabel; 
    private JTextField visitorClubField;
    private JTextField visitorClubPointsField;
    
    private JLabel weekLabel;
    private JList<String> weekList;
    
    
    private JButton submitButton;
    private JButton updateButton;
    private JButton cancelButton;

}
