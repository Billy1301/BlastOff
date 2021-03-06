package com.example.billy.spaceapp;

import android.Manifest;
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
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
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
    String base64Image;
//    File photoFile;

    private final static String CAPTURED_PHOTO_PATH_KEY = "mCurrentPhotoPath";
    private final static String CAPTURED_PHOTO_URI_KEY = "mCapturedImageURI";

    // Required for camera operations in order to save the image file on resume.
    private String mCurrentPhotoPath = null;
    Uri mCapturedImageURI;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        instantiateViews();
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        if (sharedPreferences!=null)getSavedImage();
        setLaunchButton();
        setCamera();



//        if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
//            //takePhoto();
//            ActivityCompat.requestPermissions(MainActivity.this, new String[] { Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE }, 0);
//        }


    }

    private void instantiateViews() {
        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.frame_layout_main);
        userImage = (ImageView) findViewById(R.id.user_image_main);
        launchButton = (Button) findViewById(R.id.main_launch_button_id);
        title = (TextView) findViewById(R.id.main_title_text);
        context = MainActivity.this;
        Typeface typeface = Typeface.createFromAsset(getAssets(), "scribble_box_font.ttf");
        title.setTypeface(typeface);
//        userImage = null;
    }

//    @Override
//    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
//        if (requestCode == 0) {
//            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED
//                    && grantResults[1] == PackageManager.PERMISSION_GRANTED) {
//                setCamera();
//            }
//        }
//    }


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
            takePhoto();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        if (requestCode == 100) {
//            if (resultCode == RESULT_OK) {
                userImage.setImageURI(mCapturedImageURI);
                userImage.setScaleX(4.5f);
                userImage.setScaleY(3.5f);
                storeToSharedPreferences();

//            }
//        }


//        if (requestCode == REQUEST_TAKE_PHOTO && resultCode == RESULT_OK) {
//            //userImage.setImageBitmap(null);
//            photo = (Bitmap) data.getExtras().get("data");
//            userImage.setImageBitmap(photo);
//            userImage.setScaleX(4.5f);
//            userImage.setScaleY(3.5f);
//            //userImage.setImageURI(mCapturedImageURI);
//
//        }
    }

    @Override
    protected void onPause() {
        super.onPause();

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    private void getSavedImage(){
        String previouslyEncodedImage = sharedPreferences.getString(IMAGE_CODE, "");
        if( !previouslyEncodedImage.equalsIgnoreCase("") ){
            byte[] b = Base64.decode(previouslyEncodedImage.getBytes(), Base64.DEFAULT);
            Log.i("SAVEDIMAGE", "getSavedImage: "+previouslyEncodedImage);
            photo = BitmapFactory.decodeByteArray(b, 0, b.length);
            userImage.setImageBitmap(photo);
//            userImage.setImageURI(mCapturedImageURI);
        }

    }


    public void takePhoto() {

        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        mCapturedImageURI = Uri.fromFile(getOutputMediaFile());
        intent.putExtra(MediaStore.EXTRA_OUTPUT, mCapturedImageURI);
        startActivityForResult(intent, 100);

        //Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        //selfiePhoto = new File(Environment.getExternalStorageDirectory(),  "Pic.jpg");
        //mCapturedImageURI = Uri.fromFile(selfiePhoto);
        //intent.putExtra(MediaStore.EXTRA_OUTPUT, photo);
        //startActivityForResult(intent, REQUEST_TAKE_PHOTO);
    }

    private static File getOutputMediaFile(){
        File mediaStorageDir = new File(Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES), "BlastOff");

        if (!mediaStorageDir.exists()){
            if (!mediaStorageDir.mkdirs()){
                Log.d("MainCamera", "failed to create directory");
                return null;
            }
        }

        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        return new File(mediaStorageDir.getPath() + File.separator +
                "IMG_"+ timeStamp + ".jpg");
    }

    private void storeToSharedPreferences() {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 8;
        Bitmap bitmap = BitmapFactory.decodeFile(mCapturedImageURI.getPath(), options);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Bitmap mutableBitmap = convertToMutable(bitmap);
        mutableBitmap.setWidth(1);
        mutableBitmap.setHeight(1);
        mutableBitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] bytes = baos.toByteArray();
        base64Image = Base64.encodeToString(bytes, Base64.DEFAULT);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(IMAGE_CODE, base64Image);
        editor.commit();
        Log.i("STORE SAVED PREF", "storeToSharedPreferences: " + base64Image);
       // userImage.setImageURI(mCapturedImageURI);
        Log.i("Main","Stored image with length: " + bytes.length);
    }

    /**
     * this is to convert to larger scale
     * @param imgIn
     * @return
     */
    public static Bitmap convertToMutable(Bitmap imgIn) {
        try {
            //this is the file going to use temporally to save the bytes.
            // This file will not be a image, it will store the raw image data.
            File file = new File(Environment.getExternalStorageDirectory() + File.separator + "temp.tmp");

            //Open an RandomAccessFile
            //Make sure you have added uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"
            //into AndroidManifest.xml file
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");

            // get the width and height of the source bitmap.
            int width = imgIn.getWidth();
            int height = imgIn.getHeight();
            Bitmap.Config type = imgIn.getConfig();

            //Copy the byte to the file
            //Assume source bitmap loaded using options.inPreferredConfig = Config.ARGB_8888;
            FileChannel channel = randomAccessFile.getChannel();
            MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_WRITE, 0, imgIn.getRowBytes()*height);
            imgIn.copyPixelsToBuffer(map);
            //recycle the source bitmap, this will be no longer used.
            imgIn.recycle();
            System.gc();// try to force the bytes from the imgIn to be released

            //Create a new bitmap to load the bitmap again. Probably the memory will be available.
            imgIn = Bitmap.createBitmap(width, height, type);
            map.position(0);
            //load it back from temporary
            imgIn.copyPixelsFromBuffer(map);
            //close the temporary file and channel , then delete that also
            channel.close();
            randomAccessFile.close();

            // delete the temp file
            file.delete();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return imgIn;
    }
}
