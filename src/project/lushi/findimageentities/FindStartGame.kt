package project.lushi.findimageentities

import findimage.AimImageAreaRate
import findimage.BaseImageFind
import findimage.ErrorPoint
import tools.UtilFile
import tools.UtilMouse
import java.awt.Point

/**
 * 已经调试好
 */
class FindStartGame(imagePath: String = UtilFile.getAssetsImagePath("startgame.jpg")) : BaseImageFind(imagePath = imagePath) {
    override fun exeHandler(point: Point) {
        UtilMouse.clickLeftInPoint(getRandomPoint(point))
    }

    override fun grayValue() = 4f

    override fun grayDiffValue() = 6

    override fun getErrorCount() = 0

    override fun getFloatCount() = 1

    override fun findAreaRate() = AimImageAreaRate(0.6f, 0.6f, 1f, 1f)

    override fun usePoint(screenSize: Point) = Point(((1090 / 1439f) * screenSize.x).toInt(), ((739 / 899f) * screenSize.y).toInt())

}