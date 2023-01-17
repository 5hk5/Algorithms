package algorithms.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InsertionSort {

    public static int[] sort (int count, int[] numbers){
        //삽입 정렬
        //인덱스1부터 앞 숫자들과 비교해 삽입해가며 정렬
        for (int i=1;i<count;i++){ //인덱스 1에서부터
            for (int j=0;j<i;j++){ //앞 인덱스들과 대소 비교, 삽입
                int temp;
                if (numbers[i]<numbers[j]){
                    temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }

        return numbers;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        //1번째 입력값은 숫자들 개수(N), 그 이후 입력값은 숫자들
        //1 ≤ N ≤ 1,000, 숫자 증복 X

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(br.readLine());

        //입력값들 배열에 대입
        int[] numbers = new int[count];
        for (int i=0;i<count;i++){
            numbers[i] = Integer.parseInt(br.readLine());
        }

        //정렬 실행
        int[] sortedNumbers = sort(count, numbers);

        for (int i=0;i<count;i++){
            System.out.println(sortedNumbers[i]);
        }

    }

}