package android.learning.trace.android_learning_trace.view.activity.fragment;


import android.learning.trace.android_learning_trace.R;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Part28ContentFragment extends Fragment {

    TextView tvContent;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.layout_p28_fragment_content, container, false);
        tvContent = view.findViewById(R.id.tv_p28_content);
        return view;
    }


    public void updateContent(String content) {
        tvContent.setText(content);
    }
}
