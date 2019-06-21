package com.codecool.jakotako.battleofcards;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Display {

    public String playerNameInput() {

        Scanner reader = new Scanner(System.in);
        ;
        System.out.println("Enter player name: ");
        String name = reader.nextLine();
        return name;
    }

    public void displayCard(Player player, Card card) {

        System.out.println("Player " + player.getName() + " turn.");
        System.out.println("─────────────────────────────────");
        System.out.println("Name: " + card.getDescription());
        System.out.println("(1) Attack: " + card.getFields().get("Attack"));
        System.out.println("(2) Defence: " + card.getFields().get("Defence"));
        System.out.println("(3) Speed: " + card.getFields().get("Speed"));
        System.out.println("(4) Strength: " + card.getFields().get("Strength"));
        System.out.println("─────────────────────────────────");
    }

}
