package javaPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sum7 {

	public static void main(String[] args) throws IOException {

		//첫번째 입력값 : 더할 숫자 개수
		//두번째 입력값 : 더할 한자리 숫자들 (공백 X)
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br.readLine();
		
		int sum = 0;
		for (byte num : br.readLine().getBytes()) { //나열된 숫자를 각각 바이트 배열에 추가
			sum += num - '0'; //아스키코드 '0' = 48
		}
		
		System.out.println(sum);
		
	}

}
