/**
 * Created by Danial Goodwin on 2016-01-18.
 */
package net.simplyadvanced.androidapisampler.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import net.simplyadvanced.androidapisampler.R;
import net.simplyadvanced.androidapisampler.ViewSample;

/**
 *
 */
public class ToggleViewSampleButton extends LinearLayout {

    private Button mButton;
    private boolean isShowingViewSample = false;
    private ViewSample mViewSample;

    public ToggleViewSampleButton(Context context) {
        super(context);
        initialize(context);
    }

    public ToggleViewSampleButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialize(context);
    }

    public ToggleViewSampleButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initialize(context);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public ToggleViewSampleButton(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initialize(context);
    }

    private void initialize(Context context) {
        setOrientation(VERTICAL);
        setBackgroundResource(R.drawable.border_background);

        mButton = new Button(context);
        addView(mButton);
    }

    public void setViewSample(@NonNull ViewSample sample) {
        mViewSample = sample;
        mButton.setText(mViewSample.getName());

        mButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isShowingViewSample) {
                    removeView(mViewSample.getView());
                    isShowingViewSample = false;
                } else {
                    addView(mViewSample.getView());
                    isShowingViewSample = true;
                }
            }
        });
    }

}
