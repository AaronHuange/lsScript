import tools.UtilFile;
import tools.UtilMouse;
import tools.UtilSystem;
import utils.other.C_��־;

import java.awt.*;

public class Test {
    /*****
     * //�ƶ����
     * robot.mouseMove(500, 500);
     * //����ESC���˳��Ҽ�״̬
     * System.out.println("����ESC");
     * robot.keyPress(KeyEvent.VK_ESCAPE);
     * robot.keyRelease(KeyEvent.VK_ESCAPE);
     * //����������
     * System.out.println("����");
     * robot.mouseWheel(5);
     * <p>
     * <p>
     * //����Alt+TAB�����л����洰�ڣ�
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
                        C_��־.m_��ӡ("location is " + p.x + " " + p.y);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        UtilMouse.INSTANCE.moveTo(0, 0);
        C_��־.m_��ӡ("project path is " + UtilFile.getCurrentPath());
    }

}
