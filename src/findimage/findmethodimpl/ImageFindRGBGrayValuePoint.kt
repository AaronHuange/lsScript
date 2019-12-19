package findimage.findmethodimpl

import findimage.BaseImageFind
import findimage.ErrorPoint
import tools.UtilLogCat
import java.awt.Point
import java.awt.image.BufferedImage

/**
 * 通过像素RGB和图片灰度化查找图片( >>>包括查找模型的当前屏幕坐标<<< )
 */
class ImageFindRGBGrayValuePoint(screenShotImage: BufferedImage, scaleWidth: Int = screenShotImage.width, scaleHeight: Int = screenShotImage.height) : ImageFindRGBGrayValue(screenShotImage = screenShotImage, scaleWidth = scaleWidth, scaleHeight = scaleHeight) {

    /**
     *
     */
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
                        UtilLogCat.d("Point")
                        //val point = baseImageFind.usePoint(Point(getScreenBitmapWidth(), getScreenBitmapHeight()))
                        val areaRate = baseImageFind.findAreaRate()
                        var point = ErrorPoint
                        if (areaRate == null) {
                            point = Point(((horizontal / getScaleWidth().toFloat()) * getOriginalBitmap().width).toInt(), (((vertical / getScaleHeight()).toFloat()) * getOriginalBitmap().height).toInt())
                        } else {
                            point = Point(0, 0)
                        }
                        baseImageFind.exeHandler(point)
                        return point
                    }
                }
            }
        UtilLogCat.d("ErrorPoint${aa++}")
        return ErrorPoint
    }



}

var aa = 0