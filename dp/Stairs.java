package algorithms.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Stairs {

    /* 올라간 계단 점수 누적합의 최대값 구하기
    * 1. 한번에 1 or 2계단씩 오름
    * 2. 연속 3 계단 오를 수 없음 (시작점은 계단 X)
    * 3. 마지막 도착 계단 반드시 밟음
    *
    * n번째 계단 밟는 경우 => n-3, n-1, n 또는 n-2, n
    *
    */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); //계단 수

        int[] stairs = new int[N+1]; //각 계단 점수
        int[] sum = new int[N+1]; //각 계단까지의 누적합

        for (int i=1;i<=N;i++){
            stairs[i] = Integer.parseInt(br.readLine());
        }

        sum[1] = stairs[1];

        if (N>=2) sum[2] = stairs[1] + stairs[2];

        for (int i=3;i<=N;i++){
            sum[i] = Math.max(sum[i-3]+stairs[i-1], sum[i-2]) + stairs[i];
        }

        System.out.println(sum[N]);
    }

}
