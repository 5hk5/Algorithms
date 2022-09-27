package javaPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Apartment {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		//0층 1호부터 사람 거주 (1호부터 각각 1, 2, .. n명 거주)
		//a층 b호에 살려면 a-1층의 1~b호까지의 사람만큼 거주해야 함
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(br.readLine());
		
		int[][] people = new int[15][15];

		for(int i=0;i<15;i++) {
			people[0][i]=i; //0층 => 1,2,3,..
			people[i][1]=1; //1호 => 1
		}
		
		for (int i=1;i<15;i++) { //1층 이상

			for(int j=2;j<15;j++) { //2호 이상
					people[i][j]=people[i-1][j]+people[i][j-1];
			}
			
		}
		
		for (int i=0;i<num;i++) {
			int floor = Integer.parseInt(br.readLine()); //층
			int room = Integer.parseInt(br.readLine()); //호
			System.out.println(people[floor][room]);
		}
		
	}

}
