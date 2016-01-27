/**
 * Created by Danial Goodwin on 2016-01-27.
 */
package net.simplyadvanced.androidapisampler.viewsample;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RatingBar;

import net.simplyadvanced.androidapisampler.ViewSample;

/**
 * TODO: Provide more RatingBar samples.
 */
public class RatingBarViewSample implements ViewSample {

    private Context mContext;
    private LinearLayout mRootView;

    public RatingBarViewSample(@NonNull Context context) {
        mContext = context;
    }

    @NonNull
    @Override
    public String getName() {
        return "RatingBar";
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
            RatingBar rb1 = new RatingBar(mContext);

            mRootView = new LinearLayout(mContext);
            mRootView.setOrientation(LinearLayout.VERTICAL);
            mRootView.addView(rb1);
        }
        return mRootView;
    }

    @Nullable
    @Override
    public View getViewCompat() {
        return null;
    }

}
