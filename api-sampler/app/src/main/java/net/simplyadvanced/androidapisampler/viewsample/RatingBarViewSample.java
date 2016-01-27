/**
 * Created by Danial Goodwin on 2016-01-27.
 */
package net.simplyadvanced.androidapisampler.viewsample;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatRatingBar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.Toast;

import net.simplyadvanced.androidapisampler.ViewSample;

/**
 * TODO: Provide more RatingBar samples.
 */
public class RatingBarViewSample implements ViewSample {

    private Context mContext;
    private LinearLayout mRootView;
    private LinearLayout mRootViewCompat;

    private RatingBar.OnRatingBarChangeListener mOnRatingBarChangeListener = new RatingBar.OnRatingBarChangeListener() {
        @Override
        public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
            Toast.makeText(mContext, "rating=" + rating, Toast.LENGTH_SHORT).show();
        }
    };

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
        return "A simple programmatic usage. 1) default implementation, 2) with setMax(5).";
    }

    @NonNull
    @Override
    public View getView() {
        if (mRootView == null) {
            RatingBar rb1 = new RatingBar(mContext);
            rb1.setOnRatingBarChangeListener(mOnRatingBarChangeListener);

            RatingBar rb2 = new RatingBar(mContext);
            rb2.setOnRatingBarChangeListener(mOnRatingBarChangeListener);
            rb2.setMax(5);

            mRootView = new LinearLayout(mContext);
            mRootView.setOrientation(LinearLayout.VERTICAL);
            mRootView.addView(rb1);
            mRootView.addView(rb2);
        }
        return mRootView;
    }

    @Nullable
    @Override
    public View getViewCompat() {
        if (mRootViewCompat == null) {
            AppCompatRatingBar rb1 = new AppCompatRatingBar(mContext);

            mRootViewCompat = new LinearLayout(mContext);
            mRootViewCompat.setOrientation(LinearLayout.VERTICAL);
            mRootViewCompat.addView(rb1);
        }
        return mRootViewCompat;
    }

}
