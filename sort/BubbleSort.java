package algorithms.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BubbleSort {

    public static int[] sort(int count, int[] numbers){
        //버블 정렬
        //앞에서부터 인접한 숫자 두개 반복 비교
        int temp;
        for (int i=1;i<count;i++){ //숫자 개수-1만큼 루프 실행
            for (int j=0;j<count-i;j++){ //순차적으로 뒤 인덱스는 정렬에서 제외
                if (numbers[j]>numbers[j+1]){
                    temp = numbers[j];
                    numbers[j] = numbers[j+1];
                    numbers[j+1] = temp;
                }
            }
        }
        return numbers;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        //N개의 수 오름차 정렬
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
        int[] sortedNumbers = sort(count, numbers);

        for (int i=0;i<count;i++){
            System.out.println(sortedNumbers[i]);
        }

    }

}