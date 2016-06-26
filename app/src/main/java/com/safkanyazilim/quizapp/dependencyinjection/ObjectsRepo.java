package com.safkanyazilim.quizapp.dependencyinjection;

import com.safkanyazilim.quizapp.data.DataRetriever;

/**
 * Created by elif on 26.06.2016.
 */
public class ObjectsRepo {
    private static DataRetriever dataRetriever;

    public static void setDataRetriever(DataRetriever dataRetriever) {
        ObjectsRepo.dataRetriever = dataRetriever;
    }
    public static DataRetriever getDataRetriever(){
        return dataRetriever;
    }
}
