package project.yinxionglianmeng.func

import findimage.ErrorPoint
import findimage.findmethodimpl.ImageFindRGBGrayValue
import interfaces.IBaseFunc
import javafx.scene.input.KeyCode
import tools.UtilKeyboard
import tools.UtilMouse
import tools.UtilScreenShot
import java.awt.Point

class YasuoEEE : IBaseFunc() {

    override fun exe() {
        val point = 检测附加可e对象()
        if (point.x != -1) {
            UtilMouse.moveTo(point.x, point.y)
            UtilKeyboard.click(KeyCode.E.impl_getCode())
        }
    }

    override fun stop() {
    }

    override fun notice() = "注意按e技能的时候，不要把鼠标放到可以e的小兵、野怪或敌人的身上！！"

    private fun 检测附加可e对象(): Point {
        val screenImage = UtilScreenShot.getScreenShot()
//        return ImageFindRGBGrayValue().findImagePoint(null)
        return ErrorPoint
    }
}