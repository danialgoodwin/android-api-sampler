/**
 * Created by Danial Goodwin on 2016-01-24.
 */
package net.simplyadvanced.androidapisampler.viewsample;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.DialerFilter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import net.simplyadvanced.androidapisampler.R;
import net.simplyadvanced.androidapisampler.ViewSample;

/**
 * Not working yet. Feel free to scrap all of this to create a working version.
 */
public class DialerFilterViewSample implements ViewSample {

    private Context mContext;
    private LinearLayout mRootView;

    public DialerFilterViewSample(@NonNull Context context) {
        mContext = context;
    }

    @NonNull
    @Override
    public String getName() {
        return "DialerFilter";
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
            EditText et = new EditText(mContext);

            EditText etFilter = new EditText(mContext);
            etFilter.setText("");
            etFilter.setId(R.id.hint);
//            etFilter.setId(com.android.internal.R.id.hint); // Doesn't exit for public SDK
            EditText etDigits = new EditText(mContext);
            etDigits.setText("");
            etDigits.setId(R.id.primary);
//            etDigits.setId(com.android.internal.R.id.primary); // Doesn't exit for public SDK
            LinearLayout dialerFilterLayout = new LinearLayout(mContext);
            dialerFilterLayout.setOrientation(LinearLayout.VERTICAL);
            dialerFilterLayout.addView(etFilter);
            dialerFilterLayout.addView(etDigits);
            DialerFilter df = new DialerFilter(mContext);
            df.addView(dialerFilterLayout);

            mRootView = new LinearLayout(mContext);
            mRootView.setOrientation(LinearLayout.VERTICAL);
            mRootView.addView(et);
            mRootView.addView(df);


//            df.setMode(DialerFilter.DIGITS_AND_LETTERS);
        }
        return mRootView;
    }

    @Nullable
    @Override
    public View getViewCompat() {
        return null;
    }

}
