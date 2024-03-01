package algorithms.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Change { // 거스름돈
    // 1000엔 거스름돈 구하기 (잔돈: 500, 50, 10, 5, 1)
    // 입력 : 지불 금액 (1~999)
    // 출력 : 잔돈 "최소" 개수

    public static void main(String[] args) throws IOException {
        int[] coinValue = {500, 100, 50, 10, 5, 1};

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int paidMoney = Integer.parseInt(br.readLine());
        int change = 1000 - paidMoney;

        System.out.println(changeCoins(coinValue, change));
    }

    private static int changeCoins(int[] coinValue, int change) {
        int countCoins = 0;

        for (int i=0;i<coinValue.length;i++){
            if (change >= coinValue[i]){
                countCoins += change / coinValue[i];
                change %= coinValue[i];
            }
        }

        return countCoins;
    }

}
