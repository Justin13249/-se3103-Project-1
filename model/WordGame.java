package model;

import java.util.ArrayList;
import java.util.Random;

public class WordGame {
    
    private ArrayList<String> wordPool = new ArrayList<>();
    private String key;
    private int health = 5;

    public void newGame() {
        Random r = new Random();
        key = wordPool.get(r.nextInt(wordPool.size()));
        health = 5;
    }

    public void add(String word) {
        wordPool.add(word);
    }

    public String getKey() {
        return key;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

}
