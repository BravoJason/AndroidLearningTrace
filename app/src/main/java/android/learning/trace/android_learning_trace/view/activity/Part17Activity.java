package android.learning.trace.android_learning_trace.view.activity;

import android.app.Activity;
import android.learning.trace.android_learning_trace.R;
import android.learning.trace.android_learning_trace.adapter.Part17PagerAdapter;
import android.learning.trace.android_learning_trace.utility.ColorResourceHelper;
import android.os.Bundle;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class Part17Activity extends Activity {

    private ViewPager viewPager;
    private PagerTabStrip pagerTabStrip;
    private String[] titles = {"Dog1", "Dog2", "Dog3", "Dog4"};
    private ArrayList<View> views = new ArrayList<>();
    private ViewPager.OnPageChangeListener pageChangeListener;
    private LinearLayout linearLayoutIndicator;
    private ImageView[] imageViews;
    private int currentIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part17);

        initViewPager();
        initPoint();

    }

    private void initViewPager() {
        viewPager = findViewById(R.id.vp_part17);
        pagerTabStrip = findViewById(R.id.pts_part17_vp);

        views.add(getLayoutInflater().inflate(R.layout.layout_viewpager_item1, null));
        views.add(getLayoutInflater().inflate(R.layout.layout_viewpager_item2, null));
        views.add(getLayoutInflater().inflate(R.layout.layout_viewpager_item3, null));
        views.add(getLayoutInflater().inflate(R.layout.layout_viewpager_item4, null));
        Part17PagerAdapter part17PagerAdapter = new Part17PagerAdapter(views);
        viewPager.setAdapter(part17PagerAdapter);
        pagerTabStrip.setBackgroundColor(ColorResourceHelper.getColorWrapper(this, android.R.color.holo_blue_light));
        pagerTabStrip.setTabIndicatorColor(ColorResourceHelper.getColorWrapper(this, android.R.color.holo_blue_bright));
        pagerTabStrip.setTextColor(ColorResourceHelper.getColorWrapper(this, android.R.color.white));
        //Set default view.
        viewPager.setCurrentItem(0);
        pageChangeListener = new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                Toast.makeText(Part17Activity.this, "Page----" + position, Toast.LENGTH_SHORT).show();
                setCurrentIndicator(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        };
        viewPager.addOnPageChangeListener(pageChangeListener);

    }

    private void initPoint() {
        linearLayoutIndicator = findViewById(R.id.layout_linear_indicator);
        imageViews = new ImageView[views.size()];
        for (int i = 0; i < imageViews.length; i++) {
            imageViews[i] = (ImageView) linearLayoutIndicator.getChildAt(i);
        }
        currentIndex = 0;
        imageViews[currentIndex].setImageResource(R.drawable.ic_launcher_foreground);

    }

    private void setCurrentIndicator(int position) {
        if (!(currentIndex < 0 || currentIndex == position || currentIndex > imageViews.length)) {

            imageViews[currentIndex].setImageResource(R.drawable.ic_launcher_background);
            imageViews[position].setImageResource(R.drawable.ic_launcher_foreground);
            currentIndex = position;
        }
    }

    @Override
    protected void onDestroy() {
        if (viewPager != null && pageChangeListener != null) {
            viewPager.removeOnPageChangeListener(pageChangeListener);
            pageChangeListener = null;
            Toast.makeText(this, "Destory pageChangeListener", Toast.LENGTH_SHORT).show();
        }
        super.onDestroy();
    }
}
