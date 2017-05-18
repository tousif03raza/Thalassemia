package com.example.thalassemia.Activities;

import android.app.ActionBar;
import android.app.Fragment;
import android.graphics.Typeface;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.graphics.drawable.DrawerArrowDrawable;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.TextView;
import android.widget.Toolbar;

import com.example.thalassemia.Adapters.TabAdapter;
import com.example.thalassemia.Fragments.Informaion;
import com.example.thalassemia.Fragments.Medications;
import com.example.thalassemia.Fragments.Questions;
import com.example.thalassemia.Fragments.Symptoms;
import com.example.thalassemia.Fragments.Videos;
import com.example.thalassemia.R;

import java.util.ArrayList;

public class TabActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.tabs);

        TextView txtTitle=(TextView)findViewById(R.id.txtTitle);
        txtTitle.setTypeface(Typeface.createFromAsset(this.getAssets(), "Quicksand-Regular.otf"));
        int leftDp=getResources().getDisplayMetrics().densityDpi*48;
        //txtTitle.setPadding(leftDp,0,0,0);
        txtTitle.setPadding(0, 0, 48, 0);

        android.support.v7.widget.Toolbar toolbar=(android.support.v7.widget.Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        DrawerLayout drawerLayout=(DrawerLayout)findViewById(R.id.drawerLayout);
        ActionBarDrawerToggle actionBarDrawerToggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.app_name,R.string.app_name);
        actionBarDrawerToggle.syncState();
        drawerLayout.setDrawerListener(actionBarDrawerToggle);


        ArrayList<android.support.v4.app.Fragment> fragmentList=new ArrayList<android.support.v4.app.Fragment>();
        fragmentList.add(new Informaion());
        fragmentList.add(new Medications());
        fragmentList.add(new Questions());
        fragmentList.add(new Symptoms());
        fragmentList.add(new Videos());

        ArrayList<String> titleList=new ArrayList<String>();

        titleList.add("Informtion");
        titleList.add("Medications");
        titleList.add("Questions");
        titleList.add("Symptoms");
        titleList.add("Videos");

        android.support.v4.view.ViewPager viewPager=(android.support.v4.view.ViewPager)findViewById(R.id.viewPager);
        TabAdapter tabAdapter=new TabAdapter(getSupportFragmentManager(),fragmentList,titleList);
        viewPager.setAdapter(tabAdapter);
        viewPager.requestDisallowInterceptTouchEvent(false);
        TabLayout tabLayout=(TabLayout)findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);
        for (int i=0;i<5;i++){
            tabLayout.getTabAt(i).setIcon(R.drawable.profile);
        }

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case android.R.id.home:
                ((DrawerLayout)findViewById(R.id.drawerLayout)).openDrawer(GravityCompat.START);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
