package project.lushi

import findimage.*
import findimage.findmethodimpl.ImageFindRGBGrayValue
import findimage.findmethodimpl.PointFindliang亮点Point
import project.lushi.cardentities.BaseCard
import project.lushi.cardentities.cards.cardgroup.BaseCardGroup
import project.lushi.cardentities.cards.cardgroup.CardGroup_ALL
import project.lushi.cardentities.cards.cardgroup.CardGroup_HanBinAoMiFa
import project.lushi.entities.EnvironmentBean
import project.lushi.enums.*
import project.lushi.findimageentities.*
import tools.*
import java.awt.Point
import java.awt.image.BufferedImage

fun main(args: Array<String>) {
//    for (v in 0..100)
//        println(UtilSystem.getSystemImei())
    GameManage.exe(CardGroup_HanBinAoMiFa())
//    GameManage.exe(CardGroup_ALL())
}

object GameManage {
    val cardIn牌库 = ArrayList<BaseCard>()
    val cardIn战场 = ArrayList<BaseCard>()
    val cardIn墓地 = ArrayList<BaseCard>()
    val cardIn手牌 = ArrayList<BaseCard>()
    var myJob = Jobs.中立
    var enemyJob = Jobs.中立
    var baseCardGroup: BaseCardGroup? = null
    fun exe(baseCardGroup: BaseCardGroup) {
        UtilLogCat.d("开始运行脚本")
        //初始化牌库
        this.baseCardGroup = baseCardGroup
        Thread {
            while (true) {
                exeGame {
                    //真的需要callback吗????????
                }
            }
        }.start()
    }

    /**
     * 将卡组置入牌库
     */
    private fun initCard(baseCardGroup: BaseCardGroup) {
        cardIn牌库.clear()
        cardIn墓地.clear()
        cardIn战场.clear()
        cardIn手牌.clear()
        cardIn牌库.addAll(baseCardGroup.getCards())
    }

    /**
     * 初始化双方英雄(通过技能图标)
     */
    private fun initHero() {
        myJob = Jobs.法师
        enemyJob = Jobs.战士
    }

    private var fileNum = 0

    /**
     * 运行游戏分析，会新开子线程
     */
    private fun exeGame(callback: () -> Unit) {
        onIsStartGame(BufferedImage(1, 1, 1)) {}
        val environmentBean = getCurrenEnvironment()
//        exeEnvironmentBeanParse(environmentBean, callback)
        exeEnvironmentBeanParse(environmentBean) {
            // UtilFile.saveBuffedImageToAssetsImagePath(environmentBean.screenImage, "screenimage${(++fileNum).toString()}")
        }
    }


    /**
     * 当是选择游戏模式的时候
     */
    private fun onIsSelectMode(screenImage: BufferedImage, callback: () -> Unit) {
        //选择模式的操作会在exeHandler中实现,现在直接callback()就可 以了
        callback()
    }

    /**
     * 当是需要点击开始游戏按钮时
     */
    private fun onIsStartGame(screenImage: BufferedImage, callback: () -> Unit) {
        //点击开始游戏的操作会在exeHandler中实现
        myJob = Jobs.中立
        enemyJob = Jobs.中立
        initCard(baseCardGroup!!)
        callback()
    }

    /**
     * 当是敌方回合时
     */
    private fun onIsEnemyBout(screenImage: BufferedImage, callback: () -> Unit) {
        //查找该环境的exeHandler中不会有任何操作
        callback()
    }

