package android.learning.trace.android_learning_trace.service;

public class Part26Impl extends IPart26AidlInterface.Stub {

    String name;

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String desc() {

        return "This is Part26Impl, name:" + this.name + ", current thread: " + Thread.currentThread().getName();
    }

    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     *
     * @param anInt
     * @param aLong
     * @param aBoolean
     * @param aFloat
     * @param aDouble
     * @param aString
     */
    @Override
    public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) {

    }
}
