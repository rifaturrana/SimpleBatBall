package com.example.firstapplicatio;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class CategoryAdapter extends FragmentPagerAdapter {
    private Context mContext;
    public CategoryAdapter(Context context,FragmentManager fm) {
        super(fm);
        mContext=context;

    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if(position==0)
        {return new TeamAFragment();}
        else if(position==1)
        {
            return new TeamBFragment();
        }
        else
        {
            return null;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if (position==0)
        {
            return mContext.getString(R.string.category_A);
        }
        else
        {
            return mContext.getString(R.string.category_B);
        }
    }
}
