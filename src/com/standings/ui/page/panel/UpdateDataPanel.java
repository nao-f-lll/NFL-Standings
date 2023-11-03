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
import com.standings.model.CustomCheckBox;
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
    private final int NO_CHECK_BOX_IS_SELECTED_ADD_CASE = 2;
    private final int MULTIPLE_CHEC_BOXES_ARE_SELECTED_ADD_CASE = 6;
    private final int NO_CHECK_BOX_IS_SELECTED_UPDATE_CASE = 7;
    private final int MULTIPLE_CHEC_BOXES_ARE_SELECTED_UPDATE_CASE = 8;

    private final int ALL_POINTS_ARE_INVALID = 3;
    private final int LOCAL_POINTS_ARE_INVALID = 4;
    private final int VISITOR_POINTS_ARE_INVALID = 5;
    
    private final int GAME_IS_ALREADY_IN_STANDINGS = 10;
    
    private final int WEEK_NUMBER_IS_INCORRECT = 20;
    
    private final int GAME_DOES_NOT_EXISTS = 40;
    
	
    private JTextField localClubField;
    private JTextField localClubPointsField;
    

    private JTextField visitorClubField;
    private JTextField visitorClubPointsField;
    
  
    private JComboBox<String> weekComboBox;
    private DefaultComboBoxModel<String> comboWeekModel;
    
    private JButton submitButton;
    private JButton updateButton;
  
    
    private JLabel titleInstructionsLabel;
    private JPanel instructionPanel;
    private JLabel instructionsLabel;
    private ImageIcon nflIcon;
    private JLabel termsOfUse;

	private int validationNumber;
	private int selectedWeekNumber;
    


    
    private List<Game> games;
	private ArrayList<Team> teams;
	private StandingsPanel standingsPanel;
	private ScoresPanel scoresPanel;


	
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

	
	
	public CustomCheckBox firstGameBox;
	public CustomCheckBox secondGameBox;
	public CustomCheckBox thirdGameBox;
	
	public boolean isFirstBoxSelected;
	public boolean isSecondBoxSelected;
	public boolean isThirdBoxSelected;
	

	private int currentStep;
	private boolean gameAdded;
	private boolean isGameOneAdded;   
	private boolean isGameTwoAdded;
	private boolean isGameThreeAdded;
	
	public UpdateDataPanel( ArrayList<Team> teams, List<Game> games, StandingsPanel standingsPanel, ScoresPanel scoresPanel) {
 
    	this.games = games;
    	this.teams = teams;
    	this.standingsPanel = standingsPanel;
    	this.scoresPanel = scoresPanel;
    	this.teamLogos = new HashMap<>();  
    	currentStep = 1;
    	isGameOneAdded = false;
    	isGameTwoAdded = false;
    	isGameThreeAdded = false;
    	isFirstBoxSelected = false;
    	isSecondBoxSelected = false;
    	isThirdBoxSelected = false;

		localClubPointsField = new JTextField();
		visitorClubPointsField = new JTextField();
    	
		localClubField = new JTextField();
		visitorClubField = new JTextField();
					
		
		initializeGraphics();
    	
    }
	
	
	
	
	private void initializeGraphics() {
		initializegameOneGraphics();
		initializeGameTwoGraphics();
		initiailizeGameThreeGraphics();
		initializeMainGraphics();
	}
	
	private void initializegameOneGraphics() {
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
	}
	
	private void initializeGameTwoGraphics() {
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
	}
	
	private void initiailizeGameThreeGraphics() {
	     
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
		    
	}
	private void initializeMainGraphics() {
		firstGameBox = new CustomCheckBox();
		firstGameBox.setBounds(1300, 210 ,50 , 45);
		firstGameBox.addActionListener(this);
		this.add(firstGameBox);	
		
	    	    
	    
	   
	    
	    
		secondGameBox = new CustomCheckBox();
		secondGameBox.setBounds(1300, 350 ,50 , 45);
		secondGameBox.addActionListener(this);
		this.add(secondGameBox);
	    
	    
	  
	       
	    
		thirdGameBox = new CustomCheckBox();
		thirdGameBox.setBounds(1300, 490 ,50 , 45);
		thirdGameBox.addActionListener(this);
		this.add(thirdGameBox);
	    
	       
	       initializeTeamLogos();
	       
	       createWeekComboBox();
	       


        
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
                "<li>Selecciona la jornada del partido desde 'Jornada 1' hasta 'Jornada 10' en el <br> desplegable.</li> <br>" +
                "<li>Haga click en los puntos para poder insertarlos o actualizarlos</li> <br> " +
                "<li>Ingrese los puntos del club local y visitante.</li> <br>" +
                "<li> Haga click en 'Guardar' para guardar los resultados del partido o 'Actualizar' <br> para  actualizar los datos</li> <br>"+             
                "<li>Recuerde guardar su entrada. Gracias por ayudar a mantener los resultados <br> de los partidos</li>" +     
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
	}
       
    
    @Override
	public void actionPerformed(ActionEvent e) {
		userClickLoginLogic(e);
	}
    
	private void userClickLoginLogic(ActionEvent e) {

	
	    if (e.getSource() == submitButton) {
	        StandingsDataUtil.checkWhichBoxIsSelected(this);

	        if (StandingsDataUtil.areMultipleBoxesSelected(this)) {
	            
	            handleValidationNumber(MULTIPLE_CHEC_BOXES_ARE_SELECTED_ADD_CASE);
	            
	        }else if (StandingsDataUtil.checkIfNoBoxIsSelected(this) == 0) {
	        	handleValidationNumber(NO_CHECK_BOX_IS_SELECTED_ADD_CASE);

	        } else  if (whichWeekIsSelected() != 10) {  
	        	
   
	        	handleValidationNumber(GAME_IS_ALREADY_IN_STANDINGS);     

	        } else {
	        	
	        	if (currentStep <= 3) {
	        	
					gameAdded = false;
	        		
	        		if (isFirstBoxSelected && currentStep == 1) {
	        			handleStepOne();
	        			gameAdded = true;
	        			} else if (isSecondBoxSelected && currentStep == 2) {
	        			handleStepTwo();
	        			gameAdded = true;
	        		} else if (isThirdBoxSelected && currentStep == 3) {
	        			handleStepThree();
	        			gameAdded = true;

	        		} else if (isFirstBoxSelected) {
						handleStepOne();
						currentStep--;
						if (isgameExist()) {
						
							gameAdded = true;
							return;
						}
					} else if (isSecondBoxSelected) {
						handleStepTwo();
						currentStep--;
						if (isgameExist()) {
						
							gameAdded = true;
							return;
						}
					} else if (isThirdBoxSelected) {
						handleStepThree();
						currentStep--;
						if (isgameExist()) {
						
							gameAdded = true;
							return;
						}
					}
	            

	        		if (!gameAdded) {
	        			userDialog("Los partidos se deben añadir secuencialmente", "Requisitos para añadir partidos");
	        			return;
	        		}
	        		
	        	} else {
    		     	
	        		if (isFirstBoxSelected) {
	        			handleStepOne();
	        		} else if (isSecondBoxSelected) {
	        			handleStepTwo();
	        		} else if (isThirdBoxSelected) {
	        			handleStepThree();  		
	        		}
	        	}

	        	if (StandingsDataUtil.validateStandingsDataForEmpties(localClubField.getText(), visitorClubField.getText(), localClubPointsField.getText(),visitorClubPointsField.getText())) {
	    			handleValidationNumber(SOME_OR_ALL_FIELDS_ARE_EMPTY);
	        		
	        	} else {
	            
	            validationNumber = StandingsDataUtil.validateStandingsDataForPoints(localClubPointsField.getText(), visitorClubPointsField.getText());

	            if (validationNumber == ALL_POINTS_ARE_INVALID || validationNumber == LOCAL_POINTS_ARE_INVALID || validationNumber == VISITOR_POINTS_ARE_INVALID) {
	                handleValidationNumber(validationNumber);
	                resetFields();
	            } else {
	                boolean isgameExist = false;
	                for (int i = 0; i < games.size(); i++) {
	                    isgameExist = (games.get(i).getLocalTeam().equals(localClubField.getText())) && (games.get(i).getVisitorTeam().equals(visitorClubField.getText()));
	                    if (isgameExist) {
							if (!gameAdded) {
								handleValidationNumber(GAME_IS_ALREADY_IN_STANDINGS);
							}


	                        break;
	                    }
	                }

	                 
	                    if (!isgameExist) {
	                        
	                       
	                        if (localClubField.getText().equals("Cardinals")) {
	                        	isGameOneAdded = true;
	                        	
	                        }else if (localClubField.getText().equals("Raiders")) {
	                        	 isGameTwoAdded = true;	
	                        	
	                        } else if (localClubField.getText().equals("Steelers")) {
	                        	 isGameThreeAdded = true;
	                        		
	                        }
	                        
	                        addGameAndUpdateStandings();
	                    }
	               
	            }
	        }
	       }
       	        
	    } else if (e.getSource() == updateButton) {
	    	
	    	 StandingsDataUtil.checkWhichBoxIsSelected(this);
	    	 if (StandingsDataUtil.checkIfNoBoxIsSelected(this) == 0) {
		        	handleValidationNumber(NO_CHECK_BOX_IS_SELECTED_UPDATE_CASE);
	    	 } else if (StandingsDataUtil.areMultipleBoxesSelected(this)) {
	    		 	handleValidationNumber(MULTIPLE_CHEC_BOXES_ARE_SELECTED_UPDATE_CASE);
	    	 } else {
		        	if (isFirstBoxSelected) {
		        		if (whichWeekIsSelected() != 10)  {
		        			choseGameToUpdate(isFirstBoxSelected, isSecondBoxSelected, isThirdBoxSelected);
		        		} else if (isGameOneAdded) {
		        			choseGameToUpdate(isFirstBoxSelected, isSecondBoxSelected, isThirdBoxSelected);
		        		} else {
		        			handleValidationNumber(GAME_DOES_NOT_EXISTS);
		        			return;
		        		}
		        		
		        	} else if (isSecondBoxSelected) {
		        		if (whichWeekIsSelected() != 10)  {
		        			choseGameToUpdate(isFirstBoxSelected, isSecondBoxSelected, isThirdBoxSelected);
		        		} else if (isGameTwoAdded) {
		        			choseGameToUpdate(isFirstBoxSelected, isSecondBoxSelected, isThirdBoxSelected);
		        		} else {
		        			handleValidationNumber(GAME_DOES_NOT_EXISTS);
		        			return;
		        		}
		        		
		        	} else if (isThirdBoxSelected) {
		        		if (whichWeekIsSelected() != 10)  {
		        			choseGameToUpdate(isFirstBoxSelected, isSecondBoxSelected, isThirdBoxSelected);
		        		} else if (isGameThreeAdded) {
		        			choseGameToUpdate(isFirstBoxSelected, isSecondBoxSelected, isThirdBoxSelected);
		        		} else {
		        			handleValidationNumber(GAME_DOES_NOT_EXISTS);
		        			return;
		        		}
		        	}
	    	
		        	validationNumber = StandingsDataUtil.validateStandingsDataForPoints(localClubPointsField.getText(),visitorClubPointsField.getText());

			
		        	if (StandingsDataUtil.validateStandingsDataForEmpties(localClubField.getText(), visitorClubField.getText(), localClubPointsField.getText(),visitorClubPointsField.getText())) {
		        		handleValidationNumber(SOME_OR_ALL_FIELDS_ARE_EMPTY);
				
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
		        			userDialogFedback("Su partido se ha actualizado correctamente", "Actualizar entrada");

		        		}
				
		        	}

	    	 }
	    }
		
	}

	private boolean isgameExist() {

		boolean isgameExist = false;
		for (int i = 0; i < games.size(); i++) {
			isgameExist = (games.get(i).getLocalTeam().equals(localClubField.getText())) && (games.get(i).getVisitorTeam().equals(visitorClubField.getText()));
			if (isgameExist) {
				handleValidationNumber(GAME_IS_ALREADY_IN_STANDINGS);
				break;
			}
		}
		return isgameExist;
	}
	
	
	private void handleStepOne() {
	    localClubPointsField.setText(firstLocalTeamPointField.getText());
	    visitorClubPointsField.setText(firstVisitorTeamPointField.getText());
	    localClubField.setText("Cardinals");
	    visitorClubField.setText("Cowboys");
	    currentStep++;
	}

	private void handleStepTwo() {
	    localClubPointsField.setText(secondLocalTeamPointField.getText());
	    visitorClubPointsField.setText(secondVisitorTeamPointField.getText());
	    localClubField.setText("Raiders");
	    visitorClubField.setText("Bengals");
	    currentStep++;
	}

	private void handleStepThree() {
	    localClubPointsField.setText(thirdLocalTeamPointField.getText());
	    visitorClubPointsField.setText(thirdVisitorTeamPointField.getText());
	    localClubField.setText("Steelers");
	    visitorClubField.setText("Chiefs");
	    currentStep++;
	}

	private void addGameAndUpdateStandings() {
	    new AddGameUtil(this.games, localClubField.getText(), visitorClubField.getText(), localClubPointsField.getText(), visitorClubPointsField.getText(), whichWeekIsSelected());
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
	                    firstGameBox.setSelected(false);
	            		secondGameBox.setSelected(false);
	            		thirdGameBox.setSelected(false);
	                } catch (NumberFormatException ex) {
	                    System.err.println("Error parsing week number");
	                }
	            }
	        }
	    });
	}
		
	
	
	
	private void choseGameToUpdate(boolean firstBox, boolean secondBox, boolean thirdBox) {
		if (firstBox) {
			switch (selectedWeekNumber) {
			case 1:
				handleStepGameOne(0);
				break;
			case 2:
				handleStepGameOne(3);
				break;
			case 3:
				handleStepGameOne(6);
				break;
			case 4:
				handleStepGameOne(9);
				break;
			case 5:
				handleStepGameOne(12);
				break;
			case 6:
				handleStepGameOne(15);
				break;
			case 7:
				handleStepGameOne(18);
				break;
			case 8:
				handleStepGameOne(21);
				break;
			case 9:
				handleStepGameOne(24);
				break;
			case 10:  
				handleStepGameOne(27);
				break;
			default :
			}
		}else if (secondBox) {
			switch (selectedWeekNumber) {
			case 1:
				handleStepGameTwo(1);
				break;
			case 2:
				handleStepGameTwo(4);
				break;
			case 3:
				handleStepGameTwo(7);
				break;
			case 4:
				handleStepGameTwo(10);
				break;
			case 5:
				handleStepGameTwo(13);
				break;
			case 6:
				handleStepGameTwo(16);
				break;
			case 7:
				handleStepGameTwo(19);
				break;
			case 8:
				handleStepGameTwo(22);
				break;
			case 9:
				handleStepGameTwo(25);
				break;
			case 10:
				handleStepGameTwo(28);		
				break;
			default :
			}
		}else if (thirdBox) {
			
			switch (selectedWeekNumber) {
			case 1:
				handleStepGameThree(2);
				break;
			case 2:
				handleStepGameThree(5);
				break;
			case 3:
				handleStepGameThree(8);
				break;
			case 4:
				handleStepGameThree(11);
				break;
			case 5:
				handleStepGameThree(14);
				break;
			case 6:
				handleStepGameThree(17);
				break;
			case 7:
				handleStepGameThree(20);
				break;
			case 8:
				handleStepGameThree(23);
				break;
			case 9:
				handleStepGameThree(26);
				break;
			case 10:
				handleStepGameThree(29);
				break;
			default :
			}
		}
	}
	
	
	
	private void handleStepGameOne(int gameNumber){
		
		  	localClubPointsField.setText(firstLocalTeamPointField.getText());
		    visitorClubPointsField.setText(firstVisitorTeamPointField.getText());
		    
		    localClubField.setText(games.get(gameNumber).getLocalTeam());
		    visitorClubField.setText(games.get(gameNumber).getVisitorTeam());
		    
		    isFirstBoxSelected = false;

	}
	

	private void handleStepGameTwo(int gameNumber){
		
		  	localClubPointsField.setText(secondLocalTeamPointField.getText());
		    visitorClubPointsField.setText(secondVisitorTeamPointField.getText());
		    
		    localClubField.setText(games.get(gameNumber).getLocalTeam());
		    visitorClubField.setText(games.get(gameNumber).getVisitorTeam());
		    
		    isSecondBoxSelected = false;


	}
	

	private void handleStepGameThree(int gameNumber){
		
		  	localClubPointsField.setText(thirdLocalTeamPointField.getText());
		    visitorClubPointsField.setText(thirdVisitorTeamPointField.getText());
		    
		    localClubField.setText(games.get(gameNumber).getLocalTeam());
		    visitorClubField.setText(games.get(gameNumber).getVisitorTeam());

		    isThirdBoxSelected = false;

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
		        	
		        	
		        	thirdLocalTeamPointField.setText("?");
		        	thirdLocalTeamPointLabel.setText("?");
		        	
		        	
		        	thirdVisitorTeamPointField.setText("?");
		        	thirdVisitorTeamPointLabel.setText("?");
		        	
        	
			
		 } else if (totalnumberOfGames == 28){
			 
	
	        	firstLocalTeamPointLabel.setText(String.valueOf(games.get(gameOne).getLocalScore()));
	        	firstLocalTeamPointField.setText(String.valueOf(games.get(gameOne).getLocalScore()));
	        	
	        	
	        	firstVisitorTeamPointField.setText(String.valueOf(games.get(gameOne).getVisitorScore()));
	        	firstVisitorTeamPointLabel.setText(String.valueOf(games.get(gameOne).getVisitorScore()));
	        	
	        	
	        	secondLocalTeamPointField.setText("?");
	        	secondLocalTeamPointLabel.setText("?");
	        	
	        	secondVisitorTeamPointField.setText("?");
	        	secondVisitorTeamPointLabel.setText("?");
	        	
	        	
	        	thirdLocalTeamPointField.setText("?");
	        	thirdLocalTeamPointLabel.setText("?");
	        	
	        	
	        	thirdVisitorTeamPointField.setText("?");
	        	thirdVisitorTeamPointLabel.setText("?");
	        	
	    

			 
		 } else {
        
       
        firstLocalTeamPointField.setText("?");
        firstLocalTeamPointLabel.setText("?");
  
	    firstVisitorTeamPointField.setText("?");
	    firstVisitorTeamPointLabel.setText("?");
	    
	    
	    secondLocalTeamPointField.setText("?");
	    secondLocalTeamPointLabel.setText("?");
	  
	    
	    
	    secondVisitorTeamPointField.setText("?");
	    secondVisitorTeamPointLabel.setText("?");
	    
	    
	    thirdLocalTeamPointField.setText("?");
	    thirdLocalTeamPointLabel.setText("?");
	    
	    thirdVisitorTeamPointField.setText("?");
	    thirdVisitorTeamPointLabel.setText("?");
	    
		 }  
	}

	
	private void allowToModifyField(JLabel label, JTextField field) {
		
		label.addMouseListener(new MouseAdapter() {
	        @Override
	        public void mouseClicked(MouseEvent e) {
	        	label.setVisible(false);
	        	field.setVisible(true);
	        	
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
			currentStep--;
			break;
		case ALL_POINTS_ARE_INVALID:
			userDialog("Puntos incorrectos, los puntos deben ser dentro de este rango (0 a 99)","Requisitos de campos");
			currentStep--;
			break;
		case LOCAL_POINTS_ARE_INVALID:	
			userDialog("Puntos incorrectos, los puntos deben ser dentro de este rango (0 a 99)","Requisitos de campos");
			currentStep--;
			break;
		case VISITOR_POINTS_ARE_INVALID:
			userDialog("Puntos incorrectos, los puntos deben ser dentro de este rango (0 a 99)","Requisitos de campos");
			currentStep--;
			break;	
		case MULTIPLE_CHEC_BOXES_ARE_SELECTED_ADD_CASE:
			userDialog("Se permite añadir solo un partido", "Requisitos de campos");
			break;
		case GAME_IS_ALREADY_IN_STANDINGS:
			userDialog("Este partido ya existe, asegurate que has introducido un nuevo partido","Requisitos de campos");
			break;
		case NO_CHECK_BOX_IS_SELECTED_ADD_CASE:
			userDialog("Tienes que selecionar un partido para guardar", "Requisitos de campos");
			break;
		case NO_CHECK_BOX_IS_SELECTED_UPDATE_CASE:
			userDialog("Tienes que selecionar un partido para actualizar", "Requisitos de campos");
			break;
		case MULTIPLE_CHEC_BOXES_ARE_SELECTED_UPDATE_CASE:
			userDialog("Se permite actualizar solo un partido", "Requisitos de campos");
			break;
		case WEEK_NUMBER_IS_INCORRECT:
			userDialog("La semana del partido que quieres modifcar es incorrecta", "Requisitos de campos");
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
		
		resetFields();
		
		firstGameBox.setSelected(false);
		secondGameBox.setSelected(false);
		thirdGameBox.setSelected(false);
	}
	
	private void resetFields() {
		localClubField.setText("");
		visitorClubField.setText("");
		localClubPointsField.setText("");
		visitorClubPointsField.setText("");
	}
}