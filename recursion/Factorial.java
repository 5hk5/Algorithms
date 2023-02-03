package algorithms.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Factorial {
    //입력값 : 정수 N (0~12)
    //출력값 : N!

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int result = factorial(N);

        System.out.println(result);
    }

    public static int factorial(int N){
        if (N<=1) return 1; //N이 1되면 1 리턴해 루프 마무리
        return N * factorial(N-1);
    }

}
