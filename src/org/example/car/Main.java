package org.example.car;

//Создать объект класса Автомобиль, используя классы Колесо, Двигатель. Методы: ехать, заправляться,
//менять колесо, вывести на консоль марку автомобиля.
public class Main {

    public static void main(String[] args) {
        Car car = new Car("BMV");

        car.move();
        car.fillUp(10);
        car.changeWheelById(car.getWheels().get(0).getId(), new Wheel());

        System.out.println(car.getMark());
        System.out.println(car);
    }

}
