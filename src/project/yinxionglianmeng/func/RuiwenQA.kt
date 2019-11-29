package project.yinxionglianmeng.func

import interfaces.IBaseFunc
import tools.UtilMouse
import tools.UtilSystem
import java.awt.Point

/**
 * 瑞雯光速QA
 */
class RuiwenQA : IBaseFunc() {
    override fun notice() = "没有注意的，尽情驰骋把！"

    override fun exe() {
        onceQa()
    }

    override fun stop() {

    }

    /**
     * 一次QA
     */
    private fun onceQa() {
        UtilSystem.sleep(100)
        UtilMouse.clickRightInPoint(Point(0, 0))
        UtilSystem.sleep(100)
        UtilMouse.clickRight()
    }

}