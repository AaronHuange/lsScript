package utils.computer;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.awt.AWTException;
import java.awt.Robot;

public class C_ϵͳ������ extends Robot {
    private Robot robot;
    private static C_ϵͳ������ p_ϵͳ������;

    static {
        try {
            p_ϵͳ������ = new C_ϵͳ������();
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    private C_ϵͳ������() throws AWTException {
        super();
    }


    /***************************************** �ṩ�ⲿ���÷��� ************************************************/
    public static C_ϵͳ������ m_���ϵͳ������() {
        if (p_ϵͳ������ == null) {
            try {
                p_ϵͳ������ = new C_ϵͳ������();
            } catch (AWTException e) {
            }
        }
        return p_ϵͳ������;
    }

    public void m_��ͣ(int Ҫ��ͣ�ĺ���) {
        setAutoDelay(Ҫ��ͣ�ĺ���);
    }
}
