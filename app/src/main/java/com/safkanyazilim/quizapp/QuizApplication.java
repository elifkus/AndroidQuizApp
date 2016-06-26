package com.safkanyazilim.quizapp;

import android.app.Application;
import android.util.Log;

import com.safkanyazilim.quizapp.data.DataConsumer;
import com.safkanyazilim.quizapp.data.DataRetriever;
import com.safkanyazilim.quizapp.data.FirebaseDataRetriever;
import com.safkanyazilim.quizapp.dependencyinjection.ObjectsRepo;

/**
 * Created by elif on 26.06.2016.
 */
public class QuizApplication extends Application {
    @Override
    public void onCreate()
    {
        super.onCreate();
        init();

        Log.i("quizapp", "Application onCreate called");
    }

    private void init() {
        this.initDataRetriever();
    }

    private void initDataRetriever() {
        FirebaseDataRetriever dataRetriever = new FirebaseDataRetriever();
        dataRetriever.init();

        ObjectsRepo.setDataRetriever(dataRetriever);
    }

}
