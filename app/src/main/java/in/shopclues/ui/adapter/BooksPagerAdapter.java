package in.shopclues.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import in.shopclues.ui.fragments.BooksFragment;


public class BooksPagerAdapter extends FragmentPagerAdapter {


    public BooksPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {
        return 8;
    }

    @Override
    public Fragment getItem(int position) {
        return BooksFragment.newInstance(position);
    }

}