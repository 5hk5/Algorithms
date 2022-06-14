package javaPractice;

import java.util.Scanner;

public class ThreeDices {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int dice1 = sc.nextInt();
		int dice2 = sc.nextInt();
		int dice3 = sc.nextInt();
		int result;
				
		if (dice1==dice2&dice2==dice3) {
			result = dice1*1000+10000;
		} else if (dice1==dice2|dice2==dice3) {
			result = dice2*100+1000;
		}else if (dice1==dice3) {
			result = dice1*100+1000;
		} else {
			result = Math.max(Math.max(dice1, dice2),dice3) * 100;
		}
		
		System.out.println(result);
		
	}

}
