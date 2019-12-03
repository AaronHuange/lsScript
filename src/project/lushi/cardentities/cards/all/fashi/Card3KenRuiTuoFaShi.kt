package project.lushi.cardentities.cards.all.fashi

import findimage.BaseImageFind
import findimage.ErrorPoint
import project.lushi.GameManage
import project.lushi.cardentities.BaseCard
import project.lushi.enums.Attribute
import project.lushi.enums.CardLocationMode
import project.lushi.enums.Jobs
import project.lushi.enums.ZhanHongType
import project.lushi.findimageentities.findcardimage.FindKenRuiTuoFaShi

class Card3KenRuiTuoFaShi(imageFind: BaseImageFind = FindKenRuiTuoFaShi(), cardLocationMode: CardLocationMode = CardLocationMode.IN牌库, baseAtkNum: Int = 4, baseBloodNum: Int = 3, attribute: Attribute = Attribute.白板, pay: Int = 3, is嘲讽: Boolean = false, is磁力: Boolean = false, is吸血: Boolean = false, is冲锋: Boolean = false, is突袭: Boolean = false, is双生: Boolean = false, is发现: Boolean = false, is随从: Boolean = true)
    : BaseCard(imageFind = imageFind, jobs = Jobs.法师, canAtk = false, point = ErrorPoint, cardLocationMode = cardLocationMode, baseAtkNum = baseAtkNum, baseBloodNum = baseBloodNum, attribute = attribute, pay = pay, is嘲讽 = is嘲讽, is磁力 = is磁力, is吸血 = is吸血, is冲锋 = is冲锋, is突袭 = is突袭, is双生 = is双生, is发现 = is发现, is随从 = is随从) {

    override fun cardName() = "肯瑞托法师"

    override fun notifyHaveCardPlay(baseCard: BaseCard) {
        if (funcOpen && baseCard.is奥秘) {
            for (card in GameManage.cardIn手牌) {
                if (card.is奥秘) {
                    card.pay = 3
                }
            }
            funcOpen = false
        }
    }

    override fun func() {
        funcOpen = true //功能开启
        for (card in GameManage.cardIn手牌) {
            if (card.is奥秘) {
                card.pay = 0;
            }
        }
    }

    override fun onGetMe() {
    }

    override fun onDeath() {
    }

    override fun onMyHuiHeEnd(cardLocationMode: CardLocationMode) {
        if (funcOpen) {
            for (card in GameManage.cardIn手牌) {
                if (card.is奥秘) {
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

}