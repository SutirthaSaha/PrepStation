package com.example.dell.prepstation;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class JobWisePlacementActivity extends AppCompatActivity {

    private String toolbarTitle;
    private TabLayout tabLayoutJobWisePlacement;
    private ViewPager viewPagerJobWisePlacement;
    private ViewPagerAdapter viewPagerAdapter;
    private android.support.v7.widget.Toolbar jobPlacementToolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_wise_placement);
        Intent intent = getIntent();
        toolbarTitle=intent.getStringExtra("JobNamePlacementGyan");

        jobPlacementToolbar=findViewById(R.id.jobPlacementToolbar);
        jobPlacementToolbar.setTitle(toolbarTitle);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tabLayoutJobWisePlacement=findViewById(R.id.tabLayoutJobWisePlacement);
        viewPagerJobWisePlacement=findViewById(R.id.viewPagerJobWisePlacement);

        viewPagerAdapter=new ViewPagerAdapter(getSupportFragmentManager());

        viewPagerAdapter.addFragments(new JobOverviewFragment(),"Overview");
        viewPagerAdapter.addFragments(new JobOverviewFragment(),"Stats");
        viewPagerAdapter.addFragments(new JobOverviewFragment(),"Career Path");
        viewPagerAdapter.addFragments(new JobOverviewFragment(),"Resources");
        viewPagerAdapter.addFragments(new JobOverviewFragment(),"Career Advise");
        viewPagerAdapter.addFragments(new JobOverviewFragment(),"Videos");
        viewPagerAdapter.addFragments(new JobOverviewFragment(),"FAQs");

        viewPagerJobWisePlacement.setAdapter(viewPagerAdapter);
        tabLayoutJobWisePlacement.setupWithViewPager(viewPagerJobWisePlacement);

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
