package project.lushi.entities

import project.lushi.enums.Environment
import java.awt.image.BufferedImage

/**
 * 游戏环境
 */
class EnvironmentBean(result: Environment, screenImage: BufferedImage) {
    val result: Environment

    val screenImage: BufferedImage

    init {
        this.result = result
        this.screenImage = screenImage
    }
}