package com.example.geoquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    /**the idx of question*/
    int questionIdx=0;

    /**boolean value for true&false button*/
    boolean buttonValue;

    /**only create the variable, instantiate in onCreate method*/
    Question question;


    /**only for the true and false buttons*/
    private View.OnClickListener booleanListener = new View.OnClickListener() {
        public void onClick(View v) {
            Button button = (Button) v;

            /**get the boolean value of button*/
            buttonValue = Boolean.valueOf(button.getText().toString());

            /**compare the user answer and the correct answer, toast the result*/
            if (buttonValue == question.getAnswer(questionIdx)) {
                Toast.makeText(MainActivity.this, R.string.correct_toast, Toast.LENGTH_LONG).show();
            }
            else {
                Toast.makeText(MainActivity.this, R.string.incorrect_toast, Toast.LENGTH_LONG).show();
            }
        }
    };

    /**for next and previous button*/
    private View.OnClickListener actionListener = new View.OnClickListener() {
        public void onClick(View v) {
            Button button = (Button) v;

            /**get button text*/
            String action = button.getText().toString();

            /**assign the int value of button, -1 as previous, 1 as next*/
            int actionCode = action.equalsIgnoreCase("previous")? -1 : 1;

            /**get the TextView for the question text*/
            TextView questionText = (TextView)getView("Q");

            /** update the question idx */
            questionIdx = (questionIdx+actionCode) % question.getSize();

            /** once questionId<0, make it to the last idx of all questions */
            if(questionIdx<0) questionIdx += question.getSize();

            /** show the question on the page */
            questionText.setText(question.getQuestion(questionIdx));


        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /** initialized question providing questions and answers */
        question = new Question(this, this);



        /** get the TextView for the question text */
        TextView questionText = (TextView)getView("Q");

        /** initialize the text view with the first question */
        questionText.setText(question.getQuestion(questionIdx));


        /** get button object and register with listener */
        Button trueButton = (Button) getView("B_true");
        Button falseButton = (Button) getView("B_false");
        Button previousButton = (Button) getView("B_previous");
        Button nextButton = (Button) getView("B_next");
        trueButton.setOnClickListener(booleanListener);
        falseButton.setOnClickListener(booleanListener);
        previousButton.setOnClickListener(actionListener);
        nextButton.setOnClickListener(actionListener);
    }

    /** get view object by string id */
    public View getView(String sID){
        int ID = getResources().getIdentifier(sID, "id", getPackageName());
        return findViewById(ID);
    }

    /** go to the cheat activity */
    public void Cheat(View view){
        /** create an intent of target activity*/
        Intent intent = new Intent(this, CheatActivity.class);
//        startActivity(intent);

        /** put the parameter to transfer*/
        intent.putExtra("questionContent", question.getQuestion(questionIdx));
        intent.putExtra("answerContent", question.getAnswer(questionIdx));
        startActivity(intent);
    }











}
