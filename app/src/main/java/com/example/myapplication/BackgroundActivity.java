package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
//import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NotificationCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Activity;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

public class BackgroundActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    NavigationView nav;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToogle;
   // Toolbar toolbar;
   // FragmentManager fragmentManager;
   // FragmentTransaction fragmentTransaction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_background);

      //  fragmentManager = getSupportFragmentManager();
        /*fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.container_fragment,new MainFragment());
        fragmentTransaction.commit();*/

        nav=findViewById(R.id.navigation);
      //  nav.setNavigationItemSelectedListener(this);
       Toolbar toolbar = findViewById(R.id.drawertoolbar);
        setSupportActionBar(toolbar);
        drawerLayout = findViewById(R.id.drawer);
        actionBarDrawerToogle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToogle);
        actionBarDrawerToogle.setDrawerIndicatorEnabled(true);
        actionBarDrawerToogle.setDrawerIndicatorEnabled(true);
        actionBarDrawerToogle.syncState();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }
}