package project.lushi.cardentities.cards.cardgroup

import findimage.BitmapRGB
import project.lushi.cardentities.BaseCard

/**
 * 不规定卡组
 */
class CardGroup_ALL : BaseCardGroup() {
    private val cardGroup = ArrayList<BaseCard>()

    companion object {
        val liang亮点 = BitmapRGB(117, 255, 75)
        val liang亮点2 = BitmapRGB(110, 254, 58)
        val liang亮点3 = BitmapRGB(171, 249, 101)
        val liang亮点4 = BitmapRGB(73, 255, 43)
        val liang亮点5 = BitmapRGB(132, 246, 73)
        val liang亮点6 = BitmapRGB(90, 255, 50)
    }


    /**
     * 返回一个空卡组
     */
    override fun getCards(): ArrayList<BaseCard> {
        return cardGroup
    }
}