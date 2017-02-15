package ua.study.epam.equipment.defenceEquipment;

import ua.study.epam.equipment.materialForEquipment.Material;

/**
 * Created by dima on 11.02.17.
 */
public class Boots extends DefenceEquipment {
    public Boots(Material material, int weight, int price) {
        super(material, weight, price);
        this.setDefence(5);
        this.setName(this.getName() + "Boots");
    }

    @Override
    public String toString() {
        return "boots " + getName();
    }
}
