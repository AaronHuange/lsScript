import utils.computer.C_GameHelper;
import utils.computer.C_ϵͳ������;
import utils.other.C_��־;

import java.util.List;

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
        C_��־.m_��ӡ("�����ű�");
        C_��־.m_��ӡ("��ʼ��ȡ�����ļ���ɨ��ͼ��");
        C_ͼ��.m_ɨ��ͼ��();
        C_��־.m_��ӡ("ɨ��ͼ�����");
        List<C_imagepath> p_����ͼ�� = C_ͼ��.m_����ͼ�б�();

        while (true) {
            switch (C_GameHelper.m_next()) {
                case 0:
                    C_��־.m_��ӡ("�����ʼһ����Ϸ");


                    C_��־.m_��ӡ("���");
                    break;
                case 1:
                    C_��־.m_��ӡ("");

                    C_��־.m_��ӡ("���");
                    break;
                case 2:
                    C_��־.m_��ӡ("");

                    C_��־.m_��ӡ("���");
                    break;
                default:
            }
            C_ϵͳ������.m_���ϵͳ������().m_��ͣ(500);
        }

//        C_ϵͳ������ p_ϵͳ������ = C_ϵͳ������.m_���ϵͳ������();
//        C_��ͼ��λ�� p_ͼƬλ�� = new C_��ͼ��λ��("C://aa.png");
//        C_�������� p_�������� = C_��������.m_�����������(p_ϵͳ������);
//        p_��������.m_����ƶ���xy����(p_ͼƬλ��.m_ͼƬ��X����(), p_ͼƬλ��.m_ͼƬ��Y����());
//        p_��������.m_˫��������();
//        p_ϵͳ������.m_��ͣ(1000);
    }

}
