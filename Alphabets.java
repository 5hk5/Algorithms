package javaPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Alphabets {

	public static void main(String[] args) throws IOException {

		//�Է°� : ���ĺ� �ҹ��ڵ�
		//��°� : ���ĺ��� �ε��� (���ĺ� �������, �������� ����, null => -1)
		//ex. baekjoon => 1 0 -1 -1 2 -1 -1 -1 -1 4 3 -1 -1 7 5 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1
		
		//�Է°��� ���ڿ� ������ ����
		//for������ ���ĺ� a~z ���� �ݺ� => indexOf() ���� ���ڿ� �� ���ĺ��� �ε��� ã��
		
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
