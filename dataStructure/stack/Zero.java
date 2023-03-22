package algorithms.dataStructure.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Zero {

    //입력값들 합 구하기
    //단, 0 입력시 가장 최근 입력값은 합에서 제외
    //=Stack

    //입력값 1: 입력값 개수
    //입력값 2: 스택에 저장할 입력값들
    //출력값 : 스택에 저장된 입력값의 합

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine()); //입력값 개수

        Stack<Integer> numbers = new Stack<>(); //입력값 저장할 스택
        for (int i=0;i<K;i++){
            int number = Integer.parseInt(br.readLine()); //각 입력값 숫자

            if (number==0){ //0이면 스택에서 가장 최근값 삭제
                numbers.pop();
            } else {
                numbers.push(number); //스택에 저장
            }
        }

        int sum=0;
        for (int i : numbers){
            sum += i; //스택 값 합산
        }

        System.out.println(sum);

    }

}
