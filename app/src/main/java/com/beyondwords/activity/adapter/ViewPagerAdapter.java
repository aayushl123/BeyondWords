package com.beyondwords.activity.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.beyondwords.fragment.AgeFragment;
import com.beyondwords.fragment.ConcernFragment1;
import com.beyondwords.fragment.ConcernFragment2;
import com.beyondwords.fragment.EtnicityFragment;
import com.beyondwords.fragment.InitialFragment;
import com.beyondwords.fragment.LanguageFragment;
import com.beyondwords.fragment.Phase1Info;
import com.beyondwords.fragment.Phase2Info;
import com.beyondwords.fragment.Phase3Info;
import com.beyondwords.fragment.ProfessionalInfo1Fragment;
import com.beyondwords.fragment.ProfessionalInfo2Fragment;
import com.beyondwords.fragment.ReligionFragment;
import com.beyondwords.fragment.SocioFragment;
import com.beyondwords.fragment.GenderFragment;
import com.beyondwords.fragment.CitizenFragment;
import com.beyondwords.fragment.CountryFragment;

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
                return new Phase1Info();
            case 1:
                return new GenderFragment(); //ChildFragment1 at position 0
            case 2:
                return new AgeFragment(); //ChildFragment1 at position 0
            case 3:
                return new CitizenFragment(); //ChildFragment2 at position 1
            case 4:
                return new CountryFragment(); //ChildFragment3 at position 2
            case 5:
                return new LanguageFragment(); //ChildFragment3 at position 3
            case 6:
                return new EtnicityFragment(); //childFragment4 at position 4
            case 7:
                return new ReligionFragment(); //childFragment4 at position 4
            case 8:
                return new SocioFragment(); //childFragment4 at position 4
            case 9:
                return new ProfessionalInfo1Fragment(); //childFragment4 at position 4
            case 10:
                return new ProfessionalInfo2Fragment(); //childFragment4 at position 4
            case 11:
                return new Phase2Info(); //childFragment4 at position 4

            case 12:
                return new ConcernFragment1(); //childFragment4 at position 4

            case 13:
                return new Phase3Info();
            case 14:
                return new ConcernFragment2(); //childFragment4 at position 4\

        }
        return null; //does not happen
    }

    @Override
    public int getCount() {
        return 15; //five fragments
    }
}
