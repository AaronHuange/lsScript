package project.lushi.cardentities.cards.all.fashi

import findimage.BaseImageFind
import findimage.ErrorPoint
import project.lushi.GameManage
import project.lushi.cardentities.BaseCard
import project.lushi.enums.Attribute
import project.lushi.enums.CardLocationMode
import project.lushi.enums.Jobs
import project.lushi.enums.ZhanHongType
import project.lushi.findimageentities.findcardimage.FindMaiDiWenDeNanPu

/**
 * 法师卡：麦迪文的男仆
 */
class Card2MaiDiWenDeNanPu(imageFind: BaseImageFind = FindMaiDiWenDeNanPu(), cardLocationMode: CardLocationMode = CardLocationMode.IN牌库, baseAtkNum: Int = 2, baseBloodNum: Int = 3, attribute: Attribute = Attribute.白板, pay: Int = 2, is嘲讽: Boolean = false, is磁力: Boolean = false, is吸血: Boolean = false, is冲锋: Boolean = false, is突袭: Boolean = false, is双生: Boolean = false, is发现: Boolean = false, is随从: Boolean = true)
    : BaseCard(imageFind = imageFind, jobs = Jobs.法师, canAtk = false, point = ErrorPoint, cardLocationMode = cardLocationMode, baseAtkNum = baseAtkNum, baseBloodNum = baseBloodNum, attribute = attribute, pay = pay, is嘲讽 = is嘲讽, is磁力 = is磁力, is吸血 = is吸血, is冲锋 = is冲锋, is突袭 = is突袭, is双生 = is双生, is发现 = is发现, is随从 = is随从) {

    override fun cardName() = "麦迪文的男仆"

    override fun notifyHaveCardPlay(baseCard: BaseCard) {

    }

    //寒冰箭、奥术智慧、火球术
    override fun func() {
        if (GameManage.existMyAoMi()) {
            GameManage.onZhanHongTo(3, ZhanHongType.ATK_TO_SOME) //当我方有奥秘存在时，触发3点对敌方伤害
        }
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