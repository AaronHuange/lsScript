package findimage

import net.coobird.thumbnailator.Thumbnails
import java.awt.Point
import java.awt.image.BufferedImage

/**
 * 被用来查找图片的基类
 */
abstract class BaseContainImage(screenShotImage: BufferedImage, scaleWidth: Int, scaleHeight: Int) {

    private val screenShotImage: BufferedImage
    private var scaleBitmap: BufferedImage? = null
    private val scaleWidth: Int
    private val scaleHeight: Int

    init {
        this.screenShotImage = screenShotImage
        this.scaleWidth = scaleWidth
        this.scaleHeight = scaleHeight
    }

    /**
     * 获取截屏的原始图片(未缩放的)
     */
    fun getOriginalBitmap() = screenShotImage

    /**
     * 屏幕宽度=截屏图片宽度
     */
    fun getScreenBitmapWidth() = screenShotImage.width

    /**
     * 屏幕高度=截屏图片高度
     */
    fun getScreenBitmapHeight() = screenShotImage.height

    /**
     * 得到缩放图片的宽度
     */
    fun getScaleWidth() = scaleWidth

    /**
     * 得到缩放图片的高度
     */
    fun getScaleHeight() = scaleHeight

    /**
     * 得到截屏后的图片宽度和屏幕宽度的比例
     */
    private fun getScaleWidthRate(): Float {
        return getScaleWidth() / (getScreenBitmapWidth().toFloat())
    }

    /**
     * 得到截屏后的图片高度和屏幕高度的比例
     */
    private fun getScaleHeightRate(): Float {
        return getScaleHeight() / (getScreenBitmapHeight().toFloat())
    }

    /**
     * 得到缩放图片
     */
    fun getScaledBitmap(): BufferedImage? {
        if (scaleBitmap == null) {
            if (getScaleWidth() == getScreenBitmapWidth() && getScaleHeight() == getScreenBitmapHeight()) {
                scaleBitmap = getOriginalBitmap()
            } else {
                scaleBitmap = Thumbnails.of(getOriginalBitmap())
                        .size(getScaleWidth(), getScaleHeight())
                        .asBufferedImage()
            }
        }
        return scaleBitmap
    }

    /**
     * 通过缩放的图片查找到的坐标得到真实屏幕的坐标
     */
    fun getScreenPointByScalePoint(point: Point): Point {
        point.x = (point.x / getScaleWidthRate()).toInt()
        point.y = (point.y / getScaleHeightRate()).toInt()
        return point
    }

    /**
     * 将图片的像素值打印二维数组出来
     */
    fun bitmap2RGBArray(bitmap: BufferedImage, huiduValue: Float, aimAreaRate: AimImageAreaRate? = null): ArrayList<ArrayList<BitmapRGB>> {
        val width = bitmap.width
        val height = bitmap.height
        val result = ArrayList<ArrayList<BitmapRGB>>()
        var bitmapRGBArray: ArrayList<BitmapRGB>?
        var pixel = 0;
        if (aimAreaRate != null) {
            for (y in (aimAreaRate.startPointYRate * scaleHeight).toInt()..(aimAreaRate.endPointYRate * scaleHeight - 1).toInt()) {
                bitmapRGBArray = ArrayList()
                for (x in (aimAreaRate.startPointXRate * scaleWidth).toInt()..(aimAreaRate.endPointXRate * scaleWidth - 1).toInt()) {
                    //使用getRGB(w, h)获取该点的颜色值是ARGB，若在实际应用中使用的是RGB，所以需要将ARGB转化成RGB，即bufImg.getRGB(w, h) & 0xFFFFFF，这里没用
                    pixel = bitmap.getRGB(x, y)
                    val A = pixel shr 24 and 0xff
                    if (A == 0) {
                        bitmapRGBArray.add(BitmapRGB(0, 0, 0))
                        continue
                    }
                    val R = pixel shr 16 and 0xff
                    val G = pixel shr 8 and 0xff
                    val B = pixel and 0xff
                    bitmapRGBArray.add(BitmapRGB((R / huiduValue).toInt(), (G / huiduValue).toInt(), (B / huiduValue).toInt()))
                }
                result.add(bitmapRGBArray)
            }
        } else {
            for (y in 0..(height - 1)) {
                bitmapRGBArray = ArrayList()
                for (x in 0..(width - 1)) {
                    //使用getRGB(w, h)获取该点的颜色值是ARGB，若在实际应用中使用的是RGB，所以需要将ARGB转化成RGB，即bufImg.getRGB(w, h) & 0xFFFFFF，这里没用
                    pixel = bitmap.getRGB(x, y)
                    val A = pixel shr 24 and 0xff
                    if (A == 0) {
                        bitmapRGBArray.add(BitmapRGB(0, 0, 0))
                        continue
                    }
                    val R = pixel shr 16 and 0xff
                    val G = pixel shr 8 and 0xff
                    val B = pixel and 0xff
                    bitmapRGBArray.add(BitmapRGB((R / huiduValue).toInt(), (G / huiduValue).toInt(), (B / huiduValue).toInt()))
                }
                result.add(bitmapRGBArray)
            }
        }
        return result
    }

    /**
     * 查找图片的方法，具体由各种子查找方式实现
     */
    abstract fun findImagePoint(baseImageFind: BaseImageFind): Point


}