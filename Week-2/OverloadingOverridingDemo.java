class Calculator {
    int add(int a, int b) { return a + b; }
    double add(double a, double b) { return a + b; }
    int add(int a, int b, int c) { return a + b + c; }
}

class Parent {
    void show() { System.out.println("Parent implementation"); }
}

class Child extends Parent {
    @Override
    void show() { System.out.println("Child implementation"); }
}

public class OverloadingOverridingDemo {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        System.out.println("Overloading: " + calculator.add(2, 3));
        System.out.println("Overloading: " + calculator.add(2.5, 3.5));
        System.out.println("Overloading: " + calculator.add(1, 2, 3));

        Parent object = new Child();
        object.show();
    }
}
