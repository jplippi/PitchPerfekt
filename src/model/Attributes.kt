package model

class Attributes {

    private var ap: Int = 0
    private var chr: Int = 0
    private var dhr: Int = 0
    private var det: Int = 0
    private var sks: Int = 0

    operator fun get(key: Type): Int {
        return when(key){
            Type.AttackPower -> ap
            Type.CriticalHitRate -> chr
            Type.DirectHitRate -> dhr
            Type.Determination -> det
            Type.SkillSpeed -> sks
        }
    }

    operator fun set(key: Type, value: Int) {
        when(key){
            Type.AttackPower -> ap = value
            Type.CriticalHitRate -> chr = value
            Type.DirectHitRate -> dhr = value
            Type.Determination -> det = value
            Type.SkillSpeed -> sks = value
        }
    }

    enum class Type {
        AttackPower, CriticalHitRate, DirectHitRate, Determination, SkillSpeed
    }
}