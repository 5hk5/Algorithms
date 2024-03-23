package javaPractice;

import java.util.Arrays;
import java.util.Random;

public class Lotto {

	public static void main(String[] args) {
		//�ζ� �迭
		int[] lotto=new int[6]; 
		int[] myNum=new int[6];
		Random rand;
		
		//�ζ� ��÷ ���� (����)
		rand=new Random(8); //���ڰ�
		System.out.print("1�� ��÷ ��ȣ : ");
		for (int i=0;i<lotto.length;i++) {
			lotto[i]=rand.nextInt(45)+1; //1~45 ���� ����	
			System.out.print(lotto[i]+" ");
		}
		
		//�� ����
		rand=new Random();
		System.out.print("\n���� �ζ� ��ȣ : ");
		for (int i=0;i<myNum.length;i++) {
			myNum[i]=rand.nextInt(45)+1;
			System.out.print(myNum[i]+" ");
		}
		
		//��÷ Ȯ��
		Arrays.sort(lotto);
		Arrays.sort(myNum);
		boolean result = Arrays.equals(lotto, myNum);
		System.out.println("\n\n***��÷ ���***");
		if (result) {
			System.out.println("1� ��÷�Ǽ̽��ϴ�");
		}else {
			System.out.println("��");
		}
		
		
	}

}
