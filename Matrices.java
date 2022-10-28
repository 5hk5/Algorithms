package javaPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Matrices {

	public static void main(String[] args) throws IOException {

		//입력값 1 : 두 행렬 크기 (N M) / 입력값 2 : 행렬 A, B 값 (N개의 줄에 M개의 값)
		//ex. 2 2
		// 1 3
		// 2 4
		// 2 2
		// 1 5
		//출력값 : 두 행렬의 합 (한 행씩 출력)
		//ex. 3 5
		// 3 9
		
		//입력값 1을 split()으로 나눠 두개의 정수타입 변수로 받음 (N, M)
		//N,M 크기의 행렬 sumMatrix 생성
		//중첩 반복문 * 2, StringTokenizer 사용
		//각 행 입력시 nextToken()으로 하나의 값을 sumMatrix의 해당 인덱스에 대입함 (+=)
		//두번째 중첩반복문 => 두번째 행렬부터는 각 행 입력시 이전 행렬과의 합산 값 출력
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] matrices=br.readLine().split(" ");
		
		int N=Integer.parseInt(matrices[0]);
		int M=Integer.parseInt(matrices[1]);
		
		int[][] sumMatrix = new int [N][M]; //입력한 N,M 크기의 행렬
		
		StringTokenizer st; 
		for (int i=0;i<N;i++) {
			st= new StringTokenizer(br.readLine()," ");
			for (int j=0;j<M;j++) {
				sumMatrix[i][j]+=Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i=0;i<N;i++) {
			st= new StringTokenizer(br.readLine()," ");
			for (int j=0;j<M;j++) {
				sumMatrix[i][j]+=Integer.parseInt(st.nextToken());
				System.out.print(sumMatrix[i][j] + " ");
			}
			System.out.println();
		}
		
	}

}