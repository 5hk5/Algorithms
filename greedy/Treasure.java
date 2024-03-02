package algorithms.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Treasure {
    // S = A[0] × B[0] + ... + A[N-1] × B[N-1]
    // S 최소값 구하기
    // 입력 1 : N (원소 개수, 0<=N<=50) / 입력 2 : A 원소들 (0<=a<=100) / 입력 3 : B 원소들 ((0<=b<=100))
    // 출력 : S 최소값

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] A = new int[N];
        int[] B = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i=0;i<N;i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        for (int i=0;i<N;i++){
            B[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);
        Arrays.sort(B);

        int S = 0;
        for (int i=0;i<N;i++){
            S += A[i] * B[N-1-i];
        }

        System.out.println(S);
    }

}
