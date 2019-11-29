import utils.computer.C_GameHelper;
import utils.computer.C_系统控制器;
import utils.other.C_日志;

import java.util.List;

public class Test {
    /*****
     * //移动鼠标
     * robot.mouseMove(500, 500);
     * //按下ESC，退出右键状态
     * System.out.println("按下ESC");
     * robot.keyPress(KeyEvent.VK_ESCAPE);
     * robot.keyRelease(KeyEvent.VK_ESCAPE);
     * //滚动鼠标滚轴
     * System.out.println("滚轴");
     * robot.mouseWheel(5);
     * <p>
     * <p>
     * //按下Alt+TAB键（切换桌面窗口）
     * robot.keyPress(KeyEvent.VK_ALT);
     * for(int i=1;i<=2;i++)
     * {
     * robot.keyPress(KeyEvent.VK_TAB);
     * robot.keyRelease(KeyEvent.VK_TAB);
     * }
     * robot.keyRelease(KeyEvent.VK_ALT);
     *
     * @param args
     */
    public static void main(String[] args) {
        C_日志.m_打印("启动脚本");
        C_日志.m_打印("开始读取配置文件、扫描图库");
        C_图库.m_扫描图库();
        C_日志.m_打印("扫描图库完毕");
        List<C_imagepath> p_磁盘图库 = C_图库.m_磁盘图列表();

        while (true) {
            switch (C_GameHelper.m_next()) {
                case 0:
                    C_日志.m_打印("点击开始一局游戏");


                    C_日志.m_打印("完毕");
                    break;
                case 1:
                    C_日志.m_打印("");

                    C_日志.m_打印("完毕");
                    break;
                case 2:
                    C_日志.m_打印("");

                    C_日志.m_打印("完毕");
                    break;
                default:
            }
            C_系统控制器.m_获得系统控制器().m_暂停(500);
        }

//        C_系统控制器 p_系统控制器 = C_系统控制器.m_获得系统控制器();
//        C_以图找位置 p_图片位置 = new C_以图找位置("C://aa.png");
//        C_鼠标控制器 p_鼠标控制器 = C_鼠标控制器.m_获得鼠标控制器(p_系统控制器);
//        p_鼠标控制器.m_鼠标移动至xy坐标(p_图片位置.m_图片的X坐标(), p_图片位置.m_图片的Y坐标());
//        p_鼠标控制器.m_双击鼠标左键();
//        p_系统控制器.m_暂停(1000);
    }

}
