/**
 * Created by Danial Goodwin on 2016-01-26.
 */
package net.simplyadvanced.androidapisampler.viewsample;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import net.simplyadvanced.androidapisampler.ViewSample;

/**
 *
 */
public class ProgressDialogViewSample implements ViewSample {

    private Context mContext;
    private LinearLayout mRootView;

    public ProgressDialogViewSample(@NonNull Context context) {
        mContext = context;
    }

    @NonNull
    @Override
    public String getName() {
        return "ProgressDialog";
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
//            Button view = new Button(mContext);
//            view.setText("Show progress spinner");
//            view.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    ProgressDialog dialog = new ProgressDialog(mContext);
//                    dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
//                    dialog.setIndeterminate(false);
//                    dialog.setMax(100);
//                    dialog.setProgress(42);
//                    dialog.setTitle("Progress Title");
//                    dialog.show();
//                }
//            });
            Button view2 = new Button(mContext);
            view2.setText("Show progress bar");
            view2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ProgressDialog dialog = new ProgressDialog(mContext);
                    dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                    dialog.setMax(100);
                    dialog.setIndeterminate(false);
                    dialog.setTitle("Progress Title");
                    dialog.show();
                    dialog.setProgress(42);
                }
            });
            Button view3 = new Button(mContext);
            view3.setText("Show indeterminate spinner");
            view3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ProgressDialog dialog = new ProgressDialog(mContext);
                    dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                    dialog.setIndeterminate(true);
                    dialog.setTitle("Progress Title");
                    dialog.show();
//                    dialog.setProgress(42);
//                    dialog.setSecondaryProgress(1);
                }
            });
            Button view4 = new Button(mContext);
            view4.setText("Show indeterminate bar");
            view4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ProgressDialog dialog = new ProgressDialog(mContext);
                    dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                    dialog.setIndeterminate(true);
                    dialog.setTitle("Progress Title");
                    dialog.show();
                }
            });

            mRootView = new LinearLayout(mContext);
            mRootView.setOrientation(LinearLayout.VERTICAL);
//            mRootView.addView(view);
            mRootView.addView(view2);
            mRootView.addView(view3);
            mRootView.addView(view4);
        }
        return mRootView;
    }

    @Nullable
    @Override
    public View getViewCompat() {
        return null;
    }

}
