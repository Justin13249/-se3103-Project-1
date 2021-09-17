package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.WordGame;
import controller.WordGameListener;

public class WordGamePanel {
    
    public enum GameState {
        READY, PLAYING, GAMEOVER
    }

    private JFrame window;
    private WordGameCanvas canvas;
    private JTextField gameKeyField = new JTextField();
    private JTextField guessField = new JTextField();
    private JButton[] alphaButtons;
    private JButton newGameButton = new JButton("New");
    private GameState gameState = GameState.READY;

    private WordGame wordGame;

    public WordGamePanel(JFrame window, WordGame wordGame) {
        this.window = window;
        this.wordGame = wordGame;
    }

    public void init() {


        Container cp = window.getContentPane();

        JPanel northPanel = new JPanel();
        northPanel.setLayout(new GridLayout(2,1));
        northPanel.add(gameKeyField);
        northPanel.add(guessField);
        gameKeyField.setEditable(false);
        guessField.setEditable(false);

        cp.add(BorderLayout.NORTH, northPanel);

        canvas = new WordGameCanvas(this);
        
        cp.add(BorderLayout.CENTER, canvas);

        JPanel southPanel = new JPanel();
        southPanel.setLayout(new GridLayout(4,7));

        WordGameListener keyListener = new WordGameListener(this);

        alphaButtons = new JButton[26];
        for (char alpha = 'a'; alpha <= 'z'; alpha++){
            alphaButtons[alpha - 97] = new JButton("" + alpha);
            southPanel.add(alphaButtons[alpha - 97]);
            alphaButtons[alpha - 97].addActionListener(keyListener);
        }

        newGameButton.addActionListener(keyListener);
        southPanel.add(newGameButton);
        cp.add(BorderLayout.SOUTH, southPanel);

        for ( var b: alphaButtons ) {
            b.setEnabled(false);
        }
    }

    public WordGame getWordGame() {
        return wordGame;
    }

    public JFrame getWindow() {
        return window;
    }

    public WordGameCanvas getCanvas() {
        return canvas;
    }

    public JTextField getGameKeyField() {
        return gameKeyField;
    }

    public JTextField getGuessField() {
        return guessField;
    }

    public JButton[] getAlphaButtons() {
        return alphaButtons;
    }

    public JButton getNewGameButton() {
        return newGameButton;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState state) {
        this.gameState = state;
    }

    public void setWordGame(WordGame wordGame) {
        this.wordGame = wordGame;
    }


}
