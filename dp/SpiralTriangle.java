package algorithms.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SpiralTriangle {

    //정삼각형을 나선 모양으로 놓음 (정삼각형 변 길이 증가)
    //입력값 1 : 테스트 개수
    //입력값 2 : N (N번째 삼각형 변 길이)
    //ex. 1, 1, 1, 2, 2, 3, 4, 5, 7, 9, 12, 16
    //규칙 : 연속하는 두 숫자 합산값 = 다다음 숫자  규칙 찾기는 역시 재밌다

    public static long[] dp = new long[100];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); //테스트 개수

        //dp 배열에 base case 미리 대입 (0부터 시작 => 인덱스는 입력값-1)
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 1;

        //dp 배열에 규칙에 따른 숫자들 모두 대입
//        measureLengths();

        StringBuilder sb = new StringBuilder();
        for (int i=0;i<N;i++){
//            sb.append(dp[Integer.parseInt(br.readLine())-1]).append("\n");
            sb.append(measureLengthsRecur(Integer.parseInt(br.readLine()))).append("\n");
        }

        System.out.println(sb);
    }

    //반복문
    public static void measureLengths(){
        for (int i=3;i<100;i++){
            dp[i] = dp[i-2] + dp[i-3];
        }
    }

    //재귀함수
    public static long measureLengthsRecur(int input){ //입력값
        if (dp[input-1]==0){ //dp 배열에 찾는 입력값이 비어 있으면
            dp[input-1] = measureLengthsRecur(input-2) + measureLengthsRecur(input-3); //하나 건너뛴 앞 두 숫자 합 구해 대입
        }

        return dp[input-1];
    }

}
