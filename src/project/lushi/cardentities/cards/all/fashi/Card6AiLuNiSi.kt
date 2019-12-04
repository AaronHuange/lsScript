package project.lushi.cardentities.cards.all.fashi

import findimage.BaseImageFind
import findimage.ErrorPoint
import project.lushi.GameManage
import project.lushi.cardentities.BaseCard
import project.lushi.enums.Attribute
import project.lushi.enums.CardLocationMode
import project.lushi.enums.Jobs
import project.lushi.findimageentities.findcardimage.FindAiLuNiSi

/**
 * 法师卡：艾露尼斯
 */
class Card6AiLuNiSi(imageFind: BaseImageFind = FindAiLuNiSi(), cardLocationMode: CardLocationMode = CardLocationMode.IN牌库, baseAtkNum: Int = 0, baseBloodNum: Int = 0, attribute: Attribute = Attribute.武器, pay: Int = 6, is嘲讽: Boolean = false, is磁力: Boolean = false, is吸血: Boolean = false, is冲锋: Boolean = false, is突袭: Boolean = false, is双生: Boolean = false, is发现: Boolean = false, is随从: Boolean = false, is奥秘: Boolean = false)
    : BaseCard(imageFind = imageFind, jobs = Jobs.法师, canAtk = false, point = ErrorPoint, cardLocationMode = cardLocationMode, baseAtkNum = baseAtkNum, baseBloodNum = baseBloodNum, attribute = attribute, pay = pay, is嘲讽 = is嘲讽, is磁力 = is磁力, is吸血 = is吸血, is冲锋 = is冲锋, is突袭 = is突袭, is双生 = is双生, is发现 = is发现, is随从 = is随从, is奥秘 = is奥秘) {
    override fun cardName() = "艾露尼斯"

    override fun notifyHaveCardPlay(baseCard: BaseCard) {
    }

    override fun func() {
    }

    override fun onGetMe() {
    }

    override fun onDeath() {
    }

    override fun onMyHuiHeEnd(cardLocationMode: CardLocationMode) {
        if (GameManage.isMeInZhanChang(this)) {
            GameManage.onGetCard(3) //如果我在战场上，则在回合结束时抽3张牌
        }
    }

    override fun onMyHuiHeStart(cardLocationMode: CardLocationMode) {
    }

    override fun onEnemyHuiHeEnd(cardLocationMode: CardLocationMode) {
    }

    override fun onEnemyHuiHeStart(cardLocationMode: CardLocationMode) {
    }

}