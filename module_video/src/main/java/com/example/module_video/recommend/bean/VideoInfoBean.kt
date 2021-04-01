package com.example.module_video.recommend.bean

import android.os.Parcel
import android.os.Parcelable

/**
 *  @author : zhang.wenqiang
 *  @date : 2021/3/30
 *  description :
 */
class VideoInfoBean() : Parcelable {
    var videoId = 0
    var videoTitle: String? = null
    var category: String? = null
    var video_description: String? = null
    var collectionCount = 0
    var shareCount = 0
    var avatar: String? = null
    var nickName: String? = null
    var user_description: String? = null
    var playerUrl: String? = null
    var blurredUrl: String? = null
    var coverImg: String? = null

    constructor(parcel: Parcel) : this() {
        videoTitle = parcel.readString()
        category = parcel.readString()
        video_description = parcel.readString()
        collectionCount = parcel.readInt()
        shareCount = parcel.readInt()
        avatar = parcel.readString()
        nickName = parcel.readString()
        user_description = parcel.readString()
        playerUrl = parcel.readString()
        blurredUrl = parcel.readString()
        coverImg = parcel.readString()
        videoId = parcel.readInt()
    }

    override fun toString(): String {
        return "VideoHeaderBean{" +
                "videoTitle='" + videoTitle + '\'' +
                ", category='" + category + '\'' +
                ", video_description='" + video_description + '\'' +
                ", collectionCount=" + collectionCount +
                ", shareCount=" + shareCount +
                ", avatar='" + avatar + '\'' +
                ", nickName='" + nickName + '\'' +
                ", userDescription='" + user_description + '\'' +
                ", playerUrl='" + playerUrl + '\'' +
                ", blurredUrl='" + blurredUrl + '\'' +
                ", videoId=" + videoId +
                '}'
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(videoTitle)
        parcel.writeString(category)
        parcel.writeString(video_description)
        parcel.writeInt(collectionCount)
        parcel.writeInt(shareCount)
        parcel.writeString(avatar)
        parcel.writeString(nickName)
        parcel.writeString(user_description)
        parcel.writeString(playerUrl)
        parcel.writeString(blurredUrl)
        parcel.writeString(coverImg)
        parcel.writeInt(videoId)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<VideoInfoBean> {
        override fun createFromParcel(parcel: Parcel): VideoInfoBean {
            return VideoInfoBean(parcel)
        }

        override fun newArray(size: Int): Array<VideoInfoBean?> {
            return arrayOfNulls(size)
        }
    }
}