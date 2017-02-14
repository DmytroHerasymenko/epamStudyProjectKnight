package ua.study.epam.knight;

import ua.study.epam.equipment.Equipment;
import ua.study.epam.knight.gender.Gender;
import ua.study.epam.knight.rank.Rank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by dima on 11.02.17.
 */
public class Knight extends Human {
    private final List<Equipment> equipment = new ArrayList<>();
    private Rank rank = Rank.SQUIRE;
    private int money = 700;
    private int defence = 0;
    private int damage = 0;

    public Knight(Gender gender, String name, int age) {
        super(gender, name, age);
    }

    public List<Equipment> getEquipment() {
        return equipment;
    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getDefence() {
        return defence;
    }

    public void setDefence(int defence) {
        this.defence += defence;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage += damage;
    }

    public int countEquipmentPrice(){
        int equipmentPrice = 0;
        for (Equipment equip : equipment) {
            equipmentPrice += equip.getPrice();
        }
        return equipmentPrice;
    }

    public void sortEquipmentByWeight(){
        this.sortByWeight(this.getEquipment());
    }

    private void sortByWeight(List<Equipment> equipment){
        if(equipment.isEmpty()) return;
        int lenght = equipment.size();
        int entryPoint = 0;
        int endPoint = lenght-1;
        int weight = equipment.get(lenght/2).getWeight();
        while (entryPoint <= endPoint){
            while (equipment.get(entryPoint).getWeight() < weight) {
                entryPoint++;
            }
            while (equipment.get(endPoint).getWeight() > weight) {
                endPoint--;
            }
            if ( entryPoint <= endPoint) {
                Collections.swap(equipment, entryPoint, endPoint);
                entryPoint++;
                endPoint--;
            }
        }
        if (endPoint > 0){
            sortByWeight(equipment.subList(0,endPoint+1));
        }
        if (entryPoint < lenght){
            sortByWeight(equipment.subList(entryPoint,lenght));
        }
    }

    public List<Equipment> getEquipmentByPrice(int minPrice, int maxPrice){
        List<Equipment> equipmentByPrice = new ArrayList<>();
        for (Equipment equip : equipment) {
            if(equip.getPrice() >= minPrice && equip.getPrice() <=maxPrice){
                equipmentByPrice.add(equip);
            }
        }
        return equipmentByPrice;
    }

    @Override
    public String toString() {
        return rank + " " + getName();
    }
}
