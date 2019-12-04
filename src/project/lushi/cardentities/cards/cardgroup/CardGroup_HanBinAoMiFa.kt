package project.lushi.cardentities.cards.cardgroup

import project.lushi.cardentities.BaseCard
import project.lushi.cardentities.cards.all.fashi.*

/**
 * 寒冰奥秘法卡组
 */
class CardGroup_HanBinAoMiFa() : BaseCardGroup() {
    override fun getCards(): ArrayList<BaseCard> {
        if (cards.size == 0) {
            cards.add(Card1BinQiangShu())
            cards.add(Card1BinQiangShu())
            cards.add(Card1AnJinJiaoShiCong())
            cards.add(Card2HanBinJian())
            cards.add(Card2HanBinJian())
            cards.add(Card2FengKuangKeXueJia())
            cards.add(Card2FengKuangKeXueJia())
            cards.add(Card2MiFaXueJia())
            cards.add(Card2MiFaXueJia())
            cards.add(Card2MaiDiWenDeNanPu())
            cards.add(Card2MaiDiWenDeNanPu())
            cards.add(Card3LaoJiuDeHuoBa())
            cards.add(Card3LaoJiuDeHuoBa())
            cards.add(Card3AoShuZhiHui())
            cards.add(Card3HanBinPingZhang())
            cards.add(Card3FaShuFanZhi())
            cards.add(Card3FaShuFanZhi())
            cards.add(Card3HuoYanJieJie())
            cards.add(Card3HuoYanJieJie())
            cards.add(Card3BaoZaFuWen())
            cards.add(Card3BaoZaFuWen())
            cards.add(Card3KenRuiTuoFaShi())
            cards.add(Card3KenRuiTuoFaShi())
            cards.add(Card4HuoQiuShu())
            cards.add(Card4HuoQiuShu())
            cards.add(Card5YunWuWangZi())
            cards.add(Card5YunWuWangZi())
            cards.add(Card6AnJinJiaoShuiJinShiNv())
            cards.add(Card6AnJinJiaoShuiJinShiNv())
            cards.add(Card6AiLuNiSi())
        }
        return cards
    }

    private val cards = ArrayList<BaseCard>()
}