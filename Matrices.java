package javaPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Matrices {

	public static void main(String[] args) throws IOException {

		//�Է°� 1 : �� ��� ũ�� (N M) / �Է°� 2 : ��� A, B �� (N���� �ٿ� M���� ��)
		//ex. 2 2
		// 1 3
		// 2 4
		// 2 2
		// 1 5
		//��°� : �� ����� �� (�� �྿ ���)
		//ex. 3 5
		// 3 9
		
		//�Է°� 1�� split()���� ���� �ΰ��� ����Ÿ�� ������ ���� (N, M)
		//N,M ũ���� ��� sumMatrix ����
		//��ø �ݺ��� * 2, StringTokenizer ���
		//�� �� �Է½� nextToken()���� �ϳ��� ���� sumMatrix�� �ش� �ε����� ������ (+=)
		//�ι�° ��ø�ݺ��� => �ι�° ��ĺ��ʹ� �� �� �Է½� ���� ��İ��� �ջ� �� ���
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] matrices=br.readLine().split(" ");
		
		int N=Integer.parseInt(matrices[0]);
		int M=Integer.parseInt(matrices[1]);
		
		int[][] sumMatrix = new int [N][M]; //�Է��� N,M ũ���� ���
		
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