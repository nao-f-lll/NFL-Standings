package com.standings.model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Autocomplete extends JTextField {
    /**
	 * 
	 */
	private static final long serialVersionUID = 2153479799374185953L;
	
    private JList<String> suggestions;
    private DefaultListModel<String> listModel;
    private ArrayList<String> wordList;

    public Autocomplete() {
       

    
        wordList = new ArrayList<>();
        listModel = new DefaultListModel<>();


        wordList.add("Cardinals");
        wordList.add("Cowboys");
        wordList.add("Chiefs");
        wordList.add("Steelers");
        wordList.add("Bengals");
        wordList.add("Raiders");


   
        suggestions = new JList<>(listModel);

     
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                updateSuggestions();
            }
        });

        
     
        this.add(new JScrollPane(suggestions), BorderLayout.CENTER);
    }

    private void updateSuggestions() {
        String text = this.getText().toLowerCase();
        listModel.clear();

        for (String word : wordList) {
            if (word.toLowerCase().startsWith(text)) {
                listModel.addElement(word);
            }
        }

        suggestions.setVisible(!listModel.isEmpty());
    }
    
}

    
    
    