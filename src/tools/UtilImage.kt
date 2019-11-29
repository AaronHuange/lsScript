package tools

import java.awt.image.BufferedImage
import java.io.File
import java.io.IOException
import javax.imageio.ImageIO

/**
 * 图片工具
 */
object UtilImage {

    /**
     * 从磁盘中加载图片
     */
    fun loadImage(imagePath: String): BufferedImage? {
        var bfImage: BufferedImage? = null
        try {
            bfImage = ImageIO.read(File(imagePath))
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return bfImage
    }

}