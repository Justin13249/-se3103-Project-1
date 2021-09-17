package controller;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import model.WordGame;

import java.awt.event.ActionEvent;

import view.WordGamePanel;

public class WordGameListener implements ActionListener {

    private WordGamePanel panel;
    private String guess;

    public WordGameListener(WordGamePanel panel) {
        this.panel = panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        if (button == panel.getNewGameButton()) {
            var wordGame = panel.getWordGame();
            wordGame.newGame();
            panel.setWordGame(wordGame);
            panel.setGameState(WordGamePanel.GameState.PLAYING);
            String key = wordGame.getKey();
            panel.getGameKeyField().setText(key);
            String guess = "";
            for(int i = 0; i < key.length(); i++) {
                guess += '*';
            }
            panel.getGuessField().setText(guess);

            // enable digit buttons
            for ( var b: panel.getAlphaButtons() ) {
                b.setEnabled(true);
            }

            panel.getCanvas().repaint(); 
        } else {
            // letter button 0-9
            button.setEnabled(false);

            JTextField guessField = panel.getGuessField();
            guess = guessField.getText();
            String key = panel.getWordGame().getKey();
            char n = button.getText().charAt(0);
            boolean letterPresent = false;
            for(int i = 0; i < key.length(); i++) {
                if(key.charAt(i) == n) {
                    replace(n, i);
                    letterPresent = true;
                }
            }

            if(!letterPresent) {
                panel.getWordGame().setHealth(panel.getWordGame().getHealth() - 1);
            }

            if(panel.getWordGame().getHealth() <= 0) {
                panel.setGameState(WordGamePanel.GameState.GAMEOVER);
                    for ( var b: panel.getAlphaButtons()) {
                        b.setEnabled(false);
                    }
                    panel.getCanvas().repaint();
            } else {
                guessField.setText(guess);
                System.out.println(guess);
                panel.getCanvas().repaint();
            }
        
        }
        
    }

    public void replace(char n, int index) {
        char[] temp = guess.toCharArray();
        temp[index] = n;
        guess = String.valueOf(temp);
    }


    
}
