package algorithms.dataStructure.prefixSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class PrefixSum {

    /*
    * 입력값 1 : N M (N: 구간 내 숫자 개수, M: 입력 반복 횟수)
    * 입력값 2 : N개 숫자들 입력
    * 그외 입력값 : i j (i~j번째 숫자 누적합)
    * */

    public static StringBuilder sb = new StringBuilder();

    public static int numbers[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //입력값 1
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        //입력값 2
        numbers = new int[N]; //누적합 배열

        st = new StringTokenizer(br.readLine());

        numbers[0] = Integer.parseInt(st.nextToken());
        for (int i=1;i<N;i++){
            numbers[i]= numbers[i-1] + Integer.parseInt(st.nextToken());
        }

        //입력값 3
        for (int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            range(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        System.out.println(sb);

    }

    public static void range(int start, int end){
        if (start==1){
            sb.append(numbers[end-1]).append("\n");
        } else {
            sb.append(numbers[end-1]-numbers[start-2]).append("\n");
        }
    }

}
