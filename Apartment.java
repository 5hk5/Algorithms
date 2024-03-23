package javaPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Apartment {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		//0�� 1ȣ���� ��� ���� (1ȣ���� ���� 1, 2, .. n�� ����)
		//a�� bȣ�� ����� a-1���� 1~bȣ������ �����ŭ �����ؾ� ��
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(br.readLine());
		
		int[][] people = new int[15][15];

		for(int i=0;i<15;i++) {
			people[0][i]=i; //0�� => 1,2,3,..
			people[i][1]=1; //1ȣ => 1
		}
		
		for (int i=1;i<15;i++) { //1�� �̻�

			for(int j=2;j<15;j++) { //2ȣ �̻�
					people[i][j]=people[i-1][j]+people[i][j-1];
			}
			
		}
		
		for (int i=0;i<num;i++) {
			int floor = Integer.parseInt(br.readLine()); //��
			int room = Integer.parseInt(br.readLine()); //ȣ
			System.out.println(people[floor][room]);
		}
		
	}

}
