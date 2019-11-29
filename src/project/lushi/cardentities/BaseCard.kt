package project.lushi.cardentities

import project.lushi.enums.Attribute
import project.lushi.enums.CardLocationMode
import project.lushi.enums.Jobs
import java.awt.Point

/**
 * 卡牌的基础父类
 */
abstract class BaseCard(atkNum: Int, bloodNum: Int, attribute: Attribute, is嘲讽: Boolean = false, is磁力: Boolean = false, is吸血: Boolean = false, is冲锋: Boolean, is突袭: Boolean, is双生: Boolean, is发现: Boolean) {
    /// 卡牌在什么地方，初始化时牌在牌库
    private var cardLocationMode: CardLocationMode
    /// 职业
    private var jobs: Jobs
    /// 卡牌的属性
    private var attribute: Attribute

    /// 卡牌的初始攻击力
    private var atkNum: Int
    /// 初始血量
    private var bloodNum: Int

    private var is嘲讽: Boolean

    private var is磁力: Boolean

    private var is吸血: Boolean

    private var is冲锋: Boolean

    private var is突袭: Boolean

    private var is双生: Boolean

    private var is发现: Boolean
    ///是否能进行攻击
    private var canAtk: Boolean
    ///卡牌位置
    private var point = Point(-1, -1)

    init {
        ///初始化所有牌在牌库
        cardLocationMode = CardLocationMode.IN牌库
        this.atkNum = atkNum
        this.bloodNum = bloodNum
        this.is嘲讽 = is嘲讽
        this.is磁力 = is磁力
        this.is吸血 = is吸血
        ///初始化应该是不能攻击的
        this.canAtk = false
        this.is冲锋 = is冲锋
        this.is突袭 = is突袭
        this.is双生 = is双生
        this.is发现 = is发现
        /// 所有卡牌默认为中立卡牌
        this.jobs = Jobs.中立
        /// 卡牌的属性
        this.attribute = attribute
    }

    /**
     * 得到卡牌名称
     */
    abstract fun cardName(): String

    /**
     * 当回合改变时
     */
    abstract fun onChange回合(cardLocationMode: CardLocationMode)

    private fun onChange回合() {
        when (cardLocationMode) {
            CardLocationMode.IN牌库 ->
                return
            CardLocationMode.IN墓地 ->
                return
            CardLocationMode.IN对方手牌 ->
                return
            CardLocationMode.IN战场 ->
                onChange回合(cardLocationMode)
            CardLocationMode.IN手牌 ->
                onChange回合(cardLocationMode)
            CardLocationMode.IN对方牌库 ->
                return
        }
    }

}