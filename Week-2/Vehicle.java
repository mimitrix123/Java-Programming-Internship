public class Vehicle {
    protected String brand;

    public Vehicle(String brand) { this.brand = brand; }

    public void start() { System.out.println(brand + " vehicle is starting."); }
    public void move() { System.out.println(brand + " vehicle is moving."); }
}
