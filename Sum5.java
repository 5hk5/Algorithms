package javaPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sum5 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while(true) {
			st=new StringTokenizer(br.readLine()," "); //���� ���� �и�
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			if (num1==0 && num2==0) { //���� (0,0)�� �� ����� ����
				break;
			}
			System.out.println(num1+num2); 
		}

	}

}
