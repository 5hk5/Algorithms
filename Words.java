package javaPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Words {

	public static void main(String[] args) throws NumberFormatException, IOException {

		//���ڿ� �� �ܾ� ���� (�ߺ� ����)
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		System.out.println(st.countTokens());
		
	}

}
