package android.learning.trace.android_learning_trace.view.activity.JSON;

import android.support.annotation.NonNull;

public class User {

    private String firstName;
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    @NonNull
    public String toString() {
        return "First Name---" + firstName + "  Last Name---" + lastName;
    }
}
