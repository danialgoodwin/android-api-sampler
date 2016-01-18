/**
 * Created by Danial Goodwin on 2016-01-18.
 */
package net.simplyadvanced.androidapisampler;

import android.content.Context;
import android.support.annotation.NonNull;

import net.simplyadvanced.androidapisampler.viewsample.TextSwitcherViewSample;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 */
public class SamplerData {

    private Context mContext;
    private List<ViewSample> mViewSamples;

    public SamplerData(@NonNull Context context) {
        mViewSamples = new ArrayList<>();
        mViewSamples.add(new TextSwitcherViewSample(context));
        mViewSamples.add(new TextSwitcherViewSample(context));
        mViewSamples.add(new TextSwitcherViewSample(context));
        mViewSamples.add(new TextSwitcherViewSample(context));
        mViewSamples = Collections.unmodifiableList(mViewSamples);
    }

    /** Return an unmodifiable list of ViewSamples, though the underlying view is still mutable. */
    public List<ViewSample> getViewSamples() {
        return mViewSamples;
    }

}