    /**
     * 当是我的回合且未完成
     */
    private fun onIsMyContinueBout(screenImage: BufferedImage, callback: () -> Unit) {
        //1：先把嘲讽撞了
        //判断圣盾嘲讽
//        val
       // val shenDunChaoFeng = ImageFindRGBGrayValuePoint(screenImage).findImagePoint(FindChaoFengAndShenDun())


        //判断复生嘲讽

        //判断敌方嘲讽


        //寻找我方场上亮了的牌
        CardGroup_ALL.liang亮点
        var liangCard: Point //判断亮了的手牌
//        while (true) {
//            var liangCard = PointFindliang亮点Point(screenImage).setArea(AimImageAreaRate(0f, 0.5f, 0.95f, 0.65f)).findLiang亮点APoint()
//            if (liangCard.isErrirPoint()) {
//                break
//            }
//            print("point ${liangCard.x} ${liangCard.y}")
//            UtilMouse.moveTo(liangCard.x, liangCard.y)
//            UtilMouse.clickLeft()
//            UtilSystem.sleep(200)
//            UtilMouse.moveTo(liangCard.x, liangCard.y - screenImage.height / 3)
//            UtilSystem.sleep(200)
//            UtilMouse.clickLeft()
//        }

        //2：出手牌
        //判断亮了的手牌
        liangCard = PointFindliang亮点Point(screenImage).setArea(AimImageAreaRate(0f, 0.90f, 0.95f, 0.99f)).findLiang亮点APoint()
        if (!liangCard.isErrirPoint()) {
            print("point ${liangCard.x} ${liangCard.y}")
            UtilMouse.moveTo(liangCard.x, liangCard.y)
            UtilMouse.clickLeft()
            UtilSystem.sleep(200)
            UtilMouse.moveTo(liangCard.x, liangCard.y - screenImage.height / 3)
            UtilSystem.sleep(200)
            UtilMouse.clickLeft()
        }
        callback()
    }

    /**
     * 当是我的回合其应该点击完成回合
     */
    private fun onIsMyFinishBout(screenImage: BufferedImage, callback: () -> Unit) {
        //点击完成的操作的操作会在exeHandler中实现
        callback()
    }

    /**
     * 当游戏结束点击继续进行结算时
     */
    private fun onIsClickContiune(screenImage: BufferedImage, callback: () -> Unit) {
        //点击继续的操作的操作会在exeHandler中实现
        callback()
    }

    /**
     * 当选择起始手牌的场景时
     */
    private fun onIsQiShiShouPai(screenImage: BufferedImage, callback: () -> Unit) {
        parseQiShiShouPai(screenImage)
        callback()
    }

    /**
     * 其他不确定环境
     */
    private fun onIsOther(callback: () -> Unit) {
        callback()
    }

    /**
     * 分析起始手牌
     */
    private fun parseQiShiShouPai(screenImage: BufferedImage) {
//        UtilLogCat.d("分析起始手牌...")
//        UtilLogCat.d("抽到的手牌有:")
        //查找起始抽到的牌
//        var point = Point(0, 0)
//        val xx = cardIn牌库
//        for (card in cardIn牌库) {
//            //遍历牌库的牌，查找收到的手牌
//            point = ImageFindRGBGrayValuePoint(screenImage).findImagePoint(card.imageFind)
//            if (!point.isErrirPoint()) {
//                //changeCardStatusArrayList(card, card.cardLocationMode, CardLocationMode.IN手牌)
//                card.onGetMe()  //这个方法会做上面注释掉的步骤
//                //card.point = point
//                UtilLogCat.d(card.cardName() + "x:${point.x},y:${point.y}")
//            }
//        }
    }


    /**
     * 我是否在战场上
     */
    fun isMeInZhanChang(card: BaseCard): Boolean {

        return false
    }

    /**
     * 我方是否有未触发的奥秘
     */
    fun existMyAoMi(): Boolean {

        return false
    }

    /**
     * 敌方是否有未触发的奥秘
     */
    fun existEnemyAoMi(): Boolean {

        return false
    }

    /**
     * 当触发抽牌效果时
     * @param cardCount 抽的牌的个数
     */
    fun onGetCard(cardCount: Int) {
        var card: BaseCard? = null


        card!!.onGetMe()
    }

