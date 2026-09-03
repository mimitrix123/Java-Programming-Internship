public class Circle implements Shape {
    private final double radius;

    public Circle(double radius) {
        if (radius <= 0) throw new IllegalArgumentException("Radius must be positive.");
        this.radius = radius;
    }

    @Override
    public double area() { return Math.PI * radius * radius; }

    @Override
    public double perimeter() { return 2 * Math.PI * radius; }

    public static void main(String[] args) {
        Shape circle = new Circle(5);
        System.out.printf("Area = %.2f%n", circle.area());
        System.out.printf("Perimeter = %.2f%n", circle.perimeter());
    }
}
