package algorithms.dataStructure.deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Deque {

    public static int[] deque = new int[10000]; //데크 배열 (원형으로 가정)
    public static int front; //시작 인덱스 (비우기)
    public static int back; //끝 인덱스
    public static int size;
    public static StringBuilder sb = new StringBuilder();

    public static void pushFront(int X){
        deque[front] = X;
        front = (front -1 + 10000) % 10000; //front 값 0 -> 9999 로 넘어가도록
        size++;
    }

    public static void pushBack(int X){
        back = (back + 1) % 10000;
        deque[back] = X;
        size++;
    }

    public static void popFront(){
        if (size==0){
            sb.append(-1).append("\n");
        } else {
            sb.append(deque[(front + 1) % 10000]).append("\n");
            front = (front + 1) % 10000;
            size--;
        }
    }

    public static void popBack(){
        if (size==0){
            sb.append(-1).append("\n");
        } else {
            sb.append(deque[back]).append("\n");
            back = (back -1 + 10000) % 10000;
            size--;
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
            sb.append(deque[(front +1) % 10000]).append("\n");
        }
    }

    public static void back(){
        if (size==0){
            sb.append(-1).append("\n");
        } else {
            sb.append(deque[back]).append("\n");
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); //명령 수

        for (int i=0;i<N;i++){
            String input = br.readLine();
            StringTokenizer st = new StringTokenizer(input);

            switch (st.nextToken()){
                case "push_front" :
                    pushFront(Integer.parseInt(st.nextToken()));
                    break;
                case "push_back" :
                    pushBack(Integer.parseInt(st.nextToken()));
                    break;
                case "pop_front" :
                    popFront();
                    break;
                case "pop_back" :
                    popBack();
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
                default:
                    break;
            }
        }

        System.out.println(sb);
    }

}
