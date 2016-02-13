/**
 * Created by Danial Goodwin on 2016-01-26.
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
 *
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
        return "A simple programmatic usage, default implementation.";
    }

    @NonNull
    @Override
    public View getView() {
        if (mRootView == null) {
            ProgressBar view = new ProgressBar(mContext, null, android.R.attr.progressBarStyleLarge);

            ProgressBar view4 = new ProgressBar(mContext);

            ProgressBar view5 = new ProgressBar(mContext, null, android.R.attr.progressBarStyleSmall);

            ProgressBar view2 = new ProgressBar(mContext, null, android.R.attr.progressBarStyleHorizontal);
            view2.setIndeterminate(true);

            ProgressBar view3 = new ProgressBar(mContext, null, android.R.attr.progressBarStyleHorizontal);
            view3.setMax(100);
            view3.setProgress(42);
            view3.setIndeterminate(false);

            mRootView = new LinearLayout(mContext);
            mRootView.setOrientation(LinearLayout.VERTICAL);
            mRootView.addView(view);
            mRootView.addView(view4);
            mRootView.addView(view5);
            mRootView.addView(view2);
            mRootView.addView(view3);
        }
        return mRootView;
    }

    @Nullable
    @Override
    public View getViewCompat() {
        return null;
    }

}
