package algorithms.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RGB {

    //직선 거리에 집 N개 있음 (1~N번)
    //빨강, 초록, 파랑 중 하나로 집 칠해야 함 (양 옆과 다른 색으로)
    //모든 집 칠하는 비용 최솟값 구하기

    //입력값 : 케이스 수 /n 각 집의 RGB당 비용
    //ex)
    //1
    //26 40 83 => 1번집의 R G B 비용
    //출력값 : 최소 비용
    public static int red = 0;
    public static int green = 1;
    public static int blue = 2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); //집 수

        //각 집 배열
        int[][] houses = new int[N][3];
        StringTokenizer st;

        for (int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());

            houses[i][red] = Integer.parseInt(st.nextToken());
            houses[i][green] = Integer.parseInt(st.nextToken());
            houses[i][blue] = Integer.parseInt(st.nextToken());
        }

        //비용 계산 (누적합)
        for (int i=1;i<N;i++){
            houses[i][red] += Math.min(houses[i-1][green],houses[i-1][blue]);
            houses[i][green] += Math.min(houses[i-1][red],houses[i-1][blue]);
            houses[i][blue] += Math.min(houses[i-1][green],houses[i-1][red]);
        }

        //최소 비용 출력
        System.out.println(Math.min(houses[N-1][red], Math.min(houses[N-1][green],houses[N-1][blue])));

    }

}
