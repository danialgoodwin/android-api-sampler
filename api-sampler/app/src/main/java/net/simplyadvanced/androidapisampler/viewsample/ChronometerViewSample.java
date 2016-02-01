/**
 * Created by Danial Goodwin on 2016-01-31.
 */
package net.simplyadvanced.androidapisampler.viewsample;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Chronometer;
import android.widget.LinearLayout;
import android.widget.Toast;

import net.simplyadvanced.androidapisampler.ViewSample;

/**
 *
 */
public class ChronometerViewSample implements ViewSample {

    private Context mContext;
    private LinearLayout mRootView;
    private boolean isRunning = false;

    public ChronometerViewSample(Context context) {
        mContext = context;
    }

    @NonNull
    @Override
    public String getName() {
        return "Chronometer";
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
            final Chronometer c = new Chronometer(mContext);
            c.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (isRunning) {
                        c.stop();
                        isRunning = false;
                        Toast.makeText(mContext, "Stopped", Toast.LENGTH_SHORT).show();
                    } else {
                        c.start();
                        isRunning = true;
                        Toast.makeText(mContext, "Started", Toast.LENGTH_SHORT).show();
                    }
                }
            });

            mRootView = new LinearLayout(mContext);
            mRootView.setOrientation(LinearLayout.VERTICAL);
            mRootView.addView(c);
        }
        return mRootView;
    }

    @Nullable
    @Override
    public View getViewCompat() {
        return null;
    }

}
