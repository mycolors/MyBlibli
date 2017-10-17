package com.fengniao.myblibli.module.home.homepage.live

import android.app.AlertDialog
import android.net.Uri
import android.os.Bundle
import android.text.TextUtils
import android.view.KeyEvent
import android.view.View
import android.widget.ImageView
import android.widget.TableLayout
import android.widget.TextView
import butterknife.OnClick
import com.bumptech.glide.Glide
import com.fengniao.myblibli.R
import com.fengniao.myblibli.base.BaseActivity
import com.fengniao.myblibli.manager.VideoPlayerManager
import com.fengniao.myblibli.util.NetworkUtils
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

    lateinit var liveAvatar: String
    lateinit var liveTitle: String
    lateinit var liveUpName: String
    lateinit var liveOnlineCount: String
    lateinit var liveUrl: String


    companion object {
        val LIVE_AVATAR = "live_avatar"
        val LIVE_TITLE = "live_title"
        val LIVE_UP_NAME = "live_up_name"
        val LIVE_ONLINE_COUNT = "live_online_count"
        val LIVE_URL = "live_url"
    }


    private var mManager: VideoPlayerManager? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        checkNet()
    }

    //检查当前网络
    fun checkNet() {
        if (!NetworkUtils.isNetworkAvailable(this)) {
            showToast("没有连接网络")
        } else if (NetworkUtils.isMobile(this)) {
            val builder: AlertDialog.Builder = AlertDialog.Builder(this)
            builder.setTitle("提示")
            builder.setMessage("您当前在使用手机流量，是否继续观看")
            builder.setPositiveButton("确定") { dialog, which ->
                dialog.dismiss()
                initView()
            }
            builder.setNegativeButton("取消") { dialog, which ->
                dialog.dismiss()
                finish()
            }
            val dialog = builder.create()
            dialog.setOnKeyListener { dialog, keyCode, event ->
                if (keyCode == KeyEvent.KEYCODE_BACK) {
                    finish()
                }
                false
            }
            dialog.setCanceledOnTouchOutside(false)
            dialog.show()
        } else {
            initView()
        }
    }

    private fun initView() {
        videoView = video_view
        hudView = hud_view
        imgAvatar = img_avatar
        textTitle = text_title
        textLevel = text_level
        textName = text_name
        textOnlineCount = text_online_count
        textFollow = text_follow
        textFollowCount = text_follow_count
        liveAvatar = intent.getStringExtra(LIVE_AVATAR)
        liveTitle = intent.getStringExtra(LIVE_TITLE)
        liveUpName = intent.getStringExtra(LIVE_UP_NAME)
        liveOnlineCount = intent.getStringExtra(LIVE_ONLINE_COUNT)
        liveUrl = intent.getStringExtra(LIVE_URL)
        Glide.with(this).load(liveAvatar).into(imgAvatar!!)
        textTitle!!.text = liveTitle
        textName!!.text = liveUpName
        textOnlineCount!!.text = liveOnlineCount
        initVideoPlayerManager()
    }

    private fun initVideoPlayerManager() {
        mManager = VideoPlayerManager(this)
        mManager!!.setHudView(hudView)
        playVideo()
    }


    private fun playVideo() {
        if (TextUtils.isEmpty(liveUrl)) return
        mManager!!.setVideoURI(Uri.parse(liveUrl))
        mManager!!.setOnErrorListener { iMediaPlayer, i, i1 -> true }
        mManager!!.setOnPreparedListener { iMediaPlayer ->
            UIUtils.isShowStatusBar(activity, false)
            mManager!!.start()
        }
    }

    override fun getLayoutId(): Int = R.layout.activity_live_player

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
