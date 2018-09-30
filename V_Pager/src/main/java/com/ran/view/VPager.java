package com.ran.view;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

/**
 *
 * @author Ran
 * @date 2018/9/30.
 *
 */
public class VPager extends RelativeLayout implements ViewPager.OnPageChangeListener{

    private Context mContext;
    private ViewPager mViewPager;
    private IndicatorLayout indicatorLayout;
    private LayoutParams viewPagerParams;
    private LayoutParams indicatorLayoutParams;

    public VPager(@NonNull Context context) {
        super(context);
        init(context);
    }

    public VPager(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);

    }

    public VPager(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context){
        this.mContext = context;
        mViewPager = new ViewPager(context);
        indicatorLayout = new IndicatorLayout(context);
        mViewPager.addOnPageChangeListener(this);
        viewPagerParams = new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT);
        viewPagerParams.addRule(RelativeLayout.CENTER_IN_PARENT);
        mViewPager.setLayoutParams(viewPagerParams);
        mViewPager.setBackgroundColor(Color.GRAY);
        addView(mViewPager);
        indicatorLayoutParams = new LayoutParams(LayoutParams.WRAP_CONTENT,50);
        indicatorLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        indicatorLayoutParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        indicatorLayout.setLayoutParams(indicatorLayoutParams);
        addView(indicatorLayout);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        indicatorLayout.setCurrentIndicator(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
