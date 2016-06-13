package com.example.billy.spaceapp.Train;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.billy.spaceapp.R;

import java.util.ArrayList;

public class TrainTaskActivity extends AppCompatActivity {

    TextView titleTextView;
    TextView skillsTextView;
    ListView suppliesListView;
    ListView instructionsListView;
    ArrayAdapter<String> suppliesAdapter;
    ArrayAdapter<String> instructionsAdapter;

    String title;
    String skills;
    ArrayList<String> suppliesList;
    ArrayList<String> instructionsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_traintaskactivity);

        initializeViews();
        getIntents();
        setUpArrayAdapter();
        setTextViews();
    }

    private void initializeViews(){
        titleTextView = (TextView) findViewById(R.id.trainTask_title_textView_id);
        skillsTextView = (TextView) findViewById(R.id.trainTask_skills);
        suppliesListView = (ListView) findViewById(R.id.supplies_listview);
        instructionsListView = (ListView) findViewById(R.id.instruction_listview);
    }

    private void getIntents() {
        String base;
        String crew;
        String mission;
        if ((base = getIntent().getStringExtra(com.example.billy.spaceapp.Train.TrainActivity.CODE_TITLE_BASE)) != null) {
            title= getIntent().getStringExtra(com.example.billy.spaceapp.Train.TrainActivity.CODE_TITLE_BASE);
            skills = getIntent().getStringExtra(com.example.billy.spaceapp.Train.TrainActivity.CODE_SKILLS_BASE);
            suppliesList = getIntent().getStringArrayListExtra(com.example.billy.spaceapp.Train.TrainActivity.CODE_SUPPLIES_BASE);
            instructionsList = getIntent().getStringArrayListExtra(com.example.billy.spaceapp.Train.TrainActivity.CODE_INSTRUCTIONS_BASE);
        } else if ((crew = getIntent().getStringExtra(com.example.billy.spaceapp.Train.TrainActivity.CODE_TITLE_CREW)) != null) {
            title= getIntent().getStringExtra(com.example.billy.spaceapp.Train.TrainActivity.CODE_TITLE_CREW);
            skills = getIntent().getStringExtra(com.example.billy.spaceapp.Train.TrainActivity.CODE_SKILLS_CREW);
            suppliesList = getIntent().getStringArrayListExtra(com.example.billy.spaceapp.Train.TrainActivity.CODE_SUPPLIES_CREW);
            instructionsList = getIntent().getStringArrayListExtra(com.example.billy.spaceapp.Train.TrainActivity.CODE_INSTRUCTIONS_CREW);
        } else if ((mission = getIntent().getStringExtra(com.example.billy.spaceapp.Train.TrainActivity.CODE_TITLE_MISSION)) != null) {
            title= getIntent().getStringExtra(com.example.billy.spaceapp.Train.TrainActivity.CODE_TITLE_MISSION);
            skills = getIntent().getStringExtra(com.example.billy.spaceapp.Train.TrainActivity.CODE_SKILLS_MISSION);
            suppliesList = getIntent().getStringArrayListExtra(com.example.billy.spaceapp.Train.TrainActivity.CODE_SUPPLIES_MISSION);
            instructionsList = getIntent().getStringArrayListExtra(com.example.billy.spaceapp.Train.TrainActivity.CODE_INSTRUCTIONS_MISSION);
        }
    }

    private void setUpArrayAdapter() {
        suppliesAdapter = new ArrayAdapter<String>(TrainTaskActivity.this, android.R.layout.simple_list_item_1, suppliesList);
        instructionsAdapter = new ArrayAdapter<String>(TrainTaskActivity.this, android.R.layout.simple_list_item_1, instructionsList);
        suppliesListView.setAdapter(suppliesAdapter);
        instructionsListView.setAdapter(instructionsAdapter);
    }

    private void setTextViews() {
        titleTextView.setText(title);
        skillsTextView.setText(skills);
//        Typeface typeface = Typeface.createFromAsset(getAssets(), "scribble_box_font.ttf");
//        titleTextView.setTypeface(typeface);
    }
}
