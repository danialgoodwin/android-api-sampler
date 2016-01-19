/**
 * Created by Danial Goodwin on 2016-01-19.
 */
package net.simplyadvanced.androidapisampler.viewsample;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ViewSwitcher;

import net.simplyadvanced.androidapisampler.ViewSample;

import java.util.Random;

/**
 *
 * Three ImageSwitcher are sampled here. There only difference is the animation when changing image.
 * - minimal: no animation
 * - fade: fade animation
 * - slide: slide animation
 */
public class ImageSwitcherViewSample implements ViewSample {

    private Context mContext;
    private LinearLayout mRootView;

    private int[] mImageResourceIds = {android.R.drawable.ic_input_add, android.R.drawable.ic_delete, android.R.drawable.ic_media_play, android.R.drawable.ic_media_pause};
    private int mCounter = 0;

    public ImageSwitcherViewSample(@NonNull Context context) {
        mContext = context;
    }

    @NonNull
    @Override
    public String getName() {
        return "ImageSwitcher";
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
            final ImageSwitcher minimal = newImageSwitcher(mContext);
            final ImageSwitcher fade = newImageSwitcher(mContext);
            fade.setInAnimation(AnimationUtils.loadAnimation(mContext, android.R.anim.fade_in));
            fade.setOutAnimation(AnimationUtils.loadAnimation(mContext, android.R.anim.fade_out));
            final ImageSwitcher slide = newImageSwitcher(mContext);
            slide.setInAnimation(AnimationUtils.loadAnimation(mContext, android.R.anim.slide_in_left));
            slide.setOutAnimation(AnimationUtils.loadAnimation(mContext, android.R.anim.slide_out_right));

            Button button = new Button(mContext);
            button.setText("run");
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mCounter = ++mCounter % mImageResourceIds.length;
                    minimal.setImageResource(mImageResourceIds[mCounter]);
                    fade.setImageResource(mImageResourceIds[mCounter]);
                    slide.setImageResource(mImageResourceIds[mCounter]);
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

    private @NonNull ImageSwitcher newImageSwitcher(@NonNull Context context) {
        ImageSwitcher ts = new ImageSwitcher(context);
        ts.setFactory(mFactory);
        return ts;
    }

    /**
     * The {@link ViewSwitcher.ViewFactory} used to create {@link ImageView}s that the
     * {@link ImageSwitcher} will switch between.
     */
    private ViewSwitcher.ViewFactory mFactory = new ViewSwitcher.ViewFactory() {
        @Override
        public View makeView() {
            ImageView iv = new ImageView(mContext);
//            iv.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL);
            return iv;
        }
    };

}
