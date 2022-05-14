package javaPractice;

import java.util.Arrays;
import java.util.Random;

public class Lotto {

	public static void main(String[] args) {
		//로또 배열
		int[] lotto=new int[6]; 
		int[] myNum=new int[6];
		Random rand;
		
		//로또 당첨 숫자 (고정)
		rand=new Random(8); //종자값
		System.out.print("1등 당첨 번호 : ");
		for (int i=0;i<lotto.length;i++) {
			lotto[i]=rand.nextInt(45)+1; //1~45 랜덤 리턴	
			System.out.print(lotto[i]+" ");
		}
		
		//내 숫자
		rand=new Random();
		System.out.print("\n나의 로또 번호 : ");
		for (int i=0;i<myNum.length;i++) {
			myNum[i]=rand.nextInt(45)+1;
			System.out.print(myNum[i]+" ");
		}
		
		//당첨 확인
		Arrays.sort(lotto);
		Arrays.sort(myNum);
		boolean result = Arrays.equals(lotto, myNum);
		System.out.println("\n\n***추첨 결과***");
		if (result) {
			System.out.println("1등에 당첨되셨습니다");
		}else {
			System.out.println("꽝");
		}
		
		
	}

}
