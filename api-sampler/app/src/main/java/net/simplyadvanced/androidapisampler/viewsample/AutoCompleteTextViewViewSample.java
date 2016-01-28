/**
 * Created by Danial Goodwin on 2016-01-28.
 */
package net.simplyadvanced.androidapisampler.viewsample;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.LinearLayout;
import android.widget.TextView;

import net.simplyadvanced.androidapisampler.ViewSample;

/**
 *
 */
public class AutoCompleteTextViewViewSample implements ViewSample {

    private Context mContext;
    private LinearLayout mRootView;

    public AutoCompleteTextViewViewSample(Context context) {
        mContext = context;
    }

    @NonNull
    @Override
    public String getName() {
        return "AutoCompleteTextView";
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
            String[] words = {"Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune"};
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(mContext, android.R.layout.simple_dropdown_item_1line, words);

            TextView label = new TextView(mContext);
            label.setText("Name a planet:");

            AutoCompleteTextView tv = new AutoCompleteTextView(mContext);
            tv.setAdapter(adapter);

            mRootView = new LinearLayout(mContext);
            mRootView.setOrientation(LinearLayout.VERTICAL);
            mRootView.addView(label);
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
