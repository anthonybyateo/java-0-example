package org.example.country;

import java.util.ArrayList;
import java.util.List;

//Создать объект класса Государство, используя классы Область, Район, Город. Методы: вывести на консоль
//столицу, количество областей, площадь, областные центры.
public class Main {

    public static void main(String[] args) {
        City city1 = new City("Minsk", true, true);
        City city2 = new City("Grodno", true, false);
        City city3 = new City("Osipovichy");
        District district1 = new District("Minsk's district", 200, new ArrayList<>(List.of(city1, city3)));
        District district2 = new District("Grodno's district", 100, new ArrayList<>(List.of(city2)));
        Region region1 = new Region("Minsk's region", new ArrayList<>(List.of(district1)));
        Region region2 = new Region("Grodno's region", new ArrayList<>(List.of(district2)));
        State state = new State("Belarus", new ArrayList<>(List.of(region1, region2)));

        state.printCapital();
        System.out.println("==========================");
        state.printStateCount();
        System.out.println("==========================");
        state.printSquare();
        System.out.println("==========================");
        state.printStateCapitals();
        System.out.println("==========================");
    }

}
