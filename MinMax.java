package javaPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MinMax {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int total=Integer.parseInt(br.readLine()); //첫번째 input		
		StringTokenizer st= new StringTokenizer(br.readLine()," "); //두번째 input
		
		int max=-1000000;
		int min=1000000;
		int number;
		while(st.hasMoreTokens()) {
			number=Integer.parseInt(st.nextToken());
			if (number>max) {
				max=number;
			}
			if (number<min) {
				min=number;
			}			
		}
		
		System.out.println(min+" "+max);
		
	}

}
