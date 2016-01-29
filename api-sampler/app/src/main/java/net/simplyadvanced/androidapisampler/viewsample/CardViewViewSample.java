/**
 * Created by Danial Goodwin on 2016-01-29.
 */
package net.simplyadvanced.androidapisampler.viewsample;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import net.simplyadvanced.androidapisampler.ViewSample;
import net.simplyadvanced.util.android.LayoutUtils;

/**
 *
 */
public class CardViewViewSample implements ViewSample {

    private Context mContext;
    private LinearLayout mRootView;

    public CardViewViewSample(Context context) {
        mContext = context;
    }

    @NonNull
    @Override
    public String getName() {
        return "CardView";
    }

    @NonNull
    @Override
    public String getDescription() {
        return "A simple programmatic usage, default implementation. From v7 support lib.";
    }

    @NonNull
    @Override
    public View getView() {
        if (mRootView == null) {
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            int px = LayoutUtils.getPxFromDp(mContext, 8);
            params.setMargins(px, px, px, px);

            TextView tvDefault = new TextView(mContext);
            tvDefault.setText("default");
            CardView cvDefault = new CardView(mContext);
            cvDefault.setContentPadding(px, px, px, px);
            cvDefault.addView(tvDefault);

            TextView tvElevated = new TextView(mContext);
            tvElevated.setText("elevated");
            CardView cvElevated = new CardView(mContext);
            cvElevated.setContentPadding(px, px, px, px);
            cvElevated.setCardElevation(px);
            cvElevated.addView(tvElevated);

            mRootView = new LinearLayout(mContext);
            mRootView.setOrientation(LinearLayout.VERTICAL);
            mRootView.setPadding(px, px, px, px * 2);
            mRootView.addView(cvDefault, params);
            mRootView.addView(cvElevated, params);
        }
        return mRootView;
    }

    @Nullable
    @Override
    public View getViewCompat() {
        return null;
    }

}
