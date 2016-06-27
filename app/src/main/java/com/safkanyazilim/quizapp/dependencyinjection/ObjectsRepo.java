package com.safkanyazilim.quizapp.dependencyinjection;

import com.safkanyazilim.quizapp.business.ServiceConsumer;
import com.safkanyazilim.quizapp.business.ServiceProvider;
import com.safkanyazilim.quizapp.data.DataRetriever;
import com.safkanyazilim.quizapp.models.Question;

/**
 * Created by elif on 26.06.2016.
 */
public class ObjectsRepo {
    private static DataRetriever dataRetriever;
    private static ServiceProvider<Question> questionServiceProvider;

    public static void setDataRetriever(DataRetriever dataRetriever) {
        ObjectsRepo.dataRetriever = dataRetriever;
    }

    public static DataRetriever getDataRetriever(){
        return dataRetriever;
    }

    public static ServiceProvider<Question> getQuestionServiceProvider() {
        return questionServiceProvider;
    }

    public static void setQuestionServiceProvider(ServiceProvider<Question> questionServiceProvider) {
        ObjectsRepo.questionServiceProvider = questionServiceProvider;
    }
}
