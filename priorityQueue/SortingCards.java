package algorithms.priorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class SortingCards {
    //다양한 크기의 카드 묶음을 서로 비교하며 하나로 정렬할 때의 최소 비교 횟수
    //=> 크기 오름차순으로 비교했을 때 비교 횟수가 가장 적게 나옴
    //ex. 10장, 20장, 40장 세 묶음 => (10 + 20) + (30 + 40) = 100번 (작은 숫자의 묶음 먼저 비교하고 합쳐진 해당 묶음을 마지막 남은 묶음과 비교)
    //비교할 때마다 가장 작은 묶음 꺼냄 => 우선순위 큐 사용

    //입력값 1 : 테스트케이스 수
    //입력값 2 : 카드 묶음의 크기 (=가중치)
    //출력값 : 최소 비교 횟수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Long> queue = new PriorityQueue<>();
        for (int i=0;i<N;i++){
            queue.add(Long.parseLong(br.readLine()));
        }

        System.out.println(sort(queue));
    }

    static long sort(PriorityQueue<Long> queue){

        long compareCount = 0;

        while (queue.size() > 1) { //queue에 최종값 남을 때까지
            long min1 = queue.poll();
            long min2 = queue.poll();

            compareCount += min1 + min2; //가장 작은 크기의 두 카드 묶음 더한 값

            queue.add(min1 + min2);
        }

        return compareCount;

    }
}
