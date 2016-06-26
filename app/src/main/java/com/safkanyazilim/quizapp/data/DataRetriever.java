package com.safkanyazilim.quizapp.data;

/**
 * Created by elif on 26.06.2016.
 */
public interface DataRetriever {
    void addDataConsumer(DataConsumer consumer);
    void retrieveQuestions();
}
