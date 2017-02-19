package ua.study.epam.equipment;

import ua.study.epam.equipment.material.Material;

import java.util.Random;

/**
 * Created by dima on 11.02.17.
 */
public abstract class Equipment {
    private Random random = new Random();
    private final Material material;
    private final int weight;
    private final int price;
    private String name = "unnamed";
    int i = random.nextInt(1000);

    public Equipment(Material material, int weight, int price) {
        this.material = material;
        this.weight = weight;
        this.price = price;
        this.setName(this.getName() + i);
    }

    public Material getMaterial() {
        return material;
    }

    public int getWeight() {
        return weight;
    }

    public int getPrice() {
        return price;
    }

    public String getName() { return name;  }

    public void setName(String name) {
        this.name = name;
    }
}
