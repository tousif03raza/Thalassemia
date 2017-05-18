package com.example.thalassemia.Adapters;

import android.app.FragmentManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by Tousif on 12/31/2016.
 */
public class TabAdapter extends FragmentPagerAdapter {
    ArrayList<Fragment> fragmentList;
    ArrayList<String> titleList;
    public TabAdapter(android.support.v4.app.FragmentManager fragmentManager,ArrayList<Fragment> fragmentList,ArrayList<String> titleList){
        super(fragmentManager);
        this.fragmentList=fragmentList;
        this.titleList=titleList;
    }
    @Override
    public Fragment getItem(int position) {

        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titleList.get(position);
    }
}
