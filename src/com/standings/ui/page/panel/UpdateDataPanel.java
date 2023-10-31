package com.standings.ui.page.panel;

import static com.standings.model.ParentFrame.ResizeIconStatic;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import com.standings.model.Game;
import com.standings.model.ParentFrame;
import com.standings.model.Team;
import com.standings.ui.page.SportsDashboardPage;
import com.standings.util.AddGameUtil;
import com.standings.util.StandingsCalculation;
import com.standings.util.StandingsDataUtil;

public class UpdateDataPanel extends JPanel  implements ActionListener {

	private static final long serialVersionUID = -3261993617585437616L;
	
	private final static String NEW_STANDINGS_TYPE = "New entry";
	private final static String EXISTING_STANDINGS_TYPE = "Exisitng entry";
	
    
    private final int SOME_OR_ALL_FIELDS_ARE_EMPTY = 1;
    private final int WRONG_TEAM_NAME = 2;
    private final int THE_SAME_NAME_FOR_TEAMS_IS_NOT_ALLOWED = 6;


    private final int ALL_POINTS_ARE_INVALID = 3;
    private final int LOCAL_POINTS_ARE_INVALID = 4;
    private final int VISITOR_POINTS_ARE_INVALID = 5;
    
    private final int GAME_IS_ALREADY_IN_STANDINGS = 10;
    
    private final int WEEK_NUMBER_IS_INCORRECT = 20;
    
    private final int WEEK_SELECTED_FOR_THIS_GAME_IS_WRONG = 30;
    
    private final int GAME_DOES_NOT_EXISTS = 40;
    
	
    //private JLabel localClubLabel;
    //private JLabel localClubPointsLabel;
    private JTextField localClubField;
    private JTextField localClubPointsField;
    
    //private JLabel visitorClubLabel;
   // private JLabel visitorClubPointsLabel; 
    private JTextField visitorClubField;
    private JTextField visitorClubPointsField;
    
  
    private JComboBox<String> weekComboBox;
    DefaultComboBoxModel<String> comboWeekModel;
    
    private JButton submitButton;
    private JButton updateButton;
   // private JButton cancelButton;
    
    private JLabel titleInstructionsLabel;
    private JPanel instructionPanel;
    private JLabel instructionsLabel;
    private ImageIcon nflIcon;
    private JLabel termsOfUse;

	private int validationNumber;
	private int selectedWeekNumber;
    


    
    private JLabel errorMessageForLocalPointsField;
    private JLabel errorMessageForVisitorPointsField;
    
	private List<Game> games;
	private ArrayList<Team> teams;
	private StandingsPanel standingsPanel;
	private ScoresPanel scoresPanel;

	
	/////////
	
	
	private JLabel firstLocalTeamName;
	private JLabel firstLocalTeamIcon;
	private JTextField firstLocalTeamPointField;
	private JLabel firstLocalTeamPointLabel;
	
	private JLabel firstVisitorTeamName;
	private JLabel firstVisitorTeamIcon;
	private JTextField firstVisitorTeamPointField;
	private JLabel firstVisitorTeamPointLabel;   
	
	private JLabel secondLocalTeamName;
	private JLabel secondLocalTeamIcon;
	private JTextField secondLocalTeamPointField;
	private JLabel secondLocalTeamPointLabel;
	
	private JLabel secondVisitorTeamName;
	private JLabel secondVisitorTeamIcon;
	private JTextField secondVisitorTeamPointField;
	private JLabel secondVisitorTeamPointLabel;
	
	private JLabel thirdLocalTeamName;
	private JLabel thirdLocalTeamIcon;
	private JTextField thirdLocalTeamPointField;
	private JLabel thirdLocalTeamPointLabel;
	
	private JLabel thirdVisitorTeamName;
	private JLabel thirdVisitorTeamIcon;
	private JTextField thirdVisitorTeamPointField;
	private JLabel thirdVisitorTeamPointLabel;
	
	
	private Map<String, String> teamLogos;
	
	
	
	private boolean hasFieldChanged;
	
