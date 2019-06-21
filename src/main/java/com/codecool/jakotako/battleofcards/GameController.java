package com.codecool.jakotako.battleofcards;

import com.codecool.jakotako.battleofcards.parser.CardParser;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;


public class GameController {
    private List<Card> stack;
    private static List[] decks;
    CardRepository cardRepository;
    Player player1;
    Player player2;

    public GameController(CardParser cardParser) {
        cardRepository = cardParser.getCardRepository();
        gamePreparation();
        Display display = new Display();
        this.player1 = new Player(display.playerNameInput(), decks[0]);
        this.player2 = new Player(display.playerNameInput(), decks[1]);


    }

    private void addCardsToStack() {
        this.stack = new ArrayList<>();
        stack.addAll(cardRepository.getCards());
    }

    private void stackShuffle() {
        Collections.shuffle(this.stack);
    }
    private List[] devideStackIntoDeck(List<Card> stack){
        int size = stack.size();
        List<Card> deck1 = new ArrayList<>(stack.subList(0, size / 2));
        List<Card> deck2 = new ArrayList<>(stack.subList(size/2, size));

        return new List[] {deck1,deck2};
    }
    private void gamePreparation(){
        addCardsToStack();
        stackShuffle();
        this.decks = devideStackIntoDeck(stack);
    }



    public List<Card> getStack() {
        return this.stack;
    }

    public static void main(String[] args) {
        CardParser cardParser = new CardParser();
        GameController gameController = new GameController(cardParser);
        System.out.println(gameController.getStack());
        System.out.println(decks[0]);
        System.out.println(gameController.player2.getDeck());
    }

}
