/**
 * Created by Danial Goodwin on 2016-01-18.
 */
package net.simplyadvanced.androidapisampler.viewsample;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextSwitcher;
import android.widget.TextView;

import net.simplyadvanced.androidapisampler.ViewSample;

import java.util.Random;

public class TextSwitcherViewSample implements ViewSample {

    private Context mContext;
    private ViewGroup mRootView;
    private TextSwitcher mTextSwitcher;

    private Random mRandom = new Random();

    public TextSwitcherViewSample(@NonNull Context context) {
        mContext = context;
    }

    @NonNull
    @Override
    public View getView() {
        if (mRootView == null) {
            mRootView = new LinearLayout(mContext);
            mTextSwitcher = new TextSwitcher(mContext);
            TextView tv1 = new TextView(mContext);
            tv1.setText("Hello");
            TextView tv2 = new TextView(mContext);
            tv2.setText("World");
//            TextView tv3 = new TextView(mContext);
//            tv1.setText("Hello, World!");
//            TextView tv4 = new TextView(mContext);
//            tv1.setText("Whatever text you want. 1 + 1 = 2");
            mTextSwitcher.addView(tv1);
            mTextSwitcher.addView(tv2);
//            mTextSwitcher.addView(tv3);
//            mTextSwitcher.addView(tv4);

            Button button = new Button(mContext);
            button.setText("activate");
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mTextSwitcher.setText("New text. Random: " + mRandom.nextInt(1000));
                }
            });

            mRootView.addView(mTextSwitcher);
            mRootView.addView(button);
        }
        return mRootView;
    }

    @Nullable
    @Override
    public View getViewCompat() {
        return null;
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

}
