package com.example.dell.prepstation;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private Toolbar toolbar;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            Fragment fragment=null;
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    fragment=new HomeFragment();
                    return loadFragment(fragment);

                case R.id.navigation_courses:
                    fragment=new CourseFragment();
                    return loadFragment(fragment);

                case R.id.navigation_mocktest:
                    fragment=new MockTestFragment();
                    return loadFragment(fragment);

                case R.id.navigation_placement:
                    fragment=new PlacementFragment();
                    return loadFragment(fragment);

                case R.id.navigation_interviewquestions:
                    fragment=new InterviewQuestionsFragment();
                    return loadFragment(fragment);
            }
            return false;
        }
    };

    private boolean loadFragment(Fragment fragment){
        if(fragment!=null){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,fragment).commit();
            return true;
        }
        else{
            Toast.makeText(this, "Null Frag", Toast.LENGTH_SHORT).show();
        }
        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        loadFragment(new HomeFragment());
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        drawerLayout=findViewById(R.id.drawerLayout);
        toolbar=findViewById(R.id.mainActivityToolbar);
        toolbar.setTitle("PrepStation");
        setNavigationDrawer();

    }
    private void setNavigationDrawer() {
        final NavigationView navigationView=findViewById(R.id.navigationView);
        ActionBarDrawerToggle actionBarDrawerToggle=new ActionBarDrawerToggle(MainActivity.this,drawerLayout,toolbar,R.string.drawer_open,R.string.drawer_close);

        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Toast.makeText(MainActivity.this,item.getTitle(),Toast.LENGTH_LONG).show();
                Intent navIntent;
                switch(item.getTitle().toString()){
                    case "Home":
                        navIntent=new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(navIntent);
                        break;
                    case "Dashboard":
                        navIntent=new Intent(getApplicationContext(),DashboardActivity.class);
                        startActivity(navIntent);
                        break;
                    case "My Profile":
                        navIntent=new Intent(getApplicationContext(),MyProfileActivity.class);
                        startActivity(navIntent);
                        break;
                }
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });
    }
}
