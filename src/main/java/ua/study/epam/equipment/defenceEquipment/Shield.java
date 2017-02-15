package ua.study.epam.equipment.defenceEquipment;

import ua.study.epam.equipment.materialForEquipment.Material;

/**
 * Created by dima on 11.02.17.
 */
public class Shield extends DefenceEquipment {
    private final int block;

    public Shield(Material material, int weight, int price) {
        super(material, weight, price);
        this.setDefence(20);
        this.block = 60;
        this.setName(this.getName() + "Shield");
    }

    public int getBlock() {
        return block;
    }

    @Override
    public String toString() {
        return "shield " + getName();
    }
}
