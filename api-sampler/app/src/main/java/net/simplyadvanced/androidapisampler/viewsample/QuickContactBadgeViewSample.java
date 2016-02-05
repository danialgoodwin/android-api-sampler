/**
 * Created by Danial Goodwin on 2016-02-05.
 */
package net.simplyadvanced.androidapisampler.viewsample;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.QuickContactBadge;

import net.simplyadvanced.androidapisampler.ViewSample;

/**
 * TODO: Show list of contacts to look up and assign to badge.
 */
public class QuickContactBadgeViewSample implements ViewSample {

    private Context mContext;
    private LinearLayout mRootView;

    public QuickContactBadgeViewSample(Context context) {
        mContext = context;
    }

    @NonNull
    @Override
    public String getName() {
        return "QuickContactBadge";
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

            QuickContactBadge badge = new QuickContactBadge(mContext);

            mRootView.addView(badge);
        }
        return mRootView;
    }

    @Nullable
    @Override
    public View getViewCompat() {
        return null;
    }

}
