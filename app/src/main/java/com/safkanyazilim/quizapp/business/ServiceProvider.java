package com.safkanyazilim.quizapp.business;

import com.safkanyazilim.quizapp.data.DataConsumer;

import java.util.List;

/**
 * Created by elif on 27.06.2016.
 */
public interface ServiceProvider<T> {
    void addServiceConsumer(ServiceConsumer<T> consumer);
    void retrieveData();
    void notifyConsumers(List<T> itemList);
}
