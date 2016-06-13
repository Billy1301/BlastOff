package com.example.billy.spaceapp.Learn;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.example.billy.spaceapp.R;

public class LearnActivity extends AppCompatActivity {
    Toolbar toolbar;
    ViewPager viewPager;
    MyPagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn);
        toolbar = (Toolbar) findViewById(R.id.learn_toolbar_id);
        setSupportActionBar(toolbar);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.learn_tabLayout_id);
        tabLayout.addTab(tabLayout.newTab().setText(R.string.mercury));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.venus));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.earth));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.mars));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.jupiter));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.saturn));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.uranus));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.neptune));
        tabLayout.setTabGravity(TabLayout.MODE_SCROLLABLE);

        viewPager = (ViewPager) findViewById(R.id.learn_viewPager_id);
        pagerAdapter = new MyPagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(pagerAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
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
}
