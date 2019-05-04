package android.learning.trace.android_learning_trace.view.activity;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.learning.trace.android_learning_trace.R;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Spinner;

import com.orhanobut.logger.Logger;

/**
 * Intent components:
 * 1. Component
 * 2. Action
 * 3. Category
 * 4. Data
 * 5. Type
 * 6. Extras
 * 7. Flags
 */

/**
 * Intent match progress:
 * 1. Load all intents into a table.
 * 2. Remove the intent filters which match action failed.
 * 3. Remove the intent filters which match URI failed.
 * 4. Remove the intent filters which category URI failed.
 * 5. Check whether the number of remain intent filter is 0 or not:
 * 1. Yes, the number is above 0.
 * 1. Sort intent filter in priority order.
 * 2. Return the highest priority intent filter.
 * 2. No, the number is equal to 0.
 * 1. Throw exception.
 */

public class Part25IntentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part25_intent);
    }

    public void SearchIntentByComponentName(View view) {
        //Method1: new Intent(this, Part25IntentTestActivity.class)

        //Method2:
        Intent intent = new Intent();
        ComponentName componentName = new ComponentName(this, Part25IntentTestActivity.class);
        intent.setComponent(componentName);
        startActivity(intent);


        //Method3:
//        Intent intent2 = new Intent();
//        intent2.setClass(this, Part25IntentTestActivity.class);
//        startActivity(intent2);
    }

    public void SearchIntentByAction(View view) {

        //Method 1:
//        Intent intent = new Intent();
//        intent.setAction("android.learning.trace.android_learning_trace.action.INTENT_ACTION_TEST");
//        startActivity(intent);
        //Method 2:
        Intent intent2 = new Intent("android.learning.trace.android_learning_trace.action.INTENT_ACTION_TEST");
        startActivity(intent2);


    }

    public void SearchIntentByCategory(View view) {

        Intent intent = new Intent();
        intent.setAction("android.learning.trace.android_learning_trace.action.INTENT_ACTION_TEST");
        intent.addCategory("android.learning.trace.android_learning_trace.category.INTENT_CATEGORY_TEST");
        startActivity(intent);
    }

    /**
     * Use data and action to search an activity.
     *
     * @param view
     */
    public void SearchIntentByData(View view) {

        Intent intent = new Intent();
        intent.setAction("android.learning.trace.android_learning_trace.action.INTENT_DATA_TEST");
        Uri data = Uri.parse("http://www.google.ca");
        intent.setData(data);
        startActivity(intent);

    }

    //In this method, the new activity won't be triggered.
    //It will jump to browser directly.
    //Usually, we only use one from these.
    public void OpenWebBrowserByIntent(View view) {

        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        Uri address = Uri.parse("http://www.youtube.com");
        intent.setData(address);
        startActivity(intent);
    }


    /**
     * setData() and setType can not use together.
     * If we want to use both, please use setDataAndType() function.
     *
     * @param view
     */
    public void SearchIntentByType(View view) {
        Intent intent = new Intent();
        intent.setAction("android.learning.trace.android_learning_trace.action.INTENT_ACTION_TEST");
        Uri data = Uri.parse("http://www.google.ca");
        intent.setDataAndType(data, "text/html");
        startActivity(intent);
    }

    /**
     * Activity start up mode: Standard
     * Standard:
     * Each time, create a new activity object. Put each activity into activity stack.
     * When exit, retrieve previous activity from the stack.
     * SingleTop:
     * Check the current top of the activity stack.
     * If it is the target activity object, just use it.
     * If it is not, create a new activity object.
     * SingleTask:
     * Check whether the target activity object is in the stack or not.
     * If it exists, pop the stack until meet the target activity object and then use it.
     * If it doesn't exist, create a new one, and push it into stack and use it.
     * SingleInstance:
     * Check whether the activity task stack is existed or not.
     * If it exists, switch to that activity task stack.
     * If it doesn't exist, create a new activity task stack and push the new activity object into stack.
     * Each task stack only allow one activity object in.
     */

    public void StartActivity(View view) {
        Spinner spinner = findViewById(R.id.spinner_p25_activity_mode);
        String mode = spinner.getSelectedItem().toString();
        Intent intent = CreateIntent(Part25StandardStartupActivity.class, mode);
        startActivity(intent);
    }

    private Intent CreateIntent(Class<? extends Activity> classObj, String mode) {
        Intent intent = new Intent(this, classObj);
        switch (mode) {
            case "NewTask":
                //Start the activity on a new task.
                //If the task is existed, then start the activity on the existed task.
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                Logger.i("NewTask");
                break;
            case "Standard":
                break;
            case "SingleTop":
                //Start the activity on SingleTop mode.
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                break;
            case "SingleTask":
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                break;
        }
        return intent;
    }


}
