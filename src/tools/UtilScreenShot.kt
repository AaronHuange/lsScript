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
     * 全屏幕截图
     */
    fun getScreenShot(): BufferedImage? {
        val width = Toolkit.getDefaultToolkit().screenSize.getWidth().toInt()
        val height = Toolkit.getDefaultToolkit().screenSize.getHeight().toInt()
        return getFullScreenShot(Rectangle(0, 0, width, height))
    }

    /**
     *  指定区域截屏
     */
    fun getRectScreenShot(startX: Int, startY: Int, toX: Int, toY: Int): BufferedImage? {
        return getFullScreenShot(Rectangle(startX, startY, toX, toY))
    }

    /**
     * 截图
     *
     * @return 返回BufferedImage
     */
    private fun getFullScreenShot(rectangle: Rectangle): BufferedImage? {
        var bfImage: BufferedImage? = null
        try {
            val robot = Robot()
            bfImage = robot.createScreenCapture(rectangle)
        } catch (e: AWTException) {
            e.printStackTrace()
        }
        return bfImage
    }
}