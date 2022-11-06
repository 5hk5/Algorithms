package javaPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Snail {

	public static void main(String[] args) throws IOException {
		
		//달팽이 문제
		//달팽이는 높이 V미터를 낮에 A미터 올라갔다 밤에 B미터 내려감
		//정상에 도착할 때까지 걸리는 일수
		
		//입력값 : A B V (공백 구분)
		//출력값 : 정상 도착까지 걸린 일수
		
		//하루에 갈 수 있는 높이 = A-B or A (마지막 날)
		//총 높이 V-B <= (A-B) * 일수
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();
		
		StringTokenizer st = new StringTokenizer(input," ");
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		
		int output = (V-B)/(A-B);
		if ((V-B)%(A-B)!=0) {
			output++;
		}
		
		System.out.println(output);
		
	}

}
