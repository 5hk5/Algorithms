package javaPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Snail {

	public static void main(String[] args) throws IOException {
		
		//������ ����
		//�����̴� ���� V���͸� ���� A���� �ö󰬴� �㿡 B���� ������
		//���� ������ ������ �ɸ��� �ϼ�
		
		//�Է°� : A B V (���� ����)
		//��°� : ���� �������� �ɸ� �ϼ�
		
		//�Ϸ翡 �� �� �ִ� ���� = A-B or A (������ ��)
		//�� ���� V-B <= (A-B) * �ϼ�
		
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
