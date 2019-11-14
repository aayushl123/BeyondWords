package com.beyondwords.activity.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.beyondwords.fragment.SurveyFragment1;
import com.beyondwords.fragment.SurveyFragment2;
import com.beyondwords.fragment.SurveyFragment3;
import com.beyondwords.fragment.SurveyFragment4;

public class ViewPagerAdapter extends FragmentPagerAdapter
         {

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:
                return new SurveyFragment1(); //ChildFragment1 at position 0
            case 1:
                return new SurveyFragment2(); //ChildFragment2 at position 1
            case 2:
                return new SurveyFragment3(); //ChildFragment3 at position 2
            case 3:
                return new SurveyFragment4(); //ChildFragment3 at position 3
        }
        return null; //does not happen
    }

    @Override
    public int getCount() {
        return 4; //three fragments
    }
}
