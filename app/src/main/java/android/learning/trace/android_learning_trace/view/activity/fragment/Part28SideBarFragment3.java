package android.learning.trace.android_learning_trace.view.activity.fragment;

import android.learning.trace.android_learning_trace.R;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Part28SideBarFragment3 extends Fragment {

    public static Part28SideBarFragment3 getInstance(String content) {
        Part28SideBarFragment3 part28SideBarFragment3 = LazzyHolder.Instance;
        Bundle bundle = new Bundle();
        bundle.putString("content", content);
        part28SideBarFragment3.setArguments(bundle);
        return part28SideBarFragment3;
    }

    /**
     * Called to have the fragment instantiate its user interface view.
     * This is optional, and non-graphical fragments can return null (which
     * is the default implementation).  This will be called between
     * {@link #onCreate(Bundle)} and {@link #onActivityCreated(Bundle)}.
     * <p>
     * <p>If you return a View from here, you will later be called in
     * {@link #onDestroyView} when the view is being released.
     *
     * @param inflater           The LayoutInflater object that can be used to inflate
     *                           any views in the fragment,
     * @param container          If non-null, this is the parent view that the fragment's
     *                           UI should be attached to.  The fragment should not add the view itself,
     *                           but this can be used to generate the LayoutParams of the view.
     * @param savedInstanceState If non-null, this fragment is being re-constructed
     *                           from a previous saved state as given here.
     * @return Return the View for the fragment's UI, or null.
     */
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_p28_fragment_sidebar3, container, false);
        TextView tvContent = view.findViewById(R.id.tv_p28_sidebar3_content);
        tvContent.setText(getArguments().getString("content"));
        return view;
    }

    private static class LazzyHolder {
        private static final Part28SideBarFragment3 Instance = new Part28SideBarFragment3();
    }
}
