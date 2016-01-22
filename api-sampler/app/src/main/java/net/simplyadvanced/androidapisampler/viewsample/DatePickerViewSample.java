/**
 * Created by Danial Goodwin on 2016-01-22.
 */
package net.simplyadvanced.androidapisampler.viewsample;

import android.app.DatePickerDialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.Toast;

import net.simplyadvanced.androidapisampler.ViewSample;

import java.util.Calendar;

/**
 *
 * More info: http://developer.android.com/guide/topics/ui/controls/pickers.html
 */
public class DatePickerViewSample implements ViewSample {

    private Context mContext;
    private LinearLayout mRootView;

    public DatePickerViewSample(@NonNull Context context) {
        mContext = context;
    }

    @NonNull
    @Override
    public String getName() {
        return "DatePicker";
    }

    @NonNull
    @Override
    public String getDescription() {
        return "A simple programmatic usage, default implementation is an AlertDialog.";
    }

    @NonNull
    @Override
    public View getView() {
        if (mRootView == null) {
            DatePicker dp = new DatePicker(mContext);
            dp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (v instanceof DatePicker) {
                        DatePicker p = (DatePicker) v;
                        Toast.makeText(mContext, String.format("Selected: %d-%d-%d", p.getYear(), p.getMonth(), p.getDayOfMonth()), Toast.LENGTH_SHORT).show();
                    }
                }
            });

            // Use the current date as the default date in the picker
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);
            final DatePickerDialog dpd = new DatePickerDialog(mContext, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                    Toast.makeText(mContext, String.format("Selected: %d-%d-%d", year, monthOfYear, dayOfMonth), Toast.LENGTH_SHORT).show();
                }
            }, year, month, day);

            Button dpdButton = new Button(mContext);
            dpdButton.setText("Open DatePickerDialog");
            dpdButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dpd.show();
                }
            });

            mRootView = new LinearLayout(mContext);
            mRootView.setOrientation(LinearLayout.VERTICAL);
            mRootView.addView(dp);
            mRootView.addView(dpdButton);
        }
        return mRootView;
    }

    @Nullable
    @Override
    public View getViewCompat() {
        return null;
    }

}
