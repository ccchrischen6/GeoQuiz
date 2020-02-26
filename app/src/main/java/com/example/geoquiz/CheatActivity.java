package com.example.geoquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class CheatActivity extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);

        /** receive the intent */
        Intent msIntent = getIntent();
        String questionContent = msIntent.getStringExtra("questionContent");
        boolean correctAnswer = msIntent.getBooleanExtra("answerContent", false);

        /** show the answer */
        textView = (TextView) getView("AnswerBoard");
        textView.setText(questionContent + "\n" + correctAnswer);
    }

    public View getView(String sID){
        int ID = getResources().getIdentifier(sID, "id", getPackageName());
        return findViewById(ID);
    }


    /** get back to main activity */
    public void Back(View view){
        startActivity(new Intent(this, MainActivity.class));
    }
}
