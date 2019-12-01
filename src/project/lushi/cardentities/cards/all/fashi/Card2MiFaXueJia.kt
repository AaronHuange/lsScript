package project.lushi.cardentities.cards.all.fashi

import project.lushi.cardentities.BaseCard
import project.lushi.enums.Attribute
import project.lushi.enums.CardLocationMode
import project.lushi.enums.Jobs
import tools.UtilLogCat

/**
 * 法师卡：秘法学家
 */
class Card2MiFaXueJia(baseAtkNum: Int = 2, baseBloodNum: Int = 3, attribute: Attribute = Attribute.白板, pay: Int = 2, is随从: Boolean = true)
    : BaseCard(jobs = Jobs.法师, canAtk = false, baseAtkNum = baseAtkNum, baseBloodNum = baseBloodNum, attribute = attribute, pay = pay, is随从 = is随从) {
    override fun onDeath() {

    }

    override fun cardName() = "秘法学家"

    override fun notifyHaveCardPlay(baseCard: BaseCard) {

    }

    override fun func() {
        //TODO
        UtilLogCat.todo("截屏检查是否有抽到牌?抽的牌是哪一张奥秘牌?并加入到手牌中a")
    }

    override fun onGetMe() {
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