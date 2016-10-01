package com.safkanyazilim.quizapp.business;

import com.safkanyazilim.quizapp.data.DataConsumer;
import com.safkanyazilim.quizapp.data.DataRetriever;
import com.safkanyazilim.quizapp.dependencyinjection.ObjectsRepo;
import com.safkanyazilim.quizapp.models.Question;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by elif on 27.06.2016.
 */
public class QuestionService implements ServiceProvider<Question>, DataConsumer {
    private List<ServiceConsumer> consumerList;

    private DataRetriever dataRetriever;

    public QuestionService() {
        this.consumerList = new LinkedList<>();
        this.dataRetriever = ObjectsRepo.getDataRetriever();
        this.dataRetriever.addDataConsumer(this);
    }
    @Override
    public void addServiceConsumer(ServiceConsumer<Question> consumer) {
        this.consumerList.add(consumer);
    }

    @Override
    public void retrieveData() {
        this.dataRetriever.retrieveQuestions();
    }

    public void notifyConsumers(List<Question> questionList) {
        for(ServiceConsumer consumer : consumerList) {
            consumer.dataArrived(questionList);
        }
    }

    @Override
    public void questionsArrived(List<Question> questionList) {
        this.notifyConsumers(questionList);
    }
}
