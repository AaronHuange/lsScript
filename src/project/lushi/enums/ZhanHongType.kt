package project.lushi.enums

/**
 * 战kong触发的效果
 */
enum class ZhanHongType {
    ATK_TO_SOME,  //对任何造成伤害
    ATK_TO_ENEMY, //对敌方造成伤害
    ATK_TO_MY, //对我方造成伤害
    ATK_TO_ALL_ENEMY_CARD, //对敌方所有随从造成伤害
    ADD_BLOOD_TO_MY,
    ADD_BLOOD_TO_ENEMY
}