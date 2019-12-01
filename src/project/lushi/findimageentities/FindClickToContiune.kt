package project.lushi.findimageentities

import findimage.AimImageAreaRate
import findimage.BaseImageFind
import tools.UtilFile
import tools.UtilMouse
import java.awt.Point

/**
 * 继续游戏(选用其他图片做查找，透明的查找现在的算法支持的不太好。)
 */
class FindClickToContiune(imagePath: String = UtilFile.getAssetsImagePath("clicktocontiune.png")) : BaseImageFind(imagePath = imagePath) {
    override fun grayValue() = 3f

    override fun grayDiffValue() = 5

    override fun getErrorCount() = 0

    override fun getFloatCount() = 1

    override fun exeHandler(point: Point) {
        UtilMouse.clickLeftInPoint(getRandomPoint(point))
    }


    override fun findAreaRate() = AimImageAreaRate(0.35f, 0.7f, 0.65f, 1f)

    override fun usePoint(screenSize: Point) = Point(((728 / 1439f) * screenSize.x).toInt(), ((855 / 899f) * screenSize.y).toInt())
}