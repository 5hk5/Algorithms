package javaPractice;

import java.util.Scanner;

public class BEP {  //손익분기점 문제

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long fixedCost = sc.nextLong();  //고정비용
		long variableCost = sc.nextLong();  //가변비용
		long price = sc.nextLong();  //가격
		
		if (price<=variableCost) {  //1개 가격이 변동가보다 낮으면 손익분기점 오지 않음
			System.out.println(-1);
		}else {
			long overallSalesVolume = fixedCost/(price-variableCost)+1;  //손익분기점 판매량 계산식
			System.out.println(overallSalesVolume);
		}
	}
}