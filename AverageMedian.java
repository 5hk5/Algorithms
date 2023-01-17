package algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AverageMedian {

    //입력값: 숫자 5개 (100 미만인 10의 배수)
    //출력값: 평균, 중앙값
    //카운팅 정렬

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] input = new int[5]; //입력값 배열
        int[] countArray = new int[9]; //카운팅 배열 //10,20,..,90
        int[] result = new int[5]; //결과 배열

        //입력값 배열, 카운팅 배열에 추가
        for (int i=0;i<input.length;i++){
            input[i] = Integer.parseInt(br.readLine())/10-1; //30, 50, 90, 10, 70 => 2, 4, 8, 0, 6
            countArray[input[i]]++; //1,0,1,0,1,0,1,0,1
        }

        //카운팅 배열 => 누적합으로 수정
        for (int i=1;i<countArray.length;i++){
                countArray[i] += countArray[i-1]; //1,1,2,2,3,3,4,4
        }

        //카운팅배열 값-- & 결과배열[카운팅배열 값]에 카운팅배열 인덱스 대입
        for (int i=input.length-1;i>=0;i--){ //입력값 뒷인덱스부터 진행
            countArray[input[i]]--;
            result[countArray[input[i]]]=input[i]; // 0,2,4,6,8
        }

        //중앙값
        int med = (result[2]+1)*10;

        //평균
        int total=0;
        for (int i=0;i<input.length;i++){
            total+=(input[i]+1)*10;
        }
        int avg = total/5;

        System.out.println(avg);
        System.out.println(med);

    }

}
