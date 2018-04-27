package com.example.dell.prepstation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class CompanyWisePlacementActivity extends AppCompatActivity {

    TextView tv;
    String toolbarTitle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_placement_gyan);

        tv=findViewById(R.id.tv);
        Intent intent = getIntent();
        tv.setText(intent.getStringExtra("CompanyNamePlacementGyan"));
        toolbarTitle=intent.getStringExtra("CompanyNamePlacementGyan");
        getSupportActionBar().setTitle(toolbarTitle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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
