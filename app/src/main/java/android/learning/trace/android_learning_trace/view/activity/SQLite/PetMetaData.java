package android.learning.trace.android_learning_trace.view.activity.SQLite;

import android.provider.BaseColumns;

public final class PetMetaData {
    private PetMetaData() {
    }


    public static abstract class Dog implements BaseColumns {

        public static final String TABLE_NAME = "dog";
        public static final String NAME = "name";
        public static final String AGE = "age";

    }
}
