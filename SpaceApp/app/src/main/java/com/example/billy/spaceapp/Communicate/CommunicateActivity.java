package com.example.billy.spaceapp.Communicate;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.billy.spaceapp.R;

public class CommunicateActivity extends AppCompatActivity {

    Toolbar toolbar;
    ViewPager viewPager;
    CommunicatePageAdapter pageAdapter;
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_communicate);

        setViews();
        setToolbar();
        setTabLayout();
        pageAdapter = new CommunicatePageAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(pageAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        setTabListener();
    }

    private void setViews() {
        toolbar = (Toolbar) findViewById(R.id.communicate_toolbar);
    }

    private void setToolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.app_name);
        viewPager = (ViewPager) findViewById(R.id.communicate_viewPager);
        tabLayout = (TabLayout) findViewById(R.id.communicate_tabLayout);
    }

    private void setTabLayout() {
        tabLayout.addTab(tabLayout.newTab().setText(R.string.english));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.french));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.german));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.spanish));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.russian));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.japanese));
        tabLayout.setTabGravity(TabLayout.MODE_SCROLLABLE);
    }

    private void setTabListener() {
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void setPhraseArrays() {
//        englishStrings = new String[5];
//        englishStrings[0] = getString(R.string.hello);
//        englishStrings[1] = getString(R.string.my_name_is);
//        englishStrings[2] = getString(R.string.i_am_an_astronaut);
//        englishStrings[3] = getString(R.string.country_are_you_from);
//        englishStrings[4] = getString(R.string.goodbye);
//
//        frenchStrings = new String[5];
//        frenchStrings[0] = "Bonjour";
//        frenchStrings[1] = "Mon nom est";
//        frenchStrings[2] = "Je suis un astronaute";
//        frenchStrings[3] = "De quel pays êtes vous?";
//        frenchStrings[4] = "Au revoir";
//
//        spanishStrings = new String[5];
//        spanishStrings[0] = "Hola";
//        spanishStrings[1] = "Me llamo";
//        spanishStrings[2] = "Soy un astronauta";
//        spanishStrings[3] = "De qué país eres?";
//        spanishStrings[4] = "Adiós";
//
//        germanStrings = new String[5];
//        germanStrings[0] = "Hallo";
//        germanStrings[1] = "Ich heiße";
//        germanStrings[2] = "Ich bin ein Astronaut";
//        germanStrings[3] = "Aus welchem Land kommst du?";
//        germanStrings[4] = "Auf Wiedersehen";
//
//        japaneseStrings = new String[5];
//        japaneseStrings[0] = "こんにちは (Kon'nichiwa)";
//        japaneseStrings[1] = "私の名前は (Watashinonamaeha)";
//        japaneseStrings[2] = "私はastonautです (Watashi wa astonautdesu)";
//        japaneseStrings[3] = "あなたはどこの国からのものである？(Anata wa doko no kuni kara no monodearu?)";
//        japaneseStrings[4] = "さようなら (Sayōnara)";
//
//        russianStrings = new String[5];
//        russianStrings[0] = "Здравствуйте (Zdravstvuyte)";
//        russianStrings[1] = "Меня зовут (Menya zovut)";
//        russianStrings[2] = "Я космонавтом (YA kosmonavtom)";
//        russianStrings[3] = "Из какой ты страны? (Iz kakoy ty strany?)";
//        russianStrings[4] = "Прощай (Proshchay)";
    }

}
