package tools

import java.awt.Robot

object UtilSystem : Robot() {

    init {
        setAutoWaitForIdle(true)
    }

    /**
     * 暂停time毫秒
     */
    fun sleep(time: Int) {
        setAutoDelay(time)
    }
}