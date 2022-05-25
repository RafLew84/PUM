package pl.edu.uwr.pum.wfiappjava;

import android.os.Parcel;
import android.os.Parcelable;

public class Institute implements Parcelable {
    private final String title;
    private final String info;
    private final int imageResource;

    public Institute(String title, String info, int imageResource) {
        this.title = title;
        this.info = info;
        this.imageResource = imageResource;
    }

    protected Institute(Parcel in) {
        title = in.readString();
        info = in.readString();
        imageResource = in.readInt();
    }

    public static final Creator<Institute> CREATOR = new Creator<Institute>() {
        @Override
        public Institute createFromParcel(Parcel in) {
            return new Institute(in);
        }

        @Override
        public Institute[] newArray(int size) {
            return new Institute[size];
        }
    };

    public String getTitle() {
        return title;
    }

    public String getInfo() {
        return info;
    }

    public int getImageResource() {
        return imageResource;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(title);
        parcel.writeString(info);
        parcel.writeInt(imageResource);
    }
}
