package banco_poliform;

import java.util.Scanner;

public class Teclado {
	
	public static String LerString(String rotulo) {
		System.out.println(rotulo);
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		return sc.nextLine();
	}
	
	public static int LerInt(String rotulo) {
		System.out.println(rotulo);
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		return sc.nextInt();
	}
	
	public static boolean LerBoolean(String rotulo) {
		System.out.println(rotulo);
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		return sc.nextBoolean();
	}
	
	public static float LerFLoat(String rotulo) {
		System.out.println(rotulo);
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		return sc.nextFloat();
	}
	
	public static Double LerDouble(String rotulo) {
		System.out.println(rotulo);
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		return sc.nextDouble();
	}
	
	public static String lerData(String rotulo) {
		System.out.println(rotulo);;
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		return sc.next();
	}
	
}
