/**
 * Created by Danial Goodwin on 2016-01-18.
 */
package net.simplyadvanced.androidapisampler;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import net.simplyadvanced.androidapisampler.ui.ToggleViewSampleButton;

import java.util.List;

/**
 *
 */
public class SamplerMasterView extends ScrollView {

    private LinearLayout mRootLinearLayout;

    public SamplerMasterView(Context context) {
        super(context);
        initialize(context);
    }

    public SamplerMasterView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialize(context);
    }

    public SamplerMasterView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initialize(context);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public SamplerMasterView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initialize(context);
    }

    private void initialize(Context context) {
        mRootLinearLayout = new LinearLayout(context);
        mRootLinearLayout.setOrientation(LinearLayout.VERTICAL);

        SamplerData samplerData = new SamplerData(context);
        List<ViewSample> viewSamples = samplerData.getViewSamples();
        for (ViewSample sample : viewSamples) {
            ToggleViewSampleButton button = new ToggleViewSampleButton(context);
            button.setViewSample(sample);
            mRootLinearLayout.addView(button);
        }

        addView(mRootLinearLayout);
    }

}
