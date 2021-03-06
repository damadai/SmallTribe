package com.zaze.tribe.music

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.zaze.tribe.common.BaseFragment
import com.zaze.tribe.common.util.IconCache
import com.zaze.tribe.music.data.dto.Music
import com.zaze.tribe.music.util.MediaIconCache
import kotlinx.android.synthetic.main.music_album_cover_item_frag.*

/**
 * Description : 单个唱片封面页
 *
 * @author : ZAZE
 * @version : 2018-10-01 - 23:26
 */
class AlbumCoverFragment : BaseFragment() {
    private var music: Music? = null

    companion object {
        fun newInstance(music: Music): AlbumCoverFragment {
            val args = Bundle()
            val fragment = AlbumCoverFragment()
            args.putParcelable("music", music)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        music = arguments?.getParcelable("music")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.music_album_cover_item_frag, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        music?.let {
            musicAlbumCover.setImageBitmap(MediaIconCache.buildMediaIcon(it.data)
                    ?: MediaIconCache.getDefaultMediaIcon())
        }
    }
}