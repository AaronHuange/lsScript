package project.lushi.cardentities

import findimage.BaseImageFind
import findimage.ErrorPoint
import project.lushi.GameManage
import project.lushi.enums.Attribute
import project.lushi.enums.CardLocationMode
import project.lushi.enums.Jobs
import tools.UtilLogCat
import java.awt.Point

/**
 * 卡牌的基础父类
 *
 * 抽到牌时调用baseOnGetMe()方法，统一将牌变为手牌，回调onGetMe()方法
 * 出牌时调用func()方法，然后将法术牌变为墓地，随从牌变为战场
 * 当死亡时改变我墓地，并调用onDeath()方法
 * 当我的回合开始时调用onMyHuiHeStart()方法，将战场的攻击力大于0的随从变为可攻击状态
 *
 */
abstract class BaseCard(imageFind: BaseImageFind, jobs: Jobs, canAtk: Boolean, point: Point = ErrorPoint, cardLocationMode: CardLocationMode = CardLocationMode.IN牌库, baseAtkNum: Int, baseBloodNum: Int, attribute: Attribute, pay: Int = 10, is嘲讽: Boolean = false, is磁力: Boolean = false, is吸血: Boolean = false, is冲锋: Boolean = false, is突袭: Boolean = false, is双生: Boolean = false, is发现: Boolean = false, is随从: Boolean = false, is奥秘: Boolean = false) {
    val imageFind: BaseImageFind

    /// 卡牌在什么地方，初始化时牌在牌库
    var cardLocationMode: CardLocationMode
    /// 职业
    var jobs: Jobs
    /// 卡牌的属性
    var attribute: Attribute

    /// 该卡打出的功能是否开始，一切改变都要自己控制 TODO
    var funcOpen = false

    /// 卡牌的初始攻击力
    var baseAtkNum: Int
    /// 初始血量
    var baseBloodNum: Int
    /// 卡牌的初始攻击力
    var addAtkNum: Int = 0
    /// 初始血量
    var addBloodNum: Int = 0

    var is嘲讽: Boolean

    var is磁力: Boolean

    var is吸血: Boolean

    var is冲锋: Boolean

    var is突袭: Boolean

    var is双生: Boolean

    var is发现: Boolean

    val is随从: Boolean

    /// 费用
    var pay: Int

    var is奥秘: Boolean

    ///是否能进行攻击
    var canAtk: Boolean
    ///卡牌位置
    var point: Point

    init {
        ///初始化所有牌在牌库
        this.cardLocationMode = cardLocationMode
        this.baseAtkNum = baseAtkNum
        this.baseBloodNum = baseBloodNum
        this.is嘲讽 = is嘲讽
        this.is磁力 = is磁力
        this.is吸血 = is吸血
        ///初始化应该是不能攻击的
        this.canAtk = canAtk
        this.is冲锋 = is冲锋
        this.is突袭 = is突袭
        this.is双生 = is双生
        this.is发现 = is发现
        /// 所有卡牌默认为中立卡牌
        this.jobs = jobs
        /// 卡牌的属性
        this.attribute = attribute
        this.is随从 = is随从
        this.pay = pay
        this.point = point
        this.is奥秘 = is奥秘
        this.imageFind = imageFind
    }

    /**
     * 得到卡牌名称
     */
    abstract fun cardName(): String

    /**
     * 当我方有牌被打出时会被通知,有该卡打出
     */
    abstract fun notifyHaveCardPlay(baseCard: BaseCard)

    /**
     * 出牌的特效
     */
    abstract fun func()

    /**
     * 当有抽到该牌
     */
    abstract fun onGetMe()

    /**
     * 当有抽到该牌的基础实现
     */
    fun baseOnGetMe() {
        UtilLogCat.todo("GameManage 记得在我抽到时调用我！")
        onGetMe()
        GameManage.changeCardStatusArrayList(this, cardLocationMode, CardLocationMode.IN手牌)
    }

    /**
     * 当死亡时
     */
    abstract fun onDeath()

    /**
     * 当死亡时的统一处理
     */
    fun baseOnDeath() {
        UtilLogCat.todo("GameManage 记得在我死亡时或者法术施放后调用我！！")
        onDeath()
        GameManage.changeCardStatusArrayList(this, cardLocationMode, CardLocationMode.IN墓地)

    }

    /**
     * 打出该牌时被调用 TODO
     */
    fun toPlay(notifyCard: ArrayList<BaseCard>) {
        UtilLogCat.todo("GameManage 记得在我打出时调用我！")
        func()
        if (attribute == Attribute.法术) {
            GameManage.changeCardStatusArrayList(this, cardLocationMode, CardLocationMode.IN墓地)
        } else {
            GameManage.changeCardStatusArrayList(this, cardLocationMode, CardLocationMode.IN战场)
        }
        for (card in notifyCard) {
            card.notifyHaveCardPlay(this)
        }
    }

    /**
     * 当我的回合结束时
     */
    abstract fun onMyHuiHeEnd(cardLocationMode: CardLocationMode)

    /**
     * 当我的回合开始时
     */
    abstract fun onMyHuiHeStart(cardLocationMode: CardLocationMode)

    /**
     * 当对方回合结束时
     */
    abstract fun onEnemyHuiHeEnd(cardLocationMode: CardLocationMode)

    /**
     * 当对方回合开始时
     */
    abstract fun onEnemyHuiHeStart(cardLocationMode: CardLocationMode)


    /**
     * 当我的回合开始时的统一处理
     */
    fun onMyHuiHeStart() {
        UtilLogCat.todo("GameManage 记得在我和我的伙伴执行完前截图检查数据是否正确！")
        UtilLogCat.todo("GameManage 记得在我的回合开始时调用我！")

        when (cardLocationMode) {
            CardLocationMode.IN牌库 ->
                return
            CardLocationMode.IN墓地 ->
                return
            CardLocationMode.IN对方手牌 ->
                return
            CardLocationMode.IN战场 -> {
                if (is随从 && (baseAtkNum + addAtkNum) > 0) {
                    // 如果是随从而且攻击力大于0则获得攻击能力
                    canAtk = true
                }
                onMyHuiHeStart(cardLocationMode)
            }
            CardLocationMode.IN手牌 ->
                onMyHuiHeStart(cardLocationMode)
            CardLocationMode.IN对方牌库 ->
                return
        }
    }


    /**
     * 当我的回合结束时的统一处理
     */
    fun onMyHuiHeEnd() {
        UtilLogCat.todo("GameManage 记得在我的回合结束时调用我！")
        onMyHuiHeEnd(cardLocationMode)
        UtilLogCat.todo("GameManage 记得在我和我的伙伴执行完后截图检查数据是否正确！")
    }

    /**
     * 当敌人的回合开始时的统一处理
     */
    fun onEnemyHuiHeStart() {
        UtilLogCat.todo("GameManage 记得在敌人回合开始时调用我！")

    }

    /**
     * 当敌人的回合结束时的统一处理
     */
    fun onEnemyHuiHeEnd() {
        UtilLogCat.todo("GameManage 记得在敌人回合结束时调用我！")

    }

}