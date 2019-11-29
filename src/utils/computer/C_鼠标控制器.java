package utils.computer;

import java.awt.event.InputEvent;

public class C_鼠标控制器 {
    private C_系统控制器 p_系统控制器;

    private C_鼠标控制器(C_系统控制器 p_系统控制器) {
        this.p_系统控制器 = p_系统控制器;
    }

    /***************************************** 提供外部调用方法 ************************************************/
    public static C_鼠标控制器 m_获得鼠标控制器(C_系统控制器 p_系统控制器) {
        return new C_鼠标控制器(p_系统控制器);
    }

    public void m_鼠标移动至xy坐标(int x, int y) {
        System.out.println("鼠标移动至 x:" + x + " y:" + y);
        p_系统控制器.mouseMove(x, y);
    }

    public void m_单击鼠标左键() {
        System.out.println("单击左键");
        p_系统控制器.mousePress(InputEvent.BUTTON1_MASK);
        p_系统控制器.mouseRelease(InputEvent.BUTTON1_MASK);
    }

    public void m_按下鼠标左键() {
        System.out.println("按下鼠标左键");
        p_系统控制器.mousePress(InputEvent.BUTTON1_MASK);
    }

    public void m_释放鼠标左键() {
        System.out.println("按下鼠标左键");
        p_系统控制器.mouseRelease(InputEvent.BUTTON1_MASK);
    }

    public void m_双击鼠标左键() {
        System.out.println("双击鼠标左键");
        p_系统控制器.mousePress(InputEvent.BUTTON1_MASK);
        p_系统控制器.mouseRelease(InputEvent.BUTTON1_MASK);
        p_系统控制器.mousePress(InputEvent.BUTTON1_MASK);
        p_系统控制器.mouseRelease(InputEvent.BUTTON1_MASK);
    }

    public void m_单击鼠标右键() {
        System.out.println("单击鼠标右键");
        p_系统控制器.mousePress(InputEvent.BUTTON3_MASK);
        p_系统控制器.mouseRelease(InputEvent.BUTTON3_MASK);
    }

    public void m_按下鼠标右键() {
        System.out.println("按下鼠标右键");
        p_系统控制器.mousePress(InputEvent.BUTTON3_MASK);
    }

    public void m_释放鼠标右键() {
        System.out.println("释放鼠标右键");
        p_系统控制器.mousePress(InputEvent.BUTTON3_MASK);
    }

    public void m_双击鼠标右键() {
        System.out.println("双击鼠标右键");
        p_系统控制器.mousePress(InputEvent.BUTTON3_MASK);
        p_系统控制器.mouseRelease(InputEvent.BUTTON3_MASK);
        p_系统控制器.setAutoDelay(60);
        p_系统控制器.mousePress(InputEvent.BUTTON3_MASK);
        p_系统控制器.mouseRelease(InputEvent.BUTTON3_MASK);
    }

    public void m_向上滚动滑轮() {

    }

    public void m_向下滚动滑轮() {


    }

}
