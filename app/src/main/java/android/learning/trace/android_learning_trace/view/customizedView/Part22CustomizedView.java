package android.learning.trace.android_learning_trace.view.customizedView;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.learning.trace.android_learning_trace.R;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Part22CustomizedView extends View {

    private int textColor;
    private float textSize;
    private String text;
    private Paint paint;


    /**
     * Constructor that is called when inflating a view from XML. This is called
     * when a view is being constructed from an XML file, supplying attributes
     * that were specified in the XML file. This version uses a default style of
     * 0, so the only attribute values applied are those in the Context's Theme
     * and the given AttributeSet.
     * <p>
     * <p>
     * The method onFinishInflate() will be called after all children have been
     * added.
     *
     * @param context The Context the view is running in, through which it can
     *                access the current theme, resources, etc.
     * @param attrs   The attributes of the XML tag that is inflating the view.
     * @see #View(Context, AttributeSet, int)
     */
    public Part22CustomizedView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
        //Get customized view attr.
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.Part22CustomizedView);
        textColor = array.getColor(R.styleable.Part22CustomizedView_textColor, 0x000000);
        textSize = array.getDimension(R.styleable.Part22CustomizedView_textSize, 10);
        text = array.getString(R.styleable.Part22CustomizedView_text);
    }

    /**
     * Implement this to do your drawing.
     *
     * @param canvas the canvas on which the background will be drawn
     */
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setColor(textColor);
        paint.setTextSize(textSize);
        canvas.drawText(text, 50, 50, paint);
    }
}
