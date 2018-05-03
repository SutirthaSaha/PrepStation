package com.example.dell.prepstation;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class DashboardActivity extends AppCompatActivity {
    private String toolbarTitle;
    private TabLayout tabLayoutDashboard;
    private ViewPager viewPagerDashboard;
    private ViewPagerAdapter viewPagerAdapter;
    private android.support.v7.widget.Toolbar dashboardToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        toolbarTitle="Dashboard";

        dashboardToolbar=findViewById(R.id.dashboardToolbar);
        dashboardToolbar.setTitle(toolbarTitle);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tabLayoutDashboard=findViewById(R.id.tabLayoutDashboard);
        viewPagerDashboard=findViewById(R.id.viewPagerDashboard);

        viewPagerAdapter=new ViewPagerAdapter(getSupportFragmentManager());

        viewPagerAdapter.addFragments(new JobOverviewFragment(),"Past Test");
        viewPagerAdapter.addFragments(new JobOverviewFragment(),"Report");

        viewPagerDashboard.setAdapter(viewPagerAdapter);
        tabLayoutDashboard.setupWithViewPager(viewPagerDashboard);
    }
}
