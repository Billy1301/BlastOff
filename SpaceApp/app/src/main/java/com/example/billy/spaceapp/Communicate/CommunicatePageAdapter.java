package com.example.billy.spaceapp.Communicate;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by Raiders on 6/14/16.
 */
public class CommunicatePageAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;
    Context context;

    public CommunicatePageAdapter(FragmentManager fm, int mNumOfTabs) {
        super(fm);
        this.mNumOfTabs = mNumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                LanguageFragment languageFragment1 = new LanguageFragment();
                languageFragment1.setLanguage("English");
                languageFragment1.setHello("Hello");
                languageFragment1.setiAmAstronaut("I am an Astronaut");
                languageFragment1.setMyNameIs("My name is");
                languageFragment1.setiCountry("What country are you from");
                languageFragment1.setGoodbye("Goodbye");
                //languageFragment1.setImageResource();
                return languageFragment1;
            case 1:
                LanguageFragment languageFragment2 = new LanguageFragment();
                languageFragment2.setLanguage("French");
                languageFragment2.setHello("Bonjour");
                languageFragment2.setiAmAstronaut("Je suis un astronaute");
                languageFragment2.setMyNameIs("Mon nom est");
                languageFragment2.setiCountry("De quel pays êtes vous");
                languageFragment2.setGoodbye("Au revoir");
                //languageFragment2.setImageResource();
                return languageFragment2;
            case 2:
                LanguageFragment languageFragment3 = new LanguageFragment();
                languageFragment3.setLanguage("Spanish");
                languageFragment3.setHello("Hola");
                languageFragment3.setiAmAstronaut("Soy un astronauta");
                languageFragment3.setMyNameIs("Me llamo");
                languageFragment3.setiCountry("De qué país eres");
                languageFragment3.setGoodbye("Adiós");
                //languageFragment3.setImageResource();
                return languageFragment3;
            case 3:
                LanguageFragment languageFragment4 = new LanguageFragment();
                languageFragment4.setLanguage("Japanese");
                languageFragment4.setHello("こんにちは (Kon'nichiwa)");
                languageFragment4.setiAmAstronaut("私はastonautです (Watashi wa astonautdesu)");
                languageFragment4.setMyNameIs("私の名前は (Watashinonamaeha)");
                languageFragment4.setiCountry("あなたはどこの国からのものである (Anata wa doko no kuni kara no monodearu)");
                languageFragment4.setGoodbye("さようなら (Sayōnara)");
                //languageFragment4.setImageResource();
                return languageFragment4;
            case 4:
                LanguageFragment languageFragment5 = new LanguageFragment();
                languageFragment5.setLanguage("German");
                languageFragment5.setHello("Hallo");
                languageFragment5.setiAmAstronaut("Ich bin ein Astronaut");
                languageFragment5.setMyNameIs("Ich heiße");
                languageFragment5.setiCountry("Aus welchem Land kommst du");
                languageFragment5.setGoodbye("Auf Wiedersehen");
                //languageFragment5.setImageResource();
                return languageFragment5;
            case 5:
                LanguageFragment languageFragment6 = new LanguageFragment();
                languageFragment6.setLanguage("Russian");
                languageFragment6.setHello("Здравствуйте (Zdravstvuyte)");
                languageFragment6.setiAmAstronaut("Я космонавтом (YA kosmonavtom)");
                languageFragment6.setMyNameIs("Меня зовут (Menya zovut)");
                languageFragment6.setiCountry("Из какой ты страны (Iz kakoy ty strany)");
                languageFragment6.setGoodbye("Прощай (Proshchay)");
                //languageFragment6.setImageResource();
                return languageFragment6;
        }

        return null;
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
