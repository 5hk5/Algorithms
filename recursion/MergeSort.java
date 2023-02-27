package algorithms.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MergeSort {

    //병합정렬 : 크기 1 될 때까지 절반씩 분할 -> 인접한 숫자 비교, 정렬하면서 합쳐나감

    static int order, count, result;

    static int numbers[], tmp[];


    public static void mergeSort(int[] numbers, int left, int right){ //병합정렬

        if (left<right) { //base condition - 원소가 2개 남을 때까지 진행
            int mid = (left + right) / 2;

            mergeSort(numbers, left, mid); //왼쪽 분할
            mergeSort(numbers, mid+1, right); //오른쪽 분할
            merge(numbers, left, mid, right);//병합
        }

    }

    public static void merge(int[] numbers, int left, int mid, int right){ //병합

        int l = left; //왼쪽정렬 시작점
        int r = mid+1; //오른쪽정렬 시작점
        int t = left; //temp 임시 배열 인덱스

        //오름차순 정렬 (한쪽 정렬 끝날 때까지)
        while (l<=mid && r<=right){
            if (numbers[l]<=numbers[r]){
                tmp[t++] = numbers[l++];
            } else {
                tmp[t++] = numbers[r++];
            }
        }

        //한쪽이 먼저 정렬 끝나면
        if (l>mid){ //왼쪽 배열 모두 정렬됐을 때 => 오른쪽 배열 남을 때
            while (r <= right){
                tmp[t++] = numbers[r++]; //남은 오른쪽 배열 원소들을 임시 배열에 모두 대입
            }
        } else { //왼쪽 배열 남을 때
            while (l <= mid) {
                tmp[t++] = numbers[l++]; //남은 왼쪽 배열 원소들을 임시 배열에 모두 대입
            }
        }

        //임시 배열 -> 정렬 배열 삽입
        for (l=left;l<=right;l++){
            numbers[l] = tmp[l];
            if (++count==order){ //입력값 횟수만큼 배열에 저장됐을 때
                result=numbers[l];
                break;
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine(); //입력값 1 : 숫자들 개수 + 저장된 순서
        String input2 = br.readLine(); //입력값 2 : 정렬할 숫자들

        StringTokenizer st = new StringTokenizer(input);
        int size = Integer.parseInt(st.nextToken()); //정렬할 숫자 개수
        order = Integer.parseInt(st.nextToken()); //배열에 저장되는 순서

        StringTokenizer st2 = new StringTokenizer(input2);
        for (int i=0;i<size;i++) {
            numbers[i] = Integer.parseInt(st2.nextToken());
        }
        tmp = new int[size]; //임시 배열
        numbers = new int[size]; //정렬 배열

        mergeSort(numbers, 0, size-1);

        if (order>count){ //입력값(저장 순서)이 총 저장 횟수보다 크면
            result=-1;
        }

        System.out.println(result); //출력값 : 새 배열(합병 정렬)에 N번째 저장되는 숫자
    }

}
