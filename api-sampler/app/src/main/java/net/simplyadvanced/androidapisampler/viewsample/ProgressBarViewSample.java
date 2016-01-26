/**
 * Created by Danial Goodwin on 2016-01-20.
 */
package net.simplyadvanced.androidapisampler.viewsample;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import net.simplyadvanced.androidapisampler.ViewSample;

/**
 * TODO: Provide more ProgressBar samples.
 */
public class ProgressBarViewSample implements ViewSample {

    private Context mContext;
    private LinearLayout mRootView;

    public ProgressBarViewSample(@NonNull Context context) {
        mContext = context;
    }

    @NonNull
    @Override
    public String getName() {
        return "ProgressBar";
    }

    @NonNull
    @Override
    public String getDescription() {
        return "A simple programmatic usage, default implementation with listener.";
    }

    @NonNull
    @Override
    public View getView() {
        if (mRootView == null) {
            ProgressBar pb1 = new ProgressBar(mContext);

            mRootView = new LinearLayout(mContext);
            mRootView.setOrientation(LinearLayout.VERTICAL);
            mRootView.addView(pb1);
        }
        return mRootView;
    }

    @Nullable
    @Override
    public View getViewCompat() {
        return null;
    }

}
