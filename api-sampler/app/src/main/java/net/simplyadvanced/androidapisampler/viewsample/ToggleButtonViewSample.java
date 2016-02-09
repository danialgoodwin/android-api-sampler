/**
 * Created by Danial Goodwin on 2016-02-09.
 */
package net.simplyadvanced.androidapisampler.viewsample;

import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.widget.ToggleButton;

import net.simplyadvanced.androidapisampler.ViewSample;

/**
 *
 */
public class ToggleButtonViewSample implements ViewSample {

    private Context mContext;
    private LinearLayout mRootView;

    public ToggleButtonViewSample(Context context) {
        mContext = context;
    }

    @NonNull
    @Override
    public String getName() {
        return "ToggleButton";
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

            ToggleButton view = new ToggleButton(mContext);
            view.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    Toast.makeText(mContext, "isChecked=" + isChecked, Toast.LENGTH_SHORT).show();
                }
            });

            mRootView.addView(view);
        }
        return mRootView;
    }

    @Nullable
    @Override
    public View getViewCompat() {
        return null;
    }

}
