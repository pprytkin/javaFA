import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Box box = new Box(300);
        Cylinder cyl = new Cylinder(4, 2);
        Ball ball = new Ball(3);
        Pyramid pyr = new Pyramid(10, 15);
        System.out.println("Cylinder: " + box.add(cyl));
        System.out.println("Ball: " + box.add(ball));
        System.out.println("Pyramid: " + box.add(pyr));
    }
}

abstract class Shape {
    public abstract double getVolume();
}

class Box extends Shape {
    ArrayList<Shape> shapes = new ArrayList<>();
    double volume;
    double free;
    public Box(double free) {
        this.volume = free;
        this.free = free;
    }

    public boolean add(Shape shape) {
        if (free >= shape.getVolume()) {
            shapes.add(shape);
            free -= shape.getVolume();
            return true;
        } else {
            return false;
        }
    }

    @Override
    public double getVolume() {
        return volume;
    }
}
class Pyramid extends Shape{
    double h;
    double s;
    public Pyramid(double h, double s) {
        this.h = h;
        this.s = s;
    }
    @Override
    public double getVolume() {
        return h*s*4/3;
    }
}
abstract class SolidOfRevolution extends Shape {
    double radius;
    public SolidOfRevolution(double radius) {
        this.radius = radius;
    }
    public double getRadius() {
        return radius;
    }
}
class Cylinder extends SolidOfRevolution{
    double height;
    public Cylinder(double radius, double height) {
        super(radius);
        this.height = height;
    }
    @Override
    public double getVolume() {
        return Math.PI*radius*radius*height;
    }
}
class Ball extends SolidOfRevolution {
    public Ball(double radius) {
        super(radius);
    }
    @Override
    public double getVolume() {
        return Math.PI*Math.pow(radius, 3)*4/3;
    }
}