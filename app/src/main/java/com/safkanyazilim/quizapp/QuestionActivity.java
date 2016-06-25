package com.safkanyazilim.quizapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

import com.safkanyazilim.quizapp.data.DataManager;

public class QuestionActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        RadioGroup choicesRadioGroup = (RadioGroup)findViewById(R.id.choicesRadioGroup);
        choicesRadioGroup.setOnCheckedChangeListener(this);

        DataManager.readData();
    }

    public void answerQuestion(View view) {
        ResultDialogFragment newFragment = new ResultDialogFragment();
        newFragment.show(getFragmentManager(), "result");
    }


    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        Button answerButton = (Button)findViewById(R.id.answerButton);

        if (checkedId != -1) {
            answerButton.setClickable(true);
        }
    }
}
