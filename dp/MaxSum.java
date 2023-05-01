package algorithms.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class MaxSum {

    //숫자 연속되는 구간 중에서 최대합 구하기

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); //입력값 1 : 정수 개수

        StringTokenizer st = new StringTokenizer(br.readLine()); //입력값 2 : 정수들

        int[] numbers = new int[n]; //입력한 정수 배열

        for (int i=0;i<n;i++){
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(maxSum(numbers)); //출력값 : 연속되는 숫자 최대합
    }

    public static int maxSum(int[] numbers){ //ex. [10, -4, 3, 1, 5, 6, -35, 12, 21, -1]
        int[] dp = new int[numbers.length];

        dp[0] = numbers[0];
        int max = numbers[0];

        for (int i=1; i< dp.length;i++){
            dp[i] = Math.max(dp[i-1]+numbers[i], numbers[i]); //기존 누적합보다 큰 입력값 있으면 누적합 새로 시작
            //ex. [10, 6, 9, 10, 15, 21, -14, 12, 33, 32]

            max = Math.max(max, dp[i]);
        }

        return max;
    }

}
