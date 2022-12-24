package com.encryptedcation.tankstars;

import java.io.Serializable;

public class SavedGame implements Serializable {
    // save the game state using json serialization and deserialization
    // save player position, health, fuel
    private static final long serialVersionUID = 1L;
    private Player player1;
    private Player player2;
    private int turn;

    public SavedGame(Player player1, Player player2, int turn) {
        this.player1 = player1;
        this.player2 = player2;
        this.turn = turn;
    }

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public int getTurn(){
        return this.turn;
    }

    public void setTurn(int turn){
        this.turn = turn;
    }

}
