package com.zaze.tribe.music

import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.LinearInterpolator
import com.zaze.tribe.common.BaseFragment
import com.zaze.tribe.music.R.id.*
import com.zaze.tribe.music.databinding.MusicMiniPlayerFragBinding
import com.zaze.tribe.music.handler.MusicProgressHandler
import kotlinx.android.synthetic.main.music_mini_player_frag.*

/**
 * Description : 迷你播放控制器
 *
 * @author : ZAZE
 * @version : 2018-09-30 - 0:37
 */
class MiniPlayerFragment : BaseFragment(), MusicProgressHandler.Callback {

    private lateinit var viewDataBinding: MusicMiniPlayerFragBinding
    private lateinit var progressHandler: MusicProgressHandler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        progressHandler = MusicProgressHandler(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewDataBinding = MusicMiniPlayerFragBinding.inflate(inflater, container, false)
        viewDataBinding.setLifecycleOwner(this)
        viewDataBinding.root.setOnClickListener {
            activity?.let { activity ->
                MusicDetailActivity.start(activity)
            }
        }
        return viewDataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        musicMiniPlayerStatus.setOnClickListener {
            if (MusicPlayerRemote.isPlaying.get()) {
                MusicPlayerRemote.pause()
            } else {
                MusicPlayerRemote.resumePlaying()
            }
        }
        musicMiniPlayerList.setOnClickListener {
            activity?.apply {
                MusicPlayingQueueActivity.start(this)
            }
        }
    }

    override fun onProgress(progress: Int, total: Int) {
        musicMiniPlayerProgressBar.max = total
        val animation = ObjectAnimator.ofInt(musicMiniPlayerProgressBar, "progress", progress)
        animation.duration = 1000L
        animation.interpolator = LinearInterpolator()
        animation.start()
    }

    override fun onResume() {
        super.onResume()
        progressHandler.start()
    }

    override fun onPause() {
        super.onPause()
        progressHandler.stop()
    }
}