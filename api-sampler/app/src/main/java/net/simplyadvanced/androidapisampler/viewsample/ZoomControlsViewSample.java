/**
 * Created by Danial Goodwin on 2016-02-15.
 */
package net.simplyadvanced.androidapisampler.viewsample;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ZoomControls;

import net.simplyadvanced.androidapisampler.ViewSample;

/**
 *
 */
public class ZoomControlsViewSample implements ViewSample {

    private Context mContext;
    private LinearLayout mRootView;
    private int mCounter = 1;

    public ZoomControlsViewSample(Context context) {
        mContext = context;
    }

    @NonNull
    @Override
    public String getName() {
        return "ZoomControls";
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

            final TextView counterText = new TextView(mContext);
            counterText.setText("(Click (and hold) image)");

            final ZoomControls view = new ZoomControls(mContext);
            view.setZoomSpeed(200);
            view.setOnZoomInClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    counterText.setText("Selected: zoom in, counter=" + mCounter++);
                }
            });
            view.setOnZoomOutClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    counterText.setText("Selected: zoom out, counter=" + mCounter++);
                }
            });

            final ZoomControls view2 = new ZoomControls(mContext);
            view2.setOrientation(LinearLayout.VERTICAL);
            view2.setZoomSpeed(200);
            view2.setOnZoomInClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    counterText.setText("Selected: zoom in, counter=" + mCounter++);
                }
            });
            view2.setOnZoomOutClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    counterText.setText("Selected: zoom out, counter=" + mCounter++);
                }
            });

            mRootView.addView(counterText);
            mRootView.addView(view);
            mRootView.addView(view2);
        }
        return mRootView;
    }

    @Nullable
    @Override
    public View getViewCompat() {
        return null;
    }

}
