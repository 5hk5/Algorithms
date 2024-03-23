package javaPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Multiply {

	public static void main(String[] args) throws NumberFormatException, IOException {

		//�Է°�: ���� ���ڸ� �� 2��
		//��°�: ���� ���� ��� ���� (3��) & ���� �ջ갪
		
		/* ex.
		*   472 �Է°�1
		* x 385 �Է°�2
		*-------
		*  2360 ��°�1
		* 3776  ��°�2
		*1416   ��°�3
		*-------
		*181720 ��°�4
		*/
		
		//�Է°� : �ڸ������� �ϳ��� ���� ����ؾ� �ϴ� num2�� �״�� ���ڿ� ������, �Ѳ����� ����ȯ�� ����ص� �Ǵ� num1�� ���� ������ ����
		//��°� 1~3 : �ݺ��� => num2 �ε������� num1�� ���� & ��� 
		//��°� 4 : num1 * num2
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num1=Integer.parseInt(br.readLine());
		String num2=br.readLine();		
		
		for (int i=2;i>=0;i--) {
			int output=Integer.parseInt(num2.substring(i, i+1)) * num1; 
			System.out.println(output);
		}
		
		System.out.println(num1*Integer.parseInt(num2));
		
	}

}