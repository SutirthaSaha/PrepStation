package com.example.dell.prepstation;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MyProfileActivity extends AppCompatActivity {
    private String toolbarTitle;
    private TabLayout tabLayoutMyProfile;
    private ViewPager viewPagerMyProfile;
    private ViewPagerAdapter viewPagerAdapter;
    private android.support.v7.widget.Toolbar jobPlacementToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);

        toolbarTitle="My Profile";

        jobPlacementToolbar=findViewById(R.id.myProfileToolbar);
        jobPlacementToolbar.setTitle(toolbarTitle);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tabLayoutMyProfile=findViewById(R.id.tabLayoutMyProfile);
        viewPagerMyProfile=findViewById(R.id.viewPagerMyProfile);

        viewPagerAdapter=new ViewPagerAdapter(getSupportFragmentManager());

        viewPagerAdapter.addFragments(new JobOverviewFragment(),"Personal");
        viewPagerAdapter.addFragments(new JobOverviewFragment(),"Academic");
        viewPagerAdapter.addFragments(new JobOverviewFragment(),"Skills");
        viewPagerAdapter.addFragments(new JobOverviewFragment(),"Personality");

        viewPagerMyProfile.setAdapter(viewPagerAdapter);
        tabLayoutMyProfile.setupWithViewPager(viewPagerMyProfile);
    }
}
