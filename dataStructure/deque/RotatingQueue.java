package algorithms.dataStructure.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class RotatingQueue {

    public static LinkedList<Integer> deque = new LinkedList<Integer>();

    public static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input1 = br.readLine();
        StringTokenizer st = new StringTokenizer(input1);

        int N = Integer.parseInt(st.nextToken()); //덱 개수
        int M = Integer.parseInt(st.nextToken()); //선택할 숫자 개수

        //덱에 1~N까지 숫자 채우기
        for (int i=1;i<=N;i++){
            deque.offer(i);
        }

        String input2 = br.readLine(); //선택할 숫자들
        st = new StringTokenizer(input2);



        for (int i=0;i<M;i++) {

            //중간 인덱스 지정
            int halfIndex;
            if (deque.size() % 2 == 0){
                halfIndex = deque.size()/2 - 1;
            } else {
                halfIndex = deque.size()/2;
            }

            int number = Integer.parseInt(st.nextToken()); //선택한 숫자
            int index = deque.indexOf(number); //선택한 숫자의 인덱스

            //중간 인덱스 활용해 왼쪽 또는 오른쪽으로 배열 밀기
            if (index == 0){ //맨 앞 인덱스면 바로 꺼냄
                pop();
            } else if (index <= halfIndex){ //선택한 숫자 인덱스가 중간 인덱스보다 앞 or 중간인덱스와 일치할 때
                toLeft(index);
                pop();
            } else {
                toRight(index);
                pop();
            }

        }

        System.out.println(count);

    }

    public static void pop(){ //맨 앞 숫자 꺼내기
        deque.pollFirst();
    }

    public static void toLeft(int index){
        for (int i=0;i<index;i++){
            int temp = deque.pollFirst(); //인덱스 앞 숫자들을 꺼내
            deque.offerLast(temp); //덱 뒤에 넣음
            count++;
        }
    }

    public static void toRight(int index){
        for (int i=0;i<deque.size()-index;i++){
            int temp = deque.pollLast(); //인덱스 뒤 숫자들을 꺼내
            deque.offerFirst(temp); //덱 앞에 넣음
            count++;
        }
    }

}