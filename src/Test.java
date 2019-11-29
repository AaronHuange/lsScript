import tools.UtilFile;
import tools.UtilMouse;
import tools.UtilSystem;
import utils.other.C_日志;

import java.awt.*;

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

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1500);
                        Point p = UtilMouse.INSTANCE.getMousePosition();
                        C_日志.m_打印("location is " + p.x + " " + p.y);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        UtilMouse.INSTANCE.moveTo(0, 0);
        C_日志.m_打印("project path is " + UtilFile.getCurrentPath());
    }

}
