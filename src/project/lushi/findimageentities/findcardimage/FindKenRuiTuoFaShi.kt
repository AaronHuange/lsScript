package project.lushi.findimageentities.findcardimage

import findimage.BaseImageFind
import tools.UtilFile
import java.awt.Point
import java.io.File

class FindKenRuiTuoFaShi(imagePath: String = UtilFile.getAssetsImagePath("cardgouphanbingaomifa" + File.separator + "kenruituofashi.jpg"))
    : BaseImageFind(imagePath = imagePath) {
    override fun grayValue() = 1f

    override fun grayDiffValue() = 5

    override fun findAreaRate() = null

    override fun getErrorCount() = 10

    override fun getFloatCount() = 1

    override fun usePoint(screenSize: Point) = Point(0, 0)

    override fun exeHandler(point: Point) {
    }
}