package algorithms.dataStructure.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Stack {

    //입력값 1 : 명령 수
    //입력값 2 : 명령들
    /*
    push X - 스택에 X 저장 (X는 정수)
    pop - 스택 가장 위 정수 삭제 후 출력, 없으면 -1 출력
    size - 스택 원소 개수 출력
    empty - 스택 비어 있으면 1, 아니면 0 출력
    top - 스택 가장 위 정수 출력, 없으면 -1 출력
    */

    public static int[] numbers; //정수 배열 (스택으로 가정)
    public static int count; //스택에 저장된 원소 개수

    public static void push(int X){
        numbers[count]=X;
        count++; //스택 원소 저장할 때마다 증가
    }

    public static int pop(){
        if (count==0){ //스택에 원소 없으면
            return -1;
        }

        int temp = numbers[count-1]; //변수에 가장 최근에 저장된 값 저장
        numbers[count-1]=0; //가장 최근에 저장된 값 삭제 (0 대입)
        count--; //원소 개수 감소

        return temp;
    }

    public static int size(){
        return count;
    }

    public static int empty(){
        if (count==0){
            return 1;
        } else {
            return 0;
        }
    }

    public static int top(){
        if (count==0){
            return -1;
        }
        return numbers[count-1];
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); //명령 수

        numbers = new int[N];

        for (int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            switch (st.nextToken()){
                case "push" :
                    push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop" :
                    System.out.println(pop());
                    break;
                case "size" :
                    System.out.println(size());
                    break;
                case "empty" :
                    System.out.println(empty());
                    break;
                case "top" :
                    System.out.println(top());
                    break;
            }
        }

    }

}
