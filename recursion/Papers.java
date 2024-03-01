package algorithms.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Papers {

    public static int[][] paper;
    public static int countMinusOne=0;
    public static int countZero=0;
    public static int countOne=0;

    public static void main(String[] args) throws IOException {
        // N*N의 종이 각 칸에 -1, 0, 1 저장됨
        // 종이에 저장된 모든 수가 같은 값이면 그대로 사용 / 아니면 종이를 9분할해 각 부분에 대해 위 과정 반복
        // 입력 1 : N , 입력 2 : N*N의 행렬 직접 입력
        // 출력 : -1, 0, 1로 채워진 종이의 개수 (1줄씩)

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // N=3^k
        paper = new int[N][N];

        StringTokenizer st;
        for (int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for (int j=0;j<N;j++){
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 종이 수 탐색
        searchMatrix(0, 0, N);

        System.out.println(countMinusOne);
        System.out.println(countZero);
        System.out.println(countOne);
    }

    private static void searchMatrix(int row, int col, int size) {
        // 재귀 종료 조건
        if (size == 1){
            countMatrix(row, col);
            return;
        }

        if (checkValue(row, col, size)) { // 모든 값이 같으면 해당값 count++
            countMatrix(row, col);
        } else { // 9분할 탐색 (ex. 27->9->3->1)
            int newSize = size / 3;

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    searchMatrix(row+(i*newSize), col+(j*newSize), newSize);
                }
            }
        }
    }

    private static boolean checkValue(int row, int col, int size){
        int value = paper[row][col];

        for (int i=row;i<row+size;i++){
            for (int j=col;j<col+size;j++){
                if (value != paper[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }

    private static void countMatrix(int row, int col) {
        if (paper[row][col] == -1) {
            countMinusOne++;
        } else if (paper[row][col] == 0){
            countZero++;
        } else if (paper[row][col] == 1){
            countOne++;
        }
    }

}
