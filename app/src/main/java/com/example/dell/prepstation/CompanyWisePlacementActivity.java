package com.example.dell.prepstation;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class CompanyWisePlacementActivity extends AppCompatActivity {

    private String toolbarTitle;
    private TabLayout tabLayoutCompanyWisePlacement;
    private ViewPager viewPagerCompanyWisePlacement;
    private ViewPagerAdapter viewPagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_wise_placement_gyan);

        Intent intent = getIntent();
        toolbarTitle=intent.getStringExtra("CompanyNamePlacementGyan");
        getSupportActionBar().setTitle(toolbarTitle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tabLayoutCompanyWisePlacement=findViewById(R.id.tabLayoutCompanyWisePlacement);
        viewPagerCompanyWisePlacement=findViewById(R.id.viewPagerCompanyWisePlacement);

        viewPagerAdapter=new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragments(new CompanyIntroductionFragment(),"Introduction");
        viewPagerAdapter.addFragments(new CompanyStatsFragment(),"Stats");
        viewPagerAdapter.addFragments(new CompanyHiringProcessFragment(),"Hiring Process");
        viewPagerAdapter.addFragments(new CompanyVideosFragment(),"Videos");
        viewPagerAdapter.addFragments(new CompanyInterviewExpFragment(),"Experience");
        viewPagerCompanyWisePlacement.setAdapter(viewPagerAdapter);
        tabLayoutCompanyWisePlacement.setupWithViewPager(viewPagerCompanyWisePlacement);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            onBackPressed();  return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
