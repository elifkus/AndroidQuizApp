package com.safkanyazilim.quizapp.business;

import java.util.List;

/**
 * Created by elif on 27.06.2016.
 */
public interface ServiceConsumer<T> {
    public void dataArrived(List<T> itemList);
}
