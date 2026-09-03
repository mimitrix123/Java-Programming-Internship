public class Bike extends Vehicle {
    public Bike(String brand) { super(brand); }

    @Override
    public void start() { System.out.println(brand + " bike starts with a kick/electric start."); }

    @Override
    public void move() { System.out.println(brand + " bike moves on two wheels."); }
}
