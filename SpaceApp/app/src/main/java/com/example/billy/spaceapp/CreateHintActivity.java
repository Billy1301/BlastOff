package com.example.billy.spaceapp;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class CreateHintActivity extends AppCompatActivity {
    TextView titleTextView;
    TextView nameTextView;
    private ImageView hintImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_hint);
        initializeViews();
        setFontText();
        setTitleAndHintInfo();

    }

    private void setTitleAndHintInfo(){
        String titleExtra = getIntent().getStringExtra(CreateImageActivity.HINT_TITLE_KEY);
        titleTextView.setText(titleExtra);

        if (titleTextView.getText().equals(getString(R.string.rocket_hint_titleName))){
            nameTextView.setText(getString(R.string.rocket_instructions));
            hintImage.setImageResource(R.drawable.rocketexample);
        }
        if (titleTextView.getText().equals(getString(R.string.helmet_hint_titleName))){
            nameTextView.setText(getString(R.string.helmet_instructions));
            hintImage.setImageResource(R.drawable.helmet_hint);
        }
        if (titleTextView.getText().equals(getString(R.string.spaceSuit_hint_titleName))){
            nameTextView.setText(getString(R.string.space_suit_instructions));
            hintImage.setImageResource(R.drawable.space_suit_hint);
        }
    }

    private void setFontText() {
        Typeface gotFont = Typeface.createFromAsset(getAssets(), "scribble_box_font.ttf");
        titleTextView.setTypeface(gotFont);
    }

    private void initializeViews(){
        titleTextView = (TextView) findViewById(R.id.createHint_title_textView_id);
        nameTextView = (TextView) findViewById(R.id.createHint_info_textView_id);
        hintImage = (ImageView) findViewById(R.id.create_hint_image);

    }
}
