package findimage

import java.awt.Point

/**
 * 查找失败等没有成功时返回的坐标
 */
val ErrorPoint = Point(-1, -1)

/**
 * 扩展Point方法，判断当前是否是错误坐标
 */
fun Point.isErrirPoint() = (this.x == -1 && this.y == -1)