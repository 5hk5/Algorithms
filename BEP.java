package javaPractice;

import java.util.Scanner;

public class BEP {  //���ͺб��� ����

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long fixedCost = sc.nextLong();  //�������
		long variableCost = sc.nextLong();  //�������
		long price = sc.nextLong();  //����
		
		if (price<=variableCost) {  //1�� ������ ���������� ������ ���ͺб��� ���� ����
			System.out.println(-1);
		}else {
			long overallSalesVolume = fixedCost/(price-variableCost)+1;  //���ͺб��� �Ǹŷ� ����
			System.out.println(overallSalesVolume);
		}
	}
}