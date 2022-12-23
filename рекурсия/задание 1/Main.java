public class Main
{
    public static void main(String[] args) {
        recursion(1, 55);
    }
    
    public static void recursion(int a, int n){
        if (a == n){
            System.out.println(a);
        } else {
            System.out.println(a);
            recursion(a + 1, n);
        }
    }
}