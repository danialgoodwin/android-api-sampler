/**
 * Created by Danial on 11/27/2014.
 */
package net.simplyadvanced.util.android;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.TypedValue;

/** Static helper methods related to drawing layouts on screen. */
public class LayoutUtils {

    /** Return the number of pixels equivalent to density-independent pixels for current device */
    public static int getPxFromDp(@NonNull Context context, int dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp,
                context.getResources().getDisplayMetrics());
    }

}
