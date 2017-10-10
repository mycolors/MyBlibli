package com.fengniao.myblibli.bean.drama

import android.os.Parcel
import android.os.Parcelable


data class DramaPageData(var ad: Ad, var previous: Previous, var serializing: List<DramaInfo>) {
    data class Ad(var body: List<AdBody>, var head: List<Head>)
    class AdBody
    data class Head(var id: Int, var img: String, var link: String, var pub_time: String, var title: String)

    data class Previous(var list: List<DramaInfo>, var season: Int, var year: Int)

    data class DramaInfo(var badge: String, var cover: String, var favourites: Int,
                           var is_finish: Int, var is_started: Int, var last_time: Long,
                           var newest_ep_index: String, var pub_time: Long, var season_id: Int,
                           var season_status: Int, var title: String, var watching_count: Int) : Parcelable {
        constructor(parcel: Parcel) : this(
                parcel.readString(),
                parcel.readString(),
                parcel.readInt(),
                parcel.readInt(),
                parcel.readInt(),
                parcel.readLong(),
                parcel.readString(),
                parcel.readLong(),
                parcel.readInt(),
                parcel.readInt(),
                parcel.readString(),
                parcel.readInt()) {
        }

        override fun writeToParcel(parcel: Parcel, flags: Int) {
            parcel.writeString(badge)
            parcel.writeString(cover)
            parcel.writeInt(favourites)
            parcel.writeInt(is_finish)
            parcel.writeInt(is_started)
            parcel.writeLong(last_time)
            parcel.writeString(newest_ep_index)
            parcel.writeLong(pub_time)
            parcel.writeInt(season_id)
            parcel.writeInt(season_status)
            parcel.writeString(title)
            parcel.writeInt(watching_count)
        }

        override fun describeContents(): Int = 0

        companion object CREATOR : Parcelable.Creator<DramaInfo> {
            override fun createFromParcel(parcel: Parcel): DramaInfo = DramaInfo(parcel)

            override fun newArray(size: Int): Array<DramaInfo?> = arrayOfNulls(size)
        }
    }
}