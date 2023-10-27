
/*
package com.standings.util;

import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class AutocompleteTextField extends JTextField {
    
	private static final long serialVersionUID = 1675468360920544335L;
	
	private List<String> suggestions;

    public AutocompleteTextField() {
        super();
        suggestions = new ArrayList<>();
        setupAutocomplete();
    }

    public void setSuggestions(List<String> newSuggestions) {
        suggestions = newSuggestions;
    }

    private void setupAutocomplete() {
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    
                } else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                  
                } else {
                    String userInput = getText();
                    updateSuggestions(userInput);
                }
            }
        });
    }

    private void updateSuggestions(String userInput) {
        List<String> updatedSuggestions = new ArrayList<>();
        
        setSuggestions(updatedSuggestions);
        
        
    }
}
*/