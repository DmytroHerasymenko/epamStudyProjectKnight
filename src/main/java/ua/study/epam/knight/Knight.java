package ua.study.epam.knight;

import ua.study.epam.equipment.Equipment;
import ua.study.epam.knight.gender.Gender;
import ua.study.epam.knight.rank.Rank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by dima on 11.02.17.
 */
public class Knight extends Human {
    private Scanner scanner = new Scanner(System.in);

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
        if(this.getEquipment().isEmpty()) {
            System.out.println("knight hasn't any equipment :(");
            return 0;
        }
        int equipmentPrice = 0;
        for (Equipment equip : this.getEquipment()) {
            equipmentPrice += equip.getPrice();
        }
        System.out.println("total price of knight equipment - " + equipmentPrice);
        return equipmentPrice;
    }

    public void sortEquipmentByWeight(){
        this.sortByWeight(this.getEquipment());
        System.out.println("sort equipment by weight: ");
        System.out.println(this.getEquipment());
    }

    private void sortByWeight(List<Equipment> equipment){
        if(equipment.isEmpty()){
            System.out.println("knight hasn't any equipment :(");
            return;
        }
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

    public List<Equipment> getEquipmentByPrice(){
        if(this.getEquipment().isEmpty()){
            System.out.println("knight hasn't any equipment :(");
            return new ArrayList<>();
        }

        System.out.println("For searching equipment within specified price range, please enter min price: ");
        scannerCheck();
        int minPrice = scanner.nextInt();
        System.out.println("Now enter max price: ");
        scannerCheck();
        int maxPrice = scanner.nextInt();
        while(minPrice < 0 || minPrice > maxPrice || maxPrice > Integer.MAX_VALUE){
            System.out.println("Sorry, the min price may not be less then 0 and may not be more then max price." +
                    "Max price may not be less then min price and more then " + Integer.MAX_VALUE + ". Try one more time!");
            System.out.println("enter min price: ");
            scannerCheck();
            minPrice = scanner.nextInt();
            System.out.println("enter max price: ");
            scannerCheck();
            maxPrice = scanner.nextInt();
        }

        List<Equipment> equipmentByPrice = new ArrayList<>();
        for (Equipment equip : this.getEquipment()) {
            if(equip.getPrice() >= minPrice && equip.getPrice() <=maxPrice){
                equipmentByPrice.add(equip);
            }
        }
        if(equipmentByPrice.isEmpty()){
            System.out.println("knight hasn't any equipment that satisfies current request.");
        } else {
            System.out.println("knight equipment in entered price range (" + minPrice + " - " + maxPrice + "): ");
            System.out.println(equipmentByPrice);
        }

        return equipmentByPrice;
    }

    private void scannerCheck(){
        while(!scanner.hasNextInt()){
            System.out.println("incorrect symbol. Please enter integer: ");
            scanner.next();
        }
    }

    @Override
    public String toString() {
        return rank + " " + getName();
    }
}
