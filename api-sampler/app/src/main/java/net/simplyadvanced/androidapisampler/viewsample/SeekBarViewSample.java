/**
 * Created by Danial Goodwin on 2016-02-06.
 */
package net.simplyadvanced.androidapisampler.viewsample;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import net.simplyadvanced.androidapisampler.ViewSample;

/**
 *
 */
public class SeekBarViewSample implements ViewSample {

    private Context mContext;
    private LinearLayout mRootView;

    public SeekBarViewSample(Context context) {
        mContext = context;
    }

    @NonNull
    @Override
    public String getName() {
        return "SeekBar";
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

            final TextView tv = new TextView(mContext);
            tv.setText("not set");

            SeekBar view = new SeekBar(mContext);
            view.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                    tv.setText("progress=" + progress);
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {

                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {

                }
            });

            mRootView.addView(view);
            mRootView.addView(tv);
        }
        return mRootView;
    }

    @Nullable
    @Override
    public View getViewCompat() {
        return null;
    }

}
