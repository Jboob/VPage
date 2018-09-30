package com.ran;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/**
 *
 * @author Ran
 * @date 2018/9/30.
 *
 */
public class VPager extends FrameLayout {


    public VPager(@NonNull Context context) {
        super(context);
    }

    public VPager(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public VPager(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
