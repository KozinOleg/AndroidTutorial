package zp.dv.KOM.mychat;

import android.graphics.Color;
import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Message implements Serializable {
    private String mName;
    private String mText;
    private String mDate;
    private int mColor;

    public Message(String name, String text, String date, int color) {
        this.mName = name;
        this.mText = text;
        this.mDate = date;
        this.mColor = color;
    }

    public int getmColor() {
        return mColor;
    }

    public void setmColor(int mColor) {
        this.mColor = mColor;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        this.mName = name;
    }

    public String getText() {
        return mText;
    }

    public void setText(String text) {
        this.mText = text;
    }

    public String getDate() {
        return mDate;
    }

    public void setDate(String date) {
        this.mDate = date;
    }

    @Override
    public String toString() {
        return "message [name=" + mName + ", text=" + mText + ", date=" + mDate
                + "]";
    }
}
