package android.learning.trace.android_learning_trace.view.customizedView;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

public class Part23MyListView extends ListView {

    public Part23MyListView(Context context) {
        super(context);
    }

    public Part23MyListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Part23MyListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public Part23MyListView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        heightMeasureSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
