package ua.study.epam.equipment.defenceEquipment;

import ua.study.epam.equipment.materialForEquipment.Material;

/**
 * Created by dima on 11.02.17.
 */
public class Leggings extends DefenceEquipment {
    public Leggings(Material material, int weight, int price) {
        super(material, weight, price);
        this.setDefence(10);
        this.setName(this.getName() + "Leggings");
    }

    @Override
    public String toString() {
        return "leggings " + getName();
    }
}
