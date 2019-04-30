package android.learning.trace.android_learning_trace.module;

import android.learning.trace.android_learning_trace.module.entity.FriendGroup;

import java.util.Vector;

public class CurrentFriendGroups {

    private Vector<FriendGroup> currentFriendGroups;

    public CurrentFriendGroups() {
        currentFriendGroups = new Vector<>();
    }

    public int size() {
        return currentFriendGroups.size();
    }

    public FriendGroup getGroup(int index) {
        return currentFriendGroups.get(index);
    }

    public void loadData() {
        mockLoadData();


    }

    private void mockLoadData() {
        if (currentFriendGroups == null) {
            currentFriendGroups = new Vector<>();

        }

        for (int i = 0; i < 10; i++) {
            FriendGroup friendGroup = new FriendGroup("Group" + i);
            friendGroup.mockBuildGroup();
            currentFriendGroups.add(friendGroup);
        }

    }
}
