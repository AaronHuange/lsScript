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

    /**
     * 获取操作系统类型
     */
    fun getSystemType(): SystemType {
        val systemStr = System.getProperty("os.name").toLowerCase()
        when {
            systemStr.contains("mac") ->
                return SystemType.Mac
            systemStr.contains("window") ->
                return SystemType.Windows
            systemStr.contains("linux") ->
                return SystemType.Linux
            else ->
                return SystemType.Other
        }
    }
}

enum class SystemType {
    Windows,
    Mac,
    Linux,
    Other
}