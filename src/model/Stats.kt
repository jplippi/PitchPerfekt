package model

import resources.Attribute

class Stats() {

    constructor(other: Stats) : this() {
        this + other
    }

    private var wd: Int = 0
    private var ap: Int = 0
    private var chr: Int = 0
    private var dhr: Int = 0
    private var det: Int = 0
    private var sks: Int = 0
    private var ten: Int = 0

    operator fun get(key: Attribute): Int {
        return when(key){
            Attribute.WeaponDamage -> wd
            Attribute.AttackPower -> ap
            Attribute.CriticalHitRate -> chr
            Attribute.DirectHitRate -> dhr
            Attribute.Determination -> det
            Attribute.SkillSpeed -> sks
            Attribute.Tenacity -> ten
        }
    }

    operator fun set(key: Attribute, value: Int) {
        when(key){
            Attribute.WeaponDamage -> wd = value
            Attribute.AttackPower -> ap = value
            Attribute.CriticalHitRate -> chr = value
            Attribute.DirectHitRate -> dhr = value
            Attribute.Determination -> det = value
            Attribute.SkillSpeed -> sks = value
            Attribute.Tenacity -> ten = value
        }
    }

    operator fun plus(other: Stats): Stats {
        this.wd += other.wd
        this.ap += other.ap
        this.chr += other.chr
        this.dhr += other.dhr
        this.det += other.det
        this.sks += other.sks
        this.ten += other.ten

        return this
    }

}