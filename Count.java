package javaPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Count {

	public static void main(String[] args) throws IOException {
		//대소문자 구분없이 입력값 중 가장 많이 사용된 알파벳 출력 (대문자로)
		//여러 알파벳 존재 시 ? 출력
		
		BufferedReader sb = new BufferedReader(new InputStreamReader(System.in));
		String input=sb.readLine().toUpperCase(); //입력값
		
		int[] alphabet = new int[26]; //개수 셀 알파벳 배열 (인덱스 = 아스키코드)
		
		//문자열 내 각 알파벳을 아스키코드로 변환, 알파벳 배열에 개수 count 
		for (int i=0; i<input.length();i++) {
			char charInput=input.charAt(i);
			alphabet[charInput-'A']++;
		}
		
		//알파벳 배열 내 최댓값 구하기
		int max=0;
		int index=0;
		for (int i=0;i<alphabet.length;i++) {
			if(max<alphabet[i]) {
				max=alphabet[i];
				index=i;
			}
		}
		
		//최댓값 개수 구하기
		int count=0;
		for (int i=0;i<alphabet.length;i++) {
			if (alphabet[i]==max) {
				count++;
			}
		}
		
		//최댓값 1개시 대문자 출력, 2개 이상시 ? 출력
		if (count>1) {
			System.out.println("?");
		} else {
			System.out.println((char)(index+'A'));
		}

	}

}
