package com.safkanyazilim.quizapp.presentation;

import android.app.Service;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.safkanyazilim.quizapp.R;
import com.safkanyazilim.quizapp.business.QuestionService;
import com.safkanyazilim.quizapp.business.ServiceConsumer;
import com.safkanyazilim.quizapp.business.ServiceProvider;
import com.safkanyazilim.quizapp.dependencyinjection.ObjectsRepo;
import com.safkanyazilim.quizapp.models.Question;
import com.safkanyazilim.quizapp.presentation.dialog.NotFoundDialogFragment;
import com.safkanyazilim.quizapp.presentation.dialog.ResultDialogFragment;

import java.util.List;

public class QuestionActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener, ServiceConsumer<Question> {
    private ServiceProvider<Question> questionService;

    private List<Question> questionList;
    private int currentIndex=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);


        //FIXME: These two lines should be in the business layer
        this.questionService = ObjectsRepo.getQuestionServiceProvider();
        this.questionService.addServiceConsumer(this);
        this.questionService.retrieveData();

        RadioGroup choicesRadioGroup = (RadioGroup)findViewById(R.id.choicesRadioGroup);
        choicesRadioGroup.setOnCheckedChangeListener(this);

    }

    private void createRadioButtons(RadioGroup radioGroup, List<String> choices) {
        for (String choice:choices) {
            RadioButton button = new RadioButton(this);
            button.setText(choice);

            radioGroup.addView(button);
        }
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

    @Override
    public void dataArrived(List<Question> questionList) {
        this.questionList = questionList;

        if (this.questionList != null && this.questionList.size() < 1) {
            NotFoundDialogFragment newFragment = new NotFoundDialogFragment();
            newFragment.show(getFragmentManager(), "notfound");
        } else {
            TextView view = (TextView) findViewById(R.id.questionText);
            view.setText(this.questionList.get(0).text);

            RadioGroup choicesRadioGroup = (RadioGroup)findViewById(R.id.choicesRadioGroup);
            this.createRadioButtons(choicesRadioGroup, this.questionList.get(0).choices);
        }



    }
}
