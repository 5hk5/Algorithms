package javaPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReversedNumbers {

	public static void main(String[] args) throws IOException {

		//�Է°�(���ڸ� ��)�� �Ųٷ� ������ �� ũ�� �� => ū ���� ���
		//ex. 734 893 �Է� => 437 ���
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" "); //���� �и�
		
		StringBuilder sb = new StringBuilder();
		int[] num = new int[2];
		for (int j=0;j<=1;j++) {
			for (int i=2;i>=0;i--) {
				sb.append(input[j].charAt(i)); //���ڸ����� ���ۿ� �ֱ�
			}
			num[j]=Integer.parseInt(sb.toString()); //���� �迭�� ���� �߰�
			sb.delete(0, 3); //���� Ŭ����
		}
		
		System.out.println(num[0]>num[1]?num[0]:num[1]);
		
	}

}