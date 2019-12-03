package project.lushi.cardentities.cards.all.fashi

import findimage.BaseImageFind
import findimage.ErrorPoint
import project.lushi.cardentities.BaseCard
import project.lushi.enums.Attribute
import project.lushi.enums.CardLocationMode
import project.lushi.enums.Jobs
import project.lushi.enums.ZhanHongType
import project.lushi.findimageentities.findcardimage.FindAnJinJiaoShuiJinChiNv

/**
 * 法师卡:暗金教水晶侍女
 */
class Card6AnJinJiaoShuiJinShiNv(imageFind: BaseImageFind = FindAnJinJiaoShuiJinChiNv(), cardLocationMode: CardLocationMode = CardLocationMode.IN牌库, baseAtkNum: Int = 5, baseBloodNum: Int = 5, attribute: Attribute = Attribute.白板, pay: Int = 6, is嘲讽: Boolean = false, is磁力: Boolean = false, is吸血: Boolean = false, is冲锋: Boolean = false, is突袭: Boolean = false, is双生: Boolean = false, is发现: Boolean = false, is随从: Boolean = true)
    : BaseCard(imageFind = imageFind, jobs = Jobs.法师, canAtk = false, point = ErrorPoint, cardLocationMode = cardLocationMode, baseAtkNum = baseAtkNum, baseBloodNum = baseBloodNum, attribute = attribute, pay = pay, is嘲讽 = is嘲讽, is磁力 = is磁力, is吸血 = is吸血, is冲锋 = is冲锋, is突袭 = is突袭, is双生 = is双生, is发现 = is发现, is随从 = is随从) {

    override fun cardName() = "暗金教水晶侍女"

    override fun notifyHaveCardPlay(baseCard: BaseCard) {
        if (baseCard.is奥秘 && pay > 0) {
            pay -= 2
        }
    }

    override fun func() {

    }

    override fun onGetMe() {

    }

    override fun onDeath() {

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