package project.lushi.findimageentities

import findimage.AimImageAreaRate
import findimage.BaseImageFind
import org.mozilla.javascript.BaseFunction
import tools.UtilFile
import java.awt.Point

/**
 * 敌方回合
 */
class FindEnemyBout(imagePath: String = UtilFile.getAssetsImagePath("enemybout.jpg")) : BaseImageFind(imagePath = imagePath) {
    override fun findAreaRate() = AimImageAreaRate(0.6f, 0.4f, 1f, 0.6f)

    override fun usePoint(screenSize: Point) = Point(0, 0)

    override fun exeHandler(point: Point) {
        //敌方回合不需要进行任何操作
    }

    override fun grayValue() = 1f

    override fun grayDiffValue() = 12

    override fun getErrorCount() = 0

    override fun getFloatCount() = 1
}