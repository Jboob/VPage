package com.ran.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.ran.R;

import java.util.HashMap;

/**
 *
 * @author Ran
 * @date 2018/9/30.
 *
 */

public class IndicatorLayout extends LinearLayout {

    private Context mContext;
    private int indicatorCount = 3;
    private int indicatorResId = R.drawable.selector_indicator;
    private HashMap<Integer, ImageView> hashMap = new HashMap<>();

    private LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

    public IndicatorLayout(Context context) {
        super(context);
        this.mContext = context;
        init();
    }

    public IndicatorLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        init();
    }

    public IndicatorLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;
        init();
    }

    public void setIndicatorCount(int indicatorCount) {
        this.indicatorCount = indicatorCount;
    }

    public void setIndicatorDrawable(@NonNull int resId) {
        this.indicatorResId = resId;
    }

    /**
     * 初始化 默认个数，默认小圆点
     */
    private void init() {
        if (hashMap.size() <= 0) {
            for (int i = 0; i < indicatorCount; i++) {
                ImageView view = new ImageView(mContext);
                view.setBackgroundResource(indicatorResId);
                view.setEnabled(false);
                //设置宽高
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                //设置间隔
                if (i != 0) {
                    layoutParams.leftMargin = 10;
                } else if (i == 0) {//默认选中第一个
                    view.setEnabled(true);
                }
                //添加到LinearLayout
                addView(view, layoutParams);
                hashMap.put(i, view);
            }
        }
    }

    /**
     * 设置当前指示位置
     * @param currentIndicator
     */
    public void setCurrentIndicator(int currentIndicator) {
        for (int i = 0; i < hashMap.size(); i++) {
            if (i != 0) {
                layoutParams.leftMargin = 10;
            }
            ImageView view = hashMap.get(i);
            if (currentIndicator == i) {
                view.setEnabled(true);
            } else {
                view.setEnabled(false);
            }
            view.setLayoutParams(layoutParams);
        }
    }

}
