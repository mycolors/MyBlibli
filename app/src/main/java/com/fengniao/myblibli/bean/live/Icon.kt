package com.fengniao.myblibli.bean.live


import android.os.Parcel
import android.os.Parcelable

class Icon protected constructor(`in`: Parcel) : Parcelable {
    var src: String? = null
    var height: Int = 0
    var width: Int = 0

    init {
        src = `in`.readString()
        height = `in`.readInt()
        width = `in`.readInt()
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(src)
        dest.writeInt(height)
        dest.writeInt(width)
    }

    override fun describeContents(): Int = 0

    companion object {

        val CREATOR: Parcelable.Creator<Icon> = object : Parcelable.Creator<Icon> {
            override fun createFromParcel(`in`: Parcel): Icon = Icon(`in`)

            override fun newArray(size: Int): Array<Icon?> = arrayOfNulls(size)
        }
    }
}
