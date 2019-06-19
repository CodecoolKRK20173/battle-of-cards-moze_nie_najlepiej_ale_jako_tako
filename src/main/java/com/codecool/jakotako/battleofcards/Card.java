package com.codecool.jakotako.battleofcards;

import java.util.HashMap;
import java.util.Map;

public class Card {
    private String id;
    private String description;
    private Map<String, Integer> fields = new HashMap();



    public Card(String id, String description){
        this.id = id;
        this.description = description;
    }
    public Map<String,Integer> getFields(){
        return this.fields;
    }

    public void setCardValueById(String id, int value){ //use primitives always except you need to use boxes
        this.fields.put(id, value);
    }

    public String getDescription(){

            return this.description;
        }


    }
