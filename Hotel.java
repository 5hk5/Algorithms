package javaPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Hotel {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		// 호텔 방 배정
		// 손님들은 작은 호수(width) > 저층(height) 선호
		// 101호, 201호, 301호, 102호, 202호, .. 순서로 배정됨
		// 입력값이 ( 높이 너비 손님순서 ) 일 때 방 호수 출력
				
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int total = Integer.parseInt(br.readLine()); //테스트 개수
		
		for (int i=0;i<total;i++) {
			
			String input=br.readLine();
			StringTokenizer st = new StringTokenizer(input," ");
			
			int height = Integer.parseInt(st.nextToken()); //높이, 행
			int width = Integer.parseInt(st.nextToken()); //너비, 열
			int queue = Integer.parseInt(st.nextToken()); //손님 순서
			
			int[][] hotel = new int [height+1][width+1];
			
			int j = 0;
			int k = 0;
			int count=0;
			loop:
			for (k=1;k<=width;k++) {
				for (j=1;j<=height;j++) {
					count++;
					hotel[j][k]=count;
					if (count==queue) { //1부터 센 후 손님 순서와 일치하게 되면 break
						break loop;
					}
				}
			}
								
			System.out.println(100*j+k);
			
		}
		
	}

}
