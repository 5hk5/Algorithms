package javaPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Alphabets {

	public static void main(String[] args) throws IOException {

		//입력값 : 알파벳 소문자들
		//출력값 : 알파벳당 인덱스 (알파벳 순서대로, 공백으로 구분, null => -1)
		//ex. baekjoon => 1 0 -1 -1 2 -1 -1 -1 -1 4 3 -1 -1 7 5 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1
		
		//입력값을 문자열 변수로 받음
		//for문으로 알파벳 a~z 까지 반복 => indexOf() 통해 문자열 내 알파벳들 인덱스 찾기
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String alphabets = br.readLine();
		
		String output="";
		for (int i=97;i<=122;i++) { //a~z
			int index=alphabets.indexOf(i);
			output+=index+" ";
		}
		
		System.out.println(output);
		
	}

}
