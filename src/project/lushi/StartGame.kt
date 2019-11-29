package project.lushi

import findimage.findmethodimpl.ImageFindRGBGrayValue
import findimage.isErrirPoint
import project.lushi.findimageentities.StartGame
import tools.UtilMouse
import tools.UtilScreenShot
import tools.UtilSoftware

fun main(args: Array<String>) {
    project.lushi.StartGame().start()
}

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
        ImageFindRGBGrayValue(screenShotImage).findImagePoint(StartGame("")).apply {
            if (!isErrirPoint()) {
                //当前是开始界面
                UtilMouse.moveTo(x, y)
                UtilMouse.clickLeft()
            } else {


            }
        }
    }
}