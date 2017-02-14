package ua.study.epam.forge;

import ua.study.epam.knight.Knight;

/**
 * Created by dima on 11.02.17.
 */

public interface Forge {
    boolean createFullKnightEquipment(Knight knight);

    boolean createStandardDagger(Knight knight);
    boolean createStandardSword(Knight knight);
    boolean createStandardBoots(Knight knight);
    boolean createStandardGloves(Knight knight);
    boolean createStandardHelmet(Knight knight);
    boolean createStandardLeggings(Knight knight);
    boolean createStandardMailArmor(Knight knight);
    boolean createStandardShield(Knight knight);
}