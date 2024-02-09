package com.tictactoe;

public enum Figures {
    X,
    O,
    BLANK;

    @Override
    public String toString() {
        if (this == BLANK) {
            return " ";
        } else {
            return super.toString();
        }
    }
}


