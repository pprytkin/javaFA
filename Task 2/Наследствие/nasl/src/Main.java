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

class Shape {
    double volume;

    public Shape(double volume) {
        this.volume = volume;
    }

    public double getVolume() {
        return volume;
    }
}

class Box extends Shape {
    ArrayList<Shape> shapes = new ArrayList<>();
    double free;
    public Box(double free) {
        super(free);
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
}
class Pyramid extends Shape{
    double h;
    double s;
    public Pyramid(double h, double s) {
        super(h*s*4/3);
        this.h = h;
        this.s = s;
    }
}
class SolidOfRevolution extends Shape {
    double radius;
    public SolidOfRevolution(double volume, double radius) {
        super(volume);
        this.radius = radius;
    }
    public double getRadius() {
        return radius;
    }
}
class Cylinder extends SolidOfRevolution{
    double height;
    public Cylinder(double radius, double height) {
        super(Math.PI*radius*radius*height, radius);
        this.height = height;
    }
}
class Ball extends SolidOfRevolution {
    public Ball(double radius) {
        super(Math.PI*Math.pow(radius, 3)*4/3,radius);
    }
}