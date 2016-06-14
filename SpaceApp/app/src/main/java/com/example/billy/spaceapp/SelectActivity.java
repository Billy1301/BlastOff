package com.example.billy.spaceapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.billy.spaceapp.Communicate.CommunicateActivity;
import com.example.billy.spaceapp.Learn.LearnActivity;
import com.example.billy.spaceapp.Train.TrainActivity;

public class SelectActivity extends AppCompatActivity {

    TextView titleTextView;
    Button trainButton;
    Button learnButton;
    Button createButton;
    Button communicateButton;
    Button incentiveButton;
//    Button blankButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);
        initiateViews();
        setClickListeners();
    }

    private void initiateViews(){
        titleTextView = (TextView) findViewById(R.id.select_title_textView_id);
        trainButton = (Button) findViewById(R.id.select_train_button_id);
        learnButton = (Button) findViewById(R.id.select_learn_button_id);
        createButton = (Button) findViewById(R.id.select_create_button_id);
        communicateButton = (Button) findViewById(R.id.select_communicate_button_id);
        incentiveButton = (Button) findViewById(R.id.select_incentive_button_id);
//        blankButton = (Button) findViewById(R.id.select_blank_button_id);
    }

    private void setClickListeners(){
        trainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SelectActivity.this, TrainActivity.class);
                startActivity(intent);
            }
        });

        learnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SelectActivity.this, LearnActivity.class);
                startActivity(intent);
            }
        });

        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SelectActivity.this, CreateActivity.class);
                startActivity(intent);
            }
        });

        communicateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SelectActivity.this, CommunicateActivity.class);
                startActivity(intent);
            }
        });

        incentiveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SelectActivity.this, IncentiveActivity.class);
                startActivity(intent);
            }
        });
    }


}
