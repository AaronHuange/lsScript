package project.lushi.findimageentities

import findimage.AimImageAreaRate
import findimage.BaseImageFind
import tools.UtilFile
import tools.UtilMouse
import java.awt.Point

/**
 * 带有圣盾的嘲讽牌
 */
class FindChaoFengAndShenDun(imagePath: String = UtilFile.getAssetsImagePath("shendunchaofeng.jpg")) : BaseImageFind(imagePath = imagePath) {

    override fun grayValue() = 1f

    override fun grayDiffValue() = 15

    override fun getErrorCount() = 2

    override fun getFloatCount() = 2

    override fun exeHandler(point: Point) {
        UtilMouse.clickLeftInPoint(getRandomPoint(point))
    }

    override fun findAreaRate() = AimImageAreaRate(0.15f, 0.5f, 0.70f, 0.75f)

    override fun usePoint(screenSize: Point) = Point(((728 / 1439f) * screenSize.x).toInt(), ((855 / 899f) * screenSize.y).toInt())
}