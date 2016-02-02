/**
 * Created by Danial Goodwin on 2016-02-02.
 */
package net.simplyadvanced.androidapisampler.viewsample;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import net.simplyadvanced.androidapisampler.ViewSample;

/**
 *
 */
public class FloatingActionButtonViewSample implements ViewSample {

    private Context mContext;
    private LinearLayout mRootView;

    public FloatingActionButtonViewSample(Context context) {
        mContext = context;
    }

    @NonNull
    @Override
    public String getName() {
        return "FloatingActionButton";
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
            FloatingActionButton fab = new FloatingActionButton(mContext);
            FloatingActionButton fab2 = new FloatingActionButton(mContext);
            fab2.setImageResource(android.R.drawable.ic_dialog_info);

            View.OnClickListener onClickListener = new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mContext, "FAB selected", Toast.LENGTH_SHORT).show();
                }
            };
            fab.setOnClickListener(onClickListener);
            fab2.setOnClickListener(onClickListener);

            mRootView = new LinearLayout(mContext);
            mRootView.setOrientation(LinearLayout.HORIZONTAL);
            mRootView.addView(fab);
            mRootView.addView(fab2);
        }
        return mRootView;
    }

    @Nullable
    @Override
    public View getViewCompat() {
        return null;
    }

}
