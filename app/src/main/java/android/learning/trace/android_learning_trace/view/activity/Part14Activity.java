package android.learning.trace.android_learning_trace.view.activity;

import android.learning.trace.android_learning_trace.R;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

public class Part14Activity extends AppCompatActivity {

    ImageSwitcher imageSwitcher;
    TextSwitcher textSwitcher;
    float startX = 0.0f;
    float endX = 0.0f;
    private int[] images = {R.mipmap.p1, R.mipmap.p2, R.mipmap.p3};
    private int imageIndex;
    private String[] texts = {"1", "2", "3", "4"};
    private int textIndex;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part14);
        initImageSwitcher();
        initTextSwitcher();
    }

    void initImageSwitcher() {
        imageSwitcher = findViewById(R.id.is_p14);
        imageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView iv = new ImageView(getApplicationContext());
                iv.setImageResource(images[0]);
                iv.setLayoutParams(new ImageSwitcher.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
                return iv;
            }
        });
        imageSwitcher.setOnTouchListener((v, event) -> {
            //Get current touch action.
            int action = event.getAction();
            if (action == MotionEvent.ACTION_DOWN) {
                startX = event.getX();
                return true;
            } else if (action == MotionEvent.ACTION_UP) {
                endX = event.getX();
                if (startX - endX > 20) {
                    //Slide from right to left.
                    //Show the next image.
                    imageIndex = imageIndex + 1 < images.length ? ++imageIndex : imageIndex;
                    imageSwitcher.setInAnimation(getApplicationContext(), android.R.anim.fade_in);
                    imageSwitcher.setOutAnimation(getApplicationContext(), android.R.anim.fade_out);

                } else if (startX - endX < 20) {
                    //Slide from left to right.
                    //Show the previous image.
                    imageSwitcher.setInAnimation(getApplicationContext(), android.R.anim.fade_in);
                    imageSwitcher.setOutAnimation(getApplicationContext(), android.R.anim.fade_out);
                    imageIndex = imageIndex - 1 > 0 ? --imageIndex : 0;
                }
                imageSwitcher.setImageResource(images[imageIndex]);
                v.performClick();
                return true;
            }


            return false;
        });
        imageSwitcher.setOnClickListener(v -> {
            Toast.makeText(this, "Click image.", Toast.LENGTH_SHORT).show();
        });

    }

    void initTextSwitcher() {
        textSwitcher = findViewById(R.id.ts_p14);
        textSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                TextView tv = new TextView(getApplicationContext());
                tv.setText(texts[0]);
                return tv;
            }
        });
        textSwitcher.setOnTouchListener((v, event) -> {
            //Get current touch action.
            int action = event.getAction();
            if (action == MotionEvent.ACTION_DOWN) {
                startX = event.getX();
                return true;
            } else if (action == MotionEvent.ACTION_UP) {
                endX = event.getX();
                if (startX - endX > 20) {
                    //Slide from right to left.
                    //Show the next image.
                    textIndex = textIndex + 1 < texts.length ? ++textIndex : textIndex;
                    textSwitcher.setInAnimation(getApplicationContext(), android.R.anim.fade_in);
                    textSwitcher.setOutAnimation(getApplicationContext(), android.R.anim.fade_out);

                } else if (startX - endX < 20) {
                    //Slide from left to right.
                    //Show the previous image.
                    textSwitcher.setInAnimation(getApplicationContext(), android.R.anim.fade_in);
                    textSwitcher.setOutAnimation(getApplicationContext(), android.R.anim.fade_out);
                    textIndex = textIndex - 1 > 0 ? --textIndex : 0;
                }
                textSwitcher.setText(texts[textIndex]);
                v.performClick();
                return true;
            }


            return false;
        });
    }


}
