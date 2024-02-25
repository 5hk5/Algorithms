package algorithms.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class LIS2 {

    public static void main(String[] args) throws IOException {
        // 입력값 배열 length
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 입력값 배열
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] seq = new int[N];
        for (int i=0;i<N;i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

        // lis 연산
        System.out.println(lis(seq, N));
    }

    private static int lis(int[] seq, int N) {
        int[] lis = new int[N]; // 가상의 최장부분수열 (오름차순)
        lis[0] = seq[0];

        int lastIndex = 0; // lis에 업데이트된 마지막 인덱스
        for (int i=1;i<N;i++){
            if (seq[i] > lis[lastIndex]){ // 입력값이 lis에 저장된 마지막 값보다 크면
                lis[++lastIndex] = seq[i]; // 이어서 저장
            } else {
                lis[binarySearch(lis, 0, lastIndex, seq[i])] = seq[i]; // lis 이진 탐색 후 적절한 위치에 입력값 덮어쓰기
            }
        }

        return lastIndex + 1; // lis 개수
   }

   private static int binarySearch(int[] lis, int left, int right, int target){
        int mid;

        while (left < right){
            mid = (left + right) / 2;

            if (target > lis[mid]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return right; // 새로 대입할 위치 (lis 인덱스)
   }

}