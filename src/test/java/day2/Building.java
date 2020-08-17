package day2;

//    2. Реализовать иерархию классов
//    "объект недвижимости", "жилое", "нежилое", "квартира", "жилой дом", "магазин".
//    Должна поддерживаться площадь объектов, стоимость аренды за квадратный метр и за объект целиком.

import java.util.ArrayList;

interface Residential {
    // Жилое
}
interface NonResidential {
    // Нежилое
}
public abstract class Building {
    static ArrayList<Building> allBuilds = new ArrayList<>();
    String cName;
    String name;
    int area;
    int cost;
    int fullCost;

    Building(String name, int area, int cost) {
        this.name = name;
        this.area = area;
        this.cost = cost;
        this.fullCost = area * cost;
        //System.out.println(this.name + " was created");
        allBuilds.add(this);
    }

    private void introduce() {
        System.out.println(cName + " " + name);
        System.out.println("area = " + area + " cost " + cost + " fullcost " + fullCost + "\n");
    }

    public static void printAllResidental() {
        for (Building b: allBuilds) {
            if (b instanceof Residential) {
                b.introduce();
            }
        }
    }
    public static void printAllNonResidental() {
        for (Building b: allBuilds) {
            if (b instanceof NonResidential) {
                b.introduce();
            }
        }
    }

    public static class Apartment extends Building implements Residential {
        Apartment(String name, int area, int cost) {
            super(name, area, cost);
            this.cName = "Apartment";
        }
    }
    public static class House extends Building implements Residential {
        House(String name, int area, int cost) {
            super(name, area, cost);
            this.cName = "House";
        }
    }
    public static class Shop extends Building implements NonResidential {
        Shop(String name, int area, int cost) {
            super(name, area, cost);
            this.cName = "Shop";
        }
    }
}