	////////////////7

 
    public UpdateDataPanel( ArrayList<Team> teams, List<Game> games, StandingsPanel standingsPanel, ScoresPanel scoresPanel) {
 
    	this.games = games;
    	this.teams = teams;
    	this.standingsPanel = standingsPanel;
    	this.scoresPanel = scoresPanel;
    	this.teamLogos = new HashMap<>();   	
    	
    	
    	hasFieldChanged = false;
    	/////////////////
		////////////////
		
    	
		localClubPointsField = new JTextField();
		visitorClubPointsField = new JTextField();
    	
		localClubField = new JTextField();
		visitorClubField = new JTextField();
			
    	
    	firstLocalTeamName = new JLabel(); 	
        firstLocalTeamName.setFont(new Font("Tahoma", Font.PLAIN, 20));
        firstLocalTeamName.setBounds(1033, 200, 100, 37);
        this.add(firstLocalTeamName);
        
        firstLocalTeamIcon = new JLabel("");
        firstLocalTeamIcon.setBounds(840, 160, 100, 118);
        this.add(firstLocalTeamIcon);
        
        
        firstLocalTeamPointField = new JTextField();
        firstLocalTeamPointField.setFont(new Font("Tahoma", Font.PLAIN, 20));
        firstLocalTeamPointField.setBounds(1250, 203, 33, 27);
        this.add(firstLocalTeamPointField);
        firstLocalTeamPointField.setVisible(false);
        
        
        
        firstLocalTeamPointLabel = new JLabel();
        firstLocalTeamPointLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        firstLocalTeamPointLabel.setBounds(1250, 203, 33, 27);
        this.add(firstLocalTeamPointLabel);
        
        allowToModifyField(firstLocalTeamPointLabel, firstLocalTeamPointField);
        
        
        
        
        
        firstVisitorTeamName = new JLabel();
	    firstVisitorTeamName.setFont(new Font("Tahoma", Font.PLAIN, 20));
	    firstVisitorTeamName.setBounds(1033, 240, 100, 37);
	    this.add(firstVisitorTeamName);
	       
	    firstVisitorTeamIcon = new JLabel();
	    firstVisitorTeamIcon.setBounds(840, 200, 100, 118);
	    this.add(firstVisitorTeamIcon);     
	     
	    firstVisitorTeamPointField = new JTextField();
	    firstVisitorTeamPointField.setFont(new Font("Tahoma", Font.PLAIN, 20));
	    firstVisitorTeamPointField.setBounds(1250, 242, 33, 27);
	    this.add(firstVisitorTeamPointField);
	    firstVisitorTeamPointField.setVisible(false);
   		
	    
	    firstVisitorTeamPointLabel = new JLabel();
	    firstVisitorTeamPointLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
	    firstVisitorTeamPointLabel.setBounds(1250, 242, 33, 27);
	    this.add(firstVisitorTeamPointLabel);
	    
	    allowToModifyField(firstVisitorTeamPointLabel, firstVisitorTeamPointField);
	    
	    
	    secondLocalTeamName = new JLabel();
	    secondLocalTeamName.setFont(new Font("Tahoma", Font.PLAIN, 20));
	    secondLocalTeamName.setBounds(1033, 340, 100, 37);
	    this.add(secondLocalTeamName);
	       
	    secondLocalTeamIcon = new JLabel();
	    secondLocalTeamIcon.setBounds(840, 300, 100, 118);
	    this.add(secondLocalTeamIcon);
	      	       
	    secondLocalTeamPointField = new JTextField();
	    secondLocalTeamPointField.setFont(new Font("Tahoma", Font.PLAIN, 20));
	    secondLocalTeamPointField.setBounds(1250, 342, 33, 27);
	    this.add(secondLocalTeamPointField);
	    secondLocalTeamPointField.setVisible(false);
	    
	    
	    secondLocalTeamPointLabel = new JLabel(); 
	    secondLocalTeamPointLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
	    secondLocalTeamPointLabel.setBounds(1250, 342, 33, 27);
	    this.add(secondLocalTeamPointLabel);
	    
	    allowToModifyField(secondLocalTeamPointLabel, secondLocalTeamPointField);
	    
	    
	    
    
	    secondVisitorTeamName = new JLabel();
	    secondVisitorTeamName.setFont(new Font("Tahoma", Font.PLAIN, 20));
	    secondVisitorTeamName.setBounds(1033, 380, 100, 37);      
	    this.add(secondVisitorTeamName);
	       
  
	    secondVisitorTeamIcon = new JLabel();
	    secondVisitorTeamIcon.setBounds(840, 340, 100, 118);
	    this.add(secondVisitorTeamIcon);
	       
	       
	    secondVisitorTeamPointField = new JTextField();
	    secondVisitorTeamPointField.setFont(new Font("Tahoma", Font.PLAIN, 20));
	    secondVisitorTeamPointField.setBounds(1250, 382, 33, 27);
	    this.add(secondVisitorTeamPointField);
	    secondVisitorTeamPointField.setVisible(false);
	    
	    
	    secondVisitorTeamPointLabel = new JLabel(); 
	    secondVisitorTeamPointLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
	    secondVisitorTeamPointLabel.setBounds(1250, 382, 33, 27);
	    this.add(secondVisitorTeamPointLabel);
	    
	    allowToModifyField(secondVisitorTeamPointLabel, secondVisitorTeamPointField);
	    
	    
	       
	    thirdLocalTeamName = new JLabel();
	    thirdLocalTeamName.setFont(new Font("Tahoma", Font.PLAIN, 20));
	    thirdLocalTeamName.setBounds(1033, 480, 100, 37);
	    this.add(thirdLocalTeamName);
	       
	    thirdLocalTeamIcon = new JLabel();
	    thirdLocalTeamIcon.setBounds(840, 440, 100, 118);
	    this.add(thirdLocalTeamIcon);
	       
	    thirdLocalTeamPointField = new JTextField();
	    thirdLocalTeamPointField.setFont(new Font("Tahoma", Font.PLAIN, 20));
	    thirdLocalTeamPointField.setBounds(1250, 482, 33, 27);
	    this.add(thirdLocalTeamPointField);
	    thirdLocalTeamPointField.setVisible(false);   

	    
	    thirdLocalTeamPointLabel = new JLabel(); 
	    thirdLocalTeamPointLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
	    thirdLocalTeamPointLabel.setBounds(1250, 482, 33, 27);
	    this.add(thirdLocalTeamPointLabel);
	    
	    allowToModifyField(thirdLocalTeamPointLabel, thirdLocalTeamPointField);
	    
	    
	    
	    thirdVisitorTeamName = new JLabel();
	    thirdVisitorTeamName.setFont(new Font("Tahoma", Font.PLAIN, 20));
	    thirdVisitorTeamName.setBounds(1033, 520, 100, 37);
	    this.add(thirdVisitorTeamName);
	       
	       
	    thirdVisitorTeamIcon = new JLabel();
	    thirdVisitorTeamIcon.setBounds(840, 480, 100, 118);
	    this.add(thirdVisitorTeamIcon);
	       
	    thirdVisitorTeamPointField = new JTextField();
	    thirdVisitorTeamPointField.setFont(new Font("Tahoma", Font.PLAIN, 20));
	    thirdVisitorTeamPointField.setBounds(1250, 522, 33, 27);
	    this.add(thirdVisitorTeamPointField);
	    thirdVisitorTeamPointField.setVisible(false);   

	    
	    thirdVisitorTeamPointLabel = new JLabel(); 
	    thirdVisitorTeamPointLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
	    thirdVisitorTeamPointLabel.setBounds(1250, 522, 33, 27);
	    this.add(thirdVisitorTeamPointLabel);
	    
	    allowToModifyField(thirdVisitorTeamPointLabel, thirdVisitorTeamPointField);
	    
	       
	       
	       initializeTeamLogos();
	       
	       createWeekComboBox();
	       
	       
   		////////////////

	       
	       
	       
	       //////////////////
    	
    	
       // localClubLabel = new JLabel("Equipo Local");
        //localClubLabel.setBounds(829, 215, 103, 37);
        //this.add(localClubLabel);
    
        
       // localClubField = new JTextField();
       // localClubField.setBounds(791, 262, 155, 37);
        //this.add(localClubField);
       // localClubField.setColumns(10);
             
        //visitorClubLabel = new JLabel("Equipo Visitante");
       // visitorClubLabel.setBounds(829, 355, 117, 25);
        //this.add(visitorClubLabel);
        
        //visitorClubField = new JTextField();
       // visitorClubField.setColumns(10);
       // visitorClubField.setBounds(791, 390, 155, 37);
        //this.add(visitorClubField);
        
        
       // localClubPointsLabel = new JLabel("Puntos");
        //localClubPointsLabel.setBounds(1250, 215, 71, 37);
        //this.add(localClubPointsLabel);
        
        
        //visitorClubPointsLabel = new JLabel("Puntos");
       // visitorClubPointsLabel.setBounds(1250, 352, 84, 31);
        //this.add(visitorClubPointsLabel);
        
        
       // localClubPointsField = new JTextField();
        //localClubPointsField.setBounds(1250, 264, 35, 34);
        //this.add(localClubPointsField);
        //localClubPointsField.setColumns(10);
        
        //visitorClubPointsField = new JTextField();
        //visitorClubPointsField.setColumns(10);
        //visitorClubPointsField.setBounds(1250, 392, 35, 34);
        //this.add(visitorClubPointsField);
        
        submitButton = new JButton("Guardar");
        submitButton.setBounds(930, 620, 130, 45);
        submitButton.setFocusable(false);
        submitButton.setBackground(Color.lightGray);
        submitButton.addActionListener(this);
        this.add(submitButton);
        
        updateButton = new JButton("Actualizar");
        updateButton.setBounds(1130, 620, 130, 45);
        updateButton.setFocusable(false);
        updateButton.setBackground(Color.lightGray);
        updateButton.addActionListener(this);
        this.add(updateButton);
        
       // cancelButton = new JButton("Cancelar");
       // cancelButton.setBounds(1222, 620, 130, 45);
        //cancelButton.setFocusable(false);
        //cancelButton.setBackground(Color.lightGray);
        //cancelButton.addActionListener(this);
        //this.add(cancelButton);
        
        
        instructionPanel = new JPanel();
        instructionPanel.setBackground(new Color(255, 255, 255));
        instructionPanel.setBounds(0, 60, 627, 756);
        this.add(instructionPanel);
        instructionPanel.setLayout(null);
        
        
        
        
        
        titleInstructionsLabel = new JLabel("Instrucciones para insertar/actualizar los datos");
        titleInstructionsLabel.setIcon(new ImageIcon(SportsDashboardPage.class.getResource("/images/instructionBlue.png")));
        titleInstructionsLabel.setForeground(new Color(0, 0, 0));
        titleInstructionsLabel.setBounds(49, 10, 536, 105);
        instructionPanel.add(titleInstructionsLabel);
        titleInstructionsLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        titleInstructionsLabel.setHorizontalAlignment(SwingConstants.CENTER);
        
        
        instructionsLabel = new JLabel(
                "<html>" +
                "<body style='width: 500px;'>" +
                "<ul>" +
                "<li>Selecciona la semana del partido desde 'Semana 1' hasta 'Semana 10' en el desplegable.</li> <br>" +
                "<li>Ingrese los nombres de los clubes locales y visitantes junto con sus puntos.</li> <br>" +
                "<li> Haga click en 'Guardar' para guardar los resultados del partido o 'Actualizar' para <br> actualizar los datos</li> <br>"+
                "<li>'Cancelar' para descartar los cambios</li> <br> " +                   
                "<li>Recuerde guardar su entrada. Gracias por ayudar a mantener los resultados de los partidos</li>" +     
                "</ul>" +
                "</body>" +
                "</html>"
            );
        
     

      
        instructionsLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        instructionsLabel.setBackground(this.getBackground());

      
        instructionPanel.add(instructionsLabel);

       
        instructionsLabel.setBounds(21, 179, 596, 227);
        
        nflIcon = new ImageIcon(ParentFrame.ResizeIconStatic("/images/nflWhite.png",280,200));
        JLabel nflIconLabel = new JLabel("");
		nflIconLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nflIconLabel.setIcon(nflIcon);
		nflIconLabel.setBounds(233, 476, 110, 144);
		instructionPanel.add(nflIconLabel);
        
        
		termsOfUse = new JLabel("<html><p style='text-indent: 10px; white-space: nowrap;'><a href=\"https://nao-f-lll.github.io/paginas/terminos.html\">Términos de uso</a></p></html>");
		termsOfUse.setBounds(235, 630, 250, 40);
		termsOfUse.setFont(new Font("Dialog", Font.PLAIN, 13));
		instructionPanel.add(termsOfUse);

		
		termsOfUse.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (Desktop.isDesktopSupported()) {
                    try {
                        Desktop.getDesktop().browse(new URI("https://nao-f-lll.github.io/paginas/terminos.html"));
                    } catch (IOException | URISyntaxException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
								
		errorMessageForLocalPointsField = new JLabel();
		errorMessageForLocalPointsField.setText("");
		errorMessageForLocalPointsField.setBounds(1310, 265, 130, 25);
		errorMessageForLocalPointsField.setForeground(Color.RED);
		this.add(errorMessageForLocalPointsField);
		
		
		errorMessageForVisitorPointsField = new JLabel();
		errorMessageForVisitorPointsField.setText("");
		errorMessageForVisitorPointsField.setBounds(1310, 390, 130, 40);  
		errorMessageForVisitorPointsField.setForeground(Color.RED);
		this.add(errorMessageForVisitorPointsField);
		
    }
       
    
    @Override
	public void actionPerformed(ActionEvent e) {
		userClickLoginLogic(e);
	}
    
	private void userClickLoginLogic(ActionEvent e) {
		
		/*
		if (hasFieldChanged(firstLocalTeamPointField) || hasFieldChanged(firstVisitorTeamPointField)) {
			
			localClubPointsField = new JTextField();
			visitorClubPointsField = new JTextField();
			
			localClubPointsField = firstLocalTeamPointField;
			visitorClubPointsField = firstVisitorTeamPointField;
			

			
			localClubField.setText("Cardinals");
			visitorClubField.setText("Cowboys");
			
			
			
			System.out.println("one");
			*/
		/*} else if (hasFieldChanged(secondLocalTeamPointField) || hasFieldChanged(secondVisitorTeamPointField)) {
			
			localClubPointsField = new JTextField();
			visitorClubPointsField = new JTextField();
			
			localClubPointsField = secondLocalTeamPointField;
			visitorClubPointsField = secondVisitorTeamPointField;
			

			
			localClubField.setText("Raiders");
			visitorClubField.setText("Bengals");
			
			System.out.println("two");
			
		} else if (hasFieldChanged(thirdLocalTeamPointField) || hasFieldChanged(thirdVisitorTeamPointField)) {
			
			localClubPointsField = new JTextField();
			visitorClubPointsField = new JTextField();
			
			localClubPointsField = thirdLocalTeamPointField;
			visitorClubPointsField = thirdVisitorTeamPointField;
		
			
			localClubField.setText("Steelers");
			visitorClubField.setText("Chiefs");
			
			System.out.println("three");
		}
		
		*/
		
		if (e.getSource() == submitButton) {
			
			
			localClubPointsField = new JTextField();
			visitorClubPointsField = new JTextField();
			
			localClubPointsField = firstLocalTeamPointField;
			visitorClubPointsField = firstVisitorTeamPointField;
			

			
			localClubField.setText("Cardinals");
			visitorClubField.setText("Cowboys");
			
			
			
			
			
			validationNumber = StandingsDataUtil.validateStandingsDataForPoints(localClubPointsField.getText(),visitorClubPointsField.getText());

			
			//if (StandingsDataUtil.validateStandingsDataForEmpties(localClubField.getText(), visitorClubField.getText(), localClubPointsField.getText(),visitorClubPointsField.getText())) {
				//handleValidationNumber(SOME_OR_ALL_FIELDS_ARE_EMPTY);
			
			//} else if (StandingsDataUtil.validateStandingsDataForWrongTeamName(localClubField.getText(), visitorClubField.getText())) {
				//handleValidationNumber(WRONG_TEAM_NAME); 
			//} else if (StandingsDataUtil.validateStandingsDataForSameTeamNAme(localClubField.getText(), visitorClubField.getText())) {
				//handleValidationNumber(THE_SAME_NAME_FOR_TEAMS_IS_NOT_ALLOWED); 
			
			
			
			if(validationNumber == ALL_POINTS_ARE_INVALID || validationNumber == LOCAL_POINTS_ARE_INVALID || validationNumber == VISITOR_POINTS_ARE_INVALID) {
				handleValidationNumber(validationNumber); 
			} else {
			
				
				
				boolean isgameExist = false;
				
				for (int i = 0; i < games.size(); i++) {

					isgameExist = (games.get(i).getLocalTeam().equals(localClubField.getText())) && (games.get(i).getVisitorTeam().equals(visitorClubField.getText()));
					
					if (isgameExist) {
						handleValidationNumber(GAME_IS_ALREADY_IN_STANDINGS); 
						break;
					}
				}
			
				
				if (whichWeekIsSelected() == 10) {

				if (!isgameExist) {

					
					new AddGameUtil(this.games,localClubField.getText(),visitorClubField.getText(),localClubPointsField.getText(),visitorClubPointsField.getText(), whichWeekIsSelected());		
					
					for (Team team : this.teams) {
						if (team.getName().equals(localClubField.getText()) || team.getName().equals(visitorClubField.getText())) {
							int sizeOfListOfGames = games.size() - 1;
							StandingsCalculation.updateStandings(team, games.get(sizeOfListOfGames), NEW_STANDINGS_TYPE);  
						
						}
				}
					
				
						StandingsCalculation.sortStandings(this.teams);
						standingsPanel.renderUpdatedStandings();
						scoresPanel.renderWeeksScores(whichWeekIsSelected());
						resetFieldsAndWeek();
						userDialogFedback("Su partido se ha registrado correctamente", "Insertar entrada");
				}
					
				} else if (whichWeekIsSelected() != 10){
					handleValidationNumber(WEEK_SELECTED_FOR_THIS_GAME_IS_WRONG); 
				}
				
			}

			
		} else if (e.getSource() == updateButton) {
			
			validationNumber = StandingsDataUtil.validateStandingsDataForPoints(localClubPointsField.getText(),visitorClubPointsField.getText());

			
			if (StandingsDataUtil.validateStandingsDataForEmpties(localClubField.getText(), visitorClubField.getText(), localClubPointsField.getText(),visitorClubPointsField.getText())) {
				handleValidationNumber(SOME_OR_ALL_FIELDS_ARE_EMPTY);
			} else if (StandingsDataUtil.validateStandingsDataForWrongTeamName(localClubField.getText(), visitorClubField.getText())) {
				handleValidationNumber(WRONG_TEAM_NAME); 
			} else if (StandingsDataUtil.validateStandingsDataForSameTeamNAme(localClubField.getText(), visitorClubField.getText())) {
				handleValidationNumber(THE_SAME_NAME_FOR_TEAMS_IS_NOT_ALLOWED); 
			} else if (validationNumber == ALL_POINTS_ARE_INVALID || validationNumber == LOCAL_POINTS_ARE_INVALID || validationNumber == VISITOR_POINTS_ARE_INVALID)  {
				handleValidationNumber(validationNumber); 
			} else {
				
				boolean updateStandings = false;
				boolean doesGameNotExist = true;
				
				 
				 
				for (int i = 0; i < games.size(); i++) {
					
		
					
					
					if (games.get(i).getLocalTeam().equals(localClubField.getText()) && games.get(i).getVisitorTeam().equals(visitorClubField.getText())) {
						
						if (games.get(i).getWeekNumber() == whichWeekIsSelected()) {
						
						
							games.get(i).setOldLocalScore(games.get(i).getLocalScore());
							games.get(i).setOldVisitorScore(games.get(i).getVisitorScore());
						
							games.get(i).setLocalScore(Integer.parseInt(localClubPointsField.getText()));
							games.get(i).setVisitorScore(Integer.parseInt(visitorClubPointsField.getText()));
						
							for (Team team : this.teams) {
								if (team.getName().equals(localClubField.getText()) || team.getName().equals(visitorClubField.getText())) {
									StandingsCalculation.updateStandings(team, games.get(i), EXISTING_STANDINGS_TYPE);  
								
								}
							}
							updateStandings = true;
							
						} else {
							handleValidationNumber(WEEK_NUMBER_IS_INCORRECT);
							doesGameNotExist = false;
						}
						
					}
				}
				

			    

					if (doesGameNotExist && !updateStandings) {	
						handleValidationNumber(GAME_DOES_NOT_EXISTS);
					}		
				

				
				
				if (updateStandings) {
				StandingsCalculation.sortStandings(this.teams);
				standingsPanel.renderUpdatedStandings();
				scoresPanel.renderWeeksScores(whichWeekIsSelected());	
				resetFieldsAndWeek();
				userDialogFedback("Su partido se ha actualizado correctamente", "Actualizar de entrada");
				}
				
			}
	
			
		}// else if (e.getSource() == cancelButton) {
			
		//	resetFieldsAndWeek();
		//}
	}
	

	
	
	public void createWeekComboBox() {
	    comboWeekModel = new DefaultComboBoxModel<>();
	    for (int i = 1; i < 11; i++) {
	        comboWeekModel.addElement("Jornada " + i);
	    }
	    
	    selectedWeekNumber = 1;
	   

	    weekComboBox = new JComboBox<>(comboWeekModel);
	    weekComboBox.setBackground(Color.LIGHT_GRAY);
	    weekComboBox.setBounds(1033, 90, 114, 45);
	    this.add(weekComboBox);
	    showGameInfo(0, 1, 2);

    	
	    weekComboBox.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            String selectedWeek = (String) weekComboBox.getSelectedItem();
	            String[] parts = selectedWeek.split(" ");
	            if (parts.length == 2) {
	                try {
	                    int weekNumber = Integer.parseInt(parts[1]);
	                    selectedWeekNumber = weekNumber;
	                    changeGames();
	                } catch (NumberFormatException ex) {
	                    System.err.println("Error parsing week number");
	                }
	            }
	        }
	    });
	}
	
	
	
	private void changeGames() {
		
		switch (selectedWeekNumber) {
		case 1:
			showGameInfo(0, 1, 2);
			break;
		case 2:
			showGameInfo(3, 4, 5);
			break;
		case 3:
			showGameInfo(6, 7, 8);
			break;
		case 4:
			showGameInfo(9, 10, 11);
			break;
		case 5:
			showGameInfo(12, 13, 14);
			break;
		case 6:
			showGameInfo(15, 16, 17);
			break;
		case 7:
			showGameInfo(18, 19, 20);
			break;
		case 8:
			showGameInfo(21, 22, 23);
			break;
		case 9:
			showGameInfo(24, 25, 26);
			break;
		case 10:
			showLastGameInfo();
			break;
		default :
					
		}
	}
	
	
	
	public void showGameInfo(int gameOne, int gameTwo, int gameThree) {
        
		
			firstLocalTeamName.setText(games.get(gameOne).getLocalTeam());
			setTeamIcon(firstLocalTeamIcon, games.get(gameOne).getLocalTeam());
			firstLocalTeamPointField.setText(String.valueOf(games.get(gameOne).getLocalScore()));
			firstLocalTeamPointField.setVisible(false);
			firstLocalTeamPointLabel.setText(String.valueOf(games.get(gameOne).getLocalScore()));
			firstLocalTeamPointLabel.setVisible(true);
			
			firstVisitorTeamName.setText(games.get(gameOne).getVisitorTeam());
			setTeamIcon(firstVisitorTeamIcon, games.get(gameOne).getVisitorTeam());
			firstVisitorTeamPointField.setText(String.valueOf(games.get(gameOne).getVisitorScore()));
			firstVisitorTeamPointField.setVisible(false);
			firstVisitorTeamPointLabel.setText(String.valueOf(games.get(gameOne).getVisitorScore()));
			firstVisitorTeamPointLabel.setVisible(true);
       
			secondLocalTeamName.setText(games.get(gameTwo).getLocalTeam());
			setTeamIcon(secondLocalTeamIcon, games.get(gameTwo).getLocalTeam());
			secondLocalTeamPointField.setText(String.valueOf(games.get(gameTwo).getLocalScore()));
			secondLocalTeamPointField.setVisible(false);
			secondLocalTeamPointLabel.setText(String.valueOf(games.get(gameTwo).getLocalScore()));
			secondLocalTeamPointLabel.setVisible(true);
			
			secondVisitorTeamName.setText(games.get(gameTwo).getVisitorTeam());
			setTeamIcon(secondVisitorTeamIcon, games.get(gameTwo).getVisitorTeam());
			secondVisitorTeamPointField.setText(String.valueOf(games.get(gameTwo).getVisitorScore()));
			secondVisitorTeamPointField.setVisible(false);
			secondVisitorTeamPointLabel.setText(String.valueOf(games.get(gameTwo).getVisitorScore()));
			secondVisitorTeamPointLabel.setVisible(true);
    	  
			thirdLocalTeamName.setText(games.get(gameThree).getLocalTeam());
			setTeamIcon(thirdLocalTeamIcon, games.get(gameThree).getLocalTeam());
			thirdLocalTeamPointField.setText(String.valueOf(games.get(gameThree).getLocalScore()));
			thirdLocalTeamPointField.setVisible(false);
			thirdLocalTeamPointLabel.setText(String.valueOf(games.get(gameThree).getLocalScore()));
			thirdLocalTeamPointLabel.setVisible(true);
    	  
			thirdVisitorTeamName.setText(games.get(gameThree).getVisitorTeam());
			setTeamIcon(thirdVisitorTeamIcon, games.get(gameThree).getVisitorTeam());
			thirdVisitorTeamPointField.setText(String.valueOf(games.get(gameThree).getVisitorScore()));
			thirdVisitorTeamPointField.setVisible(false);
			thirdVisitorTeamPointLabel.setText(String.valueOf(games.get(gameThree).getVisitorScore()));
			thirdVisitorTeamPointLabel.setVisible(true);
    }


	private  void setTeamIcon(JLabel label, String teamName) {
		if (teamLogos.containsKey(teamName)) {
    		String iconPath = teamLogos.get(teamName);
        	label.setIcon(new ImageIcon(ResizeIconStatic(iconPath, 45, 30)));
    	} else {
    		label.setIcon(null);
    	}
	}

	private void initializeTeamLogos() {
		teamLogos.put("Cowboys", "/images/cowboys.png");
		teamLogos.put("Cardinals", "/images/cardinals.png");
		teamLogos.put("Chiefs", "/images/chiefs.png");
		teamLogos.put("Bengals", "/images/bengals.png");
		teamLogos.put("Raiders", "/images/raiders.png");
		teamLogos.put("Steelers", "/images/steelers.png");
	}

	
	private int whichWeekIsSelected() {
		 return selectedWeekNumber;
	}

	
	
	
	private void showLastGameInfo() {
		
		int totalnumberOfGames = games.size();
		int gameOne = 27;
		int gameTwo = 28;
		int gameThree = 29;

		
		
		
		
      	firstLocalTeamName.setText("Cardinals");
        firstLocalTeamIcon.setIcon(new ImageIcon(ResizeIconStatic("/images/cardinals.png", 45, 30)));      
        firstLocalTeamPointField.setVisible(false);     
        firstLocalTeamPointLabel.setVisible(true);
        
  
        firstVisitorTeamName.setText("Cowboys");
	    firstVisitorTeamIcon.setIcon(new ImageIcon(ResizeIconStatic("/images/cowboys.png", 45, 30)));	    
	    firstVisitorTeamPointField.setVisible(false);   
	    firstVisitorTeamPointLabel.setVisible(true);
	    
	    
	    secondLocalTeamName.setText("Raiders");
	    secondLocalTeamIcon.setIcon(new ImageIcon(ResizeIconStatic("/images/raiders.png", 45, 30)));	    
	    secondLocalTeamPointField.setVisible(false);    
	    secondLocalTeamPointLabel.setVisible(true);
	    
	    secondVisitorTeamName.setText("Bengals");
		secondVisitorTeamIcon.setIcon(new ImageIcon(ResizeIconStatic("/images/bengals.png", 45, 30)));    
	    secondVisitorTeamPointField.setVisible(false);    
	    secondVisitorTeamPointLabel.setVisible(true);
		
	    
	    thirdLocalTeamName.setText("Steelers");
	    thirdLocalTeamIcon.setIcon(new ImageIcon(ResizeIconStatic("/images/steelers.png", 45, 30)));    
	    thirdLocalTeamPointField.setVisible(false);	   
	    thirdLocalTeamPointLabel.setVisible(true);
	    
	    
	       
	    thirdVisitorTeamName.setText("Chiefs");
	    thirdVisitorTeamIcon.setIcon(new ImageIcon(ResizeIconStatic("/images/chiefs.png", 45, 30)));    
	    thirdVisitorTeamPointField.setVisible(false);
	    thirdVisitorTeamPointLabel.setVisible(true);
	    
		
        if (totalnumberOfGames == 30) {

        	firstLocalTeamPointLabel.setText(String.valueOf(games.get(gameOne).getLocalScore()));
        	firstLocalTeamPointField.setText(String.valueOf(games.get(gameOne).getLocalScore()));
        	
        	
        	firstVisitorTeamPointField.setText(String.valueOf(games.get(gameOne).getVisitorScore()));
        	firstVisitorTeamPointLabel.setText(String.valueOf(games.get(gameOne).getVisitorScore()));
        	
        	
        	
        	secondLocalTeamPointField.setText(String.valueOf(games.get(gameTwo).getLocalScore()));
        	secondLocalTeamPointLabel.setText(String.valueOf(games.get(gameTwo).getLocalScore()));
        	
        	secondVisitorTeamPointField.setText(String.valueOf(games.get(gameTwo).getVisitorScore()));
        	secondVisitorTeamPointLabel.setText(String.valueOf(games.get(gameTwo).getVisitorScore()));
        	
        	
        	thirdLocalTeamPointField.setText(String.valueOf(games.get(gameThree).getLocalScore()));
        	thirdLocalTeamPointLabel.setText(String.valueOf(games.get(gameThree).getLocalScore()));
        	
        	
        	thirdVisitorTeamPointField.setText(String.valueOf(games.get(gameThree).getVisitorScore()));
        	thirdVisitorTeamPointLabel.setText(String.valueOf(games.get(gameThree).getVisitorScore()));
        	
        	
			 
		 } else if (totalnumberOfGames == 29) {
	
	        	firstLocalTeamPointLabel.setText(String.valueOf(games.get(gameOne).getLocalScore()));
	        	firstLocalTeamPointField.setText(String.valueOf(games.get(gameOne).getLocalScore()));
	        	
	        	
	        	firstVisitorTeamPointField.setText(String.valueOf(games.get(gameOne).getVisitorScore()));
	        	firstVisitorTeamPointLabel.setText(String.valueOf(games.get(gameOne).getVisitorScore()));
	        	
	        	
	        	
	        	secondLocalTeamPointField.setText(String.valueOf(games.get(gameTwo).getLocalScore()));
	        	secondLocalTeamPointLabel.setText(String.valueOf(games.get(gameTwo).getLocalScore()));
	        	
	        	secondVisitorTeamPointField.setText(String.valueOf(games.get(gameTwo).getVisitorScore()));
	        	secondVisitorTeamPointLabel.setText(String.valueOf(games.get(gameTwo).getVisitorScore()));
	        	
	        	
	        	thirdLocalTeamPointField.setText("0");
	        	thirdLocalTeamPointLabel.setText("0");
	        	
	        	
	        	thirdVisitorTeamPointField.setText("0");
	        	thirdVisitorTeamPointLabel.setText("0");
			 
			
		 } else if (totalnumberOfGames == 28){
			 
	        	firstLocalTeamPointLabel.setText(String.valueOf(games.get(gameOne).getLocalScore()));
	        	firstLocalTeamPointField.setText(String.valueOf(games.get(gameOne).getLocalScore()));
	        	
	        	
	        	firstVisitorTeamPointField.setText(String.valueOf(games.get(gameOne).getVisitorScore()));
	        	firstVisitorTeamPointLabel.setText(String.valueOf(games.get(gameOne).getVisitorScore()));
	        	
	        	
	        	
	        	secondLocalTeamPointField.setText("0");
	        	secondLocalTeamPointLabel.setText("0");
	        	
	        	secondVisitorTeamPointField.setText("0");
	        	secondVisitorTeamPointLabel.setText("0");
	        	
	        	
	        	thirdLocalTeamPointField.setText("0");
	        	thirdLocalTeamPointLabel.setText("0");
	        	
	        	
	        	thirdVisitorTeamPointField.setText("0");
	        	thirdVisitorTeamPointLabel.setText("0");
			 

			 
		 } else {
        
        

        
        firstLocalTeamPointField.setText("0");
        firstLocalTeamPointLabel.setText("0");
        
        
	      
	    firstVisitorTeamPointField.setText("0");
	    firstVisitorTeamPointLabel.setText("0");
	    
	    
	    secondLocalTeamPointField.setText("0");
	    secondLocalTeamPointLabel.setText("0");
	  
	    
	    
	    secondVisitorTeamPointField.setText("0");
	    secondVisitorTeamPointLabel.setText("0");
	    
	    
	    thirdLocalTeamPointField.setText("0");
	    thirdLocalTeamPointLabel.setText("0");
	    
	    thirdVisitorTeamPointField.setText("0");
	    thirdVisitorTeamPointLabel.setText("0");
	    
	    

		 }
	    
	    
	}

	/*
	private boolean hasFieldChanged(JTextField field) {
		
		
	
        field.getDocument().addDocumentListener(new DocumentListener() {
        	
        
      	  public void changedUpdate(DocumentEvent e) {
      		hasFieldChanged = true;
      	  }
      	  public void removeUpdate(DocumentEvent e) {
      		hasFieldChanged = false;
      	  }
      	  public void insertUpdate(DocumentEvent e) {
      		hasFieldChanged = false;
      	  }
      	  
        });
        
        return hasFieldChanged;
	}
	
	
	*/
	
	
	
	private void allowToModifyField(JLabel label, JTextField field) {
		
		label.addMouseListener(new MouseAdapter() {
	        @Override
	        public void mouseClicked(MouseEvent e) {
	        	label.setVisible(false);
	        	field.setVisible(true);
	        	field.requestFocus();
	        }
	    });
		
		
		
		this.addMouseListener(new MouseAdapter() {
			
			  @Override
		        public void mouseClicked(MouseEvent e) {
			    	label.setText(field.getText());
			    	field.setVisible(false);
			    	label.setVisible(true);
		        }
		    });
			
		}
	
	
	public void handleValidationNumber(int validationNumber) {
		
		switch (validationNumber) {
		case SOME_OR_ALL_FIELDS_ARE_EMPTY:
			userDialog("Algunos campos están vacíos, le faltan campos por rellenar", "Requisitos de campos");        
			break;
		case WRONG_TEAM_NAME:
			userDialog("Has insertado un nombre de equipo incorrecto, ver el panel de Equipos para referencia", " Nombre de equipo incorrecto");
			break;		
		case THE_SAME_NAME_FOR_TEAMS_IS_NOT_ALLOWED:
			userDialog("Has insertado el mismo nombre para los dos equipos, ver el panel de Equipos para referencia", " Los dos equipos tienen el mismo nombre");
			break;
		case ALL_POINTS_ARE_INVALID:
			userDialog("Puntos incorrectos, los puntos deben ser dentro de este rango (0 a 99)","Requisitos de campos");
			
			break;
		case LOCAL_POINTS_ARE_INVALID:	

			userDialog("Puntos incorrectos, los puntos deben ser dentro de este rango (0 a 99)","Requisitos de campos");
			break;
		case VISITOR_POINTS_ARE_INVALID:

			userDialog("Puntos incorrectos, los puntos deben ser dentro de este rango (0 a 99)","Requisitos de campos");
			break;
			
		case GAME_IS_ALREADY_IN_STANDINGS:
			userDialog("Este partido ya existe, asegurate que has introducido un nuevo partido","Requisitos de campos");
			break;
		case WEEK_NUMBER_IS_INCORRECT:
			userDialog("La semana del partido que quieres modifcar es incorrecta", "Requisitos de campos");
			break;
		case WEEK_SELECTED_FOR_THIS_GAME_IS_WRONG:
			userDialog("La semana del partido que quieres añadir es incorrecta", "Requisitos de campos");
			break;
		case GAME_DOES_NOT_EXISTS:
			userDialog("El partido que quieres modificar no existe", "Requisitos de campos");
			break;
		default :
		}
	}	
	
	
	private void userDialog(String dialogText, String dialogTitle ) {
		
		 JOptionPane fieldRequirementPane = new JOptionPane(dialogText,JOptionPane.YES_OPTION);

		 fieldRequirementPane.setMessageType(JOptionPane.WARNING_MESSAGE);

	        JPanel buttonPanel = (JPanel)fieldRequirementPane.getComponent(1);
	        
	        JButton accepetButton = (JButton)buttonPanel.getComponent(0);
	        accepetButton.setText("Aceptar");
	        accepetButton.setFocusable(false);
	        accepetButton.setBackground(Color.LIGHT_GRAY);
	        
	        JDialog passwordRequirementdialog = fieldRequirementPane.createDialog(this, dialogTitle);
	        passwordRequirementdialog.setVisible(true);
	}
	
	private void userDialogFedback(String dialogText, String dialogTitle ) {
		
		 JOptionPane fieldRequirementPane = new JOptionPane(dialogText,JOptionPane.YES_OPTION);

		 fieldRequirementPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);

	        JPanel buttonPanel = (JPanel)fieldRequirementPane.getComponent(1);
	        
	        JButton accepetButton = (JButton)buttonPanel.getComponent(0);
	        accepetButton.setText("Aceptar");
	        accepetButton.setFocusable(false);
	        accepetButton.setBackground(Color.LIGHT_GRAY);
	        
	        JDialog passwordRequirementdialog = fieldRequirementPane.createDialog(this, dialogTitle);
	        passwordRequirementdialog.setVisible(true);
	}
	
	private void resetFieldsAndWeek() {
		
		localClubField.setText("");
		visitorClubField.setText("");
		localClubPointsField.setText("");
		visitorClubPointsField.setText("");
		selectedWeekNumber = 1;
		showGameInfo(0, 1, 2);
		
		comboWeekModel = new DefaultComboBoxModel<>();
        for (int i = 1; i < 11; i++) {
            comboWeekModel.addElement("Jornada " + i);
        }
        weekComboBox.setModel(comboWeekModel);
	}
	
	

}
