import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Vector v = new Vector(new int[]{5, 2, 3});
        Vector v2 = new Vector(new int[]{2, 4, 1});
        System.out.println(v.Len());
        System.out.println(v.ScP(v2));
        System.out.println(v2.ScP(v));
        System.out.println(Arrays.toString(v.VcP(v2)));
        System.out.println(v.Cos(v2));
        System.out.println(v2.Cos(v));
        System.out.println(Arrays.toString(v.Sum(v2)));
        System.out.println(Arrays.toString(v.Dif(v2)));
        System.out.println(Arrays.toString(Vector.Ran(2)));
        int[][] vects = Vector.Ran(2);
        Vector v3 = new Vector(vects[0]);
        Vector v4 = new Vector(vects[1]);
        System.out.println("____________________________");
        System.out.println(v3.x + ", " + v3.y + ", " + v3.z);
        System.out.println(v4.x + ", " + v4.y + ", " + v4.z);
        System.out.println(v3.Len());
        System.out.println(v3.Cos(v4));
        System.out.println(v3.ScP(v4));
        System.out.println(Arrays.toString(v3.Sum(v4)));
    }
}

class Vector{
    int x;
    int y;
    int z;
    public Vector(int[] a){
        this.x = a[0];
        this.y = a[1];
        this.z = a[2];
    }
    public double Len(){
        return Math.sqrt(this.x*this.x + this.y*this.y + this.z*this.z);
    }
    public int ScP(Vector v2){
        return this.x*v2.x + this.y*v2.y + this.z*v2.z;
    }
    public int[] VcP(Vector v2){
        return new int[]{this.y * v2.z - this.z * v2.y, this.z * v2.x - this.x * v2.z, this.x * v2.y - this.y * v2.x};
    }
    public double Cos(Vector v2){
        return this.ScP(v2)/(this.Len() * v2.Len());
    }
    public int[] Sum(Vector v2){
        return new int[]{this.x + v2.x, this.y + v2.y, this.z + v2.z};
    }
    public int[] Dif(Vector v2){
        return new int[]{this.x - v2.x, this.y - v2.y, this.z - v2.z};
    }
    public static int[][] Ran(int n){
        int[][] res = new int[n][3];
        for (int i=0; i<n; i++){
            /*for (int j=0; j<3; j++){
                res[i][j] = (int)(Math.random()*101);
            }*/
            res[i] = new int[]{(int)(Math.random()*100), (int)(Math.random()*100), (int)(Math.random()*100)};
        }
        return res;
    }
}