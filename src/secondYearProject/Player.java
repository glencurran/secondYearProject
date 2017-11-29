package secondYearProject;

import java.io.Serializable;

public class Player implements Serializable{
    private String name;
    private int score;

    public Player(){}

    public Player(String name){
        setName(name);
    }
    public Player(String name, int score){
        setName(name);
        setScore(score);
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setScore(int score){
        this.score = score;
    }
    public int getScore(){
        return score;
    }

    public String toString(){
        return "Name: " + getName() + "\nScore: " + getScore();
    }
}
