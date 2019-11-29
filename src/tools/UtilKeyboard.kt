package tools

import javafx.scene.input.KeyCode

class UtilKeyboard {

    /**
     * 利用剪贴板输入文字
     */
    fun inputString(str: String) {
        val oldStr = UtilClipboard.getClipboardString()
        UtilClipboard.setClipboardText(str)
        clickDown(KeyCode.CONTROL.impl_getCode())
        click(KeyCode.V.impl_getCode())
        clickRelease(KeyCode.CONTROL.impl_getCode())
        UtilClipboard.setClipboardText(oldStr)
    }

    /**
     * 单击某个键
     */
    fun click(keyCode: Int) {
        UtilSystem.keyPress(keyCode)
        UtilSystem.keyRelease(keyCode)
    }

    /**
     * 按下某个键
     */
    fun clickDown(keyCode: Int) {
        UtilSystem.keyPress(keyCode)
    }

    /**
     * 释放某个键
     */
    fun clickRelease(keyCode: Int) {
        UtilSystem.keyRelease(keyCode)
    }

    /**
     * 长按
     */
    fun longClick(keyCode: Int) {
        UtilSystem.keyPress(keyCode)
        UtilSystem.sleep(1000)
        UtilSystem.keyRelease(keyCode)
    }


}