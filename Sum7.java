package javaPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sum7 {

	public static void main(String[] args) throws IOException {

		//ù��° �Է°� : ���� ���� ����
		//�ι�° �Է°� : ���� ���ڸ� ���ڵ� (���� X)
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br.readLine();
		
		int sum = 0;
		for (byte num : br.readLine().getBytes()) { //������ ���ڸ� ���� ����Ʈ �迭�� �߰�
			sum += num - '0'; //�ƽ�Ű�ڵ� '0' = 48
		}
		
		System.out.println(sum);
		
	}

}
