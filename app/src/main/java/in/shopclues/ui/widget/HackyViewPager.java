package in.shopclues.ui.widget;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.HorizontalScrollView;

public class HackyViewPager extends ViewPager {

    private static final String LOG_TAG = HackyViewPager.class.getSimpleName();
    boolean enabled = true;
    private int childId;

    public HackyViewPager(Context context) {
        super(context);
        enabled = true;
    }

    public HackyViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        enabled = true;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        try {
            if (this.enabled) {
                boolean ret = super.onInterceptTouchEvent(ev);
                if (ret) getParent().requestDisallowInterceptTouchEvent(true);
                return ret;
            } else {
                return false;
            }

        } catch (Exception e) {
            Log.e(LOG_TAG, "onInterceptTouchEvent in Exception");
            return false;
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        try {
            if (this.enabled) {
                boolean ret = super.onTouchEvent(ev);
                if (ret) getParent().requestDisallowInterceptTouchEvent(true);
                return ret;
            } else {
                return false;
            }
        } catch (Exception e) {
            Log.e(LOG_TAG, "onTouchEvent in Exception");
            return false;
        }
    }

    @Override
    protected boolean canScroll(View v, boolean checkV, int dx, int x, int y) {
        if (v != this && (v instanceof HorizontalScrollView)) {
            return true;
        }
        return super.canScroll(v, checkV, dx, x, y);
    }

    public void setPagingEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}