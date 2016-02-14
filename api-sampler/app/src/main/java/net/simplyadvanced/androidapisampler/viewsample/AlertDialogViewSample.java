/**
 * Created by Danial Goodwin on 2016-02-14.
 */
package net.simplyadvanced.androidapisampler.viewsample;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import net.simplyadvanced.androidapisampler.R;
import net.simplyadvanced.androidapisampler.ViewSample;

/**
 *
 */
public class AlertDialogViewSample implements ViewSample {

    private Context mContext;
    private LinearLayout mRootView;

    public AlertDialogViewSample(@NonNull Context context) {
        mContext = context;
    }

    @NonNull
    @Override
    public String getName() {
        return "AlertDialog";
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
            Button view = new Button(mContext);
            view.setText("Show default dialog");
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    new AlertDialog.Builder(mContext)
                            .setTitle("Title")
                            .setMessage("Message")
                            .setIcon(R.mipmap.ic_launcher)
                            .setPositiveButton(android.R.string.ok, null)
                            .setNegativeButton(android.R.string.cancel, null)
                            .show();
                }
            });

            Button view2 = new Button(mContext);
            view2.setText("Show dialog with short list");
            view2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final String[] words = {"a", "b", "c"};
                    new AlertDialog.Builder(mContext)
                            .setTitle("Title")
                            .setItems(words, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Toast.makeText(mContext, "Selected: " + words[which], Toast.LENGTH_SHORT).show();
                                }
                            })
                            .show();
                }
            });

            Button view3 = new Button(mContext);
            view3.setText("Show dialog with long list");
            view3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final String[] words = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
                    new AlertDialog.Builder(mContext)
                            .setTitle("Favorite letter?")
                            .setItems(words, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Toast.makeText(mContext, "Selected: " + words[which], Toast.LENGTH_SHORT).show();
                                }
                            })
                            .show();
                }
            });

            Button view4 = new Button(mContext);
            view4.setText("Show minimalist dialog");
            view4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    new AlertDialog.Builder(mContext)
                            .setTitle("Title")
                            .setMessage("Message")
                            .setPositiveButton(android.R.string.ok, null)
                            .show();
                }
            });

            mRootView = new LinearLayout(mContext);
            mRootView.setOrientation(LinearLayout.VERTICAL);
            mRootView.addView(view);
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
