package day2;

//    2. Реализовать иерархию классов
//    "объект недвижимости", "жилое", "нежилое", "квартира", "жилой дом", "магазин".
//    Должна поддерживаться площадь объектов, стоимость аренды за квадратный метр и за объект целиком.

interface Residential {
    // Жилое
}
interface NonResidential {
    // Нежилое
}
public abstract class Building {
    int area;
    int cost;
    int fullCost;

    private class Apartment extends Building implements Residential {
    }
    private class House extends Building implements Residential {
    }
    private class Shop extends Building implements NonResidential {
    }
}

