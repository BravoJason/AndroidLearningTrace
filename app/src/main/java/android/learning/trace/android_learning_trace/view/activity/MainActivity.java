
package android.learning.trace.android_learning_trace.view.activity;

import android.content.Intent;
import android.learning.trace.android_learning_trace.R;
import android.learning.trace.android_learning_trace.view.activity.XML.Part33XMLActivity;
import android.learning.trace.android_learning_trace.view.activity.actionBar.Part29ActionBarActivity;
import android.learning.trace.android_learning_trace.view.activity.asynctask.Part31AsyncTaskActivity;
import android.learning.trace.android_learning_trace.view.activity.broadcast.Part27BroadcastActivity;
import android.learning.trace.android_learning_trace.view.activity.filemanage.Part32FileManageActivity;
import android.learning.trace.android_learning_trace.view.activity.fragment.Part28FragmentActivity;
import android.learning.trace.android_learning_trace.view.activity.handler.Part30HandlerActivity;
import android.learning.trace.android_learning_trace.view.activity.handler.Part30SplashActivity;
import android.learning.trace.android_learning_trace.view.activity.intent.Part25IntentActivity;
import android.learning.trace.android_learning_trace.view.activity.service.Part26ServiceActivity;
import android.learning.trace.android_learning_trace.view.activity.ui.BasicUIComponentP3Activity;
import android.learning.trace.android_learning_trace.view.activity.ui.BasicUIComponentP4Activity;
import android.learning.trace.android_learning_trace.view.activity.ui.Part10Activity;
import android.learning.trace.android_learning_trace.view.activity.ui.Part11Activity;
import android.learning.trace.android_learning_trace.view.activity.ui.Part12Activity;
import android.learning.trace.android_learning_trace.view.activity.ui.Part13Activity;
import android.learning.trace.android_learning_trace.view.activity.ui.Part14Activity;
import android.learning.trace.android_learning_trace.view.activity.ui.Part15Activity;
import android.learning.trace.android_learning_trace.view.activity.ui.Part16Activity;
import android.learning.trace.android_learning_trace.view.activity.ui.Part17Activity;
import android.learning.trace.android_learning_trace.view.activity.ui.Part18Activity;
import android.learning.trace.android_learning_trace.view.activity.ui.Part19Activity;
import android.learning.trace.android_learning_trace.view.activity.ui.Part1TextView_Toast_ButtonActivity;
import android.learning.trace.android_learning_trace.view.activity.ui.Part20StyleActivity;
import android.learning.trace.android_learning_trace.view.activity.ui.Part21ThemeActivity;
import android.learning.trace.android_learning_trace.view.activity.ui.Part22CustomizedViewActivity;
import android.learning.trace.android_learning_trace.view.activity.ui.Part23ScrollListViewActivity;
import android.learning.trace.android_learning_trace.view.activity.ui.Part24ActivityConceptActivity;
import android.learning.trace.android_learning_trace.view.activity.ui.Part2CBtn_RBtn_RGp_TBtn_Switch_RatingBarActivity;
import android.learning.trace.android_learning_trace.view.activity.ui.Part5Activity;
import android.learning.trace.android_learning_trace.view.activity.ui.Part6Activity;
import android.learning.trace.android_learning_trace.view.activity.ui.Part7Activity;
import android.learning.trace.android_learning_trace.view.activity.ui.Part8Activity;
import android.learning.trace.android_learning_trace.view.activity.ui.Part9Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Logger.addLogAdapter(new AndroidLogAdapter());

        init();


    }


    /**
     * Function to initialize the UI member values.
     */
    private void init() {
        //Init button views.
        Button btnShowBasicUIP1Activity = findViewById(R.id.btn_basicUI_show_p1);
        Button btnShowBasicUIP2Activity = findViewById(R.id.btn_basicUI_show_p2);
        Button btnShowBasicUIP3Activity = findViewById(R.id.btn_basicUI_show_p3);
        Button btnShowBasicUIP4Activity = findViewById(R.id.btn_basicUI_show_p4);
        Button btnShowPart5 = findViewById(R.id.btn_main_showPart5);
        Button btnShowPart6 = findViewById(R.id.btn_main_showPart6);
        Button btnShowPart7 = findViewById(R.id.btn_main_showPart7);
        Button btnShowPart8 = findViewById(R.id.btn_main_showPart8);
        Button btnShowPart9 = findViewById(R.id.btn_main_showPart9);
        Button btnShowPart10 = findViewById(R.id.btn_main_showPart10);
        Button btnShowPart11 = findViewById(R.id.btn_main_showPart11);
        Button btnShowPart12 = findViewById(R.id.btn_main_showPart12);
        Button btnShowPart13 = findViewById(R.id.btn_main_showPart13);
        Button btnShowPart14 = findViewById(R.id.btn_main_showPart14);
        Button btnShowPart15 = findViewById(R.id.btn_main_showPart15);
        Button btnShowPart16 = findViewById(R.id.btn_main_showPart16);
        Button btnShowPart17 = findViewById(R.id.btn_main_showPart17);
        Button btnShowPart18 = findViewById(R.id.btn_main_showPart18);
        Button btnShowPart19 = findViewById(R.id.btn_main_showPart19);
        Button btnShowPart20Style = findViewById(R.id.btn_main_showPart20_style);
        Button btnShowPart21Theme = findViewById(R.id.btn_main_showPart21_theme);
        Button btnShowPart22CustomizedWidget = findViewById(R.id.btn_main_showPart22_customized_widget);
        Button btnShowPart23ScrollListView = findViewById(R.id.btn_main_showPart23_scroll_list_view);
        Button banShowPart24ActivityConcept = findViewById(R.id.btn_main_showPart24_activity_concept);
        Button btnShowPart25IntentConcept = findViewById(R.id.btn_main_showPart25_intent);
        Button btnShowPart26ServiceConcept = findViewById(R.id.btn_main_showPart26_service);
        Button btnShowPart27Broadcast = findViewById(R.id.btn_main_showPart27_broadcast);
        Button btnShowPart28Fragment = findViewById(R.id.btn_main_showPart28_fragment);
        Button btnShowPart29ActionBar = findViewById(R.id.btn_main_showPart29_actionbar);
        Button btnShowPart30Handler = findViewById(R.id.btn_main_showPart30_handler);
        Button btnShowPart30SplashPage = findViewById(R.id.btn_main_showPart30_splash_page);
        Button btnShowPart31AsyncTask = findViewById(R.id.btn_main_showPart31_async_task);
        Button btnShowPart32FileManage = findViewById(R.id.btn_main_showPart32_file_manage);
        Button btnShowPart33XML = findViewById(R.id.btn_main_showPart33_XML);



        //Init Basic UI activity intent.
        Intent basicUIP1Intent = new Intent(getApplicationContext(), Part1TextView_Toast_ButtonActivity.class);
        Intent basicUIP2Intent = new Intent(getApplicationContext(), Part2CBtn_RBtn_RGp_TBtn_Switch_RatingBarActivity.class);
        Intent basicUIP3Intent = new Intent(this, BasicUIComponentP3Activity.class);
        Intent basicUIP4Intent = new Intent(this, BasicUIComponentP4Activity.class);
        Intent p5Intent = new Intent(this, Part5Activity.class);
        Intent p6Intent = new Intent(this, Part6Activity.class);
        Intent p7Intent = new Intent(this, Part7Activity.class);
        Intent p8Intent = new Intent(this, Part8Activity.class);
        Intent p9Intent = new Intent(this, Part9Activity.class);
        Intent p10Intent = new Intent(this, Part10Activity.class);
        Intent p11Intent = new Intent(this, Part11Activity.class);
        Intent p12Intent = new Intent(this, Part12Activity.class);
        Intent p13Intent = new Intent(this, Part13Activity.class);
        Intent p14Intent = new Intent(this, Part14Activity.class);
        Intent p15Intent = new Intent(this, Part15Activity.class);
        Intent p16Intent = new Intent(this, Part16Activity.class);
        Intent p17Intent = new Intent(this, Part17Activity.class);
        Intent p18Intent = new Intent(this, Part18Activity.class);
        Intent p19Intent = new Intent(this, Part19Activity.class);
        Intent p20StyleIntent = new Intent(this, Part20StyleActivity.class);
        Intent p21ThemeIntent = new Intent(this, Part21ThemeActivity.class);
        Intent p22CustomizedViewIntent = new Intent(this, Part22CustomizedViewActivity.class);
        Intent p23ScrollListViewIntent = new Intent(this, Part23ScrollListViewActivity.class);
        Intent p24ActivityConceptIntent = new Intent(this, Part24ActivityConceptActivity.class);
        Intent p25Intent = new Intent(this, Part25IntentActivity.class);
        Intent p26Intent = new Intent(this, Part26ServiceActivity.class);
        Intent p27Intent = new Intent(this, Part27BroadcastActivity.class);
        Intent p28Intent = new Intent(this, Part28FragmentActivity.class);
        Intent p29Intent = new Intent(this, Part29ActionBarActivity.class);
        Intent p30HandlerIntent = new Intent(this, Part30HandlerActivity.class);
        Intent p30SplashPageIntent = new Intent(this, Part30SplashActivity.class);
        Intent p31AsyncTaskIntent = new Intent(this, Part31AsyncTaskActivity.class);
        Intent p32FileManageIntent = new Intent(this, Part32FileManageActivity.class);
        Intent p33XMLIntent = new Intent(this, Part33XMLActivity.class);

        //Set button onClick callback listener.
        btnShowBasicUIP1Activity.setOnClickListener(v -> startActivity(basicUIP1Intent));
        btnShowBasicUIP2Activity.setOnClickListener(v -> startActivity(basicUIP2Intent));
        btnShowBasicUIP3Activity.setOnClickListener(v -> startActivity(basicUIP3Intent));
        btnShowBasicUIP4Activity.setOnClickListener(v -> startActivity(basicUIP4Intent));
        btnShowPart5.setOnClickListener(v -> startActivity(p5Intent));
        btnShowPart6.setOnClickListener(v -> startActivity(p6Intent));
        btnShowPart7.setOnClickListener(v -> startActivity(p7Intent));
        btnShowPart8.setOnClickListener(v -> startActivity(p8Intent));
        btnShowPart9.setOnClickListener(v -> startActivity(p9Intent));
        btnShowPart10.setOnClickListener(v -> startActivity(p10Intent));
        btnShowPart11.setOnClickListener(v -> startActivity(p11Intent));
        btnShowPart12.setOnClickListener(v -> startActivity(p12Intent));
        btnShowPart13.setOnClickListener(v -> startActivity(p13Intent));
        btnShowPart14.setOnClickListener(v -> startActivity(p14Intent));
        btnShowPart15.setOnClickListener(v -> startActivity(p15Intent));
        btnShowPart16.setOnClickListener(v -> startActivity(p16Intent));
        btnShowPart17.setOnClickListener(v -> startActivity(p17Intent));
        btnShowPart18.setOnClickListener(v -> startActivity(p18Intent));
        btnShowPart19.setOnClickListener(v -> startActivity(p19Intent));
        btnShowPart20Style.setOnClickListener(v -> startActivity(p20StyleIntent));
        btnShowPart21Theme.setOnClickListener(v -> startActivity(p21ThemeIntent));
        btnShowPart22CustomizedWidget.setOnClickListener(v -> startActivity(p22CustomizedViewIntent));
        btnShowPart23ScrollListView.setOnClickListener(v -> startActivity(p23ScrollListViewIntent));
        banShowPart24ActivityConcept.setOnClickListener(v -> startActivity(p24ActivityConceptIntent));
        btnShowPart25IntentConcept.setOnClickListener(v -> startActivity(p25Intent));
        btnShowPart26ServiceConcept.setOnClickListener(v -> startActivity(p26Intent));
        btnShowPart27Broadcast.setOnClickListener(v -> startActivity(p27Intent));
        btnShowPart28Fragment.setOnClickListener(v -> startActivity(p28Intent));
        btnShowPart29ActionBar.setOnClickListener(v -> startActivity(p29Intent));
        btnShowPart30Handler.setOnClickListener(view -> startActivity(p30HandlerIntent));
        btnShowPart30SplashPage.setOnClickListener(view -> startActivity(p30SplashPageIntent));
        btnShowPart31AsyncTask.setOnClickListener(v -> startActivity(p31AsyncTaskIntent));
        btnShowPart32FileManage.setOnClickListener(v -> startActivity(p32FileManageIntent));
        btnShowPart33XML.setOnClickListener(v -> startActivity(p33XMLIntent));

    }
}
