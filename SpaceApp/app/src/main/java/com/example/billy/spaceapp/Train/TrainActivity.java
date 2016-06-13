package com.example.billy.spaceapp.Train;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.billy.spaceapp.R;

import java.util.ArrayList;

public class TrainActivity extends AppCompatActivity {
    Button crewAssemblyButton;
    Button baseStationWalkBackButton;
    Button missionControlButton;
    TextView titleText;

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
    private String baseStationTitle;
    private String baseStationSkills;
    private String missionControlTitle;
    private String missionControlSkills;
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

    SharedPreferences sharedPreferences;
    public static final String BOOLEAN_CODE = "BOOLEAN CODE";
    boolean isChecked = false;
    CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_train);

        initiateViews();
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        setChecked();
        setTitles();
        setSkills();
        setInstructions();
        setSupplies();
        setBaseStationAndIntent(baseStationTitle, baseStationSkills, suppliesBaseStation, instructionsBaseStation);
        setCrewAssemblyAndIntent(crewAssemblyTitle, crewAssemblySkills, suppliesCrewAssembly, instructionsCrewAssembly);
        setMissionControlAndIntent(missionControlTitle, missionControlSkills, suppliesMissionControl, instructionsMissionControl);
    }

    private void initiateViews(){
        crewAssemblyButton = (Button) findViewById(R.id.train_activity1_button_id);
        baseStationWalkBackButton = (Button) findViewById(R.id.train_activity2_button_id);
        missionControlButton = (Button) findViewById(R.id.train_activity3_button_id);
        titleText = (TextView) findViewById(R.id.train_blurb_textView_id);
//        Typeface typeface = Typeface.createFromAsset(getAssets(), "scribble_box_font.ttf");
//        titleText.setTypeface(typeface);
        checkBox = (CheckBox) findViewById(R.id.train_checkbox);
    }

    private void setCrewAssemblyAndIntent(final String title, final String skills,
                                          final ArrayList<String> supplies, final ArrayList<String> instructions) {
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
                                         final ArrayList<String> supplies, final ArrayList<String> instructions) {
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
                                            final ArrayList<String> supplies, final ArrayList<String> instructions) {
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
        suppliesBaseStation = new ArrayList<>();
        suppliesBaseStation.add("No supplies needed");

        suppliesCrewAssembly = new ArrayList<>();
        suppliesCrewAssembly.add("Gardening Gloves");
        suppliesCrewAssembly.add("Rubber Gloves");
        suppliesCrewAssembly.add("Puzzle");

        suppliesMissionControl = new ArrayList<>();
        suppliesMissionControl.add("Tennis ball");
        suppliesMissionControl.add("Stop Watch");
    }

    private void setInstructions() {
        instructionsBaseStation = new ArrayList<>();
        instructionsBaseStation.add("Measure a course at distances of 400 m (¼ mi), 800 m (½ mi), 1200 m (¾ mi), 1600 m (1 mi) ");
        instructionsBaseStation.add("At your own pace, walk, jog, or run the measured distance.");
        instructionsBaseStation.add("Start by trying to complete 400 m (¼ mi).");
        instructionsBaseStation.add("Slowly work to increase the distance by 400 m (¼ mi).");
        instructionsBaseStation.add("Over time, your goal should be to complete 1600 m (1 mi).");
        instructionsBaseStation.add("Record observations before and after this physical experience.");

        instructionsCrewAssembly = new ArrayList<>();
        instructionsCrewAssembly.add("Wearing various gloves, put together a puzzle or task items (such as using a screwdriver to turn a screw)");

        instructionsMissionControl = new ArrayList<>();
        instructionsMissionControl.add("Bounce a tennis ball off the wall and try to catch it while balancing on one foot.");
        instructionsMissionControl.add("Raise one foot up behind you, level with your knee.");
        instructionsMissionControl.add("Count how many seconds you can stand on one foot while throwing the tennis ball against the wall. Try not to let the ball, or your foot, touch the floor. Try to balance for at least 30 seconds without falling.");
        instructionsMissionControl.add("Continue to practice this activity over time until you can keep your balance for 60 seconds without having to start over.");
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(BOOLEAN_CODE, isChecked);
        editor.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
        isChecked = sharedPreferences.getBoolean(BOOLEAN_CODE, isChecked);
        checkBox.setChecked(isChecked);
    }

    private void setChecked() {
        boolean checked = (checkBox.isChecked());
        if (checked) {
            isChecked = true;
        } else {
            isChecked = false;
        }
    }
}
