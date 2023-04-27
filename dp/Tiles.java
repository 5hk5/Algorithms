package algorithms.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Tiles {
    //00와 1로 N자리 조합 만들기
    //n=1:1, n=2:2, n=3:3, n=4:5, n=5:8,.. => 피보나치 수열 규칙
    //입력값 : N
    //출력값 : N자리 조합 경우의 수 % 15746

    public static int[] dp = new int [1000001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        //-1로 배열 초기화
        for (int i=3;i<dp.length;i++){
            dp[i]=-1;
        }

        dp[0]=0;
        dp[1]=1;
        dp[2]=2;

        System.out.println(tiles(N));
    }

    public static int tiles(int N){
        if (dp[N] == -1){ //초기화된 상태일 때
            dp[N] = (tiles(N-1) + tiles(N-2)) % 15746; //앞 두 숫자 합하기
        }

        return dp[N];
    }

}
