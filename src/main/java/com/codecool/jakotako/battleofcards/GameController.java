package com.codecool.jakotako.battleofcards;
import java.util.Scanner;

public class GameController {

    Player player1;
    Player player2;

    public GameController() {

        Display display = new Display();
        this.player1 = new Player(display.playerNameInput(), deck);
        this.player2 = new Player(display.playerNameInput(), deck);


    }






}
