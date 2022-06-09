package javaPractice;

import java.util.Scanner;

public class Time {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String a = sc.nextLine();
		String[] numbers = a.split(" ");
		int hour = Integer.valueOf(numbers[0]);
		int min = Integer.valueOf(numbers[1]);
		int add = sc.nextInt();
		int resultMin=min+add;
		
		if (resultMin<60) {
			min+=add;
		} else {
			hour+=resultMin/60;
			min = (resultMin)%60;
		} 
		
		if (hour>=24) {
			hour-=24;
		}
		
		System.out.println(hour + " " + min);
		
	}

}
