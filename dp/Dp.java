package algorithms.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Dp {

    //재귀 => dp 배열 이용해 성능 향상
    /*
    if a <= 0 or b <= 0 or c <= 0, then w(a, b, c) returns: 1
    if a > 20 or b > 20 or c > 20, then w(a, b, c) returns: w(20, 20, 20)
    if a < b and b < c, then w(a, b, c) returns: w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c)
    otherwise it returns: w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1)
    */

    //입력값 : a b c
    //출력값 : w(a, b, c) = X
    //ex.
    //입력 : 1 1 1
    //출력 : w(1, 1, 1) = 2

    public static int dp[][][] = new int[21][21][21]; //메모이제이션 배열 (0~20)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true){ //입력 반복
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a==-1 && b==-1 && c==-1){ //a, b, c가 모두 -1일 때 입력 마침
                break;
            }

            sb.append("w("+a+", "+b+", "+c+") = ").append(w(a, b, c)).append("\n");
        }

        System.out.println(sb);
    }

    public static int w(int a, int b, int c){
        //메모이제이션 된 경우
        if (0<=a && 0<=b && 0<=c && a<=20 && b<=20 && c<=20 && dp[a][b][c]!=0){
            return dp[a][b][c]; //저장된 값 반환
        }

        if (a<=0 || b<=0 || c<=0){
            return 1;
        }

        if (a>20 || b>20 || c>20) {
            return dp[20][20][20] = w(20,20,20); //dp 배열에 저장
        }

        if (a<b && b<c){
            return dp[a][b][c] = w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c); //dp 배열 저장
        }

        return dp[a][b][c] = w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1);
    }

}
