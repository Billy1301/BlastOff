package com.example.billy.spaceapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class CreateActivity extends AppCompatActivity {
    private Button rocketButton;
    private Button helmetButton;
    private Button spaceSuitButton;
    private TextView titleTextView;
    SharedPreferences sharedPreferences;
    CheckBox checkBox;
    public static final String CREATE_BOOLEAN_CODE = "BOOLEAN CODE1";
    boolean isChecked = false;
    public final static String TITLE_KEY = "TitleName";
    Intent intent;
    public static String rocket = "Rocket";
    public static String helmet = "Helmet";
    public static String spaceSuit = "Space Suit";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        initializeViews();
        setChecked();
        initializeButton();
        setFontText();

    }
    private void setFontText() {
        Typeface gotFont = Typeface.createFromAsset(getAssets(), "scribble_box_font.ttf");
        titleTextView.setTypeface(gotFont);
    }

    private void initializeButton(){
        setButtonClicker(rocketButton, rocket);
        setButtonClicker(helmetButton, helmet);
        setButtonClicker(spaceSuitButton, spaceSuit);
    }


    private void initializeViews(){
        rocketButton = (Button) findViewById(R.id.create_activity1_button_id);
        helmetButton = (Button) findViewById(R.id.create_activity2_button_id);
        spaceSuitButton = (Button) findViewById(R.id.create_activity3_button_id);
        titleTextView = (TextView) findViewById(R.id.create_activity_textView_id);
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        checkBox = (CheckBox)findViewById(R.id.create_checkbox);
        intent = new Intent(CreateActivity.this, CreateImageActivity.class);

    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(CREATE_BOOLEAN_CODE, isChecked);
        editor.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
        isChecked = sharedPreferences.getBoolean(CREATE_BOOLEAN_CODE, isChecked);
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

    public void setButtonClicker(Button button, final String title) {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                intent.putExtra(TITLE_KEY, title);
                startActivity(intent);
            }
        });
    }
}
