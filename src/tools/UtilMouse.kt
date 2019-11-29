package tools

import java.awt.event.InputEvent

/**
 * 鼠标操作工具类
 */
object UtilMouse {
    /**
     * 将鼠标移动到(x,y)
     */
    fun moveTo(x: Int, y: Int) {
        UtilSystem.mouseMove(x, y)
    }

    /**
     * 单击鼠标左键
     */
    fun clickLeft() {
        UtilSystem.mousePress(InputEvent.BUTTON1_MASK)
        UtilSystem.mouseRelease(InputEvent.BUTTON1_MASK)
    }

    /**
     * 按下鼠标左键
     */
    fun clickDownLeft() {
        UtilSystem.mousePress(InputEvent.BUTTON1_MASK)
    }

    /**
     * 释放鼠标左键
     */
    fun clicUpLeft() {
        UtilSystem.mouseRelease(InputEvent.BUTTON1_MASK)
    }

    /**
     * 单击鼠标右键
     */
    fun clickRight() {
        UtilSystem.mousePress(InputEvent.BUTTON3_MASK)
        UtilSystem.mouseRelease(InputEvent.BUTTON3_MASK)
    }

    /**
     * 长按鼠标左键(默认长按2秒)
     */
    fun longClickLeft(time: Int = 2000) {
        UtilSystem.mousePress(InputEvent.BUTTON1_MASK)
        UtilSystem.sleep(time)
        UtilSystem.mouseRelease(InputEvent.BUTTON1_MASK)
    }

    /**
     * 长按鼠标右键(默认长按2秒)
     */
    fun longClickRight(time: Int = 2000) {
        UtilSystem.mousePress(InputEvent.BUTTON3_MASK)
        UtilSystem.sleep(time)
        UtilSystem.mouseRelease(InputEvent.BUTTON3_MASK)
    }

    /**
     * 双击鼠标左键
     */
    fun doubleLeft() {
        UtilSystem.mousePress(InputEvent.BUTTON1_MASK)
        UtilSystem.mouseRelease(InputEvent.BUTTON1_MASK)
        UtilSystem.mousePress(InputEvent.BUTTON1_MASK)
        UtilSystem.mouseRelease(InputEvent.BUTTON1_MASK)
    }

    /**
     * 双加鼠标右键
     */
    fun doubleRight() {
        UtilSystem.mousePress(InputEvent.BUTTON3_MASK)
        UtilSystem.mouseRelease(InputEvent.BUTTON3_MASK)
        UtilSystem.mousePress(InputEvent.BUTTON3_MASK)
        UtilSystem.mouseRelease(InputEvent.BUTTON3_MASK)
    }

    /**
     * 向下滑动滑轮
     */
    fun downPulley() {

    }

    /**
     * 向上滑动滑轮
     */
    fun topPulley() {

    }

}