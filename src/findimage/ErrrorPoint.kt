package findimage

import java.awt.Point
import java.awt.image.BufferedImage

/**
 * 查找失败等没有成功时返回的坐标
 */
val ErrorPoint = Point(-1, -1)

//1440 900   725 168
fun enemyHeroPoint(screenImage: BufferedImage) = Point((screenImage.width * (722 / 1440f)).toInt(), (screenImage.height * (168 / 900f)).toInt())

//1440 900   722 696
fun myHeroPoint(screenImage: BufferedImage) = Point((screenImage.width * (722 / 1440f)).toInt(), (screenImage.height * (696 / 900f)).toInt())

/**
 * 扩展Point方法，判断当前是否是错误坐标
 */
fun Point.isErrirPoint() = (this.x == -1 && this.y == -1)