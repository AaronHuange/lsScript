package findimage

import tools.UtilImage
import tools.UtilLogCat
import java.awt.Point
import java.awt.image.BufferedImage
import java.lang.RuntimeException


/**
 * 查找的目标图片的基类
 */
abstract class BaseImageFind(imagePath: String) {

    private val bitmap: BufferedImage

    init {
        val image = UtilImage.loadImage(imagePath)
        if (image != null) {
            this.bitmap = image
        } else {
            this.bitmap = BufferedImage(1, 1, 1)
            throw RuntimeException("图片${imagePath}不存在!!")
        }
    }

    fun getBitmap() = bitmap

    fun getImageWidth() = bitmap.width

    fun getImageHeight() = bitmap.height

    /**
     * 防止系统检测，将坐标转换成随机坐标
     */
    fun getRandomPoint(point: Point): Point {
        point.x += ((Math.random() * 8).toInt() - 4)
        point.y += ((Math.random() * 4).toInt() - 2)
        return point
    }

    /**
     * 图片处理的灰度 值
     */
    abstract fun grayValue(): Float

    /**
     * 图片处理的灰度 差值
     */
    abstract fun grayDiffValue(): Int

    /**
     * 该查找图片需要查找的区域范围占被查找图片的宽高的比率
     */
    abstract fun findAreaRate(): AimImageAreaRate?

    /**
     * 允许误差的像素点个数
     */
    abstract fun getErrorCount(): Int

    /**
     * 允许比较像素浮动比较的周围个像素点数
     */
    abstract fun getFloatCount(): Int

    /**
     * @return ErrorPoint 查找后通过自己计算位置
     *         Point(?,?) 查找后不管在哪都使用返回的位置
     */
    abstract fun usePoint(screenSize: Point): Point

    /**
     * 图片查找到后应该执行的操作
     */
    abstract fun exeHandler(point: Point)

}