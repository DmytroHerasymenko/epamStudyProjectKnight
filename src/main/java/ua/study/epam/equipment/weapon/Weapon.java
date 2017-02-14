package ua.study.epam.equipment.weapon;

import ua.study.epam.equipment.Equipment;
import ua.study.epam.equipment.materialForEquipment.Material;

/**
 * Created by dima on 11.02.17.
 */
public abstract class Weapon extends Equipment {
    private int damage;
    private int damageRange;

    public Weapon(Material material, int weight, int price) {
        super(material, weight, price);
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getDamageRange() {
        return damageRange;
    }

    public void setDamageRange(int damageRange) {
        this.damageRange = damageRange;
    }
}
