package javaPractice;

import java.util.Scanner;

public class Add {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int total = sc.nextInt();
		
		for (int i=0;i<total;i++) {
			int num1 = sc.nextInt();
			int num2 = sc.nextInt();
			System.out.println("Case #"+(i+1)+": "+(num1+num2));
		}
		
	}

}
