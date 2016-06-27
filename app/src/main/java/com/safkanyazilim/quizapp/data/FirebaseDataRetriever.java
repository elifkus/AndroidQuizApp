package com.safkanyazilim.quizapp.data;

import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;
import com.safkanyazilim.quizapp.models.Question;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by elif on 25.06.2016.
 */
public class FirebaseDataRetriever implements DataRetriever {
    public FirebaseDatabase database;
    public DatabaseReference questionsReference;

    public List<DataConsumer> dataConsumerList;

    List<Question> questionsList;

    public FirebaseDataRetriever() {
        this.dataConsumerList = new LinkedList<>();
    }

    public void init() {
        database = FirebaseDatabase.getInstance();
        questionsReference = database.getReference("questions");
    }

    @Override
    public void retrieveQuestions() {
        if (this.questionsList == null) {
            this.questionsReference.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot snapshot) {
                    GenericTypeIndicator<Map<String, Question>> type = new GenericTypeIndicator<Map<String, Question>>() {
                    };
                    Map<String, Question> questionMap = (Map<String, Question>) snapshot.getValue(type);
                    Log.i("quizapp", "Snapshot:" + snapshot.getValue().toString());
                    Log.e("quizapp", "Question map values is :" + questionMap.values());
                    Log.e("quizapp", "Question text is :" + questionMap.get("question1").text);
                    questionsList = new ArrayList<Question>(questionMap.values());
                    Log.e("quizapp", "Question text in list is :" + questionsList.get(0).text);
                    notifyConsumers(questionsList);
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Log.e("quizapp", "The read failed: " + databaseError.getMessage());
                }

            });
        } else {
            notifyConsumers(questionsList);
        }

    }

    @Override
    public void notifyConsumers(List questionsList) {
        for (DataConsumer consumer : this.dataConsumerList) {
            consumer.questionsArrived(this.questionsList);
        }
    }

    @Override
    public void addDataConsumer(DataConsumer consumer) {
        this.dataConsumerList.add(consumer);
    }
}
