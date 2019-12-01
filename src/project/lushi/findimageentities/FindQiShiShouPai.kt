package project.lushi.findimageentities

import findimage.AimImageAreaRate
import findimage.BaseImageFind
import tools.UtilFile
import tools.UtilLogCat
import java.awt.Point

class FindQiShiShouPai(imagePath: String = UtilFile.getAssetsImagePath("qishishoupai.jpg")) : BaseImageFind(imagePath = imagePath) {

    override fun grayValue() = 1f

    override fun grayDiffValue() = 12

    override fun getErrorCount() = 0

    override fun getFloatCount() = 1

    override fun exeHandler(point: Point) {
        //这张图本身不需要做任何操作
        UtilLogCat.todo("在GameManage中处理起始手牌的操作")
    }

    override fun usePoint(screenSize: Point) = Point(0, 0)

    override fun findAreaRate() = AimImageAreaRate(0.3f, 0f, 0.7f, 0.25f)
}