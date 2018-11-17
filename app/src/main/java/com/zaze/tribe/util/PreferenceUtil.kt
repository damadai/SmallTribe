
package com.zaze.tribe.util

import com.zaze.tribe.R
import com.zaze.tribe.common.App
import com.zaze.utils.ZSharedPrefUtil

/**
 * Description :
 *
 * @author : ZAZE
 * @version : 2018-10-17 - 23:31
 */
object PreferenceUtil {

    private val sharedPrefUtil = ZSharedPrefUtil.newInstance(App.INSTANCE)

    private const val LATELY_PAGE = "LATELY_PAGE"

    // ------------------------------------------------------
    /**
     * 获取最后停留的页面
     */
    fun getLastPage(): Int {
        return sharedPrefUtil.get(LATELY_PAGE, R.id.action_home)
    }

    /**
     * 保存最后停留的页面
     */
    fun saveLastPage(pageId: Int) {
        sharedPrefUtil.apply(LATELY_PAGE, pageId)
    }
}