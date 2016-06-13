package com.example.billy.spaceapp.Learn.Fragment;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.billy.spaceapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PlanetFragment extends Fragment {
    String planetName;
    //    String planetImageURL;
    int planetImageResource;
    String planetDetails;

    TextView planetNameTextView;
    ImageView planetImageView;
    TextView planetDetailsTextView;
    CheckBox planetCheckBox;
    SharedPreferences sharedpreferences;
    public static final String BOOLEAN_CODE = "BOOLEAN CODE2";
    public Boolean isChecked = false;

    public PlanetFragment() {
        // Required empty public constructor
    }

    public void setPlanetName(String planetName) {
        this.planetName = planetName;
    }

    public void setPlanetImageResource(int planetImageResource) {
        this.planetImageResource = planetImageResource;
    }

    public void setPlanetDetails(String planetDetails) {
        this.planetDetails = planetDetails;
    }

//    public void setPlanetImageURL(String planetImageURL) {
//        this.planetImageURL = planetImageURL;
//    }
//
//    public ImageView getPlanetImageView() {
//        return planetImageView;
//    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_planet, container, false);
        planetNameTextView = (TextView) v.findViewById(R.id.learnFragment_planetName_textView_id);
        planetNameTextView.setText(planetName);
        planetImageView = (ImageView) v.findViewById(R.id.learnFragment_planet_imageView_id);
        planetImageView.setImageResource(planetImageResource);
        planetDetailsTextView = (TextView) v.findViewById(R.id.learnFragment_planetDetails_textView_id);
        planetDetailsTextView.setText(planetDetails);
        planetCheckBox = (CheckBox) v.findViewById(R.id.learnFragment_planet_checkbox_id);
        setChecked();
        sharedpreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putBoolean(BOOLEAN_CODE, isChecked);
        editor.commit();
        isChecked = sharedpreferences.getBoolean(BOOLEAN_CODE, isChecked);
        planetCheckBox.setChecked(isChecked);
        return v;
    }

//    @Override
//    public void onPause() {
//        super.onPause();
//        SharedPreferences.Editor editor = sharedpreferences.edit();
//        editor.putBoolean(BOOLEAN_CODE, isChecked);
//        editor.commit();
//    }

//    @Override
//    public void onResume() {
//        super.onResume();
//        isChecked = sharedpreferences.getBoolean(BOOLEAN_CODE, isChecked);
//        planetCheckBox.setChecked(isChecked);
//    }


    public void setChecked(){
        boolean checked = (planetCheckBox.isChecked());
        if (checked) {
            isChecked = true;
        } else {
            isChecked = false;
        }
    }


}
