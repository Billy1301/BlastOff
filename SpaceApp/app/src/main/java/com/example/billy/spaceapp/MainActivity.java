package com.example.billy.spaceapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    CoordinatorLayout coordinatorLayout;
    ImageView userImage;
    Button launchButton;
    TextView title;
    private static final int REQUEST_TAKE_PHOTO = 1888;
    SharedPreferences sharedPreferences;
    Bitmap photo;
    public static final String IMAGE_CODE = "IMAGE CODE";
    Context context;


    private final static String CAPTURED_PHOTO_PATH_KEY = "mCurrentPhotoPath";
    private final static String CAPTURED_PHOTO_URI_KEY = "mCapturedImageURI";

    // Required for camera operations in order to save the image file on resume.
    private String mCurrentPhotoPath = null;
    private Uri mCapturedImageURI = null;



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
        context = MainActivity.this;
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
                PackageManager packageManager = context.getPackageManager();
                if(packageManager.hasSystemFeature(PackageManager.FEATURE_CAMERA) == false){
                    Toast.makeText(MainActivity.this, "This device does not have a camera.", Toast.LENGTH_SHORT)
                            .show();
                    return;
                }

                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);


                if (takePictureIntent.resolveActivity(getPackageManager()) != null) {

                    File photoFile = null;
                    try {
                        photoFile = createImageFile();
                    } catch (IOException ex) {
                        // Error occurred while creating the File
                        Toast toast = Toast.makeText(MainActivity.this, "There was a problem saving the photo...", Toast.LENGTH_SHORT);
                        toast.show();
                    }
                    // Continue only if the File was successfully created
                    if (photoFile != null) {
                        Uri fileUri = Uri.fromFile(photoFile);
                        mCapturedImageURI = fileUri;
                        mCurrentPhotoPath = fileUri.getPath();
                        takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT,
                                mCapturedImageURI);
                        startActivityForResult(takePictureIntent, REQUEST_TAKE_PHOTO);

                    }
                }
            }
        });
    }


    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        if (mCurrentPhotoPath != null) {
            savedInstanceState.putString(CAPTURED_PHOTO_PATH_KEY, mCurrentPhotoPath);
        }
        if (mCapturedImageURI != null) {
            savedInstanceState.putString(CAPTURED_PHOTO_URI_KEY, mCapturedImageURI.toString());
        }
        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        if (savedInstanceState.containsKey(CAPTURED_PHOTO_PATH_KEY)) {
            mCurrentPhotoPath = savedInstanceState.getString(CAPTURED_PHOTO_PATH_KEY);
        }
        if (savedInstanceState.containsKey(CAPTURED_PHOTO_URI_KEY)) {
            mCapturedImageURI = Uri.parse(savedInstanceState.getString(CAPTURED_PHOTO_URI_KEY));
        }
        super.onRestoreInstanceState(savedInstanceState);
    }

/**
 * The activity returns with the photo.
 * @param requestCode
 * @param resultCode
 * @param data
 */
        @Override
        public void onActivityResult(int requestCode, int resultCode, Intent data) {
            if (requestCode == REQUEST_TAKE_PHOTO && resultCode == Activity.RESULT_OK) {
                addPhotoToGallery();

                // Show the full sized image.
                setFullImageFromFilePath(mCurrentPhotoPath, userImage);
                //setFullImageFromFilePath(mCurrentPhotoPath(), userImage);
            } else {
                Toast.makeText(this, "Image Capture Failed", Toast.LENGTH_SHORT)
                        .show();
            }
        }

        /**
         * Creates the image file to which the image must be saved.
         * @return
         * @throws IOException
         */
        protected File createImageFile() throws IOException {
            // Create an image file name
            String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String imageFileName = "JPEG_" + timeStamp + "_";
            File storageDir = Environment.getExternalStoragePublicDirectory(
                    Environment.DIRECTORY_PICTURES);
            File image = File.createTempFile(
                    imageFileName,  /* prefix */
                    ".jpg",         /* suffix */
                    storageDir      /* directory */
            );

            // Save a file: path for use with ACTION_VIEW intents
            mCurrentPhotoPath = "file:" + image.getAbsolutePath();
            return image;
        }

        /**
         * Add the picture to the photo gallery.
         * Must be called on all camera images or they will
         * disappear once taken.
         */
        protected void addPhotoToGallery() {
            Intent mediaScanIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
            File f = new File(mCurrentPhotoPath);
            Uri contentUri = Uri.fromFile(f);
            mediaScanIntent.setData(contentUri);
            this.sendBroadcast(mediaScanIntent);
        }


        /**
         * Scale the photo down and fit it to our image views.
         *
         * "Drastically increases performance" to set images using this technique.
         * Read more:http://developer.android.com/training/camera/photobasics.html
         */
        private void setFullImageFromFilePath(String imagePath, ImageView imageView) {
            // Get the dimensions of the View
            int targetW = imageView.getWidth();
            int targetH = imageView.getHeight();

            // Get the dimensions of the bitmap
            BitmapFactory.Options bmOptions = new BitmapFactory.Options();
            bmOptions.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(imagePath, bmOptions);
            int photoW = bmOptions.outWidth;
            int photoH = bmOptions.outHeight;

            // Determine how much to scale down the image
            int scaleFactor = Math.min(photoW/targetW, photoH/targetH);

            // Decode the image file into a Bitmap sized to fill the View
            bmOptions.inJustDecodeBounds = false;
            bmOptions.inSampleSize = scaleFactor;
            bmOptions.inPurgeable = true;

            Bitmap bitmap = BitmapFactory.decodeFile(imagePath, bmOptions);
            imageView.setImageBitmap(bitmap);
        }


//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        if (requestCode == REQUEST_TAKE_PHOTO && resultCode == RESULT_OK) {
//            userImage.setImageBitmap(null);
//            photo = (Bitmap) data.getExtras().get("data");
//            userImage.setImageBitmap(photo);
//            userImage.setScaleX(3.5f);
//            userImage.setScaleY(2.5f);
//        }
//    }

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
