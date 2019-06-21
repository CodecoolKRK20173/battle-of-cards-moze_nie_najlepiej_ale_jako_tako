package com.codecool.jakotako.battleofcards;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GameController {

    Player player1;
    Player player2;
    Display display = new Display();

    public GameController() {


        this.player1 = new Player(display.playerNameInput(), deck);
        this.player2 = new Player(display.playerNameInput(), deck);
    }

    public void round(Player player1, Player player2) {

        display.displayCard(player1, player1.getTopCard());
        display.displayCard(player2, player2.getTopCard());
        System.out.println("The winner is " + winnerCard(player1.getTopCard(), player2.getTopCard()));

    }

    public String chooseStat() {

        String stat = "";
        Scanner reader = new Scanner(System.in);
        System.out.println("Choose attribute you want to fight with:");
        int statNum = reader.nextInt();
        try {
            switch (statNum) {

                case 1:
                    stat ="Attack";
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

    public String winnerCard(Card card1, Card card2) {

        if(card1.getFields().get(chooseStat()) > card2.getFields().get(chooseStat()) ) {

            return card1.getDescription();
        }
        else {

            return card2.getDescription();
        }

    }






}
