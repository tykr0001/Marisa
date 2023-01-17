package marisa.cards

import basemod.abstracts.CustomCard
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction
import com.megacrit.cardcrawl.actions.common.GainEnergyAction
import com.megacrit.cardcrawl.cards.AbstractCard
import com.megacrit.cardcrawl.characters.AbstractPlayer
import com.megacrit.cardcrawl.core.CardCrawlGame
import com.megacrit.cardcrawl.monsters.AbstractMonster
import marisa.patches.AbstractCardEnum
import marisa.powers.Marisa.ChargeUpPower

class UltraShortWave : CustomCard(
    ID,
    NAME,
    IMG_PATH,
    COST,
    DESCRIPTION,
    CardType.SKILL,
    AbstractCardEnum.MARISA_COLOR,
    CardRarity.RARE,
    CardTarget.SELF
) {
    init {
        baseBlock = BASE_ENERGY
        block = baseBlock

        baseMagicNumber = BASE_CHARGE
        magicNumber = baseMagicNumber

        baseDamage = BASE_CHARGE_GROWTH
        damage = baseDamage
    }

    private val energy by ::block
    private val increaseEnergy = ::upgradeBlock

    private val charge by ::magicNumber
    private val increaseCharge = ::upgradeMagicNumber

    private val chargeGrowth by ::damage
    private val increaseChargeGrowth = ::upgradeDamage

    override fun applyPowers() {}
    override fun calculateCardDamage(unused: AbstractMonster?) {}
    override fun use(p: AbstractPlayer, unused: AbstractMonster?) {
        addToBot(GainEnergyAction(energy))
        increaseEnergy(1)

        addToBot(ApplyPowerAction(p, p, ChargeUpPower(p, charge)))
        increaseCharge(chargeGrowth)
    }

    override fun makeCopy(): AbstractCard = UltraShortWave()

    override fun upgrade() {
        if (!upgraded) {
            upgradeName()
            increaseChargeGrowth(GAIN_CHARGE_GROWTH)
        }
    }

    companion object {
        const val ID = "UltimateShortwave"
        const val IMG_PATH = "img/cards/ShortWave.png"
        private val cardStrings = CardCrawlGame.languagePack.getCardStrings(ID)
        val NAME = cardStrings.NAME
        val DESCRIPTION = cardStrings.DESCRIPTION
        private const val COST = 1
        private const val BASE_CHARGE = 1
        private const val BASE_CHARGE_GROWTH = 1
        private const val GAIN_CHARGE_GROWTH = 1
        private const val BASE_ENERGY = 1
    }
}
