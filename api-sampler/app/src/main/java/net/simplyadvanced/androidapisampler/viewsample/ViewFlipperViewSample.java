/**
 * Created by Danial Goodwin on 2016-01-23.
 */
package net.simplyadvanced.androidapisampler.viewsample;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.widget.ViewFlipper;

import net.simplyadvanced.androidapisampler.ViewSample;

/**
 *
 */
public class ViewFlipperViewSample implements ViewSample {

    private Context mContext;
    private LinearLayout mRootView;

    private int[] mImageResourceIds = {android.R.drawable.ic_input_add, android.R.drawable.ic_delete, android.R.drawable.ic_media_play, android.R.drawable.ic_media_pause};

    public ViewFlipperViewSample(@NonNull Context context) {
        mContext = context;
    }

    @NonNull
    @Override
    public String getName() {
        return "ViewFlipper";
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
            final ViewFlipper vf1 = newViewFlipper(mContext);

            final ViewFlipper vf2 = newViewFlipper(mContext);
            vf2.setInAnimation(AnimationUtils.loadAnimation(mContext, android.R.anim.fade_in));
            vf2.setOutAnimation(AnimationUtils.loadAnimation(mContext, android.R.anim.fade_out));

            final ViewFlipper vf3 = newViewFlipper(mContext);
            vf3.setInAnimation(AnimationUtils.loadAnimation(mContext, android.R.anim.slide_in_left));
            vf3.setOutAnimation(AnimationUtils.loadAnimation(mContext, android.R.anim.slide_out_right));

            final Button button = new Button(mContext);
            button.setText("start");
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    Toast.makeText(mContext, "toggle", Toast.LENGTH_SHORT).show();
                    if (vf1.isFlipping()) {
                        vf1.stopFlipping();
                        vf2.stopFlipping();
                        vf3.stopFlipping();
                        button.setText("start");
                    } else {
                        vf1.startFlipping();
                        vf2.startFlipping();
                        vf3.startFlipping();
                        button.setText("stop");
                    }
                }
            });

            mRootView = new LinearLayout(mContext);
            mRootView.setOrientation(LinearLayout.VERTICAL);
            mRootView.addView(button);
            mRootView.addView(vf1);
            mRootView.addView(vf2);
            mRootView.addView(vf3);
        }
        return mRootView;
    }

    @Nullable
    @Override
    public View getViewCompat() {
        return null;
    }

    private ViewFlipper newViewFlipper(@NonNull Context context) {
        ViewFlipper vf = new ViewFlipper(mContext);
        vf.setAutoStart(false);
        vf.setFlipInterval(1500);
        for (int resourceId : mImageResourceIds) {
            ImageView iv = new ImageView(mContext);
            iv.setImageResource(resourceId);
            vf.addView(iv);
        }
        return vf;
    }

}
