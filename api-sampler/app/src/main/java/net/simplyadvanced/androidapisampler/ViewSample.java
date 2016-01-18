/**
 * Created by Danial Goodwin on 2016-01-18.
 */
package net.simplyadvanced.androidapisampler;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

public interface ViewSample extends Sample {
    @NonNull View getView();
    @Nullable View getViewCompat();
}
