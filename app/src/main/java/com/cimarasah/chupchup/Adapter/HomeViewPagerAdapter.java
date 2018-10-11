package com.cimarasah.chupchup.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.cimarasah.chupchup.Fragment.DebitFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by c.de.sa.oliveira on 21/08/2018.
 */

public class HomeViewPagerAdapter extends FragmentPagerAdapter{

    private final List<Fragment> listFragment = new ArrayList<>();
    private final List<String> listTitles = new ArrayList<>();

    public HomeViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return listFragment.get(position);
    }

    @Override
    public int getCount() {
        return listTitles.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return listTitles.get(position);
    }



    public void AddFragment(Fragment fragment, String title){
        listFragment.add(fragment);
        listTitles.add(title);
    }
}
