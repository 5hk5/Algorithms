package algorithms.priorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class MinHeap {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); //테스트케이스 수

        PriorityQueue<Integer> q = new PriorityQueue<>();

        for (int i=0;i<N;i++){
            int input = Integer.parseInt(br.readLine()); //입력값

            if (input>0){ //0 초과 시 큐에 삽입
                q.add(input);
            }

            if (input==0){ //0일 때
                if (q.isEmpty()){ //큐 비면 0 출력
                    System.out.println(0);
                } else {  //가장 작은 값 출력
                    System.out.println(q.poll());
                }
            }
        }

    }

}
