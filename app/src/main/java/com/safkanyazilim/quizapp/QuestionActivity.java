package com.safkanyazilim.quizapp;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;

public class QuestionActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
    }

    public void answerQuestion(View view) {
        ResultDialogFragment newFragment = new ResultDialogFragment();
        newFragment.show(getFragmentManager(), "result");
    }
}