    /**
     * 当卡牌有战孔效果
     */
    fun onZhanHongTo(atkNum: Int, zhanHongType: ZhanHongType) {
        when (zhanHongType) {
            ZhanHongType.ATK_TO_SOME -> {

            }
            ZhanHongType.ATK_TO_ENEMY -> {

            }
            ZhanHongType.ATK_TO_MY -> {

            }
            ZhanHongType.ATK_TO_ALL_ENEMY_CARD -> {

            }
            ZhanHongType.ADD_BLOOD_TO_MY -> {

            }
            ZhanHongType.ADD_BLOOD_TO_ENEMY -> {

            }
        }
    }

    /**
     * 发表情
     */
    fun sendBiaoQing(biaoQing: BiaoQing, screenImage: BufferedImage) {
        val myHeroPoint = myHeroPoint(screenImage)
        UtilMouse.moveTo(myHeroPoint.x, myHeroPoint.y)
        UtilMouse.clickLeft()
        UtilSystem.sleep(200)
        when (biaoQing) {
            BiaoQing.GREETINGS -> {
                UtilMouse.moveTo(0, 0)
            }
            BiaoQing.OOPS -> {
                UtilMouse.moveTo(0, 0)
            }
            BiaoQing.THANKS -> {
                UtilMouse.moveTo(0, 0)
            }
            BiaoQing.THREATEN -> {
                UtilMouse.moveTo(0, 0)
            }
            BiaoQing.WELL_PLAYED -> {
                UtilMouse.moveTo(0, 0)
            }
            BiaoQing.WOW -> {
                UtilMouse.moveTo(0, 0)
            }
        }
        UtilSystem.sleep(200)
        UtilMouse.clickLeft()
        UtilMouse.moveTo(0, 0)
    }

    /**
     * 判断当前环境
     */
    fun getCurrenEnvironment(): EnvironmentBean {
        //  UtilMouse.moveTo(0, 0)//避免鼠标影响
        val screenImage = UtilScreenShot.getScreenShot()
//        val screenImage = UtilImage.loadImage(UtilFile.getAssetsImagePath("screenimagestartgame.jpg"))
        val imageFindRGB = ImageFindRGBGrayValue(screenImage!!)
        var point = imageFindRGB.findImagePoint(FindDuiZhanMoShi()) //查找是否是点击对战
        var result = Environment.SELECT_MODE
        if (point.isErrirPoint()) {
            point = imageFindRGB.findImagePoint(FindQiShiShouPai()) //查找是否是起始手牌时
            result = Environment.QI_SHI_SHOU_PAI
            if (point.isErrirPoint()) {
                point = imageFindRGB.findImagePoint(FindMyBoutContiune()) //查找是否是我的没结束回合
                result = Environment.MY_BOUT_CAN_TODO
                if (point.isErrirPoint()) {
                    point = imageFindRGB.findImagePoint(FindMyBoutFinish()) //查找是否是我的回合，且该结束了
                    result = Environment.MY_BOUT_FINISH
                    if (point.isErrirPoint()) {
                        point = imageFindRGB.findImagePoint(FindEnemyBout()) //查找是否是敌方回合
                        result = Environment.ENEMY_BOUT
                        if (point.isErrirPoint()) {
                            point = imageFindRGB.findImagePoint(FindClickToContiune(), true) //查找是否是点击继续
                            result = Environment.CLICK_TO_CONTINUE
                            if (point.isErrirPoint()) {
                                point = imageFindRGB.findImagePoint(FindStartGame()) //查找是否是开始游戏
                                result = Environment.START_GAME
                                if (point.isErrirPoint()) {
                                    result = Environment.OTHER //归纳为其他环境
                                }
                            }
                        }
                    }
                }
            }
        }
        return EnvironmentBean(result, screenImage)
    }

