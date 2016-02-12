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
import net.simplyadvanced.androidapisampler.viewsample.FloatingActionButtonViewSample;
import net.simplyadvanced.androidapisampler.viewsample.ImageSwitcherViewSample;
import net.simplyadvanced.androidapisampler.viewsample.KeyboardViewViewSample;
import net.simplyadvanced.androidapisampler.viewsample.NumberPickerViewSample;
import net.simplyadvanced.androidapisampler.viewsample.ProgressBarViewSample;
import net.simplyadvanced.androidapisampler.viewsample.ProgressDialogViewSample;
import net.simplyadvanced.androidapisampler.viewsample.QuickContactBadgeViewSample;
import net.simplyadvanced.androidapisampler.viewsample.RatingBarViewSample;
import net.simplyadvanced.androidapisampler.viewsample.SearchViewViewSample;
import net.simplyadvanced.androidapisampler.viewsample.SeekBarViewSample;
import net.simplyadvanced.androidapisampler.viewsample.SpinnerViewSample;
import net.simplyadvanced.androidapisampler.viewsample.SwitchViewSample;
import net.simplyadvanced.androidapisampler.viewsample.TabLayoutViewSample;
import net.simplyadvanced.androidapisampler.viewsample.TextClockViewSample;
import net.simplyadvanced.androidapisampler.viewsample.TextSwitcherViewSample;
import net.simplyadvanced.androidapisampler.viewsample.TimePickerViewSample;
import net.simplyadvanced.androidapisampler.viewsample.ToggleButtonViewSample;
import net.simplyadvanced.androidapisampler.viewsample.ToolbarViewSample;
import net.simplyadvanced.androidapisampler.viewsample.ViewFlipperViewSample;
import net.simplyadvanced.androidapisampler.viewsample.ZoomButtonViewSample;

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
        mViewSamples.add(new FloatingActionButtonViewSample(context));
        mViewSamples.add(new ImageSwitcherViewSample(context));
        mViewSamples.add(new KeyboardViewViewSample(context));
        mViewSamples.add(new NumberPickerViewSample(context));
        mViewSamples.add(new ProgressBarViewSample(context));
        mViewSamples.add(new ProgressDialogViewSample(context));
//        mViewSamples.add(new QuickContactBadgeViewSample(context));
        mViewSamples.add(new RatingBarViewSample(context));
        mViewSamples.add(new SearchViewViewSample(context));
        mViewSamples.add(new SeekBarViewSample(context));
        mViewSamples.add(new SwitchViewSample(context));
        mViewSamples.add(new TabLayoutViewSample(context));
        mViewSamples.add(new TextClockViewSample(context));
        mViewSamples.add(new TextSwitcherViewSample(context));
        mViewSamples.add(new TimePickerViewSample(context));
        mViewSamples.add(new ToggleButtonViewSample(context));
        mViewSamples.add(new ToolbarViewSample(context));
        mViewSamples.add(new SpinnerViewSample(context));
        mViewSamples.add(new ViewFlipperViewSample(context));
        mViewSamples.add(new ZoomButtonViewSample(context));
        mViewSamples = Collections.unmodifiableList(mViewSamples);
    }

    /** Return an unmodifiable list of ViewSamples, though the underlying view is still mutable. */
    public List<ViewSample> getViewSamples() {
        return mViewSamples;
    }

}
