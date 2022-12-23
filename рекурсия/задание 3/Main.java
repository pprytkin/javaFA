public class Main {
    public static void main(String[] args) {
        System.out.println(Function.solve(0, 10)); 
    }
} 

class Function {
    public static double f(double x){
        return Math.cos(Math.pow(x, 5)) + Math.pow(x, 4) - 345.3 * x - 23;
    }

    public static double  solve(double start, double end){
        if(end - start <= 0.001){
            return start;
        }

        double x = start + (end - start) / 2;

        if(f(start) * f(x) > 0){
            return solve(x, end);
        } else {
            return solve(start, x);
        }
    }
}