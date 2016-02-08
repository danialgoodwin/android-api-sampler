/**
 * Created by Danial Goodwin on 2016-02-07.
 */
package net.simplyadvanced.androidapisampler.viewsample;

import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Switch;

import net.simplyadvanced.androidapisampler.ViewSample;

/**
 *
 */
public class SwitchViewSample implements ViewSample {

    private Context mContext;
    private LinearLayout mRootView;

    public SwitchViewSample(Context context) {
        mContext = context;
    }

    @NonNull
    @Override
    public String getName() {
        return "Switch";
    }

    @NonNull
    @Override
    public String getDescription() {
        return "A simple programmatic usage, default implementation.";
    }

    @NonNull
    @Override
    public View getView() {
        if (mRootView == null) {
            mRootView = new LinearLayout(mContext);
            mRootView.setOrientation(LinearLayout.VERTICAL);

            Switch view = new Switch(mContext);
            mRootView.addView(view);

            if (Build.VERSION.SDK_INT >= 21) {
                Switch view2 = new Switch(mContext);
                view2.setTextOn("On");
                view2.setTextOff("Off");
                view2.setShowText(true);
                mRootView.addView(view2);
            }
        }
        return mRootView;
    }

    @Nullable
    @Override
    public View getViewCompat() {
        return null;
    }

}
