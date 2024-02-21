package com.tictactoe;

public class Player {

    private Figure playerChoiceSelect;
    private String username;
    private int score;

    public Player(String username) {
        this.username = username;
    }

    public Figure getPlayerChoiceSelect() {
        return playerChoiceSelect;
    }

    public void setPlayerChoiceSelect(Figure playerChoiceSelect) {
        this.playerChoiceSelect = playerChoiceSelect;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void incrementScore() {
        this.score++;
    }
}
