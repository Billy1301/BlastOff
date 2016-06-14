package com.example.billy.spaceapp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.example.billy.spaceapp.Learn.Fragment.PlanetFragment;

public class IncentiveActivity extends AppCompatActivity {

    ImageView createBadge;
    ImageView trainBadge;
    ImageView languageBadge;
    ImageView learnBadge;
    ImageView rocketship;

    SharedPreferences sharedPreferences;

    Boolean create;
    Boolean train;
    Boolean language;
    Boolean learn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_incentive);

        setViews();
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        //getBooleans();
        //booleansCheck();

    }




    private void setViews() {
        createBadge = (ImageView) findViewById(R.id.create_badge);
        trainBadge = (ImageView) findViewById(R.id.train_badge);
        languageBadge = (ImageView) findViewById(R.id.languages_badge);
        learnBadge = (ImageView) findViewById(R.id.learn_badge);
        rocketship = (ImageView) findViewById(R.id.rocketship);
    }

    private void getBooleans() {
        create = sharedPreferences.getBoolean(CreateActivity.CREATE_BOOLEAN_CODE, create);
        language = sharedPreferences.getBoolean(CommunicateActivity.COMMUNICATE_BOOLEAN_CODE, language);
        learn = sharedPreferences.getBoolean(PlanetFragment.BOOLEAN_CODE, create);
    }

    private void booleansCheck() {
        if (create) {
            createBadge.setImageResource(R.drawable.blastoff_logo);
        }
        if (train) {
            trainBadge.setImageResource(R.drawable.blastoff_logo);
        }
        if (language) {
            languageBadge.setImageResource(R.drawable.blastoff_logo);
        }
        if (learn) {
            learnBadge.setImageResource(R.drawable.blastoff_logo);
        }
        if (train && create && language && learn) {
            rocketship.animate().translationY(5000).setDuration(3000);
        }
    }
}
