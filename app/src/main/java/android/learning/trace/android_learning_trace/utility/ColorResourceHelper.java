package android.learning.trace.android_learning_trace.utility;

import android.content.Context;
import android.os.Build;

public class ColorResourceHelper {

    /**
     * reference: https://stackoverflow.com/a/32523573
     */
    public static int getColorWrapper(Context context, int id) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            return context.getColor(id);
        } else {
            //noinspection deprecation
            return context.getResources().getColor(id);
        }
    }
}
