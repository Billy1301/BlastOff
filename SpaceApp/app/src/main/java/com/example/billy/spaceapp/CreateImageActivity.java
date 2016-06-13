package com.example.billy.spaceapp;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class CreateImageActivity extends AppCompatActivity {
    private TextView projectTitle;
    private ImageView projectImage;
    private Button hintButton;
    public final static String HINT_TITLE_KEY = "Hint_Title";
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_image);
        initializeViews();
        setFontText();
        setTitleName();
        setIntentExtraAndButton();

    }



    private void setIntentExtraAndButton(){
        if (projectTitle.getText().equals(CreateActivity.rocket)){
            setButtonClicker(hintButton, getString(R.string.rocket_hint_titleName));
        }
        if (projectTitle.getText().equals(CreateActivity.helmet)){
            setButtonClicker(hintButton, getString(R.string.helmet_hint_titleName));
        }
        if (projectTitle.getText().equals(CreateActivity.spaceSuit)){
            setButtonClicker(hintButton, getString(R.string.spaceSuit_hint_titleName));
        }

    }

    public void setButtonClicker(Button button, final String title) {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra(HINT_TITLE_KEY, title);
                startActivity(intent);
            }
        });
    }


    private void setFontText() {
        Typeface gotFont = Typeface.createFromAsset(getAssets(), "scribble_box_font.ttf");
        projectTitle.setTypeface(gotFont);
    }

    private void initializeViews(){
        projectTitle = (TextView) findViewById(R.id.createImage_title_textView_id);
        projectImage = (ImageView) findViewById(R.id.createImage_imageView_id);
        hintButton = (Button) findViewById(R.id.createImage_hint_button_id);
        intent = new Intent(CreateImageActivity.this, CreateHintActivity.class);
    }

    private void setTitleName(){
        String titleExtra = getIntent().getStringExtra(CreateActivity.TITLE_KEY);
        projectTitle.setText(titleExtra);

        if (projectTitle.getText().equals(CreateActivity.rocket)){
            projectImage.setImageResource(R.drawable.create_rocket);
        }
        if (projectTitle.getText().equals(CreateActivity.helmet)){
            projectImage.setImageResource(R.drawable.create_helmet);
        }
        if (projectTitle.getText().equals(CreateActivity.spaceSuit)){
            projectImage.setImageResource(R.drawable.space_suit_hint);
        }

    }
}
