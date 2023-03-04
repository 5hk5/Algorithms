package algorithms.bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BlackJack {

    //블랙잭 => 제시된 숫자가 M일 때, 여러 숫자들 사이 3개 총합이 M에 가장 가깝되 M보다 크지 않은 숫자가 선택됨
    //입력값 1 : N M (N: 숫자 개수, M: 최대 총합)
    //입력값 2 : N개의 숫자들 ex. 1 4 6 3 2
    //출력값 : 3개 숫자 조합의 총합(M 이하) 중 최대값
    //숫자 조합 ex. 5개 - 012, 013, 014, 023, 024, 034, 123, 124, 134, 234 (인덱스)

    public static int blackjack(int[] numbers, int N, int M){
        int result=0;

        for (int i=0;i<N-2;i++){
            for (int j=i+1;j<N-1;j++){
                for (int k=j+1;k<N;k++){
                    int sum = numbers[i]+numbers[j]+numbers[k];

                    if (sum==M){ //숫자 총합이 M과 일치하면 바로 해당 값 리턴
                        return sum;
                    }

                    if (sum<M && sum>result){ //숫자 총합이 M보다 작고 result에 대입된 값보다 클 때(최대값)
                        result = sum;
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input1 = br.readLine();
        String input2 = br.readLine();

        StringTokenizer st = new StringTokenizer(input1);
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int numbers[] = new int[N];
        st = new StringTokenizer(input2);
        for (int i=0;i<N;i++){
            numbers[i]=Integer.parseInt(st.nextToken());
        }

        System.out.println(blackjack(numbers, N, M));
    }

}
