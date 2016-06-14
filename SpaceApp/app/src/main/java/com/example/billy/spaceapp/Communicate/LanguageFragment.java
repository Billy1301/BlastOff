package com.example.billy.spaceapp.Communicate;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.billy.spaceapp.R;

/**
 * Created by Raiders on 6/14/16.
 */
public class LanguageFragment extends Fragment {

    private String language;
    private String hello;
    private String myNameIs;
    private String iAmAstronaut;
    private String iCountry;
    private String goodbye;

    private int imageResource;

    private TextView languageTitle;
    private TextView helloText;
    private TextView myNameIsText;
    private TextView iAmAstronautText;
    private TextView iCountryText;
    private TextView goodbyeText;

    private ImageView imageView;

    public LanguageFragment() {

    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setHello(String hello) {
        this.hello = hello;
    }

    public void setMyNameIs(String myNameIs) {
        this.myNameIs = myNameIs;
    }

    public void setiAmAstronaut(String iAmAstronaut) {
        this.iAmAstronaut = iAmAstronaut;
    }

    public void setiCountry(String iCountry) {
        this.iCountry = iCountry;
    }

    public void setGoodbye(String goodbye) {
        this.goodbye = goodbye;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_language, container, false);
        languageTitle = (TextView) v.findViewById(R.id.communicate_title_textView);
        languageTitle.setText(language);
        helloText = (TextView) v.findViewById(R.id.hello_textView);
        helloText.setText(hello);
        myNameIsText = (TextView) v.findViewById(R.id.myNameIs_textView);
        myNameIsText.setText(myNameIs);
        iAmAstronautText = (TextView) v.findViewById(R.id.iAmAstronaut_textView);
        iAmAstronautText.setText(iAmAstronaut);
        iCountryText = (TextView) v.findViewById(R.id.whatCountry_textView);
        iCountryText.setText(iCountry);
        goodbyeText = (TextView) v.findViewById(R.id.goodbye_textView);
        goodbyeText.setText(goodbye);
        imageView = (ImageView) v.findViewById(R.id.communicate_imageView);
        imageView.setImageResource(imageResource);

        return v;
    }
}
