public class Car extends Vehicle {
    public Car(String brand) { super(brand); }

    @Override
    public void start() { System.out.println(brand + " car starts with a key/button."); }

    @Override
    public void move() { System.out.println(brand + " car moves on four wheels."); }

    public static void main(String[] args) {
        Vehicle vehicle = new Car("Toyota");
        vehicle.start();
        vehicle.move();
    }
}
