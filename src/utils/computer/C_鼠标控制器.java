package utils.computer;

import java.awt.event.InputEvent;

public class C_�������� {
    private C_ϵͳ������ p_ϵͳ������;

    private C_��������(C_ϵͳ������ p_ϵͳ������) {
        this.p_ϵͳ������ = p_ϵͳ������;
    }

    /***************************************** �ṩ�ⲿ���÷��� ************************************************/
    public static C_�������� m_�����������(C_ϵͳ������ p_ϵͳ������) {
        return new C_��������(p_ϵͳ������);
    }

    public void m_����ƶ���xy����(int x, int y) {
        System.out.println("����ƶ��� x:" + x + " y:" + y);
        p_ϵͳ������.mouseMove(x, y);
    }

    public void m_����������() {
        System.out.println("�������");
        p_ϵͳ������.mousePress(InputEvent.BUTTON1_MASK);
        p_ϵͳ������.mouseRelease(InputEvent.BUTTON1_MASK);
    }

    public void m_����������() {
        System.out.println("����������");
        p_ϵͳ������.mousePress(InputEvent.BUTTON1_MASK);
    }

    public void m_�ͷ�������() {
        System.out.println("����������");
        p_ϵͳ������.mouseRelease(InputEvent.BUTTON1_MASK);
    }

    public void m_˫��������() {
        System.out.println("˫��������");
        p_ϵͳ������.mousePress(InputEvent.BUTTON1_MASK);
        p_ϵͳ������.mouseRelease(InputEvent.BUTTON1_MASK);
        p_ϵͳ������.mousePress(InputEvent.BUTTON1_MASK);
        p_ϵͳ������.mouseRelease(InputEvent.BUTTON1_MASK);
    }

    public void m_��������Ҽ�() {
        System.out.println("��������Ҽ�");
        p_ϵͳ������.mousePress(InputEvent.BUTTON3_MASK);
        p_ϵͳ������.mouseRelease(InputEvent.BUTTON3_MASK);
    }

    public void m_��������Ҽ�() {
        System.out.println("��������Ҽ�");
        p_ϵͳ������.mousePress(InputEvent.BUTTON3_MASK);
    }

    public void m_�ͷ�����Ҽ�() {
        System.out.println("�ͷ�����Ҽ�");
        p_ϵͳ������.mousePress(InputEvent.BUTTON3_MASK);
    }

    public void m_˫������Ҽ�() {
        System.out.println("˫������Ҽ�");
        p_ϵͳ������.mousePress(InputEvent.BUTTON3_MASK);
        p_ϵͳ������.mouseRelease(InputEvent.BUTTON3_MASK);
        p_ϵͳ������.setAutoDelay(60);
        p_ϵͳ������.mousePress(InputEvent.BUTTON3_MASK);
        p_ϵͳ������.mouseRelease(InputEvent.BUTTON3_MASK);
    }

    public void m_���Ϲ�������() {

    }

    public void m_���¹�������() {


    }

}
