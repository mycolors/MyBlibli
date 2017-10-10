package com.fengniao.myblibli.module.home.homepage.live

import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TableLayout
import android.widget.TextView
import butterknife.OnClick
import com.bumptech.glide.Glide
import com.fengniao.myblibli.R
import com.fengniao.myblibli.base.BaseActivity
import com.fengniao.myblibli.bean.live.Live
import com.fengniao.myblibli.manager.VideoPlayerManager
import com.fengniao.myblibli.util.UIUtils
import com.fengniao.myblibli.widget.media.IjkVideoView
import kotlinx.android.synthetic.main.activity_live_player.*


/**
 * 直播间
 */
class LivePlayerActivity : BaseActivity() {
    internal var videoView: IjkVideoView? = null
    internal var hudView: TableLayout? = null
    internal var imgAvatar: ImageView? = null
    internal var textTitle: TextView? = null
    internal var textLevel: TextView? = null
    internal var textName: TextView? = null
    internal var textOnlineCount: TextView? = null
    internal var textFollow: TextView? = null
    internal var textFollowCount: TextView? = null


    private var mManager: VideoPlayerManager? = null

    private var mLive: Live? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
    }

    private fun initView() {
        mLive = intent.getParcelableExtra("live")
        if (mLive == null) return
        videoView = video_view
        hudView = hud_view
        imgAvatar = img_avatar
        textTitle = text_title
        textLevel = text_level
        textName = text_name
        textOnlineCount = text_online_count
        textFollow = text_follow
        textFollowCount = text_follow_count
        Glide.with(this).load(mLive!!.owner.face).into(imgAvatar!!)
        textTitle!!.text = mLive!!.title
        textName!!.text = mLive!!.owner.name
        textOnlineCount!!.text = mLive!!.online.toString() + ""
        initVideoPlayerManager()
    }

    private fun initVideoPlayerManager() {
        mManager = VideoPlayerManager(this)
        mManager!!.setHudView(hudView)
        playVideo()
    }


    private fun playVideo() {
        mManager!!.setVideoURI(Uri.parse(mLive!!.playurl))
        mManager!!.setOnErrorListener { iMediaPlayer, i, i1 -> true }
        mManager!!.setOnPreparedListener { iMediaPlayer ->
            UIUtils.isShowStatusBar(activity, false)
            mManager!!.start()

        }
    }


    override fun getLayoutId(): Int {
        return R.layout.activity_live_player
    }

    @OnClick(R.id.img_avatar, R.id.text_title, R.id.text_name, R.id.text_follow)
    fun onViewClicked(view: View) {
        when (view.id) {
            R.id.img_avatar, R.id.text_name -> {
            }
            R.id.text_title -> {
            }
            R.id.text_follow -> {
            }
        }
    }
}
