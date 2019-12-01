package project.lushi.cardentities.cards.cardgroup

import project.lushi.cardentities.BaseCard

abstract class BaseCardGroup {
    abstract fun getCards(): ArrayList<BaseCard>

}