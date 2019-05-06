// IPart26AidlInterface.aidl
package android.learning.trace.android_learning_trace.service;

import android.learning.trace.android_learning_trace.model.Part26ServiceInfo;




// Declare any non-default types here with import statements

interface IPart26AidlInterface {

    Part26ServiceInfo getServiceInfo();

    void setName(String name);

    String desc();
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
            double aDouble, String aString);
}
