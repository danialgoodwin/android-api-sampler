/**
 * Created by Danial Goodwin on 2016-01-22.
 */
package net.simplyadvanced.androidapisampler.viewsample;

import android.app.TimePickerDialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TimePicker;
import android.widget.Toast;

import net.simplyadvanced.androidapisampler.ViewSample;

import java.util.Calendar;

/**
 *
 * More info: http://developer.android.com/guide/topics/ui/controls/pickers.html
 */
public class TimePickerViewSample implements ViewSample {

    private Context mContext;
    private LinearLayout mRootView;

    public TimePickerViewSample(@NonNull Context context) {
        mContext = context;
    }

    @NonNull
    @Override
    public String getName() {
        return "TimePicker";
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
            TimePicker dp = new TimePicker(mContext);
            dp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (v instanceof TimePicker) {
                        TimePicker p = (TimePicker) v;
                        Toast.makeText(mContext, String.format("Selected: %d:%d", p.getCurrentHour(), p.getCurrentMinute()), Toast.LENGTH_SHORT).show();
                    }
                }
            });

            // Use the current time as the default time in the picker
            final Calendar c = Calendar.getInstance();
            int hourOfDay = c.get(Calendar.HOUR_OF_DAY);
            int minute = c.get(Calendar.MINUTE);
            boolean is24HourView = false;
            final TimePickerDialog dpd = new TimePickerDialog(mContext, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    Toast.makeText(mContext, String.format("Selected: %d:%d", hourOfDay, minute), Toast.LENGTH_SHORT).show();
                }
            }, hourOfDay, minute, is24HourView);

            Button dpdButton = new Button(mContext);
            dpdButton.setAllCaps(false);
            dpdButton.setText("Open TimePickerDialog");
            dpdButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dpd.show();
                }
            });

            mRootView = new LinearLayout(mContext);
            mRootView.setOrientation(LinearLayout.VERTICAL);
            mRootView.addView(dpdButton);
            mRootView.addView(dp);
        }
        return mRootView;
    }

    @Nullable
    @Override
    public View getViewCompat() {
        return null;
    }

}
