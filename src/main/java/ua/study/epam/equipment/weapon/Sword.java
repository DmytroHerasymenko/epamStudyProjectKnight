package ua.study.epam.equipment.weapon;

import ua.study.epam.equipment.materialForEquipment.Material;

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
    @Override
    public boolean equals(Object o){
        if (o == null) return false;
        if (!(o instanceof Sword)) return false;
        return true;
    }
}
