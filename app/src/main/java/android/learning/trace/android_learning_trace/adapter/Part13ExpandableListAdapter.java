package android.learning.trace.android_learning_trace.adapter;

import android.content.Context;
import android.learning.trace.android_learning_trace.R;
import android.learning.trace.android_learning_trace.module.CurrentFriendGroups;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

public class Part13ExpandableListAdapter extends BaseExpandableListAdapter {

    private CurrentFriendGroups groups;

    private AppCompatActivity context;

    public Part13ExpandableListAdapter(Context context) {
        this.context = (AppCompatActivity) context;
        groups = new CurrentFriendGroups();
        groups.loadData();
    }


    @Override
    public int getGroupCount() {
        return groups.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return groups.getGroup(groupPosition).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return groups.getGroup(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return groups.getGroup(groupPosition).getFriend(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = context.getLayoutInflater().inflate(R.layout.layout_part13_elv_group, null);
        }
        TextView textView = convertView.findViewById(R.id.tv_p13_group);
        textView.setText(groups.getGroup(groupPosition).getGroupName());
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = context.getLayoutInflater().inflate(R.layout.layout_part13_elv_child, null);
        }
        TextView textView = convertView.findViewById(R.id.tv_p13_child);
        textView.setText(groups.getGroup(groupPosition).getFriend(childPosition).getName());
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
