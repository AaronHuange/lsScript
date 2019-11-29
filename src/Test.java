import tools.UtilFile;
import tools.UtilKeyboard;
import tools.UtilLogCat;
import tools.UtilMouse;

import java.awt.*;

public class Test {

    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1500);
                        Point p = UtilMouse.INSTANCE.getMousePosition();
                        UtilLogCat.INSTANCE.v("location is " + p.x + " " + p.y);
                        UtilKeyboard.INSTANCE.inputString("this is a test script");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
//        UtilMouse.INSTANCE.moveTo(0, 0);
        UtilLogCat.INSTANCE.v("project path is " + UtilFile.getCurrentPath());
    }

}
