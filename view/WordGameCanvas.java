package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class WordGameCanvas extends JPanel{
    
    public static int WIDTH = 500;
    public static int HEIGHT = 500;

    public int health;

    private WordGamePanel panel;

    public WordGameCanvas(WordGamePanel panel) {
        this.panel = panel;
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.WHITE);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        WordGamePanel.GameState state = panel.getGameState();
        if(state == WordGamePanel.GameState.READY) {

            g2.setColor(Color.blue);
            g2.setFont(new Font("Courier New", Font.BOLD, 30));
            g2.drawString("Click <New> to Start", 70, 150);

        } else {

            if(state == WordGamePanel.GameState.LOST) {
                g2.setColor(Color.red);
                g2.setFont(new Font("Courier New", Font.BOLD, 30));
                g2.drawString("YOU LOST !!!", 70, 110);
                g2.setColor(Color.blue);
                g2.drawString("Click <New> to Start", 70, 150);
            } else if (state == WordGamePanel.GameState.WON) {
                g2.setColor(Color.red);
                g2.setFont(new Font("Courier New", Font.BOLD, 30));
                g2.drawString("YOU WON !!!", 70, 110);
                g2.setColor(Color.blue);
                g2.drawString("Click <New> to Start", 70, 150);
            } else {
                health = panel.getWordGame().getHealth();
                g2.setColor(Color.blue);
                g2.setFont(new Font("Courier New", Font.BOLD, 30));
                // draw health
                g2.drawString("Health level: " + health, 20, 50);
                for (int i = 0; i < 5; i++) {
                    if(i < health) {
                        //g2.fillOval(i * 100 + 10, 80, 50, 50);
                        g2.fillRect(i *70 + 30, 80, 50, 50);
                    } 
                }


            }
            
            
        }

    }
}
