package com.fengniao.myblibli.bean.live;


import android.os.Parcel;
import android.os.Parcelable;

public class Live implements Parcelable {
    private OwnerBean owner;
    private CoverBean cover;
    private String title;
    private int room_id;
    private int check_version;
    private int online;
    private String area;
    private int area_id;
    private String playurl;
    private String accept_quality;
    private int broadcast_type;
    private int is_tv;
    private int area_v2_id;
    private String area_v2_name;
    private int area_v2_parent_id;
    private String area_v2_parent_name;

    public int getArea_v2_id() {
        return area_v2_id;
    }

    public void setArea_v2_id(int area_v2_id) {
        this.area_v2_id = area_v2_id;
    }

    public String getArea_v2_name() {
        return area_v2_name;
    }

    public void setArea_v2_name(String area_v2_name) {
        this.area_v2_name = area_v2_name;
    }

    public int getArea_v2_parent_id() {
        return area_v2_parent_id;
    }

    public void setArea_v2_parent_id(int area_v2_parent_id) {
        this.area_v2_parent_id = area_v2_parent_id;
    }

    public String getArea_v2_parent_name() {
        return area_v2_parent_name;
    }

    public void setArea_v2_parent_name(String area_v2_parent_name) {
        this.area_v2_parent_name = area_v2_parent_name;
    }

    public Live() {
    }


    protected Live(Parcel in) {
        owner = in.readParcelable(OwnerBean.class.getClassLoader());
        cover = in.readParcelable(CoverBean.class.getClassLoader());
        title = in.readString();
        room_id = in.readInt();
        check_version = in.readInt();
        online = in.readInt();
        area = in.readString();
        area_id = in.readInt();
        playurl = in.readString();
        accept_quality = in.readString();
        broadcast_type = in.readInt();
        is_tv = in.readInt();
        area_v2_id = in.readInt();
        area_v2_name = in.readString();
        area_v2_parent_id = in.readInt();
        area_v2_parent_name = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(owner, flags);
        dest.writeParcelable(cover, flags);
        dest.writeString(title);
        dest.writeInt(room_id);
        dest.writeInt(check_version);
        dest.writeInt(online);
        dest.writeString(area);
        dest.writeInt(area_id);
        dest.writeString(playurl);
        dest.writeString(accept_quality);
        dest.writeInt(broadcast_type);
        dest.writeInt(is_tv);
        dest.writeInt(area_v2_id);
        dest.writeString(area_v2_name);
        dest.writeInt(area_v2_parent_id);
        dest.writeString(area_v2_parent_name);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Live> CREATOR = new Creator<Live>() {
        @Override
        public Live createFromParcel(Parcel in) {
            return new Live(in);
        }

        @Override
        public Live[] newArray(int size) {
            return new Live[size];
        }
    };

    public OwnerBean getOwner() {
        return owner;
    }

    public void setOwner(OwnerBean owner) {
        this.owner = owner;
    }

    public CoverBean getCover() {
        return cover;
    }

    public void setCover(CoverBean cover) {
        this.cover = cover;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    public int getCheck_version() {
        return check_version;
    }

    public void setCheck_version(int check_version) {
        this.check_version = check_version;
    }

    public int getOnline() {
        return online;
    }

    public void setOnline(int online) {
        this.online = online;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public int getArea_id() {
        return area_id;
    }

    public void setArea_id(int area_id) {
        this.area_id = area_id;
    }

    public String getPlayurl() {
        return playurl;
    }

    public void setPlayurl(String playurl) {
        this.playurl = playurl;
    }

    public String getAccept_quality() {
        return accept_quality;
    }

    public void setAccept_quality(String accept_quality) {
        this.accept_quality = accept_quality;
    }

    public int getBroadcast_type() {
        return broadcast_type;
    }

    public void setBroadcast_type(int broadcast_type) {
        this.broadcast_type = broadcast_type;
    }

    public int getIs_tv() {
        return is_tv;
    }

    public void setIs_tv(int is_tv) {
        this.is_tv = is_tv;
    }

    public static class OwnerBean implements Parcelable {
        /**
         * face : http://i0.hdslb.com/bfs/face/19fc85057ba91141a59457c91a0fa71a0b84d6e7.jpg
         * mid : 25256202
         * name : 糖米兹
         */

        private String face;
        private int mid;
        private String name;

        protected OwnerBean(Parcel in) {
            face = in.readString();
            mid = in.readInt();
            name = in.readString();
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(face);
            dest.writeInt(mid);
            dest.writeString(name);
        }

        @Override
        public int describeContents() {
            return 0;
        }

        public static final Creator<OwnerBean> CREATOR = new Creator<OwnerBean>() {
            @Override
            public OwnerBean createFromParcel(Parcel in) {
                return new OwnerBean(in);
            }

            @Override
            public OwnerBean[] newArray(int size) {
                return new OwnerBean[size];
            }
        };

        public String getFace() {
            return face;
        }

        public void setFace(String face) {
            this.face = face;
        }

        public int getMid() {
            return mid;
        }

        public void setMid(int mid) {
            this.mid = mid;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static class CoverBean implements Parcelable {
        /**
         * src : http://i0.hdslb.com/bfs/live/f89d5b98ff6f68bced0f2184e60dc7e6d7bedaff.jpg
         * height : 180
         * width : 320
         */

        private String src;
        private int height;
        private int width;

        protected CoverBean(Parcel in) {
            src = in.readString();
            height = in.readInt();
            width = in.readInt();
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(src);
            dest.writeInt(height);
            dest.writeInt(width);
        }

        @Override
        public int describeContents() {
            return 0;
        }

        public static final Creator<CoverBean> CREATOR = new Creator<CoverBean>() {
            @Override
            public CoverBean createFromParcel(Parcel in) {
                return new CoverBean(in);
            }

            @Override
            public CoverBean[] newArray(int size) {
                return new CoverBean[size];
            }
        };

        public String getSrc() {
            return src;
        }

        public void setSrc(String src) {
            this.src = src;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }
    }


}
