package com.example.android.how_smart_are_you;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int totalScore =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitButton(View v){
//        EditText answer1 =(EditText) findViewById(R.id.answer1_text);
//        String checkAnswer1 = answer1.getText().toString().toLowerCase();
//        EditText inputQuestion3= (EditText) findViewById(R.id.answer3_text);
//        String checkedAnwer3 = inputQuestion3.getText().toString().toLowerCase();
//        if (checkedAnwer3.equals("ABC".toLowerCase())){
//            totalScore+=1;
//        }
        CheckBox confirmedBox = (CheckBox) findViewById(R.id.finished_checkbox);
        if (confirmedBox.isChecked()==true){
            EditText customerName = (EditText) findViewById(R.id.name_editText);
            String player_name = customerName.getText().toString();
            EditText inputAnswer1 = findViewById(R.id.answer1_text);
            RadioButton choiceOfq2 = findViewById(R.id.radio_No);
            EditText inputAnswer3 = findViewById(R.id.answer3_text);
            EditText inputAnswer4 = findViewById(R.id.answer4_text);
            int scoreForQuestion=calculateScore(inputAnswer1,choiceOfq2,inputAnswer3,inputAnswer4);
            String Score = createResult(player_name,scoreForQuestion);
            displayMessage(Score);

        }
        else{
            Toast.makeText(this,"You need to check the box",Toast.LENGTH_SHORT).show();
        }


    }

    private int calculateScore(EditText q1,RadioButton q2, EditText q3, EditText q4){
        int score = totalScore;
        String inputOfq1 = q1.getText().toString().toLowerCase();
        if (inputOfq1.equals("Charles Babbage".toLowerCase())){
            score+=1;
        }
        RadioButton choiceOfq2 =q2.findViewById(R.id.radio_No);
        if (choiceOfq2.isChecked()){
            score+=1;
        }
        String inputOfq3 = q3.getText().toString().toLowerCase();
        if (inputOfq3.equals("Android".toLowerCase())){
            score+=1;
        }
        String inputOfq4 = q4.getText().toString().toLowerCase();
        if (inputOfq4.equals("Relative Layout".toLowerCase())|| inputOfq4.equals("RelativeLayout".toLowerCase())){
            score+=1;
        }
        return score;



    }
    public String createResult(String playerName, int scores){
        String resultMessage = ""+getString(R.string.Name)+" "+playerName;
        resultMessage+="\nTotal Score(s):"+scores;
        return resultMessage;
    }
    private void displayMessage(String message){
        TextView displayScore = (TextView) findViewById(R.id.score_text_view);
        displayScore.setText(message);
    }
}
