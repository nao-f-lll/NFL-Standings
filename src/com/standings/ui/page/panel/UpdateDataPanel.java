package com.standings.ui.page.panel;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
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
import com.standings.model.Game;
import com.standings.model.ParentFrame;
import com.standings.model.Team;
import com.standings.ui.page.SportsDashboardPage;
import com.standings.util.AddGameUtil;
//import com.standings.util.AutocompleteTextField;
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
    
	
    private JLabel localClubLabel;
    private JLabel localClubPointsLabel;
    private JTextField localClubField;
    private JTextField localClubPointsField;
    
    private JLabel visitorClubLabel;
    private JLabel visitorClubPointsLabel; 
    private JTextField visitorClubField;
    private JTextField visitorClubPointsField;
    
  
    private JComboBox<String> weekComboBox;
    DefaultComboBoxModel<String> comboWeekModel;
    
    private JButton submitButton;
    private JButton updateButton;
    private JButton cancelButton;
    
    private JLabel titleInstructionsLabel;
    private JPanel instructionPanel;
    private JLabel instructionsLabel;
    private ImageIcon nflIcon;
    private JLabel termsOfUse;

	private int validationNumber;
    


    
    private JLabel errorMessageForLocalPointsField;
    private JLabel errorMessageForVisitorPointsField;
    
	private List<Game> games;
	private ArrayList<Team> teams;
	private StandingsPanel standingsPanel;
	private ScoresPanel scoresPanel;
	
    
	
	//private AutocompleteTextField autocompleteTextField;
	
    
    public UpdateDataPanel( ArrayList<Team> teams, List<Game> games, StandingsPanel standingsPanel, ScoresPanel scoresPanel) {
 
    	this.games = games;
    	this.teams = teams;
    	this.standingsPanel = standingsPanel;
    	
    	
    	
   
    	
    	
    	
    	comboWeekModel = new DefaultComboBoxModel<>();	
    	for (int i = 1; i < 11; i++) {
    		comboWeekModel.addElement("Semana " + i);
    	}
    	
        weekComboBox = new JComboBox<>(comboWeekModel);
        weekComboBox.setBackground(Color.LIGHT_GRAY);
        weekComboBox.setBounds(1033, 130, 114, 45);
        this.add(weekComboBox);
        
        localClubLabel = new JLabel("Equipo Local");
        localClubLabel.setBounds(829, 215, 103, 37);
        this.add(localClubLabel);
        
        
        
        
        
     	//autocompleteTextField = new AutocompleteTextField();
    	//autocompleteTextField.setBounds(791, 262, 155, 37); // Adjust the bounds as needed
    	//this.add(autocompleteTextField);
        
        localClubField = new JTextField();
        localClubField.setBounds(791, 262, 155, 37);
        this.add(localClubField);
        localClubField.setColumns(10);
        
        
        
        visitorClubLabel = new JLabel("Equipo Visitante");
        visitorClubLabel.setBounds(829, 355, 117, 25);
        this.add(visitorClubLabel);
        
        visitorClubField = new JTextField();
        visitorClubField.setColumns(10);
        visitorClubField.setBounds(791, 390, 155, 37);
        this.add(visitorClubField);
        
        
        localClubPointsLabel = new JLabel("Puntos");
        localClubPointsLabel.setBounds(1250, 215, 71, 37);
        this.add(localClubPointsLabel);
        
        
        visitorClubPointsLabel = new JLabel("Puntos");
        visitorClubPointsLabel.setBounds(1250, 352, 84, 31);
        this.add(visitorClubPointsLabel);
        
        
        localClubPointsField = new JTextField();
        localClubPointsField.setBounds(1250, 264, 35, 34);
        this.add(localClubPointsField);
        localClubPointsField.setColumns(10);
    	fieldFocusListener(localClubPointsField,null);
        
        visitorClubPointsField = new JTextField();
        visitorClubPointsField.setColumns(10);
        visitorClubPointsField.setBounds(1250, 392, 35, 34);
        this.add(visitorClubPointsField);
        fieldFocusListener(null,visitorClubPointsField);
        
        submitButton = new JButton("Guardar");
        submitButton.setBounds(778, 535, 130, 45);
        submitButton.setFocusable(false);
        submitButton.setBackground(Color.lightGray);
        submitButton.addActionListener(this);
        this.add(submitButton);
        
        updateButton = new JButton("Actualizar");
        updateButton.setBounds(1001, 535, 130, 45);
        updateButton.setFocusable(false);
        updateButton.setBackground(Color.lightGray);
        updateButton.addActionListener(this);
        this.add(updateButton);
        
        cancelButton = new JButton("Cancelar");
        cancelButton.setBounds(1222, 535, 130, 45);
        cancelButton.setFocusable(false);
        cancelButton.setBackground(Color.lightGray);
        cancelButton.addActionListener(this);
        this.add(cancelButton);
        
        
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
                "<li>Haz click en 'Guardar' para guardar los resultados del partido o 'Actualizar' para <br> actualizar los datos</li> <br>"+
                "<li>'Cancelar' para descartar los cambios</li> " + 
                "</ul>" +         
                "<p style='text-indent: 30px;'>Recuerde guardar su entrada. Gracias por ayudar a mantener los resultados </p> <p style='text-indent: 30px;'>  de los partidos</p>" +     
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
		
		if (e.getSource() == submitButton) {
			
			validationNumber = StandingsDataUtil.validateStandingsDataForPoints(localClubPointsField.getText(),visitorClubPointsField.getText());

			
			if (StandingsDataUtil.validateStandingsDataForEmpties(localClubField.getText(), visitorClubField.getText(), localClubPointsField.getText(),visitorClubPointsField.getText())) {
				handleValidationNumber(SOME_OR_ALL_FIELDS_ARE_EMPTY);
			} else if (StandingsDataUtil.validateStandingsDataForWrongTeamName(localClubField.getText(), visitorClubField.getText())) {
				handleValidationNumber(WRONG_TEAM_NAME); 
			} else if (StandingsDataUtil.validateStandingsDataForSameTeamNAme(localClubField.getText(), visitorClubField.getText())) {
				handleValidationNumber(THE_SAME_NAME_FOR_TEAMS_IS_NOT_ALLOWED); 
			} else if(validationNumber == ALL_POINTS_ARE_INVALID || validationNumber == LOCAL_POINTS_ARE_INVALID || validationNumber == VISITOR_POINTS_ARE_INVALID) {
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

				if (!isgameExist) {

					
				new AddGameUtil(this.games,localClubField.getText(),visitorClubField.getText(),localClubPointsField.getText(),visitorClubPointsField.getText());		
				for (Team team : this.teams) {
					if (team.getName().equals(localClubField.getText()) || team.getName().equals(visitorClubField.getText())) {
						int sizeOfListOfGames = games.size() - 1;
						StandingsCalculation.updateStandings(team, games.get(sizeOfListOfGames), NEW_STANDINGS_TYPE);  
						
					}
				}
				
				StandingsCalculation.sortStandings(this.teams);
				standingsPanel.renderUpdatedStandings();		
				resetFieldsAndWeek();
					
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
				
				for (int i = 0; i < games.size(); i++) {
					
					if (games.get(i).getLocalTeam().equals(localClubField.getText()) && games.get(i).getVisitorTeam().equals(visitorClubField.getText())) {
							
						
						games.get(i).setOldLocalScore(games.get(i).getLocalScore());
						games.get(i).setOldVisitorScore(games.get(i).getVisitorScore());
						
						games.get(i).setLocalScore(Integer.parseInt(localClubPointsField.getText()));
						games.get(i).setVisitorScore(Integer.parseInt(visitorClubPointsField.getText()));
						
						for (Team team : this.teams) {
							if (team.getName().equals(localClubField.getText()) || team.getName().equals(visitorClubField.getText())) {
								StandingsCalculation.updateStandings(team, games.get(i), EXISTING_STANDINGS_TYPE);  
								
							}
						}
					} 
				}
				
				StandingsCalculation.sortStandings(this.teams);
				standingsPanel.renderUpdatedStandings();			
				resetFieldsAndWeek();
				scoresPanel.initializeWeekPanels();   
				/// add fedback to the user
			}
	
			
		} else if (e.getSource() == cancelButton) {
			
			resetFieldsAndWeek();
		}
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
			localClubPointsField.setBorder(BorderFactory.createLineBorder(Color.red));
			visitorClubPointsField.setBorder(BorderFactory.createLineBorder(Color.red));
			userDialog("Puntos incorrectos, los puntos deben ser dentro de este rango (0 a 99)","Requisitos de campos");
			
			break;
		case LOCAL_POINTS_ARE_INVALID:	
			localClubPointsField.setBorder(BorderFactory.createLineBorder(Color.red));
			userDialog("Puntos incorrectos, los puntos deben ser dentro de este rango (0 a 99)","Requisitos de campos");
			break;
		case VISITOR_POINTS_ARE_INVALID:
			visitorClubPointsField.setBorder(BorderFactory.createLineBorder(Color.red));
			userDialog("Puntos incorrectos, los puntos deben ser dentro de este rango (0 a 99)","Requisitos de campos");
			break;
			
		case GAME_IS_ALREADY_IN_STANDINGS:
			userDialog("Este partido ya existe, asegurate que has introducido un nuevo partido","Requisitos de campos");
			break;
		default :
		}
	}	
	
	
	
	 public void fieldFocusListener(JTextField localPoints, JTextField visitorPoints) {  // add option for localTeam and visitorTeam names
		 if (localPoints != null) {
			 localPoints.addFocusListener(new FocusListener() {
				    @Override
				    public void focusGained(FocusEvent e) {
				    	localClubPointsField.setBorder(BorderFactory.createLineBorder(Color.black));
				    	visitorClubPointsField.setBorder(BorderFactory.createLineBorder(Color.black));
				    }

				    @Override
				    public void focusLost(FocusEvent e) {
				     
				    }
				});
		 } else if (visitorPoints != null) {
			 	visitorPoints.addFocusListener(new FocusListener() {
				    @Override
				    public void focusGained(FocusEvent e) {
				    	visitorClubPointsField.setBorder(BorderFactory.createLineBorder(Color.black));
				    	localClubPointsField.setBorder(BorderFactory.createLineBorder(Color.black));
				    }

				    @Override
				    public void focusLost(FocusEvent e) {
				       
				    }
				});
		 }
	}
	
	
	private void userDialog(String dialogText, String dialogTitle) {
		
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
	
	private void resetFieldsAndWeek() {
		
		localClubField.setText("");
		visitorClubField.setText("");
		localClubPointsField.setText("");
		visitorClubPointsField.setText("");
		
		comboWeekModel = new DefaultComboBoxModel<>();
        for (int i = 1; i < 11; i++) {
            comboWeekModel.addElement("Semana " + i);
        }
        weekComboBox.setModel(comboWeekModel);
	}

}
