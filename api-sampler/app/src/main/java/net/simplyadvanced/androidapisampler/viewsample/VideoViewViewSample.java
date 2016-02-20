/**
 * Created by Danial Goodwin on 2016-02-19.
 */
package net.simplyadvanced.androidapisampler.viewsample;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.VideoView;

import net.simplyadvanced.androidapisampler.R;
import net.simplyadvanced.androidapisampler.ViewSample;
import net.simplyadvanced.util.android.LayoutUtils;

/**
 * TODO: Add sample for media controls too: http://examples.javacodegeeks.com/android/android-videoview-example/
 */
public class VideoViewViewSample implements ViewSample {

    private Context mContext;
    private LinearLayout mRootView;

    public VideoViewViewSample(Context context) {
        mContext = context;
    }

    @NonNull
    @Override
    public String getName() {
        return "VideoView";
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

            VideoView view = new VideoView(mContext);

//            Uri videoUri = Uri.parse("http://www.sample-videos.com/video/mp4/360/big_buck_bunny_360p_2mb.mp4");
//            view.setVideoURI(videoUri);
            view.setVideoPath("android.resource://" + mContext.getPackageName() + "/" + R.raw.sample);

            view.start();

//            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LayoutUtils.getPxFromDp(mContext, 300), LayoutUtils.getPxFromDp(mContext, 200));
            mRootView.addView(view, params);
        }
        return mRootView;
    }

    @Nullable
    @Override
    public View getViewCompat() {
        return null;
    }

}
