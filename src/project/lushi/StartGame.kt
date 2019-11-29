package project.lushi

import findimage.findmethodimpl.ImageFindRGBGrayValue
import tools.UtilScreenShot
import tools.UtilSoftware

/**
 * 炉石开始游戏入口
 */
class StartGame {

    fun start() {
        if (!UtilSoftware.softIsExeing()) {
            UtilSoftware.exeSoft()
        }
        shotAndParse()
    }

    fun shotAndParse() {
        val screenShotImage = UtilScreenShot.getScreenShot()!!
        //判断当前场景


        //

//        ImageFindRGBGrayValue(screenShotImage, 360, 160).findImagePoint()

    }
}