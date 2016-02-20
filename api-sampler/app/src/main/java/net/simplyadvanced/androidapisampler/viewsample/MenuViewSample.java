/**
 * Created by Danial Goodwin on 2016-02-20.
 */
package net.simplyadvanced.androidapisampler.viewsample;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.Toast;

import net.simplyadvanced.androidapisampler.ViewSample;
import net.simplyadvanced.util.android.LayoutUtils;

/**
 *
 */
public class MenuViewSample implements ViewSample {

    private Context mContext;
    private LinearLayout mRootView;

    public MenuViewSample(Context context) {
        mContext = context;
    }

    @NonNull
    @Override
    public String getName() {
        return "Menu";
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

            Button popupMenuButton = new Button(mContext);
            popupMenuButton.setText("PopupMenu");
            popupMenuButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    PopupMenu popup = new PopupMenu(mContext, v);
                    Menu menu = popup.getMenu();
                    menu.add(0, 100, 0, "Option 1");
                    menu.add(0, 101, 0, "Option 2");
                    SubMenu subMenu = menu.addSubMenu("SubMenu");
                    subMenu.setGroupCheckable(1, true, false);
                    subMenu.add(1, 102, 0, "Option 3");
                    subMenu.add(1, 103, 0, "Option 4");
                    // Method 2. Create via XML
//                    MenuInflater inflater = popup.getMenuInflater();
//                    inflater.inflate(R.menu.actions, popup.getMenu());
                    // For API 14+
//                    popup.inflate(R.menu.actions);
                    popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem item) {
                            switch (item.getItemId()) {
                                case 100:
                                case 101:
                                case 102:
                                case 103:
                                    Toast.makeText(mContext, "Selected: " + item.getTitle(), Toast.LENGTH_SHORT).show();
                                    return true;
                            }
                            return false;
                        }
                    });
                    popup.show();
                }
            });

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            params.setMargins(LayoutUtils.getPxFromDp(mContext, 16), 0, LayoutUtils.getPxFromDp(mContext, 16), 0);
            mRootView.addView(popupMenuButton, params);
        }
        return mRootView;
    }

    @Nullable
    @Override
    public View getViewCompat() {
        return null;
    }

}
