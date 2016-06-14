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
}
