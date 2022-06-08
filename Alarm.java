package javaPractice;

import java.util.Scanner;

public class Alarm {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String a = sc.nextLine();
		String[] number=a.split(" ");
		int num1 = Integer.valueOf(number[0]);
		int num2 = Integer.valueOf(number[1]);
		
		if (num1==0&&num2<45) {num1=24;}
		
		if (num2>=45) {
			System.out.println(num1 + " " + (num2-45));
		} else {			
			System.out.println((num1-1) + " " + (num2+15));
		}
		
	}

}
