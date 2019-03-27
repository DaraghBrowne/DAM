package com.example.darag.dam_app.Activities;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.darag.dam_app.CalmFragments.CalmFragment;
import com.example.darag.dam_app.EmergencyFragments.EmergencyFragment;
import com.example.darag.dam_app.HomeFragments.HomeFragment;
import com.example.darag.dam_app.MoodsFragments.MoodsFragment;
import com.example.darag.dam_app.SettingsFragments.SettingsFragment;
import com.example.darag.dam_app.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //reference to our bottom navigation view
        BottomNavigationView bottomNav = findViewById(R.id.bottom_nav);

        //pass listener to our bottom navigation
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        //HomeFragment is displayed when we open the app
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                new HomeFragment()).commit();

    }

    //react to clicks on the items
    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null; //this var will hold reference to the fragment we want to open

                    //find out by the item id which item was clicked
                    switch (item.getItemId()){
                        case R.id.nav_home:
                            selectedFragment = new HomeFragment();
                            break;
                        case R.id.nav_moods:
                            selectedFragment = new MoodsFragment();
                            break;
                        case R.id.nav_cr:
                            selectedFragment = new EmergencyFragment();
                            break;
                        case R.id.nav_breathe:
                            selectedFragment = new CalmFragment();
                            break;
                        case R.id.nav_settings:
                            selectedFragment = new SettingsFragment();
                            break;
                    }

                    //to show the fragments we created above ^
                    //pass container where we want to display our fragment in, and fragment we want to show
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            selectedFragment).commit();

                    return true; //true means we want to select the clicked item
                }
            };
}
