package com.example.billy.spaceapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    CoordinatorLayout coordinatorLayout;
    ImageView userImage;
    Button launchButton;
    TextView title;
    private static final int CAMERA_REQUEST = 1888;
    SharedPreferences sharedPreferences;
    Bitmap photo;
    public static final String IMAGE_CODE = "IMAGE CODE";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instantiateViews();
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        setLaunchButton();
        setCamera();
    }

    private void instantiateViews() {
        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.frame_layout_main);
        userImage = (ImageView) findViewById(R.id.user_image_main);
        launchButton = (Button) findViewById(R.id.main_launch_button_id);
        title = (TextView) findViewById(R.id.main_title_text);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "scribble_box_font.ttf");
        title.setTypeface(typeface);
    }

    private void setLaunchButton() {
        launchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SelectActivity.class);
                startActivity(intent);
            }
        });
    }

    private void setCamera() {
        coordinatorLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
                    startActivityForResult(takePictureIntent, CAMERA_REQUEST);
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CAMERA_REQUEST && resultCode == RESULT_OK) {
            userImage.setImageBitmap(null);
            photo = (Bitmap) data.getExtras().get("data");
            userImage.setImageBitmap(photo);
            userImage.setScaleX(3.5f);
            userImage.setScaleY(2.5f);
        }
    }

//    @Override
//    protected void onPause() {
//        super.onPause();
//        if (photo != null) {
//            ByteArrayOutputStream baos = new ByteArrayOutputStream();
//            photo.compress(Bitmap.CompressFormat.JPEG, 100, baos);
//            byte[] b = baos.toByteArray();
//
//            String encodedImage = Base64.encodeToString(b, Base64.DEFAULT);
//            SharedPreferences.Editor editor = sharedPreferences.edit();
//            editor.putString(IMAGE_CODE, encodedImage);
//            editor.commit();
//        }
//    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//        String previouslyEncodedImage = sharedPreferences.getString(IMAGE_CODE, "");
//
//        photo = null;
//        if( !previouslyEncodedImage.equalsIgnoreCase("") ){
//            byte[] b = Base64.decode(previouslyEncodedImage, Base64.DEFAULT);
//            photo = BitmapFactory.decodeByteArray(b, 0, b.length);
//            userImage.setImageBitmap(photo);
//            userImage.setScaleX(3.5f);
//            userImage.setScaleY(2.5f);
//        }
//    }

}
