package ua.study.epam.equipment.weapon;

import ua.study.epam.equipment.material.Material;

/**
 * Created by dima on 11.02.17.
 */
public class Sword extends Weapon {
    public Sword(Material material, int weight, int price) {
        super(material, weight, price);
        this.setDamage(60);
        this.setDamageRange(4);
        this.setName(this.getName() + "Sword");
    }

    @Override
    public String toString() {
        return "sword " + getName();
    }
}
