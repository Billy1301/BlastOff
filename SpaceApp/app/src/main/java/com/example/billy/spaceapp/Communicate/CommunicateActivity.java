package com.example.billy.spaceapp.Communicate;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.billy.spaceapp.R;

public class CommunicateActivity extends AppCompatActivity {

    //region textViews
    TextView hello;
    TextView name;
    TextView astronaut;
    TextView country;
    TextView goodbye;
    TextView title;
    //endregion textViews

    //region pictures
    ImageView image1;
    ImageView image2;
    ImageView image3;
    ImageView image4;
    ImageView image5;
    //endregion pictures

    //region buttons
    Button english;
    Button french;
    Button spanish;
    Button german;
    Button japanese;
    Button russian;
    //endregion buttons

    //region image array
    int[] englishpics;
    int[] frenchpics;
    int[] spanishpics;
    int[] germanpics;
    int[] japanesepics;
    int[] russianpics;
    //endregion image array

    //region string array
    String[] englishStrings;
    String[] frenchStrings;
    String[] spanishStrings;
    String[] germanStrings;
    String[] japaneseStrings;
    String[] russianStrings;
    //endregion string array

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_communicate);

        setViews();
        setToolbar();
        setImageArrays();
        setPhraseArrays();
        setOnClickListerners(english, englishStrings, englishpics);
        setOnClickListerners(french, frenchStrings, frenchpics);
        setOnClickListerners(spanish, spanishStrings, spanishpics);
        setOnClickListerners(german, germanStrings, germanpics);
        setOnClickListerners(japanese, japaneseStrings, japanesepics);
        setOnClickListerners(russian, russianStrings, russianpics);
    }

    private void setViews() {
        hello = (TextView) findViewById(R.id.communicate_text_hello);
        name = (TextView) findViewById(R.id.communicate_text_name);
        astronaut = (TextView) findViewById(R.id.communicate_text_astronaut);
        country = (TextView) findViewById(R.id.communicate_text_country);
        goodbye = (TextView) findViewById(R.id.communicate_text_goodbye);
        title = (TextView) findViewById(R.id.communicate_title);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "scribble_box_font.ttf");
        title.setTypeface(typeface);
        image1 = (ImageView) findViewById(R.id.flag_1);
        image2 = (ImageView) findViewById(R.id.flag_2);
        image3 = (ImageView) findViewById(R.id.flag_3);
        image4 = (ImageView) findViewById(R.id.flag_4);
        image5 = (ImageView) findViewById(R.id.flag_5);
        english = (Button) findViewById(R.id.english_button);
        french = (Button) findViewById(R.id.french_button);
        spanish = (Button) findViewById(R.id.spanish_button);
        german = (Button) findViewById(R.id.german_button);
        japanese = (Button) findViewById(R.id.japanese_button);
        russian = (Button) findViewById(R.id.russian_button);
        toolbar = (Toolbar) findViewById(R.id.communicate_toolbar);
    }

    private void setToolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.app_name);
    }

    private void setOnClickListerners(Button button, final String[] phrases, final int[] image) {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hello.setText(phrases[0]);
                name.setText(phrases[1]);
                astronaut.setText(phrases[2]);
                country.setText(phrases[3]);
                goodbye.setText(phrases[4]);

                image1.setImageResource(image[0]);
                image1.startAnimation(AnimationUtils.loadAnimation(CommunicateActivity.this, android.R.anim.fade_in));
                image2.setImageResource(image[1]);
                image2.startAnimation(AnimationUtils.loadAnimation(CommunicateActivity.this, android.R.anim.fade_in));
                image3.setImageResource(image[2]);
                image3.startAnimation(AnimationUtils.loadAnimation(CommunicateActivity.this, android.R.anim.fade_in));
                image4.setImageResource(image[3]);
                image4.startAnimation(AnimationUtils.loadAnimation(CommunicateActivity.this, android.R.anim.fade_in));
                image5.setImageResource(image[4]);
                image5.startAnimation(AnimationUtils.loadAnimation(CommunicateActivity.this, android.R.anim.fade_in));
            }
        });
    }

    private void setPhraseArrays() {
        englishStrings = new String[5];
        englishStrings[0] = getString(R.string.hello);
        englishStrings[1] = getString(R.string.my_name_is);
        englishStrings[2] = getString(R.string.i_am_an_astronaut);
        englishStrings[3] = getString(R.string.country_are_you_from);
        englishStrings[4] = getString(R.string.goodbye);

        frenchStrings = new String[5];
        frenchStrings[0] = "Bonjour";
        frenchStrings[1] = "Mon nom est";
        frenchStrings[2] = "Je suis un astronaute";
        frenchStrings[3] = "De quel pays êtes vous?";
        frenchStrings[4] = "Au revoir";

        spanishStrings = new String[5];
        spanishStrings[0] = "Hola";
        spanishStrings[1] = "Me llamo";
        spanishStrings[2] = "Soy un astronauta";
        spanishStrings[3] = "De qué país eres?";
        spanishStrings[4] = "Adiós";

        germanStrings = new String[5];
        germanStrings[0] = "Hallo";
        germanStrings[1] = "Ich heiße";
        germanStrings[2] = "Ich bin ein Astronaut";
        germanStrings[3] = "Aus welchem Land kommst du?";
        germanStrings[4] = "Auf Wiedersehen";

        japaneseStrings = new String[5];
        japaneseStrings[0] = "こんにちは (Kon'nichiwa)";
        japaneseStrings[1] = "私の名前は (Watashinonamaeha)";
        japaneseStrings[2] = "私はastonautです (Watashi wa astonautdesu)";
        japaneseStrings[3] = "あなたはどこの国からのものである？(Anata wa doko no kuni kara no monodearu?)";
        japaneseStrings[4] = "さようなら (Sayōnara)";

        russianStrings = new String[5];
        russianStrings[0] = "Здравствуйте (Zdravstvuyte)";
        russianStrings[1] = "Меня зовут (Menya zovut)";
        russianStrings[2] = "Я космонавтом (YA kosmonavtom)";
        russianStrings[3] = "Из какой ты страны? (Iz kakoy ty strany?)";
        russianStrings[4] = "Прощай (Proshchay)";
    }

    private void setImageArrays() {
        englishpics = new int[5];
        englishpics[0] = 0;
        englishpics[1] = R.drawable.uk;
        englishpics[2] = R.drawable.us;
        englishpics[3] = R.drawable.canada;
        englishpics[4] = 0;

        frenchpics = new int[5];
        frenchpics[0] = 0;
        frenchpics[1] = R.drawable.belgium;
        frenchpics[2] = R.drawable.france;
        frenchpics[3] = R.drawable.canada;
        frenchpics[4] = 0;

        spanishpics = new int[5];
        spanishpics[0] = 0;
        spanishpics[1] = 0;
        spanishpics[2] = R.drawable.spain;
        spanishpics[3] = 0;
        spanishpics[4] = 0;

        germanpics = new int[5];
        germanpics[0] = 0;
        germanpics[1] = 0;
        germanpics[2] = R.drawable.germany;
        germanpics[3] = 0;
        germanpics[4] = 0;

        japanesepics = new int[5];
        japanesepics[0] = 0;
        japanesepics[1] = 0;
        japanesepics[2] = R.drawable.japan;
        japanesepics[3] = 0;
        japanesepics[4] = 0;

        russianpics = new int[5];
        russianpics[0] = 0;
        russianpics[1] = 0;
        russianpics[2] = R.drawable.russia;
        russianpics[3] = 0;
        russianpics[4] = 0;
    }
}
