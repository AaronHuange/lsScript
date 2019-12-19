package project.lushi.findimageentities

import findimage.AimImageAreaRate
import findimage.BaseImageFind
import tools.UtilFile
import tools.UtilLogCat
import tools.UtilMouse
import java.awt.Point

class FindQiShiShouPai(imagePath: String = UtilFile.getAssetsImagePath("qishishoupai.jpg")) : BaseImageFind(imagePath = imagePath) {

    override fun grayValue() = 1f

    override fun grayDiffValue() = 12

    override fun getErrorCount() = 0

    override fun getFloatCount() = 1

    override fun exeHandler(point: Point) {
        //这张图本身不需要做任何操作
        UtilMouse.clickLeftInPoint(point)
    }

    override fun usePoint(screenSize: Point): Point {
        return Point((screenSize.x.toFloat() * (726 / 1440f)).toInt(), (screenSize.y.toFloat() * (717 / 900f)).toInt())
    }

    override fun findAreaRate() = AimImageAreaRate(0.3f, 0f, 0.7f, 0.25f)
}