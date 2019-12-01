package tools

import javax.swing.JOptionPane

/**
 * 弹窗工具
 */
object UtilDialog {

    fun showYESConfirmDialog(mssage: String, title: String = "", button: String = "确定", onYesClick: () -> Unit) {
        val options = arrayOf(button)
        val response = JOptionPane.showOptionDialog(null, mssage, title, JOptionPane.YES_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, options, options[0])
        if (response == 0) {
            onYesClick()
        }
    }


    fun showYESNOConfirmDialog(mssage: String, title: String = "", onYesClick: () -> Unit, onNoClick: () -> Unit) {
        val options = arrayOf("帮助", " 取消 ", "确定")
        val response = JOptionPane.showOptionDialog(null, " 这是个选项对话框，用户可以选择自己的按钮的个数 ", " 选项对话框标题 ", JOptionPane.YES_OPTION,

                JOptionPane.QUESTION_MESSAGE, null, options, options[0])

        if (response == 0) {
            onYesClick()
        } else if (response == 1) {


        } else if (response == 2) {


        }
    }


    fun showYESNOCancelConfirmDialog(mssage: String, title: String = "", onYesClick: () -> Unit, onNoClick: () -> Unit) {
        val options = arrayOf("帮助", " 取消 ", "确定")
        val response = JOptionPane.showOptionDialog(null, " 这是个选项对话框，用户可以选择自己的按钮的个数 ", " 选项对话框标题 ", JOptionPane.YES_OPTION,

                JOptionPane.QUESTION_MESSAGE, null, options, options[0])

        if (response == 0) {
            onYesClick()
        } else if (response == 1) {


        } else if (response == 2) {


        }
    }


    fun showYESInputDialog(onYesClick: (msg: String) -> Unit) {
        onYesClick("")
    }

}