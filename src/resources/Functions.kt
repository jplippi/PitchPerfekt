package resources

import model.Stats
import java.util.*

object Functions {
    private val random = Random()

    private fun potMod(potency: Int): Double {
        return potency/100.0
    }

    private fun wdMod(wd: Int): Double {
        return Math.floor((LevelMod[80,LevelMod.Modifier.MAIN] * JobMod[Job.BRD,JobMod.Modifier.DEX]/ 1000.0) + wd)
    }

    private fun apMod(ap: Int): Double {
        return Math.floor((125 * (ap - LevelMod[80,LevelMod.Modifier.MAIN]) / LevelMod[80,LevelMod.Modifier.MAIN].toDouble()) + 100) / 100.0
    }

    private fun detMod(det: Int): Double {
        return Math.floor(130 * (det - LevelMod[80, LevelMod.Modifier.MAIN])/LevelMod[80, LevelMod.Modifier.DIV].toDouble() + 1000) / 1000.0
    }

    private fun tenMod(ten: Int): Double {
        return Math.floor(100 * (ten - LevelMod[80, LevelMod.Modifier.SUB])/LevelMod[80, LevelMod.Modifier.DIV].toDouble() + 1000) / 1000.0
    }

    private fun ssMod(ss: Int): Double {
        return Math.floor(130 * (ss - LevelMod[80, LevelMod.Modifier.SUB])/LevelMod[80, LevelMod.Modifier.DIV].toDouble() + 1000) / 1000.0
    }

    private fun chrMod(chr: Int): Double {
        return Math.floor(200 * (chr - LevelMod[80, LevelMod.Modifier.SUB])/LevelMod[80, LevelMod.Modifier.DIV].toDouble() + 1400) / 1000.0
    }

    private fun aaMod(wd: Int, delay: Double): Double {
        return Math.floor(Math.floor((LevelMod[80,LevelMod.Modifier.MAIN] * JobMod[Job.BRD,JobMod.Modifier.DEX] / 1000.0) + wd) * (delay / 3))
    }

    private fun chProb(chr: Int): Double {
        return Math.floor(200 * (chr - LevelMod[80, LevelMod.Modifier.SUB]) / LevelMod[80, LevelMod.Modifier.DIV].toDouble() + 50) / 1000
    }

    private fun dhProb(dhr: Int): Double {
        return Math.floor(550 * (dhr - LevelMod[80, LevelMod.Modifier.SUB]) / LevelMod[80, LevelMod.Modifier.DIV].toDouble()) / 1000
    }

    fun directDamage(potency: Int, stats: Stats): Int {
        val chrMod = if (random.nextDouble() < chProb(stats[Attribute.CriticalHitRate])) chrMod(stats[Attribute.CriticalHitRate]) else 1.0
        val dhrMod = if (random.nextDouble() < dhProb(stats[Attribute.DirectHitRate])) 1.25 else 1.0

        val firstPartial = Math.floor(Math.floor(Math.floor(potMod(potency) * wdMod(stats[Attribute.WeaponDamage]) * apMod(stats[Attribute.AttackPower]) * detMod(stats[Attribute.Determination]) * tenMod(stats[Attribute.Tenacity]) * 1.2) * chrMod) * dhrMod).toInt()

        val secondPartial = random.ints((firstPartial*0.95).toInt(), (firstPartial*1.05).toInt() + 1)


    }
}