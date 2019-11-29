package tools

import java.text.SimpleDateFormat
import java.util.*

/**
 * 日志工具
 */
object UtilLogCat {
    fun v(msg: String) {
        println(SimpleDateFormat("yyyy-MM-dd HH:SS:").format(Date()) + msg)
    }

    fun d(msg: String) {
        if (true) {
            println(SimpleDateFormat("yyyy-MM-dd HH:SS:").format(Date()) + msg)
        }
    }
}