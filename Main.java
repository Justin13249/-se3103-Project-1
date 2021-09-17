import javax.swing.JFrame;

import view.WordGamePanel;
import model.WordGame;

public class Main {
    
    public static void main(String[] args) {
        
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocation(400,100);

        WordGame wordGame = new WordGame();

        wordGame.add("communication");
        wordGame.add("science");
        wordGame.add("programming");
        wordGame.add("language");
        wordGame.add("difficulty");
        wordGame.add("artificial");
        wordGame.add("intelligence");
        wordGame.add("attempts");
        wordGame.add("screenshot");
        wordGame.add("baseball");
        wordGame.add("windows");
        wordGame.add("learning");
        wordGame.add("electronics");
        wordGame.add("beautiful");
        wordGame.add("internet");
        wordGame.add("database");
        wordGame.add("organization");
        wordGame.add("application");
        wordGame.add("network");
        wordGame.add("friendly");
        wordGame.add("validation");
        wordGame.add("attempts");
        wordGame.add("statistics");
        wordGame.add("physics");
        wordGame.add("chemistry");
        wordGame.add("engineering");
        wordGame.add("school");
        wordGame.add("industry");
        wordGame.add("revolution");
        wordGame.add("progress");
        wordGame.add("characters");
        wordGame.add("heavily");
        wordGame.add("graphics");

        wordGame.newGame();

        var wordGamePanel = new WordGamePanel(window, wordGame);
        wordGamePanel.init();

        window.pack();
        window.setVisible(true);

    }
}