/**
 * Created by Danial Goodwin on 2016-01-30.
 */
package net.simplyadvanced.androidapisampler.viewsample;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatCheckedTextView;
import android.view.View;
import android.widget.Checkable;
import android.widget.CheckedTextView;
import android.widget.LinearLayout;
import android.widget.TextView;

import net.simplyadvanced.androidapisampler.ViewSample;

/**
 *
 */
public class CheckedTextViewViewSample implements ViewSample {

    private Context mContext;
    private LinearLayout mRootView;

    public CheckedTextViewViewSample(Context context) {
        mContext = context;
    }

    @NonNull
    @Override
    public String getName() {
        return "CheckedTextView";
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
            TextView tvLabel = new TextView(mContext);
            tvLabel.setText("(Looks better in a ListView, with `android:layout_height=\"?android:attr/listPreferredItemHeight\"`)");

            View.OnClickListener onClickListener = new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    CheckedTextView tv = (CheckedTextView) v;
                    if (tv.isChecked()) {
                        tv.setChecked(false);
                        tv.setCheckMarkDrawable(android.R.drawable.checkbox_off_background);
                    } else {
                        tv.setChecked(true);
                        tv.setCheckMarkDrawable(android.R.drawable.checkbox_on_background);
                    }
                }
            };

            CheckedTextView tv = new CheckedTextView(mContext);
            tv.setCheckMarkDrawable(android.R.drawable.checkbox_off_background);
            tv.setText("Default version");
            tv.setOnClickListener(onClickListener);

            AppCompatCheckedTextView tvCompat = new AppCompatCheckedTextView(mContext);
            tvCompat.setCheckMarkDrawable(android.R.drawable.checkbox_off_background);
            tvCompat.setText("AppCompat version, only needed for custom views. More words to make this wrap two lines");
            tvCompat.setOnClickListener(onClickListener);

            mRootView = new LinearLayout(mContext);
            mRootView.setOrientation(LinearLayout.VERTICAL);
            mRootView.addView(tvLabel);
            mRootView.addView(tv);
            mRootView.addView(tvCompat);
        }
        return mRootView;
    }

    @Nullable
    @Override
    public View getViewCompat() {
        return null;
    }

}
