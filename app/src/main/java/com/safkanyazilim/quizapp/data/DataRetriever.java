package com.safkanyazilim.quizapp.data;

import java.util.List;

/**
 * Created by elif on 26.06.2016.
 */
public interface DataRetriever<T> {
    void addDataConsumer(DataConsumer consumer);
    void retrieveQuestions();
    void notifyConsumers(List<T> itemList);
}
