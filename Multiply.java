package javaPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Multiply {

	public static void main(String[] args) throws NumberFormatException, IOException {

		//입력값: 곱할 세자리 수 2개
		//출력값: 세로 곱셈 계산 과정 (3행) & 최종 합산값
		
		/* ex.
		*   472 입력값1
		* x 385 입력값2
		*-------
		*  2360 출력값1
		* 3776  출력값2
		*1416   출력값3
		*-------
		*181720 출력값4
		*/
		
		//입력값 : 자리수마다 하나씩 빼서 계산해야 하는 num2는 그대로 문자열 변수에, 한꺼번에 형변환해 계산해도 되는 num1은 정수 변수에 넣음
		//출력값 1~3 : 반복문 => num2 인덱스별로 num1과 곱함 & 출력 
		//출력값 4 : num1 * num2
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num1=Integer.parseInt(br.readLine());
		String num2=br.readLine();		
		
		for (int i=2;i>=0;i--) {
			int output=Integer.parseInt(num2.substring(i, i+1)) * num1; 
			System.out.println(output);
		}
		
		System.out.println(num1*Integer.parseInt(num2));
		
	}

}