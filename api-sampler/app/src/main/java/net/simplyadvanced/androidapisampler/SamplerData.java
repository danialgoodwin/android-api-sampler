/**
 * Created by Danial Goodwin on 2016-01-18.
 */
package net.simplyadvanced.androidapisampler;

import android.content.Context;
import android.support.annotation.NonNull;

import net.simplyadvanced.androidapisampler.viewsample.AutoCompleteTextViewViewSample;
import net.simplyadvanced.androidapisampler.viewsample.CalendarViewViewSample;
import net.simplyadvanced.androidapisampler.viewsample.CardViewViewSample;
import net.simplyadvanced.androidapisampler.viewsample.CheckedTextViewViewSample;
import net.simplyadvanced.androidapisampler.viewsample.ChronometerViewSample;
import net.simplyadvanced.androidapisampler.viewsample.DatePickerViewSample;
import net.simplyadvanced.androidapisampler.viewsample.DialerFilterViewSample;
import net.simplyadvanced.androidapisampler.viewsample.ImageSwitcherViewSample;
import net.simplyadvanced.androidapisampler.viewsample.KeyboardViewViewSample;
import net.simplyadvanced.androidapisampler.viewsample.ProgressBarViewSample;
import net.simplyadvanced.androidapisampler.viewsample.RatingBarViewSample;
import net.simplyadvanced.androidapisampler.viewsample.SpinnerViewSample;
import net.simplyadvanced.androidapisampler.viewsample.TextSwitcherViewSample;
import net.simplyadvanced.androidapisampler.viewsample.TimePickerViewSample;
import net.simplyadvanced.androidapisampler.viewsample.ViewFlipperViewSample;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 */
public class SamplerData {

    private List<ViewSample> mViewSamples;

    public SamplerData(@NonNull Context context) {
        mViewSamples = new ArrayList<>();
        mViewSamples.add(new AutoCompleteTextViewViewSample(context));
        mViewSamples.add(new CalendarViewViewSample(context));
        mViewSamples.add(new CardViewViewSample(context));
        mViewSamples.add(new CheckedTextViewViewSample(context));
        mViewSamples.add(new ChronometerViewSample(context));
        mViewSamples.add(new DatePickerViewSample(context));
//        mViewSamples.add(new DialerFilterViewSample(context));
        mViewSamples.add(new ImageSwitcherViewSample(context));
        mViewSamples.add(new KeyboardViewViewSample(context));
        mViewSamples.add(new ProgressBarViewSample(context));
        mViewSamples.add(new RatingBarViewSample(context));
        mViewSamples.add(new TextSwitcherViewSample(context));
        mViewSamples.add(new TimePickerViewSample(context));
        mViewSamples.add(new SpinnerViewSample(context));
        mViewSamples.add(new ViewFlipperViewSample(context));
        mViewSamples = Collections.unmodifiableList(mViewSamples);
    }

    /** Return an unmodifiable list of ViewSamples, though the underlying view is still mutable. */
    public List<ViewSample> getViewSamples() {
        return mViewSamples;
    }

}
