package ThMod.cards.Marisa

import ThMod.action.MagicChantAction
import ThMod.patches.AbstractCardEnum
import basemod.abstracts.CustomCard
import com.megacrit.cardcrawl.cards.AbstractCard
import com.megacrit.cardcrawl.characters.AbstractPlayer
import com.megacrit.cardcrawl.core.CardCrawlGame
import com.megacrit.cardcrawl.dungeons.AbstractDungeon
import com.megacrit.cardcrawl.monsters.AbstractMonster

class MagicChant : CustomCard(
    ID, NAME, IMG_PATH,
    COST, DESCRIPTION,
    CardType.SKILL,
    AbstractCardEnum.MARISA_COLOR,
    CardRarity.UNCOMMON,
    CardTarget.SELF
) {
    //private static final int UPG_RTN = 1;
    init {
        baseMagicNumber = RTN
        magicNumber = baseMagicNumber
        exhaust = true
    }

    override fun use(p: AbstractPlayer, m: AbstractMonster) {
        AbstractDungeon.actionManager.addToBottom(
            MagicChantAction()
        )
    }

    override fun makeCopy(): AbstractCard {
        return MagicChant()
    }

    override fun upgrade() {
        if (!upgraded) {
            upgradeName()
            //this.exhaust = false;
            upgradeBaseCost(COST_UPG)
            //upgradeMagicNumber(UPG_RTN);
            //this.rawDescription = DESCRIPTION_UPG;
            //initializeDescription();
        }
    }

    companion object {
        const val ID = "MagicChant"
        const val IMG_PATH = "img/cards/Chant.png"
        private val cardStrings = CardCrawlGame.languagePack.getCardStrings(ID)
        val NAME = cardStrings.NAME
        val DESCRIPTION = cardStrings.DESCRIPTION

        //        private val DESCRIPTION_UPG = cardStrings.UPGRADE_DESCRIPTION
        private const val COST = 1
        private const val COST_UPG = 0
        private const val RTN = 2
    }
}