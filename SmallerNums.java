package javaPractice;

import java.util.Scanner;

public class SmallerNums {

	public static void main(String[] args) {
		
		/*
		 * ���� N���� �̷���� ���� A�� ���� X�� �־�����. �̶�, A���� X���� ���� ���� ��� ���
		 * N: ���� ����, X: ��� ���ذ� (���� �۾ƾ� ��)
		 */
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int X = sc.nextInt();
		int A[]=new int[N];

		for (int i=0;i<N;i++) {
			A[i]=sc.nextInt();
		}

		for (int i=0;i<N;i++) {
			if (A[i]<X) {
				System.out.print(A[i]+" ");
			}
		}
		
	}
}
