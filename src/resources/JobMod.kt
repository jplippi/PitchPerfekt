package resources

import util.Table

object JobMod : Table<Job, JobMod.Modifier, Int>() {
    init {
        this[Job.BRD, Modifier.DEX] = 115
    }

    enum class Modifier {
        HP, MP, STR, VIT, DEX, INT, MND
    }
}