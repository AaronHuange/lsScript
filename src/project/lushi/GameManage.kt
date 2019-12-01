package project.lushi

import findimage.findmethodimpl.ImageFindRGBGrayValue
import findimage.isErrirPoint
import project.lushi.cardentities.BaseCard
import project.lushi.cardentities.cards.cardgroup.BaseCardGroup
import project.lushi.cardentities.cards.cardgroup.CardGroup_HanBinAoMiFa
import project.lushi.entities.EnvironmentBean
import project.lushi.enums.CardLocationMode
import project.lushi.enums.Environment
import project.lushi.enums.Jobs
import project.lushi.findimageentities.*
import tools.*
import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO


fun main(args: Array<String>) {
//    var screenImage = UtilImage.loadImage(UtilFile.getAssetsImagePath("screenstart.jpeg"))
//    var screenImage = UtilImage.loadImage(UtilFile.getAssetsImagePath("image.jpg"))
//    Thread {
//        Thread.sleep(3000)
//        screenImage = UtilScreenShot.getScreenShot()
//        val imageFindRGB = ImageFindRGBGrayValue(screenImage!!)
//        val point = imageFindRGB.findImagePoint(FindStartGame())
//        if (point.isErrirPoint()) {
//            UtilLogCat.d("未找到！！")
//        }
//        UtilFile.saveBuffedImageToAssetsImagePath(screenImage, "")
//    }.start()
    GameManage.exe(CardGroup_HanBinAoMiFa())
}

object GameManage {
    private var fileNum = 0
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

    private fun initHero() {
        myJob = Jobs.法师
        enemyJob = Jobs.战士
    }

    /**
     * 运行游戏分析，会新开子线程
     */
    private fun exeGame(callback: () -> Unit) {
        val environmentBean = getCurrenEnvironment()
        exeEnvironmentBeanParse(environmentBean, callback)
//        {
        //  UtilFile.saveBuffedImageToAssetsImagePath(environmentBean.screenImage, "screenimage${(++fileNum).toString()}")

//        }
    }


    /**
     * 当是选择游戏模式的时候
     */
    private fun onIsSelectMode(screenImage: BufferedImage, callback: () -> Unit) {
        //选择模式的操作会在exeHandler中实现
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
        //查找该环境的exeHandler中不会有任何操作
        //分析该做什么操作
        //判断当前几费判断手牌有几张
        //判断


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
     * 分析起始手牌
     */
    private fun parseQiShiShouPai(screenImage: BufferedImage) {
        UtilLogCat.d("分析起始手牌...")
        UtilLogCat.d("抽到的手牌有:")
        //查找起始抽到的牌
        for (card in cardIn牌库) {
            //遍历牌库的牌
            if (!ImageFindRGBGrayValue(screenImage).findImagePoint(card.imageFind).isErrirPoint()) {
                changeCardStatusArrayList(card, card.cardLocationMode, CardLocationMode.IN手牌)
                UtilLogCat.d(card.cardName())
            }
        }
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
            point = imageFindRGB.findImagePoint(FindQiShiShouPai()) //查找是否是开始游戏
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
                                point = imageFindRGB.findImagePoint(FindStartGame())//查找是否是起始手牌时
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
//                UtilLogCat.d("未知其他环境，进行下一次截屏分析...")
                callback()
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