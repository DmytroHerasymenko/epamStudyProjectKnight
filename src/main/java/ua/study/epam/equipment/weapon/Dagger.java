package ua.study.epam.equipment.weapon;

import ua.study.epam.equipment.materialForEquipment.Material;

/**
 * Created by dima on 11.02.17.
 */
public class Dagger extends Weapon {
    public Dagger(Material material, int weight, int price) {
        super(material, weight, price);
        this.setDamage(20);
        this.setDamageRange(2);
        this.setName(this.getName() + "Dagger");
    }

    @Override
    public String toString() {
        return "dagger " + getName();
    }
}
