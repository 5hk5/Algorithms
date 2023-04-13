package algorithms.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HanoiTower {
    //입력값 : 하노이 탑 원판 개수
    //출력값 1 : 옮긴 횟수
    //출력값 2 : 이동 과정 (1 3 / 1 2 / ..)

    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); //원판 개수

        sb.append((int)Math.pow(2,N)-1).append("\n"); //옮긴 횟수

        Hanoi(N, 1, 2, 3);

        System.out.println(sb);
    }

    public static void Hanoi(int size, int start, int mid, int end){
        if (size==1){
            sb.append(start + " " + end).append("\n");
            return;
        }

        Hanoi(size-1, start, end, mid); //경유지에 size-1개 이동

        sb.append(start + " " + end).append("\n"); //마지막 원판 목표지로

        Hanoi(size-1, mid, start, end); //경유지 -> 목표지로 size-1개 이동
    }

}
