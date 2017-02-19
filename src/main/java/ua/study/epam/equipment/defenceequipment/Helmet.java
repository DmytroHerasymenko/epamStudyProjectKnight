package ua.study.epam.equipment.defenceequipment;

import ua.study.epam.equipment.material.Material;

/**
 * Created by dima on 11.02.17.
 */
public class Helmet extends DefenceEquipment {
    public Helmet(Material material, int weight, int price) {
        super(material, weight, price);
        this.setDefence(15);
        this.setName(this.getName() + "Helmet");
    }

    @Override
    public String toString() {
        return "helmet " + getName();
    }
}
