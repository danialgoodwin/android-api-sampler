/**
 * Created by Danial Goodwin on 2016-01-18.
 */
package net.simplyadvanced.androidapisampler.viewsample;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import net.simplyadvanced.androidapisampler.ViewSample;

import java.util.Random;

/**
 *
 * Three TextSwitchers are sampled here. There only difference is the animation when changing text.
 * - minimal: no animation
 * - fade: fade animation
 * - slide: slide animation
 *
 * More sample code: https://android.googlesource.com/platform/development/+/4b737b6/samples/browseable/TextSwitcher/src/com.example.android.textswitcher/MainActivity.java
 */
public class TextSwitcherViewSample implements ViewSample {

    private Context mContext;
    private LinearLayout mRootView;

    private Random mRandom = new Random();

    public TextSwitcherViewSample(@NonNull Context context) {
        mContext = context;
    }

    @NonNull
    @Override
    public String getName() {
        return "TextSwitcher";
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
            final TextSwitcher minimal = newTextSwitcher(mContext);
            final TextSwitcher fade = newTextSwitcher(mContext);
            fade.setInAnimation(AnimationUtils.loadAnimation(mContext, android.R.anim.fade_in));
            fade.setOutAnimation(AnimationUtils.loadAnimation(mContext, android.R.anim.fade_out));
            final TextSwitcher slide = newTextSwitcher(mContext);
            slide.setInAnimation(AnimationUtils.loadAnimation(mContext, android.R.anim.slide_in_left));
            slide.setOutAnimation(AnimationUtils.loadAnimation(mContext, android.R.anim.slide_out_right));

            Button button = new Button(mContext);
            button.setText("run");
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    minimal.setText("Random: " + mRandom.nextInt(1000));
                    fade.setText("Random: " + mRandom.nextInt(1000));
                    slide.setText("Random: " + mRandom.nextInt(1000));
                }
            });

            mRootView.addView(button);
            mRootView.addView(minimal);
            mRootView.addView(fade);
            mRootView.addView(slide);
        }
        return mRootView;
    }

    @Nullable
    @Override
    public View getViewCompat() {
        return null;
    }

    private @NonNull TextSwitcher newTextSwitcher(@NonNull Context context) {
        TextSwitcher ts = new TextSwitcher(context);
        ts.setFactory(mFactory);
        return ts;
    }

    /**
     * The {@link android.widget.ViewSwitcher.ViewFactory} used to create {@link android.widget.TextView}s that the
     * {@link android.widget.TextSwitcher} will switch between.
     */
    private ViewSwitcher.ViewFactory mFactory = new ViewSwitcher.ViewFactory() {
        @Override
        public View makeView() {
            TextView tv = new TextView(mContext);
//            tv.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL);
//            tv.setTextAppearance(mContext, android.R.style.TextAppearance_Large);
            return tv;
        }
    };

}
