package com.tictactoe;

public class Player {

    private Figure playerChoiceSelect;
    private String username;

    public Player() {
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
}
