package javaPractice;

import java.util.Scanner;

public class SmallerNums {

	public static void main(String[] args) {
		
		/*
		 * 정수 N개로 이루어진 수열 A와 정수 X가 주어진다. 이때, A에서 X보다 작은 수를 모두 출력
		 * N: 수열 개수, X: 출력 기준값 (보다 작아야 함)
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
