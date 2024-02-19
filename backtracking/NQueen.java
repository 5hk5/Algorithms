package algorithms.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NQueen {
    // N x N 의 체스판에 N개의 퀸들을 서로 공격할 수 없는 위치에 놓는 경우의 수 세기
    // 퀸 => 대각선, 상하좌우에 위치하면 공격 불가

    private static int N;
    private static int[] array; // 퀸 위치 (행 = 인덱스, 열 = 값)
    private static int count; // 퀸들이 서로 공격할 수 없는 위치에 있는 경우의 수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        array = new int[N];

        nQueen(0);

        System.out.println(count);
    }

    private static void nQueen(int row){
        // 마지막 행까지 탐색 완료
        if (row == N) {
            count++;
            return;
        }

        // DFS 탐색
        for (int col=0;col<N;col++){
            array[row] = col; // 좌표 저장

            if (promising(row)){ // 저장된 좌표 탐색 성공 시
                nQueen(row + 1); // 다음 행(depth) 탐색
            }
            // 실패 시 형제노드로 이동 (for문 col++)
        }
    }

    // 다음 depth(행) 탐색
    private static boolean promising(int depth){
        for (int i=0;i<depth;i++){ // 좌표 지정된 퀸들과 비교
            if (array[depth] == array[i]) return false; // 같은 열
            if (Math.abs(depth-i) == Math.abs(array[depth] - array[i])) return false; // 같은 대각선상
        }

        return true;
    }

}
