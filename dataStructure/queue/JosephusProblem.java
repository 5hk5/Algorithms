package algorithms.dataStructure.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class JosephusProblem {

    /*
    * 1~N 순번의 원순열에서 K번째 숫자 삭제 반복 -> 전체 숫자 삭제
    * 입력값 : N K
    * 출력값 : 삭제되는 숫자들
    *
    * ex.
    * 입력 : 7 3
    * 출력 : <3, 6, 2, 7, 5, 1, 4>
    * */
    public static StringBuilder sb = new StringBuilder();

    public static Queue<Integer> queue = new LinkedList<>(); //1~N 큐

    public static int count = 0; //요세푸스 함수 호출 count

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        //1~N 숫자 존재하는 원순열(큐) 생성
        for (int i=1;i<=N;i++){
            queue.add(i);
        }

        //큐 empty될 때까지 K번째 수 삭제
        while (!queue.isEmpty()){
            josephus(N, K);
        }

        System.out.println("<" + sb + ">");
    }

    public static void josephus(int N, int K){
        count++;

        for (int i=1;i<K;i++){ //1 ~ K-1번째 숫자 삭제 -> 큐 뒤에 새로 삽입
            queue.offer(queue.poll());
        }

        //K번째 숫자 제거
        if (count<N){
            sb.append(queue.poll()).append(", ");
        } else {
            sb.append(queue.poll());
        }
    }

}
