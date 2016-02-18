/**
 * Created by Danial Goodwin on 2016-02-18.
 */
package net.simplyadvanced.androidapisampler.viewsample;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import net.simplyadvanced.androidapisampler.ViewSample;

/**
 *
 */
public class RadioGroupViewSample implements ViewSample {

    private Context mContext;
    private LinearLayout mRootView;

    private View.OnClickListener mOnRadioButtonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v instanceof RadioButton) {
                RadioButton button = (RadioButton) v;
                boolean isChecked = button.isChecked();
                switch (v.getId()) {
                    case 1:
                        if (isChecked) { Toast.makeText(mContext, "Selected: " + button.getText(), Toast.LENGTH_SHORT).show(); }
                        break;
                    case 2:
                        if (isChecked) { Toast.makeText(mContext, "Selected: " + button.getText(), Toast.LENGTH_SHORT).show(); }
                        break;
                    case 3:
                        if (isChecked) { Toast.makeText(mContext, "Selected: " + button.getText(), Toast.LENGTH_SHORT).show(); }
                        break;
                }
            }
        }
    };

    public RadioGroupViewSample(Context context) {
        mContext = context;
    }

    @NonNull
    @Override
    public String getName() {
        return "RadioGroup";
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

            RadioGroup view = new RadioGroup(mContext);
            view.setOrientation(LinearLayout.HORIZONTAL);
            view.addView(newRadioButton(1, "1"));
            view.addView(newRadioButton(2, "2"));
            view.addView(newRadioButton(3, "3"));

            RadioGroup view2 = new RadioGroup(mContext);
            view2.setOrientation(LinearLayout.VERTICAL);
            view2.addView(newRadioButton(1, "1"));
            view2.addView(newRadioButton(2, "2"));
            view2.addView(newRadioButton(3, "3"));

            mRootView.addView(view);
            mRootView.addView(view2);
        }
        return mRootView;
    }

    private RadioButton newRadioButton(int id, String title) {
        RadioButton button = new RadioButton(mContext);
        button.setId(id);
        button.setText(title);
        button.setOnClickListener(mOnRadioButtonClickListener);
        return button;
    }

    @Nullable
    @Override
    public View getViewCompat() {
        return null;
    }

}
