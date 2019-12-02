package project.lushi.cardentities.cards.all.fashi

import findimage.BaseImageFind
import findimage.ErrorPoint
import project.lushi.GameManage
import project.lushi.cardentities.BaseCard
import project.lushi.enums.Attribute
import project.lushi.enums.CardLocationMode
import project.lushi.enums.Jobs

/**
 * 法师卡：暗金教侍从
 */
class Card1AnJinJiaoShiCong(imageFind: BaseImageFind, cardLocationMode: CardLocationMode = CardLocationMode.IN牌库, atkNum: Int = 2, bloodNum: Int = 1, attribute: Attribute = Attribute.白板, pay: Int = 1, is嘲讽: Boolean = false, is磁力: Boolean = false, is吸血: Boolean = false, is冲锋: Boolean = false, is突袭: Boolean = false, is双生: Boolean = false, is发现: Boolean = false, is随从: Boolean = true)
    : BaseCard(imageFind = imageFind, jobs = Jobs.法师, canAtk = false, point = ErrorPoint, cardLocationMode = cardLocationMode, baseAtkNum = atkNum, baseBloodNum = bloodNum, attribute = attribute, pay = pay, is嘲讽 = is嘲讽, is磁力 = is磁力, is吸血 = is吸血, is冲锋 = is冲锋, is突袭 = is突袭, is双生 = is双生, is发现 = is发现, is随从 = is随从) {
    override fun onDeath() {

    }

    override fun onGetMe() {

    }

    override fun notifyHaveCardPlay(baseCard: BaseCard) {
        if (funcOpen && baseCard.is奥秘) {
            for (card in GameManage.cardIn手牌) {
                if (card.is奥秘) {
                    //fixme 这里有一个bug，因为奥秘被暗金教侍从改成0费之前不一定都是3费
                    card.pay = 3
                }
            }
            funcOpen = false
        }
    }

    override fun func() {
        //将所有的手牌的奥秘消耗变成0点,然后在notifyHaveCardPlay方法变回来
        funcOpen = true
        for (card in GameManage.cardIn手牌) {
            if (card.is奥秘) {
                card.pay = 0
            }
        }
    }

    override fun onMyHuiHeEnd(cardLocationMode: CardLocationMode) {
        if (funcOpen) {
            //如果该卡已经打出去，但是funcToHaveUseAomi还是true，说明该卡效果没有用，则在回合开始时，重置效果
            for (card in GameManage.cardIn手牌) {
                if (card.is奥秘) {
                    //fixme 这里有一个bug，因为奥秘被暗金教侍从改成0费之前不一定都是3费
                    card.pay = 3
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