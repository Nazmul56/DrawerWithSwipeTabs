package com.androidbelieve.drawerwithswipetabs;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity{
    DrawerLayout mDrawerLayout;
    NavigationView mNavigationView;
    FragmentManager mFragmentManager;
    FragmentTransaction mFragmentTransaction;

    public void sendMessage(View view){
        Intent startNewActivity = new Intent(this, MessageSubmit.class);
        startActivity(startNewActivity);
    }

    public void enlarged1(View view){
        Intent startNewActivity = new Intent(this, Sales1.class);
        startActivity(startNewActivity);
    }

    public void rent1(View view){
        Intent startNewActivity = new Intent(this, Rent1.class);
        startActivity(startNewActivity);
    }

    public void rent2(View view){
        Intent startNewActivity = new Intent(this, Rent2.class);
        startActivity(startNewActivity);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

             mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
             mNavigationView = (NavigationView) findViewById(R.id.shitstuff) ;
        //Add Header to Navigation Drawer

        View header = getLayoutInflater().inflate(R.layout.header_layout,null);
        mNavigationView.addHeaderView(header);

             mFragmentManager = getSupportFragmentManager();
             mFragmentTransaction = mFragmentManager.beginTransaction();
             mFragmentTransaction.replace(R.id.containerView,new TabFragment()).commit();


             mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
             @Override
             public boolean onNavigationItemSelected(MenuItem menuItem) {
                mDrawerLayout.closeDrawers();

                 if (menuItem.getItemId() == R.id.nav_item_sent) {
                     FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
                    // fragmentTransaction.replace(R.id.containerView,new SentFragment()).commit();

                 }

                if (menuItem.getItemId() == R.id.nav_item_inbox) {
                    FragmentTransaction xfragmentTransaction = mFragmentManager.beginTransaction();
                   // xfragmentTransaction.replace(R.id.containerView,new TabFragment()).commit();
                }
                 if (menuItem.getItemId() == R.id.nav_item_location) {
                     FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
                    // fragmentTransaction.replace(R.id.containerView,new LocationFragment()).commit();

                 }

                 return false;
            }

        });


                android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
                ActionBarDrawerToggle mDrawerToggle = new ActionBarDrawerToggle(this,mDrawerLayout, toolbar,R.string.app,
                R.string.app_name);

                mDrawerLayout.setDrawerListener(mDrawerToggle);

                mDrawerToggle.syncState();

    }
}