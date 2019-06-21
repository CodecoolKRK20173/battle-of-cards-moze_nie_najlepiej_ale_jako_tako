package com.codecool.jakotako.battleofcards;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GameController {

    Player player1;
    Player player2;
    Display display = new Display();
    //boolean isOn = true;

    public GameController() {

        this.player1 = new Player(display.playerNameInput(), deck);
        this.player2 = new Player(display.playerNameInput(), deck);
    }

    public void round(Player player1, Player player2) {

        while (!player1.getDeck().isEmpty() || !player2.getDeck().isEmpty()) {

            display.displayCard(player1, player1.getTopCard());
            display.displayCard(player2, player2.getTopCard());
            String chooseStat = chooseStat();
            winnerCard(player1.getTopCard(), player2.getTopCard(), chooseStat);
        }
    }

    public String chooseStat() {

        String stat = "";
        Scanner reader = new Scanner(System.in);
        System.out.println("Choose attribute you want to fight with:");
        int statNum = reader.nextInt();
        try {
            switch (statNum) {

                case 1:
                    stat = "Attack";
                case 2:
                    stat = "Defence";
                case 3:
                    stat = "Speed";
                case 4:
                    stat = "Strength";
            }
        } catch (InputMismatchException ex) {
            System.out.println("Please enter a number.");
        }

        return stat;
    }

    public String winnerCard(Card card1, Card card2, String stat) {

        if (card1.getFields().get(stat) > card2.getFields().get(stat)) {

            return "The winner is " + card1.getDescription();
        } else {

            return "The winner is " + card2.getDescription();
        }
    }


}
