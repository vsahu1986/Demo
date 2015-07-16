package in.shopclues.ui.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import in.shopclues.sample.MainActivity;
import in.shopclues.sample.R;
import in.shopclues.ui.adapter.BooksPagerAdapter;
import in.shopclues.ui.widget.CirclePageIndicator;


public class CategoryFragment extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    ViewPager viewPager;
    CirclePageIndicator circlePageIndicator;

    public CategoryFragment() {
    }

    public static CategoryFragment newInstance(int sectionNumber) {
        CategoryFragment fragment = new CategoryFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        viewPager = (ViewPager) rootView.findViewById(R.id.book_pager);
        circlePageIndicator = (CirclePageIndicator) rootView.findViewById(R.id.circle_indicator);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewPager.setAdapter(new BooksPagerAdapter(getChildFragmentManager()));
        circlePageIndicator.setViewPager(viewPager);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        ((MainActivity) activity).onSectionAttached(
                getArguments().getInt(ARG_SECTION_NUMBER));
    }
}
