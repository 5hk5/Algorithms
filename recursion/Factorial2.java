package algorithms.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Factorial2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Integer.parseInt(br.readLine()); //팩토리얼 구할 정수

        System.out.println(factorial(N));
    }

    public static long factorial(long N){
        if (N<=1){ //base condition
            return 1;
        }

        return factorial(N-1) * N;
    }

}
