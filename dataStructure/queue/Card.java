package algorithms.dataStructure.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Card {

    //1~N까지의 카드 => 맨위 1부터 바닥 N까지 쌓여있음
    //카드 한장 남을 때까지 맨위 카드 제거, 그 다음 카드는 맨아래로 옮김
    //ex. 4 => 1234 342 24 4
    //=Queue

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Queue<Integer> numbers = new LinkedList<>(); //1~N 숫자 배열
        for (int i=1;i<=N;i++){
            numbers.offer(i); //큐에 1~N 저장
        }

        for (int i=0;i<N-1;i++){
            numbers.poll(); //가장 먼저 저장된 숫자 삭제
            numbers.offer(numbers.poll()); //두번째로 저장된 숫자 삭제 후 새로 추가
        }

        System.out.println(numbers.poll()); //마지막 숫자 출력

    }

}
