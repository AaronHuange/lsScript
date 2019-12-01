package project.lushi.enums

import findimage.ErrorPoint
import java.awt.Point

enum class Environment(point: Point) {
    SELECT_MODE(Point(0, 0)), //选择游戏模式
    START_GAME(Point(0, 0)), //游戏未开始，有开始按钮可以点击
    QI_SHI_SHOU_PAI(Point(0, 0)),//选择起始手牌时
    QI_SHI_SHOU_PAI3(Point(0, 0)),//选择起始手牌时(3张时)
    QI_SHI_SHOU_PAI4(Point(0, 0)),//选择起始手牌时(4张时)
    MY_BOUT_CAN_TODO(Point(0, 0)), //我的回合且未完成
    MY_BOUT_FINISH(Point(0, 0)),//我的回合且完成(可以点击结束回合按钮了)
    ENEMY_BOUT(Point(0, 0)),//敌人回合
    CLICK_TO_CONTINUE(Point(0, 0)), //胜负已出，点击继续
    OTHER(ErrorPoint) //其他未知游戏环境状态
}