package android.learning.trace.android_learning_trace.view.activity.fragment;

import android.content.SharedPreferences;
import android.learning.trace.android_learning_trace.R;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Toast;

import java.util.List;

public class Part28FragmentActivity extends AppCompatActivity implements Part28MenuFragment.MenuListener {

    Part28ContentFragment part28ContentFragment;
    Part28MenuFragment part28MenuFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part28_fragment);
        //Get fragment object by fragmentManager.
        part28ContentFragment = new Part28ContentFragment();
        part28MenuFragment = (Part28MenuFragment) getSupportFragmentManager().findFragmentById(R.id.frame_p28_menu);
        addContentLayout();


        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        Toast.makeText(this, Boolean.toString(sp.getBoolean("isMute", false)), Toast.LENGTH_SHORT).show();


    }

    /**
     * Add fragment through code.
     */
    private void addContentLayout() {

        Fragment addFragment = null;


        FragmentManager fm = this.getSupportFragmentManager();

        List<Fragment> fragments = fm.getFragments();
        if (fragments != null) {
            for (Fragment fragment : fragments) {
                if (fragment != null && fragment.isVisible()) {
                    addFragment = fragment;
                }
            }

        }
        //Begin one transaction.
        FragmentTransaction ft = fm.beginTransaction();

        if (addFragment == null) {
            addFragment = part28ContentFragment;
        }

        //Add fragment.
        ft.add(R.id.frame_p28_sideBar, addFragment);

        //Submit the transaction.
        ft.commit();


    }

    public void ChangeSideBarOneClick(View view) {
        Part28SideBarFragment1 part28SideBarFragment1 = new Part28SideBarFragment1();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frame_p28_sideBar, part28SideBarFragment1);
        //Add fragment into activity stack.
        ft.addToBackStack(null);
        ft.commit();

    }

    public void ChangeSideBarTwoClick(View view) {
        Part28SideBarFragment2 part28SideBarFragment2 = new Part28SideBarFragment2();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frame_p28_sideBar, part28SideBarFragment2);
        //Add fragment into activity stack.
        ft.addToBackStack(null);
        ft.commit();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_BACK:
                if (getSupportFragmentManager().getBackStackEntryCount() == 0) {
                    finish();
                } else {
                    getSupportFragmentManager().popBackStack();
                }
                return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    public void ChangeSideBarWithParameterClick(View view) {
        Part28SideBarFragment3 part28SideBarFragment3 = Part28SideBarFragment3.getInstance("Part28SideBarFragment3");
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frame_p28_sideBar, part28SideBarFragment3);
        ft.addToBackStack(null);
        ft.commit();
    }

    @Override
    public void ChangeValue(String value) {
        part28ContentFragment.updateContent(value);


    }
}
