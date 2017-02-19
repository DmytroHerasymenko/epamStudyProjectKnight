package ua.study.epam.knight;

import org.junit.Test;
import ua.study.epam.equipment.Equipment;
import ua.study.epam.equipment.defenceequipment.*;
import ua.study.epam.equipment.material.Material;
import ua.study.epam.forge.Forge;
import ua.study.epam.forge.ForgeImpl;
import ua.study.epam.knight.gender.Gender;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by dima on 12.02.17.
 */
public class KnightTest {
    Knight knight = new Knight(Gender.MALE, "Petro", 30);
    Forge forge = ForgeImpl.instance();
    @Test
    public void countEquipmentPriceTest() throws Exception {
        forge.createFullKnightEquipment(knight);
        int price = 0;
        for(Equipment equip : knight.getEquipment()){
            price += equip.getPrice();
        }
        assertEquals(price, knight.countEquipmentPrice());
    }

    @Test
    public void countEquipmentPriceNullTest() throws Exception {
        assertEquals(0, knight.countEquipmentPrice());
    }

    @Test
    public void sortEquipmentByWeightTest() throws Exception {

        knight.getEquipment().add(new Helmet(Material.IRON, 7, 100));
        knight.getEquipment().add(new Helmet(Material.IRON, 3, 100));
        knight.getEquipment().add(new Helmet(Material.IRON, 5, 100));
        knight.getEquipment().add(new Helmet(Material.IRON, 1, 100));
        knight.getEquipment().add(new Helmet(Material.IRON, 2, 100));

        List<Equipment> equip = new ArrayList<>();
        equip.add(knight.getEquipment().get(3));
        equip.add(knight.getEquipment().get(4));
        equip.add(knight.getEquipment().get(1));
        equip.add(knight.getEquipment().get(2));
        equip.add(knight.getEquipment().get(0));
        knight.sortEquipmentByWeight();
        assertEquals(equip,knight.getEquipment());
    }
    @Test
    public void sortEquipmentByWeightEmptyTest() throws Exception {
        List<Equipment> equip = new ArrayList<>();
        knight.sortEquipmentByWeight();
        assertEquals(equip, knight.getEquipment());
    }

    @Test
    public void getEquipmentByPriceNullTest() throws Exception {
        List<Equipment> equip = new ArrayList<>();
        assertEquals(equip, knight.getEquipmentByPrice(20,300));
    }

    @Test
    public void getEquipmentByPriceTest() throws Exception {
        forge.createFullKnightEquipment(knight);
        List<Equipment> equipmentList = new ArrayList<>();
        equipmentList.add(knight.getEquipment().get(3));
        assertEquals(equipmentList, knight.getEquipmentByPrice(40, 50));
    }

    @Test(expected = IllegalArgumentException.class)
    public void getEquipmentByPriceIllegalTest() {
        forge.createFullKnightEquipment(knight);
        knight.getEquipmentByPrice(-2,20);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getEquipmentByPriceIllegal1Test() {
        forge.createFullKnightEquipment(knight);
        knight.getEquipmentByPrice(100, 99);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getEquipmentByPriceIllegal2Test() {
        forge.createFullKnightEquipment(knight);
        knight.getEquipmentByPrice(-30, -20);
    }
}