package resources

import util.Table

object LevelMod : Table<Int, LevelMod.Modifier, Int>() {
    init {
        this[80, Modifier.MAIN] = 340
        this[80, Modifier.SUB] = 380
        this[80, Modifier.DIV] = 3300
    }

    enum class Modifier {
        MP, MAIN, SUB, DIV, HP, ELMT, THREAT
    }
}