package ThMod.cards.Marisa

import ThMod.action.DarkSparkAction
import ThMod.patches.AbstractCardEnum
import ThMod.patches.CardTagEnum
import basemod.abstracts.CustomCard
import com.megacrit.cardcrawl.cards.AbstractCard
import com.megacrit.cardcrawl.characters.AbstractPlayer
import com.megacrit.cardcrawl.core.CardCrawlGame
import com.megacrit.cardcrawl.monsters.AbstractMonster

class DarkSpark : CustomCard(
    ID,
    NAME,
    IMG_PATH,
    COST,
    DESCRIPTION,
    CardType.ATTACK,
    AbstractCardEnum.MARISA_COLOR,
    CardRarity.UNCOMMON,
    CardTarget.ALL_ENEMY
) {
    init {
        tags.add(CardTagEnum.SPARK)
        baseDamage = ATK_DMG
        isMultiDamage = true
        baseMagicNumber = EXHAUST_COUNT
        magicNumber = baseMagicNumber
    }

    override fun use(p: AbstractPlayer, m: AbstractMonster) {
        /*
    AbstractDungeon.actionManager.addToBottom(
        new ExhaustAllNonAttackAction()
    );
    */
        /*
    AbstractDungeon.actionManager.addToBottom(
        new DamageAllEnemiesAction(
            p,
            this.multiDamage,
            this.damageTypeForTurn,
            AbstractGameAction.AttackEffect.NONE
        )
    );
    AbstractDungeon.actionManager.addToBottom(
        new DamageAllEnemiesAction(
            p,
            this.multiDamage,
            this.damageTypeForTurn,
            AbstractGameAction.AttackEffect.NONE
        )
    );*/
        for (i in 0 until magicNumber) {
            addToBot(DarkSparkAction(multiDamage, damageType))
        }
    }

    override fun makeCopy(): AbstractCard {
        return DarkSpark()
    }

    override fun upgrade() {
        //upgradeDamage(UPG_DMG);
        upgradeName()
        upgradeMagicNumber(COUNT_UPG)
        upgraded = true
        initializeDescription()
    }

    companion object {
        const val ID = "DarkSpark"
        private val cardStrings = CardCrawlGame.languagePack.getCardStrings(ID)
        val NAME = cardStrings.NAME
        val DESCRIPTION = cardStrings.DESCRIPTION
        const val IMG_PATH = "img/cards/darkSpark.png"
        private const val COST = 2
        private const val ATK_DMG = 7

        //private static final int UPG_DMG = 3;
        private const val EXHAUST_COUNT = 5
        private const val COUNT_UPG = 3
    }
}