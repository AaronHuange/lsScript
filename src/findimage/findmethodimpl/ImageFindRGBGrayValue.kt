package findimage.findmethodimpl

import findimage.BaseContainImage
import findimage.BaseImageFind
import findimage.BitmapRGB
import findimage.ErrorPoint
import tools.UtilLogCat
import java.awt.Point
import java.awt.image.BufferedImage
import javax.rmi.CORBA.Util


/**
 * 通过像素RGB和图片灰度化查找图片( >>>需要查找模型自己提供找到后的坐标<<< )
 */
open class ImageFindRGBGrayValue(screenShotImage: BufferedImage, scaleWidth: Int = screenShotImage.width, scaleHeight: Int = screenShotImage.height)
    : BaseContainImage(screenShotImage = screenShotImage, scaleWidth = scaleWidth, scaleHeight = scaleHeight) {

    override fun findImagePoint(baseImageFind: BaseImageFind, openA: Boolean): Point {
        val screenScaleImage = getScaledBitmap()
        val findImage = baseImageFind.getBitmap()
        screenScaleImage ?: return ErrorPoint

        val screenScaleArray = bitmap2RGBArray(screenScaleImage!!, baseImageFind.grayValue(), baseImageFind.findAreaRate())
        val findArray = bitmap2RGBArray(findImage, baseImageFind.grayValue())

        for (vertical in 0..screenScaleArray.size - 1)
            for (horizontal in 0..screenScaleArray[0].size - 1) {
                if (
                        (floatCompareRGB(
                                findArray[0][0],
                                vertical,
                                horizontal,
                                baseImageFind.getFloatCount(),
                                baseImageFind.grayDiffValue(),
                                screenScaleArray, openA
                        ))
                        &&
                        (floatCompareRGB(
                                findArray[baseImageFind.getImageHeight() - 1][0],
                                vertical + baseImageFind.getImageHeight() - 1,
                                horizontal,
                                baseImageFind.getFloatCount(),
                                baseImageFind.grayDiffValue(),
                                screenScaleArray, openA
                        ))
                        &&
                        (floatCompareRGB(
                                findArray[0][baseImageFind.getImageWidth() - 1],
                                vertical,
                                horizontal + baseImageFind.getImageWidth() - 1,
                                baseImageFind.getFloatCount(),
                                baseImageFind.grayDiffValue(),
                                screenScaleArray, openA
                        ))
                        &&
                        (floatCompareRGB(
                                findArray[baseImageFind.getImageHeight() - 1][baseImageFind.getImageWidth() - 1],
                                baseImageFind.getImageHeight() + vertical - 1,
                                baseImageFind.getImageWidth() + horizontal - 1,
                                baseImageFind.getFloatCount(),
                                baseImageFind.grayDiffValue(),
                                screenScaleArray, openA
                        ))
                ) {
                    if (compareAll(vertical, horizontal, screenScaleArray, findArray, baseImageFind, openA)) {
                        val point = baseImageFind.usePoint(Point(getScreenBitmapWidth(), getScreenBitmapHeight()))
                        baseImageFind.exeHandler(point)
//                        UtilLogCat.d("point ${point.x} ${point.y}")
                        return point
                    }
//                    else {
//
//                        return ErrorPoint
//                    }
                }
            }
        return ErrorPoint
    }


    /**
     * 浮动像素点比较
     */
    protected fun floatCompareRGB(
            pixel: BitmapRGB,
            x: Int,
            y: Int,
            floatNum: Int,
            grayDiffValue: Int,
            aimCompare: ArrayList<ArrayList<BitmapRGB>>,
            aOpen: Boolean
    ): Boolean {
        for (startX in x - floatNum..floatNum + x)
            for (startY in y - floatNum..floatNum + y) {
                if (aOpen && pixel.r == 0 && pixel.g == 0 && pixel.b == 0) {
                    //如果是透明的
                    return true
                }

                if (startX >= 0 && startX < aimCompare.size && startY >= 0 && startY < aimCompare[0].size) {
                    if (Math.abs(pixel.r - aimCompare[startX][startY].r) < grayDiffValue && Math.abs(pixel.g - aimCompare[startX][startY].g) < grayDiffValue && Math.abs(
                                    pixel.b - aimCompare[startX][startY].b
                            ) < grayDiffValue
                    )
                        return true
                }
            }
        return false
    }


    /**
     * 私有方法比较图片具体的像素值
     */
    protected fun compareAll(
            theX: Int,
            theY: Int,
            smallScreenShotArray: ArrayList<ArrayList<BitmapRGB>>,
            findImgArray: ArrayList<ArrayList<BitmapRGB>>,
            findImg: BaseImageFind,
            openA: Boolean
    ): Boolean {
        var errorCount = 0
        for (x in theX..(findImg.getImageHeight() - 1)) {
            for (y in theY..(findImg.getImageWidth() - 1)) {
                if (openA) {
                    if (findImgArray[x - theX][y - theY].b == 0 && findImgArray[x - theX][y - theY].g == 0 && findImgArray[x - theX][y - theY].r == 0) {
                        continue
                    }
                }
                if (!floatCompareRGB(
                                findImgArray[x - theX][y - theY],
                                x,
                                y,
                                findImg.getFloatCount(),
                                findImg.grayDiffValue(),
                                smallScreenShotArray, openA
                        )
                ) {
                    errorCount++
                    if (findImg.getErrorCount() < errorCount) {  //如果不同的像素点超过允许的误差的像素点的个数
                        return false
                    }
                }
            }
        }
        return true
    }
}