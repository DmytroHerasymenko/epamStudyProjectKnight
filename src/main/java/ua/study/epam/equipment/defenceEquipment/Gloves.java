package ua.study.epam.equipment.defenceEquipment;

import ua.study.epam.equipment.materialForEquipment.Material;

/**
 * Created by dima on 11.02.17.
 */
public class Gloves extends DefenceEquipment {
    public Gloves(Material material, int weight, int price) {
        super(material, weight, price);
        this.setDefence(5);
        this.setName(this.getName() + "Gloves");
    }

    @Override
    public String toString() {
        return "gloves " + getName();
    }
}
