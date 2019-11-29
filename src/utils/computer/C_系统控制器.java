package utils.computer;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.awt.AWTException;
import java.awt.Robot;

public class C_系统控制器 extends Robot {
    private Robot robot;
    private static C_系统控制器 p_系统控制器;

    static {
        try {
            p_系统控制器 = new C_系统控制器();
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    private C_系统控制器() throws AWTException {
        super();
    }


    /***************************************** 提供外部调用方法 ************************************************/
    public static C_系统控制器 m_获得系统控制器() {
        if (p_系统控制器 == null) {
            try {
                p_系统控制器 = new C_系统控制器();
            } catch (AWTException e) {
            }
        }
        return p_系统控制器;
    }

    public void m_暂停(int 要暂停的毫秒) {
        setAutoDelay(要暂停的毫秒);
    }
}
