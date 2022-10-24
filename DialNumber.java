package javaPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DialNumber {

	public static void main(String[] args) throws IOException {
		//입력값 : 알파벳 문자열 / 출력값 : 각 알파벳(숫자)에 배정된 최소시간 합산해 출력
		//알파벳-숫자 매칭 : ABC-2 / DEF-3 / .. / TUV-8 / WXYZ-9
		//최소시간=숫자+1
		
		//switch문 사용해 각 알파벳에 해당하는 숫자 합산변수에 더하기
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String alphabets = br.readLine();
		
		int sum=0;
		for (int i=0; i<alphabets.length();i++) {
			switch(alphabets.charAt(i)) {
				case 'A': case 'B': case 'C':
					sum+=3;
					break;
				case 'D': case 'E': case 'F':
					sum+=4;
					break;
				case 'G': case 'H': case 'I':
					sum+=5;
					break;
				case 'J': case 'K': case 'L':
					sum+=6;
					break;
				case 'M': case 'N': case 'O':
					sum+=7;
					break;
				case 'P': case 'Q': case 'R': case 'S':
					sum+=8;
					break;
				case 'T': case 'U': case 'V':
					sum+=9;
					break;
				case 'W': case 'X': case 'Y': case 'Z':
					sum+=10;
					break;
			}
		}
		
		System.out.println(sum);
		
	}

}
