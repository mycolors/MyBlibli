package com.fengniao.myblibli.bean.live;


import android.os.Parcel;
import android.os.Parcelable;

public class EntranceIcon implements Parcelable {
    private int id;
    private String name;
    private Icon entrance_icon;

    protected EntranceIcon(Parcel in) {
        id = in.readInt();
        name = in.readString();
        entrance_icon = in.readParcelable(Icon.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeParcelable(entrance_icon, flags);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<EntranceIcon> CREATOR = new Creator<EntranceIcon>() {
        @Override
        public EntranceIcon createFromParcel(Parcel in) {
            return new EntranceIcon(in);
        }

        @Override
        public EntranceIcon[] newArray(int size) {
            return new EntranceIcon[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Icon getEntrance_icon() {
        return entrance_icon;
    }

    public void setEntrance_icon(Icon entrance_icon) {
        this.entrance_icon = entrance_icon;
    }
}
