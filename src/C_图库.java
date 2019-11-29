import utils.other.C_��־;
import utils.other.FileHelper;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class C_ͼ�� {
    //������
    private static List<C_imagepath> p_�ƿ��б�;

    //��ʼ��Ϸ�����
    private static List<C_imagepath> startGameList;

    //Ӣ�ۼ�����
    private static List<C_imagepath> eroicSkillshList;

    //�����
    private static List<C_imagepath> roleList;

    //���ֱ������Ƶ�����
    private static List<String> saveImageNameList;

    public static void m_ɨ��ͼ��() {
        //����ͳ�ʼ��
        if (p_�ƿ��б� != null) {
            p_�ƿ��б�.clear();
            startGameList.clear();
            eroicSkillshList.clear();
            roleList.clear();
            saveImageNameList.clear();
        } else {
            p_�ƿ��б� = new ArrayList<>();
            startGameList = new ArrayList<>();
            eroicSkillshList = new ArrayList<>();
            roleList = new ArrayList<>();
            saveImageNameList = new ArrayList<>();
        }

        //
        List<String> p_�����ļ� = FileHelper.getFileContentList(new File("/Users/MacBook/Documents/projects/java/lushiscript/src/utils/other/readme"));
        int addThis = 0;
        for (String str : p_�����ļ�) {
            if (null != str && !"".endsWith(str)) {
                switch (str.trim()) {
                    case "��ʼ��Ϸ���":
                        addThis = 0;
                        continue;

                    case "ͼ���ַ":
                        //ֻ������ͼƬ��ַ���ѣ�����ͼƬ����Ļ���
                        addThis = 1;
                        continue;

                    case "ͼ��ͼƬ":
                        addThis = 2;
                        continue;

                    case "��������":
                        addThis = 3;
                        continue;

                    case "նɱ��":
                        addThis = 4;
                        break;

                    case "��Ҫ�����":
                        addThis = 5;
                        break;

                    case "Ҫ���Ľ���":
                        addThis = 6;
                        break;

                    case "Ч���϶�ָ��":
                        addThis = 7;
                        break;

                    case "Ч������ָ��":
                        addThis = 8;
                        break;

                    default:

                }

                switch (addThis) {
                    case 0:
                        if (str.contains("_")) {
                            C_imagepath c_imagepath = new C_imagepath();
                            String[] strs = str.trim().split("_");
                            if (str.length() == 2) {
                                c_imagepath.setP_imageType(C_imagepath.P_startGame);
                                c_imagepath.setP_name(strs[0]);
                                c_imagepath.setP_path(strs[1]);
                                c_imagepath.setP_useNum(-1);
                                p_�ƿ��б�.add(c_imagepath);
                                startGameList.add(c_imagepath);
                            }
                        }
                        break;
                    case 1:
                        continue;
                    case 2:
                        if (str.contains("_")) {
                            C_imagepath c_imagepath = new C_imagepath();
                            String[] strs = str.trim().split("_");
                            if (str.length() == 3) {
                                int userNum = -1;
                                try {
                                    userNum = Integer.parseInt(strs[0]);
                                } catch (Exception e) {
                                }

                                c_imagepath.setP_imageType(C_imagepath.P_images);
                                c_imagepath.setP_name(strs[1]);
                                c_imagepath.setP_path(strs[2]);
                                c_imagepath.setP_useNum(userNum);
                                p_�ƿ��б�.add(c_imagepath);
                                roleList.add(c_imagepath);
                            }
                        }
                        break;
                    case 3:
                        //��������
                        saveImageNameList.add(str);
                        break;

                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    default:
                }


                C_��־.m_��ӡ(str);

            }
        }
    }

    public static List<C_imagepath> m_����ͼ�б�() {
        return p_�ƿ��б�;
    }

    public static List<C_imagepath> getStartGameList() {
        return startGameList;
    }

    public static List<C_imagepath> getEroicSkillshList() {
        return eroicSkillshList;
    }

    public static List<C_imagepath> getRoleList() {
        return roleList;
    }

    public static List<String> getSaveImageNameList() {
        return saveImageNameList;
    }
}
