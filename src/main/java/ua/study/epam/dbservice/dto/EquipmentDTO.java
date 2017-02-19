package ua.study.epam.dbservice.dto;

import ua.study.epam.equipment.Equipment;
import ua.study.epam.equipment.defenceequipment.*;
import ua.study.epam.equipment.material.Material;
import ua.study.epam.equipment.weapon.Dagger;
import ua.study.epam.equipment.weapon.Sword;

/**
 * Created by dima on 14.02.17.
 */
public class EquipmentDTO {
    private String type;
    private String material;
    private String name;
    private int weight;
    private int price;
    private int damage;
    private int damageRange;
    private int defence;
    private int block;
    private String owner;

    public EquipmentDTO(String type, String material, String name, int weight, int price, int damage, int damageRange,
                        int defence, int block) {
        this.type = type;
        this.material = material;
        this.name = name;
        this.weight = weight;
        this.price = price;
        this.damage = damage;
        this.damageRange = damageRange;
        this.defence = defence;
        this.block = block;
    }

    public Equipment loadEquipmentFromDB(){
        if (this == null) return null;
        else {
            Equipment equipment = null;
            switch (this.getType()) {
                case "Dagger":
                    equipment = new Dagger(Material.valueOf(this.getMaterial()), this.getWeight(), this.getPrice());
                    break;
                case "Sword":
                    equipment = new Sword(Material.valueOf(this.getMaterial()), this.getWeight(), this.getPrice());
                    break;
                case "Boots":
                    equipment = new Boots(Material.valueOf(this.getMaterial()), this.getWeight(), this.getPrice());
                    break;
                case "Gloves":
                    equipment = new Gloves(Material.valueOf(this.getMaterial()), this.getWeight(), this.getPrice());
                    break;
                case "Helmet":
                    equipment = new Helmet(Material.valueOf(this.getMaterial()), this.getWeight(), this.getPrice());
                    break;
                case "Leggings":
                    equipment = new Leggings(Material.valueOf(this.getMaterial()), this.getWeight(), this.getPrice());
                    break;
                case "MailArmor":
                    equipment = new MailArmor(Material.valueOf(this.getMaterial()), this.getWeight(), this.getPrice());
                    break;
                case "Shield":
                    equipment = new Shield(Material.valueOf(this.getMaterial()), this.getWeight(), this.getPrice());
                    break;
            }
            return equipment;
        }
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getDamageRange() {
        return damageRange;
    }

    public void setDamageRange(int damageRange) {
        this.damageRange = damageRange;
    }

    public int getDefence() {
        return defence;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public int getBlock() {
        return block;
    }

    public void setBlock(int block) {
        this.block = block;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
