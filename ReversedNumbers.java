package javaPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReversedNumbers {

	public static void main(String[] args) throws IOException {

		//입력값(세자리 수)을 거꾸로 정렬한 후 크기 비교 => 큰 숫자 출력
		//ex. 734 893 입력 => 437 출력
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" "); //숫자 분리
		
		StringBuilder sb = new StringBuilder();
		int[] num = new int[2];
		for (int j=0;j<=1;j++) {
			for (int i=2;i>=0;i--) {
				sb.append(input[j].charAt(i)); //뒷자리부터 버퍼에 넣기
			}
			num[j]=Integer.parseInt(sb.toString()); //정수 배열에 새로 추가
			sb.delete(0, 3); //버퍼 클리어
		}
		
		System.out.println(num[0]>num[1]?num[0]:num[1]);
		
	}

}