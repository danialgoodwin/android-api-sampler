/**
 * Created by Danial Goodwin on 2016-02-10.
 */
package net.simplyadvanced.androidapisampler.viewsample;

import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import net.simplyadvanced.androidapisampler.ViewSample;

/**
 *
 */
public class ToolbarViewSample implements ViewSample {

    private Context mContext;
    private LinearLayout mRootView;

    public ToolbarViewSample(Context context) {
        mContext = context;
    }

    @NonNull
    @Override
    public String getName() {
        return "Toolbar";
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

            Toolbar view = new Toolbar(mContext);
            view.setTitle("Title");
            view.setSubtitle("Subtitle");

            Menu menu = view.getMenu();
            menu.add(0, 1, 0, "Option 1");
            MenuItem menuItem = menu.add(0, 2, 0, "Option 2");
            menuItem.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
            menuItem.setIcon(android.R.drawable.ic_menu_compass);

            view.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {
                    switch (item.getItemId()) {
                        case 1:
                            Toast.makeText(mContext, "Selected 1", Toast.LENGTH_SHORT).show();
                            return true;
                        case 2:
                            Toast.makeText(mContext, "Selected 2", Toast.LENGTH_SHORT).show();
                            return true;
                    }
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
