package com.safkanyazilim.quizapp.presentation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.safkanyazilim.quizapp.R;
import com.safkanyazilim.quizapp.business.ServiceConsumer;
import com.safkanyazilim.quizapp.models.Question;

import java.util.List;

public class MainActivity extends AppCompatActivity implements ServiceConsumer<Question> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void startQuiz(View view) {
        Intent intent = new Intent(this, QuestionActivity.class);
        startActivity(intent);
    }

    @Override
    public void dataArrived(List<Question> itemList) {
        //Do nothing
    }
}
