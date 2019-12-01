package project.lushi.findimageentities

import findimage.AimImageAreaRate
import findimage.BaseImageFind
import tools.UtilFile
import tools.UtilMouse
import java.awt.Point

/**
 * 对战模式图片（已经调试好）
 */
open class FindDuiZhanMoShi(imagePath: String = UtilFile.getAssetsImagePath("selectmode.jpg")) : BaseImageFind(imagePath = imagePath) {


    override fun findAreaRate() = AimImageAreaRate(0.3f, 0.1f, 0.6f, 0.6f)

    override fun grayValue() = 2f

    override fun grayDiffValue() = 3

    override fun getErrorCount() = 3

    override fun getFloatCount() = 1

    override fun usePoint(screenSize: Point) = Point(((718 / 1439f) * screenSize.x).toInt(), ((275 / 899f) * screenSize.y).toInt())

    override fun exeHandler(point: Point) {
        UtilMouse.clickLeftInPoint(getRandomPoint(point))
    }
}