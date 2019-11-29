package project.lushi.findimageentities

import findimage.AimImageAreaRate
import findimage.BaseImageFind
import java.awt.Point

class StartGame(imagePath: String) : BaseImageFind(imagePath = imagePath) {
    override fun exeHandler(point: Point) {

    }

    override fun grayValue() = 5f

    override fun grayDiffValue() = 5

    override fun findAreaRate() = AimImageAreaRate(0.5f, 0.5f, 1f, 1f)

    override fun getErrorCount() = 10

    override fun getFloatCount() = 0

    override fun useThisPoint() = Point()
}