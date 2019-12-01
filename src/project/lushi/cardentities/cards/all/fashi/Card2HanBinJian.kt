package project.lushi.cardentities.cards.all.fashi

import findimage.ErrorPoint
import project.lushi.cardentities.BaseCard
import project.lushi.enums.Attribute
import project.lushi.enums.CardLocationMode
import project.lushi.enums.Jobs

/**
 * 法师卡：寒冰箭
 */
class Card2HanBinJian(cardLocationMode: CardLocationMode = CardLocationMode.IN牌库, atkNum: Int = 3, bloodNum: Int = 0, attribute: Attribute = Attribute.法术, pay: Int = 2, is嘲讽: Boolean = false, is磁力: Boolean = false, is吸血: Boolean = false, is冲锋: Boolean = false, is突袭: Boolean = false, is双生: Boolean = false, is发现: Boolean = false, is随从: Boolean = false)
    : BaseCard(jobs = Jobs.法师, canAtk = false, point = ErrorPoint, cardLocationMode = cardLocationMode, baseAtkNum = atkNum, baseBloodNum = bloodNum, attribute = attribute, pay = pay, is嘲讽 = is嘲讽, is磁力 = is磁力, is吸血 = is吸血, is冲锋 = is冲锋, is突袭 = is突袭, is双生 = is双生, is发现 = is发现, is随从 = is随从) {
    override fun onDeath() {

    }

    override fun onGetMe() {

    }

    override fun cardName() = "寒冰箭"

    override fun notifyHaveCardPlay(baseCard: BaseCard) {

    }

    override fun func() {

    }

    override fun onMyHuiHeEnd(cardLocationMode: CardLocationMode) {
    }

    override fun onMyHuiHeStart(cardLocationMode: CardLocationMode) {
    }

    override fun onEnemyHuiHeEnd(cardLocationMode: CardLocationMode) {
    }

    override fun onEnemyHuiHeStart(cardLocationMode: CardLocationMode) {
    }

}
