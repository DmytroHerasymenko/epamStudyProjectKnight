package ua.study.epam.forge;

import ua.study.epam.equipment.defenceEquipment.*;
import ua.study.epam.equipment.materialForEquipment.Material;
import ua.study.epam.equipment.weapon.*;
import ua.study.epam.knight.Knight;

/**
 * Created by dima on 11.02.17.
 */

public class ForgeImpl implements Forge{

    private static Forge forgeImpl;

    private final int standardDaggerPrice = 100;
    private final int standardSwordPrice = 150;
    private final int standardBootsPrice = 30;
    private final int standardGlovesPrice = 30;
    private final int standardHelmetPrice = 70;
    private final int standardLeggingsPrice = 50;
    private final int standardMailArmorPrice = 150;
    private final int standardShieldPrice = 100;

    private ForgeImpl(){
    }
    public static Forge instance(){
        if (forgeImpl == null){
            forgeImpl = new ForgeImpl();
        }
        return forgeImpl;
    }

    public boolean createFullKnightEquipment(Knight knight) {
        int fullEquipmentPrice = standardDaggerPrice + standardSwordPrice + standardBootsPrice + standardGlovesPrice +
                standardHelmetPrice + standardLeggingsPrice + standardMailArmorPrice + standardShieldPrice;

        if(fullEquipmentPrice > knight.getMoney()) return false;

        createStandardBoots(knight);
        createStandardGloves(knight);
        createStandardHelmet(knight);
        createStandardLeggings(knight);
        createStandardMailArmor(knight);
        createStandardShield(knight);
        createStandardSword(knight);
        createStandardDagger(knight);

        return true;
    }

    public boolean createStandardDagger(Knight knight) {
        if( standardDaggerPrice > knight.getMoney()) return false;
        else {
            Dagger dagger = new Dagger(Material.IRON, 1, standardDaggerPrice);
            knight.setMoney(knight.getMoney() - dagger.getPrice());
            knight.getEquipment().add(dagger);
            knight.setDamage(dagger.getDamage());
            return true;
        }
    }

    public boolean createStandardSword(Knight knight) {
        if(standardSwordPrice > knight.getMoney()) return false;
        else {
            Sword sword = new Sword(Material.IRON, 3, standardSwordPrice);
            knight.setMoney(knight.getMoney() - sword.getPrice());
            knight.getEquipment().add(sword);
            knight.setDamage(sword.getDamage());
            return true;
        }
    }

    public boolean createStandardBoots(Knight knight) {
        if(standardBootsPrice > knight.getMoney()) return false;
        else {
            Boots boots = new Boots(Material.SKIN, 1, standardBootsPrice);
            knight.setMoney(knight.getMoney() - boots.getPrice());
            knight.getEquipment().add(boots);
            knight.setDefence(boots.getDefence());
            return true;
        }
    }

    public boolean createStandardGloves(Knight knight) {
        if(standardGlovesPrice > knight.getMoney()) return false;
        else {
            Gloves gloves = new Gloves(Material.SKIN, 1, standardGlovesPrice);
            knight.setMoney(knight.getMoney() - gloves.getPrice());
            knight.getEquipment().add(gloves);
            knight.setDefence(gloves.getDefence());
            return true;
        }
    }

    public boolean createStandardHelmet(Knight knight) {
        if(standardHelmetPrice > knight.getMoney()) return false;
        else {
            Helmet helmet = new Helmet(Material.IRON, 3, standardHelmetPrice);
            knight.setMoney(knight.getMoney() - helmet.getPrice());
            knight.getEquipment().add(helmet);
            knight.setDefence(helmet.getDefence());
            return true;
        }
    }

    public boolean createStandardLeggings(Knight knight) {
        if(standardLeggingsPrice > knight.getMoney()) return false;
        else {
            Leggings leggings = new Leggings(Material.SKIN, 1, standardLeggingsPrice);
            knight.setMoney(knight.getMoney() - leggings.getPrice());
            knight.getEquipment().add(leggings);
            knight.setDefence(leggings.getDefence());
            return true;
        }
    }

    public boolean createStandardMailArmor(Knight knight) {
        if(standardMailArmorPrice > knight.getMoney()) return false;
        else {
            MailArmor mailArmor = new MailArmor(Material.IRON, 10, standardMailArmorPrice);
            knight.setMoney(knight.getMoney() - mailArmor.getPrice());
            knight.getEquipment().add(mailArmor);
            knight.setDefence(mailArmor.getDefence());
            return true;
        }
    }

    public boolean createStandardShield(Knight knight) {
        if(standardShieldPrice > knight.getMoney()) return false;
        else {
            Shield shield = new Shield(Material.WOOD, 5, standardShieldPrice);
            knight.setMoney(knight.getMoney() - shield.getPrice());
            knight.getEquipment().add(shield);
            knight.setDefence(shield.getDefence());
            return true;
        }
    }
}
