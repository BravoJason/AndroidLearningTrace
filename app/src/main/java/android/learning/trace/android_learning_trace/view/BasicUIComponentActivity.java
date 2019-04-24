package android.learning.trace.android_learning_trace.view;

import android.learning.trace.android_learning_trace.R;
import android.learning.trace.android_learning_trace.utility.ColorResourceHelper;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class BasicUIComponentActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_uicomponent);

        init();
    }

    /**
     * Function to init the member values.
     */
    private void init() {

        //Initialize the buttons.
        Button btnDisplayTextToast = findViewById(R.id.btn_basicUI_showTextToast);
        Button btnDisplayImageToast = findViewById(R.id.btn_basicUI_showImageToast);
        Button btnShowImageAndToast = findViewById(R.id.btn_basicUI_showTextImageToast);

        //Add onClick callback functions to buttons.
        btnDisplayTextToast.setOnClickListener(v -> {
            //Show toast.
            Toast.makeText(getApplicationContext(), getText(R.string.basicUI_text_toast), Toast.LENGTH_SHORT).show();
        });

        //Add onClick callback function by using a Lambda function.
        btnDisplayImageToast.setOnClickListener((v) -> {
            //Get image view.
            ImageView imgToastView = new ImageView(getApplicationContext());
            //Get toast view.
            Toast t = new Toast(getApplicationContext());
            //Get image.
            imgToastView.setImageResource(R.drawable.ic_toast_image);

            imgToastView.setBackgroundColor(
                    ColorResourceHelper.getColorWrapper(
                            getApplicationContext(),
                            R.color.colorToastImageBackground));
            //Set view.
            t.setView(imgToastView);
            t.setDuration(Toast.LENGTH_SHORT);
            //Show.
            t.show();
        });

        //Add onClick callback function by using a Lambda function.
        btnShowImageAndToast.setOnClickListener((v) -> {
            //Get toast.
            Toast toast = Toast.makeText(getApplicationContext(), getText(R.string.basicUI_text_image_toast), Toast.LENGTH_SHORT);
            //Get image view.
            ImageView imageView = new ImageView(getApplicationContext());
            //Set image view content.
            imageView.setBackgroundColor(ColorResourceHelper.getColorWrapper(getApplicationContext(), R.color.colorToastImageBackground));
            imageView.setImageResource(R.drawable.ic_toast_image);
            //Convert toast view to linear layout view.
            LinearLayout toastView = (LinearLayout) toast.getView();
            toastView.setOrientation(LinearLayout.HORIZONTAL);
            //Add image view into toast view.
            toastView.addView(imageView, 0);
            //Show toast view.
            toast.show();
        });


    }


}
