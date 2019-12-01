package project.lushi.findimageentities

import findimage.AimImageAreaRate
import findimage.BaseImageFind
import tools.UtilFile
import tools.UtilMouse
import java.awt.Point

/**
 * 我的回合且该结束了
 */
class FindMyBoutFinish(imagePath: String = UtilFile.getAssetsImagePath("myboutfinish.jpg")) : BaseImageFind(imagePath = imagePath) {
    override fun exeHandler(point: Point) {
        UtilMouse.clickLeftInPoint(getRandomPoint(point))
    }
    override fun grayValue() = 2f

    override fun grayDiffValue() = 20

    override fun getErrorCount() = 0

    override fun getFloatCount() = 1

    override fun findAreaRate() = AimImageAreaRate(0.6f, 0.4f, 1f, 0.6f)

    override fun usePoint(screenSize: Point) = Point(((1221 / 1439f) * screenSize.x).toInt(), ((416 / 899f) * screenSize.y).toInt())

}