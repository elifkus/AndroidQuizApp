package com.safkanyazilim.quizapp;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

public class QuestionActivity extends FragmentActivity implements RadioGroup.OnCheckedChangeListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        RadioGroup choicesRadioGroup = (RadioGroup)findViewById(R.id.choicesRadioGroup);
        choicesRadioGroup.setOnCheckedChangeListener(this);
    }

    public void answerQuestion(View view) {
        ResultDialogFragment newFragment = new ResultDialogFragment();
        newFragment.show(getFragmentManager(), "result");
    }


    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        Button answerButton = (Button) findViewById(R.id.answerButton);
        
        if (checkedId != -1) {
            answerButton.setClickable(true);
        }
    }
}
