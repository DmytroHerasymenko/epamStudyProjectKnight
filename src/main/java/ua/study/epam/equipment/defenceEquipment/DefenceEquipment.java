package ua.study.epam.equipment.defenceEquipment;

import ua.study.epam.equipment.Equipment;
import ua.study.epam.equipment.materialForEquipment.Material;

/**
 * Created by dima on 11.02.17.
 */
public abstract class DefenceEquipment extends Equipment {
    private int defence;

    public DefenceEquipment(Material material, int weight, int price) {
        super(material, weight, price);
    }

    public int getDefence() {
        return defence;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

}
