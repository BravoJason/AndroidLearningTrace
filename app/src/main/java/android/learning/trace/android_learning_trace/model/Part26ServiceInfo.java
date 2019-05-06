package android.learning.trace.android_learning_trace.model;

import android.learning.trace.android_learning_trace.service.Part26Service;
import android.os.Parcel;
import android.os.Parcelable;

public class Part26ServiceInfo implements Parcelable {

    private String serviceName;
    private String serviceJob;



    public Part26ServiceInfo(String serviceName, String serviceJob){
        this.serviceName = serviceName;
        this.serviceJob = serviceJob;
    }

    protected Part26ServiceInfo(Parcel in) {
        serviceName = in.readString();
        serviceJob = in.readString();
    }

    public static final Creator<Part26ServiceInfo> CREATOR = new Creator<Part26ServiceInfo>() {
        @Override
        public Part26ServiceInfo createFromParcel(Parcel in) {
            return new Part26ServiceInfo(in);
        }

        @Override
        public Part26ServiceInfo[] newArray(int size) {
            return new Part26ServiceInfo[size];
        }
    };

    @Override
    public String toString() {
        return "Part26ServiceInfo{" +
                "serviceName='" + serviceName + '\'' +
                ", serviceJob='" + serviceJob + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(serviceName);
        dest.writeString(serviceJob);
    }
}
