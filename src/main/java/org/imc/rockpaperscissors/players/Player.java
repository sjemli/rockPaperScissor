package org.imc.rockpaperscissors.players;


import org.imc.rockpaperscissors.enums.Move;

public abstract class Player {

    private int score = 0;

    public abstract Move getChoice();

    public void incrementScore() {
        score++;
    }

    public int getScore() {
        return score;
    }

}
