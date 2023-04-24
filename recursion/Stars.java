package algorithms.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import java.util.Scanner;

public class Stars {
    //입력값 : N (3의 거듭제곱)
    //*으로 이뤄진 N*N 정사각형 구현 (가운데 공백)

    public static String[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        arr = new String[N][N];

        //배열 전체에 공백 삽입
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = " ";
            }
        }

        StringBuilder sb = new StringBuilder();

        //별 삽입
        drawStar(N, 0, 0);

        //배열 출력
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(arr[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static void drawStar(int N, int row, int col) { //배열 행/렬 크기, 행인덱스, 열인덱스
        //base condition
        if (N == 1) {
            arr[row][col] = "*";
            return;
        }

        //배열 삼등분해가며 가운데 공백 skip&나머지 별 삽입
        int div = N / 3; //ex. N = 27 -> 9 -> 3 -> 1
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 1 && j == 1) { //가운데 공백 유지
                    continue;
                }

                drawStar(div, row + div*i, col + div*j);
            }
        }
    }
}


