package javaPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Remainder {

	public static void main(String[] args) throws NumberFormatException, IOException {

		//숫자 10개 입력받은 후, 42로 나눴을 때 서로 다른 나머지값 개수(종류) 출력 (모두 같으면 1)
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashSet<Integer> hs = new HashSet<Integer>();
		
		for (int i=0;i<10;i++) {
			hs.add(Integer.parseInt(br.readLine())%42);
		}

		System.out.println(hs.size());		
		
	}

}
