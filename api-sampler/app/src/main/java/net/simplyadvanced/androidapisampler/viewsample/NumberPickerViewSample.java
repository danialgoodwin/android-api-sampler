/**
 * Created by Danial Goodwin on 2016-02-04.
 */
package net.simplyadvanced.androidapisampler.viewsample;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.Toast;

import net.simplyadvanced.androidapisampler.ViewSample;

/**
 *
 * More info: http://developer.android.com/guide/topics/ui/controls/pickers.html
 */
public class NumberPickerViewSample implements ViewSample {

    private Context mContext;
    private LinearLayout mRootView;

    public NumberPickerViewSample(@NonNull Context context) {
        mContext = context;
    }

    @NonNull
    @Override
    public String getName() {
        return "NumberPicker";
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
            final NumberPicker np = new NumberPicker(mContext);
            np.setMinValue(0);
            np.setMaxValue(5);
            np.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
                @Override
                public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                    Toast.makeText(mContext, "Selected: " + picker.getValue(), Toast.LENGTH_SHORT).show();
                }
            });

            mRootView = new LinearLayout(mContext);
            mRootView.setOrientation(LinearLayout.VERTICAL);
            mRootView.addView(np);
        }
        return mRootView;
    }

    @Nullable
    @Override
    public View getViewCompat() {
        return null;
    }

}
