package javaPractice;

import java.util.Scanner;

public class Stars2 {

	public static void main(String[] args) {

		Scanner sc= new Scanner(System.in);
		int num=sc.nextInt();
		int i,j,k;
		for(i=1;i<=num;i++) {
			for(j=1;j<=num-i;j++) {
				System.out.print(" "); //����(�Է°�-�ప)
			}			
			for(k=1;k<=i;k++) {
				System.out.print("*"); //��(=�ప)
			}
			System.out.println(); //���� ��
		}
		
	}

}
