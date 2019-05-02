package android.learning.trace.android_learning_trace.utility;

import android.app.Activity;
import android.util.DisplayMetrics;

public class ScreenSizeHelper {


    /**
     * Return the device screen display Metrics in {@link DisplayMetrics} type.
     *
     * @param activityContext Current screen holder {@link Activity} object.
     * @return Current screen {@link DisplayMetrics} object.
     */
    public static DisplayMetrics getScreenDisplayMetrics(Activity activityContext) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activityContext.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics;

    }


}
