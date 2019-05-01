package android.learning.trace.android_learning_trace.view.activity;

import android.graphics.Color;
import android.learning.trace.android_learning_trace.R;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class Part16Activity extends AppCompatActivity {

    private TextView textView;
    private Button btn_setSize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part16);
        init();


    }

    private void init() {
        textView = findViewById(R.id.tv_part16_setBGColor);
        btn_setSize = findViewById(R.id.btn_part16_setSize);
        //Register the context menu.
        registerForContextMenu(textView);

        btn_setSize.setOnClickListener(v -> {
            //Inflate the popup menu.
            PopupMenu popupMenu = new PopupMenu(this, btn_setSize);
            MenuInflater inflater = popupMenu.getMenuInflater();
            inflater.inflate(R.menu.menu_part16_popup, popupMenu.getMenu());
            //Set the popup menu items click listener.
            popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {
                    int id = item.getItemId();
                    switch (id) {
                        case R.id.item_popup_p16_s:
                            Toast.makeText(Part16Activity.this, "You choose S.", Toast.LENGTH_SHORT).show();
                            break;
                        case R.id.item_popup_p16_m:
                            Toast.makeText(Part16Activity.this, "You choose M.", Toast.LENGTH_SHORT).show();
                            break;
                        case R.id.item_popup_p16_l:
                            Toast.makeText(Part16Activity.this, "You choose L.", Toast.LENGTH_SHORT).show();
                            break;
                        case R.id.item_popup_p16_xl:
                            Toast.makeText(Part16Activity.this, "You choose XL.", Toast.LENGTH_SHORT).show();
                            break;
                        case R.id.item_popup_p16_xxl:
                            Toast.makeText(Part16Activity.this, "You choose XXL.", Toast.LENGTH_SHORT).show();
                            break;

                    }
                    return false;
                }
            });
            popupMenu.show();

        });
    }

    /**
     * Initialize the contents of the Activity's standard options menu.  You
     * should place your menu items in to <var>menu</var>.
     * <p>
     * <p>This is only called once, the first time the options menu is
     * displayed.  To update the menu every time it is displayed, see
     * {@link #onPrepareOptionsMenu}.
     * <p>
     * <p>The default implementation populates the menu with standard system
     * menu items.  These are placed in the {@link Menu#CATEGORY_SYSTEM} group so that
     * they will be correctly ordered with application-defined menu items.
     * Deriving classes should always call through to the base implementation.
     * <p>
     * <p>You can safely hold on to <var>menu</var> (and any items created
     * from it), making modifications to it as desired, until the next
     * time onCreateOptionsMenu() is called.
     * <p>
     * <p>When you add items to the menu, you can implement the Activity's
     * {@link #onOptionsItemSelected} method to handle them there.
     *
     * @param menu The options menu in which you place your items.
     * @return You must return true for the menu to be displayed;
     * if you return false it will not be shown.
     * @see #onPrepareOptionsMenu
     * @see #onOptionsItemSelected
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        //Set menu by layout file.
        //Get menu inflater.
        getMenuInflater().inflate(R.menu.menu_part16, menu);

        //Set menu items manually.
//        menu.add(0, 100, 1, "Game");
//        menu.add(0, 200, 2, "Video");
//        menu.add(0, 300, 3, "Youtube");

        return true;
    }

    /**
     * This hook is called whenever an item in your options menu is selected.
     * The default implementation simply returns false to have the normal
     * processing happen (calling the item's Runnable or sending a message to
     * its Handler as appropriate).  You can use this method for any items
     * for which you would like to do processing without those other
     * facilities.
     * <p>
     * <p>Derived classes should call through to the base class for it to
     * perform the default menu handling.</p>
     *
     * @param item The menu item that was selected.
     * @return boolean Return false to allow normal menu processing to
     * proceed, true to consume it here.
     * @see #onCreateOptionsMenu
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        switch (id) {
            case R.id.menu_item_game:
                Toast.makeText(this, "Game", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_item_video:
                Toast.makeText(this, "Video", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_item_youtube:
                Toast.makeText(this, "Youtube", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_item_exit:
                Toast.makeText(this, "Exit", Toast.LENGTH_SHORT).show();
                break;
//            case 100:
//                Toast.makeText(this, "Game", Toast.LENGTH_SHORT).show();
//                break;
//            case 200:
//                Toast.makeText(this, "Video", Toast.LENGTH_SHORT).show();
//                break;
//            case 300:
//                Toast.makeText(this, "Youtube", Toast.LENGTH_SHORT).show();
//                break;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * Called when a context menu for the {@code view} is about to be shown.
     * Unlike {@link #onCreateOptionsMenu(Menu)}, this will be called every
     * time the context menu is about to be shown and should be populated for
     * the view (or item inside the view for {@link AdapterView} subclasses,
     * this can be found in the {@code menuInfo})).
     * <p>
     * Use {@link #onContextItemSelected(MenuItem)} to know when an
     * item has been selected.
     * <p>
     * It is not safe to hold onto the context menu after this method returns.
     *
     * @param menu
     * @param v
     * @param menuInfo
     */
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu_part16_context, menu);
    }

    /**
     * This hook is called whenever an item in a context menu is selected. The
     * default implementation simply returns false to have the normal processing
     * happen (calling the item's Runnable or sending a message to its Handler
     * as appropriate). You can use this method for any items for which you
     * would like to do processing without those other facilities.
     * <p>
     * Use {@link MenuItem#getMenuInfo()} to get extra information set by the
     * View that added this menu item.
     * <p>
     * Derived classes should call through to the base class for it to perform
     * the default menu handling.
     *
     * @param item The context menu item that was selected.
     * @return boolean Return false to allow normal context menu processing to
     * proceed, true to consume it here.
     */
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.i_mn_p16_r:
                textView.setBackgroundColor(Color.RED);

                break;
            case R.id.i_mn_p16_g:
                textView.setBackgroundColor(Color.GREEN);
                break;
            case R.id.i_mn_p16_b:
                textView.setBackgroundColor(Color.BLUE);
                break;
            case R.id.i_mn_p16_t:
                textView.setBackgroundColor(Color.TRANSPARENT);
                break;
        }
        return super.onContextItemSelected(item);
    }
}
