package pl.edu.uwr.pum.parcelableexamplejava;

import android.os.Parcel;
import android.os.Parcelable;

public class Properties implements Parcelable {
    private int a;
    private int b;
    private String c;

    public Properties(int a, int b, String c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    protected Properties(Parcel in) {
        a = in.readInt();
        b = in.readInt();
        c = in.readString();
    }

    public static final Creator<Properties> CREATOR = new Creator<Properties>() {
        @Override
        public Properties createFromParcel(Parcel in) {
            return new Properties(in);
        }

        @Override
        public Properties[] newArray(int size) {
            return new Properties[size];
        }
    };

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    @Override
    public int describeContents() {
        return hashCode();
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(a);
        parcel.writeInt(b);
        parcel.writeString(c);
    }
}
