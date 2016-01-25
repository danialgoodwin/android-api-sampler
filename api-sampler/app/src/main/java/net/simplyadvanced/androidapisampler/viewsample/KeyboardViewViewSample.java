/**
 * Created by Danial Goodwin on 2016-01-25.
 */
package net.simplyadvanced.androidapisampler.viewsample;

import android.content.Context;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import net.simplyadvanced.androidapisampler.R;
import net.simplyadvanced.androidapisampler.ViewSample;

/**
 *
 */
public class KeyboardViewViewSample implements ViewSample {

    private Context mContext;
    private View mRootView;

    public KeyboardViewViewSample(@NonNull Context context) {
        mContext = context;
    }

    @NonNull
    @Override
    public String getName() {
        return "KeyboardView";
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
            LayoutInflater inflater = LayoutInflater.from(mContext);
            View view = inflater.inflate(R.layout.keyboardview, null);

            KeyboardView kv = (KeyboardView) view.findViewById(R.id.keyboardview);

            Keyboard keyboard = new Keyboard(mContext, R.xml.keyboard);

//            KeyboardView kv = new KeyboardView(mContext, null);
            kv.setKeyboard(keyboard);
            kv.setOnKeyboardActionListener(new KeyboardView.OnKeyboardActionListener() {
                @Override
                public void onPress(int primaryCode) {

                }

                @Override
                public void onRelease(int primaryCode) {

                }

                @Override
                public void onKey(int primaryCode, int[] keyCodes) {
                    Toast.makeText(mContext, "onKey(primaryCode=" + primaryCode + ", ...)", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onText(CharSequence text) {
                    Toast.makeText(mContext, "onText(text=" + text + ", ...)", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void swipeLeft() {

                }

                @Override
                public void swipeRight() {

                }

                @Override
                public void swipeDown() {

                }

                @Override
                public void swipeUp() {

                }
            });

            mRootView = view;
        }
        return mRootView;
    }

    @Nullable
    @Override
    public View getViewCompat() {
        return null;
    }

}
