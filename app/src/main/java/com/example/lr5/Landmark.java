package com.example.lr5;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

import com.yandex.mapkit.geometry.Point;

import java.time.LocalTime;

public class Landmark implements Parcelable {
    private String name;
    private int descr;
    private LocalTime StworkTime;
    private LocalTime FinworkTime;
    private Point point;
    private float depth;

    @RequiresApi(api = Build.VERSION_CODES.O)
    protected Landmark(Parcel in) {
        name = in.readString();
        descr = in.readInt();
        StworkTime = LocalTime.of(in.readInt(), in.readInt());
        FinworkTime = LocalTime.of(in.readInt(), in.readInt());
        point = new Point(in.readDouble(), in.readDouble());
        depth = in.readFloat();
    }

    public static final Creator<Landmark> CREATOR = new Creator<Landmark>() {
        @RequiresApi(api = Build.VERSION_CODES.O)
        @Override
        public Landmark createFromParcel(Parcel in) {
            return new Landmark(in);
        }

        @Override
        public Landmark[] newArray(int size) {
            return new Landmark[size];
        }
    };

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getDescr() {
        return descr;
    }

    public void setDescr(int descr) {
        this.descr = descr;
    }

    public LocalTime getStWorkTime() {
        return StworkTime;
    }

    public void setStWorkTime(LocalTime workTime) {
        this.StworkTime = workTime;
    }

    public LocalTime getFinworkTime() {
        return FinworkTime;
    }

    public void setFinworkTime(LocalTime finworkTime) {
        FinworkTime = finworkTime;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public Point getPoint() {
        return point;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public String toString(){
        return this.name;
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(descr);
        dest.writeInt(StworkTime.getHour());
        dest.writeInt(StworkTime.getMinute());
        dest.writeInt(FinworkTime.getHour());
        dest.writeInt(FinworkTime.getMinute());
        dest.writeDouble(point.getLatitude());
        dest.writeDouble(point.getLongitude());
        dest.writeFloat(depth);
    }
    public Landmark(String Name, int Description, LocalTime StWorkTime, LocalTime FinWorkTime, Point Point, float Depth){
        setName(Name);
        setDescr(Description);
        setStWorkTime(StWorkTime);
        setFinworkTime(FinWorkTime);
        setPoint(Point);
        setDepth(Depth);
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    public Landmark(String Name, int Description, Point Point, float Depth){
        setName(Name);
        setDescr(Description);
        setPoint(Point);
        setStWorkTime(LocalTime.of(0,0));
        setFinworkTime(LocalTime.of(0,0));
        setDepth(Depth);
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    public Landmark(String Name, int Description, Point Point){
        setName(Name);
        setDescr(Description);
        setPoint(Point);
        setStWorkTime(LocalTime.of(0,0));
        setFinworkTime(LocalTime.of(0,0));
        setDepth(2);
    }

    public float getDepth() {
        return depth;
    }

    public void setDepth(float depth) {
        this.depth = depth;
    }
}
