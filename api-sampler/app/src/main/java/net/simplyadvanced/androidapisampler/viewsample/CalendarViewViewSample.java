/**
 * Created by Danial Goodwin on 2016-01-20.
 */
package net.simplyadvanced.androidapisampler.viewsample;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.CalendarView;
import android.widget.Toast;

import net.simplyadvanced.androidapisampler.ViewSample;

/**
 *
 */
public class CalendarViewViewSample implements ViewSample {

    private Context mContext;
    private View mRootView;

    public CalendarViewViewSample(@NonNull Context context) {
        mContext = context;
    }

    @NonNull
    @Override
    public String getName() {
        return "CalendarView";
    }

    @NonNull
    @Override
    public String getDescription() {
        return "A simple programmatic usage, default implementation with listener.";
    }

    @NonNull
    @Override
    public View getView() {
        if (mRootView == null) {
            CalendarView cv = new CalendarView(mContext);
            cv.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
                @Override
                public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                    Toast.makeText(mContext, String.format("Selected: %d-%d-%d", year, month, dayOfMonth), Toast.LENGTH_SHORT).show();
                }
            });
            mRootView = cv;
        }
        return mRootView;
    }

    @Nullable
    @Override
    public View getViewCompat() {
        return null;
    }

}
