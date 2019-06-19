package com.codecool.jakotako.battleofcards;

import java.util.*;

public class Player{

    private String name;
    private List<Card> deck;

    public Player(String name, List<Card> deck){
        this.name = name;
        this.deck = deck;
    }

    public String getName(){
        return this.name;
    }

}
