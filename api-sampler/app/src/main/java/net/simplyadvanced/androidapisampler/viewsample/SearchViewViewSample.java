/**
 * Created by Danial Goodwin on 2016-02-05.
 */
package net.simplyadvanced.androidapisampler.viewsample;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.SearchView;
import android.widget.Toast;

import net.simplyadvanced.androidapisampler.ViewSample;

/**
 *
 */
public class SearchViewViewSample implements ViewSample {

    private Context mContext;
    private LinearLayout mRootView;

    public SearchViewViewSample(Context context) {
        mContext = context;
    }

    @NonNull
    @Override
    public String getName() {
        return "SearchView";
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

            SearchView view = new SearchView(mContext);
//            view.setIconifiedByDefault(false);
            view.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {
                    Toast.makeText(mContext, "query=" + query, Toast.LENGTH_SHORT).show();
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String newText) {
                    return false;
                }
            });

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
