/**
 * Created by Danial Goodwin on 2016-02-01.
 */
package net.simplyadvanced.androidapisampler.viewsample;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Chronometer;
import android.widget.LinearLayout;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.Toast;

import net.simplyadvanced.androidapisampler.ViewSample;

/**
 *
 */
public class TextClockViewSample implements ViewSample {

    private Context mContext;
    private LinearLayout mRootView;

    public TextClockViewSample(Context context) {
        mContext = context;
    }

    @NonNull
    @Override
    public String getName() {
        return "TextClock";
    }

    @NonNull
    @Override
    public String getDescription() {
        return "A simple programmatic usage, default implementation. Requires API 17+.";
    }

    @NonNull
    @Override
    public View getView() {
        if (mRootView == null) {
            mRootView = new LinearLayout(mContext);
            mRootView.setOrientation(LinearLayout.VERTICAL);

            if (Build.VERSION.SDK_INT >= 17) {
                TextClock c = new TextClock(mContext);
                mRootView.addView(c);
            } else {
                TextView t = new TextView(mContext);
                t.setText("Requires API 17+");
                mRootView.addView(t);
            }
        }
        return mRootView;
    }

    @Nullable
    @Override
    public View getViewCompat() {
        return null;
    }

}
