package com.safkanyazilim.quizapp.models;

import java.util.List;

/**
 * Created by elif on 25.06.2016.
 */
public class Question {

    public Question() {
    }

    public String id;
    public String text;
    public List<String> choices;
    public int correctChoiceIndex;

    @Override
    public String toString() {
        return "{id:"+this.id+", text:"+this.text +
                ", firstChoice:"+ this.choices.get(0).toString() +
                ", firstChoice:" + this.correctChoiceIndex +"}" ;
    }
}

