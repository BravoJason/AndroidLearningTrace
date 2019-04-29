package android.learning.trace.android_learning_trace.view.activity;

import android.learning.trace.android_learning_trace.R;
import android.learning.trace.android_learning_trace.utility.ColorResourceHelper;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.orhanobut.logger.Logger;

public class BasicUIComponentP1Activity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_uicomponent_p1);

        initToast();
        initTextView();
        initButton();
    }

    /**
     * Function to initToast the member values.
     */
    private void initToast() {

        //Initialize the buttons.
        Button btnDisplayTextToast = findViewById(R.id.btn_basicUI_showTextToast);
        Button btnDisplayImageToast = findViewById(R.id.btn_basicUI_showImageToast);
        Button btnShowImageAndToast = findViewById(R.id.btn_basicUI_showTextImageToast);

        //Add onClick callback functions to buttons.
        btnDisplayTextToast.setOnClickListener(v -> {
            //Show toast.
            Toast.makeText(getApplicationContext(), getText(R.string.basicUI_text_toast),
                    Toast.LENGTH_SHORT).show();
        });

        /*
        Note:
              When the anonymous class only has one abstract function, we can use lambda expression
              to replace it.
         */

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

    /**
     * Function to initialize TextView widget.
     */
    private void initTextView() {

        EditText etvEditTextView = findViewById(R.id.etv_basicUI_editText);

        etvEditTextView.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Logger.i("Before changed: " + "s: " + s + ", start: " + start +
                        ", after: " + after + ", count: " + count);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Logger.i("On changing: " + "s: " + s + ", start: " + start +
                        ", before: " + before + ", count: " + count);
            }

            @Override
            public void afterTextChanged(Editable s) {
                Logger.i("After changed: " + "s: " + s);

            }
        });

    }

    /**
     *
     */
    private void initButton() {
        Button btnTextButton = findViewById(R.id.btn_textButton);
        btnTextButton.setOnClickListener((v -> Toast.makeText(this, "Text button.", Toast.LENGTH_SHORT).show()));

        Button btnTransparentButton = findViewById(R.id.btn_tpButton);
        btnTransparentButton.setOnClickListener((view) -> Toast.makeText(
                this,
                "Transparent button.", Toast.LENGTH_SHORT).show());

    }

}
