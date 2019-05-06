// IPart26AidlInterface.aidl
package android.learning.trace.android_learning_trace.service;

// Declare any non-default types here with import statements

interface IPart26AidlInterface {



    void setName(String name);

    String desc();
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
            double aDouble, String aString);
}
