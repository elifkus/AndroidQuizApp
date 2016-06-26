package com.safkanyazilim.quizapp.data;

import com.safkanyazilim.quizapp.models.Question;

import java.util.List;

/**
 * Created by elif on 26.06.2016.
 */
public interface DataConsumer {
    void questionsArrived(List<Question> questionList);
}
