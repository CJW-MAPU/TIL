public class Circle {
    int radius;
    String name;

    public Circle() {
        radius = 1;
        name = "";
    }

    public Circle(int r, String n) {
        radius = r;
        name = n;
    }

    public double getArea() {
        return 3.14 * radius * radius;
    }

    public static void main(String[] args) {
        Circle pizza = new Circle(10, "Java Pizza");
        double area = pizza.getArea();
        System.out.println(pizza.name + " Area: " + area);

        Circle [] c;
        c = new Circle[5];

        for (int i = 0; i < c.length; i++) {
            c[i] = new Circle( );
        }
    }
}