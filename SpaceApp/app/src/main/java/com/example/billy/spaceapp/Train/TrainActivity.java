package com.example.billy.spaceapp.Train;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.billy.spaceapp.R;

import java.util.ArrayList;

public class TrainActivity extends AppCompatActivity {
    Button crewAssemblyButton;
    Button baseStationWalkBackButton;
    Button missionControlButton;
    TextView titleText;
    Toolbar toolbar;

    //region lists
    private ArrayList<String> suppliesCrewAssembly;
    private ArrayList<String> instructionsCrewAssembly;
    private ArrayList<String> suppliesBaseStation;
    private ArrayList<String> instructionsBaseStation;
    private ArrayList<String> suppliesMissionControl;
    private ArrayList<String> instructionsMissionControl;
    //endregion lists

    //region string
    private String crewAssemblyTitle;
    private String crewAssemblySkills;
    private String crewAssemblySupplies;
    private String crewAssemblyInstructions;
    private String baseStationTitle;
    private String baseStationSkills;
    private String baseStationSupplies;
    private String baseStationInstructions;
    private String missionControlTitle;
    private String missionControlSkills;
    private String missionControlSupplies;
    private String missionControlInstructions;
    //endregion string

    //region more strings
    public final static String CODE_SUPPLIES_CREW = "SUPPLIES CREW";
    public final static String CODE_INSTRUCTIONS_CREW = "INSTRUCTIONS CREW";
    public final static String CODE_TITLE_CREW = "TITLE CREW";
    public final static String CODE_SKILLS_CREW = "SKILLS CREW";
    public final static String CODE_SUPPLIES_BASE = "SUPPLIES BASE";
    public final static String CODE_INSTRUCTIONS_BASE = "INSTRUCTIONS BASE";
    public final static String CODE_TITLE_BASE = "TITLE BASE";
    public final static String CODE_SKILLS_BASE = "SKILLS BASE";
    public final static String CODE_SUPPLIES_MISSION = "SUPPLIES MISSION";
    public final static String CODE_INSTRUCTIONS_MISSION = "INSTRUCTIONS MISSION";
    public final static String CODE_TITLE_MISSION = "TITLE MISSION";
    public final static String CODE_SKILLS_MISSION = "SKILLS MISSION";
    //endregion more strings

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_train);

        initiateViews();
        setToolbar();
        setTitles();
        setSkills();
        setInstructions();
        setSupplies();
        setBaseStationAndIntent(baseStationTitle, baseStationSkills, baseStationSupplies, baseStationInstructions);
        setCrewAssemblyAndIntent(crewAssemblyTitle, crewAssemblySkills, crewAssemblySupplies, crewAssemblyInstructions);
        setMissionControlAndIntent(missionControlTitle, missionControlSkills, missionControlSupplies, missionControlInstructions);
    }

    private void initiateViews(){
        toolbar = (Toolbar) findViewById(R.id.train_toolbar);
        crewAssemblyButton = (Button) findViewById(R.id.train_activity1_button_id);
        baseStationWalkBackButton = (Button) findViewById(R.id.train_activity2_button_id);
        missionControlButton = (Button) findViewById(R.id.train_activity3_button_id);
        titleText = (TextView) findViewById(R.id.train_blurb_textView_id);
//        Typeface typeface = Typeface.createFromAsset(getAssets(), "scribble_box_font.ttf");
//        titleText.setTypeface(typeface);
    }

    private void setToolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.app_name);
    }

    private void setCrewAssemblyAndIntent(final String title, final String skills,
                                          final String supplies, final String instructions) {
        crewAssemblyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent trainIntent = new Intent(TrainActivity.this, com.example.billy.spaceapp.Train.TrainTaskActivity.class);
                trainIntent.putExtra(CODE_TITLE_CREW, title);
                trainIntent.putExtra(CODE_SKILLS_CREW, skills);
                trainIntent.putExtra(CODE_INSTRUCTIONS_CREW, instructions);
                trainIntent.putExtra(CODE_SUPPLIES_CREW, supplies);
                startActivity(trainIntent);
            }
        });
    }

    private void setBaseStationAndIntent(final String title, final String skills,
                                         final String supplies, final String instructions) {
        baseStationWalkBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent trainIntent = new Intent(TrainActivity.this, com.example.billy.spaceapp.Train.TrainTaskActivity.class);
                trainIntent.putExtra(CODE_TITLE_BASE, title);
                trainIntent.putExtra(CODE_SKILLS_BASE, skills);
                trainIntent.putExtra(CODE_INSTRUCTIONS_BASE, instructions);
                trainIntent.putExtra(CODE_SUPPLIES_BASE, supplies);
                startActivity(trainIntent);
            }
        });
    }

    private void setMissionControlAndIntent(final String title, final String skills,
                                            final String supplies, final String instructions) {
        missionControlButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent trainIntent = new Intent(TrainActivity.this, com.example.billy.spaceapp.Train.TrainTaskActivity.class);
                trainIntent.putExtra(CODE_TITLE_MISSION, title);
                trainIntent.putExtra(CODE_SKILLS_MISSION, skills);
                trainIntent.putExtra(CODE_INSTRUCTIONS_MISSION, instructions);
                trainIntent.putExtra(CODE_SUPPLIES_MISSION, supplies);
                startActivity(trainIntent);
            }
        });
    }

    private void setTitles() {
        crewAssemblyTitle = getString(R.string.crew_assembly);
        baseStationTitle = getString(R.string.base_station_walk);
        missionControlTitle = getString(R.string.mission_control);
    }

    private void setSkills() {
        crewAssemblySkills = getString(R.string.skills_crew);
        baseStationSkills = getString(R.string.skills_base);
        missionControlSkills = getString(R.string.skills_mission);
    }

    private void setSupplies() {
        baseStationSupplies = " No supplies needed";
        crewAssemblySupplies = "Gardening Gloves\n Rubber Gloves\n Puzzle";
        missionControlSupplies = "Tennis ball\n Stop Watch";
    }

    private void setInstructions() {
        baseStationInstructions = "Measure a course at distances of 400 m (¼ mi), 800 m (½ mi), 1200 m (¾ mi), 1600 m (1 mi)\n At your own pace, walk, jog, or run the measured distance.\n Start by trying to complete 400 m (¼ mi).\n Slowly work to increase the distance by 400 m (¼ mi).\n Over time, your goal should be to complete 1600 m (1 mi).\n Record observations before and after this physical experience.";
        crewAssemblyInstructions = "Wearing various gloves, put together a puzzle or task items (such as using a screwdriver to turn a screw)";
        missionControlInstructions = "Bounce a tennis ball off the wall and try to catch it while balancing on one foot.\n Raise one foot up behind you, level with your knee.\n Count how many seconds you can stand on one foot while throwing the tennis ball against the wall. Try not to let the ball, or your foot, touch the floor. Try to balance for at least 30 seconds without falling.\n Continue to practice this activity over time until you can keep your balance for 60 seconds without having to start over.";
    }
}
