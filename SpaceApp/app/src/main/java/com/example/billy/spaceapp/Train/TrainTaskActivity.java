package com.example.billy.spaceapp.Train;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.webkit.WebView;
import android.widget.TextView;

import com.example.billy.spaceapp.R;

public class TrainTaskActivity extends AppCompatActivity {

    TextView titleTextView;
    TextView skillsTextView;
    TextView suppliesTextView;
    TextView instructionsTextView;

    WebView webView;

    Toolbar toolbar;

    String title;
    String skills;
    String instructions;
    String supplies;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_traintaskactivity);

        initializeViews();
        //setToolbar();
        getIntents();
        setTextViews();
    }

    private void initializeViews(){
        toolbar = (Toolbar) findViewById(R.id.train_toolbar);
        titleTextView = (TextView) findViewById(R.id.trainTask_title_textView_id);
        skillsTextView = (TextView) findViewById(R.id.trainTask_skills);
        instructionsTextView = (TextView) findViewById(R.id.traintask_instruction_textview);
        suppliesTextView = (TextView) findViewById(R.id.traintask_supplies_textview);
        skillsTextView = (TextView) findViewById(R.id.trainTask_skills);
        webView = (WebView) findViewById(R.id.traintask_webview);
    }

    private void setToolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.app_name);
    }

    private void getIntents() {
        String base;
        String crew;
        String mission;
        if ((base = getIntent().getStringExtra(com.example.billy.spaceapp.Train.TrainActivity.CODE_TITLE_BASE)) != null) {
            title= getIntent().getStringExtra(com.example.billy.spaceapp.Train.TrainActivity.CODE_TITLE_BASE);
            skills = getIntent().getStringExtra(com.example.billy.spaceapp.Train.TrainActivity.CODE_SKILLS_BASE);
            supplies = getIntent().getStringExtra(com.example.billy.spaceapp.Train.TrainActivity.CODE_SUPPLIES_BASE);
            instructions = getIntent().getStringExtra(com.example.billy.spaceapp.Train.TrainActivity.CODE_INSTRUCTIONS_BASE);
            webView.loadUrl("https://youtu.be/s6tVH6E-iMw");
        } else if ((crew = getIntent().getStringExtra(com.example.billy.spaceapp.Train.TrainActivity.CODE_TITLE_CREW)) != null) {
            title= getIntent().getStringExtra(com.example.billy.spaceapp.Train.TrainActivity.CODE_TITLE_CREW);
            skills = getIntent().getStringExtra(com.example.billy.spaceapp.Train.TrainActivity.CODE_SKILLS_CREW);
            supplies = getIntent().getStringExtra(com.example.billy.spaceapp.Train.TrainActivity.CODE_SUPPLIES_CREW);
            instructions = getIntent().getStringExtra(com.example.billy.spaceapp.Train.TrainActivity.CODE_INSTRUCTIONS_CREW);
            webView.loadUrl("https://youtu.be/CPdtQp5lWrM");
        } else if ((mission = getIntent().getStringExtra(com.example.billy.spaceapp.Train.TrainActivity.CODE_TITLE_MISSION)) != null) {
            title= getIntent().getStringExtra(com.example.billy.spaceapp.Train.TrainActivity.CODE_TITLE_MISSION);
            skills = getIntent().getStringExtra(com.example.billy.spaceapp.Train.TrainActivity.CODE_SKILLS_MISSION);
            supplies = getIntent().getStringExtra(com.example.billy.spaceapp.Train.TrainActivity.CODE_SUPPLIES_MISSION);
            instructions = getIntent().getStringExtra(com.example.billy.spaceapp.Train.TrainActivity.CODE_INSTRUCTIONS_MISSION);
            webView.loadUrl("https://youtu.be/MeWC3E0b7Zw");
        }
    }

    private void setTextViews() {
        titleTextView.setText(title);
        skillsTextView.setText(skills);
        instructionsTextView.setText(instructions);
        suppliesTextView.setText(supplies);
//        Typeface typeface = Typeface.createFromAsset(getAssets(), "scribble_box_font.ttf");
//        titleTextView.setTypeface(typeface);
    }
}
