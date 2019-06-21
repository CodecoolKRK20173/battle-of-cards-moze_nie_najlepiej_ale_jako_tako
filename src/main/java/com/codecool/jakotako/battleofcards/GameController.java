package com.codecool.jakotako.battleofcards;

import com.codecool.jakotako.battleofcards.parser.CardParser;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;


import java.util.InputMismatchException;
import java.util.Scanner;

public class GameController {
    private List<Card> stack;
    private static List[] decks;
    CardRepository cardRepository;
    Player player1;
    Player player2;
    Display display = new Display();
    //boolean isOn = true;

    public GameController(CardParser cardParser) {
        cardRepository = cardParser.getCardRepository();
        gamePreparation();
        Display display = new Display();
        this.player1 = new Player(display.playerNameInput(), decks[0]);
        this.player2 = new Player(display.playerNameInput(), decks[1]);
        round();


    }

    public void round() {

        while (!player1.getDeck().isEmpty() || !player2.getDeck().isEmpty()) {

            display.displayCard(player1, player1.getTopCard());
            display.displayCard(player2, player2.getTopCard());
            String chooseStat = chooseStat();
            winnerCard(player1.getTopCard(), player2.getTopCard(), chooseStat);
        }
    }

    private void addCardsToStack () {
        this.stack = new ArrayList<>();
        stack.addAll(cardRepository.getCards());
    }

    private void stackShuffle() {
        Collections.shuffle(this.stack);
    }

    private List[] devideStackIntoDeck(List<Card> stack) {
        int size = stack.size();
        List<Card> deck1 = new ArrayList<>(stack.subList(0, size / 2));
        List<Card> deck2 = new ArrayList<>(stack.subList(size / 2, size));
        return new List[] {deck1,deck2};
    }

    private void gamePreparation(){
        addCardsToStack();
        stackShuffle();
        this.decks = devideStackIntoDeck(stack);
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

    public List<Card> getStack() {
        return this.stack;
    }

    public String winnerCard(Card card1, Card card2, String stat) {
    public static void main(String[] args) {
        CardParser cardParser = new CardParser();
        GameController gameController = new GameController(cardParser);
        System.out.println(gameController.getStack());
        System.out.println(decks[0]);
        System.out.println(gameController.player2.getDeck());
    }

        if (card1.getFields().get(stat) > card2.getFields().get(stat)) {

            player1.getDeck().add(card1);
            player1.getDeck().add(card2);
            return "The winner is " + card1.getDescription();

        }
        else {
            player2.getDeck().add(card1);
            player2.getDeck().add(card2);
            return "The winner is " + card2.getDescription();
        }
    }
}
