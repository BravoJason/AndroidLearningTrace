package android.learning.trace.android_learning_trace.model.entity;

import java.util.Vector;

public class FriendGroup {

    private String groupName;
    private Vector<Friend> group;

    public FriendGroup(String groupName) {
        this.groupName = groupName;
        group = new Vector<>();

    }

    public String getGroupName() {
        return groupName;
    }

    public void mockBuildGroup() {
        if (group == null) {
            group = new Vector<>();
        }
        for (int i = 0; i < 10; i++) {
            group.add(new Friend(groupName + i));
        }
    }

    public int size() {
        return group.size();
    }

    public Friend getFriend(int index) {
        return group.get(index);
    }
}
