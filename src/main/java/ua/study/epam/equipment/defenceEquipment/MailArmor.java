package ua.study.epam.equipment.defenceEquipment;

import ua.study.epam.equipment.materialForEquipment.Material;

/**
 * Created by dima on 11.02.17.
 */
public class MailArmor extends DefenceEquipment {
    public MailArmor(Material material, int weight, int price) {
        super(material, weight, price);
        this.setDefence(30);
        this.setName(this.getName() + "MailArmor");
    }

    @Override
    public String toString() {
        return "mail-armor " + getName();
    }
    @Override
    public boolean equals(Object o){
        if (o == null) return false;
        if (!(o instanceof MailArmor)) return false;
        return true;
    }
}
