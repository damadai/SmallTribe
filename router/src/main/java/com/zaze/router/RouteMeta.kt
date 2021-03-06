package com.zaze.router

/**
 * Description :
 * @author : ZAZE
 * @version : 2018-11-26 - 23:47
 */
open class RouteMeta {
    /**
     * 路径 /xx/xxx
     */
    var path: String = ""
    /**
     * 目标
     */
    var target: Class<*>? = null

    /**
     * 路由类型
     */
    var type: RouteType? = null
}