package practice3classes;

class Vehicle {

    private String brand;
    private int year;
    private static int totalVehicles = 0;

    public Vehicle(String brand, int year) {
        this.brand = brand;
        this.year = year;
        totalVehicles++;
    }

    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }
    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }

    public static int getTotalVehicles() { return totalVehicles; }

    public void printDetails() {
        System.out.print("Марка: " + brand + ", Год: " + year);
    }
}

class Car extends Vehicle {

    private String fuelType;
    private static int carCount = 0;

    public Car(String brand, int year, String fuelType) {
        super(brand, year);
        this.fuelType = fuelType;
        carCount++;
    }

    public String getFuelType() { return fuelType; }
    public void setFuelType(String fuelType) { this.fuelType = fuelType; }
    public static int getCarCount() { return carCount; }

    @Override
    public void printDetails() {
        super.printDetails();
        System.out.println(", Тип топлива: " + fuelType);
    }
}

class Bicycle extends Vehicle {

    private int gearCount;
    private static int bicycleCount = 0;

    public Bicycle(String brand, int year, int gearCount) {
        super(brand, year);
        this.gearCount = gearCount;
        bicycleCount++;
    }

    public static int getBicycleCount() { 
        return bicycleCount; 
    }

    @Override
    public void printDetails() {
        super.printDetails();
        System.out.println(", Количество передач: " + gearCount);
    }
}

public class Main {

    public static void main(String[] args) {
        Vehicle[] garage = new Vehicle[3];

        garage[0] = new Car("Toyota", 2022, "Бензин");
        garage[1] = new Bicycle("Bianchi", 2023, 21);
        garage[2] = new Car("Volvo", 2024, "Электро");

        System.out.println("Транспорт: ");
        for (Vehicle i: garage) {
            i.printDetails();
        }

        System.out.println("Статистика: ");
        System.out.println("Всего тр. средств: " + Vehicle.getTotalVehicles());
        System.out.println("Машин: " + Car.getCarCount());
        System.out.println("Велосипедов: " + Bicycle.getBicycleCount());

    }
    
}
