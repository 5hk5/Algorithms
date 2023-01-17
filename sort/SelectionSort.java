package algorithms.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SelectionSort {

    public static void sort (int count, int[] numbers){
        //선택 정렬
        //매 루프마다 최솟값 찾아 순차 배치
        int temp;
        for (int i=0;i<count-1;i++){ //비교 기준
            for (int j=i+1;j<count;j++){ //비교할 숫자들
                if (numbers[i]>numbers[j]){
                    temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        //N개의 수 오름차 정렬 (선택정렬 사용)
        //1 ≤ N ≤ 1,000, 숫자 증복 X
        //1번째 입력값은 숫자들 개수(N), 그 이후 입력값은 숫자들

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(br.readLine());

        //입력 숫자들 배열에 대입
        int[] numbers = new int[count];
        for (int i=0;i<count;i++){
            numbers[i] = Integer.parseInt(br.readLine());
        }

        //정렬 실행
        sort(count, numbers);

        for (int i=0;i<count;i++){
            System.out.println(numbers[i]);
        }

    }

}