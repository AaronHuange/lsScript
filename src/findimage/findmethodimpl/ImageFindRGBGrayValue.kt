package findimage.findmethodimpl

import findimage.BaseContainImage
import findimage.BaseImageFind
import java.awt.Point
import java.awt.image.BufferedImage


/**
 * 通过像素RGB和图片灰度化查找图片
 */
class ImageFindRGBGrayValue(screenShotImage: BufferedImage, scaleWidth: Int, scaleHeight: Int) : BaseContainImage(screenShotImage = screenShotImage, scaleWidth = scaleWidth, scaleHeight = scaleHeight) {
    override fun findImagePoint(baseImageFind: BaseImageFind): Point {


        return Point(-1, -1)
    }
}