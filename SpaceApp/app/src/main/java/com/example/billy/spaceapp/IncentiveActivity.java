package com.example.billy.spaceapp;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class IncentiveActivity extends AppCompatActivity {

    ImageView rocketship;
    TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_incentive);

        setViews();
        makeRocketTakeOff();
    }

    private void setViews() {
        rocketship = (ImageView) findViewById(R.id.rocketship);
        title = (TextView) findViewById(R.id.incentive_textView);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "scribble_box_font.ttf");
        title.setTypeface(typeface);
    }

    private void makeRocketTakeOff() {
        rocketship.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Vibrator vibrator = (Vibrator) getApplicationContext().getSystemService(Context.VIBRATOR_SERVICE);
                vibrator.vibrate(1500);
                rocketship.animate().translationY(-5000).setDuration(4000);
            }
        });
    }
}
