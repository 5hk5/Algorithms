package algorithms.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Fibonacci {
    //입력값 : n
    //출력값 : n번째 피보나치 수
    //0<=n<=20 (n은 정수)
    //피보나치 수열 ex. 0,1,1,2,3,5,8,13, .. (앞에 있는 두 수의 합이 다음 값)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int result = fibo(n);

        System.out.println(result);
    }

    public static int fibo(int n){
        if (n==0) return 0;
        if (n==1) return 1;
        return fibo(n-2) + fibo(n-1); //앞 두 수의 합
    }

    // fibo(4)
    // => fibo(2)+fibo(3)
    // => fibo(0)+fibo(1) + fibo(1)+fibo(2)
    // => 0+1 + 1 + fibo(0)+fibo(1)
    // => 0+1 + 1 + 0 + 1
    // = 2
}
