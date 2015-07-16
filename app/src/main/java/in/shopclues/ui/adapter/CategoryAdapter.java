package in.shopclues.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import in.shopclues.ui.fragments.CategoryFragment;

public class CategoryAdapter extends FragmentStatePagerAdapter {
    int number;

    String string[] = new String[]{"Fiction","Business","Epic"};

    public CategoryAdapter(FragmentManager fm, int number) {
        super(fm);
        this.number = number;
    }

    @Override
    public int getCount() {
        return number;
    }

    @Override
    public Fragment getItem(int position) {

        return CategoryFragment.newInstance(position);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return string[position];
    }
}