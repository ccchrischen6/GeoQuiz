package com.example.geoquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private View.OnClickListener buttonListener = new View.OnClickListener() {
        public void onClick(View v) {
            Button button = (Button) v;
            char buttonValue = button.getText().charAt(0);
            System.out.println("Listener started");
            if (buttonValue == 'T') {
                Toast.makeText(MainActivity.this, R.string.correct_toast, Toast.LENGTH_LONG).show();
            }
            if (buttonValue == 'F') {
                Toast.makeText(MainActivity.this, R.string.incorrect_toast, Toast.LENGTH_LONG).show();
            }

            if (buttonValue == "N"){

            }

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button trueButton = (Button) viewObj("B-t");
        Button falseButton = (Button) viewObj("B-f");
        trueButton.setOnClickListener(buttonListener);
        falseButton.setOnClickListener(buttonListener);
    }

    private View viewObj(String sID){
        int ID = getResources().getIdentifier(sID, "id", getPackageName());
        return findViewById(ID);
    }




}
