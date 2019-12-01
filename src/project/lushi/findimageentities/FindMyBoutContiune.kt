package project.lushi.findimageentities

import findimage.AimImageAreaRate
import findimage.BaseImageFind
import tools.UtilFile
import java.awt.Point

class FindMyBoutContiune(imagePath: String = UtilFile.getAssetsImagePath("myboutcontiune.jpg")) : BaseImageFind(imagePath = imagePath) {

    override fun grayValue() = 1f

    override fun grayDiffValue() = 12

    override fun getErrorCount() = 0

    override fun getFloatCount() = 1

    override fun findAreaRate() = AimImageAreaRate(0.6f, 0.4f, 1f, 0.6f)

    override fun exeHandler(point: Point) {
        //我的回合需要继续时，这张被发现的图片的地方不能点所以不能进行任何操作
    }

    override fun usePoint(screenSize: Point) = Point(0, 0)

}