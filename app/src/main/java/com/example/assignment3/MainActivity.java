package com.example.assignment3;

import android.net.Uri;
import android.os.Bundle;

import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.assignment3.fragments.about;
import com.example.assignment3.fragments.contact;
import com.example.assignment3.fragments.help;
import com.example.assignment3.fragments.primary;
import com.example.assignment3.fragments.send;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, primary.OnFragmentInteractionListener,
        send.OnFragmentInteractionListener, about.OnFragmentInteractionListener, contact.OnFragmentInteractionListener,
        help.OnFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();


/*
       <---------------------------Steps  + Logic ---------------------------------------->

        // Create new fragment and transaction

        // Replace whatever is in the fragment_container view with this fragment,
        // and add the transaction to the back stack


        // Commit the transaction */

        Fragment newFragment = null ;

        switch(id){
            case R.id.about:
                newFragment = new about();
                break ;
            case R.id.contact:
                newFragment = new contact();
                break ;
            case R.id.home:
                newFragment = new primary();
                break ;
            case R.id.nav_send:
                newFragment = new send();
                break ;
            case R.id.help:
                newFragment = new help();
                break ;
        }
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, newFragment);
        transaction.addToBackStack(null);
        transaction.commit();
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
