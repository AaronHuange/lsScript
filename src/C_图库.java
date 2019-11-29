import utils.other.C_日志;
import utils.other.FileHelper;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class C_图库 {
    //所有牌
    private static List<C_imagepath> p_牌库列表;

    //开始游戏相关牌
    private static List<C_imagepath> startGameList;

    //英雄技能牌
    private static List<C_imagepath> eroicSkillshList;

    //随从牌
    private static List<C_imagepath> roleList;

    //起手保留的牌的名字
    private static List<String> saveImageNameList;

    public static void m_扫描图库() {
        //清除和初始化
        if (p_牌库列表 != null) {
            p_牌库列表.clear();
            startGameList.clear();
            eroicSkillshList.clear();
            roleList.clear();
            saveImageNameList.clear();
        } else {
            p_牌库列表 = new ArrayList<>();
            startGameList = new ArrayList<>();
            eroicSkillshList = new ArrayList<>();
            roleList = new ArrayList<>();
            saveImageNameList = new ArrayList<>();
        }

        //
        List<String> p_配置文件 = FileHelper.getFileContentList(new File("/Users/MacBook/Documents/projects/java/lushiscript/src/utils/other/readme"));
        int addThis = 0;
        for (String str : p_配置文件) {
            if (null != str && !"".endsWith(str)) {
                switch (str.trim()) {
                    case "开始游戏相关":
                        addThis = 0;
                        continue;

                    case "图库地址":
                        //只是配置图片地址而已，不是图片种类的划分
                        addThis = 1;
                        continue;

                    case "图库图片":
                        addThis = 2;
                        continue;

                    case "起手留牌":
                        addThis = 3;
                        continue;

                    case "斩杀牌":
                        addThis = 4;
                        break;

                    case "需要解的牌":
                        addThis = 5;
                        break;

                    case "要留的解牌":
                        addThis = 6;
                        break;

                    case "效果拖动指向":
                        addThis = 7;
                        break;

                    case "效果磁力指向":
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
                                p_牌库列表.add(c_imagepath);
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
                                p_牌库列表.add(c_imagepath);
                                roleList.add(c_imagepath);
                            }
                        }
                        break;
                    case 3:
                        //起手留牌
                        saveImageNameList.add(str);
                        break;

                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    default:
                }


                C_日志.m_打印(str);

            }
        }
    }

    public static List<C_imagepath> m_磁盘图列表() {
        return p_牌库列表;
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
