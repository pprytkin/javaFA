import java.lang.reflect.Array;

public class Main {
    public static void main(String[] args) {
        BMW car1 = new BMW("white", 250, "auto", 10000000, "x7");
        LowRider car2 = new LowRider("red", 150, "mech", 1400000, 3);
        car1.accelerate(70);
        car1.start(5);
        car1.accelerate(70);
        System.out.println(car1.now_speed);
        car1.accelerate(300);
        car1.know_model();
        car1.stop();
        System.out.println(car1.status);
    }
}
class Car{
    String status = "cтоит на месте";
    String color;
    int max_speed;
    String type;
    int now_speed;
    int piece;
    public Car(String color, int max_speed, String type, int piece){
        this.color = color;
        this.max_speed = max_speed;
        this.type = type;
        this.now_speed = now_speed;
        this.piece = piece;
    }
    public void start(int speed){
        if (status != "едет") {
            status = "едет";
            now_speed = speed;
        } else {
            System.out.println("Машина и так " + status);
        }
    }
    public void accelerate(int speed){
        if (status == "едет"){
            if (now_speed < speed){
                if (speed < max_speed) {
                    now_speed = speed;
                    System.out.println("Машина ускорилась до " + speed);
                } else {
                    System.out.println("Максимаьная скорость машины: " + max_speed);
                }
            } else {
                System.out.println("Машина не может ускорить до " + speed + ", так как уже имеет скорость" + now_speed);
            }
        } else {
            System.out.println("Машина не может ускориться, так как " + status);
        }
    }
    public void stop(){
        if (status == "едет") {
            status = "стоит на месте";
            now_speed = 0;
        } else {
            System.out.println("Машина и так " + status);
        }
    }
}
class BMW extends Car{
    String model;
    public BMW(String color, int max_speed, String type, int piece, String model) {
        super(color, max_speed, type, piece);
        this.model = model;
    }
    public void know_model(){
        System.out.println("Модель машины: " + model);
    }
}
class LowRider extends Car{
    int max_jump;
    public LowRider(String color, int max_speed, String type, int piece,int max_jump) {
        super(color, max_speed, type, piece);
        this.max_jump = max_jump;
    }
    public void jump(int h){
        if (h < max_jump){
            System.out.println("Машина подпрыгнула на " + h);
        } else {
            System.out.println("Максимальная высота прыжка: " + max_jump);
        }
    }
}
class Garage{
    Car[] cars = new Car[this.max];
    int[] count = new int[this.max];
    int cnt = 0;
    int max;
    int s = 0;
    public Garage(int max){
        this.max = max;
    }
    public void append(Car p, int count){
        if (cnt + count < max){
            cars[s] = p;
            this.count[s] = count;
            cnt += count;
        } else {
            System.out.println("В гараже не хватает места");
        }
    }
}