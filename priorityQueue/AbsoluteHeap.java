package algorithms.priorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class AbsoluteHeap {

    /** 절대값 힙
     * 배열에서 절대값이 가장 작은 값 출력 후 제거
     * 입력값 1 : 테스트케이스 수
     * 입력값 2 : N개의 입력값 (0이면 절대값 제일 작은 값 출력 후 제거(빈 배열이면 0 출력), 0 아니면 배열에 해당 값 추 가)
     * 출력값 : 0 입력할 때마다 출력되는 값
     **/

    //우선순위 변경
    static PriorityQueue<Integer> queue = new PriorityQueue<>((a,b)->{
        int absA = Math.abs(a);
        int absB = Math.abs(b);

        if (absA == absB) { //절대값 같으면

            if (a<=b){ //기존값 비교
                return -1; //a가 더 작으면 a에게 높은 우선순위
            } else {
                return 1; //a가 더 크면 b에게 높은 우선순위
            }

        } else if (absA < absB) { //절대값a가 더 작으면

            return -1; //a에게 높은 우선순위

        } else { //절대값b가 더 작으면

            return 1; //b에게 높은 우선순위

        }
    });

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); //테스트케이스 수

        for (int i=0;i<N;i++){
            heap(Integer.parseInt(br.readLine())); //입력값 따라 출력 또는 삽입
        }
    }

    static void heap(int input){
        if (input==0){ //입력값 0이면 출력
            print();
        } else { //아니면 삽입
            insert(input);
        }
    }

    static void print(){
        if (queue.isEmpty()){ //큐 비었을 때 0 출력
            System.out.println(0);
        } else {
            System.out.println(queue.poll());
        }
    }

    static void insert(int num){
        queue.add(num);
    }

}
