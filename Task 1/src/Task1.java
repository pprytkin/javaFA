public class Task1{

    public static void main(String[] args){
		System.out.println("Задание 1: ");
		System.out.println("Hello World!");
		
		System.out.println("Задание 2: ");
		int z2 = 2;
		System.out.println(z2);
		
		System.out.println("Задание 3: ");
		int z3 = 0;
		z3 = z3 + 1;
		z3 += 1;
		++z3;
		System.out.println(z3);

		System.out.println("Задание 4: ");
		int z4_1 = 4;
		int z4_2 = 44;
		
		var z4_3 = z4_1;
		z4_1 = z4_2;
		z4_2 = z4_3;
		
		z4_1 += z4_2;
		z4_2 = z4_1 - z4_2;
		z4_1 -= z4_2;
		System.out.println(z4_1+", "+z4_2);
		
		System.out.println("Задание 5: ");
		int z5_1 = 3;
		int z5_2 = 4;
		System.out.println(Math.sqrt(z5_1*z5_1 + z5_2*z5_2));
		
		System.out.println("Задание 6: ");
		int z6 = 123456;
		System.out.println(z6 % 10);
		
		System.out.println("Задание 7: ");
		int z7 = 1234576;
		System.out.println((z7 % 100 - z7 % 10)/10);
		
		System.out.println("Задание 8: ");
		int z8 = 89;
		System.out.println(z8/10);
		
		System.out.println("Задание 9: ");
		System.out.println(Z9(30));
		
		System.out.println("Задание 10: ");
		System.out.println(Z10(14, 6));
		
		System.out.println("Задание 11: ");
		System.out.println(Z11(121, 1));
		
		System.out.println("Задание 12: ");
		System.out.println(Z12(-2, 19, -2, 7));
    }
	public static int Z9(int z9){
		return z9 - 21;
	}
	public static int Z10(int z10_1, int z10_2){
		return (z10_1 + z10_2)/2;
	}
	public static double Z11(int z11_1, int z11_2){
		return Math.sqrt(z11_1*z11_2);
	}
	public static double Z12(double z12_1, double z12_2, double z12_3, double z12_4){
		var z12_5 = z12_1 - z12_3;
		var z12_6 = z12_2 - z12_4;
		return Math.sqrt(z12_5*z12_5 + z12_6*z12_6);
	}
}
