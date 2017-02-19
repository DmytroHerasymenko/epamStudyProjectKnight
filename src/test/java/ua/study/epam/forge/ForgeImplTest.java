package ua.study.epam.forge;

import org.junit.Test;
import ua.study.epam.equipment.Equipment;
import ua.study.epam.equipment.defenceequipment.*;
import ua.study.epam.equipment.material.Material;
import ua.study.epam.equipment.weapon.*;
import ua.study.epam.knight.gender.Gender;
import ua.study.epam.knight.Knight;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by dima on 12.02.17.
 */
public class ForgeImplTest {
    Knight knight = new Knight(Gender.MALE, "Petro", 25);
    Forge forge = ForgeImpl.instance();
    List<Equipment> equipment = new ArrayList<>();

    @Test
    public void createFullKnightEquipmentTest() throws Exception {
        forge.createFullKnightEquipment(knight);
        String [] arrayKnight = new String[8];
        int count = 0;
        for(Equipment e : knight.getEquipment()){
            arrayKnight[count] = e.getClass().getSimpleName();
            count++;
        }

        String[] arrayTest = new String[8];
        equipment.add(new Boots(Material.SKIN, 1, 100));
        equipment.add(new Gloves(Material.SKIN, 1, 100));
        equipment.add(new Helmet(Material.SKIN, 1, 100));
        equipment.add(new Leggings(Material.SKIN, 1, 100));
        equipment.add(new MailArmor(Material.SKIN, 1, 100));
        equipment.add(new Shield(Material.SKIN, 1, 10));
        equipment.add(new Sword (Material.IRON, 7, 150));
        equipment.add(new Dagger (Material.IRON, 7, 150));

        int testCount = 0;
        for(Equipment e : equipment){
            arrayTest[testCount] = e.getClass().getSimpleName();
            testCount++;
        }

        assertArrayEquals(arrayTest, arrayKnight);
    }

    @Test
    public void createFullKnightEquipmentNullTest() throws Exception {
        knight.setMoney(500);
        forge.createFullKnightEquipment(knight);
        assertEquals(equipment, knight.getEquipment());
    }
    @Test
    public void createFullKnightEquipmentMoneyTest() throws Exception {
        forge.createFullKnightEquipment(knight);
        assertEquals(20, knight.getMoney());
    }

    @Test
    public void createFullKnightEquipmentDamageTest() throws Exception {
        forge.createFullKnightEquipment(knight);
        assertEquals(80, knight.getDamage());
    }
    @Test
    public void createFullKnightEquipmentDefenceTest() throws Exception {
        forge.createFullKnightEquipment(knight);
        assertEquals(85, knight.getDefence());
    }

    @Test
    public void createStandardDaggerTest() throws Exception {
        forge.createStandardDagger(knight);
        assertEquals(Dagger.class.getSimpleName(), knight.getEquipment().get(0).getClass().getSimpleName());
    }
    @Test
    public void createStandardDaggerNullTest() throws Exception {
        knight.setMoney(20);
        forge.createStandardDagger(knight);
        assertEquals(equipment, knight.getEquipment());
    }

    @Test
    public void createStandardSwordTest() throws Exception {
        forge.createStandardSword(knight);
        equipment.add(new Sword(Material.IRON, 7, 150));
        assertEquals(Sword.class.getSimpleName(), knight.getEquipment().get(0).getClass().getSimpleName());
    }
    @Test
    public void createStandardSwordNullTest() throws Exception {
        knight.setMoney(20);
        forge.createStandardSword(knight);
        assertEquals(equipment, knight.getEquipment());
    }
    @Test
    public void createStandardBootsTest() throws Exception {
        forge.createStandardBoots(knight);
        equipment.add(new Boots(Material.SKIN, 1, 100));
        assertEquals(Boots.class.getSimpleName(), knight.getEquipment().get(0).getClass().getSimpleName());
    }
    @Test
    public void createStandardBootsNullTest() throws Exception {
        knight.setMoney(20);
        forge.createStandardBoots(knight);
        assertEquals(equipment, knight.getEquipment());
    }
    @Test
    public void createStandardGlovesTest() throws Exception {
        forge.createStandardGloves(knight);
        equipment.add(new Gloves(Material.SKIN, 1, 100));
        assertEquals(Gloves.class.getSimpleName(), knight.getEquipment().get(0).getClass().getSimpleName());
    }
    @Test
    public void createStandardGlovesNullTest() throws Exception {
        knight.setMoney(20);
        forge.createStandardGloves(knight);
        assertEquals(equipment, knight.getEquipment());
    }
    @Test
    public void createStandardHelmetTest() throws Exception {
        forge.createStandardHelmet(knight);
        equipment.add(new Helmet(Material.SKIN, 1, 100));
        assertEquals(Helmet.class.getSimpleName(), knight.getEquipment().get(0).getClass().getSimpleName());
    }
    @Test
    public void createStandardHelmetNullTest() throws Exception {
        knight.setMoney(20);
        forge.createStandardHelmet(knight);
        assertEquals(equipment, knight.getEquipment());
    }
    @Test
    public void createStandardLeggingsTest() throws Exception {
        forge.createStandardLeggings(knight);
        equipment.add(new Leggings(Material.SKIN, 1, 100));
        assertEquals(Leggings.class.getSimpleName(), knight.getEquipment().get(0).getClass().getSimpleName());
    }
    @Test
    public void createStandardLeggingsNullTest() throws Exception {
        knight.setMoney(20);
        forge.createStandardLeggings(knight);
        assertEquals(equipment, knight.getEquipment());
    }
    @Test
    public void createStandardMailArmorTest() throws Exception {
        forge.createStandardMailArmor(knight);
        equipment.add(new MailArmor(Material.SKIN, 1, 100));
        assertEquals(MailArmor.class.getSimpleName(), knight.getEquipment().get(0).getClass().getSimpleName());
    }
    @Test
    public void createStandardMailArmorNullTest() throws Exception {
        knight.setMoney(20);
        forge.createStandardMailArmor(knight);
        assertEquals(equipment, knight.getEquipment());
    }

    @Test
    public void createStandardShieldTest() throws Exception {
        forge.createStandardShield(knight);
        equipment.add(new Shield(Material.SKIN, 1, 100));
        assertEquals(Shield.class.getSimpleName(), knight.getEquipment().get(0).getClass().getSimpleName());
    }
    @Test
    public void createStandardShieldNullTest() throws Exception {
        knight.setMoney(20);
        forge.createStandardShield(knight);
        assertEquals(equipment, knight.getEquipment());
    }
}