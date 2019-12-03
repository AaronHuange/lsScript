package project.lushi.findimageentities.findcardimage

import findimage.BaseImageFind
import tools.UtilFile
import java.awt.Point

/**
 * 暗金教侍从卡片的查找模型
 */
class FindAnJinJiaoShiCong(imagePath: String = UtilFile.getAssetsImagePath("anjingjiaoshichong.jpg")) : BaseImageFind(imagePath = imagePath) {
    override fun grayValue() = 1f

    override fun grayDiffValue() = 5

    override fun findAreaRate() = null

    override fun getErrorCount() = 10

    override fun getFloatCount() = 1

    override fun usePoint(screenSize: Point) = Point(0, 0)

    override fun exeHandler(point: Point) {
    }
}