    /**
     * 运行环境分析过程
     */
    fun exeEnvironmentBeanParse(environmentBean: EnvironmentBean, callback: () -> Unit) {
        when (environmentBean.result) {
            Environment.SELECT_MODE -> {
                UtilLogCat.d("选择游戏模式中...")
                onIsSelectMode(environmentBean.screenImage, callback)
            }
            Environment.START_GAME -> {
                UtilLogCat.d("开始游戏")
                onIsStartGame(environmentBean.screenImage, callback)
            }
            Environment.MY_BOUT_CAN_TODO -> {
                UtilLogCat.d("我的回合且未完成")
                onIsMyContinueBout(environmentBean.screenImage, callback)
            }
            Environment.MY_BOUT_FINISH -> {
                UtilLogCat.d("我的回合已完成")
                onIsMyFinishBout(environmentBean.screenImage, callback)
            }
            Environment.ENEMY_BOUT -> {
                UtilLogCat.d("地方回合")
                onIsEnemyBout(environmentBean.screenImage, callback)
            }
            Environment.CLICK_TO_CONTINUE -> {
                UtilLogCat.d("游戏完成，点击继续游戏")
                onIsClickContiune(environmentBean.screenImage, callback)
            }
            Environment.QI_SHI_SHOU_PAI -> {
                UtilLogCat.d("显示其实手牌中...")
                onIsQiShiShouPai(environmentBean.screenImage, callback)
            }
            Environment.OTHER -> {
                onIsOther(callback)
            }
            Environment.QI_SHI_SHOU_PAI3 -> {

            }
            Environment.QI_SHI_SHOU_PAI4 -> {

            }
        }
    }

    fun changeCardStatusArrayList(card: BaseCard, oldCardLocationMode: CardLocationMode, cardLocationMode: CardLocationMode) {
        when (oldCardLocationMode) {
            CardLocationMode.IN手牌 -> {
                val card = findCardByNameInArray(card.cardName(), cardIn手牌)
                if (card != null) {
                    addCardToArrayByCardLocationMode(card, cardLocationMode)
                    cardIn手牌.remove(card)
                }
            }
            CardLocationMode.IN战场 -> {
                val card = findCardByNameInArray(card.cardName(), cardIn战场)
                if (card != null) {
                    addCardToArrayByCardLocationMode(card, cardLocationMode)
                    cardIn战场.remove(card)
                }
            }
            CardLocationMode.IN墓地 -> {
                val card = findCardByNameInArray(card.cardName(), cardIn墓地)
                if (card != null) {
                    addCardToArrayByCardLocationMode(card, cardLocationMode)
                    cardIn墓地.remove(card)
                }
            }
            CardLocationMode.IN牌库 -> {
                val card = findCardByNameInArray(card.cardName(), cardIn牌库)
                if (card != null) {
                    addCardToArrayByCardLocationMode(card, cardLocationMode)
                    cardIn牌库.remove(card)
                }
            }
            CardLocationMode.IN对方牌库 -> {

            }
            CardLocationMode.IN对方手牌 -> {

            }
        }

    }

    fun findCardByNameInArray(cardName: String, array: ArrayList<BaseCard>): BaseCard? {
        for (card in array) {
            if (card.cardName().equals(cardName)) {
                return card
            }
        }
        return null
    }

    fun addCardToArrayByCardLocationMode(card: BaseCard, cardLocationMode: CardLocationMode) {
        when (cardLocationMode) {
            CardLocationMode.IN手牌 -> {
                card.cardLocationMode = CardLocationMode.IN手牌
                cardIn手牌.add(card)
            }
            CardLocationMode.IN战场 -> {
                card.cardLocationMode = CardLocationMode.IN战场
                cardIn战场.add(card)
            }
            CardLocationMode.IN墓地 -> {
                card.cardLocationMode = CardLocationMode.IN墓地
                cardIn墓地.add(card)
            }
            CardLocationMode.IN牌库 -> {
                card.cardLocationMode = CardLocationMode.IN牌库
                cardIn牌库.add(card)
            }
            CardLocationMode.IN对方牌库 -> {

            }
            CardLocationMode.IN对方手牌 -> {

            }
        }
    }
}