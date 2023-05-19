package algorithms.bfs;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Cabbage {

    //배추 심어진 구역에 익충 배추흰지렁이 하나씩 심기 (각 구역은 상하좌우 1로 연결됨)
    //입력값 1 : 테스트케이스 개수
    //입력값 2 : M N K (M: 구역 가로 길이, N: 구역 세로 길이, K: 배추 좌표 개수)
    //입력값 3 : K개의 배추 좌표 (ex. 1 1)
    //출력값 : 필요한 최소의 배추흰지렁이 수

    static int[][] map;
    static boolean[][] visited;

    static int M, N;

    static int[] nx = {0,0,-1,1};
    static int[] ny = {-1,1,0,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); //테스트케이스 개수

        StringBuilder sb = new StringBuilder();

        //map 배열 초기화
        StringTokenizer st;
        for (int i=0;i<T;i++){
            st = new StringTokenizer(br.readLine());

            M = Integer.parseInt(st.nextToken()); //map 가로
            N = Integer.parseInt(st.nextToken()); //map 세로
            int K = Integer.parseInt(st.nextToken()); //좌표 개수

            map = new int[M][N];
            visited = new boolean[M][N];

            for (int j=0;j<K;j++){
                String[] location = br.readLine().split(" ");
                map[Integer.parseInt(location[0])][Integer.parseInt(location[1])] = 1;
            }

            //map 전체 좌표 탐색
            int count=0; //구역 수
            for (int j=0;j<M;j++){
                for (int k=0;k<N;k++){
                    if (map[j][k]==1 && !visited[j][k]){
                        bfs(j,k);
                        count++;
                    }
                }
            }

            sb.append(count).append("\n");

        }

        System.out.println(sb);

    }

    static void bfs(int x, int y){

        visited[x][y] = true;

        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x,y));

        while (!queue.isEmpty()){
            Point point = queue.poll();

            for (int i=0;i<4;i++){
                int xx = nx[i] + point.x;
                int yy = ny[i] + point.y;

                if (xx>=0 && yy>=0 && xx<M && yy<N){
                    if (!visited[xx][yy] && map[xx][yy]==1){
                        visited[xx][yy]=true;
                        queue.offer(new Point(xx,yy));
                    }
                }
            }
        }

    }

}
