package findimage

import java.awt.Point
import java.awt.image.BufferedImage


/**
 * 查找的目标图片的基类
 */
abstract class BaseImageFind(bitmap: BufferedImage) {

    private val bitmap: BufferedImage

    init {
        this.bitmap = bitmap
    }

    fun getBitmap() = bitmap

    fun getImageWidth() = bitmap.width

    fun getImageHeight() = bitmap.height

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
    abstract fun findAreaRate(): AimImageAreaRate

    /**
     * 图片查找到后应该执行的操作
     */
    abstract fun exeHandler(point: Point)

    /**
     * 允许误差的像素点个数
     */
    abstract fun getErrorCount(): Int

    /**
     * 允许比较像素浮动比较的周围个像素点数
     */
    abstract fun getFloatCount(): Int

    /**
     * 不需要程序确定找到后的位置，自己能够确定屏幕位置
     */
    abstract fun useThisPoint(): Point

}