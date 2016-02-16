/**
 * Created by Danial Goodwin on 2016-02-16.
 */
package net.simplyadvanced.androidapisampler.viewsample;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.webkit.WebView;
import android.widget.LinearLayout;

import net.simplyadvanced.androidapisampler.ViewSample;

/**
 *
 */
public class WebViewViewSample implements ViewSample {

    private Context mContext;
    private LinearLayout mRootView;

    public WebViewViewSample(Context context) {
        mContext = context;
    }

    @NonNull
    @Override
    public String getName() {
        return "WebView";
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

            // Inflammable means flammable? What a country.
            String longText = "Collaboratively administrate empowered markets via plug-and-play networks. Dynamically procrastinate B2C users after installed base benefits. Dramatically visualize customer directed convergence without revolutionary ROI.\n" +
                    "\n" +
                    "Efficiently unleash cross-media information without cross-media value. Quickly maximize timely deliverables for real-time schemas. Dramatically maintain clicks-and-mortar solutions without functional solutions.";

            String data = "<html><body bgcolor=\"#03A9F4\">" +
                    "<h1>Hello, World!</h1>" +
                    "<p align=\"justify\">" + longText + "</p>" +
                    "</body></html>";
            String mimeType = "text/html";
            String encoding = "utf-8";

            WebView view = new WebView(mContext);
//            view.loadData();
            view.loadDataWithBaseURL(null, data, mimeType, encoding, null);
//            view.loadUrl("file:///android_asset/filename.html");

            mRootView.addView(view);
        }
        return mRootView;
    }

    @Nullable
    @Override
    public View getViewCompat() {
        return null;
    }

}
