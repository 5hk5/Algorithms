package javaPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Count {

	public static void main(String[] args) throws IOException {
		//��ҹ��� ���о��� �Է°� �� ���� ���� ���� ���ĺ� ��� (�빮�ڷ�)
		//���� ���ĺ� ���� �� ? ���
		
		BufferedReader sb = new BufferedReader(new InputStreamReader(System.in));
		String input=sb.readLine().toUpperCase(); //�Է°�
		
		int[] alphabet = new int[26]; //���� �� ���ĺ� �迭 (�ε��� = �ƽ�Ű�ڵ�)
		
		//���ڿ� �� �� ���ĺ��� �ƽ�Ű�ڵ�� ��ȯ, ���ĺ� �迭�� ���� count 
		for (int i=0; i<input.length();i++) {
			char charInput=input.charAt(i);
			alphabet[charInput-'A']++;
		}
		
		//���ĺ� �迭 �� �ִ� ���ϱ�
		int max=0;
		int index=0;
		for (int i=0;i<alphabet.length;i++) {
			if(max<alphabet[i]) {
				max=alphabet[i];
				index=i;
			}
		}
		
		//�ִ� ���� ���ϱ�
		int count=0;
		for (int i=0;i<alphabet.length;i++) {
			if (alphabet[i]==max) {
				count++;
			}
		}
		
		//�ִ� 1���� �빮�� ���, 2�� �̻�� ? ���
		if (count>1) {
			System.out.println("?");
		} else {
			System.out.println((char)(index+'A'));
		}

	}

}
