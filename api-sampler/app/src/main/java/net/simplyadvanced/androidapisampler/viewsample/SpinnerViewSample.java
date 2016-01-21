/**
 * Created by Danial Goodwin on 2016-01-21.
 */
package net.simplyadvanced.androidapisampler.viewsample;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import net.simplyadvanced.androidapisampler.R;
import net.simplyadvanced.androidapisampler.ViewSample;

/**
 *
 */
public class SpinnerViewSample implements ViewSample {

    private Context mContext;
    private LinearLayout mRootView;

    public SpinnerViewSample(@NonNull Context context) {
        mContext = context;
    }

    @NonNull
    @Override
    public String getName() {
        return "Spinner";
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
            final String[] words = {"Mercury", "Venus", "Earth", "Mars"};

            ArrayAdapter<String> adapter = new ArrayAdapter<>(mContext, android.R.layout.simple_spinner_item, words);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

            AdapterView.OnItemSelectedListener onItemSelectedListener = new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    Toast.makeText(mContext, "Selected: " + words[position], Toast.LENGTH_SHORT).show();
                }
                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            };

            Spinner s1 = new Spinner(mContext);
            s1.setOnItemSelectedListener(onItemSelectedListener);
            s1.setAdapter(adapter);

            Spinner s2 = new Spinner(mContext, Spinner.MODE_DIALOG);
            s2.setOnItemSelectedListener(onItemSelectedListener);
            s2.setAdapter(adapter);

            Spinner s3 = new Spinner(mContext, Spinner.MODE_DROPDOWN);
            s3.setOnItemSelectedListener(onItemSelectedListener);
            s3.setAdapter(adapter);

            Spinner s4 = (Spinner) View.inflate(mContext, R.layout.spinner, null);
            s4.setOnItemSelectedListener(onItemSelectedListener);
            s4.setAdapter(adapter);

            mRootView = new LinearLayout(mContext);
            mRootView.setOrientation(LinearLayout.VERTICAL);
            mRootView.addView(s1);
            mRootView.addView(s2);
            mRootView.addView(s3);
            mRootView.addView(s4);
        }
        return mRootView;
    }

    @Nullable
    @Override
    public View getViewCompat() {
        return null;
    }

}
