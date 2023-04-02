package algorithms.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Fibonacci { //0,1,1,2,3,5,8,13...

    public static int rCount; //재귀 count
    public static int dCount; //dp count
    public static int[] dArray; //메모이제이션 배열

    public static int recurFib(int n){ //재귀
        if (n==1||n==2){
            rCount++;
            return 1;
        }

        return recurFib(n-1) + recurFib(n-2);
    }

    public static int dpFib(int n){ //동적 계획법
        dArray[1]=dArray[2]=1; //dp 메모이제이션 배열에 피보나치 초기 숫자 입력

        for (int i=3;i<=n;i++){
            dArray[i]=dArray[i-1]+dArray[i-2]; //앞 숫자 두개 합산 반복
            dCount++;
        }

        return dArray[n];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); //구할 피보나치 수
        dArray = new int[n+1];
        recurFib(n);
        dpFib(n);

        System.out.println(rCount+" "+dCount);
    }

}
