package algorithms.dataStructure.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Queue{

    //입력값 1 : 명령 수
    //입력값 2 : 명령들
    /*
    push X - 큐에 X 저장 (X는 정수, 1<=X<=100,000)
    pop - 큐 가장 앞 정수 삭제 후 출력, 없으면 -1 출력
    size - 큐 정수 개수 출력
    empty - 큐 비어 있으면 1, 아니면 0 출력
    front - 큐 가장 앞 정수 출력, 없으면 -1 출력
    back - 큐 가장 뒤 정수 출력, 없으면 -1 출력
    */

    public static int[] numbers; //정수 배열 (큐)

    public static int size = 0; //큐 원소 개수
    public static int front = 0; //큐 맨앞 인덱스
    public static int back = 0; //큐 맨뒤 인덱스 + 1

    public static StringBuilder sb = new StringBuilder();

    public static void push(int X){
        numbers[back]=X;
        size++; //원소 개수 증가
        back++; //맨뒤 정수 가리키는 인덱스 증가
    }

    public static void pop(){
        if (size==0){ //큐에 원소 없으면
            sb.append(-1).append("\n");
        } else {
            sb.append(numbers[front]).append("\n");
            numbers[front]=0; //제일 앞 정수 삭제 (0 대입)
            size--; //원소 개수 감소
            front++; //맨 앞 정수 가리키는 인덱스 1 증가
        }
    }

    public static void size(){
        sb.append(size).append("\n");
    }

    public static void empty(){
        if (size==0){
            sb.append(1).append("\n");
        } else {
            sb.append(0).append("\n");
        }
    }

    public static void front(){
        if (size==0){
            sb.append(-1).append("\n");
        } else {
            sb.append(numbers[front]).append("\n"); //맨앞 정수
        }
    }

    public static void back(){
        if (size==0){
            sb.append(-1).append("\n");
        } else {
            sb.append(numbers[back-1]).append("\n"); //맨뒤 정수
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); //명령 수

        numbers = new int[N];

        for (int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            switch (st.nextToken()){ //입력한 명령 꺼내기
                case "push" :
                    push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop" :
                    pop();
                    break;
                case "size" :
                    size();
                    break;
                case "empty" :
                    empty();
                    break;
                case "front" :
                    front();
                    break;
                case "back" :
                    back();
                    break;
                default :
                    break;
            }
        }

        System.out.print(sb);

    }

}
