package tools

import java.awt.AWTException
import java.awt.Rectangle
import java.awt.Robot
import java.awt.Toolkit
import java.awt.image.BufferedImage

/**
 * 截屏工具
 */
object UtilScreenShot {

    /**
     * 得到屏幕截图
     */
    fun getScreenShot(): BufferedImage? {
        return getFullScreenShot()
    }

    /**
     * 全屏截图
     *
     * @return 返回BufferedImage
     */
    private fun getFullScreenShot(): BufferedImage? {
        var bfImage: BufferedImage? = null
        val width = Toolkit.getDefaultToolkit().screenSize.getWidth().toInt()
        val height = Toolkit.getDefaultToolkit().screenSize.getHeight().toInt()
        try {
            val robot = Robot()
            bfImage = robot.createScreenCapture(Rectangle(0, 0, width, height))
        } catch (e: AWTException) {
            e.printStackTrace()
        }
        return bfImage
    }

}