package tools

import java.awt.Toolkit
import java.awt.datatransfer.DataFlavor
import java.awt.datatransfer.StringSelection

object UtilClipboard {

    /**
     * 把文本设置到剪贴板（复制）
     */
    fun setClipboardText(text: String) {
        val clipboard = Toolkit.getDefaultToolkit().systemClipboard
        val trans = StringSelection(text)
        clipboard.setContents(trans, null)
    }


    /**
     * 从剪贴板中获取文本（粘贴）
     */
    fun getClipboardString(): String {
        val clipboard = Toolkit.getDefaultToolkit().systemClipboard
        val trans = clipboard.getContents(null)
        trans ?: return ""
        if (trans.isDataFlavorSupported(DataFlavor.stringFlavor)) {
            try {
                val text = trans.getTransferData(DataFlavor.stringFlavor) as String
                return text
            } catch (e: Exception) {
                return ""
            }
        }
        return ""
    }

}