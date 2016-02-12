/**
 * Created by Danial Goodwin on 2016-02-11.
 */
package net.simplyadvanced.androidapisampler.viewsample;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ZoomButton;

import net.simplyadvanced.androidapisampler.ViewSample;

/**
 *
 */
public class ZoomButtonViewSample implements ViewSample {

    private Context mContext;
    private LinearLayout mRootView;

    private int mCounter = 1;

    public ZoomButtonViewSample(Context context) {
        mContext = context;
    }

    @NonNull
    @Override
    public String getName() {
        return "ZoomButton";
    }

    @NonNull
    @Override
    public String getDescription() {
        return "A simple programmatic usage, using Android R drawables.";
    }

    @NonNull
    @Override
    public View getView() {
        if (mRootView == null) {
            mRootView = new LinearLayout(mContext);
            mRootView.setOrientation(LinearLayout.VERTICAL);

            final TextView directions = new TextView(mContext);
            directions.setText("(Click and hold image)");

            final TextView label = new TextView(mContext);
            label.setText("zoom: " + mCounter);

            ZoomButton view = new ZoomButton(mContext);
            view.setZoomSpeed(200);
            view.setImageResource(android.R.drawable.zoom_plate);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    label.setText("zoom: " + ++mCounter);
//                    Toast.makeText(mContext, "click " + mCounter++, Toast.LENGTH_SHORT).show();
                }
            });
            view.setOnKeyListener(new View.OnKeyListener() {
                @Override
                public boolean onKey(View v, int keyCode, KeyEvent event) {
                    label.setText("zoom: " + ++mCounter);
                    Toast.makeText(mContext, "keyCode=" + keyCode + ", event=" + event, Toast.LENGTH_SHORT).show();
                    return true;
                }
            });

            ZoomButton view2 = new ZoomButton(mContext);
            view2.setZoomSpeed(600);
            view2.setImageResource(android.R.drawable.ic_menu_zoom);
            view2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    label.setText("zoom: " + --mCounter);
//                    Toast.makeText(mContext, "click " + mCounter2++, Toast.LENGTH_SHORT).show();
                }
            });

            mRootView.addView(directions);
            mRootView.addView(label);
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
