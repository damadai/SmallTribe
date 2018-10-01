package com.zaze.tribe.music

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.zaze.tribe.databinding.MiniPlayerFragBinding
import com.zaze.utils.ZActivityUtil

/**
 * Description :
 *
 * @author : ZAZE
 * @version : 2018-09-30 - 0:37
 */
class MiniPlayerFragment : Fragment() {

    private lateinit var viewDataBinding: MiniPlayerFragBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewDataBinding = MiniPlayerFragBinding.inflate(inflater, container, false)
        viewDataBinding.root.setOnClickListener {
            ZActivityUtil.startActivity(this, MusicDetailActivity::class.java)
        }
        return viewDataBinding.root
    }

}