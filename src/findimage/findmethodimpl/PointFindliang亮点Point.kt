package findimage.findmethodimpl

import findimage.*
import project.lushi.cardentities.cards.cardgroup.CardGroup_ALL
import java.awt.Point
import java.awt.image.BufferedImage


/**
 * 发现像素点的位置
 */
class PointFindliang亮点Point(val screenShotImage: BufferedImage, scaleWidth: Int = screenShotImage.width, scaleHeight: Int = screenShotImage.height)
    : BaseContainImage(screenShotImage = screenShotImage, scaleWidth = scaleWidth, scaleHeight = scaleHeight) {
    private lateinit var areaRate: AimImageAreaRate


    override fun findImagePoint(baseImageFind: BaseImageFind, openA: Boolean): Point {
        return ErrorPoint
    }

    fun findLiang亮点Points(): ArrayList<Point> {
        val result = ArrayList<Point>()
        val screenScaleImage = getScaledBitmap()
        val screenScaleArray = bitmap2RGBArray(screenScaleImage!!, 1f, areaRate)
        for (vertical in 0..screenScaleArray.size - 1)
            for (horizontal in 0..screenScaleArray[0].size - 1) {
                if (isLiang亮点(screenScaleArray[vertical][horizontal], 10)) {
                    result.add(Point((horizontal + areaRate.startPointXRate * screenShotImage.width).toInt(), (vertical + areaRate.startPointYRate * screenShotImage.height).toInt()))
                }
            }
        return result
    }

    fun findLiang亮点APoint(): Point {
        val screenScaleImage = getScaledBitmap()
        val screenScaleArray = bitmap2RGBArray(screenScaleImage!!, 1f, areaRate)
        for (vertical in 0..screenScaleArray.size - 1)
            for (horizontal in 0..screenScaleArray[0].size - 1) {
                if (isLiang亮点(screenScaleArray[vertical][horizontal], 5)) {
                    return Point((horizontal + areaRate.startPointXRate * screenScaleImage.width).toInt(), (vertical + areaRate.startPointYRate * screenScaleImage.height).toInt())
                }
            }
        return ErrorPoint
    }


    fun setArea(areaRate: AimImageAreaRate): PointFindliang亮点Point {
        this.areaRate = areaRate
        return this
    }

    private fun isLiang亮点(rgb2: BitmapRGB, cha: Int): Boolean {

        if (Math.abs(CardGroup_ALL.liang亮点.r - rgb2.r) < cha && Math.abs(CardGroup_ALL.liang亮点.g - rgb2.g) < cha && Math.abs(CardGroup_ALL.liang亮点.b - rgb2.b) < cha ||
                Math.abs(CardGroup_ALL.liang亮点2.r - rgb2.r) < cha && Math.abs(CardGroup_ALL.liang亮点2.g - rgb2.g) < cha && Math.abs(CardGroup_ALL.liang亮点2.b - rgb2.b) < cha ||
                Math.abs(CardGroup_ALL.liang亮点3.r - rgb2.r) < cha && Math.abs(CardGroup_ALL.liang亮点3.g - rgb2.g) < cha && Math.abs(CardGroup_ALL.liang亮点3.b - rgb2.b) < cha ||
                Math.abs(CardGroup_ALL.liang亮点4.r - rgb2.r) < cha && Math.abs(CardGroup_ALL.liang亮点4.g - rgb2.g) < cha && Math.abs(CardGroup_ALL.liang亮点4.b - rgb2.b) < cha ||
                Math.abs(CardGroup_ALL.liang亮点5.r - rgb2.r) < cha && Math.abs(CardGroup_ALL.liang亮点5.g - rgb2.g) < cha && Math.abs(CardGroup_ALL.liang亮点5.b - rgb2.b) < cha ||
                Math.abs(CardGroup_ALL.liang亮点6.r - rgb2.r) < cha && Math.abs(CardGroup_ALL.liang亮点6.g - rgb2.g) < cha && Math.abs(CardGroup_ALL.liang亮点6.b - rgb2.b) < cha) {
            return true
        }
        return false
    }

}