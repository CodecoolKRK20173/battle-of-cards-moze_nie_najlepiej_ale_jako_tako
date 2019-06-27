package com.codecool.jakotako.battleofcards;

import com.codecool.jakotako.battleofcards.parser.CardParser;

public class Main {
    public static void main(String[] args) {
        CardParser cardParser = new CardParser();
        GameController gameController = new GameController(cardParser);
    }
}
