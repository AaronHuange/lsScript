package project.lushi.cardentities.cards.all.fashi

import findimage.BaseImageFind
import findimage.ErrorPoint
import project.lushi.GameManage
import project.lushi.cardentities.BaseCard
import project.lushi.enums.Attribute
import project.lushi.enums.CardLocationMode
import project.lushi.enums.Jobs

/**
 * 法师卡:元素唤醒
 */
class Card0Yuansuhuanxing(imageFind: BaseImageFind, cardLocationMode: CardLocationMode = CardLocationMode.IN牌库, baseAtkNum: Int = 0, baseBloodNum: Int = 0, attribute: Attribute = Attribute.法术, pay: Int = 0, is嘲讽: Boolean = false, is磁力: Boolean = false, is吸血: Boolean = false, is冲锋: Boolean = false, is突袭: Boolean = false, is双生: Boolean = false, is发现: Boolean = false, is随从: Boolean = false)
    : BaseCard(imageFind = imageFind, jobs = Jobs.法师, canAtk = false, point = ErrorPoint, cardLocationMode = cardLocationMode, baseAtkNum = baseAtkNum, baseBloodNum = baseBloodNum, attribute = attribute, pay = pay, is嘲讽 = is嘲讽, is磁力 = is磁力, is吸血 = is吸血, is冲锋 = is冲锋, is突袭 = is突袭, is双生 = is双生, is发现 = is发现, is随从 = is随从) {
    override fun onDeath() {

    }

    override fun onGetMe() {

    }

    override fun notifyHaveCardPlay(baseCard: BaseCard) {
        if (funcOpen && baseCard.attribute == Attribute.元素) {
            for (card in GameManage.cardIn手牌) {
                if (card.attribute == Attribute.元素) {
                    card.pay += 2
                }
            }
            funcOpen = false
        }
    }

    override fun func() {
        funcOpen = true //功能开启
        for (card in GameManage.cardIn手牌) {
            if (card.attribute == Attribute.元素) {
                card.pay -= 2
            }
        }
    }

    override fun onMyHuiHeEnd(cardLocationMode: CardLocationMode) {
        if (funcOpen) {
            for (card in GameManage.cardIn手牌) {
                if (card.attribute == Attribute.元素) {
                    card.pay += 2
                }
            }
            funcOpen = false
        }
    }

    override fun onMyHuiHeStart(cardLocationMode: CardLocationMode) {
    }

    override fun onEnemyHuiHeEnd(cardLocationMode: CardLocationMode) {
    }

    override fun onEnemyHuiHeStart(cardLocationMode: CardLocationMode) {
    }

    override fun cardName() = "元素唤醒"

}